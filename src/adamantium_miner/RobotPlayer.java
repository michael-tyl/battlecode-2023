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

    static ArrayList<Integer> findConveyerBelt(RobotController rc) throws GameActionException{
        int n = rc.getMapWidth(), m = rc.getMapHeight();
        MapInfo mapData[][] = new MapInfo[n][m];
        MapInfo visible[] = rc.senseNearbyMapInfos();
        int type[][] = new int[n][m];
        int hx = rc.getLocation().x, hy = rc.getLocation().y;
        int cnt = 0;
        MapLocation well = rc.getLocation();
        int dist = 1000000000;
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
        int wx = well.x, wy = well.y;
        Direction dir = rc.getLocation().directionTo(well);
        for(int i = 0; i < 8; i++){
            MapLocation nxt = well.add(directions[i]);
            if(rc.canSenseLocation(nxt) && type[nxt.x][nxt.y] != 0){
                type[nxt.x][nxt.y] = 2;
            }
        }
        MapLocation q[] = new MapLocation[cnt];
        boolean vis[][] = new boolean[n][m];
        int l = 0, r = 1;
        q[0] = rc.getLocation();
        vis[hx][hy] = true;
        while(l < r){
            l++;
            if(type[q[l - 1].x][q[l - 1].y] == 2) break;
            for(int i = 0; i < 8; i++){
                MapLocation nxt = q[l - 1].add(directions[i]);
                if(rc.canSenseLocation(nxt) && type[nxt.x][nxt.y] != 0 && !vis[nxt.x][nxt.y]){
                    vis[nxt.x][nxt.y] = true;
                    q[r++] = nxt;
                }
            }
        }
        System.out.println(Clock.getBytecodesLeft());
        return null;
    }

    /**
     * Run a single turn for a Headquarters.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runHeadquarters(RobotController rc) throws GameActionException {
        System.out.println(Clock.getBytecodesLeft());
        //findConveyerBelt(rc);
        int moves[] = {1, 1, 1, 8, 7, 7, 4, 6, 3, 2, 5, 5, 4};
        for(int i = 0; i < moves.length; i++) rc.writeSharedArray(i + 1, moves[i]);
        int cnt = 10;
        while(true){
            if(cnt > 0 && rc.canBuildRobot(RobotType.CARRIER, rc.getLocation().add(directions[0]))){
                rc.writeSharedArray(0, 1);
                rc.buildRobot(RobotType.CARRIER, rc.getLocation().add(directions[0]));
                cnt--;
            }
            Clock.yield();
        }
    }

    static void fixedCarrier(RobotController rc) throws GameActionException {        
        int cur = 0;
        ArrayList<Direction> moves = new ArrayList<Direction>();
        int index = 1;
        int parse = rc.readSharedArray(index);
        while((parse & 15) != 0){
            moves.add(directions[(parse & 15) - 1]);
            parse = rc.readSharedArray(++index);
        }
        while (true) {
            turnCount += 1;
            try {
                if(rc.isMovementReady()){
                    if(rc.canMove(moves.get(cur))){
                        rc.move(moves.get(cur));
                        cur++;
                        cur %= moves.size();
                    }
                }
                if(rc.isActionReady()){
                    MapLocation pos = rc.getLocation();
                    for(int i = 0; i < 8; i++){
                        MapLocation nxt = pos.add(directions[i]);
                        if(rc.canSenseRobotAtLocation(nxt) && rc.senseRobotAtLocation(nxt).type == RobotType.HEADQUARTERS && rc.getResourceAmount(ResourceType.ADAMANTIUM) > 0){
                            rc.transferResource(nxt, ResourceType.ADAMANTIUM, rc.getResourceAmount(ResourceType.ADAMANTIUM));
                            break;
                        }
                        if(rc.canSenseRobotAtLocation(nxt) && rc.senseRobotAtLocation(nxt).type == RobotType.HEADQUARTERS && rc.getResourceAmount(ResourceType.MANA) > 0){
                            rc.transferResource(nxt, ResourceType.MANA, rc.getResourceAmount(ResourceType.MANA));
                            break;
                        }
                        if(rc.canCollectResource(nxt, -1)){
                            rc.collectResource(nxt, -1);
                            break;
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
     * Run a single turn for a Carrier.
     * This code is wrapped inside the infinite loop in run(), so it is called once per turn.
     */
    static void runCarrier(RobotController rc) throws GameActionException {
        int job = rc.readSharedArray(0);
        rc.writeSharedArray(0, job ^ (job & 3));
        if((job & 3) == 1){
            fixedCarrier(rc);
        } else {

        } 
    }
}
