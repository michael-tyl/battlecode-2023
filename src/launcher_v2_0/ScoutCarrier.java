package launcher_v2_0;

import battlecode.common.*;

import java.util.*;

public class ScoutCarrier extends Pathfinding {

    MapLocation hqs[]; //hq positions
    int targetHqId; //target hq id
    boolean goingHome; //going home
    int turnCount;
    Communication comms = new Communication(rc);

    int closestHq() throws GameActionException{
        int ret = -1;
        for(int i = 0; i < hqs.length; i++){
            if(ret == -1){
                ret = i;
            } else if(rc.getLocation().distanceSquaredTo(hqs[i]) < rc.getLocation().distanceSquaredTo(hqs[ret])){ 
                ret = i;
            }
        } 
        return ret;
    }

    ScoutCarrier(RobotController rc_) throws GameActionException{
        super(rc_);
        hqs = comms.getHqs();
        goingHome = false;
        turnCount = 0;
    }

    void run() throws GameActionException{
        System.out.println("new scout");
        targetHqId = closestHq();
        Direction normalDir = Direction.CENTER; 
        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(-1, rc.getTeam()); 
        for (int i = 0; i < nearbyRobots.length; i++) {
            if (nearbyRobots[i].getType() == RobotType.HEADQUARTERS && nearbyRobots[i].getTeam() == rc.getTeam()) {
                normalDir = rc.getLocation().directionTo(nearbyRobots[i].getLocation()).opposite();
                break;
            }
        }
        WellInfo wells[] = new WellInfo[0];
        while(true){
            turnCount += 1;
            try { 
                WellInfo[] nearbyWells = rc.senseNearbyWells();
                for (int i = 0; i < nearbyWells.length; i++) {
                    if (!comms.wellExists(nearbyWells[i]) && nearbyWells[i].getResourceType() == ResourceType.MANA) {
                        wells = nearbyWells;
                        goingHome = true;
                        target = hqs[closestHq()];
                        break;
                    }
                }
                if(goingHome){
                    if(rc.canWriteSharedArray(0, 0)){
                        for(int i = 0; i < wells.length; i++){
                            comms.addWell(wells[i]);
                        }
                        ResourceCarrier carrier = new ResourceCarrier(rc);
                        if(rng.nextBoolean()) carrier.run(ResourceType.ADAMANTIUM);
                        else carrier.run(ResourceType.MANA);
                    }
                    move();
                } else {
                    for (int i = 0; i < 2; i++) {
                        while (!rc.canMove(normalDir))
                            normalDir = normalDir.rotateRight();
                        rc.move(normalDir);
                        if (rng.nextBoolean())
                            normalDir = normalDir.rotateRight();
                        rc.setIndicatorString(normalDir.name() + " | move in normal direction");
                    }
                }
            } catch(GameActionException e){
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

