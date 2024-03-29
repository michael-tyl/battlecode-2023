package cc_v0_4;

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

    /**
     * run() is the method that is called when a robot is instantiated in the Battlecode world.
     * It is like the main function for your robot. If this method returns, the robot dies!
     *
     * @param rc  The RobotController object. You use it to perform actions from this robot, and to get
     *            information on its current status. Essentially your portal to interacting with the world.
     **/
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {

        // Hello world! Standard output is very useful for debugging.
        // Everything you say here will be directly viewable in your terminal when you run a match!
        System.out.println("I'm a " + rc.getType() + " and I just got created! I have health " + rc.getHealth());

        // You can also use indicators to save debug notes in replays.
        rc.setIndicatorString("Hello world!");

        while (true) {
            // This code runs during the entire lifespan of the robot, which is why it is in an infinite
            // loop. If we ever leave this loop and return from run(), the robot dies! At the end of the
            // loop, we call Clock.yield(), signifying that we've done everything we want to do.

            turnCount += 1;  // We have now been alive for one more turn!

            // Try/catch blocks stop unhandled exceptions, which cause your robot to explode.
            try {
                // The same run() function is called for every robot on your team, even if they are
                // different types. Here, we separate the control depending on the RobotType, so we can
                // use different strategies on different robots. If you wish, you are free to rewrite
                // this into a different control structure!
                switch (rc.getType()) {
                    case HEADQUARTERS:     runHeadquarters(rc);  break;
                    case CARRIER:      runCarrier(rc);   break;
                    case LAUNCHER: runLauncher(rc); break;
                    case BOOSTER: // Examplefuncsplayer doesn't use any of these robot types below.
                    case DESTABILIZER: // You might want to give them a try!
                    case AMPLIFIER:       break;
                }

            } catch (GameActionException e) {
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
            // End of loop: go back to the top. Clock.yield() has ended, so it's time for another turn!
        }

        // Your code should never reach here (unless it's intentional)! Self-destruction imminent...
    }

    /**
     * Run a single turn for a Headquarters.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runHeadquarters(RobotController rc) throws GameActionException {
        // ArrayList<Direction> stkDir = new ArrayList<Direction>();
        // for (int i = 0; i < directions.length; i++) {
        //     stkDir.add(directions[i]);
        // }
        // Collections.shuffle(stkDir);
        while (true) {
            turnCount += 1;
            try {
                MapLocation newLoc = rc.getLocation();
                newLoc = newLoc.add(Direction.WEST);
                newLoc = newLoc.add(Direction.WEST);
                newLoc = newLoc.add(Direction.WEST);
                newLoc = newLoc.add(Direction.SOUTH);
                newLoc = newLoc.add(Direction.SOUTH);
                newLoc = newLoc.add(Direction.SOUTH);
                anchor_cooldown--;
                if (anchor_cooldown <= 49 && rc.getNumAnchors(Anchor.STANDARD) == 0 && rc.getNumAnchors(Anchor.ACCELERATING) == 0) {
                    rc.setIndicatorString("Trying to build an anchor");
                    if (rc.canBuildAnchor(Anchor.ACCELERATING)) {
                        rc.buildAnchor(Anchor.ACCELERATING);
                        anchor_cooldown = 50;
                    } else if (rc.canBuildAnchor(Anchor.STANDARD)) {
                        rc.buildAnchor(Anchor.STANDARD);
                        anchor_cooldown = 50;
                    }
                } 
                for (int dx = -3; dx <= 3; dx++) {
                    newLoc = newLoc.add(Direction.SOUTH);
                    newLoc = newLoc.add(Direction.SOUTH);
                    newLoc = newLoc.add(Direction.SOUTH);
                    newLoc = newLoc.add(Direction.SOUTH);
                    newLoc = newLoc.add(Direction.SOUTH);
                    newLoc = newLoc.add(Direction.SOUTH);
                    for (int dy = -3; dy <= 3; dy++) {
                        if (rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                            rc.setIndicatorString("Trying to build a carrier");
                            rc.buildRobot(RobotType.CARRIER, newLoc);
                            break;
                            // ind++;
                        } else if (rc.canBuildRobot(RobotType.LAUNCHER, newLoc)) {
                            rc.setIndicatorString("Trying to build a laucher");
                            rc.buildRobot(RobotType.LAUNCHER, newLoc);
                            break;
                        }
                        newLoc = newLoc.add(Direction.NORTH);
                    }
                    newLoc = newLoc.add(Direction.EAST);
                }
                // MapLocation newLoc = rc.getLocation().add(stkDir.get(ind));
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

    /**
     * Run a single turn for a Carrier.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runCarrier(RobotController rc) throws GameActionException {
        boolean movingBack = false;                                         // finished harvesting, returning to hq
        boolean claimIsland = false;
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


                if (rc.getWeight() == MAX_CAPACITY &&
                        rc.getNumAnchors(Anchor.STANDARD) == 0 &&
                        rc.getNumAnchors(Anchor.ACCELERATING) == 0)
                    movingBack = true;

                MapLocation me = rc.getLocation();

                if(rc.canTakeAnchor(hqPosition, Anchor.ACCELERATING)) {
                    claimIsland = true;
                    rc.takeAnchor(hqPosition, Anchor.ACCELERATING);
                }
                if(rc.canTakeAnchor(hqPosition, Anchor.STANDARD)) {
                    claimIsland = true;
                    rc.takeAnchor(hqPosition, Anchor.STANDARD);
                }

                if(!claimIsland){
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
                    } else if(claimIsland) {
                        if(rc.canPlaceAnchor()) {
                            rc.placeAnchor();
                            claimIsland = false;
                        }
                        else {
                            int[] islands = rc.senseNearbyIslands();

                            int curid = 0;
                            for(; curid < islands.length; curid++)
                            {
                                if(rc.senseTeamOccupyingIsland(islands[curid]) == Team.NEUTRAL)
                                    break;
                            }

                            if(curid < islands.length) {
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
