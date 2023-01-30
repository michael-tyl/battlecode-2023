package sojourner.bfs;

import battlecode.common.*;
import java.math.*;

public class UnrolledBFS_MR10_VR10 {
	static RobotController rc;

	public static void init(RobotController _rc) { rc = _rc; }

	// 000: movable cell at location (-1, 3) relative to origin
	static MapLocation maploc000;
	static boolean isPassable000;
	static MapInfo mapinfo000;
	static int accessibilityFactor000;
	static int potentialFactor000;
	static Direction initialDirection000;
	
	// 001: movable cell at location (0, 3) relative to origin
	static MapLocation maploc001;
	static boolean isPassable001;
	static MapInfo mapinfo001;
	static int accessibilityFactor001;
	static int potentialFactor001;
	static Direction initialDirection001;
	
	// 002: movable cell at location (1, 3) relative to origin
	static MapLocation maploc002;
	static boolean isPassable002;
	static MapInfo mapinfo002;
	static int accessibilityFactor002;
	static int potentialFactor002;
	static Direction initialDirection002;
	
	// 003: movable cell at location (-2, 2) relative to origin
	static MapLocation maploc003;
	static boolean isPassable003;
	static MapInfo mapinfo003;
	static int accessibilityFactor003;
	static int potentialFactor003;
	static Direction initialDirection003;
	
	// 004: movable cell at location (-1, 2) relative to origin
	static MapLocation maploc004;
	static boolean isPassable004;
	static MapInfo mapinfo004;
	static int accessibilityFactor004;
	static int potentialFactor004;
	static Direction initialDirection004;
	
	// 005: movable cell at location (0, 2) relative to origin
	static MapLocation maploc005;
	static boolean isPassable005;
	static MapInfo mapinfo005;
	static int accessibilityFactor005;
	static int potentialFactor005;
	static Direction initialDirection005;
	
	// 006: movable cell at location (1, 2) relative to origin
	static MapLocation maploc006;
	static boolean isPassable006;
	static MapInfo mapinfo006;
	static int accessibilityFactor006;
	static int potentialFactor006;
	static Direction initialDirection006;
	
	// 007: movable cell at location (2, 2) relative to origin
	static MapLocation maploc007;
	static boolean isPassable007;
	static MapInfo mapinfo007;
	static int accessibilityFactor007;
	static int potentialFactor007;
	static Direction initialDirection007;
	
	// 008: movable cell at location (-3, 1) relative to origin
	static MapLocation maploc008;
	static boolean isPassable008;
	static MapInfo mapinfo008;
	static int accessibilityFactor008;
	static int potentialFactor008;
	static Direction initialDirection008;
	
	// 009: movable cell at location (-2, 1) relative to origin
	static MapLocation maploc009;
	static boolean isPassable009;
	static MapInfo mapinfo009;
	static int accessibilityFactor009;
	static int potentialFactor009;
	static Direction initialDirection009;
	
	// 010: movable cell at location (-1, 1) relative to origin
	static MapLocation maploc010;
	static boolean isPassable010;
	static MapInfo mapinfo010;
	static int accessibilityFactor010;
	static int potentialFactor010;
	static Direction initialDirection010;
	
	// 011: movable cell at location (0, 1) relative to origin
	static MapLocation maploc011;
	static boolean isPassable011;
	static MapInfo mapinfo011;
	static int accessibilityFactor011;
	static int potentialFactor011;
	static Direction initialDirection011;
	
	// 012: movable cell at location (1, 1) relative to origin
	static MapLocation maploc012;
	static boolean isPassable012;
	static MapInfo mapinfo012;
	static int accessibilityFactor012;
	static int potentialFactor012;
	static Direction initialDirection012;
	
	// 013: movable cell at location (2, 1) relative to origin
	static MapLocation maploc013;
	static boolean isPassable013;
	static MapInfo mapinfo013;
	static int accessibilityFactor013;
	static int potentialFactor013;
	static Direction initialDirection013;
	
	// 014: movable cell at location (3, 1) relative to origin
	static MapLocation maploc014;
	static boolean isPassable014;
	static MapInfo mapinfo014;
	static int accessibilityFactor014;
	static int potentialFactor014;
	static Direction initialDirection014;
	
	// 015: movable cell at location (-3, 0) relative to origin
	static MapLocation maploc015;
	static boolean isPassable015;
	static MapInfo mapinfo015;
	static int accessibilityFactor015;
	static int potentialFactor015;
	static Direction initialDirection015;
	
	// 016: movable cell at location (-2, 0) relative to origin
	static MapLocation maploc016;
	static boolean isPassable016;
	static MapInfo mapinfo016;
	static int accessibilityFactor016;
	static int potentialFactor016;
	static Direction initialDirection016;
	
	// 017: movable cell at location (-1, 0) relative to origin
	static MapLocation maploc017;
	static boolean isPassable017;
	static MapInfo mapinfo017;
	static int accessibilityFactor017;
	static int potentialFactor017;
	static Direction initialDirection017;
	
	// 018: movable cell at location (0, 0) relative to origin
	static MapLocation maploc018;
	static boolean isPassable018;
	static MapInfo mapinfo018;
	static int accessibilityFactor018;
	static int potentialFactor018;
	static Direction initialDirection018;
	
	// 019: movable cell at location (1, 0) relative to origin
	static MapLocation maploc019;
	static boolean isPassable019;
	static MapInfo mapinfo019;
	static int accessibilityFactor019;
	static int potentialFactor019;
	static Direction initialDirection019;
	
	// 020: movable cell at location (2, 0) relative to origin
	static MapLocation maploc020;
	static boolean isPassable020;
	static MapInfo mapinfo020;
	static int accessibilityFactor020;
	static int potentialFactor020;
	static Direction initialDirection020;
	
	// 021: movable cell at location (3, 0) relative to origin
	static MapLocation maploc021;
	static boolean isPassable021;
	static MapInfo mapinfo021;
	static int accessibilityFactor021;
	static int potentialFactor021;
	static Direction initialDirection021;
	
	// 022: movable cell at location (-3, -1) relative to origin
	static MapLocation maploc022;
	static boolean isPassable022;
	static MapInfo mapinfo022;
	static int accessibilityFactor022;
	static int potentialFactor022;
	static Direction initialDirection022;
	
	// 023: movable cell at location (-2, -1) relative to origin
	static MapLocation maploc023;
	static boolean isPassable023;
	static MapInfo mapinfo023;
	static int accessibilityFactor023;
	static int potentialFactor023;
	static Direction initialDirection023;
	
	// 024: movable cell at location (-1, -1) relative to origin
	static MapLocation maploc024;
	static boolean isPassable024;
	static MapInfo mapinfo024;
	static int accessibilityFactor024;
	static int potentialFactor024;
	static Direction initialDirection024;
	
	// 025: movable cell at location (0, -1) relative to origin
	static MapLocation maploc025;
	static boolean isPassable025;
	static MapInfo mapinfo025;
	static int accessibilityFactor025;
	static int potentialFactor025;
	static Direction initialDirection025;
	
	// 026: movable cell at location (1, -1) relative to origin
	static MapLocation maploc026;
	static boolean isPassable026;
	static MapInfo mapinfo026;
	static int accessibilityFactor026;
	static int potentialFactor026;
	static Direction initialDirection026;
	
	// 027: movable cell at location (2, -1) relative to origin
	static MapLocation maploc027;
	static boolean isPassable027;
	static MapInfo mapinfo027;
	static int accessibilityFactor027;
	static int potentialFactor027;
	static Direction initialDirection027;
	
	// 028: movable cell at location (3, -1) relative to origin
	static MapLocation maploc028;
	static boolean isPassable028;
	static MapInfo mapinfo028;
	static int accessibilityFactor028;
	static int potentialFactor028;
	static Direction initialDirection028;
	
	// 029: movable cell at location (-2, -2) relative to origin
	static MapLocation maploc029;
	static boolean isPassable029;
	static MapInfo mapinfo029;
	static int accessibilityFactor029;
	static int potentialFactor029;
	static Direction initialDirection029;
	
	// 030: movable cell at location (-1, -2) relative to origin
	static MapLocation maploc030;
	static boolean isPassable030;
	static MapInfo mapinfo030;
	static int accessibilityFactor030;
	static int potentialFactor030;
	static Direction initialDirection030;
	
	// 031: movable cell at location (0, -2) relative to origin
	static MapLocation maploc031;
	static boolean isPassable031;
	static MapInfo mapinfo031;
	static int accessibilityFactor031;
	static int potentialFactor031;
	static Direction initialDirection031;
	
	// 032: movable cell at location (1, -2) relative to origin
	static MapLocation maploc032;
	static boolean isPassable032;
	static MapInfo mapinfo032;
	static int accessibilityFactor032;
	static int potentialFactor032;
	static Direction initialDirection032;
	
	// 033: movable cell at location (2, -2) relative to origin
	static MapLocation maploc033;
	static boolean isPassable033;
	static MapInfo mapinfo033;
	static int accessibilityFactor033;
	static int potentialFactor033;
	static Direction initialDirection033;
	
	// 034: movable cell at location (-1, -3) relative to origin
	static MapLocation maploc034;
	static boolean isPassable034;
	static MapInfo mapinfo034;
	static int accessibilityFactor034;
	static int potentialFactor034;
	static Direction initialDirection034;
	
	// 035: movable cell at location (0, -3) relative to origin
	static MapLocation maploc035;
	static boolean isPassable035;
	static MapInfo mapinfo035;
	static int accessibilityFactor035;
	static int potentialFactor035;
	static Direction initialDirection035;
	
