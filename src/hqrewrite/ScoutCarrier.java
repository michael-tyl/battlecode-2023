package hqrewrite;

import battlecode.common.*;

public class ScoutCarrier extends Pathfinding {

        int mapWidth, mapHeight;
        MapLocation hqs[]; //hq positions
        int targetHqId; //target hq id
        boolean goingHome; //going home
        int turnCount;
        Communication comms = new Communication(rc);

        int []visArray;

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
            mapWidth = rc_.getMapWidth();
            mapHeight = rc_.getMapHeight();
            visArray = new int[mapWidth * mapHeight];
        }
 
        void run() throws GameActionException{
            targetHqId = closestHq();
            Direction normalDir = Direction.CENTER; 
            RobotInfo[] nearbyRobots = rc.senseNearbyRobots(2, rc.getTeam()); 
            for (int i = 0; i < nearbyRobots.length; i++) {
                if (nearbyRobots[i].getType() == RobotType.HEADQUARTERS && nearbyRobots[i].getTeam() == rc.getTeam()) {
                    normalDir = rc.getLocation().directionTo(nearbyRobots[i].getLocation()).opposite();
                    break;
                }
            }
            WellInfo wells[] = new WellInfo[0];

            int segLength = 1;
            int disLength = 0;
            while(true){
                turnCount += 1;
                try { 
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
                        rc.setIndicatorString("resource scout | " + "going home");
                    } else {
                        for (int i = 0; i < 2; i++) {
                            WellInfo[] nearbyWells = rc.senseNearbyWells();
                            if (nearbyWells.length > 0) {
                                for (int j = 0; j < nearbyWells.length; j++) {
                                    if (!comms.wellExists(nearbyWells[j])) {
                                        wells = nearbyWells;
                                        goingHome = true;
                                        target = hqs[closestHq()];
                                        break;
                                    }
                                }
                                if (goingHome)
                                    continue;
                            }

                            MapLocation myLoc = rc.getLocation();
                            visArray[myLoc.x + mapWidth * myLoc.y]++;
                            int curLim = 0;
                            while (true) {
                                curLim++;
                                if (!rc.canMove(normalDir)) {
                                    normalDir = normalDir.rotateRight();
                                    continue;
                                } 
                                MapLocation newLoc = myLoc.add(normalDir);
                                if (visArray[newLoc.x + newLoc.y * mapWidth] >= curLim) {
                                    normalDir = normalDir.rotateRight();
                                    continue;
                                }
                                break;
                            }
                            rc.move(normalDir);
                            disLength++;
                            if (disLength >= segLength) {
                                normalDir = normalDir.rotateRight();
                                disLength = 0;
                                segLength++;
                            }
                            rc.setIndicatorString("resource scout | " + normalDir.name() + " | " + disLength + " | " + segLength);
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