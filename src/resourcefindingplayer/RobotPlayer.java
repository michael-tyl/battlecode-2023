package resourcefindingplayer;

import battlecode.common.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public strictfp class RobotPlayer {
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

        // Hello world! Standard output is very useful for debugging.
        // Everything you say here will be directly viewable in your terminal when you run a match!
        System.out.println("I'm a " + rc.getType() + " and I just got created! I have health " + rc.getHealth());

        // You can also use indicators to save debug notes in replays.
        switch (rc.getType()) {
        case HEADQUARTERS: runHeadquarters(rc); break;
        case CARRIER: runCarrier(rc); break;
        case LAUNCHER: runLauncher(rc); break;
        default: break;
        }
    }

    
    static void runHeadquarters(RobotController rc) throws GameActionException {
        Direction dir = directions[rng.nextInt(directions.length)];
        while (true) {
            turnCount += 1;
            try {
                MapLocation newLoc = rc.getLocation().add(dir);
                int round = rc.getRoundNum();
                if (round < SPRAY_MODE_ROUND)
                    dir = dir.rotateRight().rotateRight();
                else
                    dir = dir.rotateRight();
                if (true || round < FARMING_ROUND_LENGTH || rng.nextBoolean()) {
                    rc.setIndicatorString("Trying to build a carrier");
                    if (rc.canBuildRobot(RobotType.CARRIER, newLoc)) 
                        rc.buildRobot(RobotType.CARRIER, newLoc);
                } else {
                    rc.setIndicatorString("Trying to build a laucher");
                    if (rc.canBuildRobot(RobotType.LAUNCHER, newLoc)) 
                        rc.buildRobot(RobotType.LAUNCHER, newLoc);
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
        boolean movingBack = false;                                         // finished harvesting, returning to hq
        Stack<Direction> moveList = new Stack<Direction>();         // list of directions
        Direction normalDir = Direction.CENTER;                             // direction robot is "trying" to go in
        MapLocation hqPosition = new MapLocation(0, 0);

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

        while (true) {
            turnCount += 1;
            try {
                boolean willMove = true;

                // Deposit if possible
                // TODO: make this handle case where robot carries more than one type of resource
                if (rc.canTransferResource(hqPosition, ResourceType.MANA, MAX_CAPACITY)) { 
                    rc.transferResource(hqPosition, ResourceType.MANA, MAX_CAPACITY);
                    rc.setIndicatorString("Depositing, now have, AD:" + 
                        rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                        " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                        " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                    willMove = false;
                    moveList.clear();
                }
                // TODO: make this handle case where robot carries more than one type of resource
                if (rc.canTransferResource(hqPosition, ResourceType.ADAMANTIUM, MAX_CAPACITY)) {
                    rc.transferResource(hqPosition, ResourceType.ADAMANTIUM , MAX_CAPACITY);
                    rc.setIndicatorString("Depositing, now have, AD:" + 
                        rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                        " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                        " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                    willMove = false;
                    moveList.clear();
                }

                if (rc.getWeight() == MAX_CAPACITY)
                    movingBack = true;

                MapLocation me = rc.getLocation();
                // Harvest if possible
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        MapLocation wellLocation = new MapLocation(me.x + dx, me.y + dy);
                        if (rc.canCollectResource(wellLocation, -1)) {
                            rc.collectResource(wellLocation, -1);
                            rc.setIndicatorString("Collecting, now have, AD:" + 
                                rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                                " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                                " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                            willMove = false;
                        }
                    }
                }

                if (rc.getWeight() == 0)
                    movingBack = false;
                
                if (willMove) {
                    if (movingBack) {
                        Direction dir = moveList.peek().opposite();
                        if (rc.canMove(dir)) {
                            moveList.pop();
                            rc.move(dir);
                            rc.setIndicatorString("moving back");
                        } else {
                            rc.setIndicatorString("unable to move back");
                        }
                    } else {
                        // Attempt to move towards well
                        WellInfo[] wells = rc.senseNearbyWells();
                        if (wells.length >= 1) {
                            WellInfo well = wells[0];
                            normalDir = me.directionTo(well.getMapLocation());
                            if (rc.canMove(normalDir)) {
                                rc.move(normalDir);
                                moveList.push(normalDir);
                                rc.setIndicatorString("move towards well");
                            } else {
                                RobotInfo blocker = rc.senseRobotAtLocation(me.add(normalDir));
                                if (blocker != null) {
                                    while (!rc.canMove(normalDir))
                                        normalDir = normalDir.rotateRight();
                                    rc.move(normalDir);
                                    moveList.push(normalDir);
                                    rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                                } else {
                                    rc.disintegrate();
                                }
                            }
                        } else {
                            while (!rc.canMove(normalDir))
                                normalDir = normalDir.rotateRight();
                            rc.move(normalDir);
                            moveList.push(normalDir);
                            rc.setIndicatorString(normalDir.name() + " | move in normal direction");
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

    static void runLauncher(RobotController rc) throws GameActionException {
        // Try to attack someone
        rc.setIndicatorString("shit");        
        while (true) {
            turnCount += 1;
            try {
                rc.setIndicatorString("fuck");        
                int radius = rc.getType().actionRadiusSquared;
                Team opponent = rc.getTeam().opponent();
                RobotInfo[] enemies = rc.senseNearbyRobots(radius, opponent);
                if (enemies.length >= 1) {
                    MapLocation toAttack = enemies[0].location;
                    rc.setIndicatorString("trying to attack" + toAttack.toString());
                    if (rc.canAttack(toAttack)) {  
                        rc.setIndicatorString("Attacking");
                        rc.attack(toAttack);
                    }
                }

                // Also try to move randomly.
                Direction dir = directions[rng.nextInt(directions.length)];
                rc.setIndicatorString("trying to move in direction: " + dir.name());
                if (rc.canMove(dir)) {
                    rc.move(dir);
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
