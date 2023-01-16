// implements a bot that also places anchors 
// built on top of thomas's half working code :/

// also doesn't work

package anchorplacer_v1;

import battlecode.common.*;

import java.util.*;
import java.math.*;

public strictfp class RobotPlayer {

    static final Random rng = new Random(6147);

    static final Direction[] directions = {
        Direction.NORTH,
        Direction.NORTHEAST,
        Direction.EAST,
        Direction.SOUTHEAST,
        Direction.SOUTH,
        Direction.SOUTHWEST,
        Direction.WEST,
        Direction.NORTHWEST,
    }; 

    static private class Communication {


        int wellCap = 14;
        RobotController rc;

        Communication(RobotController rc_){
            rc = rc_;
        }

        int getRange(int l, int r, int ind) throws GameActionException {
            return (rc.readSharedArray(ind) >> l) & ((1 << (r - l + 1)) - 1);
        }

        void setRange(int l, int r, int ind, int v) throws GameActionException {
            int x = rc.readSharedArray(ind);
            x &= ((1 << 16) - 1) ^ (((1 << (r - l + 1)) - 1) << l);
            x |= v << l;
            rc.writeSharedArray(ind, x);
        }

        //Gets the position stored at ind
        MapLocation getPos(int ind) throws GameActionException{
            int x = getRange(0, 11, ind);
            return new MapLocation((x - 1)/60, (x - 1)%60);
        } 

        //Sets the position stored at ind
        void setPos(int ind, MapLocation v) throws GameActionException{
            rc.writeSharedArray(ind, v.x*60 + v.y + 1);
        } 

        //Returns array of wells stored in the shared data
        MapLocation[] getWells() throws GameActionException {
            int cur = 0;
            while(getRange(0, 11, 4 + cur) > 0) cur++;
            MapLocation ret[] = new MapLocation[cur];
            for(int i = 0; i < cur; i++){
                ret[i] = getPos(4 + i);
            }
            return ret;
        }

        //Returns array of well types stored in the shared data
        //index should correspond with wells from getWells
        ResourceType[] getWellTypes() throws GameActionException {
            int cur = 0;
            while(getRange(0, 11, 4 + cur) > 0) cur++;
            ResourceType ret[] = new ResourceType[cur];
            for(int i = 0; i < cur; i++){
                int t = getRange(12, 13, 4 + i);
                if(t == 1){
                    ret[i] = ResourceType.ADAMANTIUM;
                } else if(t == 2){
                    ret[i] = ResourceType.MANA;
                } else if(t == 3){
                    ret[i] = ResourceType.ELIXIR;
                }
            }
            return ret;
        }

        //Returns array of headquarters stored in the shared data
        MapLocation[] getHqs() throws GameActionException {
            int cur = 0;
            for(int i = 0; i < 4; i++) if(getRange(0, 11, i) > 0) cur++;
            MapLocation ret[] = new MapLocation[cur];
            for(int i = 0; i < cur; i++){
                ret[i] = getPos(i);
            }
            return ret;
        }

        //Adds a well to the shared data
        void addWell(WellInfo v) throws GameActionException {
            int cur = 0;
            int x = v.getMapLocation().x*60 + v.getMapLocation().y + 1;
            while(true){
                int y = getRange(0, 11, cur);
                if(y == 0) break;
                if(y == x) return;
                cur++;
                if(cur == wellCap) break;
            }
            if(cur == wellCap) return;
            setRange(0, 11, 4 + cur, x);
        }

        //Checks if a well exists in the data
        boolean wellExists(WellInfo v) throws GameActionException {
            int cur = 0;
            int x = v.getMapLocation().x*60 + v.getMapLocation().y + 1;
            while(true){
                int y = getRange(0, 11, cur);
                if(y == 0) break;
                if(y == x) return true;
                cur++;
                if(cur == wellCap) break;
            }
            return false;
        }

        //Gets the job of the robot at spawn
        int getJob() throws GameActionException {
            int st = 2;
            if(rc.getTeam() == Team.A) st++;
            for(int i = st; i <= 9; i += 2){
                if(rc.canSenseRobot(i)){
                    int hq = i/2 - 1;
                    int ret = getRange(12, 15, hq);
                    if(ret > 0){
                        setRange(12, 15, hq, getRange(12, 15, wellCap + hq));
                        setRange(12, 15, wellCap + hq, 0);
                        return ret;
                    }
                }
            }
            return -1;
        }

        //Adds a job to hq job queue
        void addJob(int hq, int v) throws GameActionException {
            if(getRange(12, 15, hq) == 0) setRange(12, 15, hq, v);
            else setRange(12, 15, 14 + hq, v);
        }
    }

    static Communication comms;

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        comms = new Communication(rc);
        switch (rc.getType()){
            case HEADQUARTERS: runHeadquarters(rc); break;
            case CARRIER: runCarrier(rc); break;
        }
        return;
    }

    static int dirIndex(Direction dir){
        switch(dir){
            case NORTH: return 0;
            case NORTHEAST: return 1;
            case EAST: return 2;
            case SOUTHEAST: return 3;
            case SOUTH: return 4;
            case SOUTHWEST: return 5;
            case WEST: return 6;
            case NORTHWEST: return 7;
            default: return -1;
        }
    } 

    static void runHeadquarters(RobotController rc) throws GameActionException {
        int myId = rc.getID()/2 - 1;
        WellInfo wells[] = rc.senseNearbyWells();
        for(int i = 0; i < wells.length; i++){
            comms.addWell(wells[i]);
        }
        comms.setPos(myId, rc.getLocation());
        int numScouts = 2;
        while(true){
            try {
                if(numScouts == 0) continue;
                MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                rc.setIndicatorString("Trying to build a carrier");
                if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                    comms.addJob(myId,1);
                    rc.buildRobot(RobotType.CARRIER, newLoc);
                    numScouts--;
                }
            } catch (GameActionException e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } finally {
                Clock.yield();
            }
        }
    }

    static void runCarrier(RobotController rc) throws GameActionException { 
        int job = comms.getJob();
        System.out.println("Job: " + job);
        if(job == 1){ //Scout
            runScout(rc);
        } else if(job == 2){ //Resource collector adamantium
            runResourceCollector(rc, ResourceType.ADAMANTIUM);
        } else if(job == 3){ //Resource collector mana
            runResourceCollector(rc, ResourceType.MANA);
        } else if(job == 4){ //Resource collector elixir
            runResourceCollector(rc, ResourceType.ELIXIR);
        } 
    }

    static void runResourceCollector(RobotController rc, ResourceType tarResource) throws GameActionException{

        MapLocation wells[] = comms.getWells();
        if(wells.length == 0){
            runScout(rc);
            return;
        }
        ResourceType wellTypes[] = comms.getWellTypes();
        MapLocation hqs[] = comms.getHqs();
        boolean trackingObstacle = false;
        Direction movingDirection = Direction.CENTER; 
        boolean traversingClockwise = false;
        MapLocation target = null;
        int targetId = -1;
        //Find closest well of correct resource
        for(int i = 0; i < wells.length; i++){
            if(wellTypes[i] == tarResource){
                if(target == null){
                    target = wells[i];
                    targetId = i;
                } else if(rc.getLocation().distanceSquaredTo(target) > rc.getLocation().distanceSquaredTo(target)){
                    target = wells[i];
                    targetId = i;
                }
            }
        }
        //Find closest well if there are no correct resources
        if(target == null){
            for(int i = 0; i < wells.length; i++){
                if(target == null){
                    target = wells[i]; 
                    targetId = i;
                } else if(rc.getLocation().distanceSquaredTo(target) > rc.getLocation().distanceSquaredTo(target)){
                    target = wells[i];
                    targetId = i;
                }
            }
        }

        // if the carrier ever locates an unclaimed island, it will store the loctation and immediately return to base
        // it will then use global memory to request an anchor, then transport the anchor to the island to claim it
        // optional: store island location in global memory?
        boolean isAnchorCarrier = false;

        boolean collecting = false; //collecting from well
        boolean adjacent = false; //adjacent to well
        int turnCount = 0;
        while(true){
            turnCount += 1;
            try {

                if (isAnchorCarrier) {
                    for (int moves = 0; moves < 2; moves++) {
                        if (!rc.isMovementReady())
                            continue;

                        if (rc.getLocation().equals(target)) {
                            // find island
                        }

                        MapLocation currentPosition = rc.getLocation();
                        System.out.println("currently at position " + currentPosition.toString());
                        rc.setIndicatorString("pathfinding to target location at " + target.toString());

                        if (trackingObstacle) {
                            // if the robot is tracking an obstacle...
                            if (traversingClockwise) {
                                // if going around the obstacle clockwise...
                                System.out.println("tracking obstacle, travelling clockwise, movingDirection = " + movingDirection.name());

                                if (rc.canMove(movingDirection.rotateRight())) {
                                    // if we can turn the corner around the obstacle...
                                    System.out.println("moving around corner");
                                    rc.move(movingDirection.rotateRight()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                        // if after turning corner we still need to track wall...
                                        movingDirection = movingDirection.rotateRight().rotateRight();
                                    } else {
                                        // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else {
                                    // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection;
                                    
                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0;; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }

                                        movingDirection = movingDirection.rotateLeft();
                                        if (i % 2 == 1)
                                            newMovingDirection = movingDirection;
                                    }
                                }
                            } else {
                                // if going around the obstacle counterclocwise...
                                System.out.println("tracking obstacle, travelling counterclockwise, movingDirection = " + movingDirection.name());
                                if (rc.canMove(movingDirection.rotateLeft())) {
                                    // if we can turn the corner around the obstacle...
                                    System.out.println("moving around corner");
                                    rc.move(movingDirection.rotateLeft()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                        // if after turning corner we still need to track walll...
                                        movingDirection = movingDirection.rotateLeft().rotateLeft();
                                    } else {
                                        // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else {
                                    // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection;

                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0;; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }

                                        movingDirection = movingDirection.rotateRight();
                                        if (i % 2 == 1)
                                            newMovingDirection = movingDirection;
                                    }
                                }
                            }
                        } else {
                            // if the robot is not tracking an obstacle...

                            boolean hasMoved = false;
                            Direction optimalDirection = currentPosition.directionTo(target);
                            MapInfo optimalSquareInfo = rc.senseMapInfo(currentPosition.add(optimalDirection));
                            RobotInfo blockingRobot = rc.senseRobotAtLocation(currentPosition.add(optimalDirection));

                            // try to move in most optimal direction
                            // hasMoved - if the robot has already moved in the current turn
                            // 
                            System.out.println("trying to move in direction " + optimalDirection.name());


                            if (optimalSquareInfo.isPassable() && blockingRobot == null) {
                                System.out.println("optimal cell at " + optimalSquareInfo.getMapLocation() + " is passable");
                                Direction optimalSquareCurrentDirection = optimalSquareInfo.getCurrentDirection();
                                if (optimalSquareCurrentDirection == Direction.CENTER) {
                                    System.out.println("optimal cell has no current, moving to optimal cell");
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                } else if (optimalSquareCurrentDirection == optimalDirection || 
                                        optimalSquareCurrentDirection == optimalDirection.rotateRight() ||
                                        optimalSquareCurrentDirection == optimalDirection.rotateLeft()) {
                                    System.out.println("optimal cell has farvorable current, moving to optimal cell");
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                }
                            } 

                            if (!hasMoved) {
                                if (blockingRobot != null) {
                                    // if robot, wait or pathfind around
                                    if (rc.canMove(optimalDirection.rotateLeft())) {
                                        rc.move(optimalDirection.rotateLeft());
                                        hasMoved = true;
                                    } else if (rc.canMove(optimalDirection.rotateRight())) {
                                        rc.move(optimalDirection.rotateRight());
                                        hasMoved = true;
                                    }
                                } else {
                                    Direction optimalCardinalDirection;
                                    if (optimalDirection.getDeltaX() != 0 && optimalDirection.getDeltaY() != 0) {
                                        if (rng.nextBoolean())
                                            optimalCardinalDirection = optimalDirection.rotateLeft();
                                        else
                                            optimalCardinalDirection = optimalDirection.rotateRight();
                                    } else {
                                        optimalCardinalDirection = optimalDirection;
                                    }

                                    trackingObstacle = true;
                                    if (rng.nextBoolean()) {
                                        movingDirection = optimalCardinalDirection.rotateLeft().rotateLeft();
                                        traversingClockwise = true;
                                    } else {
                                        movingDirection = optimalCardinalDirection.rotateRight().rotateRight();
                                        traversingClockwise = false;
                                    }

                                    if (traversingClockwise) {
                                        System.out.println("tracking obstacle, travelling clockwise, movingDirection = " + movingDirection.name());
                                        if (rc.canMove(movingDirection.rotateRight())) {
                                            rc.move(movingDirection.rotateRight()); 
                                            System.out.println("moving around corner");
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                movingDirection = movingDirection.rotateRight().rotateRight();
                                            } else {
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateLeft();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    } else {
                                        System.out.println("tracking obstacle, travelling counterclockwise, movingDirection = " + movingDirection.name());
                                        if (rc.canMove(movingDirection.rotateLeft())) {
                                            rc.move(movingDirection.rotateLeft()); 
                                            System.out.println("moving around corner");
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                System.out.println("next move to target goes through wall, continue tracking");
                                                movingDirection = movingDirection.rotateLeft().rotateLeft();
                                            } else {
                                                System.out.println("next move does not go through wall, stopping tracking");
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateRight();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    RobotInfo targets[] = rc.senseNearbyRobots();
                    if(rc.getWeight() >= 5){
                        for(int i = 0; i < targets.length; i++){
                            if(targets[i].getTeam() != rc.getTeam() && rc.canAttack(targets[i].getLocation())){
                                rc.attack(targets[i].getLocation());
                                break;
                            }
                        }
                    }

                    if(collecting){
                        int dif = 39 - rc.getWeight();
                        rc.setIndicatorString(String.valueOf(dif));
                        if(dif == 1){
                            if(rc.canCollectResource(wells[targetId], 1)){
                                rc.collectResource(wells[targetId], 1);
                            }
                            continue;
                        } else if(dif > 1){
                            if(rc.canCollectResource(wells[targetId], 2)){
                                rc.collectResource(wells[targetId], 2);
                            }
                            continue;
                        } else {
                            collecting = false;
                        }
                    }
                    for(int moves = 0; moves < 2; moves++){
                        if(!rc.isMovementReady()) continue;
                        if(!adjacent){
                            if(rc.canSenseLocation(target)){                        
                                MapLocation nextTarget = null;
                                for(int i = 0; i < 8; i++){
                                    MapLocation loc = target.add(directions[i]);
                                    if(!rc.canSenseRobotAtLocation(loc) || rc.senseMapInfo(loc).isPassable()){
                                        if(nextTarget == null) nextTarget = loc;
                                        else if(rc.getLocation().distanceSquaredTo(loc) < rc.getLocation().distanceSquaredTo(nextTarget)){
                                            nextTarget = loc;
                                        }
                                    }
                                }
                                if(nextTarget != null){
                                    adjacent = true;
                                    target = nextTarget;
                                }
                            }
                        } else {
                            if(rc.getLocation().equals(target)){
                                collecting = true;
                                break;
                            }
                            if(rc.canSenseLocation(target) && (rc.canSenseRobotAtLocation(target) || !rc.senseMapInfo(target).isPassable())){                        
                                MapLocation nextTarget = null;
                                for(int i = 0; i < 8; i++){
                                    MapLocation loc = target.add(directions[i]);
                                    if(!rc.canSenseRobotAtLocation(loc) && rc.senseMapInfo(loc).isPassable()){
                                        if(nextTarget == null) nextTarget = loc;
                                        else if(rc.getLocation().distanceSquaredTo(loc) < rc.getLocation().distanceSquaredTo(nextTarget)){
                                            nextTarget = loc;
                                        }
                                    }
                                }
                                if(nextTarget != null){
                                    adjacent = true;
                                    target = nextTarget;
                                }
                            }   
                        }
                        
                        MapLocation currentPosition = rc.getLocation();
                        if(trackingObstacle){ // if the robot is tracking an obstacle...
                            if (traversingClockwise) { // if going around the obstacle clockwise...
                                if (rc.canMove(movingDirection.rotateRight())){ // if we can turn the corner around the obstacle...
                                    rc.move(movingDirection.rotateRight()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)){ // if after turning corner we still need to track wall...
                                        movingDirection = movingDirection.rotateRight().rotateRight();
                                    } else { // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else { // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection; 
                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0; i < 8; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }
                                        movingDirection = movingDirection.rotateLeft();
                                        if (i % 2 == 1) newMovingDirection = movingDirection;
                                    }
                                }
                            } else { // if going around the obstacle counterclocwise...
                                if (rc.canMove(movingDirection.rotateLeft())){ // if we can turn the corner around the obstacle...
                                    rc.move(movingDirection.rotateLeft()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) { // if after turning corner we still need to track walll...
                                        movingDirection = movingDirection.rotateLeft().rotateLeft();
                                    } else { // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else { // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection;
                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0;; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }
                                        movingDirection = movingDirection.rotateRight();
                                        if (i % 2 == 1) newMovingDirection = movingDirection;
                                    }
                                }
                            }
                        } else { // if the robot is not tracking an obstacle...
                            boolean hasMoved = false;
                            Direction optimalDirection = currentPosition.directionTo(target);
                            MapInfo optimalSquareInfo = rc.senseMapInfo(currentPosition.add(optimalDirection));
                            RobotInfo blockingRobot = rc.senseRobotAtLocation(currentPosition.add(optimalDirection));

                            // try to move in most optimal direction
                            // hasMoved - if the robot has already moved in the current turn
                            if (optimalSquareInfo.isPassable() && blockingRobot == null) {
                                Direction optimalSquareCurrentDirection = optimalSquareInfo.getCurrentDirection();
                                if (optimalSquareCurrentDirection == Direction.CENTER) {
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                } else if (optimalSquareCurrentDirection == optimalDirection || 
                                        optimalSquareCurrentDirection == optimalDirection.rotateRight() ||
                                        optimalSquareCurrentDirection == optimalDirection.rotateLeft()) {
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                }
                            } 

                            if (!hasMoved) {
                                if (blockingRobot != null) { // if robot, wait or pathfind around
                                    if (rc.canMove(optimalDirection.rotateLeft())) {
                                        rc.move(optimalDirection.rotateLeft());
                                        hasMoved = true;
                                    } else if (rc.canMove(optimalDirection.rotateRight())) {
                                        rc.move(optimalDirection.rotateRight());
                                        hasMoved = true;
                                    }
                                } else {
                                    Direction optimalCardinalDirection;
                                    if (optimalDirection.getDeltaX() != 0 && optimalDirection.getDeltaY() != 0) {
                                        if (rng.nextBoolean())
                                            optimalCardinalDirection = optimalDirection.rotateLeft();
                                        else
                                            optimalCardinalDirection = optimalDirection.rotateRight();
                                    } else {
                                        optimalCardinalDirection = optimalDirection;
                                    }

                                    trackingObstacle = true;
                                    if (rng.nextBoolean()) {
                                        movingDirection = optimalCardinalDirection.rotateLeft().rotateLeft();
                                        traversingClockwise = true;
                                    } else {
                                        movingDirection = optimalCardinalDirection.rotateRight().rotateRight();
                                        traversingClockwise = false;
                                    }

                                    if (traversingClockwise) {
                                        if (rc.canMove(movingDirection.rotateRight())) {
                                            rc.move(movingDirection.rotateRight()); 
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                movingDirection = movingDirection.rotateRight().rotateRight();
                                            } else {
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateLeft();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    } else {
                                        if (rc.canMove(movingDirection.rotateLeft())) {
                                            rc.move(movingDirection.rotateLeft()); 
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                movingDirection = movingDirection.rotateLeft().rotateLeft();
                                            } else {
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateRight();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (GameActionException e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } finally {
                Clock.yield();
            }
        }
    }

    static boolean checkAcrossWall(MapLocation position, Direction wallDirection, MapLocation target) {
        switch (wallDirection) {
        case NORTH:
            return position.y < target.y;
        case EAST:
            return position.x < target.x;
        case SOUTH:
            return position.y > target.y;
        case WEST:
            return position.x > target.x;
        }
        return false;
    }
    
    static void runScout(RobotController rc) throws GameActionException {
        boolean movingBack = false; 
        Direction normalDir = Direction.CENTER; 
        WellInfo scoutedWellInfo = null;
        MapLocation hqPosition = null;

        // movingBack - true if moving back to hq, false otherwise
        // normalDir - intended direction of movement
        // scoutedWellInfo - stored information of well

        // initialize normalDir
        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(2, rc.getTeam()); 
        for (int i = 0; i < nearbyRobots.length; i++) {
            if (nearbyRobots[i].getType() == RobotType.HEADQUARTERS) {
                normalDir = rc.getLocation().directionTo(nearbyRobots[i].getLocation()).opposite();
                hqPosition = nearbyRobots[i].getLocation();
                break;
            }
        }
        rc.setIndicatorString(normalDir.name());

        MapLocation target = null;
        boolean trackingObstacle = false;
        Direction movingDirection = Direction.CENTER; 
        boolean traversingClockwise = false;

        while (true) {
            try {
                WellInfo[] nearbyWells = rc.senseNearbyWells();
                for (int i = 0; i < nearbyWells.length; i++) {
                    if (!comms.wellExists(nearbyWells[i])) {
                        scoutedWellInfo = nearbyWells[i];
                        movingBack = true;
                        target = hqPosition;
                        rc.setIndicatorString("found mana well, returning now");
                        break;
                    }
                }
                
                if (movingBack) {
                    // System.out.println("already found well, moving back");
                    for (int moves = 0; moves < 2; moves++) {
                        if (!rc.isMovementReady())
                            continue;

                        if (rc.getLocation().isAdjacentTo(target)) {
                            rc.setIndicatorString("uploaded info to global array");
                            comms.addWell(scoutedWellInfo);
                            if(rng.nextBoolean()) runResourceCollector(rc, ResourceType.ADAMANTIUM);
                            else  runResourceCollector(rc, ResourceType.MANA);
                            break;
                        }

                        MapLocation currentPosition = rc.getLocation();
                        rc.setIndicatorString("pathfinding to target location at " + target.toString());

                        if (trackingObstacle) {
                            // if the robot is tracking an obstacle...
                            if (traversingClockwise) {
                                // if going around the obstacle clockwise...

                                if (rc.canMove(movingDirection.rotateRight())) {
                                    // if we can turn the corner around the obstacle...
                                    rc.move(movingDirection.rotateRight()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                        // if after turning corner we still need to track wall...
                                        movingDirection = movingDirection.rotateRight().rotateRight();
                                    } else {
                                        // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else {
                                    // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection;
                                    
                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0;; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }

                                        movingDirection = movingDirection.rotateLeft();
                                        if (i % 2 == 1)
                                            newMovingDirection = movingDirection;
                                    }
                                }
                            } else {
                                // if going around the obstacle counterclocwise...
                                if (rc.canMove(movingDirection.rotateLeft())) {
                                    // if we can turn the corner around the obstacle...
                                    rc.move(movingDirection.rotateLeft()); 
                                    if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                        // if after turning corner we still need to track walll...
                                        movingDirection = movingDirection.rotateLeft().rotateLeft();
                                    } else {
                                        // if after turning corner we no longer need to track wall...
                                        trackingObstacle = false;
                                        movingDirection = Direction.CENTER;
                                    }
                                } else {
                                    // if we can't turn the corner
                                    Direction newMovingDirection = movingDirection;

                                    // find mininmum number of turns to get to a square we can go on
                                    // if the robot is surrounded, commit suicide to avoid gridlock?
                                    for (int i = 0;; i++) {
                                        if (rc.canMove(movingDirection)) {
                                            rc.move(movingDirection);
                                            movingDirection = newMovingDirection;
                                            break;
                                        }

                                        movingDirection = movingDirection.rotateRight();
                                        if (i % 2 == 1)
                                            newMovingDirection = movingDirection;
                                    }
                                }
                            }
                        } else {
                            // if the robot is not tracking an obstacle...

                            boolean hasMoved = false;
                            Direction optimalDirection = currentPosition.directionTo(target);
                            MapInfo optimalSquareInfo = rc.senseMapInfo(currentPosition.add(optimalDirection));
                            RobotInfo blockingRobot = rc.senseRobotAtLocation(currentPosition.add(optimalDirection));

                            // try to move in most optimal direction
                            // hasMoved - if the robot has already moved in the current turn
                            // 


                            if (optimalSquareInfo.isPassable() && blockingRobot == null) {
                                Direction optimalSquareCurrentDirection = optimalSquareInfo.getCurrentDirection();
                                if (optimalSquareCurrentDirection == Direction.CENTER) {
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                } else if (optimalSquareCurrentDirection == optimalDirection || 
                                        optimalSquareCurrentDirection == optimalDirection.rotateRight() ||
                                        optimalSquareCurrentDirection == optimalDirection.rotateLeft()) {
                                    rc.move(optimalDirection);
                                    hasMoved = true;
                                }
                            } 

                            if (!hasMoved) {
                                if (blockingRobot != null) {
                                    // if robot, wait or pathfind around
                                    if (rc.canMove(optimalDirection.rotateLeft())) {
                                        rc.move(optimalDirection.rotateLeft());
                                        hasMoved = true;
                                    } else if (rc.canMove(optimalDirection.rotateRight())) {
                                        rc.move(optimalDirection.rotateRight());
                                        hasMoved = true;
                                    }
                                } else {
                                    Direction optimalCardinalDirection;
                                    if (optimalDirection.getDeltaX() != 0 && optimalDirection.getDeltaY() != 0) {
                                        if (rng.nextBoolean())
                                            optimalCardinalDirection = optimalDirection.rotateLeft();
                                        else
                                            optimalCardinalDirection = optimalDirection.rotateRight();
                                    } else {
                                        optimalCardinalDirection = optimalDirection;
                                    }

                                    trackingObstacle = true;
                                    if (rng.nextBoolean()) {
                                        movingDirection = optimalCardinalDirection.rotateLeft().rotateLeft();
                                        traversingClockwise = true;
                                    } else {
                                        movingDirection = optimalCardinalDirection.rotateRight().rotateRight();
                                        traversingClockwise = false;
                                    }

                                    if (traversingClockwise) {
                                        if (rc.canMove(movingDirection.rotateRight())) {
                                            rc.move(movingDirection.rotateRight()); 
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                movingDirection = movingDirection.rotateRight().rotateRight();
                                            } else {
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateLeft();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    } else {
                                        if (rc.canMove(movingDirection.rotateLeft())) {
                                            rc.move(movingDirection.rotateLeft()); 
                                            if (checkAcrossWall(currentPosition, movingDirection.opposite(), target)) {
                                                movingDirection = movingDirection.rotateLeft().rotateLeft();
                                            } else {
                                                trackingObstacle = false;
                                                movingDirection = Direction.CENTER;
                                            }
                                        } else {
                                            Direction newMovingDirection = movingDirection;
                                            // hopefully the robot isn't trapped.....
                                            for (int i = 0;; i++) {
                                                if (rc.canMove(movingDirection)) {
                                                    rc.move(movingDirection);
                                                    movingDirection = newMovingDirection;
                                                    break;
                                                }

                                                movingDirection = movingDirection.rotateRight();
                                                if (i % 2 == 1)
                                                    newMovingDirection = movingDirection;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        while (!rc.canMove(normalDir))
                            normalDir = normalDir.rotateRight();
                        rc.move(normalDir);
                        if (rng.nextBoolean())
                            normalDir = normalDir.rotateRight();
                        rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                    }
                }
            } catch (GameActionException e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } finally {
                Clock.yield();
            }
        } 
    }

    static void runAnchorPlacer(RobotController rc) throws GameActionException {

    }
}