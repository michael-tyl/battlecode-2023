package scout_v1;

import battlecode.common.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public strictfp class RobotPlayer {
    static private class Comms {
        static final int wellCap = 13;

        //Sets the position stored at ind to v
        static void setPos(RobotController rc, int ind, int v) throws GameActionException{
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, (x & ((1 << 16) - 1) ^ ((1 << 12) - 1)) + v);
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

        //Gets the job stored at ind
        static int getJob(RobotController rc, int ind) throws GameActionException {
            int x = rc.readSharedArray(ind);
            return x >> 12;
        }

        //Sets the job stored at ind to v [0, 15]
        static void setJob(RobotController rc, int ind, int v) throws GameActionException {
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, (x & ((1 << 12) - 1)) + (v << 11));
        }

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

        static void addWell(RobotController rc, int v) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0){
                if(getPos(rc, 4 + cur) == v) return;
                cur++;
            }
            if(cur == 13) return;
            setPos(rc, cur, v);
        }
    }

    static int turnCount = 0;

    static final int MAX_CAPACITY = 40; // capcity of carriers

    static final int FARMING_ROUND_LENGTH = 100; // first 100 rounds are used for farming

    static final int SPRAY_MODE_ROUND = 10; // first 10 rounds spray carriers

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

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        switch (rc.getType()) {
        case HEADQUARTERS: runHeadquarters(rc); break;
        case CARRIER: runCarrier(rc); break;
        default: break;
        }
    }

    
    static void runHeadquarters(RobotController rc) throws GameActionException {
        int numSpawned = 0;
        while (true) {
            turnCount += 1;
            try {
                if (numSpawned >= 2)
                    continue;
                MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                rc.setIndicatorString("Trying to build a carrier");
                if (rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                    rc.buildRobot(RobotType.CARRIER, newLoc);
                    numSpawned++;
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

    
    static void runCarrier(RobotController rc) throws GameActionException {
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
            turnCount += 1;
            try {
                if (isScout) {
                    WellInfo[] nearbyWells = rc.senseNearbyWells();
                    for (int i = 0; i < nearbyWells.length; i++) {
                        if (nearbyWells[i].getResourceType() != ResourceType.ADAMANTIUM ) {
                            scoutedWellInfo = nearbyWells[i];
                            movingBack = true;
                            target = hqPosition;
                            System.out.println("found mana well, returning now");
                            break;
                        }
                    }
                    
                    if (movingBack) {
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
                    // resource collection suff
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
}
