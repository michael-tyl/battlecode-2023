package launcher_v2;


import battlecode.common.*;

import java.util.*;
import java.math.*;

public strictfp class RobotPlayer {

    static final Random rng = new Random(6151);
    static int turnCount = 0;

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
    
    static Communication comms;

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        comms = new Communication(rc);

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

        switch (rc.getType()){
            case HEADQUARTERS: runHeadquarters(rc); break;
            case CARRIER: runCarrier(rc); break;
            case LAUNCHER: runLauncher(rc); break;
        }
        return;
    }

    static int dirIndex(Direction dir){
        switch(dir){
            case NORTH: return 0;
            case NORTHEAST: return 1;
            case EAST: return 2;
            case SOUTHEAST: return 3;
            case SOUTH: return 4;
            case SOUTHWEST: return 5;
            case WEST: return 6;
            case NORTHWEST: return 7;
            default: return -1;
        }
    } 

    static int countEnemyLaunchers(RobotController rc) throws GameActionException {
        RobotInfo[] enemies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam().opponent());
        short count = 0;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].getType() == RobotType.LAUNCHER) count++;
        }
        return count;
    }

    static int countNumFriendlies(RobotController rc) throws GameActionException {
        return rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam()).length;
    }

    static void runHeadquarters(RobotController rc) throws GameActionException {
        int myId = rc.getID()/2 - 1;
        WellInfo wells[] = rc.senseNearbyWells();
        for(int i = 0; i < wells.length; i++){
            comms.addWell(wells[i]);
        }
        comms.setPos(myId, rc.getLocation());
        int miners = 16;
        int scouts = 2;
        int scoutCooldown = 0;
        int cur = 0;
        
        Direction[] stkDir = new Direction[8];
        stkDir[0] = hqLoc.directionTo(enemyHQ);
        stkDir[1] = stkDir[0].rotateLeft();
        stkDir[2] = stkDir[0].rotateRight();
        stkDir[3] = stkDir[0].rotateLeft().rotateLeft();
        stkDir[4] = stkDir[0].rotateRight().rotateRight();
        stkDir[5] = stkDir[0].rotateLeft().rotateLeft().rotateLeft();
        stkDir[6] = stkDir[0].rotateRight().rotateRight().rotateRight();
        stkDir[7] = stkDir[0].rotateLeft().rotateLeft().rotateLeft();
        if(scouts > 0 && scoutCooldown == 0){
            MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
            if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                comms.addJob(myId, 1);
                rc.buildRobot(RobotType.CARRIER, newLoc);
                scouts--;
                scoutCooldown = 200;
            }
        }
        while(true){
            turnCount += 1;
            try {
                // if (turnCount > 750) rc.resign();
                boolean built = false;
                RobotInfo[] friendlies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam());
                numFriendlies = friendlies.length;
                // int numFriendliesClose = rc.senseNearbyRobots(20, rc.getTeam()).length;
                boolean anchorBuilt = false;
                anchor_cooldown--;
                // Only spawn if not surrounded
                int enemyCount = countEnemyLaunchers(rc);
                if (countEnemyLaunchers(rc) - numFriendlies < 4) {
                    int curVal = rc.readSharedArray(63);
                    int flip = 1 << (rc.getID() / 2 - 1);
                    if ((curVal & flip) == 1) {
                        rc.writeSharedArray(63, curVal ^ flip);
                    }
                    if(anchors_built < 10 && anchor_cooldown < 25 && rc.getNumAnchors(Anchor.STANDARD) == 0 && rc.getNumAnchors(Anchor.ACCELERATING) == 0) {
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
                    if (!built) {
                        for (int i = 0; i < friendlies.length && !built; i++) {
                            if (friendlies[i].getType() == RobotType.LAUNCHER) {
                                MapLocation launcherLoc = friendlies[i].getLocation();
                                for (int j = 0; j < stkDir.length; j++) {
                                    MapLocation spawnLoc = launcherLoc.add(stkDir[j]);
                                    if (rc.canBuildRobot(RobotType.LAUNCHER, spawnLoc)) {
                                        rc.buildRobot(RobotType.LAUNCHER, spawnLoc);
                                        built = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!built) {
                        for (int mult = 1; mult <= 3; mult++) {
                            for (int i = 0; i < stkDir.length; i++) {
                                MapLocation newLoc = rc.getLocation();
                                for (int j = 0; j < mult; j++) {
                                    newLoc = newLoc.add(stkDir[i]);
                                }
                                if (numFriendlies < 42 && turnCount < 1750 && rc.canBuildRobot(RobotType.LAUNCHER, newLoc)) {
                                    rc.setIndicatorString("Trying to build a laucher");
                                    rc.buildRobot(RobotType.LAUNCHER, newLoc);
                                } 
                                /*else if (((numFriendlies < 20 && turnCount < 1750) || carrierOverride) && rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                                    comms.addJob(myId,5);
                                    rc.buildRobot(RobotType.CARRIER, newLoc);
                                }*/
                            }

                        }
                    }
                    if (!anchorBuilt){ 
                        // Frequency of scout building
                        int sctFreq = 10;

                        // if(numScouts > 0 && turnCount - prvScout >= sctFreq && numFriendlies < 27){
                        //     MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                        //     if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                        //         comms.addJob(myId,1);
                        //         rc.buildRobot(RobotType.CARRIER, newLoc);
                        //         built = true;
                        //         numScouts--;
                        //     }
                        // } else if (numFriendlies < 27) {
                        if(scouts > 0 && scoutCooldown == 0){
                            MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                            if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                                comms.addJob(myId, 1);
                                rc.buildRobot(RobotType.CARRIER, newLoc);
                                scouts--;
                                built = true;
                                scoutCooldown = 200;
                            }
                        }
                        if(scoutCooldown > 0) scoutCooldown--;
                        if(!built && miners > 0){
                            MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                            if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                                if(cur == 0) comms.addJob(myId, 3);
                                else if(cur == 1) comms.addJob(myId, 2);
                                else if(cur == 2) comms.addJob(myId, 3);
                                cur++;
                                cur %= 2;
                                rc.buildRobot(RobotType.CARRIER, newLoc);
                                miners--;
                            }
                        } 
                        if (numFriendlies < 32 && !built) {
                            MapLocation newLoc = rc.getLocation().add(directions[rng.nextInt(directions.length)]);
                            if(rc.canSenseLocation(newLoc) && rc.senseMapInfo(newLoc).getCurrentDirection().equals(Direction.CENTER) && rc.canBuildRobot(RobotType.CARRIER, newLoc)){
                                if(cur == 0) comms.addJob(myId, 3);
                                else if(cur == 1) comms.addJob(myId, 2);
                                else if(cur == 2) comms.addJob(myId, 3);
                                cur++;
                                cur %= 2;
                                rc.buildRobot(RobotType.CARRIER, newLoc);
                                built = true;
                            }
                        }
                    } else {
                        anchor_cooldown = 50;
                        anchors_built++;
                        carrierOverride = true;
                    } 

                } else {
                    int curVal = rc.readSharedArray(63);
                    rc.writeSharedArray(63, curVal | (1 << (rc.getID() / 2 - 1)));
                    rc.setIndicatorString("Disabled " + enemyCount);
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
        int job = comms.getJob();
        // Check for anchors
        if (rc.canTakeAnchor(hqLoc, Anchor.ACCELERATING)) {
            rc.takeAnchor(hqLoc, Anchor.ACCELERATING);
            runAnchorCarrier(rc);
        } else if (rc.canTakeAnchor(hqLoc, Anchor.STANDARD)) {
            rc.takeAnchor(hqLoc, Anchor.STANDARD);
            runAnchorCarrier(rc);
        } else if(job == 1){ //Scout
            ScoutCarrier carrier = new ScoutCarrier(rc);
            carrier.run();
        } else if(job == 2){ //Resource collector adamantium
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.ADAMANTIUM);
        } else if(job == 3){ //Resource collector mana
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.MANA);
        } else if(job == 4){ //Resource collector elixir
            ResourceCarrier carrier = new ResourceCarrier(rc);
            carrier.run(ResourceType.ELIXIR);
        } else if(job == 5) { //Support carrier (follows launchers)
            SupportCarrier carrier = new SupportCarrier(rc);
            carrier.run();
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

    static void runLauncher(RobotController rc) throws GameActionException {
        Launcher launcher = new Launcher(rc, hqLoc, enemyHQ);
        launcher.run();
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

    static int activeThreshold(int turn) {
        int thr = 0;
        turn -= 20;
        while (turn > 0) {
            turn /= 7;
            thr++;
        }
        return 0;
    }
}