package hqrewrite;

import battlecode.common.*;

import java.util.*;

public class Launcher extends Pathfinding {
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
    
    // Tracks the previous target to follow if it goes out of range
    MapLocation prevTarget;
    MapLocation hqLoc;
    MapLocation enemyHQ;
    // Launchers don't move until in large enough group
    boolean active;
    int moveCount;

    // Count number of turns since last prevTarget refresh
    short lastRefresh;

    int turnCount;

    public Launcher(RobotController rc_, MapLocation hqL, MapLocation eHq) throws GameActionException{
        super(rc_);
        turnCount = 0;
        prevTarget = null;
        lastRefresh = 0;
        active = true;
        moveCount = 0;
        hqLoc = hqL;
        enemyHQ = eHq;
    }
    void run() throws GameActionException {
        int prevHealth = rc.getType().health;
        boolean prevEscape = false;
        while (true) {
            turnCount += 1;
            try {
                // Try to attack someone
                int radius = rc.getType().actionRadiusSquared;
                int vision = rc.getType().visionRadiusSquared;
                Team opponent = rc.getTeam().opponent();
                RobotInfo[] enemies = rc.senseNearbyRobots(vision, opponent);
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
                MapLocation target = null;
                int launcherID = 999999;
                int launcherHP = 999999;
                boolean launcher = false;
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
                        if (target == null 
                            || (enemies[curEnemy].getType() == RobotType.LAUNCHER && launcher == false)
                            || (enemies[curEnemy].getHealth() == launcherHP && enemies[curEnemy].getID() < launcherID && (enemies[curEnemy].getType() == RobotType.LAUNCHER || !launcher))
                            || (enemies[curEnemy].getHealth() < launcherHP && (enemies[curEnemy].getType() == RobotType.LAUNCHER || !launcher))) {
                            target = toAttack;
                            if (enemies[curEnemy].getType() == RobotType.LAUNCHER) launcher = true;
                            launcherHP = enemies[curEnemy].getHealth();
                            launcherID = enemies[curEnemy].getID();
                        }
                    } else {
                        dir = curLoc.directionTo(toAttack);
                        prevTarget = toAttack;
                        lastRefresh = 0;
                        rc.setIndicatorString("Chasing enemy in vision");
                    }
                    curEnemy++;
                }


                
                
                // TODO: Better criteria than lowest ID
                // Current form is worse than v0.3, currently not used to set direction
                // boolean leader = true;

                int launcherCount = 1;
                int xSum = curLoc.x;
                int ySum = curLoc.y;
                RobotInfo[] closeFriendlies = rc.senseNearbyRobots(vision-12, rc.getTeam());
                for (int i = 0; i < friendlies.length; i++) {
                    if (friendlies[i].getType() != RobotType.LAUNCHER) continue;
                    launcherCount++;
                    // Activate in groups of at least x size
                    if (launcherCount >= RobotPlayer.activeThreshold(turnCount)) {
                        active = true;
                    }
                    xSum += friendlies[i].getLocation().x;
                    ySum += friendlies[i].getLocation().y;
                }
                int lcount2 = 1;
                for (int i = 0; i < closeFriendlies.length; i++) {
                    if (closeFriendlies[i].getType() != RobotType.LAUNCHER) continue;
                    lcount2++;
                    // Activate in groups of at least x size
                    if (lcount2 >= RobotPlayer.activeThreshold(turnCount)) {
                        active = true;
                    }
                }
                xSum /= launcherCount;
                ySum /= launcherCount;
                MapLocation centerMass = new MapLocation(xSum, ySum);

                Direction enemyHQDir = centerMass.directionTo(enemyHQ);
                centerMass = centerMass.add(enemyHQDir);
                MapLocation oldCM = centerMass.add(enemyHQDir);
                rc.setIndicatorString("Center mass target: " + centerMass.toString());
                centerMass = centerMass.add(enemyHQDir);

                // if (!leader && !chase) {
                //     dir = curLoc.directionTo(centerMass);
                // }

                
                // Try moving towards center of mass shifted towards enemy HQ
                if (dir == null) {
                    dir = curLoc.directionTo(centerMass);
                }

                // Move towards HQ if health decreased
                boolean escape = false;
                int numEnemyLaunchers = 0;
                int hp2 = 0;
                RobotInfo[] enemies2 = rc.senseNearbyRobots(vision, opponent);
                
                int xSum2 = curLoc.x;
                int ySum2 = curLoc.y;
                for (int i = 0; i < enemies2.length; i++) {
                    if (enemies2[i].getType() == RobotType.LAUNCHER) {
                        numEnemyLaunchers++;
                        hp2 = enemies2[i].getHealth();
                        xSum2 += enemies2[i].getLocation().x;
                        ySum2 += enemies2[i].getLocation().y;
                    }
                }
                xSum2 /= (numEnemyLaunchers+1);
                ySum2 /= (numEnemyLaunchers+1);
                Direction toCenter = curLoc.directionTo(centerMass);
                Direction toEnemy = curLoc.directionTo(new MapLocation(xSum2,ySum2));
                boolean needToReturn = toCenter == toEnemy || toCenter.rotateLeft() == toEnemy || toCenter.rotateLeft().rotateLeft() == toEnemy
                                                        || toCenter.rotateRight() == toEnemy || toCenter.rotateRight().rotateRight() == toEnemy;
                needToReturn = !needToReturn;
                if (toEnemy == Direction.CENTER || toCenter == Direction.CENTER || curLoc.directionTo(oldCM) == Direction.CENTER) needToReturn = false;
                // if (turnCount > 100) needToReturn = false;
                if (rc.getHealth() < prevHealth || numEnemyLaunchers > launcherCount + 1 || needToReturn || (numEnemyLaunchers >= 1 && launcherCount == 1 && hp2 > rc.getHealth())) {
                    dir = curLoc.directionTo(hqLoc);
                    if (target != null) rc.attack(target);
                    rc.setIndicatorString("Escaping" + numEnemyLaunchers + launcherCount + toCenter + toEnemy);
                    escape = true;
                    prevEscape = true;
                } else if (prevEscape) {
                    prevEscape = false;
                    dir = curLoc.directionTo(hqLoc);
                    if (target != null) rc.attack(target);
                    rc.setIndicatorString("Escaping");
                    escape = true;
                }
                prevHealth = rc.getHealth();

                int lim = 11;
                int lim2 = 24;
                int numFriendlies = RobotPlayer.countNumFriendlies(rc);
                if (turnCount < lim) {
                    if ((rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud");
                        dir = dir.rotateLeft();

                    }
                    if ((rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud");
                        dir = dir.rotateRight();
                        dir = dir.rotateRight();
                    }
                    if (rc.senseMapInfo(curLoc.add(dir)).hasCloud()) dir = dir.rotateLeft();
                    if (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && numFriendlies > 1) dir = Direction.CENTER;
                } else if (turnCount < lim2) {
                    if (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && numFriendlies > 1) dir = Direction.CENTER;
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateLeft();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateLeft();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateRight();
                        dir = dir.rotateRight();
                        dir = dir.rotateRight();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateRight();
                    }
                } else {
                    // Try avoiding clouds
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateLeft();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateLeft();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateRight();
                        dir = dir.rotateRight();
                        dir = dir.rotateRight();
                    }
                    if (!rc.canMove(dir) || (rc.senseMapInfo(curLoc.add(dir)).hasCloud() && !rc.senseMapInfo(curLoc).hasCloud())) {
                        rc.setIndicatorString("Avoiding cloud or barrier");
                        dir = dir.rotateRight();
                    }

                    // Try moving randomly
                    int j = 0;
                    while (!rc.canMove(dir) && j < 20) {
                        dir = directions[rng.nextInt(directions.length)];

                        j++;
                    }

                }
                

                // Move x times to prevent crowding HQ
                if ((moveCount < rc.getMapHeight() / 6 || active || rc.senseMapInfo(curLoc).hasCloud()) && rc.canMove(dir)) {
                    rc.move(dir);
                    moveCount++;
                }

                if (!escape) {
                    // Identify new target after moving
                    curEnemy = 0;
                    while (curEnemy < enemies.length) {
                        MapLocation toAttack = enemies[curEnemy].location;

                        if (enemies[curEnemy].type == RobotType.HEADQUARTERS) {
                            curEnemy++;
                            dir = curLoc.directionTo(toAttack);
                            continue;
                        }

                        // MapLocation toAttack = rc.getLocation().add(Direction.EAST);
                        if (rc.canAttack(toAttack)) {
                            if (target == null 
                                || (enemies[curEnemy].getType() == RobotType.LAUNCHER && launcher == false)
                                || (enemies[curEnemy].getHealth() == launcherHP && enemies[curEnemy].getID() < launcherID && (enemies[curEnemy].getType() == RobotType.LAUNCHER || !launcher))
                                || (enemies[curEnemy].getHealth() < launcherHP && (enemies[curEnemy].getType() == RobotType.LAUNCHER || !launcher))) {
                                target = toAttack;
                                if (enemies[curEnemy].getType() == RobotType.LAUNCHER) launcher = true;
                                launcherHP = enemies[curEnemy].getHealth();
                                launcherID = enemies[curEnemy].getID();
                            }
                        } else {
                            dir = curLoc.directionTo(toAttack);
                            prevTarget = toAttack;
                            lastRefresh = 0;
                        }
                        curEnemy++;
                    }

                    // Attack after moving
                    if (target != null) {    
                        rc.attack(target);

                        if (rc.canSenseLocation(target) && rc.senseRobotAtLocation(target) == null) {
                            if (curEnemy+1 >= enemies.length) {
                                prevTarget = null;
                                dir = directions[rng.nextInt(directions.length)];
                            } else {
                                prevTarget = enemies[curEnemy-1].getLocation();
                            }
                        } else {
                            dir = curLoc.directionTo(target);
                            chase = true;
                            prevTarget = target;
                        }

                        lastRefresh = 0;
                    }
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