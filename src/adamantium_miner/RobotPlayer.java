package adamantium_miner;

import battlecode.common.*;

import java.util.*;
import java.math.*;

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

        switch (rc.getType()){
            case HEADQUARTERS: runHeadquarters(rc); break;
            case CARRIER: runCarrier(rc); break;
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
            if(fixedCarrierCnt > 0 && rc.canBuildRobot(RobotType.CARRIER, rc.getLocation().add(directions[moves.get(0)]))){
                int x = rc.readSharedArray(fixedCarrierIndex);
                rc.writeSharedArray(fixedCarrierIndex, x + 8);
                rc.buildRobot(RobotType.CARRIER, rc.getLocation().add(directions[moves.get(0)]));
                fixedCarrierCnt--;
            }
            Clock.yield();
        }
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
                            if(i != dirIndex(well.directionTo(out)) && i != dirIndex(well.directionTo(curPos)) && cnt > 0){
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
                if(moved == 0 || (!rc.isMovementReady() && !rc.isActionReady())){
                    Clock.yield();
                }
            }
        }
    }

    /**
     * Run a single turn for a Carrier.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runCarrier(RobotController rc) throws GameActionException { 
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
}
