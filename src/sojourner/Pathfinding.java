// package sojourner;

// import battlecode.common.*;

// import java.util.HashSet;

// public class Pathfinding {

//     static RobotController rc;
//     static MapLocation target = null;
//     static double avgRubbleCost = 10;
//     static boolean[] impassable = null;

//     static final Direction[] directions = {
//         Direction.NORTH,
//         Direction.NORTHEAST,
//         Direction.EAST,
//         Direction.SOUTHEAST,
//         Direction.SOUTH,
//         Direction.SOUTHWEST,
//         Direction.WEST,
//         Direction.NORTHWEST,
//         Direction.CENTER
//     };

//     public static void init(RobotController _rc) {
//         rc = _rc;
//         BugNavigator.rotateRight = Math.random() > 0.5;
//     }

//     static void setImpassableArray(boolean[] _impassable) { impassable = _impassable; }

//     static void initTurn() {
//         impassable = new boolean[directions.length];
//     }

//     static boolean canMove(Direction dir){
//         if (!rc.canMove(dir)) 
//         	return false;
//         if (impassable[dir.ordinal()]) 
//         	return false;
//         return true;
//     }

//     static double getEstimation(MapLocation loc){
//         try {
//             if (loc.distanceSquaredTo(target) == 0) return 0;
//             int d = Util.distance(target, loc);
//             double r = 1 + rc.senseRubble(loc) / 10;
//             return r + (d - 1) * avgRubbleCost;
//         } catch (Throwable e){
//             e.printStackTrace();
//         }
//         return 1e9;
//     }

//     static public void move(MapLocation loc){
//         if (!rc.isMovementReady()) 
//         	return;
//         target = loc;
//         if (!BugNavigator.move()) 
//         	greedyPath();
//         BugNavigator.move();
//     }

//     static final double EPS = 1e-5;

//     static void greedyPath() {
//         try {
//             boolean hasMoved = false;
//             Direction optimalDirection = currentPosition.directionTo(target);
//             MapInfo optimalSquareInfo = rc.senseMapInfo(currentPosition.add(optimalDirection));
//             RobotInfo blockingRobot = rc.senseRobotAtLocation(currentPosition.add(optimalDirection));

//             if(optimalSquareInfo.isPassable() && blockingRobot == null){
//                 Direction optimalSquareCurrentDirection = optimalSquareInfo.getCurrentDirection();
//                 if(optimalSquareCurrentDirection == Direction.CENTER){
//                     rc.move(optimalDirection);
//                     hasMoved = true;
//                 } else if (optimalSquareCurrentDirection == optimalDirection || 
//                         optimalSquareCurrentDirection == optimalDirection.rotateRight() ||
//                         optimalSquareCurrentDirection == optimalDirection.rotateLeft()){
//                     rc.move(optimalDirection);
//                     hasMoved = true;
//                 }
//             } 
//             if(!hasMoved){
//                 if(blockingRobot != null){ // if robot, wait or pathfind around
//                     if(rc.canMove(optimalDirection.rotateLeft())){
//                         rc.move(optimalDirection.rotateLeft());
//                         hasMoved = true;
//                     } else if (rc.canMove(optimalDirection.rotateRight())){
//                         rc.move(optimalDirection.rotateRight());
//                         hasMoved = true;
//                     } else if(rc.getType() == RobotType.CARRIER){
//                         if(rc.canMove(optimalDirection.rotateLeft().rotateLeft())){
//                             rc.move(optimalDirection.rotateLeft().rotateLeft());
//                             hasMoved = true;
//                         } else if (rc.canMove(optimalDirection.rotateRight().rotateRight())){
//                             rc.move(optimalDirection.rotateRight().rotateRight());
//                             hasMoved = true;
//                         }
//                     }
//                 } else {
//                     Direction optimalCardinalDirection;
//                     if (optimalDirection.getDeltaX() != 0 && optimalDirection.getDeltaY() != 0){
//                         if(rng.nextBoolean()){
//                             optimalCardinalDirection = optimalDirection.rotateLeft();
//                         } else {
//                             optimalCardinalDirection = optimalDirection.rotateRight();
//                         }
//                     } else {
//                         optimalCardinalDirection = optimalDirection;
//                     }
//                     trackingObstacle = true;
//                     if(rng.nextBoolean()){
//                         movingDirection = optimalCardinalDirection.rotateLeft().rotateLeft();
//                         traversingClockwise = true;
//                     } else {
//                         movingDirection = optimalCardinalDirection.rotateRight().rotateRight();
//                         traversingClockwise = false;
//                     }
//                 }
//             }
//         } catch (Exception e){
//             e.printStackTrace();
//         }
//     }

