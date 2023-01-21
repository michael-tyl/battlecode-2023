package sojourner;

import battlecode.common.*;
import java.util.*;

public strictfp class RobotPlayer {
    static final Random rng = new Random(61474);

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

    static void runCarrier(RobotController rc) throws GameActionException {
        boolean pause = true; 
        MapLocation target = null;
        Pathfinder pathfinder = new Pathfinder();
        pathfinder.init(rc);

        while (true) {
            try {
                MapLocation currentLocation = rc.getLocation();
                if (target == null || currentLocation.isAdjacentTo(target)) {
                    if (pause) {
                        target = new MapLocation(rng.nextInt(rc.getMapWidth()), rng.nextInt(rc.getMapHeight()));
                        pause = false;
                    } else {
                        rc.setIndicatorString("reached target locaton at " + target.toString());
                        pause = true;
                    }
                } else {
                    Direction optDirection = pathfinder.getBestDirectionOneMove(target);
                    if (optDirection == null) {
                        rc.setIndicatorString("target = " + target.toString() + "| robot movement cooldown active");
                    } else if (rc.canMove(optDirection)) {
                        rc.setIndicatorString("optimal direction = " + optDirection.name() + " | success");
                        rc.move(optDirection);
                    } else {
                        rc.setIndicatorString("optimal direction = " + optDirection.name() + " | failed");
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