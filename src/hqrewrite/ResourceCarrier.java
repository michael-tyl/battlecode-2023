package hqrewrite;

import battlecode.common.*;

import java.util.*;

public class ResourceCarrier extends Pathfinding {

    MapLocation wells[]; //well positions
    ResourceType wellTypes[]; //well types for each position
    MapLocation hqs[]; //hq positions
    int prvWellVis[]; //previous turn checked well
    int prvHqVis[];
    boolean collecting; //collecting from well
    boolean foundWell; //found the well
    boolean foundHome; //found the base
    boolean goingHome; //going home
    int targetWellId; //target well id
    int targetHqId; //target hq id
    int turnCount;
    Communication comms = new Communication(rc);


    void updateData() throws GameActionException{
        wells = comms.getWells();
        wellTypes = comms.getWellTypes();
        int tmp[] = prvWellVis;
        prvWellVis = new int[wells.length];
        for(int i = 0; i < tmp.length; i++) prvWellVis[i] = tmp[i];
    }

    int closestWell(ResourceType tarResource) throws GameActionException{
        int ret = -1;
        for(int i = 0; i < wells.length; i++){
            if(prvWellVis[i] == 0 || prvWellVis[i] + 20 <= turnCount){
                if(wellTypes[i] == tarResource){
                    if(ret == -1){
                        ret = i;
                    } else if(rc.getLocation().distanceSquaredTo(wells[i]) 
                            < rc.getLocation().distanceSquaredTo(wells[ret])){
                        ret = i;
                    }
                }
            }
        }
        if(ret == -1){
            for(int i = 0; i < wells.length; i++){
                if(prvWellVis[i] == 0 || prvWellVis[i] + 20 <= turnCount){
                    if(ret == -1){
                        ret = i;
                    } else if(rc.getLocation().distanceSquaredTo(wells[i]) < rc.getLocation().distanceSquaredTo(target)){
                        ret = i;
                    }
                }
            }
        }
        return ret;
    }

    int closestHq() throws GameActionException{
        int ret = -1;
        int dist = 2000;
        for(int i = 0; i < hqs.length; i++){
            if(ret == -1){
                ret = i;
                dist = Math.min(5, turnCount - prvHqVis[i]);
            } else if(Math.min(5, turnCount - prvHqVis[i]) < dist){
                ret = i;
                dist = Math.min(5, turnCount - prvHqVis[i]);
            } else if(Math.min(5, turnCount - prvHqVis[i]) == dist 
                && rc.getLocation().distanceSquaredTo(hqs[i]) < rc.getLocation().distanceSquaredTo(hqs[ret])){ 
                ret = i;
                dist = Math.min(5, turnCount - prvHqVis[i]);
            }
        } 
        return ret;
    }

    ResourceCarrier(RobotController rc_) throws GameActionException{
        super(rc_);
        prvWellVis = new int[0];
        updateData();
        hqs = comms.getHqs();
        prvHqVis = new int[hqs.length];
        collecting = false;
        foundWell = false;
        goingHome = false;
        foundHome = false;
        turnCount = 0;
    }

    MapLocation closestAdjacent(MapLocation tar) throws GameActionException{
        if(rc.getLocation().isAdjacentTo(tar)) return rc.getLocation();
        MapLocation ret = null;
        for(int i = 0; i < 8; i++){
            MapLocation loc = tar.add(RobotPlayer.directions[i]);
            if(rc.canSenseLocation(loc) && 
                    !rc.canSenseRobotAtLocation(loc) && rc.senseMapInfo(loc).isPassable()){
                if(ret == null){
                    ret = loc;
                } else if(rc.getLocation().distanceSquaredTo(loc) < rc.getLocation().distanceSquaredTo(ret)){
                    ret = loc;
                }
            }
        }
        return ret;
    }

    void updateTargetWell(ResourceType tarResource) throws GameActionException{
        MapLocation nxtTar = closestAdjacent(wells[targetWellId]);
        if(nxtTar != null){
            foundWell = true;
            target = nxtTar;
        } else {
            foundWell = false;
            prvWellVis[targetWellId] = turnCount;
            updateData();
            int nxtWell = closestWell(tarResource);
            if(nxtWell == -1){
                ScoutCarrier carrier = new ScoutCarrier(rc);
                carrier.run();
            } else {
                targetWellId = nxtWell;
                target = wells[nxtWell];
            }
        }
    }