	// 036: movable cell at location (1, -3) relative to origin
	static MapLocation maploc036;
	static boolean isPassable036;
	static MapInfo mapinfo036;
	static int accessibilityFactor036;
	static int potentialFactor036;
	static Direction initialDirection036;
	
	
	/* tries to get exactly to target in one move per turn */
	public static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {
		maploc018 = rc.getLocation();
		mapinfo018 = rc.senseMapInfo(maploc018);
		isPassable018 = true;
		accessibilityFactor018 = 0;
		potentialFactor018 = 256;
		initialDirection018 = null;
		
		maploc010 = maploc018.add(Direction.NORTHWEST);
		accessibilityFactor010 = 256;
		potentialFactor010 = 256;
		initialDirection010 = null;
		if (rc.onTheMap(maploc010)) {
			mapinfo010 = rc.senseMapInfo(maploc010);
			isPassable010 = mapinfo010.isPassable() && rc.senseRobotAtLocation(maploc010) == null;
		} else {
			isPassable010 = false;
		}

		maploc011 = maploc018.add(Direction.NORTH);
		accessibilityFactor011 = 256;
		potentialFactor011 = 256;
		initialDirection011 = null;
		if (rc.onTheMap(maploc011)) {
			mapinfo011 = rc.senseMapInfo(maploc011);
			isPassable011 = mapinfo011.isPassable() && rc.senseRobotAtLocation(maploc011) == null;
		} else {
			isPassable011 = false;
		}

		maploc012 = maploc018.add(Direction.NORTHEAST);
		accessibilityFactor012 = 256;
		potentialFactor012 = 256;
		initialDirection012 = null;
		if (rc.onTheMap(maploc012)) {
			mapinfo012 = rc.senseMapInfo(maploc012);
			isPassable012 = mapinfo012.isPassable() && rc.senseRobotAtLocation(maploc012) == null;
		} else {
			isPassable012 = false;
		}

		maploc017 = maploc018.add(Direction.WEST);
		accessibilityFactor017 = 256;
		potentialFactor017 = 256;
		initialDirection017 = null;
		if (rc.onTheMap(maploc017)) {
			mapinfo017 = rc.senseMapInfo(maploc017);
			isPassable017 = mapinfo017.isPassable() && rc.senseRobotAtLocation(maploc017) == null;
		} else {
			isPassable017 = false;
		}

		maploc019 = maploc018.add(Direction.EAST);
		accessibilityFactor019 = 256;
		potentialFactor019 = 256;
		initialDirection019 = null;
		if (rc.onTheMap(maploc019)) {
			mapinfo019 = rc.senseMapInfo(maploc019);
			isPassable019 = mapinfo019.isPassable() && rc.senseRobotAtLocation(maploc019) == null;
		} else {
			isPassable019 = false;
		}

		maploc024 = maploc018.add(Direction.SOUTHWEST);
		accessibilityFactor024 = 256;
		potentialFactor024 = 256;
		initialDirection024 = null;
		if (rc.onTheMap(maploc024)) {
			mapinfo024 = rc.senseMapInfo(maploc024);
			isPassable024 = mapinfo024.isPassable() && rc.senseRobotAtLocation(maploc024) == null;
		} else {
			isPassable024 = false;
		}

		maploc025 = maploc018.add(Direction.SOUTH);
		accessibilityFactor025 = 256;
		potentialFactor025 = 256;
		initialDirection025 = null;
		if (rc.onTheMap(maploc025)) {
			mapinfo025 = rc.senseMapInfo(maploc025);
			isPassable025 = mapinfo025.isPassable() && rc.senseRobotAtLocation(maploc025) == null;
		} else {
			isPassable025 = false;
		}

		maploc026 = maploc018.add(Direction.SOUTHEAST);
		accessibilityFactor026 = 256;
		potentialFactor026 = 256;
		initialDirection026 = null;
		if (rc.onTheMap(maploc026)) {
			mapinfo026 = rc.senseMapInfo(maploc026);
			isPassable026 = mapinfo026.isPassable() && rc.senseRobotAtLocation(maploc026) == null;
		} else {
			isPassable026 = false;
		}

		maploc003 = maploc010.add(Direction.NORTHWEST);
		accessibilityFactor003 = 256;
		potentialFactor003 = 256;
		initialDirection003 = null;
		if (rc.onTheMap(maploc003)) {
			mapinfo003 = rc.senseMapInfo(maploc003);
			isPassable003 = mapinfo003.isPassable() && rc.senseRobotAtLocation(maploc003) == null;
		} else {
			isPassable003 = false;
		}

		maploc004 = maploc010.add(Direction.NORTH);
		accessibilityFactor004 = 256;
		potentialFactor004 = 256;
		initialDirection004 = null;
		if (rc.onTheMap(maploc004)) {
			mapinfo004 = rc.senseMapInfo(maploc004);
			isPassable004 = mapinfo004.isPassable() && rc.senseRobotAtLocation(maploc004) == null;
		} else {
			isPassable004 = false;
		}

		maploc005 = maploc010.add(Direction.NORTHEAST);
		accessibilityFactor005 = 256;
		potentialFactor005 = 256;
		initialDirection005 = null;
		if (rc.onTheMap(maploc005)) {
			mapinfo005 = rc.senseMapInfo(maploc005);
			isPassable005 = mapinfo005.isPassable() && rc.senseRobotAtLocation(maploc005) == null;
		} else {
			isPassable005 = false;
		}

		maploc009 = maploc010.add(Direction.WEST);
		accessibilityFactor009 = 256;
		potentialFactor009 = 256;
		initialDirection009 = null;
		if (rc.onTheMap(maploc009)) {
			mapinfo009 = rc.senseMapInfo(maploc009);
			isPassable009 = mapinfo009.isPassable() && rc.senseRobotAtLocation(maploc009) == null;
		} else {
			isPassable009 = false;
		}

		maploc016 = maploc010.add(Direction.SOUTHWEST);
		accessibilityFactor016 = 256;
		potentialFactor016 = 256;
		initialDirection016 = null;
		if (rc.onTheMap(maploc016)) {
			mapinfo016 = rc.senseMapInfo(maploc016);
			isPassable016 = mapinfo016.isPassable() && rc.senseRobotAtLocation(maploc016) == null;
		} else {
			isPassable016 = false;
		}

		maploc006 = maploc011.add(Direction.NORTHEAST);
		accessibilityFactor006 = 256;
		potentialFactor006 = 256;
		initialDirection006 = null;
		if (rc.onTheMap(maploc006)) {
			mapinfo006 = rc.senseMapInfo(maploc006);
			isPassable006 = mapinfo006.isPassable() && rc.senseRobotAtLocation(maploc006) == null;
		} else {
			isPassable006 = false;
		}

		maploc007 = maploc012.add(Direction.NORTHEAST);
		accessibilityFactor007 = 256;
		potentialFactor007 = 256;
		initialDirection007 = null;
		if (rc.onTheMap(maploc007)) {
			mapinfo007 = rc.senseMapInfo(maploc007);
			isPassable007 = mapinfo007.isPassable() && rc.senseRobotAtLocation(maploc007) == null;
		} else {
			isPassable007 = false;
		}

		maploc013 = maploc012.add(Direction.EAST);
		accessibilityFactor013 = 256;
		potentialFactor013 = 256;
		initialDirection013 = null;
		if (rc.onTheMap(maploc013)) {
			mapinfo013 = rc.senseMapInfo(maploc013);
			isPassable013 = mapinfo013.isPassable() && rc.senseRobotAtLocation(maploc013) == null;
		} else {
			isPassable013 = false;
		}

		maploc020 = maploc012.add(Direction.SOUTHEAST);
		accessibilityFactor020 = 256;
		potentialFactor020 = 256;
		initialDirection020 = null;
		if (rc.onTheMap(maploc020)) {
			mapinfo020 = rc.senseMapInfo(maploc020);
			isPassable020 = mapinfo020.isPassable() && rc.senseRobotAtLocation(maploc020) == null;
		} else {
			isPassable020 = false;
		}

		maploc023 = maploc017.add(Direction.SOUTHWEST);
		accessibilityFactor023 = 256;
		potentialFactor023 = 256;
		initialDirection023 = null;
		if (rc.onTheMap(maploc023)) {
			mapinfo023 = rc.senseMapInfo(maploc023);
			isPassable023 = mapinfo023.isPassable() && rc.senseRobotAtLocation(maploc023) == null;
		} else {
			isPassable023 = false;
		}

		maploc027 = maploc019.add(Direction.SOUTHEAST);
		accessibilityFactor027 = 256;
		potentialFactor027 = 256;
		initialDirection027 = null;
		if (rc.onTheMap(maploc027)) {
			mapinfo027 = rc.senseMapInfo(maploc027);
			isPassable027 = mapinfo027.isPassable() && rc.senseRobotAtLocation(maploc027) == null;
		} else {
			isPassable027 = false;
		}

		maploc029 = maploc024.add(Direction.SOUTHWEST);
		accessibilityFactor029 = 256;
		potentialFactor029 = 256;
		initialDirection029 = null;
		if (rc.onTheMap(maploc029)) {
			mapinfo029 = rc.senseMapInfo(maploc029);
			isPassable029 = mapinfo029.isPassable() && rc.senseRobotAtLocation(maploc029) == null;
		} else {
			isPassable029 = false;
		}

		maploc030 = maploc024.add(Direction.SOUTH);
		accessibilityFactor030 = 256;
		potentialFactor030 = 256;
		initialDirection030 = null;
		if (rc.onTheMap(maploc030)) {
			mapinfo030 = rc.senseMapInfo(maploc030);
			isPassable030 = mapinfo030.isPassable() && rc.senseRobotAtLocation(maploc030) == null;
		} else {
			isPassable030 = false;
		}

		maploc031 = maploc024.add(Direction.SOUTHEAST);
		accessibilityFactor031 = 256;
		potentialFactor031 = 256;
		initialDirection031 = null;
		if (rc.onTheMap(maploc031)) {
			mapinfo031 = rc.senseMapInfo(maploc031);
			isPassable031 = mapinfo031.isPassable() && rc.senseRobotAtLocation(maploc031) == null;
		} else {
			isPassable031 = false;
		}

		maploc032 = maploc025.add(Direction.SOUTHEAST);
		accessibilityFactor032 = 256;
		potentialFactor032 = 256;
		initialDirection032 = null;
		if (rc.onTheMap(maploc032)) {
			mapinfo032 = rc.senseMapInfo(maploc032);
			isPassable032 = mapinfo032.isPassable() && rc.senseRobotAtLocation(maploc032) == null;
		} else {
			isPassable032 = false;
		}

		maploc033 = maploc026.add(Direction.SOUTHEAST);
		accessibilityFactor033 = 256;
		potentialFactor033 = 256;
		initialDirection033 = null;
		if (rc.onTheMap(maploc033)) {
			mapinfo033 = rc.senseMapInfo(maploc033);
			isPassable033 = mapinfo033.isPassable() && rc.senseRobotAtLocation(maploc033) == null;
		} else {
			isPassable033 = false;
		}

		maploc000 = maploc003.add(Direction.NORTHEAST);
		accessibilityFactor000 = 256;
		potentialFactor000 = 256;
		initialDirection000 = null;
		if (rc.onTheMap(maploc000)) {
			mapinfo000 = rc.senseMapInfo(maploc000);
			isPassable000 = mapinfo000.isPassable() && rc.senseRobotAtLocation(maploc000) == null;
		} else {
			isPassable000 = false;
		}

		maploc008 = maploc003.add(Direction.SOUTHWEST);
		accessibilityFactor008 = 256;
		potentialFactor008 = 256;
		initialDirection008 = null;
		if (rc.onTheMap(maploc008)) {
			mapinfo008 = rc.senseMapInfo(maploc008);
			isPassable008 = mapinfo008.isPassable() && rc.senseRobotAtLocation(maploc008) == null;
		} else {
			isPassable008 = false;
		}

		maploc001 = maploc004.add(Direction.NORTHEAST);
		accessibilityFactor001 = 256;
		potentialFactor001 = 256;
		initialDirection001 = null;
		if (rc.onTheMap(maploc001)) {
			mapinfo001 = rc.senseMapInfo(maploc001);
			isPassable001 = mapinfo001.isPassable() && rc.senseRobotAtLocation(maploc001) == null;
		} else {
			isPassable001 = false;
		}

		maploc002 = maploc005.add(Direction.NORTHEAST);
		accessibilityFactor002 = 256;
		potentialFactor002 = 256;
		initialDirection002 = null;
		if (rc.onTheMap(maploc002)) {
			mapinfo002 = rc.senseMapInfo(maploc002);
			isPassable002 = mapinfo002.isPassable() && rc.senseRobotAtLocation(maploc002) == null;
		} else {
			isPassable002 = false;
		}

		maploc015 = maploc009.add(Direction.SOUTHWEST);
		accessibilityFactor015 = 256;
		potentialFactor015 = 256;
		initialDirection015 = null;
		if (rc.onTheMap(maploc015)) {
			mapinfo015 = rc.senseMapInfo(maploc015);
			isPassable015 = mapinfo015.isPassable() && rc.senseRobotAtLocation(maploc015) == null;
		} else {
			isPassable015 = false;
		}

		maploc022 = maploc016.add(Direction.SOUTHWEST);
		accessibilityFactor022 = 256;
		potentialFactor022 = 256;
		initialDirection022 = null;
		if (rc.onTheMap(maploc022)) {
			mapinfo022 = rc.senseMapInfo(maploc022);
			isPassable022 = mapinfo022.isPassable() && rc.senseRobotAtLocation(maploc022) == null;
		} else {
			isPassable022 = false;
		}

		maploc014 = maploc007.add(Direction.SOUTHEAST);
		accessibilityFactor014 = 256;
		potentialFactor014 = 256;
		initialDirection014 = null;
		if (rc.onTheMap(maploc014)) {
			mapinfo014 = rc.senseMapInfo(maploc014);
			isPassable014 = mapinfo014.isPassable() && rc.senseRobotAtLocation(maploc014) == null;
		} else {
			isPassable014 = false;
		}

		maploc021 = maploc013.add(Direction.SOUTHEAST);
		accessibilityFactor021 = 256;
		potentialFactor021 = 256;
		initialDirection021 = null;
		if (rc.onTheMap(maploc021)) {
			mapinfo021 = rc.senseMapInfo(maploc021);
			isPassable021 = mapinfo021.isPassable() && rc.senseRobotAtLocation(maploc021) == null;
		} else {
			isPassable021 = false;
		}

		maploc028 = maploc020.add(Direction.SOUTHEAST);
		accessibilityFactor028 = 256;
		potentialFactor028 = 256;
		initialDirection028 = null;
		if (rc.onTheMap(maploc028)) {
			mapinfo028 = rc.senseMapInfo(maploc028);
			isPassable028 = mapinfo028.isPassable() && rc.senseRobotAtLocation(maploc028) == null;
		} else {
			isPassable028 = false;
		}

		maploc034 = maploc029.add(Direction.SOUTHEAST);
		accessibilityFactor034 = 256;
		potentialFactor034 = 256;
		initialDirection034 = null;
		if (rc.onTheMap(maploc034)) {
			mapinfo034 = rc.senseMapInfo(maploc034);
			isPassable034 = mapinfo034.isPassable() && rc.senseRobotAtLocation(maploc034) == null;
		} else {
			isPassable034 = false;
		}

		maploc035 = maploc030.add(Direction.SOUTHEAST);
		accessibilityFactor035 = 256;
		potentialFactor035 = 256;
		initialDirection035 = null;
		if (rc.onTheMap(maploc035)) {
			mapinfo035 = rc.senseMapInfo(maploc035);
			isPassable035 = mapinfo035.isPassable() && rc.senseRobotAtLocation(maploc035) == null;
		} else {
			isPassable035 = false;
		}

		maploc036 = maploc031.add(Direction.SOUTHEAST);
		accessibilityFactor036 = 256;
		potentialFactor036 = 256;
		initialDirection036 = null;
		if (rc.onTheMap(maploc036)) {
			mapinfo036 = rc.senseMapInfo(maploc036);
			isPassable036 = mapinfo036.isPassable() && rc.senseRobotAtLocation(maploc036) == null;
		} else {
			isPassable036 = false;
		}

		if (accessibilityFactor010 > accessibilityFactor018 + 1) {
			accessibilityFactor010 = accessibilityFactor018 + 1;
			initialDirection010 = Direction.NORTHWEST;
		}
		if (accessibilityFactor011 > accessibilityFactor018 + 1) {
			accessibilityFactor011 = accessibilityFactor018 + 1;
			initialDirection011 = Direction.NORTH;
		}
		if (accessibilityFactor012 > accessibilityFactor018 + 1) {
			accessibilityFactor012 = accessibilityFactor018 + 1;
			initialDirection012 = Direction.NORTHEAST;
		}
		if (accessibilityFactor017 > accessibilityFactor018 + 1) {
			accessibilityFactor017 = accessibilityFactor018 + 1;
			initialDirection017 = Direction.WEST;
		}
		if (accessibilityFactor019 > accessibilityFactor018 + 1) {
			accessibilityFactor019 = accessibilityFactor018 + 1;
			initialDirection019 = Direction.EAST;
		}
		if (accessibilityFactor024 > accessibilityFactor018 + 1) {
			accessibilityFactor024 = accessibilityFactor018 + 1;
			initialDirection024 = Direction.SOUTHWEST;
		}
		if (accessibilityFactor025 > accessibilityFactor018 + 1) {
			accessibilityFactor025 = accessibilityFactor018 + 1;
			initialDirection025 = Direction.SOUTH;
		}
		if (accessibilityFactor026 > accessibilityFactor018 + 1) {
			accessibilityFactor026 = accessibilityFactor018 + 1;
			initialDirection026 = Direction.SOUTHEAST;
		}
		
		if (isPassable011) {
			if (accessibilityFactor004 > accessibilityFactor011 + 1) {
				accessibilityFactor004 = accessibilityFactor011 + 1;
				initialDirection004 = initialDirection011;
			}
			if (accessibilityFactor005 > accessibilityFactor011 + 1) {
				accessibilityFactor005 = accessibilityFactor011 + 1;
				initialDirection005 = initialDirection011;
			}
			if (accessibilityFactor006 > accessibilityFactor011 + 1) {
				accessibilityFactor006 = accessibilityFactor011 + 1;
				initialDirection006 = initialDirection011;
			}
			if (accessibilityFactor010 > accessibilityFactor011 + 1) {
				accessibilityFactor010 = accessibilityFactor011 + 1;
				initialDirection010 = initialDirection011;
			}
			if (accessibilityFactor012 > accessibilityFactor011 + 1) {
				accessibilityFactor012 = accessibilityFactor011 + 1;
				initialDirection012 = initialDirection011;
			}
			if (accessibilityFactor017 > accessibilityFactor011 + 1) {
				accessibilityFactor017 = accessibilityFactor011 + 1;
				initialDirection017 = initialDirection011;
			}
			if (accessibilityFactor019 > accessibilityFactor011 + 1) {
				accessibilityFactor019 = accessibilityFactor011 + 1;
				initialDirection019 = initialDirection011;
			}
		}
		if (isPassable017) {
			if (accessibilityFactor009 > accessibilityFactor017 + 1) {
				accessibilityFactor009 = accessibilityFactor017 + 1;
				initialDirection009 = initialDirection017;
			}
			if (accessibilityFactor010 > accessibilityFactor017 + 1) {
				accessibilityFactor010 = accessibilityFactor017 + 1;
				initialDirection010 = initialDirection017;
			}
			if (accessibilityFactor016 > accessibilityFactor017 + 1) {
				accessibilityFactor016 = accessibilityFactor017 + 1;
				initialDirection016 = initialDirection017;
			}
			if (accessibilityFactor023 > accessibilityFactor017 + 1) {
				accessibilityFactor023 = accessibilityFactor017 + 1;
				initialDirection023 = initialDirection017;
			}
			if (accessibilityFactor024 > accessibilityFactor017 + 1) {
				accessibilityFactor024 = accessibilityFactor017 + 1;
				initialDirection024 = initialDirection017;
			}
			if (accessibilityFactor025 > accessibilityFactor017 + 1) {
				accessibilityFactor025 = accessibilityFactor017 + 1;
				initialDirection025 = initialDirection017;
			}
		}
		if (isPassable019) {
			if (accessibilityFactor012 > accessibilityFactor019 + 1) {
				accessibilityFactor012 = accessibilityFactor019 + 1;
				initialDirection012 = initialDirection019;
			}
			if (accessibilityFactor013 > accessibilityFactor019 + 1) {
				accessibilityFactor013 = accessibilityFactor019 + 1;
				initialDirection013 = initialDirection019;
			}
			if (accessibilityFactor020 > accessibilityFactor019 + 1) {
				accessibilityFactor020 = accessibilityFactor019 + 1;
				initialDirection020 = initialDirection019;
			}
			if (accessibilityFactor025 > accessibilityFactor019 + 1) {
				accessibilityFactor025 = accessibilityFactor019 + 1;
				initialDirection025 = initialDirection019;
			}
			if (accessibilityFactor026 > accessibilityFactor019 + 1) {
				accessibilityFactor026 = accessibilityFactor019 + 1;
				initialDirection026 = initialDirection019;
			}
			if (accessibilityFactor027 > accessibilityFactor019 + 1) {
				accessibilityFactor027 = accessibilityFactor019 + 1;
				initialDirection027 = initialDirection019;
			}
		}
		if (isPassable025) {
			if (accessibilityFactor024 > accessibilityFactor025 + 1) {
				accessibilityFactor024 = accessibilityFactor025 + 1;
				initialDirection024 = initialDirection025;
			}
			if (accessibilityFactor026 > accessibilityFactor025 + 1) {
				accessibilityFactor026 = accessibilityFactor025 + 1;
				initialDirection026 = initialDirection025;
			}
			if (accessibilityFactor030 > accessibilityFactor025 + 1) {
				accessibilityFactor030 = accessibilityFactor025 + 1;
				initialDirection030 = initialDirection025;
			}
			if (accessibilityFactor031 > accessibilityFactor025 + 1) {
				accessibilityFactor031 = accessibilityFactor025 + 1;
				initialDirection031 = initialDirection025;
			}
			if (accessibilityFactor032 > accessibilityFactor025 + 1) {
				accessibilityFactor032 = accessibilityFactor025 + 1;
				initialDirection032 = initialDirection025;
			}
		}
		if (isPassable010) {
			if (accessibilityFactor003 > accessibilityFactor010 + 1) {
				accessibilityFactor003 = accessibilityFactor010 + 1;
				initialDirection003 = initialDirection010;
			}
			if (accessibilityFactor004 > accessibilityFactor010 + 1) {
				accessibilityFactor004 = accessibilityFactor010 + 1;
				initialDirection004 = initialDirection010;
			}
			if (accessibilityFactor005 > accessibilityFactor010 + 1) {
				accessibilityFactor005 = accessibilityFactor010 + 1;
				initialDirection005 = initialDirection010;
			}
			if (accessibilityFactor009 > accessibilityFactor010 + 1) {
				accessibilityFactor009 = accessibilityFactor010 + 1;
				initialDirection009 = initialDirection010;
			}
			if (accessibilityFactor016 > accessibilityFactor010 + 1) {
				accessibilityFactor016 = accessibilityFactor010 + 1;
				initialDirection016 = initialDirection010;
			}
		}
		if (isPassable012) {
			if (accessibilityFactor005 > accessibilityFactor012 + 1) {
				accessibilityFactor005 = accessibilityFactor012 + 1;
				initialDirection005 = initialDirection012;
			}
			if (accessibilityFactor006 > accessibilityFactor012 + 1) {
				accessibilityFactor006 = accessibilityFactor012 + 1;
				initialDirection006 = initialDirection012;
			}
			if (accessibilityFactor007 > accessibilityFactor012 + 1) {
				accessibilityFactor007 = accessibilityFactor012 + 1;
				initialDirection007 = initialDirection012;
			}
			if (accessibilityFactor013 > accessibilityFactor012 + 1) {
				accessibilityFactor013 = accessibilityFactor012 + 1;
				initialDirection013 = initialDirection012;
			}
			if (accessibilityFactor020 > accessibilityFactor012 + 1) {
				accessibilityFactor020 = accessibilityFactor012 + 1;
				initialDirection020 = initialDirection012;
			}
		}
		if (isPassable024) {
			if (accessibilityFactor016 > accessibilityFactor024 + 1) {
				accessibilityFactor016 = accessibilityFactor024 + 1;
				initialDirection016 = initialDirection024;
			}
			if (accessibilityFactor023 > accessibilityFactor024 + 1) {
				accessibilityFactor023 = accessibilityFactor024 + 1;
				initialDirection023 = initialDirection024;
			}
			if (accessibilityFactor029 > accessibilityFactor024 + 1) {
				accessibilityFactor029 = accessibilityFactor024 + 1;
				initialDirection029 = initialDirection024;
			}
			if (accessibilityFactor030 > accessibilityFactor024 + 1) {
				accessibilityFactor030 = accessibilityFactor024 + 1;
				initialDirection030 = initialDirection024;
			}
			if (accessibilityFactor031 > accessibilityFactor024 + 1) {
				accessibilityFactor031 = accessibilityFactor024 + 1;
				initialDirection031 = initialDirection024;
			}
		}
		if (isPassable026) {
			if (accessibilityFactor020 > accessibilityFactor026 + 1) {
				accessibilityFactor020 = accessibilityFactor026 + 1;
				initialDirection020 = initialDirection026;
			}
			if (accessibilityFactor027 > accessibilityFactor026 + 1) {
				accessibilityFactor027 = accessibilityFactor026 + 1;
				initialDirection027 = initialDirection026;
			}
			if (accessibilityFactor031 > accessibilityFactor026 + 1) {
				accessibilityFactor031 = accessibilityFactor026 + 1;
				initialDirection031 = initialDirection026;
			}
			if (accessibilityFactor032 > accessibilityFactor026 + 1) {
				accessibilityFactor032 = accessibilityFactor026 + 1;
				initialDirection032 = initialDirection026;
			}
			if (accessibilityFactor033 > accessibilityFactor026 + 1) {
				accessibilityFactor033 = accessibilityFactor026 + 1;
				initialDirection033 = initialDirection026;
			}
		}
		if (isPassable005) {
			if (accessibilityFactor000 > accessibilityFactor005 + 1) {
				accessibilityFactor000 = accessibilityFactor005 + 1;
				initialDirection000 = initialDirection005;
			}
			if (accessibilityFactor001 > accessibilityFactor005 + 1) {
				accessibilityFactor001 = accessibilityFactor005 + 1;
				initialDirection001 = initialDirection005;
			}
			if (accessibilityFactor002 > accessibilityFactor005 + 1) {
				accessibilityFactor002 = accessibilityFactor005 + 1;
				initialDirection002 = initialDirection005;
			}
			if (accessibilityFactor004 > accessibilityFactor005 + 1) {
				accessibilityFactor004 = accessibilityFactor005 + 1;
				initialDirection004 = initialDirection005;
			}
			if (accessibilityFactor006 > accessibilityFactor005 + 1) {
				accessibilityFactor006 = accessibilityFactor005 + 1;
				initialDirection006 = initialDirection005;
			}
		}
		if (isPassable016) {
			if (accessibilityFactor008 > accessibilityFactor016 + 1) {
				accessibilityFactor008 = accessibilityFactor016 + 1;
				initialDirection008 = initialDirection016;
			}
			if (accessibilityFactor009 > accessibilityFactor016 + 1) {
				accessibilityFactor009 = accessibilityFactor016 + 1;
				initialDirection009 = initialDirection016;
			}
			if (accessibilityFactor015 > accessibilityFactor016 + 1) {
				accessibilityFactor015 = accessibilityFactor016 + 1;
				initialDirection015 = initialDirection016;
			}
			if (accessibilityFactor022 > accessibilityFactor016 + 1) {
				accessibilityFactor022 = accessibilityFactor016 + 1;
				initialDirection022 = initialDirection016;
			}
			if (accessibilityFactor023 > accessibilityFactor016 + 1) {
				accessibilityFactor023 = accessibilityFactor016 + 1;
				initialDirection023 = initialDirection016;
			}
		}
		if (isPassable020) {
			if (accessibilityFactor013 > accessibilityFactor020 + 1) {
				accessibilityFactor013 = accessibilityFactor020 + 1;
				initialDirection013 = initialDirection020;
			}
			if (accessibilityFactor014 > accessibilityFactor020 + 1) {
				accessibilityFactor014 = accessibilityFactor020 + 1;
				initialDirection014 = initialDirection020;
			}
			if (accessibilityFactor021 > accessibilityFactor020 + 1) {
				accessibilityFactor021 = accessibilityFactor020 + 1;
				initialDirection021 = initialDirection020;
			}
			if (accessibilityFactor027 > accessibilityFactor020 + 1) {
				accessibilityFactor027 = accessibilityFactor020 + 1;
				initialDirection027 = initialDirection020;
			}
			if (accessibilityFactor028 > accessibilityFactor020 + 1) {
				accessibilityFactor028 = accessibilityFactor020 + 1;
				initialDirection028 = initialDirection020;
			}
		}
		if (isPassable031) {
			if (accessibilityFactor030 > accessibilityFactor031 + 1) {
				accessibilityFactor030 = accessibilityFactor031 + 1;
				initialDirection030 = initialDirection031;
			}
			if (accessibilityFactor032 > accessibilityFactor031 + 1) {
				accessibilityFactor032 = accessibilityFactor031 + 1;
				initialDirection032 = initialDirection031;
			}
			if (accessibilityFactor034 > accessibilityFactor031 + 1) {
				accessibilityFactor034 = accessibilityFactor031 + 1;
				initialDirection034 = initialDirection031;
			}
			if (accessibilityFactor035 > accessibilityFactor031 + 1) {
				accessibilityFactor035 = accessibilityFactor031 + 1;
				initialDirection035 = initialDirection031;
			}
			if (accessibilityFactor036 > accessibilityFactor031 + 1) {
				accessibilityFactor036 = accessibilityFactor031 + 1;
				initialDirection036 = initialDirection031;
			}
		}
		if (isPassable004) {
			if (accessibilityFactor000 > accessibilityFactor004 + 1) {
				accessibilityFactor000 = accessibilityFactor004 + 1;
				initialDirection000 = initialDirection004;
			}
			if (accessibilityFactor001 > accessibilityFactor004 + 1) {
				accessibilityFactor001 = accessibilityFactor004 + 1;
				initialDirection001 = initialDirection004;
			}
			if (accessibilityFactor003 > accessibilityFactor004 + 1) {
				accessibilityFactor003 = accessibilityFactor004 + 1;
				initialDirection003 = initialDirection004;
			}
			if (accessibilityFactor009 > accessibilityFactor004 + 1) {
				accessibilityFactor009 = accessibilityFactor004 + 1;
				initialDirection009 = initialDirection004;
			}
		}
		if (isPassable006) {
			if (accessibilityFactor001 > accessibilityFactor006 + 1) {
				accessibilityFactor001 = accessibilityFactor006 + 1;
				initialDirection001 = initialDirection006;
			}
			if (accessibilityFactor002 > accessibilityFactor006 + 1) {
				accessibilityFactor002 = accessibilityFactor006 + 1;
				initialDirection002 = initialDirection006;
			}
			if (accessibilityFactor007 > accessibilityFactor006 + 1) {
				accessibilityFactor007 = accessibilityFactor006 + 1;
				initialDirection007 = initialDirection006;
			}
			if (accessibilityFactor013 > accessibilityFactor006 + 1) {
				accessibilityFactor013 = accessibilityFactor006 + 1;
				initialDirection013 = initialDirection006;
			}
		}
		if (isPassable009) {
			if (accessibilityFactor003 > accessibilityFactor009 + 1) {
				accessibilityFactor003 = accessibilityFactor009 + 1;
				initialDirection003 = initialDirection009;
			}
			if (accessibilityFactor008 > accessibilityFactor009 + 1) {
				accessibilityFactor008 = accessibilityFactor009 + 1;
				initialDirection008 = initialDirection009;
			}
			if (accessibilityFactor015 > accessibilityFactor009 + 1) {
				accessibilityFactor015 = accessibilityFactor009 + 1;
				initialDirection015 = initialDirection009;
			}
		}
		if (isPassable013) {
			if (accessibilityFactor007 > accessibilityFactor013 + 1) {
				accessibilityFactor007 = accessibilityFactor013 + 1;
				initialDirection007 = initialDirection013;
			}
			if (accessibilityFactor014 > accessibilityFactor013 + 1) {
				accessibilityFactor014 = accessibilityFactor013 + 1;
				initialDirection014 = initialDirection013;
			}
			if (accessibilityFactor021 > accessibilityFactor013 + 1) {
				accessibilityFactor021 = accessibilityFactor013 + 1;
				initialDirection021 = initialDirection013;
			}
		}
		if (isPassable023) {
			if (accessibilityFactor015 > accessibilityFactor023 + 1) {
				accessibilityFactor015 = accessibilityFactor023 + 1;
				initialDirection015 = initialDirection023;
			}
			if (accessibilityFactor022 > accessibilityFactor023 + 1) {
				accessibilityFactor022 = accessibilityFactor023 + 1;
				initialDirection022 = initialDirection023;
			}
			if (accessibilityFactor029 > accessibilityFactor023 + 1) {
				accessibilityFactor029 = accessibilityFactor023 + 1;
				initialDirection029 = initialDirection023;
			}
			if (accessibilityFactor030 > accessibilityFactor023 + 1) {
				accessibilityFactor030 = accessibilityFactor023 + 1;
				initialDirection030 = initialDirection023;
			}
		}
		if (isPassable027) {
			if (accessibilityFactor021 > accessibilityFactor027 + 1) {
				accessibilityFactor021 = accessibilityFactor027 + 1;
				initialDirection021 = initialDirection027;
			}
			if (accessibilityFactor028 > accessibilityFactor027 + 1) {
				accessibilityFactor028 = accessibilityFactor027 + 1;
				initialDirection028 = initialDirection027;
			}
			if (accessibilityFactor032 > accessibilityFactor027 + 1) {
				accessibilityFactor032 = accessibilityFactor027 + 1;
				initialDirection032 = initialDirection027;
			}
			if (accessibilityFactor033 > accessibilityFactor027 + 1) {
				accessibilityFactor033 = accessibilityFactor027 + 1;
				initialDirection033 = initialDirection027;
			}
		}
		if (isPassable030) {
			if (accessibilityFactor029 > accessibilityFactor030 + 1) {
				accessibilityFactor029 = accessibilityFactor030 + 1;
				initialDirection029 = initialDirection030;
			}
			if (accessibilityFactor034 > accessibilityFactor030 + 1) {
				accessibilityFactor034 = accessibilityFactor030 + 1;
				initialDirection034 = initialDirection030;
			}
			if (accessibilityFactor035 > accessibilityFactor030 + 1) {
				accessibilityFactor035 = accessibilityFactor030 + 1;
				initialDirection035 = initialDirection030;
			}
		}
		if (isPassable032) {
			if (accessibilityFactor033 > accessibilityFactor032 + 1) {
				accessibilityFactor033 = accessibilityFactor032 + 1;
				initialDirection033 = initialDirection032;
			}
			if (accessibilityFactor035 > accessibilityFactor032 + 1) {
				accessibilityFactor035 = accessibilityFactor032 + 1;
				initialDirection035 = initialDirection032;
			}
			if (accessibilityFactor036 > accessibilityFactor032 + 1) {
				accessibilityFactor036 = accessibilityFactor032 + 1;
				initialDirection036 = initialDirection032;
			}
		}
		if (isPassable003) {
			if (accessibilityFactor000 > accessibilityFactor003 + 1) {
				accessibilityFactor000 = accessibilityFactor003 + 1;
				initialDirection000 = initialDirection003;
			}
			if (accessibilityFactor008 > accessibilityFactor003 + 1) {
				accessibilityFactor008 = accessibilityFactor003 + 1;
				initialDirection008 = initialDirection003;
			}
		}
		if (isPassable007) {
			if (accessibilityFactor002 > accessibilityFactor007 + 1) {
				accessibilityFactor002 = accessibilityFactor007 + 1;
				initialDirection002 = initialDirection007;
			}
			if (accessibilityFactor014 > accessibilityFactor007 + 1) {
				accessibilityFactor014 = accessibilityFactor007 + 1;
				initialDirection014 = initialDirection007;
			}
		}
		if (isPassable029) {
			if (accessibilityFactor022 > accessibilityFactor029 + 1) {
				accessibilityFactor022 = accessibilityFactor029 + 1;
				initialDirection022 = initialDirection029;
			}
			if (accessibilityFactor034 > accessibilityFactor029 + 1) {
				accessibilityFactor034 = accessibilityFactor029 + 1;
				initialDirection034 = initialDirection029;
			}
		}
		if (isPassable033) {
			if (accessibilityFactor028 > accessibilityFactor033 + 1) {
				accessibilityFactor028 = accessibilityFactor033 + 1;
				initialDirection028 = initialDirection033;
			}
			if (accessibilityFactor036 > accessibilityFactor033 + 1) {
				accessibilityFactor036 = accessibilityFactor033 + 1;
				initialDirection036 = initialDirection033;
			}
		}
		if (isPassable001) {
			if (accessibilityFactor000 > accessibilityFactor001 + 1) {
				accessibilityFactor000 = accessibilityFactor001 + 1;
				initialDirection000 = initialDirection001;
			}
			if (accessibilityFactor002 > accessibilityFactor001 + 1) {
				accessibilityFactor002 = accessibilityFactor001 + 1;
				initialDirection002 = initialDirection001;
			}
		}
		if (isPassable015) {
			if (accessibilityFactor008 > accessibilityFactor015 + 1) {
				accessibilityFactor008 = accessibilityFactor015 + 1;
				initialDirection008 = initialDirection015;
			}
			if (accessibilityFactor022 > accessibilityFactor015 + 1) {
				accessibilityFactor022 = accessibilityFactor015 + 1;
				initialDirection022 = initialDirection015;
			}
		}
		if (isPassable021) {
			if (accessibilityFactor014 > accessibilityFactor021 + 1) {
				accessibilityFactor014 = accessibilityFactor021 + 1;
				initialDirection014 = initialDirection021;
			}
			if (accessibilityFactor028 > accessibilityFactor021 + 1) {
				accessibilityFactor028 = accessibilityFactor021 + 1;
				initialDirection028 = initialDirection021;
			}
		}
		if (isPassable035) {
			if (accessibilityFactor034 > accessibilityFactor035 + 1) {
				accessibilityFactor034 = accessibilityFactor035 + 1;
				initialDirection034 = initialDirection035;
			}
			if (accessibilityFactor036 > accessibilityFactor035 + 1) {
				accessibilityFactor036 = accessibilityFactor035 + 1;
				initialDirection036 = initialDirection035;
			}
		}
		int dx = target.x - maploc018.x, dy = target.y - maploc018.y;
		switch (dx) {
		case -3:
			switch (dy) {
			case 1: return initialDirection008;
			case 0: return initialDirection015;
			case -1: return initialDirection022;
			}
			break;
		case -2:
			switch (dy) {
			case 2: return initialDirection003;
			case 1: return initialDirection009;
			case 0: return initialDirection016;
			case -1: return initialDirection023;
			case -2: return initialDirection029;
			}
			break;
		case -1:
			switch (dy) {
			case 3: return initialDirection000;
			case 2: return initialDirection004;
			case 1: return initialDirection010;
			case 0: return initialDirection017;
			case -1: return initialDirection024;
			case -2: return initialDirection030;
			case -3: return initialDirection034;
			}
			break;
		case 0:
			switch (dy) {
			case 3: return initialDirection001;
			case 2: return initialDirection005;
			case 1: return initialDirection011;
			case 0: return initialDirection018;
			case -1: return initialDirection025;
			case -2: return initialDirection031;
			case -3: return initialDirection035;
			}
			break;
		case 1:
			switch (dy) {
			case 3: return initialDirection002;
			case 2: return initialDirection006;
			case 1: return initialDirection012;
			case 0: return initialDirection019;
			case -1: return initialDirection026;
			case -2: return initialDirection032;
			case -3: return initialDirection036;
			}
			break;
		case 2:
			switch (dy) {
			case 2: return initialDirection007;
			case 1: return initialDirection013;
			case 0: return initialDirection020;
			case -1: return initialDirection027;
			case -2: return initialDirection033;
			}
			break;
		case 3:
			switch (dy) {
			case 1: return initialDirection014;
			case 0: return initialDirection021;
			case -1: return initialDirection028;
			}
			break;
		}
		potentialFactor000 = Math.max(Math.abs(target.x - maploc000.x), Math.abs(target.y - maploc000.y));
		potentialFactor001 = Math.max(Math.abs(target.x - maploc001.x), Math.abs(target.y - maploc001.y));
		potentialFactor002 = Math.max(Math.abs(target.x - maploc002.x), Math.abs(target.y - maploc002.y));
		potentialFactor003 = Math.max(Math.abs(target.x - maploc003.x), Math.abs(target.y - maploc003.y));
		potentialFactor004 = Math.max(Math.abs(target.x - maploc004.x), Math.abs(target.y - maploc004.y));
		potentialFactor006 = Math.max(Math.abs(target.x - maploc006.x), Math.abs(target.y - maploc006.y));
		potentialFactor007 = Math.max(Math.abs(target.x - maploc007.x), Math.abs(target.y - maploc007.y));
		potentialFactor008 = Math.max(Math.abs(target.x - maploc008.x), Math.abs(target.y - maploc008.y));
		potentialFactor009 = Math.max(Math.abs(target.x - maploc009.x), Math.abs(target.y - maploc009.y));
		potentialFactor013 = Math.max(Math.abs(target.x - maploc013.x), Math.abs(target.y - maploc013.y));
		potentialFactor014 = Math.max(Math.abs(target.x - maploc014.x), Math.abs(target.y - maploc014.y));
		potentialFactor015 = Math.max(Math.abs(target.x - maploc015.x), Math.abs(target.y - maploc015.y));
		potentialFactor021 = Math.max(Math.abs(target.x - maploc021.x), Math.abs(target.y - maploc021.y));
		potentialFactor022 = Math.max(Math.abs(target.x - maploc022.x), Math.abs(target.y - maploc022.y));
		potentialFactor023 = Math.max(Math.abs(target.x - maploc023.x), Math.abs(target.y - maploc023.y));
		potentialFactor027 = Math.max(Math.abs(target.x - maploc027.x), Math.abs(target.y - maploc027.y));
		potentialFactor028 = Math.max(Math.abs(target.x - maploc028.x), Math.abs(target.y - maploc028.y));
		potentialFactor029 = Math.max(Math.abs(target.x - maploc029.x), Math.abs(target.y - maploc029.y));
		potentialFactor030 = Math.max(Math.abs(target.x - maploc030.x), Math.abs(target.y - maploc030.y));
		potentialFactor032 = Math.max(Math.abs(target.x - maploc032.x), Math.abs(target.y - maploc032.y));
		potentialFactor033 = Math.max(Math.abs(target.x - maploc033.x), Math.abs(target.y - maploc033.y));
		potentialFactor034 = Math.max(Math.abs(target.x - maploc034.x), Math.abs(target.y - maploc034.y));
		potentialFactor035 = Math.max(Math.abs(target.x - maploc035.x), Math.abs(target.y - maploc035.y));
		potentialFactor036 = Math.max(Math.abs(target.x - maploc036.x), Math.abs(target.y - maploc036.y));
		if (isPassable036) {
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor036 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor036 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor036 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor036 + 1);
		}

