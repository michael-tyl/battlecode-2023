package heuristic_miner;


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

    static private class Comms {

        static final int wellCap = 13;

        //Sets the position stored at ind to v
        static void setPos(RobotController rc, int ind, int v) throws GameActionException{
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, ((x >> 11) << 11) + v);
        }

        //Gets the position stored at ind
        static int getPos(RobotController rc, int ind) throws GameActionException{
            int x = rc.readSharedArray(ind);
            return x & ((1 << 12) - 1);
        }

        //Hashes (x, y) into an int
        static int hashPos(int x, int y){
            return x*60 + y + 1;
        } 

        //Sets the job stored at ind to v [0, 15]
        static void setJob(RobotController rc, int ind, int v) throws GameActionException {
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, (x & ((1 << 12) - 1)) + (v << 12));
        }

        //Returns array of wells stored in the shared data
        static MapLocation[] getWells(RobotController rc) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0) cur++;
            MapLocation ret[] = new MapLocation[cur];
            for(int i = 0; i < cur; i++){
                int x = getPos(rc, 4 + cur);
                ret[i] = new MapLocation((x - 1)/60, (x - 1)%60);
            }
            return ret;
        }

        //Returns array of headquarters stored in the shared data
        static MapLocation[] getHqs(RobotController rc) throws GameActionException {
            int cur = 0;
            for(int i = 0; i < 4; i++) if(getPos(rc, i) > 0) cur++;
            MapLocation ret[] = new MapLocation[cur];
            cur = 0;
            for(int i = 0; i < 4; i++){
                int x = getPos(rc, i);
                if(x > 0){
                    ret[cur++] = new MapLocation((x - 1)/60, (x - 1)%60);
                }
            }
            return ret;
        }

        //Adds a well to the shared data
        static void addWell(RobotController rc, int v) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0){
                if(getPos(rc, 4 + cur) == v) return;
                cur++;
            }
            if(cur == wellCap) return;
            setPos(rc, cur, v);
        }

        //Checks if a well exists in the data
        static boolean wellExists(RobotController rc, int v) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0){
                if(getPos(rc, 4 + cur) == v) return true;
                cur++;
            }
            return false;
        }

        //Gets the job of the robot at spawn
        static int getJob(RobotController rc) throws GameActionException {
            int ret = -1; 
            int ind = -1;
            for(int i = 2; i <= 9; i++){
                if(rc.canSenseRobot(i)){
                    int x = rc.readSharedArray(i/2 - 1);
                    if((x >> 12) > 0){
                        ret = x >> 12;
                        ind = i;
                    }
                }
            }
            if(ind != -1) setJob(rc, ind/2 - 1, 0);
            return ret;
        }

        //Check if a headquarters can spawn a bot without overriding current job
        static boolean canSpawn(RobotController rc, int ind) throws GameActionException {
            int x = rc.readSharedArray(ind);
            return (x >> 12) == 0;
        }
    }

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {

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
        int myX = rc.getLocation().x, myY = rc.getLocation().y;
        WellInfo wells[] = rc.senseNearbyWells();
        for(int i = 0; i < wells.length; i++){
            MapLocation loc = wells[i].getMapLocation();
            Comms.addWell(rc, Comms.hashPos(loc.x, loc.y));
        }
        Comms.setPos(rc, myId, Comms.hashPos(myX, myY));
        int numScouts = 2;
        while(true){
            try {
                if(numScouts == 0) continue;
                MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                rc.setIndicatorString("Trying to build a carrier");
                if(rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc) && Comms.canSpawn(rc, myId)) {
                    Comms.setJob(rc, myId, 1);
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
        int job = Comms.getJob(rc);
        System.out.println("Job: " + job);
        if(job == 1){ //Scout
            runScout(rc);
        } else if(job == 2){ //Resource collector
            runResourceCollector(rc);
        } 
    }

    static void runResourceCollector(RobotController rc) throws GameActionException{
        MapLocation wells[] = Comms.getWells(rc);
        MapLocation hqs[] = Comms.getHqs(rc);
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
        boolean isScout = true;

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
                if (isScout) {
                    WellInfo[] nearbyWells = rc.senseNearbyWells();
                    for (int i = 0; i < nearbyWells.length; i++) {
                        MapLocation loc = nearbyWells[i].getMapLocation();
                        if (!Comms.wellExists(rc, Comms.hashPos(loc.x, loc.y))) {
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
                                MapLocation wellPosition = scoutedWellInfo.getMapLocation();
                                Comms.addWell(rc, Comms.hashPos(wellPosition.x, wellPosition.y));
                                break;
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
                        for (int i = 0; i < 2; i++) {
                            while (!rc.canMove(normalDir))
                                normalDir = normalDir.rotateRight();
                            rc.move(normalDir);
                            if (rng.nextBoolean())
                                normalDir = normalDir.rotateRight();
                            rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                        }
                    }
                } else {
                    break;
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
        runResourceCollector(rc);
    }
}