//     static boolean strictlyCloser(MapLocation newLoc, MapLocation oldLoc, MapLocation target){
//         int dOld = Util.distance(target, oldLoc), dNew = Util.distance(target, newLoc);
//         if (dOld < dNew) return false;
//         if (dNew < dOld) return true;
//         return target.distanceSquaredTo(newLoc) < target.distanceSquaredTo(oldLoc);
//     }

//     static class BugNavigator {
//         static final int INF = 1000000;

//         static boolean rotateRight = true; 			 		// rotation direction
//         static MapLocation lastObstacleFound = null;  		// location of most rescent seen obstacle
//         static int minDistToEnemy = INF; 		     		// min distance to the enemy while navigating around obstacle
//         static int minDistanceToTarget = INF;         		// min acceptable distance to target (e.g. 2 for wells, 0 for anchors, etc.)
//         static MapLocation prevTarget = null;      			// previous target (to cache results in case of repeated movements)
//         static HashSet<Integer> visited = new HashSet<>();

//         static boolean move() {
//             try {
//                 if (prevTarget == null || target.distanceSquaredTo(prevTarget) > 0) 
//                 	resetPathfinding();

//                 //If I'm at a minimum distance to the target, I'm free!
//                 MapLocation myLoc = rc.getLocation();
//                 int d = myLoc.distanceSquaredTo(target);
//                 if (d <= minDistanceToTarget) 
//                 	resetPathfinding();

//                 int code = getCode();
//                 if (visited.contains(code)) 
//                 	resetPathfinding();
//                 visited.add(code);

//                 //Update data
//                 prevTarget = target;
//                 minDistToEnemy = Math.min(d, minDistToEnemy);

              
//                 Direction dir = myLoc.directionTo(target);
//                 if (lastObstacleFound != null) 
//                 	dir = myLoc.directionTo(lastObstacleFound);
//                 if (canMove(dir))
//                     resetPathfinding();

                
//                 for (int i = 8; i-- > 0;) {
//                     if (canMove(dir)) {
//                         rc.move(dir);
//                         return true;
//                     }
//                     MapLocation newLoc = myLoc.add(dir);
//                     if (!rc.onTheMap(newLoc)) 
//                     	rotateRight = !rotateRight;
//                     else 
//                     	lastObstacleFound = myLoc.add(dir);
//                     if (rotateRight) 
//                     	dir = dir.rotateRight();
//                     else 
//                     	dir = dir.rotateLeft();
//                 }

//                 if (canMove(dir)) 
//                 	rc.move(dir);
//             } catch (Exception e){
//                 e.printStackTrace();
//             }
//             return true;
//         }

//         /**
//          * Resets cached results of previous pathfinding query
//          */ 
//         static void resetPathfinding() {
//             lastObstacleFound = null;
//             minDistToEnemy = INF;
//             visited.clear();
//         }

//         /**
//          * Gets the hashed position of a state, accounting for the robots position, direction of 
//          * obstacle, and rotation direction. Used to store all visited states in a hash table.
//          */ 
//         static int getCode() {
//             int x = rc.getLocation().x;
//             int y = rc.getLocation().y;
//             Direction obstacleDir = rc.getLocation().directionTo(target);
//             if (lastObstacleFound != null) 
//             	obstacleDir = rc.getLocation().directionTo(lastObstacleFound);
//             int bit = rotateRight ? 1 : 0;
//             return (((((x << 6) | y) << 4) | obstacleDir.ordinal()) << 1) | bit;
//         }
//     }


// }