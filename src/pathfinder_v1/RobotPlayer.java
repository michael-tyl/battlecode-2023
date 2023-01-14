// demo robot for pathfinder method with carriers

package pathfinder_v1;

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

    static int turnCount = 0;

    static final Random rng = new Random(61474);

    /** Array containing all the possible movement directions. */
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
        System.out.println("I'm a " + rc.getType() + " and I just got created! I have health " + rc.getHealth());

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
                if (numSpawned >= 1)
                    continue;
                Direction dir = directions[rng.nextInt(directions.length)];
                MapLocation newLoc = rc.getLocation().add(dir);
                if (rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                    numSpawned++;
                    rc.buildRobot(RobotType.CARRIER, newLoc);
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
        boolean pause = true; 
        MapLocation target = null;
        boolean trackingObstacle = false;
        Direction movingDirection = Direction.CENTER; 
        boolean traversingClockwise = false;

        // pause - testing variable
        // target - intended final square (make sure its not in a wall or a current)
        // trackingObstacle - if the robot is currently maneuvering around an obstacle
        // movingDirection - direction in which the robot is moving around an obstacle
        // traversingClockwise - whiether the robot is going clockwise or counterclockwise

        while (true) {
            turnCount += 1;
            try {
                // NOTE: Only moves once per turn, may need modifications for optimal performance on carriers
                for (int moves = 0; moves < 2; moves++) {
                    if (!rc.isMovementReady())
                        continue;

                    if (pause) {
                        target = new MapLocation(rng.nextInt(rc.getMapWidth()), rng.nextInt(rc.getMapHeight()));            
                        pause = false;
                    } else if (rc.getLocation().isAdjacentTo(target)) {
                        rc.setIndicatorString("reached target locaton at " + target.toString());
                        pause = true;
                        continue;
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
