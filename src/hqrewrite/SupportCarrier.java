package hqrewrite;

import battlecode.common.*;

import java.util.*;

public class SupportCarrier extends Pathfinding {
    public static final Direction[] directions = {
        Direction.NORTH,
        Direction.NORTHEAST,
        Direction.EAST,
        Direction.SOUTHEAST,
        Direction.SOUTH,
        Direction.SOUTHWEST,
        Direction.WEST,
        Direction.NORTHWEST,
    }; 
    int turnCount;
    // Launchers don't move until in large enough group
    boolean active;
    int moveCount;

    public SupportCarrier(RobotController rc_) throws GameActionException{
        super(rc_);
        moveCount = 0;
        turnCount = 0;
        active = true;
    }
    void run() throws GameActionException {
        // This is broken but somehow makes the bot better?
        MapLocation curLoc = rc.getLocation();
        while (true) {
            try {
                RobotInfo[] friendlies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam());
                rc.setIndicatorString("Support carrier!");
                
                // Leave null for now
                Direction dir = null;


                for (int i = 0; i < friendlies.length; i++) {
                    if (friendlies[i].getType() == RobotType.LAUNCHER) {
                        dir = curLoc.directionTo(friendlies[i].getLocation());
                        rc.setIndicatorString("Moving towards lancher");
                        break;
                    }
                }

                // Try moving towards enemy HQ
                if (dir == null) {
                    // dir = curLoc.directionTo(enemyHQ);
                    int i = 0;
                    while (!rc.canMove(dir) && i < 20) {
                        dir = directions[rng.nextInt(directions.length)];
                        i++;
                    }
                    // rc.setIndicatorString("Moving towards enemy HQ at " + enemyHQ.x + "," + enemyHQ.y);
                }

                if (rc.canMove(dir)) {
                    rc.move(dir);
                    moveCount++;
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
