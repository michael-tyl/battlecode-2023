package cc_v0_5_0;

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

    /** MAP INFO */
    static MapLocation enemyHQ = null;
    static MapLocation hqLoc = null;
    static int numFriendlies = 0;

    /** HQ STATIC VARS */
    static int anchor_cooldown = 200; // How many turns until next anchor can be made
    static boolean carrierOverride = false; // Queue new carrier to get anchor
    static int anchors_built = 0; // Track how many anchors have been made

    /** CARRIER STATIC VARS */
    static final int MAX_CAPACITY = 40; // capcity of carriers

    static final int FARMING_ROUND_LENGTH = 100; // first 100 rounds are used for farming

    static final int SPRAY_MODE_ROUND = 10; // first 10 rounds spray carriers
    
    static char carrierType = 'f';
    // 'c' - close resource carrier
    // 'f' - far resource carrier
    // 'a' - anchor carrier
    // 's' - scout carrier 

    /** LAUNCHER STATIC VARS */
    // Tracks the previous target to follow if it goes out of range
    static MapLocation prevTarget = null;

    // Count number of turns since last prevTarget refresh
    static short lastRefresh = 0;

    static boolean active = false;
    static int moveCount = 0;

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

        // Set enemy HQ loc
        if (enemyHQ == null) {
            hqLoc = rc.getLocation();
            if (rc.getType() != RobotType.HEADQUARTERS) {
                RobotInfo[] friendlies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam());
                for (int i = 0; i < friendlies.length; i++) {
                    if (friendlies[i].getType() == RobotType.HEADQUARTERS) {
                        hqLoc = friendlies[i].getLocation();
                        break;
                    }
                }
                // numFriendlies = friendlies.length;
            }

            enemyHQ = new MapLocation(Math.abs(rc.getMapWidth() - 1 - hqLoc.x), Math.abs(rc.getMapHeight() - 1 - hqLoc.y));
        }

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
        // int ind = 0;
        while (true) {
            turnCount += 1;
            try {
                RobotInfo[] friendlies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam());
                numFriendlies = friendlies.length;
                boolean anchorBuilt = false;
                anchor_cooldown--;
                if(numFriendlies > 8 && anchors_built < 10 && anchor_cooldown < 25 && rc.getNumAnchors(Anchor.STANDARD) == 0 && rc.getNumAnchors(Anchor.ACCELERATING) == 0) {
                    rc.setIndicatorString("Trying to build an anchor" + numFriendlies);
                    if(rc.canBuildAnchor(Anchor.ACCELERATING)) {
                        rc.buildAnchor(Anchor.ACCELERATING);
                        anchorBuilt = true;
                    }
                    else if(rc.canBuildAnchor(Anchor.STANDARD)){
                        rc.buildAnchor(Anchor.STANDARD);
                        anchorBuilt = true;
                    }
                }
                if (!anchorBuilt){ 
                    for (int i = 0; i < stkDir.size(); i++) {
                        MapLocation newLoc = rc.getLocation().add(stkDir.get(i));
                        if ((numFriendlies < 14 || carrierOverride) && rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                            rc.setIndicatorString("Trying to build a carrier");
                            rc.buildRobot(RobotType.CARRIER, newLoc);
                            carrierOverride = false;
                        } else if (numFriendlies < 18 && rc.canBuildRobot(RobotType.LAUNCHER, newLoc)) {
                            rc.setIndicatorString("Trying to build a laucher");
                            rc.buildRobot(RobotType.LAUNCHER, newLoc);
                        }
                    }
                } else {
                    anchor_cooldown = 50;
                    anchors_built++;
                    carrierOverride = true;
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

    static void runCarrier(RobotController rc) throws GameActionException {

        if (rc.canTakeAnchor(hqLoc, Anchor.ACCELERATING)) {
            rc.takeAnchor(hqLoc, Anchor.ACCELERATING);
            carrierType = 'a';
        } else if (rc.canTakeAnchor(hqLoc, Anchor.STANDARD)) {
            rc.takeAnchor(hqLoc, Anchor.STANDARD);
            carrierType = 'a';
        }

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

        while (true) {
            turnCount += 1;
            try {
                // Try to attack someone
                int radius = rc.getType().actionRadiusSquared;
                int vision = rc.getType().visionRadiusSquared;
                Team opponent = rc.getTeam().opponent();
                RobotInfo[] enemies = rc.senseNearbyRobots(radius, opponent);
                RobotInfo[] friendlies = rc.senseNearbyRobots(vision, rc.getTeam());

                MapLocation curLoc = rc.getLocation();

                // Leave null for now
                Direction dir = null;

                // Move towards previous target, if available
                if (prevTarget != null) {
                    dir = curLoc.directionTo(prevTarget);
                    lastRefresh++;
                }
                if (lastRefresh >= 3) {
                    prevTarget = null;
                }

                boolean chase = false;
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
                        chase = true;
                        prevTarget = toAttack;
                    }

                    lastRefresh = 0;

                    break;
                }

                // Try moving towards enemy HQ
                if (dir == null) {
                    dir = curLoc.directionTo(enemyHQ);
                    int i = 0;
                    while (!rc.canMove(dir) && i < 20) {
                        dir = directions[rng.nextInt(directions.length)];
                        i++;
                    }
                }
                
                // TODO: Better criteria than lowest ID
                // Current form is worse than v0.3, currently not used to set direction
                boolean leader = true;

                // MapLocation centerMass = rc.getLocation();
                int launcherCount = 0;
                for (int i = 0; i < friendlies.length; i++) {
                    if (friendlies[i].getType() != RobotType.LAUNCHER) continue;
                    launcherCount++;
                    // Activate in groups of at least x size
                    if (launcherCount >= 3) {
                        active = true;
                        rc.setIndicatorString("Active!");
                    }
                    // if (friendlies[i].getID() < rc.getID()) leader = false;
                    // centerMass = centerMass.add(curLoc.directionTo(friendlies[i].getLocation()));
                }

                // if (!leader && !chase) {
                //     dir = curLoc.directionTo(centerMass);
                // }

                // Move 3 times to prevent crowding HQ
                if ((moveCount < 3 || active || rc.senseMapInfo(curLoc).hasCloud()) && rc.canMove(dir)) {
                    rc.move(dir);
                    moveCount++;
                }
            }  catch (GameActionException e) {
                // Oh no! It looks like we did something illegal in the Battlecode world. You should
                // handle GameActionExceptions judiciously, in case unexpected events occur in the game
                // world. Remember, uncaught exceptions cause your robot to explode!
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } catch (Exception e) {
                // Oh no! It looks like our code tried to do something bad. This isn't a
                // GameActionException, so it's more likely to be a bug in our code.
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();

            } finally {
                // Signify we've done everything we want to do, thereby ending our turn.
                // This will make our code wait until the next turn, and then perform this loop again.
                Clock.yield();
            }
        }
    }
}
