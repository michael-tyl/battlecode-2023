package hqrewrite;

import battlecode.common.*;

import java.util.*;

public class AnchorCarrier extends Pathfinding {

    AnchorCarrier(RobotController rc_) throws GameActionException{
        super(rc_);
    }

    void run() throws GameActionException{
        boolean movingBack = false;
        Direction normalDir = Direction.CENTER;                             // direction robot is "trying" to go in
        MapLocation hqPosition = new MapLocation(0, 0);
        MapLocation wellPosition = new MapLocation(0, 0);
        Stack<Direction> moveList = new Stack<Direction>();

        // initialize normalDir
        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(2, rc.getTeam()); 
        for (int i = 0; i < nearbyRobots.length; i++) {
            if (nearbyRobots[i].getType() == RobotType.HEADQUARTERS) {
                normalDir = rc.getLocation().directionTo(nearbyRobots[i].getLocation()).opposite();
                hqPosition = nearbyRobots[i].getLocation();
                break;
            }
        }
        int turnCount = 0;
        while (true) {
            turnCount += 1;
            try {
                MapLocation me = rc.getLocation();
                rc.setIndicatorString(normalDir.name());
                
                if (rc.getWeight() == 0)
                    movingBack = false;
                
                if (movingBack) {
                    while (true) {
                        Direction dir = moveList.peek().opposite();
                        if (!rc.canMove(dir))
                            break;
                        moveList.pop();
                        rc.move(dir);
                        rc.setIndicatorString("moving back");
                    }
                } else {
                    if (rc.canPlaceAnchor()) {
                        rc.placeAnchor();
                        movingBack = true;
                    } else {
                        int[] islands = rc.senseNearbyIslands();

                        int curid = 0;
                        for(; curid < islands.length; curid++) {
                            if(rc.senseTeamOccupyingIsland(islands[curid]) == Team.NEUTRAL)
                                break;
                        }

                        if (curid < islands.length) {
                            int idx = islands[curid];
                            MapLocation[] goIsland = rc.senseNearbyIslandLocations(idx);
                            MapLocation goToLoc = goIsland[curid];

                            normalDir = me.directionTo(goToLoc);

                            if (rc.canMove(normalDir)) {
                                rc.move(normalDir);
                                moveList.push(normalDir);
                                rc.setIndicatorString("move towards island");
                            } else {
                                int lim = 0;
                                while (!rc.canMove(normalDir) && lim < 8) {
                                    normalDir = normalDir.rotateRight();
                                    lim++;
                                }
                                
                                if (rc.canMove(normalDir)) {
                                    rc.move(normalDir);
                                    moveList.push(normalDir);
                                    rc.setIndicatorString(normalDir.name() + " | move in normal direction");

                                }
                            }
                        } else {
                            int lim = 0;
                            while (!rc.canMove(normalDir) && lim < 8) {
                                normalDir = normalDir.rotateRight();
                                lim++;
                            }
                            if (rc.canMove(normalDir)) {
                                rc.move(normalDir);
                                moveList.push(normalDir);
                                rc.setIndicatorString(normalDir.name() + " | move in normal direction");

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