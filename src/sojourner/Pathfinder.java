package sojourner;

import battlecode.common.*;
import java.util.*;
import java.math.*;

import sojourner.pathfinding.*;

public class Pathfinder {
	static RobotController rc;
	static UnrolledBFS_MR10_VR20 bfsPathfinder_MR10_VR20;
	MapLocation target;

	// important: vision range of robot must be at least the vision range

	void init(RobotController _rc) { 
		rc = _rc; 
		bfsPathfinder.init(_rc);
		target = null;
	}



	static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {
		// int bytecodesLeft = clock.getBytecodesLeft();
		if (!rc.isMovementReady())
			return null;
		return bfsPathfinder.getBestDirectionOneMove(target);
	}
};