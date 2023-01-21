package hqrewrite;

import battlecode.common.*;

import java.util.*;
import java.math.*;

public class Pathfinding {

    Direction movingDirection;
    boolean trackingObstacle;
    boolean traversingClockwise;
    RobotController rc;
    MapLocation target;
    static final Random rng = new Random(6151);

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
