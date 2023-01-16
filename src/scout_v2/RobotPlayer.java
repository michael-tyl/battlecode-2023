package scout_v2;

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
                int y = getRange(0, 11, 4 + cur);
                if(y == 0) break;
                if(y == x) return;
                cur++;
                if(cur == wellCap) break;
            }
            if(cur == wellCap) return;
            setRange(0, 11, 4 + cur, x);
            if(v.getResourceType() == ResourceType.ADAMANTIUM) setRange(12, 13, 4 + cur, 1);
            else if(v.getResourceType() == ResourceType.MANA) setRange(12, 13, 4 + cur, 2);
            else if(v.getResourceType() == ResourceType.ELIXIR) setRange(12, 13, 4 + cur, 3);
        }

        //Checks if a well exists in the data
        boolean wellExists(WellInfo v) throws GameActionException {
            int cur = 0;
            int x = v.getMapLocation().x*60 + v.getMapLocation().y + 1;
            while(true){
                int y = getRange(0, 11, 4 + cur);
                if(y == 0) break;
                if(y == x) return true;
                cur++;
                if(cur == wellCap) break;
            }
            return false;
        }

        //Gets the job of the robot at spawn
        int getJob() throws GameActionException {
            for(int i = 2; i <= 9; i++){
                if(rc.canSenseRobot(i) && rc.senseRobot(i).getTeam() == rc.getTeam()){
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

    static void runHeadquarters(RobotController rc) throws GameActionException {
        int myId = rc.getID()/2 - 1;
        WellInfo wells[] = rc.senseNearbyWells();
        for(int i = 0; i < wells.length; i++){
            comms.addWell(wells[i]);
        }
        comms.setPos(myId, rc.getLocation());
        int miners = 24;
        int scouts = 8;
        int scoutCooldown = 0;
        int cur = 2;
        while(true){
            try {
                if(scouts > 0 && scoutCooldown == 0){
                    MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                    if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                        comms.addJob(myId, 1);
                        rc.buildRobot(RobotType.CARRIER, newLoc);
                        scouts--;
                        scoutCooldown = 200;
                    }
                }
                if(scoutCooldown > 0) scoutCooldown--;
                // if(miners > 0){
                //     MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                //     if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                //         comms.addJob(myId, cur);
                //         if(cur == 2) cur = 3;
                //         else cur = 2;
                //         rc.buildRobot(RobotType.CARRIER, newLoc);
                //         miners--;
                //     }
                // } 
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
        if(job == 1){ //Scout
            ScoutCarrier carrier = new ScoutCarrier(rc);
            carrier.run();
        } else if(job == 2){ //Resource collector adamantium
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.ADAMANTIUM);
        } else if(job == 3){ //Resource collector mana
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.MANA);
        } else if(job == 4){ //Resource collector elixir
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.ELIXIR);
        }
    }

    //move() - does one move of pathfinding
    private static class Pathfinding {

        Direction movingDirection;
        boolean trackingObstacle;
        boolean traversingClockwise;
        RobotController rc;
        MapLocation target;

        Pathfinding(RobotController rc_){
            rc = rc_;
            movingDirection = Direction.CENTER;
            trackingObstacle = false;
            traversingClockwise = false;
            target = rc.getLocation();
        }

        static boolean checkAcrossWall(MapLocation position, Direction wallDirection, MapLocation tar) {
            switch (wallDirection) {
            case NORTH:
                return position.y < tar.y;
            case EAST:
                return position.x < tar.x;
            case SOUTH:
                return position.y > tar.y;
            case WEST:
                return position.x > tar.x;
            }
            return false;
        }

        void move() throws GameActionException {
            if(!rc.isMovementReady()) return;
            if(rc.getLocation().equals(target)) return;
            MapLocation currentPosition = rc.getLocation();
            if(trackingObstacle){ // if the robot is tracking an obstacle...
                if(traversingClockwise){ // if going around the obstacle clockwise...
                    if(rc.canMove(movingDirection.rotateRight())){ // if we can turn the corner around the obstacle...
                        rc.move(movingDirection.rotateRight()); 
                        if(checkAcrossWall(currentPosition, movingDirection.opposite(), target)){ // if after turning corner we still need to track wall...
                            movingDirection = movingDirection.rotateRight().rotateRight();
                        } else { // if after turning corner we no longer need to track wall...
                            trackingObstacle = false;
                            movingDirection = Direction.CENTER;
                        }
                    } else { // if we can't turn the corner
                        Direction newMovingDirection = movingDirection; 
                        // find mininmum number of turns to get to a square we can go on
                        // if the robot is surrounded, commit suicide to avoid gridlock?
                        for (int i = 0;; i++) {
                            if(rc.canMove(movingDirection)){
                                rc.move(movingDirection);
                                movingDirection = newMovingDirection;
                                break;
                            }
                            movingDirection = movingDirection.rotateLeft();
                            if(i%2 == 1){
                                newMovingDirection = movingDirection;
                            }
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
                            if(i % 2 == 1){
                                newMovingDirection = movingDirection;
                            }
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
                if(optimalSquareInfo.isPassable() && blockingRobot == null){
                    Direction optimalSquareCurrentDirection = optimalSquareInfo.getCurrentDirection();
                    if(optimalSquareCurrentDirection == Direction.CENTER){
                        rc.move(optimalDirection);
                        hasMoved = true;
                    } else if (optimalSquareCurrentDirection == optimalDirection || 
                            optimalSquareCurrentDirection == optimalDirection.rotateRight() ||
                            optimalSquareCurrentDirection == optimalDirection.rotateLeft()){
                        rc.move(optimalDirection);
                        hasMoved = true;
                    }
                } 
                if(!hasMoved){
                    if(blockingRobot != null){ // if robot, wait or pathfind around
                        if(rc.canMove(optimalDirection.rotateLeft())){
                            rc.move(optimalDirection.rotateLeft());
                            hasMoved = true;
                        } else if (rc.canMove(optimalDirection.rotateRight())){
                            rc.move(optimalDirection.rotateRight());
                            hasMoved = true;
                        } else if(rc.getType() == RobotType.CARRIER){
                            if(rc.canMove(optimalDirection.rotateLeft().rotateLeft())){
                                rc.move(optimalDirection.rotateLeft().rotateLeft());
                                hasMoved = true;
                            } else if (rc.canMove(optimalDirection.rotateRight().rotateRight())){
                                rc.move(optimalDirection.rotateRight().rotateRight());
                                hasMoved = true;
                            }
                        }
                    } else {
                        Direction optimalCardinalDirection;
                        if (optimalDirection.getDeltaX() != 0 && optimalDirection.getDeltaY() != 0){
                            if(rng.nextBoolean()){
                                optimalCardinalDirection = optimalDirection.rotateLeft();
                            } else {
                                optimalCardinalDirection = optimalDirection.rotateRight();
                            }
                        } else {
                            optimalCardinalDirection = optimalDirection;
                        }
                        trackingObstacle = true;
                        if(rng.nextBoolean()){
                            movingDirection = optimalCardinalDirection.rotateLeft().rotateLeft();
                            traversingClockwise = true;
                        } else {
                            movingDirection = optimalCardinalDirection.rotateRight().rotateRight();
                            traversingClockwise = false;
                        }
                    }
                }
            }
        }
    }

    private static class ResourceCarrier extends Pathfinding {

        MapLocation wells[]; //well positions
        ResourceType wellTypes[]; //well types for each position
        MapLocation hqs[]; //hq positions
        int prvWellVis[]; //previous turn checked well
        int prvHqVis[];
        boolean collecting; //collecting from well
        boolean foundWell; //found the well
        boolean foundHome; //found the base
        boolean goingHome; //going home
        int targetWellId; //target well id
        int targetHqId; //target hq id
        int turnCount;
    

        void updateData() throws GameActionException{
            wells = comms.getWells();
            wellTypes = comms.getWellTypes();
            int tmp[] = prvWellVis;
            prvWellVis = new int[wells.length];
            for(int i = 0; i < tmp.length; i++) prvWellVis[i] = tmp[i];
        }

        int closestWell(ResourceType tarResource) throws GameActionException{
            int ret = -1;
            for(int i = 0; i < wells.length; i++){
                if(prvWellVis[i] == 0 || prvWellVis[i] + 20 <= turnCount){
                    if(wellTypes[i] == tarResource){
                        if(ret == -1){
                            ret = i;
                        } else if(rc.getLocation().distanceSquaredTo(wells[i]) 
                                < rc.getLocation().distanceSquaredTo(wells[ret])){
                            ret = i;
                        }
                    }
                }
            }
            if(ret == -1){
                for(int i = 0; i < wells.length; i++){
                    if(prvWellVis[i] == 0 || prvWellVis[i] + 20 <= turnCount){
                        if(ret == -1){
                            ret = i;
                        } else if(rc.getLocation().distanceSquaredTo(wells[i]) < rc.getLocation().distanceSquaredTo(target)){
                            ret = i;
                        }
                    }
                }
            }
            return ret;
        }

        int closestHq() throws GameActionException{
            int ret = -1;
            int dist = 2000;
            for(int i = 0; i < hqs.length; i++){
                if(ret == -1){
                    ret = i;
                    dist = Math.min(5, turnCount - prvHqVis[i]);
                } else if(Math.min(5, turnCount - prvHqVis[i]) < dist){
                    ret = i;
                    dist = Math.min(5, turnCount - prvHqVis[i]);
                } else if(Math.min(5, turnCount - prvHqVis[i]) == dist 
                    && rc.getLocation().distanceSquaredTo(hqs[i]) < rc.getLocation().distanceSquaredTo(hqs[ret])){ 
                    ret = i;
                    dist = Math.min(5, turnCount - prvHqVis[i]);
                }
            } 
            return ret;
        }

        ResourceCarrier(RobotController rc_) throws GameActionException{
            super(rc_);
            prvWellVis = new int[0];
            updateData();
            hqs = comms.getHqs();
            prvHqVis = new int[hqs.length];
            collecting = false;
            foundWell = false;
            goingHome = false;
            foundHome = false;
            turnCount = 0;
        }

        MapLocation closestAdjacent(MapLocation tar) throws GameActionException{
            if(rc.getLocation().isAdjacentTo(tar)) return rc.getLocation();
            MapLocation ret = null;
            for(int i = 0; i < 8; i++){
                MapLocation loc = tar.add(directions[i]);
                if(rc.canSenseLocation(loc) && 
                        !rc.canSenseRobotAtLocation(loc) && rc.senseMapInfo(loc).isPassable()){
                    if(ret == null){
                        ret = loc;
                    } else if(rc.getLocation().distanceSquaredTo(loc) < rc.getLocation().distanceSquaredTo(ret)){
                        ret = loc;
                    }
                }
            }
            return ret;
        }

        void updateTargetWell(ResourceType tarResource) throws GameActionException{
            MapLocation nxtTar = closestAdjacent(wells[targetWellId]);
            if(nxtTar != null){
                foundWell = true;
                target = nxtTar;
            } else {
                foundWell = false;
                prvWellVis[targetWellId] = turnCount;
                updateData();
                int nxtWell = closestWell(tarResource);
                if(nxtWell == -1){
                    rc.disintegrate();
                } else {
                    targetWellId = nxtWell;
                    target = wells[nxtWell];
                }
            }
        }

        void updateTargetHq() throws GameActionException{
            MapLocation nxtTar = closestAdjacent(hqs[targetHqId]);
            if(nxtTar != null){
                foundHome = true;
                target = nxtTar;
            } else {
                foundHome = false;
                prvHqVis[targetHqId] = turnCount;
                updateData();
                targetHqId = closestHq();
                target = hqs[targetHqId];
            }
        }
    
        void run(ResourceType tarResource) throws GameActionException{
            rc.disintegrate();

            if(wells.length == 0) return;
            targetWellId = closestWell(tarResource); 
            targetHqId = closestHq();
            target = wells[targetWellId];
            while(true){
                turnCount += 1;
                try { 
                    if(target == null) rc.setIndicatorString("no target");
                    else rc.setIndicatorString(String.valueOf(target.x) + " " + String.valueOf(target.y));
                    for(int t = 0; t < 2; t++){
                        if(rc.getWeight() >= 5){
                            RobotInfo targets[] = rc.senseNearbyRobots(rc.getType().actionRadiusSquared, rc.getTeam().opponent());
                            RobotInfo lowestId = null;
                            for(int i = 0; i < targets.length; i++){
                                if(targets[i].getType() != RobotType.HEADQUARTERS){
                                    if(lowestId == null) lowestId = targets[i];
                                    else if(targets[i].getID() < lowestId.getID()) lowestId = targets[i];
                                }
                            }
                            if(lowestId != null && rc.canAttack(lowestId.getLocation())){
                                rc.attack(lowestId.getLocation());
                            }
                        }
                        if(collecting){
                            int dif = 39 - rc.getWeight();
                            if(dif == 1){
                                if(rc.canCollectResource(wells[targetWellId], 1)){
                                    rc.collectResource(wells[targetWellId], 1);
                                }
                                continue;
                            } else if(dif > 1){
                                if(rc.canCollectResource(wells[targetWellId], 2)){
                                    rc.collectResource(wells[targetWellId], 2);
                                }
                                continue;
                            } else {
                                collecting = false;
                                foundWell = false;
                                goingHome = true;
                                target = hqs[targetHqId];
                            }
                        }
                        if(!goingHome){
                            if(!foundWell){
                                if(rc.canSenseLocation(target)){
                                    updateTargetWell(tarResource); 
                                }
                            }
                            if(foundWell){
                                if(rc.getLocation().equals(target)){
                                    collecting = true;
                                    break;
                                }
                                if(rc.canSenseLocation(target) && (rc.canSenseRobotAtLocation(target) 
                                        || !rc.senseMapInfo(target).isPassable())){                        
                                    updateTargetWell(tarResource);
                                }   
                            }
                        } else {
                            if(!foundHome){
                                if(rc.canSenseLocation(target)){
                                    updateTargetHq();
                                }
                            }
                            if(foundHome){
                                if(rc.getLocation().equals(target)){
                                    while(rc.getWeight() > 0){
                                        while(!rc.canTransferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, 1) && 
                                            !rc.canTransferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, 1) &&
                                                !rc.canTransferResource(hqs[targetHqId], ResourceType.MANA, 1)){
                                            Clock.yield();
                                        }
                                        if(rc.getResourceAmount(ResourceType.ADAMANTIUM) > 0){
                                            rc.transferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, rc.getResourceAmount(ResourceType.ADAMANTIUM));
                                        } else if(rc.getResourceAmount(ResourceType.MANA) > 0){
                                            rc.transferResource(hqs[targetHqId], ResourceType.MANA, rc.getResourceAmount(ResourceType.MANA));
                                        } else if(rc.getResourceAmount(ResourceType.ELIXIR) > 0){
                                            rc.transferResource(hqs[targetHqId], ResourceType.ELIXIR, rc.getResourceAmount(ResourceType.ELIXIR));
                                        }
                                    }
                                    foundHome = false;
                                    goingHome = false;
                                    targetWellId = closestWell(tarResource);
                                    target = wells[targetWellId];
                                }
                                if(rc.canSenseLocation(target) && (rc.canSenseRobotAtLocation(target) 
                                        || !rc.senseMapInfo(target).isPassable())){                        
                                    updateTargetHq();
                                }
                            }
                        }
                        move();
                    }
                } catch(GameActionException e){
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
    }

    private static class ScoutCarrier extends Pathfinding {

        int mapWidth, mapHeight;
        MapLocation hqs[]; //hq positions
        int targetHqId; //target hq id
        boolean goingHome; //going home
        int turnCount;

        boolean []visArray;

        int closestHq() throws GameActionException{
            int ret = -1;
            for(int i = 0; i < hqs.length; i++){
                if(ret == -1){
                    ret = i;
                } else if(rc.getLocation().distanceSquaredTo(hqs[i]) < rc.getLocation().distanceSquaredTo(hqs[ret])){ 
                    ret = i;
                }
            } 
            return ret;
        }

        ScoutCarrier(RobotController rc_) throws GameActionException{
            super(rc_);
            hqs = comms.getHqs();
            goingHome = false;
            turnCount = 0;
            mapWidth = rc_.getMapWidth();
            mapHeight = rc_.getMapHeight();
            visArray = new boolean[mapWidth * mapHeight];
        }
 
        void run() throws GameActionException{
            targetHqId = closestHq();
            Direction normalDir = Direction.CENTER; 
            RobotInfo[] nearbyRobots = rc.senseNearbyRobots(2, rc.getTeam()); 
            for (int i = 0; i < nearbyRobots.length; i++) {
                if (nearbyRobots[i].getType() == RobotType.HEADQUARTERS && nearbyRobots[i].getTeam() == rc.getTeam()) {
                    normalDir = rc.getLocation().directionTo(nearbyRobots[i].getLocation()).opposite();
                    break;
                }
            }
            WellInfo wells[] = new WellInfo[0];

            int segLength = 1;
            int disLength = 0;
            while(true){
                turnCount += 1;
                try { 
                    if(goingHome){
                        if(rc.canWriteSharedArray(0, 0)){
                            for(int i = 0; i < wells.length; i++){
                                comms.addWell(wells[i]);
                            }
                            ResourceCarrier carrier = new ResourceCarrier(rc);
                            if(rng.nextBoolean()) carrier.run(ResourceType.ADAMANTIUM);
                            else carrier.run(ResourceType.MANA);
                        }
                        move();
                        rc.setIndicatorString("resource scout | " + "going home");
                    } else {
                        for (int i = 0; i < 2; i++) {
                            WellInfo[] nearbyWells = rc.senseNearbyWells();
                            if (nearbyWells.length > 0) {
                                for (int j = 0; j < nearbyWells.length; j++) {
                                    if (!comms.wellExists(nearbyWells[j])) {
                                        wells = nearbyWells;
                                        goingHome = true;
                                        target = hqs[closestHq()];
                                        break;
                                    }
                                }
                                if (goingHome)
                                    continue;
                            }

                            MapLocation myLoc = rc.getLocation();
                            visArray[myLoc.x + mapWidth * myLoc.y] = true;
                            while (true) {
                                if (!rc.canMove(normalDir)) {
                                    normalDir = normalDir.rotateRight();
                                    continue;
                                } 
                                MapLocation newLoc = myLoc.add(normalDir);
                                if (visArray[newLoc.x + newLoc.y * mapWidth]) {
                                    normalDir = normalDir.rotateRight();
                                    continue;
                                }
                                break;
                            }
                            rc.move(normalDir);
                            disLength++;
                            if (disLength >= segLength) {
                                normalDir = normalDir.rotateRight();
                                disLength = 0;
                                segLength++;
                            }
                            rc.setIndicatorString("resource scout | " + normalDir.name() + " | " + disLength + " | " + segLength);
                        }
                    }
                } catch(GameActionException e){
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
    }
}
