package comms;

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

    static final int maxFixedCarrierMoves = 17;

    static int[][] findConveyerBelts(RobotController rc) throws GameActionException{
        int n = rc.getMapWidth(), m = rc.getMapHeight();
        int hx = rc.getLocation().x, hy = rc.getLocation().y;
        int radius = 5, diameter = 2*radius + 1;
        int shiftX = Math.max(hx - radius, 0), shiftY = Math.max(hy - radius, 0);
        hx -= shiftX;
        hy -= shiftY;
        MapInfo visible[] = rc.senseNearbyMapInfos();
        WellInfo wells[] = rc.senseNearbyWells();
        //found no wells
        if(wells.length == 0){
            int ret[][] = new int[0][0];
            return ret;
        }
        int type[][] = new int[diameter][diameter];
        int queueSize = 0;
        //scans map
        for(int i = 0; i < visible.length; i++){
            int x = visible[i].getMapLocation().x - shiftX, y = visible[i].getMapLocation().y - shiftY;
            if(visible[i].isPassable() && visible[i].getCurrentDirection() == Direction.CENTER){
                queueSize++;
                type[x][y] = 1;
            }   
        }
        int l = 0, r = 1;
        MapLocation queue[] = new MapLocation[queueSize];
        MapLocation par[][][] = new MapLocation[diameter][diameter][8];
        int parIndex[][] = new int[diameter][diameter];
        int curIndex[][] = new int[diameter][diameter];
        queue[0] = rc.getLocation();
        //runs bfs while storing all parents in optimal order
        //unroll pain
        type[hx][hy] = 0;
        MapLocation nxt;
        int nx, ny;
        while(l < r){
            nxt = queue[l].add(Direction.NORTH);
            nx = queue[l].x - shiftX;
            ny = queue[l].y - shiftY + 1;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.EAST);
            nx++;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.SOUTH);
            ny--;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.SOUTH);
            ny--;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.WEST);
            nx--;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.WEST);
            nx--;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.NORTH);
            ny++;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            nxt = nxt.add(Direction.NORTH);
            ny++;
            if(0 <= nx && nx < diameter && 0 <= ny && ny < diameter && type[nx][ny] == 1){
                if(parIndex[nx][ny] == 0){
                    queue[r++] = nxt;
                }
                par[nx][ny][parIndex[nx][ny]++] = queue[l]; 
            }
            l++;
        } 
        type[hx][hy] = 1;
        int ret[][] = new int[wells.length][maxFixedCarrierMoves];
        for(int i = 0; i < wells.length; i++){
            type[wells[i].getMapLocation().x - shiftX][wells[i].getMapLocation().y - shiftY] = 0;
        }
        for(int i = 0; i < wells.length; i++){
            MapLocation tar = wells[i].getMapLocation();
            MapLocation cur = rc.getLocation();
            int ind = 0;
            while(!tar.equals(cur)){
                if(ind == maxFixedCarrierMoves - 1){
                    ret[i][0] = -1;
                    break;
                }
                int x = tar.x - shiftX, y = tar.y - shiftY;
                type[x][y] = 0;
                while(curIndex[x][y] < parIndex[x][y] && type[par[x][y][curIndex[x][y]].x - shiftX][par[x][y][curIndex[x][y]].y - shiftY] == 0){
                    curIndex[x][y]++;
                }
                if(curIndex[x][y] == parIndex[x][y]){
                    ret[i][0] = -1;
                    break;
                }
                ret[i][ind++] = dirIndex(par[x][y][curIndex[x][y]].directionTo(tar));
                tar = par[x][y][curIndex[x][y]++];
            }
            if(ret[i][0] == -1) continue;
            for(int j = 0; j < ind/2; j++){
                int tmp = ret[i][j];
                ret[i][j] = ret[i][ind - j - 1];
                ret[i][ind - j - 1] = tmp;
            }
            if(ret[i][ind] == -1) continue;
            int stop = ind;
            cur = cur.add(directions[ret[i][0]]);
            tar = wells[i].getMapLocation();
            boolean found = false;
            while(!tar.equals(rc.getLocation())){
                if(ind == maxFixedCarrierMoves - 1){
                    ret[i][stop] = -1;
                    break;
                }
                int x = tar.x - shiftX, y = tar.y - shiftY;
                type[x][y] = 0; 
                while(curIndex[x][y] < parIndex[x][y] && type[par[x][y][curIndex[x][y]].x - shiftX][par[x][y][curIndex[x][y]].y - shiftY] == 0){
                    curIndex[x][y]++;
                }
                if(curIndex[x][y] == parIndex[x][y]){
                    ret[i][stop] = -1;
                    break;
                }
                if(par[x][y][curIndex[x][y]].equals(rc.getLocation())){
                    if(tar.isAdjacentTo(cur)){
                        ret[i][ind++] = dirIndex(tar.directionTo(cur));
                        found = true;
                        break;
                    }
                }
                ret[i][ind++] = dirIndex(tar.directionTo(par[x][y][curIndex[x][y]]));
                tar = par[x][y][curIndex[x][y]++];
            }
            if(!found) ret[i][stop] = -1;
            if(ret[i][stop] == -1) continue; 
            tar = wells[i].getMapLocation();
            for(int j = 0; j < 8; j++){
                int x = tar.add(directions[j]).x - shiftX, y = tar.add(directions[j]).y - shiftY;
                if(0 <= x && x < diameter && 0 <= y && y < diameter) type[x][y] = 0;
            }
            ret[i][ind] = -2;
        }
        return ret;
    }

    static int getJob(int x){
        return (x & (((1 << 16) - 1) ^ ((1 << 13) - 1)));
    }

    static void runHeadquarters(RobotController rc) throws GameActionException {
        int myId = rc.getID()/2 - 1;
        int myX = rc.getLocation().x, myY = rc.getLocation().y;
        rc.writeSharedArray(myId, myX*60 + myY);
        int fixedCarrierPaths[][] = findConveyerBelts(rc);
        int fixedCarrierCnt[] = new int[fixedCarrierPaths.length];
        int fixedCarrierLen[] = new int[fixedCarrierPaths.length];
        int curCarrier = 0;
        for(int i = 0; i < fixedCarrierPaths.length; i++){
            if(fixedCarrierPaths[i][0] != -1){
                fixedCarrierCnt[i] = 3;
            } else {
                continue;
            }
            int cur = 0;
            while(fixedCarrierPaths[i][cur] >= 0) cur++;
            if(fixedCarrierPaths[i][cur] == -1){
                for(int j = cur - 1; j > 0; j--){
                    if(cur == maxFixedCarrierMoves){
                        fixedCarrierCnt[i] = 0;
                        break;
                    }
                    fixedCarrierPaths[i][cur++] = (fixedCarrierPaths[i][j] + 4)%8;
                }
            }
            fixedCarrierLen[i] = cur;
        }
        int turnCount = 0;
        while(true){
            turnCount += 1;
            try {
                if(fixedCarrierPaths.length > 0){
                    if(fixedCarrierCnt[curCarrier] > 0){
                        int x = rc.readSharedArray(myId);
                        if(getJob(x) == 0 && rc.canBuildRobot(RobotType.CARRIER, rc.getLocation().add(directions[fixedCarrierPaths[curCarrier][0]]))){
                            rc.writeSharedArray(myId, (x & ((1 << 13) - 1)) ^ (1 << 13));
                            for(int j = 1; j < fixedCarrierLen[curCarrier]; j++){
                                x = rc.readSharedArray(4 + j - 1);
                                x = x & (((1 << 16) - 1) ^ (((1 << 3) - 1) << (myId*3)));
                                rc.writeSharedArray(4 + j - 1, x ^ (fixedCarrierPaths[curCarrier][j] << (myId*3)));
                            }
                            rc.buildRobot(RobotType.CARRIER, rc.getLocation().add(directions[fixedCarrierPaths[curCarrier][0]]));
                            fixedCarrierCnt[curCarrier]--;
                            curCarrier++;
                            curCarrier %= fixedCarrierPaths.length;
                        }
                    } else {
                        curCarrier++;
                        curCarrier %= fixedCarrierPaths.length;
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

    static int getTotalResource(RobotController rc){
        return rc.getResourceAmount(ResourceType.ADAMANTIUM) + rc.getResourceAmount(ResourceType.MANA) + rc.getResourceAmount(ResourceType.ELIXIR); 
    }

    static void fixedCarrier(RobotController rc, int myHq) throws GameActionException {        
        Direction moves[] = new Direction[maxFixedCarrierMoves];
        MapLocation cur = rc.getLocation();
        MapLocation well = null;
        int movesLen = 0;
        do {
            int x = rc.readSharedArray(4 + movesLen);
            x = (x & (((1 << 3) - 1) << (3*myHq))) >> (3*myHq);
            moves[movesLen++] = directions[x];
            cur = cur.add(directions[x]);
        } while(!cur.equals(rc.getLocation()));
        int curMove = 0;
        while(true){
            turnCount += 1;
            int moved = 0;
            if(rc.senseWell(rc.getLocation()) != null){
                well = rc.getLocation();
            }
            try {
                if(rc.isActionReady()){
                    MapLocation pos = rc.getLocation();
                    if(getTotalResource(rc) >= 5){
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
                if(rc.canMove(moves[curMove])){
                    if(well != null && rc.getLocation().isAdjacentTo(well) && !rc.getLocation().add(moves[curMove]).isAdjacentTo(well) && getTotalResource(rc) < 40) continue;
                    rc.move(moves[curMove]);
                    moved++;
                    curMove++;
                    curMove %= movesLen;
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

    static void runCarrier(RobotController rc) throws GameActionException { 
        int myHq = -1; 
        for(int i = 0; i < 8; i++){
            RobotInfo nxt = rc.senseRobotAtLocation(rc.getLocation().add(directions[i]));
            if(nxt != null && nxt.getType() == RobotType.HEADQUARTERS){
                myHq = nxt.getID();
            }
        }
        myHq = myHq/2 - 1;
        rc.setIndicatorString(String.valueOf(myHq));
        int job = rc.readSharedArray(myHq);
        rc.writeSharedArray(myHq, job & ((1 << 13) - 1));
        if(((job >> 13) & 1) == 1){
            fixedCarrier(rc, myHq);
        } else {

        } 
    }
}
