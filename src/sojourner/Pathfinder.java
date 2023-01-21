package sojourner;

import battlecode.common.*;
import java.util.*;
import java.math.*;

public class Pathfinder {
	static RobotController rc;
	static UnrolledBFS_MR20_VR20 bfs_mr20_vr20;

	void init(RobotController _rc) { 
		rc = _rc; 
		bfs_mr20_vr20.init(_rc);
	}

	static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {
		// int bytecodesLeft = clock.getBytecodesLeft();
		if (!rc.isMovementReady())
			return null;
		return bfs_mr20_vr20.getBestDirectionOneMove(target);
	}
};