package cc_v0_4_4;

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

/**
 * RobotPlayer is the class that describes your main robot strategy.
 * The run() method inside this class is like your main function: this is what we'll call once your robot
 * is created!
 */
public strictfp class RobotPlayer {

    /**
     * We will use this variable to count the number of turns this robot has been alive.
     * You can use static variables like this to save any information you want. Keep in mind that even though
     * these variables are static, in Battlecode they aren't actually shared between your robots.
     */
    static int turnCount = 0;

    /**
     * A random number generator.
     * We will use this RNG to make some random moves. The Random class is provided by the java.util.Random
     * import at the top of this file. Here, we *seed* the RNG with a constant number (6147); this makes sure
     * we get the same sequence of numbers every time this code is run. This is very useful for debugging!
     */
    static final Random rng = new Random(6147);

    /** HQ STATIC VARS */
    static int anchor_cooldown = 50; // How many turns until next anchor can be made

    static int anchors_built = 0; // Track how many anchors have been made

    /** CARRIER STATIC VARS */
    static final int MAX_CAPACITY = 40; // capcity of carriers

    static final int FARMING_ROUND_LENGTH = 100; // first 100 rounds are used for farming

    static final int SPRAY_MODE_ROUND = 10; // first 10 rounds spray carriers

    /** LAUNCHER STATIC VARS */
    // Tracks the previous target to follow if it goes out of range
    static MapLocation prevTarget = null;

    // Count number of turns since last prevTarget refresh
    static short lastRefresh = 0;

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
        case LAUNCHER: runLauncher(rc); break;
        default: break;
        }
    }


    /**
     * Run a single turn for a Headquarters.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runHeadquarters(RobotController rc) throws GameActionException {
        ArrayList<Direction> stkDir = new ArrayList<Direction>();
        for (int i = 0; i < directions.length; i++) {
            stkDir.add(directions[i]);
        }
        Collections.shuffle(stkDir);
        int ind = 0;
        while (true) {
            turnCount += 1;
            try {
                MapLocation newLoc = rc.getLocation().add(stkDir.get(ind));
                if (true) {
                    rc.setIndicatorString("Trying to build a carrier");
                    if (rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                        rc.buildRobot(RobotType.CARRIER, newLoc);
                        ind++;
                    }
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

    // runs resource carrier code for wells within sight of hq
    static void runCloseResourceCarrier(RobotController rc) {
        // while (true) {
        //     turnCount += 1;
        //     try {
                
        //     } catch (GameActionException e) {
        //         System.out.println(rc.getType() + " Exception");
        //         e.printStackTrace();

        //     } catch (Exception e) {
        //         System.out.println(rc.getType() + " Exception");
        //         e.printStackTrace();

        //     } finally {
        //         Clock.yield();
        //     }
        // }
    }

    // runs resource carrier code for wells outside of sight of hq
    static void runFarResourceCarrier(RobotController rc) throws GameActionException {
        boolean movingBack = false;                                         // finished harvesting, returning to hq
        Stack<Direction> moveList = new Stack<Direction>();         // list of directions
        Direction normalDir = Direction.CENTER;                             // direction robot is "trying" to go in
        MapLocation hqPosition = new MapLocation(0, 0);
        MapLocation wellPosition = new MapLocation(0, 0);

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

                // Deposit if possible
                // TODO: make this handle case where robot carries more than one type of resource
                if (rc.canTransferResource(hqPosition, ResourceType.MANA, MAX_CAPACITY)) { 
                    rc.transferResource(hqPosition, ResourceType.MANA, MAX_CAPACITY);
                    rc.setIndicatorString("Depositing, now have, AD:" + 
                        rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                        " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                        " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                    moveList.clear();
                }
                // TODO: make this handle case where robot carries more than one type of resource
                if (rc.canTransferResource(hqPosition, ResourceType.ADAMANTIUM, MAX_CAPACITY)) {
                    rc.transferResource(hqPosition, ResourceType.ADAMANTIUM , MAX_CAPACITY);
                    rc.setIndicatorString("Depositing, now have, AD:" + 
                        rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                        " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                        " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                    moveList.clear();
                }

                if (rc.getWeight() == MAX_CAPACITY)
                    movingBack = true;

                boolean harvesting = false;
                MapLocation me = rc.getLocation();
                // Harvest if possible
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        MapLocation wellLocation = new MapLocation(me.x + dx, me.y + dy);
                        if (rc.canCollectResource(wellLocation, -1)) {
                            harvesting = true;
                            rc.collectResource(wellLocation, -1);
                            rc.setIndicatorString("Collecting, now have, AD:" + 
                                rc.getResourceAmount(ResourceType.ADAMANTIUM) + 
                                " MN: " + rc.getResourceAmount(ResourceType.MANA) + 
                                " EX: " + rc.getResourceAmount(ResourceType.ELIXIR));
                        }
                    }
                }

                if (rc.getWeight() == 0)
                    movingBack = false;
                if (harvesting)
                    continue;
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
                            while (!rc.canMove(normalDir))
                                    normalDir = normalDir.rotateRight();
                                rc.move(normalDir);
                                moveList.push(normalDir);
                                rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                            // RobotInfo blocker = rc.senseRobotAtLocation(me.add(normalDir));
                            // if (blocker != null) {
                            //     while (!rc.canMove(normalDir))
                            //         normalDir = normalDir.rotateRight();
                            //     rc.move(normalDir);
                            //     moveList.push(normalDir);
                            //     rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                            // } else {

                            //     rc.disintegrate();
                            // }
                        }
                    } else {
                        while (!rc.canMove(normalDir))
                            normalDir = normalDir.rotateRight();
                        rc.move(normalDir);
                        moveList.push(normalDir);
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

    // carries anchors to islands
    static void runAnchorCarrier(RobotController rc) throws GameActionException {
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
        while (true) {
            turnCount += 1;
            try {
                MapLocation me = rc.getLocation();
                rc.setIndicatorString(normalDir.name());

                if (rc.canTakeAnchor(hqPosition, Anchor.ACCELERATING)) {
                    movingBack = false;
                    rc.takeAnchor(hqPosition, Anchor.ACCELERATING);
                    moveList.clear();
                } else if (rc.canTakeAnchor(hqPosition, Anchor.STANDARD)) {
                    movingBack = false;
                    rc.takeAnchor(hqPosition, Anchor.STANDARD);
                    moveList.clear();
                }

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
                                while (!rc.canMove(normalDir))
                                    normalDir = normalDir.rotateRight();
                                rc.move(normalDir);
                                moveList.push(normalDir);
                                rc.setIndicatorString(normalDir.name() + " | move in normal direction");
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

    static void runCarrier(RobotController rc) throws GameActionException {
        char carrierType = 'f';
        // 'c' - close resource carrier
        // 'f' - far resource carrier
        // 'a' - anchor carrier
        // 's' - scout carrier 

        switch (carrierType) {
        case 'c': runCloseResourceCarrier(rc); break;
        case 'f': runFarResourceCarrier(rc); break;
        case 'a': runAnchorCarrier(rc); break;
        }
    }

    /**
     * Run a single turn for a Launcher.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runLauncher(RobotController rc) throws GameActionException {
        // Try to attack someone
        int radius = rc.getType().actionRadiusSquared;
        Team opponent = rc.getTeam().opponent();
        RobotInfo[] enemies = rc.senseNearbyRobots(radius, opponent);

        MapLocation curLoc = rc.getLocation();

        // Also try to move randomly.
        Direction dir = directions[rng.nextInt(directions.length)];

        // Move towards previous target, if available
        if (prevTarget != null) {
            dir = curLoc.directionTo(prevTarget);
            lastRefresh++;
        }
        if (lastRefresh >= 3) {
            prevTarget = null;
        }

        int curEnemy = 0;
        // Make sure not attacking HQ
        while (curEnemy < enemies.length) {
            MapLocation toAttack = enemies[curEnemy].location;

            if (enemies[curEnemy].type == RobotType.HEADQUARTERS) {
                curEnemy++;
                dir = curLoc.directionTo(toAttack);
                continue;
            }

            // MapLocation toAttack = rc.getLocation().add(Direction.EAST);

            if (rc.canAttack(toAttack)) {
                rc.setIndicatorString("Attacking");        
                rc.attack(toAttack);
            }

            if (enemies[curEnemy].health <= 0) {
                prevTarget = null;
                dir = directions[rng.nextInt(directions.length)];
            } else {
                dir = curLoc.directionTo(toAttack);
                prevTarget = toAttack;
            }

            lastRefresh = 0;

            break;
        }

        if (rc.canMove(dir)) {
            rc.move(dir);
        }
    }
}
