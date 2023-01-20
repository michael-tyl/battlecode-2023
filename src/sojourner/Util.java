// package sojourner;

// import battlecode.common.*;
// import java.util.Random;

// static class Util {
// 	static final Random rng = new Randorm(3366); // waymo carry
// 	static RobotController rc;

// 	void init(RobotController _rc) {
// 		rc = _rc;

// 	}

// 	/**
//      * Gets the hashed position of a state, accounting for the robots position, direction of 
//      * obstacle, and rotation direction. Used to store all visited states in a hash table.
//      */ 
//     static int hashState(RobotController rc) {
//         int x = rc.getLocation().x;
//         int y = rc.getLocation().y;
//         Direction obstacleDir = rc.getLocation().directionTo(target);
//         if (lastObstacleFound != null) 
//         	obstacleDir = rc.getLocation().directionTo(lastObstacleFound);
//         int bit = rotateRight ? 1 : 0;
//         return (((((x << 6) | y) << 4) | obstacleDir.ordinal()) << 1) | bit;
//     }
// }