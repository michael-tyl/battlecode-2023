package heuristic_miner;

import battlecode.common.*;

import java.util.*;
import java.math.*;

public strictfp class RobotPlayer {

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

    static private class Comms {

        static final int wellCap = 13;

        //Sets the position stored at ind to v
        static void setPos(RobotController rc, int ind, int v) throws GameActionException{
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, (x & ((1 << 16) - 1) ^ ((1 << 12) - 1)) + v);
        }

        //Gets the position stored at ind
        static int getPos(RobotController rc, int ind) throws GameActionException{
            int x = rc.readSharedArray(ind);
            return x & ((1 << 12) - 1);
        }

        //Hashes (x, y) into an int
        static int hashPos(int x, int y){
            return x*60 + y + 1;
        } 

        //Sets the job stored at ind to v [0, 15]
        static void setJob(RobotController rc, int ind, int v) throws GameActionException {
            int x = rc.readSharedArray(ind);
            rc.writeSharedArray(ind, (x & ((1 << 12) - 1)) + (v << 11));
        }

        //Returns array of wells stored in the shared data
        static MapLocation[] getWells(RobotController rc) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0) cur++;
            MapLocation ret[] = new MapLocation[cur];
            for(int i = 0; i < cur; i++){
                int x = getPos(rc, 4 + cur);
                ret[i] = new MapLocation((x - 1)/60, (x - 1)%60);
            }
            return ret;
        }

        //Adds a well to the shared data
        static void addWell(RobotController rc, int v) throws GameActionException {
            int cur = 0;
            while(getPos(rc, 4 + cur) > 0){
                if(getPos(rc, 4 + cur) == v) return;
                cur++;
            }
            if(cur == 13) return;
            setPos(rc, cur, v);
        }

        //Gets the job of the robot at spawn
        static int getJob(RobotController rc) throws GameActionException, Exception {
            int ret = -1; 
            for(int i = 2; i <= 9; i++){
                if(rc.canSenseRobot(i)){
                    int x = rc.readSharedArray(i/2 - 1);
                    if(x > 0) ret = x;
                }
            }
            if(ret == -1) throw new Exception("Did not receive a Job");
            return ret/2 - 1;
        }
    }

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {

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

    static void runHeadquarters(RobotController rc) throws GameActionException {
        int myId = rc.getID()/2 - 1;
        int myX = rc.getLocation().x, myY = rc.getLocation().y;
        WellInfo wells[] = rc.senseNearbyWells();
        rc.writeSharedArray(myId, myX*60 + myY);
        System.out.println(Clock.getBytecodesLeft());
        while(true){
            /*try {
                
            } catch (GameActionException e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } finally {
                Clock.yield();
            }*/
            Clock.yield();
        }
    }

    static int getTotalResource(RobotController rc){
        return rc.getResourceAmount(ResourceType.ADAMANTIUM) + rc.getResourceAmount(ResourceType.MANA) + rc.getResourceAmount(ResourceType.ELIXIR); 
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