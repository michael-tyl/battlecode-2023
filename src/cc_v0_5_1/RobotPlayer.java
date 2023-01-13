package cc_v0_5_1;

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

    static ArrayList<Integer> findConveyerBelt(RobotController rc) throws GameActionException{
        int n = rc.getMapWidth(), m = rc.getMapHeight();
        MapInfo mapData[][] = new MapInfo[n][m];
        MapInfo visible[] = rc.senseNearbyMapInfos();
        int type[][] = new int[n][m];
        int hx = rc.getLocation().x, hy = rc.getLocation().y;
        int cnt = 0;
        MapLocation well = rc.getLocation();
        int dist = 1000000000;
        //scans map
        for(int i = 0; i < visible.length; i++){
            int x = visible[i].getMapLocation().x, y = visible[i].getMapLocation().y;
            mapData[x][y] = visible[i];
            if(mapData[x][y].isPassable() && mapData[x][y].getCurrentDirection() == Direction.CENTER){
                cnt++;
                type[x][y] = 1;
                if(rc.senseWell(new MapLocation(x, y)) != null){
                    int nw = Math.abs(x - hx)*Math.abs(x - hx) + Math.abs(y - hy)*Math.abs(y - hy);
                    if(nw < dist){
                        dist = nw;
                        well = new MapLocation(x, y);
                    }
                }
            }   
        }
        //found no well 
        if(dist == 1000000000) return null;
        //marks all cells adjacent to well
        int wx = well.x, wy = well.y;
        int size = 1;
        Direction dir = rc.getLocation().directionTo(well);
        for(int i = 0; i < 8; i++){
            MapLocation nxt = well.add(directions[i]);
            if(rc.canSenseLocation(nxt) && type[nxt.x][nxt.y] != 0){
                type[nxt.x][nxt.y] = 2;
                size++;
            }
        }
        MapLocation q[] = new MapLocation[cnt];
        MapLocation par[][] = new MapLocation[n][m]; //parent of cell
        boolean vis[][] = new boolean[n][m]; //if cell is visited or not
        int st = dirIndex(rc.getLocation().directionTo(well)); //heuristic to optimize bfs
        //run bfs
        int l = 0, r = 1;
        q[0] = rc.getLocation();
        vis[hx][hy] = true;
        while(l < r){
            l++;
            if(!q[l - 1].equals(q[0]) && type[q[l - 1].x][q[l - 1].y] == 2) break;
            for(int i = 0; i < 8; i++){
                MapLocation nxt = q[l - 1].add(directions[(st - 1 + i + 7)%8]);
                if(rc.canSenseLocation(nxt) && type[nxt.x][nxt.y] != 0 && !vis[nxt.x][nxt.y]){
                    vis[nxt.x][nxt.y] = true;
                    par[nxt.x][nxt.y] = q[l - 1];
                    q[r++] = nxt;
                }
            }
        }
        //found no paths
        if(q[l - 1].equals(q[0]) || type[q[l - 1].x][q[l - 1].y] != 2) return null;
        //retrieve one path on the bfs and mark all visited nodes
        MapLocation cur = q[l - 1];
        ArrayList<Integer> path = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) for(int j = 0; j < m; j++) vis[i][j] = false;
        while(!cur.equals(rc.getLocation())){
            path.add(dirIndex(par[cur.x][cur.y].directionTo(cur)));
            vis[cur.x][cur.y] = true;
            cur = par[cur.x][cur.y];
        }
        //reverse path to make order correct
        Collections.reverse(path);
        //last element of first part should be marked
        if(path.size() == 1){
            path.add(dirIndex(q[l - 1].directionTo(well)));
            path.add(dirIndex(well.directionTo(q[l - 1])));
            path.add(1);
            return path;
        }
        path.set(path.size() - 1, path.get(path.size() - 1) + 8);
        //add extra stuff for the bot to compute path
        path.add(dirIndex(q[l - 1].directionTo(well)));
        //run bfs again to get the second path
        l = 0;
        r = 1;
        q[0] = rc.getLocation().add(directions[path.get(0)]);
        while(l < r){
            l++;
            if(!q[l - 1].equals(q[0]) && type[q[l - 1].x][q[l - 1].y] == 2) break;
            for(int i = 0; i < 8; i++){
                MapLocation nxt = q[l - 1].add(directions[(st - 1 + i + 7)%8]);
                if(rc.canSenseLocation(nxt) && type[nxt.x][nxt.y] != 0 && !vis[nxt.x][nxt.y]){
                    vis[nxt.x][nxt.y] = true;
                    par[nxt.x][nxt.y] = q[l - 1];
                    q[r++] = nxt;
                }
            }
        }
        //figure out how many robots to allocate optimally
        //size += path.size() - 1;
        //only found one path
        if(q[l - 1].equals(q[0]) || type[q[l - 1].x][q[l - 1].y] != 2){
            path.add(1);
            return path;
        }
        //retrive second path
        cur = q[l - 1];
        //add extra stuff for the bot to compute path
        path.add(dirIndex(well.directionTo(cur)));
        while(!cur.equals(rc.getLocation().add(directions[path.get(0)]))){
            path.add(dirIndex(cur.directionTo(par[cur.x][cur.y])));
            cur = par[cur.x][cur.y];
        }
        path.add(size);
        return path;
    }

    /**
     * Run a single turn for a Headquarters.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runHeadquarters(RobotController rc) throws GameActionException {
        ArrayList<Integer> moves = findConveyerBelt(rc);
        int fixedCarrierCnt = 0; //number of fixed carriers to spawn
        int fixedCarrierIndex = 0; //index to assign fixed carrier id

        ArrayList<Direction> stkDir = new ArrayList<Direction>();
        for (int i = 0; i < directions.length; i++) {
            stkDir.add(directions[i]);
        }
        Collections.shuffle(stkDir);
        if(moves != null){
            while(((rc.readSharedArray(fixedCarrierIndex) >> 2) & 1) == 1){
                int parse = rc.readSharedArray(++fixedCarrierIndex);
                while(((parse >> 4) & 1) == 1){
                    parse = rc.readSharedArray(++fixedCarrierIndex);
                }
                fixedCarrierIndex++;
            }
            rc.writeSharedArray(fixedCarrierIndex, rc.getID()/2 - 1 + 4);
            fixedCarrierCnt = moves.get(moves.size() - 1);
            moves.remove(moves.size() - 1);
            for(int i = 1; i < moves.size() - 1; i++) rc.writeSharedArray(fixedCarrierIndex + i, moves.get(i) + 16);
            rc.writeSharedArray(fixedCarrierIndex + moves.size() - 1, moves.get(moves.size() - 1));
        }
        while(true){
            RobotInfo[] friendlies = rc.senseNearbyRobots(rc.getType().visionRadiusSquared, rc.getTeam());
            numFriendlies = friendlies.length;
            boolean anchorBuilt = false;
            anchor_cooldown--;
            if(numFriendlies > 5 && anchors_built < 10 && anchor_cooldown < 25 && rc.getNumAnchors(Anchor.STANDARD) == 0 && rc.getNumAnchors(Anchor.ACCELERATING) == 0) {
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
                if(fixedCarrierCnt > 0 && rc.canBuildRobot(RobotType.CARRIER, rc.getLocation().add(directions[moves.get(0)]))){
                    int x = rc.readSharedArray(fixedCarrierIndex);
                    rc.writeSharedArray(fixedCarrierIndex, x + 8);
                    rc.buildRobot(RobotType.CARRIER, rc.getLocation().add(directions[moves.get(0)]));
                    fixedCarrierCnt--;
                }
                else for (int i = 0; i < stkDir.size(); i++) {
                    MapLocation newLoc = rc.getLocation().add(stkDir.get(i));
                    if (carrierOverride && rc.canBuildRobot(RobotType.CARRIER, newLoc)) {
                        rc.setIndicatorString("Trying to build a carrier");
                        rc.buildRobot(RobotType.CARRIER, newLoc);
                        carrierOverride = false;
                    } else if (numFriendlies < 9 && rc.canBuildRobot(RobotType.LAUNCHER, newLoc)) {
                        rc.setIndicatorString("Trying to build a laucher");
                        rc.buildRobot(RobotType.LAUNCHER, newLoc);
                    }
                }
            } else {
                anchor_cooldown = 50;
                anchors_built++;
                carrierOverride = true;
            }
            Clock.yield();
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

    static void fixedCarrier(RobotController rc, int readIndex) throws GameActionException {        
        ArrayList<Direction> moves = new ArrayList<Direction>(); 
        int index = readIndex + 1;
        int stop = -2;
        int cur = 0;
        int parse = rc.readSharedArray(index);
        while(((parse >> 4) & 1) == 1){
            moves.add(directions[parse & 7]);
            if(((parse >> 3) & 1) == 1){
                stop = index - readIndex - 1;
            }
            parse = rc.readSharedArray(++index);
        }
        moves.add(directions[parse & 7]);
        if(((parse >> 3) & 1) == 1){
            stop = index - readIndex - 1;
        }
        ArrayList<Direction> insideMoves = new ArrayList<Direction>();
        boolean first = false;
        int inside = -1;
        while(true){
            turnCount += 1;
            int moved = 0;
            try {
                if(rc.isActionReady()){
                    MapLocation pos = rc.getLocation();
                    if(rc.getResourceAmount(ResourceType.ADAMANTIUM) + rc.getResourceAmount(ResourceType.MANA) + rc.getResourceAmount(ResourceType.ELIXIR) >= 20){
                        boolean found = false;
                        RobotInfo targets[] = rc.senseNearbyRobots();
                        for(int i = 0; i < targets.length; i++){
                            if(targets[i].getTeam() != rc.getTeam()){
                                if(rc.canAttack(targets[i].getLocation())){
                                    rc.attack(targets[i].getLocation());
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if(found) continue;
                    }
                    if(rc.canCollectResource(pos, -1)){
                        rc.collectResource(pos, -1);
                        moved++;
                    } else {
                        for(int i = 0; i < 8; i++){
                            MapLocation nxt = pos.add(directions[i]);
                            if(rc.canSenseRobotAtLocation(nxt) && rc.senseRobotAtLocation(nxt).type == RobotType.HEADQUARTERS && rc.getResourceAmount(ResourceType.ADAMANTIUM) > 0){
                                rc.transferResource(nxt, ResourceType.ADAMANTIUM, rc.getResourceAmount(ResourceType.ADAMANTIUM));
                                moved++;
                                break;
                            }
                            if(rc.canSenseRobotAtLocation(nxt) && rc.senseRobotAtLocation(nxt).type == RobotType.HEADQUARTERS && rc.getResourceAmount(ResourceType.MANA) > 0){
                                rc.transferResource(nxt, ResourceType.MANA, rc.getResourceAmount(ResourceType.MANA));
                                moved++;
                                break;
                            }
                            if(rc.canSenseRobotAtLocation(nxt) && rc.senseRobotAtLocation(nxt).type == RobotType.HEADQUARTERS && rc.getResourceAmount(ResourceType.ELIXIR) > 0){
                                rc.transferResource(nxt, ResourceType.ELIXIR, rc.getResourceAmount(ResourceType.ELIXIR));
                                moved++;
                                break;
                            }
                            if(rc.canCollectResource(nxt, -1)){
                                rc.collectResource(nxt, -1);
                                moved++;
                                break;
                            }
                        }
                    } 
                }
                if(cur == stop + 1){
                    if(!first){
                        MapLocation curPos = rc.getLocation();
                        MapLocation well = curPos.add(moves.get(cur));
                        MapLocation out = well.add(moves.get(cur + 1));
                        boolean valid[] = new boolean[8];
                        for(int i = 0; i < 8; i++){
                            valid[i] = rc.sensePassability(well.add(directions[i]));
                        }
                        MapLocation nodes[] = new MapLocation[9];
                        int valcnt = 0;
                        nodes[valcnt++] = well;
                        for(int i = 0; i < 8; i++){
                            int cnt = 0;
                            MapLocation x = well.add(directions[i]);
                            for(int j = 0; j < 8; j++){
                                if(valid[j] && x.isAdjacentTo(well.add(directions[j]))){
                                    cnt++;
                                }
                            }
                            if(valid[i] && i != dirIndex(well.directionTo(out)) && i != dirIndex(well.directionTo(curPos)) && cnt > 0){
                                nodes[valcnt++] = x;
                            }
                        }
                        int dp[][] = new int[1 << valcnt][valcnt];
                        int par[][] = new int[1 << valcnt][valcnt];
                        for(int i = 0; i < (1 << valcnt); i++){
                            int bitCnt = 0;
                            for(int j = 0; j < valcnt; j++) bitCnt += (i >> j) & 1;
                            for(int j = 0; j < valcnt; j++){
                                if((i & (1 << j)) > 0){
                                    if(bitCnt == 1 && out.isAdjacentTo(nodes[j])){
                                        dp[i][j] = -1;
                                        par[i][j] = -1;
                                    }
                                    if(dp[i][j] == 0) continue;
                                    for(int k = 0; k < valcnt; k++){
                                        if((i & (1 << k)) == 0 && nodes[j].isAdjacentTo(nodes[k])){
                                            dp[i ^ (1 << k)][k] = j + 1;
                                            par[i ^ (1 << k)][k] = i;
                                        }
                                    }
                                }
                            }
                        }
                        boolean found = false;
                        for(int i = (1 << valcnt) - 1; i >= 0; i--){
                            for(int j = 0; j < valcnt; j++){
                                if(dp[i][j] != 0 && curPos.isAdjacentTo(nodes[j])){
                                    found = true;
                                    int x = i, y = j;
                                    while(y != -2){
                                        insideMoves.add(curPos.directionTo(nodes[y]));
                                        curPos = nodes[y];
                                        int x1 = x;
                                        x = par[x][y];
                                        y = dp[x1][y] - 1;
                                    }
                                    insideMoves.add(curPos.directionTo(out));
                                    break;
                                }
                            }
                            if(found) break;
                        }
                        first = true;
                    }
                    inside = 0;
                    cur += 2;
                    cur %= moves.size();
                }
                if(inside != -1){
                    if(inside == insideMoves.size()){
                        if(rc.getResourceAmount(ResourceType.ADAMANTIUM) + rc.getResourceAmount(ResourceType.MANA) + rc.getResourceAmount(ResourceType.ELIXIR) >= 34){
                            inside = -1;
                        }
                    } else {
                        if(rc.canMove(insideMoves.get(inside))){
                            rc.move(insideMoves.get(inside));
                            moved++;
                            inside++;
                        }
                    }
                } else {
                    if(stop == -2 && rc.senseWell(rc.getLocation()) != null && rc.getResourceAmount(ResourceType.ADAMANTIUM) + rc.getResourceAmount(ResourceType.MANA) + rc.getResourceAmount(ResourceType.ELIXIR) < 40){
                        continue;
                    } else if(rc.canMove(moves.get(cur))){
                        rc.move(moves.get(cur));
                        moved++;
                        cur++;
                        cur %= moves.size();
                    } 
                }
            } catch (GameActionException e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } finally {
                //if(moved == 0 || (!rc.isMovementReady() && !rc.isActionReady())){
                    Clock.yield();
                //}
            }
        }
    }

    // runs resource carrier code for wells outside of sight of hq
    static void runFarResourceCarrier(RobotController rc) throws GameActionException {
        int hq = -1; 
        for(int i = 0; i < 8; i++){
            RobotInfo nxt = rc.senseRobotAtLocation(rc.getLocation().add(directions[i]));
            if(nxt != null && nxt.getType() == RobotType.HEADQUARTERS){
                hq = nxt.getID();
            }
        }
        int readIndex = 0;
        while((rc.readSharedArray(readIndex) & 3) != hq/2 - 1){
            int parse = rc.readSharedArray(++readIndex);
            while(((parse >> 4) & 1) == 1){
                parse = rc.readSharedArray(++readIndex);
            }
            readIndex++;
        }
        int job = rc.readSharedArray(readIndex);
        rc.writeSharedArray(readIndex, job & 3);
        if(((job >> 3) & 1) == 1){
            fixedCarrier(rc, readIndex);
        } else {

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