		if (isPassable034) {
			potentialFactor029 = Math.min(potentialFactor029, potentialFactor034 + 1);
			potentialFactor030 = Math.min(potentialFactor030, potentialFactor034 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor034 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor034 + 1);
		}

		if (isPassable028) {
			potentialFactor020 = Math.min(potentialFactor020, potentialFactor028 + 1);
			potentialFactor021 = Math.min(potentialFactor021, potentialFactor028 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor028 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor028 + 1);
		}

		if (isPassable022) {
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor022 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor022 + 1);
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor022 + 1);
			potentialFactor029 = Math.min(potentialFactor029, potentialFactor022 + 1);
		}

		if (isPassable014) {
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor014 + 1);
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor014 + 1);
			potentialFactor020 = Math.min(potentialFactor020, potentialFactor014 + 1);
			potentialFactor021 = Math.min(potentialFactor021, potentialFactor014 + 1);
		}

		if (isPassable008) {
			potentialFactor003 = Math.min(potentialFactor003, potentialFactor008 + 1);
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor008 + 1);
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor008 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor008 + 1);
		}

		if (isPassable002) {
			potentialFactor001 = Math.min(potentialFactor001, potentialFactor002 + 1);
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor002 + 1);
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor002 + 1);
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor002 + 1);
		}

		if (isPassable000) {
			potentialFactor001 = Math.min(potentialFactor001, potentialFactor000 + 1);
			potentialFactor003 = Math.min(potentialFactor003, potentialFactor000 + 1);
			potentialFactor004 = Math.min(potentialFactor004, potentialFactor000 + 1);
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor000 + 1);
		}

		if (isPassable035) {
			potentialFactor030 = Math.min(potentialFactor030, potentialFactor035 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor035 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor035 + 1);
		}

		if (isPassable021) {
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor021 + 1);
			potentialFactor020 = Math.min(potentialFactor020, potentialFactor021 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor021 + 1);
		}

		if (isPassable015) {
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor015 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor015 + 1);
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor015 + 1);
		}

		if (isPassable001) {
			potentialFactor004 = Math.min(potentialFactor004, potentialFactor001 + 1);
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor001 + 1);
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor001 + 1);
		}

		if (isPassable033) {
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor033 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor033 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor033 + 1);
		}

		if (isPassable029) {
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor029 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor029 + 1);
			potentialFactor030 = Math.min(potentialFactor030, potentialFactor029 + 1);
		}

		if (isPassable007) {
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor007 + 1);
			potentialFactor012 = Math.min(potentialFactor012, potentialFactor007 + 1);
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor007 + 1);
		}

		if (isPassable003) {
			potentialFactor004 = Math.min(potentialFactor004, potentialFactor003 + 1);
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor003 + 1);
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor003 + 1);
		}

		if (isPassable032) {
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor032 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor032 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor032 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor032 + 1);
		}

		if (isPassable030) {
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor030 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor030 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor030 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor030 + 1);
		}

		if (isPassable027) {
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor027 + 1);
			potentialFactor020 = Math.min(potentialFactor020, potentialFactor027 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor027 + 1);
		}

		if (isPassable023) {
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor023 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor023 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor023 + 1);
		}

		if (isPassable013) {
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor013 + 1);
			potentialFactor012 = Math.min(potentialFactor012, potentialFactor013 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor013 + 1);
			potentialFactor020 = Math.min(potentialFactor020, potentialFactor013 + 1);
		}

		if (isPassable009) {
			potentialFactor004 = Math.min(potentialFactor004, potentialFactor009 + 1);
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor009 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor009 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor009 + 1);
		}

		if (isPassable006) {
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor006 + 1);
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor006 + 1);
			potentialFactor012 = Math.min(potentialFactor012, potentialFactor006 + 1);
		}

		if (isPassable004) {
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor004 + 1);
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor004 + 1);
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor004 + 1);
		}

		if (isPassable031) {
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor031 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor031 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor031 + 1);
		}

		if (isPassable020) {
			potentialFactor012 = Math.min(potentialFactor012, potentialFactor020 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor020 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor020 + 1);
		}

		if (isPassable016) {
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor016 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor016 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor016 + 1);
		}

		if (isPassable005) {
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor005 + 1);
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor005 + 1);
			potentialFactor012 = Math.min(potentialFactor012, potentialFactor005 + 1);
		}

		if (isPassable026) {
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor026 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor026 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor026 + 1);
		}

		if (isPassable024) {
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor024 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor024 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor024 + 1);
		}

		if (isPassable012) {
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor012 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor012 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor012 + 1);
		}

		if (isPassable010) {
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor010 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor010 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor010 + 1);
		}

		if (isPassable025) {
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor025 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor025 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor025 + 1);
		}

		if (isPassable019) {
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor019 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor019 + 1);
		}

		if (isPassable017) {
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor017 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor017 + 1);
		}

		if (isPassable011) {
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor011 + 1);
		}

		int bestValue = 256;
		Direction bestDirection = null;
		Direction tempCurrentDirection = null;
		MapLocation bestLocation = null;
		if (isPassable000) {
			tempCurrentDirection = mapinfo000.getCurrentDirection();
			switch (tempCurrentDirection) {
			case CENTER:
				if (isPassable000 && accessibilityFactor000 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor000;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case EAST:
				if (isPassable001 && accessibilityFactor000 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor001;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case SOUTHWEST:
				if (isPassable003 && accessibilityFactor000 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor003;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case SOUTH:
				if (isPassable004 && accessibilityFactor000 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor004;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case SOUTHEAST:
				if (isPassable005 && accessibilityFactor000 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor005;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			default: break;
			}
		}
		if (isPassable001) {
			tempCurrentDirection = mapinfo001.getCurrentDirection();
			switch (tempCurrentDirection) {
			case WEST:
				if (isPassable000 && accessibilityFactor001 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor000;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case CENTER:
				if (isPassable001 && accessibilityFactor001 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor001;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case EAST:
				if (isPassable002 && accessibilityFactor001 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor002;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case SOUTHWEST:
				if (isPassable004 && accessibilityFactor001 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor004;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case SOUTH:
				if (isPassable005 && accessibilityFactor001 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor005;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case SOUTHEAST:
				if (isPassable006 && accessibilityFactor001 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor006;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			default: break;
			}
		}
		if (isPassable002) {
			tempCurrentDirection = mapinfo002.getCurrentDirection();
			switch (tempCurrentDirection) {
			case WEST:
				if (isPassable001 && accessibilityFactor002 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor001;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case CENTER:
				if (isPassable002 && accessibilityFactor002 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor002;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTHWEST:
				if (isPassable005 && accessibilityFactor002 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor005;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTH:
				if (isPassable006 && accessibilityFactor002 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor006;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTHEAST:
				if (isPassable007 && accessibilityFactor002 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor007;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			default: break;
			}
		}
		if (isPassable003) {
			tempCurrentDirection = mapinfo003.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHEAST:
				if (isPassable000 && accessibilityFactor003 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor000;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			case CENTER:
				if (isPassable003 && accessibilityFactor003 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor003;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			case EAST:
				if (isPassable004 && accessibilityFactor003 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor004;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			case SOUTHWEST:
				if (isPassable008 && accessibilityFactor003 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor008;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			case SOUTH:
				if (isPassable009 && accessibilityFactor003 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor009;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			case SOUTHEAST:
				if (isPassable010 && accessibilityFactor003 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor010;
					bestDirection = initialDirection003;
					bestLocation = maploc003;
				}
				break;
			default: break;
			}
		}
		if (isPassable004) {
			tempCurrentDirection = mapinfo004.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable000 && accessibilityFactor004 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor000;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case NORTHEAST:
				if (isPassable001 && accessibilityFactor004 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor001;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case WEST:
				if (isPassable003 && accessibilityFactor004 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor003;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case CENTER:
				if (isPassable004 && accessibilityFactor004 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor004;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case EAST:
				if (isPassable005 && accessibilityFactor004 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor005;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case SOUTHWEST:
				if (isPassable009 && accessibilityFactor004 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor009;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case SOUTH:
				if (isPassable010 && accessibilityFactor004 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor010;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			case SOUTHEAST:
				if (isPassable011 && accessibilityFactor004 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor004 + potentialFactor011;
					bestDirection = initialDirection004;
					bestLocation = maploc004;
				}
				break;
			default: break;
			}
		}
		if (isPassable005) {
			tempCurrentDirection = mapinfo005.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable000 && accessibilityFactor005 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor000;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case NORTH:
				if (isPassable001 && accessibilityFactor005 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor001;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case NORTHEAST:
				if (isPassable002 && accessibilityFactor005 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor002;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case WEST:
				if (isPassable004 && accessibilityFactor005 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor004;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case CENTER:
				if (isPassable005 && accessibilityFactor005 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor005;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case EAST:
				if (isPassable006 && accessibilityFactor005 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor006;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case SOUTHWEST:
				if (isPassable010 && accessibilityFactor005 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor010;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case SOUTH:
				if (isPassable011 && accessibilityFactor005 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor011;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case SOUTHEAST:
				if (isPassable012 && accessibilityFactor005 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor012;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			default: break;
			}
		}
		if (isPassable006) {
			tempCurrentDirection = mapinfo006.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable001 && accessibilityFactor006 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor001;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case NORTH:
				if (isPassable002 && accessibilityFactor006 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor002;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case WEST:
				if (isPassable005 && accessibilityFactor006 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor005;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case CENTER:
				if (isPassable006 && accessibilityFactor006 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor006;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case EAST:
				if (isPassable007 && accessibilityFactor006 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor007;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case SOUTHWEST:
				if (isPassable011 && accessibilityFactor006 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor011;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case SOUTH:
				if (isPassable012 && accessibilityFactor006 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor012;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case SOUTHEAST:
				if (isPassable013 && accessibilityFactor006 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor013;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			default: break;
			}
		}
		if (isPassable007) {
			tempCurrentDirection = mapinfo007.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable002 && accessibilityFactor007 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor002;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case WEST:
				if (isPassable006 && accessibilityFactor007 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor006;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case CENTER:
				if (isPassable007 && accessibilityFactor007 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor007;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTHWEST:
				if (isPassable012 && accessibilityFactor007 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor012;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTH:
				if (isPassable013 && accessibilityFactor007 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor013;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTHEAST:
				if (isPassable014 && accessibilityFactor007 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor014;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			default: break;
			}
		}
		if (isPassable008) {
			tempCurrentDirection = mapinfo008.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHEAST:
				if (isPassable003 && accessibilityFactor008 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor003;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case CENTER:
				if (isPassable008 && accessibilityFactor008 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor008;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case EAST:
				if (isPassable009 && accessibilityFactor008 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor009;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case SOUTH:
				if (isPassable015 && accessibilityFactor008 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor015;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case SOUTHEAST:
				if (isPassable016 && accessibilityFactor008 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor016;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			default: break;
			}
		}
		if (isPassable009) {
			tempCurrentDirection = mapinfo009.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable003 && accessibilityFactor009 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor003;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case NORTHEAST:
				if (isPassable004 && accessibilityFactor009 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor004;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case WEST:
				if (isPassable008 && accessibilityFactor009 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor008;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case CENTER:
				if (isPassable009 && accessibilityFactor009 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor009;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case EAST:
				if (isPassable010 && accessibilityFactor009 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor010;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case SOUTHWEST:
				if (isPassable015 && accessibilityFactor009 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor015;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case SOUTH:
				if (isPassable016 && accessibilityFactor009 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor016;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case SOUTHEAST:
				if (isPassable017 && accessibilityFactor009 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor017;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			default: break;
			}
		}
		if (isPassable010) {
			tempCurrentDirection = mapinfo010.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable003 && accessibilityFactor010 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor003;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case NORTH:
				if (isPassable004 && accessibilityFactor010 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor004;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case NORTHEAST:
				if (isPassable005 && accessibilityFactor010 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor005;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case WEST:
				if (isPassable009 && accessibilityFactor010 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor009;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case CENTER:
				if (isPassable010 && accessibilityFactor010 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor010;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case EAST:
				if (isPassable011 && accessibilityFactor010 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor011;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case SOUTHWEST:
				if (isPassable016 && accessibilityFactor010 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor016;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case SOUTH:
				if (isPassable017 && accessibilityFactor010 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor017;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			default: break;
			}
		}
		if (isPassable011) {
			tempCurrentDirection = mapinfo011.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable004 && accessibilityFactor011 + potentialFactor004 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor004;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case NORTH:
				if (isPassable005 && accessibilityFactor011 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor005;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case NORTHEAST:
				if (isPassable006 && accessibilityFactor011 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor006;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case WEST:
				if (isPassable010 && accessibilityFactor011 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor010;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case CENTER:
				if (isPassable011 && accessibilityFactor011 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor011;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case EAST:
				if (isPassable012 && accessibilityFactor011 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor012;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case SOUTHWEST:
				if (isPassable017 && accessibilityFactor011 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor017;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case SOUTHEAST:
				if (isPassable019 && accessibilityFactor011 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor019;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			default: break;
			}
		}
		if (isPassable012) {
			tempCurrentDirection = mapinfo012.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable005 && accessibilityFactor012 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor005;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case NORTH:
				if (isPassable006 && accessibilityFactor012 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor006;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case NORTHEAST:
				if (isPassable007 && accessibilityFactor012 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor007;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case WEST:
				if (isPassable011 && accessibilityFactor012 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor011;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case CENTER:
				if (isPassable012 && accessibilityFactor012 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor012;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case EAST:
				if (isPassable013 && accessibilityFactor012 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor013;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case SOUTH:
				if (isPassable019 && accessibilityFactor012 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor019;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case SOUTHEAST:
				if (isPassable020 && accessibilityFactor012 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor020;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			default: break;
			}
		}
		if (isPassable013) {
			tempCurrentDirection = mapinfo013.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable006 && accessibilityFactor013 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor006;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case NORTH:
				if (isPassable007 && accessibilityFactor013 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor007;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case WEST:
				if (isPassable012 && accessibilityFactor013 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor012;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case CENTER:
				if (isPassable013 && accessibilityFactor013 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor013;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case EAST:
				if (isPassable014 && accessibilityFactor013 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor014;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case SOUTHWEST:
				if (isPassable019 && accessibilityFactor013 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor019;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case SOUTH:
				if (isPassable020 && accessibilityFactor013 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor020;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case SOUTHEAST:
				if (isPassable021 && accessibilityFactor013 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor021;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			default: break;
			}
		}
		if (isPassable014) {
			tempCurrentDirection = mapinfo014.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable007 && accessibilityFactor014 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor007;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case WEST:
				if (isPassable013 && accessibilityFactor014 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor013;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case CENTER:
				if (isPassable014 && accessibilityFactor014 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor014;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case SOUTHWEST:
				if (isPassable020 && accessibilityFactor014 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor020;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case SOUTH:
				if (isPassable021 && accessibilityFactor014 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor021;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			default: break;
			}
		}
		if (isPassable015) {
			tempCurrentDirection = mapinfo015.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable008 && accessibilityFactor015 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor008;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case NORTHEAST:
				if (isPassable009 && accessibilityFactor015 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor009;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case CENTER:
				if (isPassable015 && accessibilityFactor015 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor015;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case EAST:
				if (isPassable016 && accessibilityFactor015 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor016;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case SOUTH:
				if (isPassable022 && accessibilityFactor015 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor022;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case SOUTHEAST:
				if (isPassable023 && accessibilityFactor015 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor023;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			default: break;
			}
		}
		if (isPassable016) {
			tempCurrentDirection = mapinfo016.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable008 && accessibilityFactor016 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor008;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case NORTH:
				if (isPassable009 && accessibilityFactor016 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor009;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case NORTHEAST:
				if (isPassable010 && accessibilityFactor016 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor010;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case WEST:
				if (isPassable015 && accessibilityFactor016 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor015;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case CENTER:
				if (isPassable016 && accessibilityFactor016 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor016;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case EAST:
				if (isPassable017 && accessibilityFactor016 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor017;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case SOUTHWEST:
				if (isPassable022 && accessibilityFactor016 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor022;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case SOUTH:
				if (isPassable023 && accessibilityFactor016 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor023;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case SOUTHEAST:
				if (isPassable024 && accessibilityFactor016 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor024;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			default: break;
			}
		}
		if (isPassable017) {
			tempCurrentDirection = mapinfo017.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable009 && accessibilityFactor017 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor009;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case NORTH:
				if (isPassable010 && accessibilityFactor017 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor010;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case NORTHEAST:
				if (isPassable011 && accessibilityFactor017 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor011;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case WEST:
				if (isPassable016 && accessibilityFactor017 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor016;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case CENTER:
				if (isPassable017 && accessibilityFactor017 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor017;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTHWEST:
				if (isPassable023 && accessibilityFactor017 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor023;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTH:
				if (isPassable024 && accessibilityFactor017 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor024;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTHEAST:
				if (isPassable025 && accessibilityFactor017 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor025;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			default: break;
			}
		}
		if (isPassable018) {
			tempCurrentDirection = mapinfo018.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable010 && accessibilityFactor018 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor010;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case NORTH:
				if (isPassable011 && accessibilityFactor018 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor011;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case NORTHEAST:
				if (isPassable012 && accessibilityFactor018 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor012;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case WEST:
				if (isPassable017 && accessibilityFactor018 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor017;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case EAST:
				if (isPassable019 && accessibilityFactor018 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor019;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case SOUTHWEST:
				if (isPassable024 && accessibilityFactor018 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor024;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case SOUTH:
				if (isPassable025 && accessibilityFactor018 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor025;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case SOUTHEAST:
				if (isPassable026 && accessibilityFactor018 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor026;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			default: break;
			}
		}
		if (isPassable019) {
			tempCurrentDirection = mapinfo019.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable011 && accessibilityFactor019 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor011;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case NORTH:
				if (isPassable012 && accessibilityFactor019 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor012;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case NORTHEAST:
				if (isPassable013 && accessibilityFactor019 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor013;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case CENTER:
				if (isPassable019 && accessibilityFactor019 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor019;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case EAST:
				if (isPassable020 && accessibilityFactor019 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor020;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case SOUTHWEST:
				if (isPassable025 && accessibilityFactor019 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor025;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case SOUTH:
				if (isPassable026 && accessibilityFactor019 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor026;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case SOUTHEAST:
				if (isPassable027 && accessibilityFactor019 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor027;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			default: break;
			}
		}
		if (isPassable020) {
			tempCurrentDirection = mapinfo020.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable012 && accessibilityFactor020 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor012;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case NORTH:
				if (isPassable013 && accessibilityFactor020 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor013;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case NORTHEAST:
				if (isPassable014 && accessibilityFactor020 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor014;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case WEST:
				if (isPassable019 && accessibilityFactor020 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor019;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case CENTER:
				if (isPassable020 && accessibilityFactor020 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor020;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case EAST:
				if (isPassable021 && accessibilityFactor020 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor021;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case SOUTHWEST:
				if (isPassable026 && accessibilityFactor020 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor026;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case SOUTH:
				if (isPassable027 && accessibilityFactor020 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor027;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case SOUTHEAST:
				if (isPassable028 && accessibilityFactor020 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor028;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			default: break;
			}
		}
		if (isPassable021) {
			tempCurrentDirection = mapinfo021.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable013 && accessibilityFactor021 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor013;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case NORTH:
				if (isPassable014 && accessibilityFactor021 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor014;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case WEST:
				if (isPassable020 && accessibilityFactor021 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor020;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case CENTER:
				if (isPassable021 && accessibilityFactor021 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor021;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case SOUTHWEST:
				if (isPassable027 && accessibilityFactor021 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor027;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case SOUTH:
				if (isPassable028 && accessibilityFactor021 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor028;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			default: break;
			}
		}
		if (isPassable022) {
			tempCurrentDirection = mapinfo022.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable015 && accessibilityFactor022 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor015;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case NORTHEAST:
				if (isPassable016 && accessibilityFactor022 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor016;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case CENTER:
				if (isPassable022 && accessibilityFactor022 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor022;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case EAST:
				if (isPassable023 && accessibilityFactor022 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor023;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case SOUTHEAST:
				if (isPassable029 && accessibilityFactor022 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor029;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			default: break;
			}
		}
		if (isPassable023) {
			tempCurrentDirection = mapinfo023.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable015 && accessibilityFactor023 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor015;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case NORTH:
				if (isPassable016 && accessibilityFactor023 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor016;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case NORTHEAST:
				if (isPassable017 && accessibilityFactor023 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor017;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case WEST:
				if (isPassable022 && accessibilityFactor023 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor022;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case CENTER:
				if (isPassable023 && accessibilityFactor023 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor023;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case EAST:
				if (isPassable024 && accessibilityFactor023 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor024;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case SOUTH:
				if (isPassable029 && accessibilityFactor023 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor029;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case SOUTHEAST:
				if (isPassable030 && accessibilityFactor023 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor030;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			default: break;
			}
		}
		if (isPassable024) {
			tempCurrentDirection = mapinfo024.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable016 && accessibilityFactor024 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor016;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case NORTH:
				if (isPassable017 && accessibilityFactor024 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor017;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case WEST:
				if (isPassable023 && accessibilityFactor024 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor023;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case CENTER:
				if (isPassable024 && accessibilityFactor024 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor024;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case EAST:
				if (isPassable025 && accessibilityFactor024 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor025;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case SOUTHWEST:
				if (isPassable029 && accessibilityFactor024 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor029;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case SOUTH:
				if (isPassable030 && accessibilityFactor024 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor030;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case SOUTHEAST:
				if (isPassable031 && accessibilityFactor024 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor031;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			default: break;
			}
		}
		if (isPassable025) {
			tempCurrentDirection = mapinfo025.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable017 && accessibilityFactor025 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor017;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case NORTHEAST:
				if (isPassable019 && accessibilityFactor025 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor019;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case WEST:
				if (isPassable024 && accessibilityFactor025 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor024;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case CENTER:
				if (isPassable025 && accessibilityFactor025 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor025;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case EAST:
				if (isPassable026 && accessibilityFactor025 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor026;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case SOUTHWEST:
				if (isPassable030 && accessibilityFactor025 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor030;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case SOUTH:
				if (isPassable031 && accessibilityFactor025 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor031;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case SOUTHEAST:
				if (isPassable032 && accessibilityFactor025 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor032;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			default: break;
			}
		}
		if (isPassable026) {
			tempCurrentDirection = mapinfo026.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable019 && accessibilityFactor026 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor019;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case NORTHEAST:
				if (isPassable020 && accessibilityFactor026 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor020;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case WEST:
				if (isPassable025 && accessibilityFactor026 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor025;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case CENTER:
				if (isPassable026 && accessibilityFactor026 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor026;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case EAST:
				if (isPassable027 && accessibilityFactor026 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor027;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case SOUTHWEST:
				if (isPassable031 && accessibilityFactor026 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor031;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case SOUTH:
				if (isPassable032 && accessibilityFactor026 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor032;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case SOUTHEAST:
				if (isPassable033 && accessibilityFactor026 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor033;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			default: break;
			}
		}
		if (isPassable027) {
			tempCurrentDirection = mapinfo027.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable019 && accessibilityFactor027 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor019;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case NORTH:
				if (isPassable020 && accessibilityFactor027 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor020;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case NORTHEAST:
				if (isPassable021 && accessibilityFactor027 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor021;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case WEST:
				if (isPassable026 && accessibilityFactor027 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor026;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case CENTER:
				if (isPassable027 && accessibilityFactor027 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor027;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case EAST:
				if (isPassable028 && accessibilityFactor027 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor028;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case SOUTHWEST:
				if (isPassable032 && accessibilityFactor027 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor032;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case SOUTH:
				if (isPassable033 && accessibilityFactor027 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor033;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			default: break;
			}
		}
		if (isPassable028) {
			tempCurrentDirection = mapinfo028.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable020 && accessibilityFactor028 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor020;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case NORTH:
				if (isPassable021 && accessibilityFactor028 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor021;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case WEST:
				if (isPassable027 && accessibilityFactor028 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor027;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case CENTER:
				if (isPassable028 && accessibilityFactor028 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor028;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case SOUTHWEST:
				if (isPassable033 && accessibilityFactor028 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor033;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			default: break;
			}
		}
		if (isPassable029) {
			tempCurrentDirection = mapinfo029.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable022 && accessibilityFactor029 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor022;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case NORTH:
				if (isPassable023 && accessibilityFactor029 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor023;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case NORTHEAST:
				if (isPassable024 && accessibilityFactor029 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor024;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case CENTER:
				if (isPassable029 && accessibilityFactor029 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor029;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case EAST:
				if (isPassable030 && accessibilityFactor029 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor030;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case SOUTHEAST:
				if (isPassable034 && accessibilityFactor029 + potentialFactor034 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor034;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			default: break;
			}
		}
		if (isPassable030) {
			tempCurrentDirection = mapinfo030.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable023 && accessibilityFactor030 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor023;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case NORTH:
				if (isPassable024 && accessibilityFactor030 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor024;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case NORTHEAST:
				if (isPassable025 && accessibilityFactor030 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor025;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case WEST:
				if (isPassable029 && accessibilityFactor030 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor029;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case CENTER:
				if (isPassable030 && accessibilityFactor030 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor030;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case EAST:
				if (isPassable031 && accessibilityFactor030 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor031;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case SOUTH:
				if (isPassable034 && accessibilityFactor030 + potentialFactor034 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor034;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case SOUTHEAST:
				if (isPassable035 && accessibilityFactor030 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor035;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			default: break;
			}
		}
		if (isPassable031) {
			tempCurrentDirection = mapinfo031.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable024 && accessibilityFactor031 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor024;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case NORTH:
				if (isPassable025 && accessibilityFactor031 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor025;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case NORTHEAST:
				if (isPassable026 && accessibilityFactor031 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor026;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case WEST:
				if (isPassable030 && accessibilityFactor031 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor030;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case CENTER:
				if (isPassable031 && accessibilityFactor031 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor031;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case EAST:
				if (isPassable032 && accessibilityFactor031 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor032;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case SOUTHWEST:
				if (isPassable034 && accessibilityFactor031 + potentialFactor034 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor034;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case SOUTH:
				if (isPassable035 && accessibilityFactor031 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor035;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case SOUTHEAST:
				if (isPassable036 && accessibilityFactor031 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor036;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			default: break;
			}
		}
		if (isPassable032) {
			tempCurrentDirection = mapinfo032.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable025 && accessibilityFactor032 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor025;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case NORTH:
				if (isPassable026 && accessibilityFactor032 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor026;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case NORTHEAST:
				if (isPassable027 && accessibilityFactor032 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor027;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case WEST:
				if (isPassable031 && accessibilityFactor032 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor031;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case CENTER:
				if (isPassable032 && accessibilityFactor032 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor032;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case EAST:
				if (isPassable033 && accessibilityFactor032 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor033;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case SOUTHWEST:
				if (isPassable035 && accessibilityFactor032 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor035;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case SOUTH:
				if (isPassable036 && accessibilityFactor032 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor036;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			default: break;
			}
		}
		if (isPassable033) {
			tempCurrentDirection = mapinfo033.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable026 && accessibilityFactor033 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor026;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case NORTH:
				if (isPassable027 && accessibilityFactor033 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor027;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case NORTHEAST:
				if (isPassable028 && accessibilityFactor033 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor028;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case WEST:
				if (isPassable032 && accessibilityFactor033 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor032;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case CENTER:
				if (isPassable033 && accessibilityFactor033 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor033;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case SOUTHWEST:
				if (isPassable036 && accessibilityFactor033 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor036;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			default: break;
			}
		}
		if (isPassable034) {
			tempCurrentDirection = mapinfo034.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable029 && accessibilityFactor034 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor029;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case NORTH:
				if (isPassable030 && accessibilityFactor034 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor030;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case NORTHEAST:
				if (isPassable031 && accessibilityFactor034 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor031;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case CENTER:
				if (isPassable034 && accessibilityFactor034 + potentialFactor034 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor034;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case EAST:
				if (isPassable035 && accessibilityFactor034 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor035;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			default: break;
			}
		}
		if (isPassable035) {
			tempCurrentDirection = mapinfo035.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable030 && accessibilityFactor035 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor030;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case NORTH:
				if (isPassable031 && accessibilityFactor035 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor031;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case NORTHEAST:
				if (isPassable032 && accessibilityFactor035 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor032;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case WEST:
				if (isPassable034 && accessibilityFactor035 + potentialFactor034 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor034;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case CENTER:
				if (isPassable035 && accessibilityFactor035 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor035;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case EAST:
				if (isPassable036 && accessibilityFactor035 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor036;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			default: break;
			}
		}
		if (isPassable036) {
			tempCurrentDirection = mapinfo036.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable031 && accessibilityFactor036 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor031;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case NORTH:
				if (isPassable032 && accessibilityFactor036 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor032;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case NORTHEAST:
				if (isPassable033 && accessibilityFactor036 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor033;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case WEST:
				if (isPassable035 && accessibilityFactor036 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor035;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case CENTER:
				if (isPassable036 && accessibilityFactor036 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor036;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			default: break;
			}
		}
		
		// System.out.println("bestValue = " + bestValue + ", bestDirection = " + (bestDirection == null ? "null" : bestDirection.name()));
		// System.out.println("dx = " + dx + ", dy = " + dy);
		// System.out.println("bestLocation = " + bestLocation.toString());
		if (bestDirection != null) rc.setIndicatorLine(maploc018.add(bestDirection), bestLocation, 0, 255, 0);
		return bestDirection;
	}
}
