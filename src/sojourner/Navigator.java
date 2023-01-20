// package sojourner;

// import battlecode.common.*;

// public class Navigator {
// 	static RobotController rc;

//     static MapLocation lastCurrLoc;
//     static MapLocation currentTarget;
//     static int closestDistanceToDest;
//     static int turnsSinceClosestDistanceDecreased;
//     static int turnsGreedy;

//     static void init(RobotController _rc) {
//         rc = _rc;
//         BFSUnrolled29.init(rc);
//         BFSUnrolled20.init(rc);
//         BFSUnrolled18.init(rc);
//         BFSUnrolled13.init(rc);
//         MapTracker.reset();
//         Pathfinding.init(rc);
//         closestDistanceToDest = Integer.MAX_VALUE;
//         turnsSinceClosestDistanceDecreased = 0;
//     }

//     /**
//      * Gets directions that may be on the path to an adjacent square to the current position
//      */ 
//     public static Direction[] getDirectionsToAdjacentSquares(MapLocation location) {
//         switch(rc.getLocation().directionTo(location)) {
//             case SOUTH:
//                 return new Direction[]{Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.SOUTHEAST, Direction.SOUTHWEST};
//             case NORTH:
//                 return new Direction[]{Direction.NORTH, Direction.EAST, Direction.WEST, Direction.NORTHEAST, Direction.NORTHWEST};
//             case EAST:
//                 return new Direction[]{Direction.EAST, Direction.NORTH, Direction.SOUTH, Direction.NORTHEAST, Direction.SOUTHEAST};
//             case WEST:
//                 return new Direction[]{Direction.WEST, Direction.NORTH, Direction.SOUTH, Direction.NORTHWEST, Direction.SOUTHWEST};
//             case NORTHEAST:
//                 return new Direction[]{Direction.NORTHEAST, Direction.NORTH, Direction.EAST};
//             case SOUTHEAST:
//                 return new Direction[]{Direction.SOUTHEAST, Direction.SOUTH, Direction.EAST};
//             case SOUTHWEST:
//                 return new Direction[]{Direction.SOUTHWEST, Direction.SOUTH, Direction.WEST};
//             case NORTHWEST:
//                 return new Direction[]{Direction.NORTHWEST, Direction.NORTH, Direction.WEST};
//             default:
//                 return new Direction[]{};
//         }
//     }

//     static Direction navigateTo(MapLocation dest) throws GameActionException {
//         if(!rc.isMovementReady())
//             return Direction.CENTER;

//         MapLocation currLoc = rc.getLocation();

//         if(currLoc.isAdjacentTo(dest))
//             return getBestDirBetterRubbleSquareAdjacentTo(dest);

//         if(!dest.equals(currentTarget)) {
//             currentTarget = dest;
//             closestDistanceToDest = currLoc.distanceSquaredTo(dest);
//             turnsSinceClosestDistanceDecreased = 0;
//         }

//         int dist = currLoc.distanceSquaredTo(dest);
//         if(dist < closestDistanceToDest) {
//             closestDistanceToDest = dist;
//             turnsSinceClosestDistanceDecreased = 0;
//         } else {
//             turnsSinceClosestDistanceDecreased++;
//         }
        
//         if(turnsSinceClosestDistanceDecreased >= 3) {
//             Debug.println(Debug.PATHFINDING, "BFS failed to get closer in two turns: Falling back to directionTo");
//             return currLoc.directionTo(dest);
//         } else {
//             Debug.println(Debug.PATHFINDING, "Doing BFS normally");
//         }
//         Direction dir = Nav.getBestDir(dest);
//         return dir == null ? Util.getFirstValidInOrderDirection(currLoc.directionTo(dest)) : dir;
//     }

//     public static Direction getBestDir(MapLocation dest) throws GameActionException {
//         return getBestDir(dest, 0);
//     }

//     public static Direction getBestDir(MapLocation dest, int bytecodeCushion) throws GameActionException {
//         int bcLeft = Clock.getBytecodesLeft();
//         if(bcLeft >= BFSUnrolled29.MIN_BC_TO_USE + bytecodeCushion && rc.getType().visionRadiusSquared >= 29) {
//             return BFSUnrolled29.getBestDir(dest);
//         } else if(bcLeft >= BFSUnrolled20.MIN_BC_TO_USE + bytecodeCushion) {
//             return BFSUnrolled20.getBestDir(dest);
//         } else if(bcLeft >= BFSUnrolled18.MIN_BC_TO_USE + bytecodeCushion) {
//             return BFSUnrolled18.getBestDir(dest);
//         } else if(bcLeft >= BFSUnrolled13.MIN_BC_TO_USE + bytecodeCushion) {
//             return BFSUnrolled13.getBestDir(dest);
//         } else {
//             return getGreedyDirection(rc.getLocation().directionTo(dest));
//         }
//     }

//     public static Direction getGreedyDirection(Direction dir) throws GameActionException {
//         Direction[] bestDirs = greedyDirection(dir);
//         if(bestDirs.length > 0) {
//             return bestDirs[0];
//         } else {
//             return Util.getFirstValidInOrderDirection(dir);
//         }
//     }

//     static void move(MapLocation target) throws GameActionException {
//         move(target, false);
//     }

//     static void move(MapLocation target, boolean greedy) throws GameActionException {
//         if (target == null) return;
//         if (!rc.isMovementReady()) return;
//         if (rc.getLocation().distanceSquaredTo(target) == 0) return;

//         update(target);

//         if (!greedy && turnsGreedy <= 0){
//             Direction dir = getBestDir(target, BYTECODE_REMAINING);
//             if (dir != null && !MapTracker.check(rc.adjacentLocation(dir))){
//                 Explore.move(dir);
//                 return;
//             } else activateGreedy();
//         }

//         switch(rc.getType()) {
//             case MINER:
//             case BUILDER:
//                 if (Clock.getBytecodesLeft() >= BYTECODE_REMAINING) {
//                     Pathfinding.move(target);
//                     --turnsGreedy;
//                 } else {
//                     Debug.setIndicatorDot(true, rc.getLocation(), 255, 255, 255);
//                     Debug.println("Didn't have enough BC");
//                 }
//                 break;
//             default:
//                 if (Clock.getBytecodesLeft() >= BYTECODE_REMAINING_NON_MINER_BUILDER) {
//                     Pathfinding.move(target);
//                     --turnsGreedy;
//                 } else {
//                     Debug.setIndicatorDot(true, rc.getLocation(), 255, 255, 255);
//                     Debug.println("Didn't have enough BC");
//                 }
//                 break;
//         }
//     }
// }