    void updateTargetHq() throws GameActionException{
        MapLocation nxtTar = closestAdjacent(hqs[targetHqId]);
        if(nxtTar != null){
            foundHome = true;
            target = nxtTar;
        } else {
            foundHome = false;
            prvHqVis[targetHqId] = turnCount;
            updateData();
            targetHqId = closestHq();
            target = hqs[targetHqId];
        }
    }

    void run(ResourceType tarResource) throws GameActionException{
        if(wells.length == 0) return;
        targetWellId = closestWell(tarResource); 
        targetHqId = closestHq();
        target = wells[targetWellId];
        while(true){
            turnCount += 1;
            try { 
                if(target == null) rc.setIndicatorString("no target");
                else rc.setIndicatorString(String.valueOf(target.x) + " " + String.valueOf(target.y));
                for(int t = 0; t < 2; t++){
                    if(rc.getWeight() >= 5){
                        RobotInfo targets[] = rc.senseNearbyRobots(rc.getType().actionRadiusSquared, rc.getTeam().opponent());
                        RobotInfo lowestId = null;
                        for(int i = 0; i < targets.length; i++){
                            if(targets[i].getType() != RobotType.HEADQUARTERS){
                                if(lowestId == null) lowestId = targets[i];
                                else if(targets[i].getID() < lowestId.getID()) lowestId = targets[i];
                            }
                        }
                        if(lowestId != null && rc.canAttack(lowestId.getLocation())){
                            rc.attack(lowestId.getLocation());
                        }
                    }
                    if(collecting){
                        int dif = 39 - rc.getWeight();
                        if(dif > 0){
                            if(rc.canCollectResource(wells[targetWellId], 1)){
                                rc.collectResource(wells[targetWellId], 1);
                            }
                            continue;
                        } else {
                            collecting = false;
                            foundWell = false;
                            goingHome = true;
                            target = hqs[targetHqId];
                        }
                    }
                    if(!goingHome){
                        if(!foundWell){
                            if(rc.canSenseLocation(target)){
                                updateTargetWell(tarResource); 
                            }
                        }
                        if(foundWell){
                            if(rc.getLocation().equals(target)){
                                collecting = true;
                                break;
                            }
                            if(rc.canSenseLocation(target) && (rc.canSenseRobotAtLocation(target) 
                                    || !rc.senseMapInfo(target).isPassable())){                        
                                updateTargetWell(tarResource);
                            }   
                        }
                    } else {
                        if(!foundHome){
                            if(rc.canSenseLocation(target)){
                                updateTargetHq();
                            }
                        }
                        if(foundHome){
                            if(rc.getLocation().equals(target)){
                                while(rc.getWeight() > 0){
                                    while(!rc.canTransferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, 1) && 
                                        !rc.canTransferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, 1) &&
                                            !rc.canTransferResource(hqs[targetHqId], ResourceType.MANA, 1)){
                                        Clock.yield();
                                    }
                                    if(rc.getResourceAmount(ResourceType.ADAMANTIUM) > 0){
                                        rc.transferResource(hqs[targetHqId], ResourceType.ADAMANTIUM, rc.getResourceAmount(ResourceType.ADAMANTIUM));
                                    } else if(rc.getResourceAmount(ResourceType.MANA) > 0){
                                        rc.transferResource(hqs[targetHqId], ResourceType.MANA, rc.getResourceAmount(ResourceType.MANA));
                                    } else if(rc.getResourceAmount(ResourceType.ELIXIR) > 0){
                                        rc.transferResource(hqs[targetHqId], ResourceType.ELIXIR, rc.getResourceAmount(ResourceType.ELIXIR));
                                    }
                                }
                                foundHome = false;
                                goingHome = false;
                                updateTargetHq();
                                target = wells[targetWellId];
                            }
                            if(rc.canSenseLocation(target) && (rc.canSenseRobotAtLocation(target) 
                                    || !rc.senseMapInfo(target).isPassable())){                        
                                updateTargetHq();
                            }
                        }
                    }
                    move();
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

