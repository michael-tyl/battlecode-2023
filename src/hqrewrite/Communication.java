package hqrewrite;

import battlecode.common.*;

public class Communication {

    final static int FULLMASK = 65535;
    final static int HQS = 4;
    final static int WELLS = 8;
    final static int JOB_IND[] = {0, 12, 12, 12, 12};
    final static int JOB_L[] = {12, 12, 8, 4, 0};
    final static int JOB_R[] = {15, 15, 11, 7, 3};
    RobotController rc;

    Communication(RobotController rc_){
        rc = rc_;
    }

    int getRange(int l, int r, int ind) throws GameActionException {
        return (rc.readSharedArray(ind) >> l) & ((1 << (r - l + 1)) - 1);
    }

    void setRange(int l, int r, int ind, int v) throws GameActionException {
        int x = rc.readSharedArray(ind);
        x &= FULLMASK ^ (((1 << (r - l + 1)) - 1) << l);
        x |= v << l;
        rc.writeSharedArray(ind, x);
    }

    //Gets the position stored at ind
    MapLocation getPos(int ind) throws GameActionException{
        int x = getRange(0, 11, ind);
        return new MapLocation((x - 1)/60, (x - 1)%60);
    } 

    //Sets the position stored at ind
    void setPos(int ind, MapLocation v) throws GameActionException{
        rc.writeSharedArray(ind, v.x*60 + v.y + 1);
    } 

    //Returns array of wells stored in the shared data
    MapLocation[] getWells() throws GameActionException {
        int cur = 0;
        while(getRange(0, 11, HQS + cur) > 0) cur++;
        MapLocation ret[] = new MapLocation[cur];
        for(int i = 0; i < cur; i++){
            ret[i] = getPos(HQS + i);
        }
        return ret;
    }

    //Returns array of well types stored in the shared data
    //index should correspond with wells from getWells
    ResourceType[] getWellTypes() throws GameActionException {
        int cur = 0;
        while(getRange(0, 11, HQS + cur) > 0) cur++;
        ResourceType ret[] = new ResourceType[cur];
        for(int i = 0; i < cur; i++){
            int t = getRange(12, 13, HQS + i);
            if(t == 1){
                ret[i] = ResourceType.ADAMANTIUM;
            } else if(t == 2){
                ret[i] = ResourceType.MANA;
            } else if(t == 3){
                ret[i] = ResourceType.ELIXIR;
            }
        }
        return ret;
    }

    //Returns array of headquarters stored in the shared data
    MapLocation[] getHqs() throws GameActionException {
        int cur = 0;
        for(int i = 0; i < HQS; i++) if(getRange(0, 11, i) > 0) cur++;
        MapLocation ret[] = new MapLocation[cur];
        for(int i = 0; i < cur; i++){
            ret[i] = getPos(i);
        }
        return ret;
    }

    //Adds a well to the shared data
    void addWell(WellInfo v) throws GameActionException {
        int cur = 0;
        int x = v.getMapLocation().x*60 + v.getMapLocation().y + 1;
        while(true){
            int y = getRange(0, 11, HQS + cur);
            if(y == 0) break;
            if(y == x) return;
            cur++;
            if(cur == WELLS) break;
        }
        if(cur == WELLS) return;
        setRange(0, 11, 4 + cur, x);
        if(v.getResourceType() == ResourceType.ADAMANTIUM) setRange(12, 13, 4 + cur, 1);
        else if(v.getResourceType() == ResourceType.MANA) setRange(12, 13, 4 + cur, 2);
        else if(v.getResourceType() == ResourceType.ELIXIR) setRange(12, 13, 4 + cur, 3);
    }

    //Checks if a well exists in the data
    boolean wellExists(WellInfo v) throws GameActionException {
        int cur = 0;
        int x = v.getMapLocation().x*60 + v.getMapLocation().y + 1;
        while(true){
            int y = getRange(0, 11, 4 + cur);
            if(y == 0) break;
            if(y == x) return true;
            cur++;
            if(cur == WELLS) break;
        }
        return false;
    }

    int getNextJob(int hq) throws GameActionException {
        int size = JOB_IND.length - 1;
        for(int i = 0; i <= size; i++){
            int x = getRange(JOB_L[i], JOB_R[i], JOB_IND[i] + hq);
            if(x > 0){
                for(int j = i; j + 1 <= size; j++){
                    setRange(JOB_L[j], JOB_R[j], JOB_IND[j] + hq, getRange(JOB_L[j + 1], JOB_R[j + 1], JOB_IND[j + 1] + hq));
                }
                setRange(JOB_L[size], JOB_R[size], JOB_IND[size] + hq, 0);
                return x;
            }
        }
        return -1;
    }

    //Gets the job of the robot at spawn
    int getJob() throws GameActionException {
        for(int i = 2; i <= 9; i++){
            if(rc.canSenseRobot(i) && rc.senseRobot(i).getTeam() == rc.getTeam()){
                int hq = i/2 - 1;
                int ret = getNextJob(hq);
                if(ret > 0){
                    return ret;
                }
            }
        }
        return -1;
    }

    //Adds a job to hq job queue
    void addJob(int hq, int v) throws GameActionException {
        int size = JOB_IND.length - 1;
        for(int i = 0; i <= size; i++){
            int x = getRange(JOB_L[i], JOB_R[i], JOB_IND[i] + hq);
            if(x == 0){
                setRange(JOB_L[i], JOB_R[i], JOB_IND[i] + hq, v);
                return;
            }
        }
    }
}