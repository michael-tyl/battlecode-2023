package sojourner.bfs;

import battlecode.common.*;
import java.math.*;

public class UnrolledBFS_MR20_VR20 {
	static RobotController rc;

	public static void init(RobotController _rc) { rc = _rc; }

	// 000: movable cell at location (-2, 4) relative to origin
	static MapLocation maploc000;
	static boolean isPassable000;
	static MapInfo mapinfo000;
	static int accessibilityFactor000;
	static int potentialFactor000;
	static Direction initialDirection000;
	
	// 001: movable cell at location (-1, 4) relative to origin
	static MapLocation maploc001;
	static boolean isPassable001;
	static MapInfo mapinfo001;
	static int accessibilityFactor001;
	static int potentialFactor001;
	static Direction initialDirection001;
	
	// 002: movable cell at location (0, 4) relative to origin
	static MapLocation maploc002;
	static boolean isPassable002;
	static MapInfo mapinfo002;
	static int accessibilityFactor002;
	static int potentialFactor002;
	static Direction initialDirection002;
	
	// 003: movable cell at location (1, 4) relative to origin
	static MapLocation maploc003;
	static boolean isPassable003;
	static MapInfo mapinfo003;
	static int accessibilityFactor003;
	static int potentialFactor003;
	static Direction initialDirection003;
	
	// 004: movable cell at location (2, 4) relative to origin
	static MapLocation maploc004;
	static boolean isPassable004;
	static MapInfo mapinfo004;
	static int accessibilityFactor004;
	static int potentialFactor004;
	static Direction initialDirection004;
	
	// 005: movable cell at location (-3, 3) relative to origin
	static MapLocation maploc005;
	static boolean isPassable005;
	static MapInfo mapinfo005;
	static int accessibilityFactor005;
	static int potentialFactor005;
	static Direction initialDirection005;
	
	// 006: movable cell at location (-2, 3) relative to origin
	static MapLocation maploc006;
	static boolean isPassable006;
	static MapInfo mapinfo006;
	static int accessibilityFactor006;
	static int potentialFactor006;
	static Direction initialDirection006;
	
	// 007: movable cell at location (-1, 3) relative to origin
	static MapLocation maploc007;
	static boolean isPassable007;
	static MapInfo mapinfo007;
	static int accessibilityFactor007;
	static int potentialFactor007;
	static Direction initialDirection007;
	
	// 008: movable cell at location (0, 3) relative to origin
	static MapLocation maploc008;
	static boolean isPassable008;
	static MapInfo mapinfo008;
	static int accessibilityFactor008;
	static int potentialFactor008;
	static Direction initialDirection008;
	
	// 009: movable cell at location (1, 3) relative to origin
	static MapLocation maploc009;
	static boolean isPassable009;
	static MapInfo mapinfo009;
	static int accessibilityFactor009;
	static int potentialFactor009;
	static Direction initialDirection009;
	
	// 010: movable cell at location (2, 3) relative to origin
	static MapLocation maploc010;
	static boolean isPassable010;
	static MapInfo mapinfo010;
	static int accessibilityFactor010;
	static int potentialFactor010;
	static Direction initialDirection010;
	
	// 011: movable cell at location (3, 3) relative to origin
	static MapLocation maploc011;
	static boolean isPassable011;
	static MapInfo mapinfo011;
	static int accessibilityFactor011;
	static int potentialFactor011;
	static Direction initialDirection011;
	
	// 012: movable cell at location (-4, 2) relative to origin
	static MapLocation maploc012;
	static boolean isPassable012;
	static MapInfo mapinfo012;
	static int accessibilityFactor012;
	static int potentialFactor012;
	static Direction initialDirection012;
	
	// 013: movable cell at location (-3, 2) relative to origin
	static MapLocation maploc013;
	static boolean isPassable013;
	static MapInfo mapinfo013;
	static int accessibilityFactor013;
	static int potentialFactor013;
	static Direction initialDirection013;
	
	// 014: movable cell at location (-2, 2) relative to origin
	static MapLocation maploc014;
	static boolean isPassable014;
	static MapInfo mapinfo014;
	static int accessibilityFactor014;
	static int potentialFactor014;
	static Direction initialDirection014;
	
	// 015: movable cell at location (-1, 2) relative to origin
	static MapLocation maploc015;
	static boolean isPassable015;
	static MapInfo mapinfo015;
	static int accessibilityFactor015;
	static int potentialFactor015;
	static Direction initialDirection015;
	
	// 016: movable cell at location (0, 2) relative to origin
	static MapLocation maploc016;
	static boolean isPassable016;
	static MapInfo mapinfo016;
	static int accessibilityFactor016;
	static int potentialFactor016;
	static Direction initialDirection016;
	
	// 017: movable cell at location (1, 2) relative to origin
	static MapLocation maploc017;
	static boolean isPassable017;
	static MapInfo mapinfo017;
	static int accessibilityFactor017;
	static int potentialFactor017;
	static Direction initialDirection017;
	
	// 018: movable cell at location (2, 2) relative to origin
	static MapLocation maploc018;
	static boolean isPassable018;
	static MapInfo mapinfo018;
	static int accessibilityFactor018;
	static int potentialFactor018;
	static Direction initialDirection018;
	
	// 019: movable cell at location (3, 2) relative to origin
	static MapLocation maploc019;
	static boolean isPassable019;
	static MapInfo mapinfo019;
	static int accessibilityFactor019;
	static int potentialFactor019;
	static Direction initialDirection019;
	
	// 020: movable cell at location (4, 2) relative to origin
	static MapLocation maploc020;
	static boolean isPassable020;
	static MapInfo mapinfo020;
	static int accessibilityFactor020;
	static int potentialFactor020;
	static Direction initialDirection020;
	
	// 021: movable cell at location (-4, 1) relative to origin
	static MapLocation maploc021;
	static boolean isPassable021;
	static MapInfo mapinfo021;
	static int accessibilityFactor021;
	static int potentialFactor021;
	static Direction initialDirection021;
	
	// 022: movable cell at location (-3, 1) relative to origin
	static MapLocation maploc022;
	static boolean isPassable022;
	static MapInfo mapinfo022;
	static int accessibilityFactor022;
	static int potentialFactor022;
	static Direction initialDirection022;
	
	// 023: movable cell at location (-2, 1) relative to origin
	static MapLocation maploc023;
	static boolean isPassable023;
	static MapInfo mapinfo023;
	static int accessibilityFactor023;
	static int potentialFactor023;
	static Direction initialDirection023;
	
	// 024: movable cell at location (-1, 1) relative to origin
	static MapLocation maploc024;
	static boolean isPassable024;
	static MapInfo mapinfo024;
	static int accessibilityFactor024;
	static int potentialFactor024;
	static Direction initialDirection024;
	
	// 025: movable cell at location (0, 1) relative to origin
	static MapLocation maploc025;
	static boolean isPassable025;
	static MapInfo mapinfo025;
	static int accessibilityFactor025;
	static int potentialFactor025;
	static Direction initialDirection025;
	
	// 026: movable cell at location (1, 1) relative to origin
	static MapLocation maploc026;
	static boolean isPassable026;
	static MapInfo mapinfo026;
	static int accessibilityFactor026;
	static int potentialFactor026;
	static Direction initialDirection026;
	
	// 027: movable cell at location (2, 1) relative to origin
	static MapLocation maploc027;
	static boolean isPassable027;
	static MapInfo mapinfo027;
	static int accessibilityFactor027;
	static int potentialFactor027;
	static Direction initialDirection027;
	
	// 028: movable cell at location (3, 1) relative to origin
	static MapLocation maploc028;
	static boolean isPassable028;
	static MapInfo mapinfo028;
	static int accessibilityFactor028;
	static int potentialFactor028;
	static Direction initialDirection028;
	
	// 029: movable cell at location (4, 1) relative to origin
	static MapLocation maploc029;
	static boolean isPassable029;
	static MapInfo mapinfo029;
	static int accessibilityFactor029;
	static int potentialFactor029;
	static Direction initialDirection029;
	
	// 030: movable cell at location (-4, 0) relative to origin
	static MapLocation maploc030;
	static boolean isPassable030;
	static MapInfo mapinfo030;
	static int accessibilityFactor030;
	static int potentialFactor030;
	static Direction initialDirection030;
	
	// 031: movable cell at location (-3, 0) relative to origin
	static MapLocation maploc031;
	static boolean isPassable031;
	static MapInfo mapinfo031;
	static int accessibilityFactor031;
	static int potentialFactor031;
	static Direction initialDirection031;
	
	// 032: movable cell at location (-2, 0) relative to origin
	static MapLocation maploc032;
	static boolean isPassable032;
	static MapInfo mapinfo032;
	static int accessibilityFactor032;
	static int potentialFactor032;
	static Direction initialDirection032;
	
	// 033: movable cell at location (-1, 0) relative to origin
	static MapLocation maploc033;
	static boolean isPassable033;
	static MapInfo mapinfo033;
	static int accessibilityFactor033;
	static int potentialFactor033;
	static Direction initialDirection033;
	
	// 034: movable cell at location (0, 0) relative to origin
	static MapLocation maploc034;
	static boolean isPassable034;
	static MapInfo mapinfo034;
	static int accessibilityFactor034;
	static int potentialFactor034;
	static Direction initialDirection034;
	
	// 035: movable cell at location (1, 0) relative to origin
	static MapLocation maploc035;
	static boolean isPassable035;
	static MapInfo mapinfo035;
	static int accessibilityFactor035;
	static int potentialFactor035;
	static Direction initialDirection035;
	
	// 036: movable cell at location (2, 0) relative to origin
	static MapLocation maploc036;
	static boolean isPassable036;
	static MapInfo mapinfo036;
	static int accessibilityFactor036;
	static int potentialFactor036;
	static Direction initialDirection036;
	
	// 037: movable cell at location (3, 0) relative to origin
	static MapLocation maploc037;
	static boolean isPassable037;
	static MapInfo mapinfo037;
	static int accessibilityFactor037;
	static int potentialFactor037;
	static Direction initialDirection037;
	
	// 038: movable cell at location (4, 0) relative to origin
	static MapLocation maploc038;
	static boolean isPassable038;
	static MapInfo mapinfo038;
	static int accessibilityFactor038;
	static int potentialFactor038;
	static Direction initialDirection038;
	
	// 039: movable cell at location (-4, -1) relative to origin
	static MapLocation maploc039;
	static boolean isPassable039;
	static MapInfo mapinfo039;
	static int accessibilityFactor039;
	static int potentialFactor039;
	static Direction initialDirection039;
	
	// 040: movable cell at location (-3, -1) relative to origin
	static MapLocation maploc040;
	static boolean isPassable040;
	static MapInfo mapinfo040;
	static int accessibilityFactor040;
	static int potentialFactor040;
	static Direction initialDirection040;
	
	// 041: movable cell at location (-2, -1) relative to origin
	static MapLocation maploc041;
	static boolean isPassable041;
	static MapInfo mapinfo041;
	static int accessibilityFactor041;
	static int potentialFactor041;
	static Direction initialDirection041;
	
	// 042: movable cell at location (-1, -1) relative to origin
	static MapLocation maploc042;
	static boolean isPassable042;
	static MapInfo mapinfo042;
	static int accessibilityFactor042;
	static int potentialFactor042;
	static Direction initialDirection042;
	
	// 043: movable cell at location (0, -1) relative to origin
	static MapLocation maploc043;
	static boolean isPassable043;
	static MapInfo mapinfo043;
	static int accessibilityFactor043;
	static int potentialFactor043;
	static Direction initialDirection043;
	
	// 044: movable cell at location (1, -1) relative to origin
	static MapLocation maploc044;
	static boolean isPassable044;
	static MapInfo mapinfo044;
	static int accessibilityFactor044;
	static int potentialFactor044;
	static Direction initialDirection044;
	
	// 045: movable cell at location (2, -1) relative to origin
	static MapLocation maploc045;
	static boolean isPassable045;
	static MapInfo mapinfo045;
	static int accessibilityFactor045;
	static int potentialFactor045;
	static Direction initialDirection045;
	
	// 046: movable cell at location (3, -1) relative to origin
	static MapLocation maploc046;
	static boolean isPassable046;
	static MapInfo mapinfo046;
	static int accessibilityFactor046;
	static int potentialFactor046;
	static Direction initialDirection046;
	
	// 047: movable cell at location (4, -1) relative to origin
	static MapLocation maploc047;
	static boolean isPassable047;
	static MapInfo mapinfo047;
	static int accessibilityFactor047;
	static int potentialFactor047;
	static Direction initialDirection047;
	
	// 048: movable cell at location (-4, -2) relative to origin
	static MapLocation maploc048;
	static boolean isPassable048;
	static MapInfo mapinfo048;
	static int accessibilityFactor048;
	static int potentialFactor048;
	static Direction initialDirection048;
	
	// 049: movable cell at location (-3, -2) relative to origin
	static MapLocation maploc049;
	static boolean isPassable049;
	static MapInfo mapinfo049;
	static int accessibilityFactor049;
	static int potentialFactor049;
	static Direction initialDirection049;
	
	// 050: movable cell at location (-2, -2) relative to origin
	static MapLocation maploc050;
	static boolean isPassable050;
	static MapInfo mapinfo050;
	static int accessibilityFactor050;
	static int potentialFactor050;
	static Direction initialDirection050;
	
	// 051: movable cell at location (-1, -2) relative to origin
	static MapLocation maploc051;
	static boolean isPassable051;
	static MapInfo mapinfo051;
	static int accessibilityFactor051;
	static int potentialFactor051;
	static Direction initialDirection051;
	
	// 052: movable cell at location (0, -2) relative to origin
	static MapLocation maploc052;
	static boolean isPassable052;
	static MapInfo mapinfo052;
	static int accessibilityFactor052;
	static int potentialFactor052;
	static Direction initialDirection052;
	
	// 053: movable cell at location (1, -2) relative to origin
	static MapLocation maploc053;
	static boolean isPassable053;
	static MapInfo mapinfo053;
	static int accessibilityFactor053;
	static int potentialFactor053;
	static Direction initialDirection053;
	
	// 054: movable cell at location (2, -2) relative to origin
	static MapLocation maploc054;
	static boolean isPassable054;
	static MapInfo mapinfo054;
	static int accessibilityFactor054;
	static int potentialFactor054;
	static Direction initialDirection054;
	
	// 055: movable cell at location (3, -2) relative to origin
	static MapLocation maploc055;
	static boolean isPassable055;
	static MapInfo mapinfo055;
	static int accessibilityFactor055;
	static int potentialFactor055;
	static Direction initialDirection055;
	
	// 056: movable cell at location (4, -2) relative to origin
	static MapLocation maploc056;
	static boolean isPassable056;
	static MapInfo mapinfo056;
	static int accessibilityFactor056;
	static int potentialFactor056;
	static Direction initialDirection056;
	
	// 057: movable cell at location (-3, -3) relative to origin
	static MapLocation maploc057;
	static boolean isPassable057;
	static MapInfo mapinfo057;
	static int accessibilityFactor057;
	static int potentialFactor057;
	static Direction initialDirection057;
	
	// 058: movable cell at location (-2, -3) relative to origin
	static MapLocation maploc058;
	static boolean isPassable058;
	static MapInfo mapinfo058;
	static int accessibilityFactor058;
	static int potentialFactor058;
	static Direction initialDirection058;
	
	// 059: movable cell at location (-1, -3) relative to origin
	static MapLocation maploc059;
	static boolean isPassable059;
	static MapInfo mapinfo059;
	static int accessibilityFactor059;
	static int potentialFactor059;
	static Direction initialDirection059;
	
	// 060: movable cell at location (0, -3) relative to origin
	static MapLocation maploc060;
	static boolean isPassable060;
	static MapInfo mapinfo060;
	static int accessibilityFactor060;
	static int potentialFactor060;
	static Direction initialDirection060;
	
	// 061: movable cell at location (1, -3) relative to origin
	static MapLocation maploc061;
	static boolean isPassable061;
	static MapInfo mapinfo061;
	static int accessibilityFactor061;
	static int potentialFactor061;
	static Direction initialDirection061;
	
	// 062: movable cell at location (2, -3) relative to origin
	static MapLocation maploc062;
	static boolean isPassable062;
	static MapInfo mapinfo062;
	static int accessibilityFactor062;
	static int potentialFactor062;
	static Direction initialDirection062;
	
	// 063: movable cell at location (3, -3) relative to origin
	static MapLocation maploc063;
	static boolean isPassable063;
	static MapInfo mapinfo063;
	static int accessibilityFactor063;
	static int potentialFactor063;
	static Direction initialDirection063;
	
	// 064: movable cell at location (-2, -4) relative to origin
	static MapLocation maploc064;
	static boolean isPassable064;
	static MapInfo mapinfo064;
	static int accessibilityFactor064;
	static int potentialFactor064;
	static Direction initialDirection064;
	
	// 065: movable cell at location (-1, -4) relative to origin
	static MapLocation maploc065;
	static boolean isPassable065;
	static MapInfo mapinfo065;
	static int accessibilityFactor065;
	static int potentialFactor065;
	static Direction initialDirection065;
	
	// 066: movable cell at location (0, -4) relative to origin
	static MapLocation maploc066;
	static boolean isPassable066;
	static MapInfo mapinfo066;
	static int accessibilityFactor066;
	static int potentialFactor066;
	static Direction initialDirection066;
	
	// 067: movable cell at location (1, -4) relative to origin
	static MapLocation maploc067;
	static boolean isPassable067;
	static MapInfo mapinfo067;
	static int accessibilityFactor067;
	static int potentialFactor067;
	static Direction initialDirection067;
	
	// 068: movable cell at location (2, -4) relative to origin
	static MapLocation maploc068;
	static boolean isPassable068;
	static MapInfo mapinfo068;
	static int accessibilityFactor068;
	static int potentialFactor068;
	static Direction initialDirection068;
	
	
	/* tries to get exactly to target in one move per turn */
	public static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {
		maploc034 = rc.getLocation();
		mapinfo034 = rc.senseMapInfo(maploc034);
		isPassable034 = true;
		accessibilityFactor034 = 0;
		potentialFactor034 = 256;
		initialDirection034 = null;
		
		maploc024 = maploc034.add(Direction.NORTHWEST);
		accessibilityFactor024 = 256;
		potentialFactor024 = 256;
		initialDirection024 = null;
		if (rc.onTheMap(maploc024)) {
			mapinfo024 = rc.senseMapInfo(maploc024);
			isPassable024 = mapinfo024.isPassable() && rc.senseRobotAtLocation(maploc024) == null;
		} else {
			isPassable024 = false;
		}

		maploc025 = maploc034.add(Direction.NORTH);
		accessibilityFactor025 = 256;
		potentialFactor025 = 256;
		initialDirection025 = null;
		if (rc.onTheMap(maploc025)) {
			mapinfo025 = rc.senseMapInfo(maploc025);
			isPassable025 = mapinfo025.isPassable() && rc.senseRobotAtLocation(maploc025) == null;
		} else {
			isPassable025 = false;
		}

		maploc026 = maploc034.add(Direction.NORTHEAST);
		accessibilityFactor026 = 256;
		potentialFactor026 = 256;
		initialDirection026 = null;
		if (rc.onTheMap(maploc026)) {
			mapinfo026 = rc.senseMapInfo(maploc026);
			isPassable026 = mapinfo026.isPassable() && rc.senseRobotAtLocation(maploc026) == null;
		} else {
			isPassable026 = false;
		}

		maploc033 = maploc034.add(Direction.WEST);
		accessibilityFactor033 = 256;
		potentialFactor033 = 256;
		initialDirection033 = null;
		if (rc.onTheMap(maploc033)) {
			mapinfo033 = rc.senseMapInfo(maploc033);
			isPassable033 = mapinfo033.isPassable() && rc.senseRobotAtLocation(maploc033) == null;
		} else {
			isPassable033 = false;
		}

		maploc035 = maploc034.add(Direction.EAST);
		accessibilityFactor035 = 256;
		potentialFactor035 = 256;
		initialDirection035 = null;
		if (rc.onTheMap(maploc035)) {
			mapinfo035 = rc.senseMapInfo(maploc035);
			isPassable035 = mapinfo035.isPassable() && rc.senseRobotAtLocation(maploc035) == null;
		} else {
			isPassable035 = false;
		}

		maploc042 = maploc034.add(Direction.SOUTHWEST);
		accessibilityFactor042 = 256;
		potentialFactor042 = 256;
		initialDirection042 = null;
		if (rc.onTheMap(maploc042)) {
			mapinfo042 = rc.senseMapInfo(maploc042);
			isPassable042 = mapinfo042.isPassable() && rc.senseRobotAtLocation(maploc042) == null;
		} else {
			isPassable042 = false;
		}

		maploc043 = maploc034.add(Direction.SOUTH);
		accessibilityFactor043 = 256;
		potentialFactor043 = 256;
		initialDirection043 = null;
		if (rc.onTheMap(maploc043)) {
			mapinfo043 = rc.senseMapInfo(maploc043);
			isPassable043 = mapinfo043.isPassable() && rc.senseRobotAtLocation(maploc043) == null;
		} else {
			isPassable043 = false;
		}

		maploc044 = maploc034.add(Direction.SOUTHEAST);
		accessibilityFactor044 = 256;
		potentialFactor044 = 256;
		initialDirection044 = null;
		if (rc.onTheMap(maploc044)) {
			mapinfo044 = rc.senseMapInfo(maploc044);
			isPassable044 = mapinfo044.isPassable() && rc.senseRobotAtLocation(maploc044) == null;
		} else {
			isPassable044 = false;
		}

		maploc014 = maploc024.add(Direction.NORTHWEST);
		accessibilityFactor014 = 256;
		potentialFactor014 = 256;
		initialDirection014 = null;
		if (rc.onTheMap(maploc014)) {
			mapinfo014 = rc.senseMapInfo(maploc014);
			isPassable014 = mapinfo014.isPassable() && rc.senseRobotAtLocation(maploc014) == null;
		} else {
			isPassable014 = false;
		}

		maploc015 = maploc024.add(Direction.NORTH);
		accessibilityFactor015 = 256;
		potentialFactor015 = 256;
		initialDirection015 = null;
		if (rc.onTheMap(maploc015)) {
			mapinfo015 = rc.senseMapInfo(maploc015);
			isPassable015 = mapinfo015.isPassable() && rc.senseRobotAtLocation(maploc015) == null;
		} else {
			isPassable015 = false;
		}

		maploc016 = maploc024.add(Direction.NORTHEAST);
		accessibilityFactor016 = 256;
		potentialFactor016 = 256;
		initialDirection016 = null;
		if (rc.onTheMap(maploc016)) {
			mapinfo016 = rc.senseMapInfo(maploc016);
			isPassable016 = mapinfo016.isPassable() && rc.senseRobotAtLocation(maploc016) == null;
		} else {
			isPassable016 = false;
		}

		maploc023 = maploc024.add(Direction.WEST);
		accessibilityFactor023 = 256;
		potentialFactor023 = 256;
		initialDirection023 = null;
		if (rc.onTheMap(maploc023)) {
			mapinfo023 = rc.senseMapInfo(maploc023);
			isPassable023 = mapinfo023.isPassable() && rc.senseRobotAtLocation(maploc023) == null;
		} else {
			isPassable023 = false;
		}

		maploc032 = maploc024.add(Direction.SOUTHWEST);
		accessibilityFactor032 = 256;
		potentialFactor032 = 256;
		initialDirection032 = null;
		if (rc.onTheMap(maploc032)) {
			mapinfo032 = rc.senseMapInfo(maploc032);
			isPassable032 = mapinfo032.isPassable() && rc.senseRobotAtLocation(maploc032) == null;
		} else {
			isPassable032 = false;
		}

		maploc017 = maploc025.add(Direction.NORTHEAST);
		accessibilityFactor017 = 256;
		potentialFactor017 = 256;
		initialDirection017 = null;
		if (rc.onTheMap(maploc017)) {
			mapinfo017 = rc.senseMapInfo(maploc017);
			isPassable017 = mapinfo017.isPassable() && rc.senseRobotAtLocation(maploc017) == null;
		} else {
			isPassable017 = false;
		}

		maploc018 = maploc026.add(Direction.NORTHEAST);
		accessibilityFactor018 = 256;
		potentialFactor018 = 256;
		initialDirection018 = null;
		if (rc.onTheMap(maploc018)) {
			mapinfo018 = rc.senseMapInfo(maploc018);
			isPassable018 = mapinfo018.isPassable() && rc.senseRobotAtLocation(maploc018) == null;
		} else {
			isPassable018 = false;
		}

		maploc027 = maploc026.add(Direction.EAST);
		accessibilityFactor027 = 256;
		potentialFactor027 = 256;
		initialDirection027 = null;
		if (rc.onTheMap(maploc027)) {
			mapinfo027 = rc.senseMapInfo(maploc027);
			isPassable027 = mapinfo027.isPassable() && rc.senseRobotAtLocation(maploc027) == null;
		} else {
			isPassable027 = false;
		}

		maploc036 = maploc026.add(Direction.SOUTHEAST);
		accessibilityFactor036 = 256;
		potentialFactor036 = 256;
		initialDirection036 = null;
		if (rc.onTheMap(maploc036)) {
			mapinfo036 = rc.senseMapInfo(maploc036);
			isPassable036 = mapinfo036.isPassable() && rc.senseRobotAtLocation(maploc036) == null;
		} else {
			isPassable036 = false;
		}

		maploc041 = maploc033.add(Direction.SOUTHWEST);
		accessibilityFactor041 = 256;
		potentialFactor041 = 256;
		initialDirection041 = null;
		if (rc.onTheMap(maploc041)) {
			mapinfo041 = rc.senseMapInfo(maploc041);
			isPassable041 = mapinfo041.isPassable() && rc.senseRobotAtLocation(maploc041) == null;
		} else {
			isPassable041 = false;
		}

		maploc045 = maploc035.add(Direction.SOUTHEAST);
		accessibilityFactor045 = 256;
		potentialFactor045 = 256;
		initialDirection045 = null;
		if (rc.onTheMap(maploc045)) {
			mapinfo045 = rc.senseMapInfo(maploc045);
			isPassable045 = mapinfo045.isPassable() && rc.senseRobotAtLocation(maploc045) == null;
		} else {
			isPassable045 = false;
		}

		maploc050 = maploc042.add(Direction.SOUTHWEST);
		accessibilityFactor050 = 256;
		potentialFactor050 = 256;
		initialDirection050 = null;
		if (rc.onTheMap(maploc050)) {
			mapinfo050 = rc.senseMapInfo(maploc050);
			isPassable050 = mapinfo050.isPassable() && rc.senseRobotAtLocation(maploc050) == null;
		} else {
			isPassable050 = false;
		}

		maploc051 = maploc042.add(Direction.SOUTH);
		accessibilityFactor051 = 256;
		potentialFactor051 = 256;
		initialDirection051 = null;
		if (rc.onTheMap(maploc051)) {
			mapinfo051 = rc.senseMapInfo(maploc051);
			isPassable051 = mapinfo051.isPassable() && rc.senseRobotAtLocation(maploc051) == null;
		} else {
			isPassable051 = false;
		}

		maploc052 = maploc042.add(Direction.SOUTHEAST);
		accessibilityFactor052 = 256;
		potentialFactor052 = 256;
		initialDirection052 = null;
		if (rc.onTheMap(maploc052)) {
			mapinfo052 = rc.senseMapInfo(maploc052);
			isPassable052 = mapinfo052.isPassable() && rc.senseRobotAtLocation(maploc052) == null;
		} else {
			isPassable052 = false;
		}

		maploc053 = maploc043.add(Direction.SOUTHEAST);
		accessibilityFactor053 = 256;
		potentialFactor053 = 256;
		initialDirection053 = null;
		if (rc.onTheMap(maploc053)) {
			mapinfo053 = rc.senseMapInfo(maploc053);
			isPassable053 = mapinfo053.isPassable() && rc.senseRobotAtLocation(maploc053) == null;
		} else {
			isPassable053 = false;
		}

		maploc054 = maploc044.add(Direction.SOUTHEAST);
		accessibilityFactor054 = 256;
		potentialFactor054 = 256;
		initialDirection054 = null;
		if (rc.onTheMap(maploc054)) {
			mapinfo054 = rc.senseMapInfo(maploc054);
			isPassable054 = mapinfo054.isPassable() && rc.senseRobotAtLocation(maploc054) == null;
		} else {
			isPassable054 = false;
		}

		maploc005 = maploc014.add(Direction.NORTHWEST);
		accessibilityFactor005 = 256;
		potentialFactor005 = 256;
		initialDirection005 = null;
		if (rc.onTheMap(maploc005)) {
			mapinfo005 = rc.senseMapInfo(maploc005);
			isPassable005 = mapinfo005.isPassable() && rc.senseRobotAtLocation(maploc005) == null;
		} else {
			isPassable005 = false;
		}

		maploc006 = maploc014.add(Direction.NORTH);
		accessibilityFactor006 = 256;
		potentialFactor006 = 256;
		initialDirection006 = null;
		if (rc.onTheMap(maploc006)) {
			mapinfo006 = rc.senseMapInfo(maploc006);
			isPassable006 = mapinfo006.isPassable() && rc.senseRobotAtLocation(maploc006) == null;
		} else {
			isPassable006 = false;
		}

		maploc007 = maploc014.add(Direction.NORTHEAST);
		accessibilityFactor007 = 256;
		potentialFactor007 = 256;
		initialDirection007 = null;
		if (rc.onTheMap(maploc007)) {
			mapinfo007 = rc.senseMapInfo(maploc007);
			isPassable007 = mapinfo007.isPassable() && rc.senseRobotAtLocation(maploc007) == null;
		} else {
			isPassable007 = false;
		}

		maploc013 = maploc014.add(Direction.WEST);
		accessibilityFactor013 = 256;
		potentialFactor013 = 256;
		initialDirection013 = null;
		if (rc.onTheMap(maploc013)) {
			mapinfo013 = rc.senseMapInfo(maploc013);
			isPassable013 = mapinfo013.isPassable() && rc.senseRobotAtLocation(maploc013) == null;
		} else {
			isPassable013 = false;
		}

		maploc022 = maploc014.add(Direction.SOUTHWEST);
		accessibilityFactor022 = 256;
		potentialFactor022 = 256;
		initialDirection022 = null;
		if (rc.onTheMap(maploc022)) {
			mapinfo022 = rc.senseMapInfo(maploc022);
			isPassable022 = mapinfo022.isPassable() && rc.senseRobotAtLocation(maploc022) == null;
		} else {
			isPassable022 = false;
		}

		maploc008 = maploc015.add(Direction.NORTHEAST);
		accessibilityFactor008 = 256;
		potentialFactor008 = 256;
		initialDirection008 = null;
		if (rc.onTheMap(maploc008)) {
			mapinfo008 = rc.senseMapInfo(maploc008);
			isPassable008 = mapinfo008.isPassable() && rc.senseRobotAtLocation(maploc008) == null;
		} else {
			isPassable008 = false;
		}

		maploc009 = maploc016.add(Direction.NORTHEAST);
		accessibilityFactor009 = 256;
		potentialFactor009 = 256;
		initialDirection009 = null;
		if (rc.onTheMap(maploc009)) {
			mapinfo009 = rc.senseMapInfo(maploc009);
			isPassable009 = mapinfo009.isPassable() && rc.senseRobotAtLocation(maploc009) == null;
		} else {
			isPassable009 = false;
		}

		maploc031 = maploc023.add(Direction.SOUTHWEST);
		accessibilityFactor031 = 256;
		potentialFactor031 = 256;
		initialDirection031 = null;
		if (rc.onTheMap(maploc031)) {
			mapinfo031 = rc.senseMapInfo(maploc031);
			isPassable031 = mapinfo031.isPassable() && rc.senseRobotAtLocation(maploc031) == null;
		} else {
			isPassable031 = false;
		}

		maploc040 = maploc032.add(Direction.SOUTHWEST);
		accessibilityFactor040 = 256;
		potentialFactor040 = 256;
		initialDirection040 = null;
		if (rc.onTheMap(maploc040)) {
			mapinfo040 = rc.senseMapInfo(maploc040);
			isPassable040 = mapinfo040.isPassable() && rc.senseRobotAtLocation(maploc040) == null;
		} else {
			isPassable040 = false;
		}

		maploc010 = maploc017.add(Direction.NORTHEAST);
		accessibilityFactor010 = 256;
		potentialFactor010 = 256;
		initialDirection010 = null;
		if (rc.onTheMap(maploc010)) {
			mapinfo010 = rc.senseMapInfo(maploc010);
			isPassable010 = mapinfo010.isPassable() && rc.senseRobotAtLocation(maploc010) == null;
		} else {
			isPassable010 = false;
		}

		maploc011 = maploc018.add(Direction.NORTHEAST);
		accessibilityFactor011 = 256;
		potentialFactor011 = 256;
		initialDirection011 = null;
		if (rc.onTheMap(maploc011)) {
			mapinfo011 = rc.senseMapInfo(maploc011);
			isPassable011 = mapinfo011.isPassable() && rc.senseRobotAtLocation(maploc011) == null;
		} else {
			isPassable011 = false;
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

		maploc028 = maploc018.add(Direction.SOUTHEAST);
		accessibilityFactor028 = 256;
		potentialFactor028 = 256;
		initialDirection028 = null;
		if (rc.onTheMap(maploc028)) {
			mapinfo028 = rc.senseMapInfo(maploc028);
			isPassable028 = mapinfo028.isPassable() && rc.senseRobotAtLocation(maploc028) == null;
		} else {
			isPassable028 = false;
		}

		maploc037 = maploc027.add(Direction.SOUTHEAST);
		accessibilityFactor037 = 256;
		potentialFactor037 = 256;
		initialDirection037 = null;
		if (rc.onTheMap(maploc037)) {
			mapinfo037 = rc.senseMapInfo(maploc037);
			isPassable037 = mapinfo037.isPassable() && rc.senseRobotAtLocation(maploc037) == null;
		} else {
			isPassable037 = false;
		}

		maploc046 = maploc036.add(Direction.SOUTHEAST);
		accessibilityFactor046 = 256;
		potentialFactor046 = 256;
		initialDirection046 = null;
		if (rc.onTheMap(maploc046)) {
			mapinfo046 = rc.senseMapInfo(maploc046);
			isPassable046 = mapinfo046.isPassable() && rc.senseRobotAtLocation(maploc046) == null;
		} else {
			isPassable046 = false;
		}

		maploc049 = maploc041.add(Direction.SOUTHWEST);
		accessibilityFactor049 = 256;
		potentialFactor049 = 256;
		initialDirection049 = null;
		if (rc.onTheMap(maploc049)) {
			mapinfo049 = rc.senseMapInfo(maploc049);
			isPassable049 = mapinfo049.isPassable() && rc.senseRobotAtLocation(maploc049) == null;
		} else {
			isPassable049 = false;
		}

		maploc055 = maploc045.add(Direction.SOUTHEAST);
		accessibilityFactor055 = 256;
		potentialFactor055 = 256;
		initialDirection055 = null;
		if (rc.onTheMap(maploc055)) {
			mapinfo055 = rc.senseMapInfo(maploc055);
			isPassable055 = mapinfo055.isPassable() && rc.senseRobotAtLocation(maploc055) == null;
		} else {
			isPassable055 = false;
		}

		maploc057 = maploc050.add(Direction.SOUTHWEST);
		accessibilityFactor057 = 256;
		potentialFactor057 = 256;
		initialDirection057 = null;
		if (rc.onTheMap(maploc057)) {
			mapinfo057 = rc.senseMapInfo(maploc057);
			isPassable057 = mapinfo057.isPassable() && rc.senseRobotAtLocation(maploc057) == null;
		} else {
			isPassable057 = false;
		}

		maploc058 = maploc050.add(Direction.SOUTH);
		accessibilityFactor058 = 256;
		potentialFactor058 = 256;
		initialDirection058 = null;
		if (rc.onTheMap(maploc058)) {
			mapinfo058 = rc.senseMapInfo(maploc058);
			isPassable058 = mapinfo058.isPassable() && rc.senseRobotAtLocation(maploc058) == null;
		} else {
			isPassable058 = false;
		}

		maploc059 = maploc050.add(Direction.SOUTHEAST);
		accessibilityFactor059 = 256;
		potentialFactor059 = 256;
		initialDirection059 = null;
		if (rc.onTheMap(maploc059)) {
			mapinfo059 = rc.senseMapInfo(maploc059);
			isPassable059 = mapinfo059.isPassable() && rc.senseRobotAtLocation(maploc059) == null;
		} else {
			isPassable059 = false;
		}

		maploc060 = maploc051.add(Direction.SOUTHEAST);
		accessibilityFactor060 = 256;
		potentialFactor060 = 256;
		initialDirection060 = null;
		if (rc.onTheMap(maploc060)) {
			mapinfo060 = rc.senseMapInfo(maploc060);
			isPassable060 = mapinfo060.isPassable() && rc.senseRobotAtLocation(maploc060) == null;
		} else {
			isPassable060 = false;
		}

		maploc061 = maploc052.add(Direction.SOUTHEAST);
		accessibilityFactor061 = 256;
		potentialFactor061 = 256;
		initialDirection061 = null;
		if (rc.onTheMap(maploc061)) {
			mapinfo061 = rc.senseMapInfo(maploc061);
			isPassable061 = mapinfo061.isPassable() && rc.senseRobotAtLocation(maploc061) == null;
		} else {
			isPassable061 = false;
		}

		maploc062 = maploc053.add(Direction.SOUTHEAST);
		accessibilityFactor062 = 256;
		potentialFactor062 = 256;
		initialDirection062 = null;
		if (rc.onTheMap(maploc062)) {
			mapinfo062 = rc.senseMapInfo(maploc062);
			isPassable062 = mapinfo062.isPassable() && rc.senseRobotAtLocation(maploc062) == null;
		} else {
			isPassable062 = false;
		}

		maploc063 = maploc054.add(Direction.SOUTHEAST);
		accessibilityFactor063 = 256;
		potentialFactor063 = 256;
		initialDirection063 = null;
		if (rc.onTheMap(maploc063)) {
			mapinfo063 = rc.senseMapInfo(maploc063);
			isPassable063 = mapinfo063.isPassable() && rc.senseRobotAtLocation(maploc063) == null;
		} else {
			isPassable063 = false;
		}

		maploc000 = maploc005.add(Direction.NORTHEAST);
		accessibilityFactor000 = 256;
		potentialFactor000 = 256;
		initialDirection000 = null;
		if (rc.onTheMap(maploc000)) {
			mapinfo000 = rc.senseMapInfo(maploc000);
			isPassable000 = mapinfo000.isPassable() && rc.senseRobotAtLocation(maploc000) == null;
		} else {
			isPassable000 = false;
		}

		maploc012 = maploc005.add(Direction.SOUTHWEST);
		accessibilityFactor012 = 256;
		potentialFactor012 = 256;
		initialDirection012 = null;
		if (rc.onTheMap(maploc012)) {
			mapinfo012 = rc.senseMapInfo(maploc012);
			isPassable012 = mapinfo012.isPassable() && rc.senseRobotAtLocation(maploc012) == null;
		} else {
			isPassable012 = false;
		}

		maploc001 = maploc006.add(Direction.NORTHEAST);
		accessibilityFactor001 = 256;
		potentialFactor001 = 256;
		initialDirection001 = null;
		if (rc.onTheMap(maploc001)) {
			mapinfo001 = rc.senseMapInfo(maploc001);
			isPassable001 = mapinfo001.isPassable() && rc.senseRobotAtLocation(maploc001) == null;
		} else {
			isPassable001 = false;
		}

		maploc002 = maploc007.add(Direction.NORTHEAST);
		accessibilityFactor002 = 256;
		potentialFactor002 = 256;
		initialDirection002 = null;
		if (rc.onTheMap(maploc002)) {
			mapinfo002 = rc.senseMapInfo(maploc002);
			isPassable002 = mapinfo002.isPassable() && rc.senseRobotAtLocation(maploc002) == null;
		} else {
			isPassable002 = false;
		}

		maploc021 = maploc013.add(Direction.SOUTHWEST);
		accessibilityFactor021 = 256;
		potentialFactor021 = 256;
		initialDirection021 = null;
		if (rc.onTheMap(maploc021)) {
			mapinfo021 = rc.senseMapInfo(maploc021);
			isPassable021 = mapinfo021.isPassable() && rc.senseRobotAtLocation(maploc021) == null;
		} else {
			isPassable021 = false;
		}

		maploc030 = maploc022.add(Direction.SOUTHWEST);
		accessibilityFactor030 = 256;
		potentialFactor030 = 256;
		initialDirection030 = null;
		if (rc.onTheMap(maploc030)) {
			mapinfo030 = rc.senseMapInfo(maploc030);
			isPassable030 = mapinfo030.isPassable() && rc.senseRobotAtLocation(maploc030) == null;
		} else {
			isPassable030 = false;
		}

		maploc003 = maploc008.add(Direction.NORTHEAST);
		accessibilityFactor003 = 256;
		potentialFactor003 = 256;
		initialDirection003 = null;
		if (rc.onTheMap(maploc003)) {
			mapinfo003 = rc.senseMapInfo(maploc003);
			isPassable003 = mapinfo003.isPassable() && rc.senseRobotAtLocation(maploc003) == null;
		} else {
			isPassable003 = false;
		}

		maploc004 = maploc009.add(Direction.NORTHEAST);
		accessibilityFactor004 = 256;
		potentialFactor004 = 256;
		initialDirection004 = null;
		if (rc.onTheMap(maploc004)) {
			mapinfo004 = rc.senseMapInfo(maploc004);
			isPassable004 = mapinfo004.isPassable() && rc.senseRobotAtLocation(maploc004) == null;
		} else {
			isPassable004 = false;
		}

		maploc039 = maploc031.add(Direction.SOUTHWEST);
		accessibilityFactor039 = 256;
		potentialFactor039 = 256;
		initialDirection039 = null;
		if (rc.onTheMap(maploc039)) {
			mapinfo039 = rc.senseMapInfo(maploc039);
			isPassable039 = mapinfo039.isPassable() && rc.senseRobotAtLocation(maploc039) == null;
		} else {
			isPassable039 = false;
		}

		maploc048 = maploc040.add(Direction.SOUTHWEST);
		accessibilityFactor048 = 256;
		potentialFactor048 = 256;
		initialDirection048 = null;
		if (rc.onTheMap(maploc048)) {
			mapinfo048 = rc.senseMapInfo(maploc048);
			isPassable048 = mapinfo048.isPassable() && rc.senseRobotAtLocation(maploc048) == null;
		} else {
			isPassable048 = false;
		}

		maploc020 = maploc011.add(Direction.SOUTHEAST);
		accessibilityFactor020 = 256;
		potentialFactor020 = 256;
		initialDirection020 = null;
		if (rc.onTheMap(maploc020)) {
			mapinfo020 = rc.senseMapInfo(maploc020);
			isPassable020 = mapinfo020.isPassable() && rc.senseRobotAtLocation(maploc020) == null;
		} else {
			isPassable020 = false;
		}

		maploc029 = maploc019.add(Direction.SOUTHEAST);
		accessibilityFactor029 = 256;
		potentialFactor029 = 256;
		initialDirection029 = null;
		if (rc.onTheMap(maploc029)) {
			mapinfo029 = rc.senseMapInfo(maploc029);
			isPassable029 = mapinfo029.isPassable() && rc.senseRobotAtLocation(maploc029) == null;
		} else {
			isPassable029 = false;
		}

		maploc038 = maploc028.add(Direction.SOUTHEAST);
		accessibilityFactor038 = 256;
		potentialFactor038 = 256;
		initialDirection038 = null;
		if (rc.onTheMap(maploc038)) {
			mapinfo038 = rc.senseMapInfo(maploc038);
			isPassable038 = mapinfo038.isPassable() && rc.senseRobotAtLocation(maploc038) == null;
		} else {
			isPassable038 = false;
		}

		maploc047 = maploc037.add(Direction.SOUTHEAST);
		accessibilityFactor047 = 256;
		potentialFactor047 = 256;
		initialDirection047 = null;
		if (rc.onTheMap(maploc047)) {
			mapinfo047 = rc.senseMapInfo(maploc047);
			isPassable047 = mapinfo047.isPassable() && rc.senseRobotAtLocation(maploc047) == null;
		} else {
			isPassable047 = false;
		}

		maploc056 = maploc046.add(Direction.SOUTHEAST);
		accessibilityFactor056 = 256;
		potentialFactor056 = 256;
		initialDirection056 = null;
		if (rc.onTheMap(maploc056)) {
			mapinfo056 = rc.senseMapInfo(maploc056);
			isPassable056 = mapinfo056.isPassable() && rc.senseRobotAtLocation(maploc056) == null;
		} else {
			isPassable056 = false;
		}

		maploc064 = maploc057.add(Direction.SOUTHEAST);
		accessibilityFactor064 = 256;
		potentialFactor064 = 256;
		initialDirection064 = null;
		if (rc.onTheMap(maploc064)) {
			mapinfo064 = rc.senseMapInfo(maploc064);
			isPassable064 = mapinfo064.isPassable() && rc.senseRobotAtLocation(maploc064) == null;
		} else {
			isPassable064 = false;
		}

		maploc065 = maploc058.add(Direction.SOUTHEAST);
		accessibilityFactor065 = 256;
		potentialFactor065 = 256;
		initialDirection065 = null;
		if (rc.onTheMap(maploc065)) {
			mapinfo065 = rc.senseMapInfo(maploc065);
			isPassable065 = mapinfo065.isPassable() && rc.senseRobotAtLocation(maploc065) == null;
		} else {
			isPassable065 = false;
		}

		maploc066 = maploc059.add(Direction.SOUTHEAST);
		accessibilityFactor066 = 256;
		potentialFactor066 = 256;
		initialDirection066 = null;
		if (rc.onTheMap(maploc066)) {
			mapinfo066 = rc.senseMapInfo(maploc066);
			isPassable066 = mapinfo066.isPassable() && rc.senseRobotAtLocation(maploc066) == null;
		} else {
			isPassable066 = false;
		}

		maploc067 = maploc060.add(Direction.SOUTHEAST);
		accessibilityFactor067 = 256;
		potentialFactor067 = 256;
		initialDirection067 = null;
		if (rc.onTheMap(maploc067)) {
			mapinfo067 = rc.senseMapInfo(maploc067);
			isPassable067 = mapinfo067.isPassable() && rc.senseRobotAtLocation(maploc067) == null;
		} else {
			isPassable067 = false;
		}

		maploc068 = maploc061.add(Direction.SOUTHEAST);
		accessibilityFactor068 = 256;
		potentialFactor068 = 256;
		initialDirection068 = null;
		if (rc.onTheMap(maploc068)) {
			mapinfo068 = rc.senseMapInfo(maploc068);
			isPassable068 = mapinfo068.isPassable() && rc.senseRobotAtLocation(maploc068) == null;
		} else {
			isPassable068 = false;
		}

		if (accessibilityFactor024 > accessibilityFactor034 + 1) {
			accessibilityFactor024 = accessibilityFactor034 + 1;
			initialDirection024 = Direction.NORTHWEST;
		}
		if (accessibilityFactor025 > accessibilityFactor034 + 1) {
			accessibilityFactor025 = accessibilityFactor034 + 1;
			initialDirection025 = Direction.NORTH;
		}
		if (accessibilityFactor026 > accessibilityFactor034 + 1) {
			accessibilityFactor026 = accessibilityFactor034 + 1;
			initialDirection026 = Direction.NORTHEAST;
		}
		if (accessibilityFactor033 > accessibilityFactor034 + 1) {
			accessibilityFactor033 = accessibilityFactor034 + 1;
			initialDirection033 = Direction.WEST;
		}
		if (accessibilityFactor035 > accessibilityFactor034 + 1) {
			accessibilityFactor035 = accessibilityFactor034 + 1;
			initialDirection035 = Direction.EAST;
		}
		if (accessibilityFactor042 > accessibilityFactor034 + 1) {
			accessibilityFactor042 = accessibilityFactor034 + 1;
			initialDirection042 = Direction.SOUTHWEST;
		}
		if (accessibilityFactor043 > accessibilityFactor034 + 1) {
			accessibilityFactor043 = accessibilityFactor034 + 1;
			initialDirection043 = Direction.SOUTH;
		}
		if (accessibilityFactor044 > accessibilityFactor034 + 1) {
			accessibilityFactor044 = accessibilityFactor034 + 1;
			initialDirection044 = Direction.SOUTHEAST;
		}
		
		if (isPassable025) {
			if (accessibilityFactor015 > accessibilityFactor025 + 1) {
				accessibilityFactor015 = accessibilityFactor025 + 1;
				initialDirection015 = initialDirection025;
			}
			if (accessibilityFactor016 > accessibilityFactor025 + 1) {
				accessibilityFactor016 = accessibilityFactor025 + 1;
				initialDirection016 = initialDirection025;
			}
			if (accessibilityFactor017 > accessibilityFactor025 + 1) {
				accessibilityFactor017 = accessibilityFactor025 + 1;
				initialDirection017 = initialDirection025;
			}
			if (accessibilityFactor024 > accessibilityFactor025 + 1) {
				accessibilityFactor024 = accessibilityFactor025 + 1;
				initialDirection024 = initialDirection025;
			}
			if (accessibilityFactor026 > accessibilityFactor025 + 1) {
				accessibilityFactor026 = accessibilityFactor025 + 1;
				initialDirection026 = initialDirection025;
			}
			if (accessibilityFactor033 > accessibilityFactor025 + 1) {
				accessibilityFactor033 = accessibilityFactor025 + 1;
				initialDirection033 = initialDirection025;
			}
			if (accessibilityFactor035 > accessibilityFactor025 + 1) {
				accessibilityFactor035 = accessibilityFactor025 + 1;
				initialDirection035 = initialDirection025;
			}
		}
		if (isPassable033) {
			if (accessibilityFactor023 > accessibilityFactor033 + 1) {
				accessibilityFactor023 = accessibilityFactor033 + 1;
				initialDirection023 = initialDirection033;
			}
			if (accessibilityFactor024 > accessibilityFactor033 + 1) {
				accessibilityFactor024 = accessibilityFactor033 + 1;
				initialDirection024 = initialDirection033;
			}
			if (accessibilityFactor032 > accessibilityFactor033 + 1) {
				accessibilityFactor032 = accessibilityFactor033 + 1;
				initialDirection032 = initialDirection033;
			}
			if (accessibilityFactor041 > accessibilityFactor033 + 1) {
				accessibilityFactor041 = accessibilityFactor033 + 1;
				initialDirection041 = initialDirection033;
			}
			if (accessibilityFactor042 > accessibilityFactor033 + 1) {
				accessibilityFactor042 = accessibilityFactor033 + 1;
				initialDirection042 = initialDirection033;
			}
			if (accessibilityFactor043 > accessibilityFactor033 + 1) {
				accessibilityFactor043 = accessibilityFactor033 + 1;
				initialDirection043 = initialDirection033;
			}
		}
		if (isPassable035) {
			if (accessibilityFactor026 > accessibilityFactor035 + 1) {
				accessibilityFactor026 = accessibilityFactor035 + 1;
				initialDirection026 = initialDirection035;
			}
			if (accessibilityFactor027 > accessibilityFactor035 + 1) {
				accessibilityFactor027 = accessibilityFactor035 + 1;
				initialDirection027 = initialDirection035;
			}
			if (accessibilityFactor036 > accessibilityFactor035 + 1) {
				accessibilityFactor036 = accessibilityFactor035 + 1;
				initialDirection036 = initialDirection035;
			}
			if (accessibilityFactor043 > accessibilityFactor035 + 1) {
				accessibilityFactor043 = accessibilityFactor035 + 1;
				initialDirection043 = initialDirection035;
			}
			if (accessibilityFactor044 > accessibilityFactor035 + 1) {
				accessibilityFactor044 = accessibilityFactor035 + 1;
				initialDirection044 = initialDirection035;
			}
			if (accessibilityFactor045 > accessibilityFactor035 + 1) {
				accessibilityFactor045 = accessibilityFactor035 + 1;
				initialDirection045 = initialDirection035;
			}
		}
		if (isPassable043) {
			if (accessibilityFactor042 > accessibilityFactor043 + 1) {
				accessibilityFactor042 = accessibilityFactor043 + 1;
				initialDirection042 = initialDirection043;
			}
			if (accessibilityFactor044 > accessibilityFactor043 + 1) {
				accessibilityFactor044 = accessibilityFactor043 + 1;
				initialDirection044 = initialDirection043;
			}
			if (accessibilityFactor051 > accessibilityFactor043 + 1) {
				accessibilityFactor051 = accessibilityFactor043 + 1;
				initialDirection051 = initialDirection043;
			}
			if (accessibilityFactor052 > accessibilityFactor043 + 1) {
				accessibilityFactor052 = accessibilityFactor043 + 1;
				initialDirection052 = initialDirection043;
			}
			if (accessibilityFactor053 > accessibilityFactor043 + 1) {
				accessibilityFactor053 = accessibilityFactor043 + 1;
				initialDirection053 = initialDirection043;
			}
		}
		if (isPassable024) {
			if (accessibilityFactor014 > accessibilityFactor024 + 1) {
				accessibilityFactor014 = accessibilityFactor024 + 1;
				initialDirection014 = initialDirection024;
			}
			if (accessibilityFactor015 > accessibilityFactor024 + 1) {
				accessibilityFactor015 = accessibilityFactor024 + 1;
				initialDirection015 = initialDirection024;
			}
			if (accessibilityFactor016 > accessibilityFactor024 + 1) {
				accessibilityFactor016 = accessibilityFactor024 + 1;
				initialDirection016 = initialDirection024;
			}
			if (accessibilityFactor023 > accessibilityFactor024 + 1) {
				accessibilityFactor023 = accessibilityFactor024 + 1;
				initialDirection023 = initialDirection024;
			}
			if (accessibilityFactor032 > accessibilityFactor024 + 1) {
				accessibilityFactor032 = accessibilityFactor024 + 1;
				initialDirection032 = initialDirection024;
			}
		}
		if (isPassable026) {
			if (accessibilityFactor016 > accessibilityFactor026 + 1) {
				accessibilityFactor016 = accessibilityFactor026 + 1;
				initialDirection016 = initialDirection026;
			}
			if (accessibilityFactor017 > accessibilityFactor026 + 1) {
				accessibilityFactor017 = accessibilityFactor026 + 1;
				initialDirection017 = initialDirection026;
			}
			if (accessibilityFactor018 > accessibilityFactor026 + 1) {
				accessibilityFactor018 = accessibilityFactor026 + 1;
				initialDirection018 = initialDirection026;
			}
			if (accessibilityFactor027 > accessibilityFactor026 + 1) {
				accessibilityFactor027 = accessibilityFactor026 + 1;
				initialDirection027 = initialDirection026;
			}
			if (accessibilityFactor036 > accessibilityFactor026 + 1) {
				accessibilityFactor036 = accessibilityFactor026 + 1;
				initialDirection036 = initialDirection026;
			}
		}
		if (isPassable042) {
			if (accessibilityFactor032 > accessibilityFactor042 + 1) {
				accessibilityFactor032 = accessibilityFactor042 + 1;
				initialDirection032 = initialDirection042;
			}
			if (accessibilityFactor041 > accessibilityFactor042 + 1) {
				accessibilityFactor041 = accessibilityFactor042 + 1;
				initialDirection041 = initialDirection042;
			}
			if (accessibilityFactor050 > accessibilityFactor042 + 1) {
				accessibilityFactor050 = accessibilityFactor042 + 1;
				initialDirection050 = initialDirection042;
			}
			if (accessibilityFactor051 > accessibilityFactor042 + 1) {
				accessibilityFactor051 = accessibilityFactor042 + 1;
				initialDirection051 = initialDirection042;
			}
			if (accessibilityFactor052 > accessibilityFactor042 + 1) {
				accessibilityFactor052 = accessibilityFactor042 + 1;
				initialDirection052 = initialDirection042;
			}
		}
		if (isPassable044) {
			if (accessibilityFactor036 > accessibilityFactor044 + 1) {
				accessibilityFactor036 = accessibilityFactor044 + 1;
				initialDirection036 = initialDirection044;
			}
			if (accessibilityFactor045 > accessibilityFactor044 + 1) {
				accessibilityFactor045 = accessibilityFactor044 + 1;
				initialDirection045 = initialDirection044;
			}
			if (accessibilityFactor052 > accessibilityFactor044 + 1) {
				accessibilityFactor052 = accessibilityFactor044 + 1;
				initialDirection052 = initialDirection044;
			}
			if (accessibilityFactor053 > accessibilityFactor044 + 1) {
				accessibilityFactor053 = accessibilityFactor044 + 1;
				initialDirection053 = initialDirection044;
			}
			if (accessibilityFactor054 > accessibilityFactor044 + 1) {
				accessibilityFactor054 = accessibilityFactor044 + 1;
				initialDirection054 = initialDirection044;
			}
		}
		if (isPassable016) {
			if (accessibilityFactor007 > accessibilityFactor016 + 1) {
				accessibilityFactor007 = accessibilityFactor016 + 1;
				initialDirection007 = initialDirection016;
			}
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
			if (accessibilityFactor017 > accessibilityFactor016 + 1) {
				accessibilityFactor017 = accessibilityFactor016 + 1;
				initialDirection017 = initialDirection016;
			}
		}
		if (isPassable032) {
			if (accessibilityFactor022 > accessibilityFactor032 + 1) {
				accessibilityFactor022 = accessibilityFactor032 + 1;
				initialDirection022 = initialDirection032;
			}
			if (accessibilityFactor023 > accessibilityFactor032 + 1) {
				accessibilityFactor023 = accessibilityFactor032 + 1;
				initialDirection023 = initialDirection032;
			}
			if (accessibilityFactor031 > accessibilityFactor032 + 1) {
				accessibilityFactor031 = accessibilityFactor032 + 1;
				initialDirection031 = initialDirection032;
			}
			if (accessibilityFactor040 > accessibilityFactor032 + 1) {
				accessibilityFactor040 = accessibilityFactor032 + 1;
				initialDirection040 = initialDirection032;
			}
			if (accessibilityFactor041 > accessibilityFactor032 + 1) {
				accessibilityFactor041 = accessibilityFactor032 + 1;
				initialDirection041 = initialDirection032;
			}
		}
		if (isPassable036) {
			if (accessibilityFactor027 > accessibilityFactor036 + 1) {
				accessibilityFactor027 = accessibilityFactor036 + 1;
				initialDirection027 = initialDirection036;
			}
			if (accessibilityFactor028 > accessibilityFactor036 + 1) {
				accessibilityFactor028 = accessibilityFactor036 + 1;
				initialDirection028 = initialDirection036;
			}
			if (accessibilityFactor037 > accessibilityFactor036 + 1) {
				accessibilityFactor037 = accessibilityFactor036 + 1;
				initialDirection037 = initialDirection036;
			}
			if (accessibilityFactor045 > accessibilityFactor036 + 1) {
				accessibilityFactor045 = accessibilityFactor036 + 1;
				initialDirection045 = initialDirection036;
			}
			if (accessibilityFactor046 > accessibilityFactor036 + 1) {
				accessibilityFactor046 = accessibilityFactor036 + 1;
				initialDirection046 = initialDirection036;
			}
		}
		if (isPassable052) {
			if (accessibilityFactor051 > accessibilityFactor052 + 1) {
				accessibilityFactor051 = accessibilityFactor052 + 1;
				initialDirection051 = initialDirection052;
			}
			if (accessibilityFactor053 > accessibilityFactor052 + 1) {
				accessibilityFactor053 = accessibilityFactor052 + 1;
				initialDirection053 = initialDirection052;
			}
			if (accessibilityFactor059 > accessibilityFactor052 + 1) {
				accessibilityFactor059 = accessibilityFactor052 + 1;
				initialDirection059 = initialDirection052;
			}
			if (accessibilityFactor060 > accessibilityFactor052 + 1) {
				accessibilityFactor060 = accessibilityFactor052 + 1;
				initialDirection060 = initialDirection052;
			}
			if (accessibilityFactor061 > accessibilityFactor052 + 1) {
				accessibilityFactor061 = accessibilityFactor052 + 1;
				initialDirection061 = initialDirection052;
			}
		}
		if (isPassable015) {
			if (accessibilityFactor006 > accessibilityFactor015 + 1) {
				accessibilityFactor006 = accessibilityFactor015 + 1;
				initialDirection006 = initialDirection015;
			}
			if (accessibilityFactor007 > accessibilityFactor015 + 1) {
				accessibilityFactor007 = accessibilityFactor015 + 1;
				initialDirection007 = initialDirection015;
			}
			if (accessibilityFactor008 > accessibilityFactor015 + 1) {
				accessibilityFactor008 = accessibilityFactor015 + 1;
				initialDirection008 = initialDirection015;
			}
			if (accessibilityFactor014 > accessibilityFactor015 + 1) {
				accessibilityFactor014 = accessibilityFactor015 + 1;
				initialDirection014 = initialDirection015;
			}
			if (accessibilityFactor023 > accessibilityFactor015 + 1) {
				accessibilityFactor023 = accessibilityFactor015 + 1;
				initialDirection023 = initialDirection015;
			}
		}
		if (isPassable017) {
			if (accessibilityFactor008 > accessibilityFactor017 + 1) {
				accessibilityFactor008 = accessibilityFactor017 + 1;
				initialDirection008 = initialDirection017;
			}
			if (accessibilityFactor009 > accessibilityFactor017 + 1) {
				accessibilityFactor009 = accessibilityFactor017 + 1;
				initialDirection009 = initialDirection017;
			}
			if (accessibilityFactor010 > accessibilityFactor017 + 1) {
				accessibilityFactor010 = accessibilityFactor017 + 1;
				initialDirection010 = initialDirection017;
			}
			if (accessibilityFactor018 > accessibilityFactor017 + 1) {
				accessibilityFactor018 = accessibilityFactor017 + 1;
				initialDirection018 = initialDirection017;
			}
			if (accessibilityFactor027 > accessibilityFactor017 + 1) {
				accessibilityFactor027 = accessibilityFactor017 + 1;
				initialDirection027 = initialDirection017;
			}
		}
		if (isPassable023) {
			if (accessibilityFactor013 > accessibilityFactor023 + 1) {
				accessibilityFactor013 = accessibilityFactor023 + 1;
				initialDirection013 = initialDirection023;
			}
			if (accessibilityFactor014 > accessibilityFactor023 + 1) {
				accessibilityFactor014 = accessibilityFactor023 + 1;
				initialDirection014 = initialDirection023;
			}
			if (accessibilityFactor022 > accessibilityFactor023 + 1) {
				accessibilityFactor022 = accessibilityFactor023 + 1;
				initialDirection022 = initialDirection023;
			}
			if (accessibilityFactor031 > accessibilityFactor023 + 1) {
				accessibilityFactor031 = accessibilityFactor023 + 1;
				initialDirection031 = initialDirection023;
			}
		}
		if (isPassable027) {
			if (accessibilityFactor018 > accessibilityFactor027 + 1) {
				accessibilityFactor018 = accessibilityFactor027 + 1;
				initialDirection018 = initialDirection027;
			}
			if (accessibilityFactor019 > accessibilityFactor027 + 1) {
				accessibilityFactor019 = accessibilityFactor027 + 1;
				initialDirection019 = initialDirection027;
			}
			if (accessibilityFactor028 > accessibilityFactor027 + 1) {
				accessibilityFactor028 = accessibilityFactor027 + 1;
				initialDirection028 = initialDirection027;
			}
			if (accessibilityFactor037 > accessibilityFactor027 + 1) {
				accessibilityFactor037 = accessibilityFactor027 + 1;
				initialDirection037 = initialDirection027;
			}
		}
		if (isPassable041) {
			if (accessibilityFactor031 > accessibilityFactor041 + 1) {
				accessibilityFactor031 = accessibilityFactor041 + 1;
				initialDirection031 = initialDirection041;
			}
			if (accessibilityFactor040 > accessibilityFactor041 + 1) {
				accessibilityFactor040 = accessibilityFactor041 + 1;
				initialDirection040 = initialDirection041;
			}
			if (accessibilityFactor049 > accessibilityFactor041 + 1) {
				accessibilityFactor049 = accessibilityFactor041 + 1;
				initialDirection049 = initialDirection041;
			}
			if (accessibilityFactor050 > accessibilityFactor041 + 1) {
				accessibilityFactor050 = accessibilityFactor041 + 1;
				initialDirection050 = initialDirection041;
			}
			if (accessibilityFactor051 > accessibilityFactor041 + 1) {
				accessibilityFactor051 = accessibilityFactor041 + 1;
				initialDirection051 = initialDirection041;
			}
		}
		if (isPassable045) {
			if (accessibilityFactor037 > accessibilityFactor045 + 1) {
				accessibilityFactor037 = accessibilityFactor045 + 1;
				initialDirection037 = initialDirection045;
			}
			if (accessibilityFactor046 > accessibilityFactor045 + 1) {
				accessibilityFactor046 = accessibilityFactor045 + 1;
				initialDirection046 = initialDirection045;
			}
			if (accessibilityFactor053 > accessibilityFactor045 + 1) {
				accessibilityFactor053 = accessibilityFactor045 + 1;
				initialDirection053 = initialDirection045;
			}
			if (accessibilityFactor054 > accessibilityFactor045 + 1) {
				accessibilityFactor054 = accessibilityFactor045 + 1;
				initialDirection054 = initialDirection045;
			}
			if (accessibilityFactor055 > accessibilityFactor045 + 1) {
				accessibilityFactor055 = accessibilityFactor045 + 1;
				initialDirection055 = initialDirection045;
			}
		}
		if (isPassable051) {
			if (accessibilityFactor050 > accessibilityFactor051 + 1) {
				accessibilityFactor050 = accessibilityFactor051 + 1;
				initialDirection050 = initialDirection051;
			}
			if (accessibilityFactor058 > accessibilityFactor051 + 1) {
				accessibilityFactor058 = accessibilityFactor051 + 1;
				initialDirection058 = initialDirection051;
			}
			if (accessibilityFactor059 > accessibilityFactor051 + 1) {
				accessibilityFactor059 = accessibilityFactor051 + 1;
				initialDirection059 = initialDirection051;
			}
			if (accessibilityFactor060 > accessibilityFactor051 + 1) {
				accessibilityFactor060 = accessibilityFactor051 + 1;
				initialDirection060 = initialDirection051;
			}
		}
		if (isPassable053) {
			if (accessibilityFactor054 > accessibilityFactor053 + 1) {
				accessibilityFactor054 = accessibilityFactor053 + 1;
				initialDirection054 = initialDirection053;
			}
			if (accessibilityFactor060 > accessibilityFactor053 + 1) {
				accessibilityFactor060 = accessibilityFactor053 + 1;
				initialDirection060 = initialDirection053;
			}
			if (accessibilityFactor061 > accessibilityFactor053 + 1) {
				accessibilityFactor061 = accessibilityFactor053 + 1;
				initialDirection061 = initialDirection053;
			}
			if (accessibilityFactor062 > accessibilityFactor053 + 1) {
				accessibilityFactor062 = accessibilityFactor053 + 1;
				initialDirection062 = initialDirection053;
			}
		}
		if (isPassable014) {
			if (accessibilityFactor005 > accessibilityFactor014 + 1) {
				accessibilityFactor005 = accessibilityFactor014 + 1;
				initialDirection005 = initialDirection014;
			}
			if (accessibilityFactor006 > accessibilityFactor014 + 1) {
				accessibilityFactor006 = accessibilityFactor014 + 1;
				initialDirection006 = initialDirection014;
			}
			if (accessibilityFactor007 > accessibilityFactor014 + 1) {
				accessibilityFactor007 = accessibilityFactor014 + 1;
				initialDirection007 = initialDirection014;
			}
			if (accessibilityFactor013 > accessibilityFactor014 + 1) {
				accessibilityFactor013 = accessibilityFactor014 + 1;
				initialDirection013 = initialDirection014;
			}
			if (accessibilityFactor022 > accessibilityFactor014 + 1) {
				accessibilityFactor022 = accessibilityFactor014 + 1;
				initialDirection022 = initialDirection014;
			}
		}
		if (isPassable018) {
			if (accessibilityFactor009 > accessibilityFactor018 + 1) {
				accessibilityFactor009 = accessibilityFactor018 + 1;
				initialDirection009 = initialDirection018;
			}
			if (accessibilityFactor010 > accessibilityFactor018 + 1) {
				accessibilityFactor010 = accessibilityFactor018 + 1;
				initialDirection010 = initialDirection018;
			}
			if (accessibilityFactor011 > accessibilityFactor018 + 1) {
				accessibilityFactor011 = accessibilityFactor018 + 1;
				initialDirection011 = initialDirection018;
			}
			if (accessibilityFactor019 > accessibilityFactor018 + 1) {
				accessibilityFactor019 = accessibilityFactor018 + 1;
				initialDirection019 = initialDirection018;
			}
			if (accessibilityFactor028 > accessibilityFactor018 + 1) {
				accessibilityFactor028 = accessibilityFactor018 + 1;
				initialDirection028 = initialDirection018;
			}
		}
		if (isPassable050) {
			if (accessibilityFactor040 > accessibilityFactor050 + 1) {
				accessibilityFactor040 = accessibilityFactor050 + 1;
				initialDirection040 = initialDirection050;
			}
			if (accessibilityFactor049 > accessibilityFactor050 + 1) {
				accessibilityFactor049 = accessibilityFactor050 + 1;
				initialDirection049 = initialDirection050;
			}
			if (accessibilityFactor057 > accessibilityFactor050 + 1) {
				accessibilityFactor057 = accessibilityFactor050 + 1;
				initialDirection057 = initialDirection050;
			}
			if (accessibilityFactor058 > accessibilityFactor050 + 1) {
				accessibilityFactor058 = accessibilityFactor050 + 1;
				initialDirection058 = initialDirection050;
			}
			if (accessibilityFactor059 > accessibilityFactor050 + 1) {
				accessibilityFactor059 = accessibilityFactor050 + 1;
				initialDirection059 = initialDirection050;
			}
		}
		if (isPassable054) {
			if (accessibilityFactor046 > accessibilityFactor054 + 1) {
				accessibilityFactor046 = accessibilityFactor054 + 1;
				initialDirection046 = initialDirection054;
			}
			if (accessibilityFactor055 > accessibilityFactor054 + 1) {
				accessibilityFactor055 = accessibilityFactor054 + 1;
				initialDirection055 = initialDirection054;
			}
			if (accessibilityFactor061 > accessibilityFactor054 + 1) {
				accessibilityFactor061 = accessibilityFactor054 + 1;
				initialDirection061 = initialDirection054;
			}
			if (accessibilityFactor062 > accessibilityFactor054 + 1) {
				accessibilityFactor062 = accessibilityFactor054 + 1;
				initialDirection062 = initialDirection054;
			}
			if (accessibilityFactor063 > accessibilityFactor054 + 1) {
				accessibilityFactor063 = accessibilityFactor054 + 1;
				initialDirection063 = initialDirection054;
			}
		}
		if (isPassable008) {
			if (accessibilityFactor001 > accessibilityFactor008 + 1) {
				accessibilityFactor001 = accessibilityFactor008 + 1;
				initialDirection001 = initialDirection008;
			}
			if (accessibilityFactor002 > accessibilityFactor008 + 1) {
				accessibilityFactor002 = accessibilityFactor008 + 1;
				initialDirection002 = initialDirection008;
			}
			if (accessibilityFactor003 > accessibilityFactor008 + 1) {
				accessibilityFactor003 = accessibilityFactor008 + 1;
				initialDirection003 = initialDirection008;
			}
			if (accessibilityFactor007 > accessibilityFactor008 + 1) {
				accessibilityFactor007 = accessibilityFactor008 + 1;
				initialDirection007 = initialDirection008;
			}
			if (accessibilityFactor009 > accessibilityFactor008 + 1) {
				accessibilityFactor009 = accessibilityFactor008 + 1;
				initialDirection009 = initialDirection008;
			}
		}
		if (isPassable031) {
			if (accessibilityFactor021 > accessibilityFactor031 + 1) {
				accessibilityFactor021 = accessibilityFactor031 + 1;
				initialDirection021 = initialDirection031;
			}
			if (accessibilityFactor022 > accessibilityFactor031 + 1) {
				accessibilityFactor022 = accessibilityFactor031 + 1;
				initialDirection022 = initialDirection031;
			}
			if (accessibilityFactor030 > accessibilityFactor031 + 1) {
				accessibilityFactor030 = accessibilityFactor031 + 1;
				initialDirection030 = initialDirection031;
			}
			if (accessibilityFactor039 > accessibilityFactor031 + 1) {
				accessibilityFactor039 = accessibilityFactor031 + 1;
				initialDirection039 = initialDirection031;
			}
			if (accessibilityFactor040 > accessibilityFactor031 + 1) {
				accessibilityFactor040 = accessibilityFactor031 + 1;
				initialDirection040 = initialDirection031;
			}
		}
		if (isPassable037) {
			if (accessibilityFactor028 > accessibilityFactor037 + 1) {
				accessibilityFactor028 = accessibilityFactor037 + 1;
				initialDirection028 = initialDirection037;
			}
			if (accessibilityFactor029 > accessibilityFactor037 + 1) {
				accessibilityFactor029 = accessibilityFactor037 + 1;
				initialDirection029 = initialDirection037;
			}
			if (accessibilityFactor038 > accessibilityFactor037 + 1) {
				accessibilityFactor038 = accessibilityFactor037 + 1;
				initialDirection038 = initialDirection037;
			}
			if (accessibilityFactor046 > accessibilityFactor037 + 1) {
				accessibilityFactor046 = accessibilityFactor037 + 1;
				initialDirection046 = initialDirection037;
			}
			if (accessibilityFactor047 > accessibilityFactor037 + 1) {
				accessibilityFactor047 = accessibilityFactor037 + 1;
				initialDirection047 = initialDirection037;
			}
		}
		if (isPassable060) {
			if (accessibilityFactor059 > accessibilityFactor060 + 1) {
				accessibilityFactor059 = accessibilityFactor060 + 1;
				initialDirection059 = initialDirection060;
			}
			if (accessibilityFactor061 > accessibilityFactor060 + 1) {
				accessibilityFactor061 = accessibilityFactor060 + 1;
				initialDirection061 = initialDirection060;
			}
			if (accessibilityFactor065 > accessibilityFactor060 + 1) {
				accessibilityFactor065 = accessibilityFactor060 + 1;
				initialDirection065 = initialDirection060;
			}
			if (accessibilityFactor066 > accessibilityFactor060 + 1) {
				accessibilityFactor066 = accessibilityFactor060 + 1;
				initialDirection066 = initialDirection060;
			}
			if (accessibilityFactor067 > accessibilityFactor060 + 1) {
				accessibilityFactor067 = accessibilityFactor060 + 1;
				initialDirection067 = initialDirection060;
			}
		}
		if (isPassable007) {
			if (accessibilityFactor000 > accessibilityFactor007 + 1) {
				accessibilityFactor000 = accessibilityFactor007 + 1;
				initialDirection000 = initialDirection007;
			}
			if (accessibilityFactor001 > accessibilityFactor007 + 1) {
				accessibilityFactor001 = accessibilityFactor007 + 1;
				initialDirection001 = initialDirection007;
			}
			if (accessibilityFactor002 > accessibilityFactor007 + 1) {
				accessibilityFactor002 = accessibilityFactor007 + 1;
				initialDirection002 = initialDirection007;
			}
			if (accessibilityFactor006 > accessibilityFactor007 + 1) {
				accessibilityFactor006 = accessibilityFactor007 + 1;
				initialDirection006 = initialDirection007;
			}
		}
		if (isPassable009) {
			if (accessibilityFactor002 > accessibilityFactor009 + 1) {
				accessibilityFactor002 = accessibilityFactor009 + 1;
				initialDirection002 = initialDirection009;
			}
			if (accessibilityFactor003 > accessibilityFactor009 + 1) {
				accessibilityFactor003 = accessibilityFactor009 + 1;
				initialDirection003 = initialDirection009;
			}
			if (accessibilityFactor004 > accessibilityFactor009 + 1) {
				accessibilityFactor004 = accessibilityFactor009 + 1;
				initialDirection004 = initialDirection009;
			}
			if (accessibilityFactor010 > accessibilityFactor009 + 1) {
				accessibilityFactor010 = accessibilityFactor009 + 1;
				initialDirection010 = initialDirection009;
			}
		}
		if (isPassable022) {
			if (accessibilityFactor012 > accessibilityFactor022 + 1) {
				accessibilityFactor012 = accessibilityFactor022 + 1;
				initialDirection012 = initialDirection022;
			}
			if (accessibilityFactor013 > accessibilityFactor022 + 1) {
				accessibilityFactor013 = accessibilityFactor022 + 1;
				initialDirection013 = initialDirection022;
			}
			if (accessibilityFactor021 > accessibilityFactor022 + 1) {
				accessibilityFactor021 = accessibilityFactor022 + 1;
				initialDirection021 = initialDirection022;
			}
			if (accessibilityFactor030 > accessibilityFactor022 + 1) {
				accessibilityFactor030 = accessibilityFactor022 + 1;
				initialDirection030 = initialDirection022;
			}
		}
		if (isPassable028) {
			if (accessibilityFactor019 > accessibilityFactor028 + 1) {
				accessibilityFactor019 = accessibilityFactor028 + 1;
				initialDirection019 = initialDirection028;
			}
			if (accessibilityFactor020 > accessibilityFactor028 + 1) {
				accessibilityFactor020 = accessibilityFactor028 + 1;
				initialDirection020 = initialDirection028;
			}
			if (accessibilityFactor029 > accessibilityFactor028 + 1) {
				accessibilityFactor029 = accessibilityFactor028 + 1;
				initialDirection029 = initialDirection028;
			}
			if (accessibilityFactor038 > accessibilityFactor028 + 1) {
				accessibilityFactor038 = accessibilityFactor028 + 1;
				initialDirection038 = initialDirection028;
			}
		}
		if (isPassable040) {
			if (accessibilityFactor030 > accessibilityFactor040 + 1) {
				accessibilityFactor030 = accessibilityFactor040 + 1;
				initialDirection030 = initialDirection040;
			}
			if (accessibilityFactor039 > accessibilityFactor040 + 1) {
				accessibilityFactor039 = accessibilityFactor040 + 1;
				initialDirection039 = initialDirection040;
			}
			if (accessibilityFactor048 > accessibilityFactor040 + 1) {
				accessibilityFactor048 = accessibilityFactor040 + 1;
				initialDirection048 = initialDirection040;
			}
			if (accessibilityFactor049 > accessibilityFactor040 + 1) {
				accessibilityFactor049 = accessibilityFactor040 + 1;
				initialDirection049 = initialDirection040;
			}
		}
		if (isPassable046) {
			if (accessibilityFactor038 > accessibilityFactor046 + 1) {
				accessibilityFactor038 = accessibilityFactor046 + 1;
				initialDirection038 = initialDirection046;
			}
			if (accessibilityFactor047 > accessibilityFactor046 + 1) {
				accessibilityFactor047 = accessibilityFactor046 + 1;
				initialDirection047 = initialDirection046;
			}
			if (accessibilityFactor055 > accessibilityFactor046 + 1) {
				accessibilityFactor055 = accessibilityFactor046 + 1;
				initialDirection055 = initialDirection046;
			}
			if (accessibilityFactor056 > accessibilityFactor046 + 1) {
				accessibilityFactor056 = accessibilityFactor046 + 1;
				initialDirection056 = initialDirection046;
			}
		}
		if (isPassable059) {
			if (accessibilityFactor058 > accessibilityFactor059 + 1) {
				accessibilityFactor058 = accessibilityFactor059 + 1;
				initialDirection058 = initialDirection059;
			}
			if (accessibilityFactor064 > accessibilityFactor059 + 1) {
				accessibilityFactor064 = accessibilityFactor059 + 1;
				initialDirection064 = initialDirection059;
			}
			if (accessibilityFactor065 > accessibilityFactor059 + 1) {
				accessibilityFactor065 = accessibilityFactor059 + 1;
				initialDirection065 = initialDirection059;
			}
			if (accessibilityFactor066 > accessibilityFactor059 + 1) {
				accessibilityFactor066 = accessibilityFactor059 + 1;
				initialDirection066 = initialDirection059;
			}
		}
		if (isPassable061) {
			if (accessibilityFactor062 > accessibilityFactor061 + 1) {
				accessibilityFactor062 = accessibilityFactor061 + 1;
				initialDirection062 = initialDirection061;
			}
			if (accessibilityFactor066 > accessibilityFactor061 + 1) {
				accessibilityFactor066 = accessibilityFactor061 + 1;
				initialDirection066 = initialDirection061;
			}
			if (accessibilityFactor067 > accessibilityFactor061 + 1) {
				accessibilityFactor067 = accessibilityFactor061 + 1;
				initialDirection067 = initialDirection061;
			}
			if (accessibilityFactor068 > accessibilityFactor061 + 1) {
				accessibilityFactor068 = accessibilityFactor061 + 1;
				initialDirection068 = initialDirection061;
			}
		}
		if (isPassable006) {
			if (accessibilityFactor000 > accessibilityFactor006 + 1) {
				accessibilityFactor000 = accessibilityFactor006 + 1;
				initialDirection000 = initialDirection006;
			}
			if (accessibilityFactor001 > accessibilityFactor006 + 1) {
				accessibilityFactor001 = accessibilityFactor006 + 1;
				initialDirection001 = initialDirection006;
			}
			if (accessibilityFactor005 > accessibilityFactor006 + 1) {
				accessibilityFactor005 = accessibilityFactor006 + 1;
				initialDirection005 = initialDirection006;
			}
			if (accessibilityFactor013 > accessibilityFactor006 + 1) {
				accessibilityFactor013 = accessibilityFactor006 + 1;
				initialDirection013 = initialDirection006;
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
			if (accessibilityFactor011 > accessibilityFactor010 + 1) {
				accessibilityFactor011 = accessibilityFactor010 + 1;
				initialDirection011 = initialDirection010;
			}
			if (accessibilityFactor019 > accessibilityFactor010 + 1) {
				accessibilityFactor019 = accessibilityFactor010 + 1;
				initialDirection019 = initialDirection010;
			}
		}
		if (isPassable013) {
			if (accessibilityFactor005 > accessibilityFactor013 + 1) {
				accessibilityFactor005 = accessibilityFactor013 + 1;
				initialDirection005 = initialDirection013;
			}
			if (accessibilityFactor012 > accessibilityFactor013 + 1) {
				accessibilityFactor012 = accessibilityFactor013 + 1;
				initialDirection012 = initialDirection013;
			}
			if (accessibilityFactor021 > accessibilityFactor013 + 1) {
				accessibilityFactor021 = accessibilityFactor013 + 1;
				initialDirection021 = initialDirection013;
			}
		}
		if (isPassable019) {
			if (accessibilityFactor011 > accessibilityFactor019 + 1) {
				accessibilityFactor011 = accessibilityFactor019 + 1;
				initialDirection011 = initialDirection019;
			}
			if (accessibilityFactor020 > accessibilityFactor019 + 1) {
				accessibilityFactor020 = accessibilityFactor019 + 1;
				initialDirection020 = initialDirection019;
			}
			if (accessibilityFactor029 > accessibilityFactor019 + 1) {
				accessibilityFactor029 = accessibilityFactor019 + 1;
				initialDirection029 = initialDirection019;
			}
		}
		if (isPassable049) {
			if (accessibilityFactor039 > accessibilityFactor049 + 1) {
				accessibilityFactor039 = accessibilityFactor049 + 1;
				initialDirection039 = initialDirection049;
			}
			if (accessibilityFactor048 > accessibilityFactor049 + 1) {
				accessibilityFactor048 = accessibilityFactor049 + 1;
				initialDirection048 = initialDirection049;
			}
			if (accessibilityFactor057 > accessibilityFactor049 + 1) {
				accessibilityFactor057 = accessibilityFactor049 + 1;
				initialDirection057 = initialDirection049;
			}
			if (accessibilityFactor058 > accessibilityFactor049 + 1) {
				accessibilityFactor058 = accessibilityFactor049 + 1;
				initialDirection058 = initialDirection049;
			}
		}
		if (isPassable055) {
			if (accessibilityFactor047 > accessibilityFactor055 + 1) {
				accessibilityFactor047 = accessibilityFactor055 + 1;
				initialDirection047 = initialDirection055;
			}
			if (accessibilityFactor056 > accessibilityFactor055 + 1) {
				accessibilityFactor056 = accessibilityFactor055 + 1;
				initialDirection056 = initialDirection055;
			}
			if (accessibilityFactor062 > accessibilityFactor055 + 1) {
				accessibilityFactor062 = accessibilityFactor055 + 1;
				initialDirection062 = initialDirection055;
			}
			if (accessibilityFactor063 > accessibilityFactor055 + 1) {
				accessibilityFactor063 = accessibilityFactor055 + 1;
				initialDirection063 = initialDirection055;
			}
		}
		if (isPassable058) {
			if (accessibilityFactor057 > accessibilityFactor058 + 1) {
				accessibilityFactor057 = accessibilityFactor058 + 1;
				initialDirection057 = initialDirection058;
			}
			if (accessibilityFactor064 > accessibilityFactor058 + 1) {
				accessibilityFactor064 = accessibilityFactor058 + 1;
				initialDirection064 = initialDirection058;
			}
			if (accessibilityFactor065 > accessibilityFactor058 + 1) {
				accessibilityFactor065 = accessibilityFactor058 + 1;
				initialDirection065 = initialDirection058;
			}
		}
		if (isPassable062) {
			if (accessibilityFactor063 > accessibilityFactor062 + 1) {
				accessibilityFactor063 = accessibilityFactor062 + 1;
				initialDirection063 = initialDirection062;
			}
			if (accessibilityFactor067 > accessibilityFactor062 + 1) {
				accessibilityFactor067 = accessibilityFactor062 + 1;
				initialDirection067 = initialDirection062;
			}
			if (accessibilityFactor068 > accessibilityFactor062 + 1) {
				accessibilityFactor068 = accessibilityFactor062 + 1;
				initialDirection068 = initialDirection062;
			}
		}
		if (isPassable002) {
			if (accessibilityFactor001 > accessibilityFactor002 + 1) {
				accessibilityFactor001 = accessibilityFactor002 + 1;
				initialDirection001 = initialDirection002;
			}
			if (accessibilityFactor003 > accessibilityFactor002 + 1) {
				accessibilityFactor003 = accessibilityFactor002 + 1;
				initialDirection003 = initialDirection002;
			}
		}
		if (isPassable030) {
			if (accessibilityFactor021 > accessibilityFactor030 + 1) {
				accessibilityFactor021 = accessibilityFactor030 + 1;
				initialDirection021 = initialDirection030;
			}
			if (accessibilityFactor039 > accessibilityFactor030 + 1) {
				accessibilityFactor039 = accessibilityFactor030 + 1;
				initialDirection039 = initialDirection030;
			}
		}
		if (isPassable038) {
			if (accessibilityFactor029 > accessibilityFactor038 + 1) {
				accessibilityFactor029 = accessibilityFactor038 + 1;
				initialDirection029 = initialDirection038;
			}
			if (accessibilityFactor047 > accessibilityFactor038 + 1) {
				accessibilityFactor047 = accessibilityFactor038 + 1;
				initialDirection047 = initialDirection038;
			}
		}
		if (isPassable066) {
			if (accessibilityFactor065 > accessibilityFactor066 + 1) {
				accessibilityFactor065 = accessibilityFactor066 + 1;
				initialDirection065 = initialDirection066;
			}
			if (accessibilityFactor067 > accessibilityFactor066 + 1) {
				accessibilityFactor067 = accessibilityFactor066 + 1;
				initialDirection067 = initialDirection066;
			}
		}
		if (isPassable001) {
			if (accessibilityFactor000 > accessibilityFactor001 + 1) {
				accessibilityFactor000 = accessibilityFactor001 + 1;
				initialDirection000 = initialDirection001;
			}
		}
		if (isPassable003) {
			if (accessibilityFactor004 > accessibilityFactor003 + 1) {
				accessibilityFactor004 = accessibilityFactor003 + 1;
				initialDirection004 = initialDirection003;
			}
		}
		if (isPassable021) {
			if (accessibilityFactor012 > accessibilityFactor021 + 1) {
				accessibilityFactor012 = accessibilityFactor021 + 1;
				initialDirection012 = initialDirection021;
			}
		}
		if (isPassable029) {
			if (accessibilityFactor020 > accessibilityFactor029 + 1) {
				accessibilityFactor020 = accessibilityFactor029 + 1;
				initialDirection020 = initialDirection029;
			}
		}
		if (isPassable039) {
			if (accessibilityFactor048 > accessibilityFactor039 + 1) {
				accessibilityFactor048 = accessibilityFactor039 + 1;
				initialDirection048 = initialDirection039;
			}
		}
		if (isPassable047) {
			if (accessibilityFactor056 > accessibilityFactor047 + 1) {
				accessibilityFactor056 = accessibilityFactor047 + 1;
				initialDirection056 = initialDirection047;
			}
		}
		if (isPassable065) {
			if (accessibilityFactor064 > accessibilityFactor065 + 1) {
				accessibilityFactor064 = accessibilityFactor065 + 1;
				initialDirection064 = initialDirection065;
			}
		}
		if (isPassable067) {
			if (accessibilityFactor068 > accessibilityFactor067 + 1) {
				accessibilityFactor068 = accessibilityFactor067 + 1;
				initialDirection068 = initialDirection067;
			}
		}
		if (isPassable005) {
			if (accessibilityFactor000 > accessibilityFactor005 + 1) {
				accessibilityFactor000 = accessibilityFactor005 + 1;
				initialDirection000 = initialDirection005;
			}
			if (accessibilityFactor012 > accessibilityFactor005 + 1) {
				accessibilityFactor012 = accessibilityFactor005 + 1;
				initialDirection012 = initialDirection005;
			}
		}
		if (isPassable011) {
			if (accessibilityFactor004 > accessibilityFactor011 + 1) {
				accessibilityFactor004 = accessibilityFactor011 + 1;
				initialDirection004 = initialDirection011;
			}
			if (accessibilityFactor020 > accessibilityFactor011 + 1) {
				accessibilityFactor020 = accessibilityFactor011 + 1;
				initialDirection020 = initialDirection011;
			}
		}
		if (isPassable057) {
			if (accessibilityFactor048 > accessibilityFactor057 + 1) {
				accessibilityFactor048 = accessibilityFactor057 + 1;
				initialDirection048 = initialDirection057;
			}
			if (accessibilityFactor064 > accessibilityFactor057 + 1) {
				accessibilityFactor064 = accessibilityFactor057 + 1;
				initialDirection064 = initialDirection057;
			}
		}
		if (isPassable063) {
			if (accessibilityFactor056 > accessibilityFactor063 + 1) {
				accessibilityFactor056 = accessibilityFactor063 + 1;
				initialDirection056 = initialDirection063;
			}
			if (accessibilityFactor068 > accessibilityFactor063 + 1) {
				accessibilityFactor068 = accessibilityFactor063 + 1;
				initialDirection068 = initialDirection063;
			}
		}
		int dx = target.x - maploc034.x, dy = target.y - maploc034.y;
		switch (dx) {
		case -4:
			switch (dy) {
			case 2: return initialDirection012;
			case 1: return initialDirection021;
			case 0: return initialDirection030;
			case -1: return initialDirection039;
			case -2: return initialDirection048;
			}
			break;
		case -3:
			switch (dy) {
			case 3: return initialDirection005;
			case 2: return initialDirection013;
			case 1: return initialDirection022;
			case 0: return initialDirection031;
			case -1: return initialDirection040;
			case -2: return initialDirection049;
			case -3: return initialDirection057;
			}
			break;
		case -2:
			switch (dy) {
			case 4: return initialDirection000;
			case 3: return initialDirection006;
			case 2: return initialDirection014;
			case 1: return initialDirection023;
			case 0: return initialDirection032;
			case -1: return initialDirection041;
			case -2: return initialDirection050;
			case -3: return initialDirection058;
			case -4: return initialDirection064;
			}
			break;
		case -1:
			switch (dy) {
			case 4: return initialDirection001;
			case 3: return initialDirection007;
			case 2: return initialDirection015;
			case 1: return initialDirection024;
			case 0: return initialDirection033;
			case -1: return initialDirection042;
			case -2: return initialDirection051;
			case -3: return initialDirection059;
			case -4: return initialDirection065;
			}
			break;
		case 0:
			switch (dy) {
			case 4: return initialDirection002;
			case 3: return initialDirection008;
			case 2: return initialDirection016;
			case 1: return initialDirection025;
			case 0: return initialDirection034;
			case -1: return initialDirection043;
			case -2: return initialDirection052;
			case -3: return initialDirection060;
			case -4: return initialDirection066;
			}
			break;
		case 1:
			switch (dy) {
			case 4: return initialDirection003;
			case 3: return initialDirection009;
			case 2: return initialDirection017;
			case 1: return initialDirection026;
			case 0: return initialDirection035;
			case -1: return initialDirection044;
			case -2: return initialDirection053;
			case -3: return initialDirection061;
			case -4: return initialDirection067;
			}
			break;
		case 2:
			switch (dy) {
			case 4: return initialDirection004;
			case 3: return initialDirection010;
			case 2: return initialDirection018;
			case 1: return initialDirection027;
			case 0: return initialDirection036;
			case -1: return initialDirection045;
			case -2: return initialDirection054;
			case -3: return initialDirection062;
			case -4: return initialDirection068;
			}
			break;
		case 3:
			switch (dy) {
			case 3: return initialDirection011;
			case 2: return initialDirection019;
			case 1: return initialDirection028;
			case 0: return initialDirection037;
			case -1: return initialDirection046;
			case -2: return initialDirection055;
			case -3: return initialDirection063;
			}
			break;
		case 4:
			switch (dy) {
			case 2: return initialDirection020;
			case 1: return initialDirection029;
			case 0: return initialDirection038;
			case -1: return initialDirection047;
			case -2: return initialDirection056;
			}
			break;
		}
		potentialFactor000 = Math.max(Math.abs(target.x - maploc000.x), Math.abs(target.y - maploc000.y));
		potentialFactor001 = Math.max(Math.abs(target.x - maploc001.x), Math.abs(target.y - maploc001.y));
		potentialFactor002 = Math.max(Math.abs(target.x - maploc002.x), Math.abs(target.y - maploc002.y));
		potentialFactor003 = Math.max(Math.abs(target.x - maploc003.x), Math.abs(target.y - maploc003.y));
		potentialFactor004 = Math.max(Math.abs(target.x - maploc004.x), Math.abs(target.y - maploc004.y));
		potentialFactor005 = Math.max(Math.abs(target.x - maploc005.x), Math.abs(target.y - maploc005.y));
		potentialFactor006 = Math.max(Math.abs(target.x - maploc006.x), Math.abs(target.y - maploc006.y));
		potentialFactor010 = Math.max(Math.abs(target.x - maploc010.x), Math.abs(target.y - maploc010.y));
		potentialFactor011 = Math.max(Math.abs(target.x - maploc011.x), Math.abs(target.y - maploc011.y));
		potentialFactor012 = Math.max(Math.abs(target.x - maploc012.x), Math.abs(target.y - maploc012.y));
		potentialFactor013 = Math.max(Math.abs(target.x - maploc013.x), Math.abs(target.y - maploc013.y));
		potentialFactor019 = Math.max(Math.abs(target.x - maploc019.x), Math.abs(target.y - maploc019.y));
		potentialFactor020 = Math.max(Math.abs(target.x - maploc020.x), Math.abs(target.y - maploc020.y));
		potentialFactor021 = Math.max(Math.abs(target.x - maploc021.x), Math.abs(target.y - maploc021.y));
		potentialFactor029 = Math.max(Math.abs(target.x - maploc029.x), Math.abs(target.y - maploc029.y));
		potentialFactor030 = Math.max(Math.abs(target.x - maploc030.x), Math.abs(target.y - maploc030.y));
		potentialFactor038 = Math.max(Math.abs(target.x - maploc038.x), Math.abs(target.y - maploc038.y));
		potentialFactor039 = Math.max(Math.abs(target.x - maploc039.x), Math.abs(target.y - maploc039.y));
		potentialFactor047 = Math.max(Math.abs(target.x - maploc047.x), Math.abs(target.y - maploc047.y));
		potentialFactor048 = Math.max(Math.abs(target.x - maploc048.x), Math.abs(target.y - maploc048.y));
		potentialFactor049 = Math.max(Math.abs(target.x - maploc049.x), Math.abs(target.y - maploc049.y));
		potentialFactor055 = Math.max(Math.abs(target.x - maploc055.x), Math.abs(target.y - maploc055.y));
		potentialFactor056 = Math.max(Math.abs(target.x - maploc056.x), Math.abs(target.y - maploc056.y));
		potentialFactor057 = Math.max(Math.abs(target.x - maploc057.x), Math.abs(target.y - maploc057.y));
		potentialFactor058 = Math.max(Math.abs(target.x - maploc058.x), Math.abs(target.y - maploc058.y));
		potentialFactor062 = Math.max(Math.abs(target.x - maploc062.x), Math.abs(target.y - maploc062.y));
		potentialFactor063 = Math.max(Math.abs(target.x - maploc063.x), Math.abs(target.y - maploc063.y));
		potentialFactor064 = Math.max(Math.abs(target.x - maploc064.x), Math.abs(target.y - maploc064.y));
		potentialFactor065 = Math.max(Math.abs(target.x - maploc065.x), Math.abs(target.y - maploc065.y));
		potentialFactor066 = Math.max(Math.abs(target.x - maploc066.x), Math.abs(target.y - maploc066.y));
		potentialFactor067 = Math.max(Math.abs(target.x - maploc067.x), Math.abs(target.y - maploc067.y));
		potentialFactor068 = Math.max(Math.abs(target.x - maploc068.x), Math.abs(target.y - maploc068.y));
		if (isPassable068) {
			potentialFactor061 = Math.min(potentialFactor061, potentialFactor068 + 1);
			potentialFactor062 = Math.min(potentialFactor062, potentialFactor068 + 1);
			potentialFactor063 = Math.min(potentialFactor063, potentialFactor068 + 1);
			potentialFactor067 = Math.min(potentialFactor067, potentialFactor068 + 1);
		}

		if (isPassable064) {
			potentialFactor057 = Math.min(potentialFactor057, potentialFactor064 + 1);
			potentialFactor058 = Math.min(potentialFactor058, potentialFactor064 + 1);
			potentialFactor059 = Math.min(potentialFactor059, potentialFactor064 + 1);
			potentialFactor065 = Math.min(potentialFactor065, potentialFactor064 + 1);
		}

		if (isPassable056) {
			potentialFactor046 = Math.min(potentialFactor046, potentialFactor056 + 1);
			potentialFactor047 = Math.min(potentialFactor047, potentialFactor056 + 1);
			potentialFactor055 = Math.min(potentialFactor055, potentialFactor056 + 1);
			potentialFactor063 = Math.min(potentialFactor063, potentialFactor056 + 1);
		}

		if (isPassable048) {
			potentialFactor039 = Math.min(potentialFactor039, potentialFactor048 + 1);
			potentialFactor040 = Math.min(potentialFactor040, potentialFactor048 + 1);
			potentialFactor049 = Math.min(potentialFactor049, potentialFactor048 + 1);
			potentialFactor057 = Math.min(potentialFactor057, potentialFactor048 + 1);
		}

		if (isPassable020) {
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor020 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor020 + 1);
			potentialFactor028 = Math.min(potentialFactor028, potentialFactor020 + 1);
			potentialFactor029 = Math.min(potentialFactor029, potentialFactor020 + 1);
		}

		if (isPassable012) {
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor012 + 1);
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor012 + 1);
			potentialFactor021 = Math.min(potentialFactor021, potentialFactor012 + 1);
			potentialFactor022 = Math.min(potentialFactor022, potentialFactor012 + 1);
		}

		if (isPassable004) {
			potentialFactor003 = Math.min(potentialFactor003, potentialFactor004 + 1);
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor004 + 1);
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor004 + 1);
			potentialFactor011 = Math.min(potentialFactor011, potentialFactor004 + 1);
		}

		if (isPassable000) {
			potentialFactor001 = Math.min(potentialFactor001, potentialFactor000 + 1);
			potentialFactor005 = Math.min(potentialFactor005, potentialFactor000 + 1);
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor000 + 1);
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor000 + 1);
		}

		if (isPassable063) {
			potentialFactor054 = Math.min(potentialFactor054, potentialFactor063 + 1);
			potentialFactor055 = Math.min(potentialFactor055, potentialFactor063 + 1);
			potentialFactor062 = Math.min(potentialFactor062, potentialFactor063 + 1);
		}

		if (isPassable057) {
			potentialFactor049 = Math.min(potentialFactor049, potentialFactor057 + 1);
			potentialFactor050 = Math.min(potentialFactor050, potentialFactor057 + 1);
			potentialFactor058 = Math.min(potentialFactor058, potentialFactor057 + 1);
		}

		if (isPassable011) {
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor011 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor011 + 1);
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor011 + 1);
		}

		if (isPassable005) {
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor005 + 1);
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor005 + 1);
			potentialFactor014 = Math.min(potentialFactor014, potentialFactor005 + 1);
		}

		if (isPassable067) {
			potentialFactor060 = Math.min(potentialFactor060, potentialFactor067 + 1);
			potentialFactor061 = Math.min(potentialFactor061, potentialFactor067 + 1);
			potentialFactor062 = Math.min(potentialFactor062, potentialFactor067 + 1);
			potentialFactor066 = Math.min(potentialFactor066, potentialFactor067 + 1);
		}

		if (isPassable065) {
			potentialFactor058 = Math.min(potentialFactor058, potentialFactor065 + 1);
			potentialFactor059 = Math.min(potentialFactor059, potentialFactor065 + 1);
			potentialFactor060 = Math.min(potentialFactor060, potentialFactor065 + 1);
			potentialFactor066 = Math.min(potentialFactor066, potentialFactor065 + 1);
		}

		if (isPassable047) {
			potentialFactor037 = Math.min(potentialFactor037, potentialFactor047 + 1);
			potentialFactor038 = Math.min(potentialFactor038, potentialFactor047 + 1);
			potentialFactor046 = Math.min(potentialFactor046, potentialFactor047 + 1);
			potentialFactor055 = Math.min(potentialFactor055, potentialFactor047 + 1);
		}

		if (isPassable039) {
			potentialFactor030 = Math.min(potentialFactor030, potentialFactor039 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor039 + 1);
			potentialFactor040 = Math.min(potentialFactor040, potentialFactor039 + 1);
			potentialFactor049 = Math.min(potentialFactor049, potentialFactor039 + 1);
		}

		if (isPassable029) {
			potentialFactor019 = Math.min(potentialFactor019, potentialFactor029 + 1);
			potentialFactor028 = Math.min(potentialFactor028, potentialFactor029 + 1);
			potentialFactor037 = Math.min(potentialFactor037, potentialFactor029 + 1);
			potentialFactor038 = Math.min(potentialFactor038, potentialFactor029 + 1);
		}

		if (isPassable021) {
			potentialFactor013 = Math.min(potentialFactor013, potentialFactor021 + 1);
			potentialFactor022 = Math.min(potentialFactor022, potentialFactor021 + 1);
			potentialFactor030 = Math.min(potentialFactor030, potentialFactor021 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor021 + 1);
		}

		if (isPassable003) {
			potentialFactor002 = Math.min(potentialFactor002, potentialFactor003 + 1);
			potentialFactor008 = Math.min(potentialFactor008, potentialFactor003 + 1);
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor003 + 1);
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor003 + 1);
		}

		if (isPassable001) {
			potentialFactor002 = Math.min(potentialFactor002, potentialFactor001 + 1);
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor001 + 1);
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor001 + 1);
			potentialFactor008 = Math.min(potentialFactor008, potentialFactor001 + 1);
		}

		if (isPassable066) {
			potentialFactor059 = Math.min(potentialFactor059, potentialFactor066 + 1);
			potentialFactor060 = Math.min(potentialFactor060, potentialFactor066 + 1);
			potentialFactor061 = Math.min(potentialFactor061, potentialFactor066 + 1);
		}

		if (isPassable038) {
			potentialFactor028 = Math.min(potentialFactor028, potentialFactor038 + 1);
			potentialFactor037 = Math.min(potentialFactor037, potentialFactor038 + 1);
			potentialFactor046 = Math.min(potentialFactor046, potentialFactor038 + 1);
		}

		if (isPassable030) {
			potentialFactor022 = Math.min(potentialFactor022, potentialFactor030 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor030 + 1);
			potentialFactor040 = Math.min(potentialFactor040, potentialFactor030 + 1);
		}

		if (isPassable002) {
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor002 + 1);
			potentialFactor008 = Math.min(potentialFactor008, potentialFactor002 + 1);
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor002 + 1);
		}

		if (isPassable062) {
			potentialFactor053 = Math.min(potentialFactor053, potentialFactor062 + 1);
			potentialFactor054 = Math.min(potentialFactor054, potentialFactor062 + 1);
			potentialFactor055 = Math.min(potentialFactor055, potentialFactor062 + 1);
			potentialFactor061 = Math.min(potentialFactor061, potentialFactor062 + 1);
		}

		if (isPassable058) {
			potentialFactor049 = Math.min(potentialFactor049, potentialFactor058 + 1);
			potentialFactor050 = Math.min(potentialFactor050, potentialFactor058 + 1);
			potentialFactor051 = Math.min(potentialFactor051, potentialFactor058 + 1);
			potentialFactor059 = Math.min(potentialFactor059, potentialFactor058 + 1);
		}

		if (isPassable055) {
			potentialFactor045 = Math.min(potentialFactor045, potentialFactor055 + 1);
			potentialFactor046 = Math.min(potentialFactor046, potentialFactor055 + 1);
			potentialFactor054 = Math.min(potentialFactor054, potentialFactor055 + 1);
		}

		if (isPassable049) {
			potentialFactor040 = Math.min(potentialFactor040, potentialFactor049 + 1);
			potentialFactor041 = Math.min(potentialFactor041, potentialFactor049 + 1);
			potentialFactor050 = Math.min(potentialFactor050, potentialFactor049 + 1);
		}

		if (isPassable019) {
			potentialFactor010 = Math.min(potentialFactor010, potentialFactor019 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor019 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor019 + 1);
			potentialFactor028 = Math.min(potentialFactor028, potentialFactor019 + 1);
		}

		if (isPassable013) {
			potentialFactor006 = Math.min(potentialFactor006, potentialFactor013 + 1);
			potentialFactor014 = Math.min(potentialFactor014, potentialFactor013 + 1);
			potentialFactor022 = Math.min(potentialFactor022, potentialFactor013 + 1);
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor013 + 1);
		}

		if (isPassable010) {
			potentialFactor009 = Math.min(potentialFactor009, potentialFactor010 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor010 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor010 + 1);
		}

		if (isPassable006) {
			potentialFactor007 = Math.min(potentialFactor007, potentialFactor006 + 1);
			potentialFactor014 = Math.min(potentialFactor014, potentialFactor006 + 1);
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor006 + 1);
		}

		if (isPassable061) {
			potentialFactor052 = Math.min(potentialFactor052, potentialFactor061 + 1);
			potentialFactor053 = Math.min(potentialFactor053, potentialFactor061 + 1);
			potentialFactor054 = Math.min(potentialFactor054, potentialFactor061 + 1);
			potentialFactor060 = Math.min(potentialFactor060, potentialFactor061 + 1);
		}

		if (isPassable059) {
			potentialFactor050 = Math.min(potentialFactor050, potentialFactor059 + 1);
			potentialFactor051 = Math.min(potentialFactor051, potentialFactor059 + 1);
			potentialFactor052 = Math.min(potentialFactor052, potentialFactor059 + 1);
			potentialFactor060 = Math.min(potentialFactor060, potentialFactor059 + 1);
		}

		if (isPassable046) {
			potentialFactor036 = Math.min(potentialFactor036, potentialFactor046 + 1);
			potentialFactor037 = Math.min(potentialFactor037, potentialFactor046 + 1);
			potentialFactor045 = Math.min(potentialFactor045, potentialFactor046 + 1);
			potentialFactor054 = Math.min(potentialFactor054, potentialFactor046 + 1);
		}

		if (isPassable040) {
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor040 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor040 + 1);
			potentialFactor041 = Math.min(potentialFactor041, potentialFactor040 + 1);
			potentialFactor050 = Math.min(potentialFactor050, potentialFactor040 + 1);
		}

		if (isPassable028) {
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor028 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor028 + 1);
			potentialFactor036 = Math.min(potentialFactor036, potentialFactor028 + 1);
			potentialFactor037 = Math.min(potentialFactor037, potentialFactor028 + 1);
		}

		if (isPassable022) {
			potentialFactor014 = Math.min(potentialFactor014, potentialFactor022 + 1);
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor022 + 1);
			potentialFactor031 = Math.min(potentialFactor031, potentialFactor022 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor022 + 1);
		}

		if (isPassable009) {
			potentialFactor008 = Math.min(potentialFactor008, potentialFactor009 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor009 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor009 + 1);
			potentialFactor018 = Math.min(potentialFactor018, potentialFactor009 + 1);
		}

		if (isPassable007) {
			potentialFactor008 = Math.min(potentialFactor008, potentialFactor007 + 1);
			potentialFactor014 = Math.min(potentialFactor014, potentialFactor007 + 1);
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor007 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor007 + 1);
		}

		if (isPassable060) {
			potentialFactor051 = Math.min(potentialFactor051, potentialFactor060 + 1);
			potentialFactor052 = Math.min(potentialFactor052, potentialFactor060 + 1);
			potentialFactor053 = Math.min(potentialFactor053, potentialFactor060 + 1);
		}

		if (isPassable037) {
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor037 + 1);
			potentialFactor036 = Math.min(potentialFactor036, potentialFactor037 + 1);
			potentialFactor045 = Math.min(potentialFactor045, potentialFactor037 + 1);
		}

		if (isPassable031) {
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor031 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor031 + 1);
			potentialFactor041 = Math.min(potentialFactor041, potentialFactor031 + 1);
		}

		if (isPassable008) {
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor008 + 1);
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor008 + 1);
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor008 + 1);
		}

		if (isPassable054) {
			potentialFactor044 = Math.min(potentialFactor044, potentialFactor054 + 1);
			potentialFactor045 = Math.min(potentialFactor045, potentialFactor054 + 1);
			potentialFactor053 = Math.min(potentialFactor053, potentialFactor054 + 1);
		}

		if (isPassable050) {
			potentialFactor041 = Math.min(potentialFactor041, potentialFactor050 + 1);
			potentialFactor042 = Math.min(potentialFactor042, potentialFactor050 + 1);
			potentialFactor051 = Math.min(potentialFactor051, potentialFactor050 + 1);
		}

		if (isPassable018) {
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor018 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor018 + 1);
			potentialFactor027 = Math.min(potentialFactor027, potentialFactor018 + 1);
		}

		if (isPassable014) {
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor014 + 1);
			potentialFactor023 = Math.min(potentialFactor023, potentialFactor014 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor014 + 1);
		}

		if (isPassable053) {
			potentialFactor043 = Math.min(potentialFactor043, potentialFactor053 + 1);
			potentialFactor044 = Math.min(potentialFactor044, potentialFactor053 + 1);
			potentialFactor045 = Math.min(potentialFactor045, potentialFactor053 + 1);
			potentialFactor052 = Math.min(potentialFactor052, potentialFactor053 + 1);
		}

		if (isPassable051) {
			potentialFactor041 = Math.min(potentialFactor041, potentialFactor051 + 1);
			potentialFactor042 = Math.min(potentialFactor042, potentialFactor051 + 1);
			potentialFactor043 = Math.min(potentialFactor043, potentialFactor051 + 1);
			potentialFactor052 = Math.min(potentialFactor052, potentialFactor051 + 1);
		}

		if (isPassable045) {
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor045 + 1);
			potentialFactor036 = Math.min(potentialFactor036, potentialFactor045 + 1);
			potentialFactor044 = Math.min(potentialFactor044, potentialFactor045 + 1);
		}

		if (isPassable041) {
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor041 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor041 + 1);
			potentialFactor042 = Math.min(potentialFactor042, potentialFactor041 + 1);
		}

		if (isPassable027) {
			potentialFactor017 = Math.min(potentialFactor017, potentialFactor027 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor027 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor027 + 1);
			potentialFactor036 = Math.min(potentialFactor036, potentialFactor027 + 1);
		}

		if (isPassable023) {
			potentialFactor015 = Math.min(potentialFactor015, potentialFactor023 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor023 + 1);
			potentialFactor032 = Math.min(potentialFactor032, potentialFactor023 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor023 + 1);
		}

		if (isPassable017) {
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor017 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor017 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor017 + 1);
		}

		if (isPassable015) {
			potentialFactor016 = Math.min(potentialFactor016, potentialFactor015 + 1);
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor015 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor015 + 1);
		}

		if (isPassable052) {
			potentialFactor042 = Math.min(potentialFactor042, potentialFactor052 + 1);
			potentialFactor043 = Math.min(potentialFactor043, potentialFactor052 + 1);
			potentialFactor044 = Math.min(potentialFactor044, potentialFactor052 + 1);
		}

		if (isPassable036) {
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor036 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor036 + 1);
			potentialFactor044 = Math.min(potentialFactor044, potentialFactor036 + 1);
		}

		if (isPassable032) {
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor032 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor032 + 1);
			potentialFactor042 = Math.min(potentialFactor042, potentialFactor032 + 1);
		}

		if (isPassable016) {
			potentialFactor024 = Math.min(potentialFactor024, potentialFactor016 + 1);
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor016 + 1);
			potentialFactor026 = Math.min(potentialFactor026, potentialFactor016 + 1);
		}

		if (isPassable044) {
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor044 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor044 + 1);
			potentialFactor043 = Math.min(potentialFactor043, potentialFactor044 + 1);
		}

		if (isPassable042) {
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor042 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor042 + 1);
			potentialFactor043 = Math.min(potentialFactor043, potentialFactor042 + 1);
		}

		if (isPassable026) {
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor026 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor026 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor026 + 1);
		}

		if (isPassable024) {
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor024 + 1);
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor024 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor024 + 1);
		}

		if (isPassable043) {
			potentialFactor033 = Math.min(potentialFactor033, potentialFactor043 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor043 + 1);
			potentialFactor035 = Math.min(potentialFactor035, potentialFactor043 + 1);
		}

		if (isPassable035) {
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor035 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor035 + 1);
		}

		if (isPassable033) {
			potentialFactor025 = Math.min(potentialFactor025, potentialFactor033 + 1);
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor033 + 1);
		}

		if (isPassable025) {
			potentialFactor034 = Math.min(potentialFactor034, potentialFactor025 + 1);
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
				if (isPassable005 && accessibilityFactor000 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor005;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case SOUTH:
				if (isPassable006 && accessibilityFactor000 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor006;
					bestDirection = initialDirection000;
					bestLocation = maploc000;
				}
				break;
			case SOUTHEAST:
				if (isPassable007 && accessibilityFactor000 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor000 + potentialFactor007;
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
				if (isPassable006 && accessibilityFactor001 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor006;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case SOUTH:
				if (isPassable007 && accessibilityFactor001 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor007;
					bestDirection = initialDirection001;
					bestLocation = maploc001;
				}
				break;
			case SOUTHEAST:
				if (isPassable008 && accessibilityFactor001 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor001 + potentialFactor008;
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
			case EAST:
				if (isPassable003 && accessibilityFactor002 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor003;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTHWEST:
				if (isPassable007 && accessibilityFactor002 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor007;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTH:
				if (isPassable008 && accessibilityFactor002 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor008;
					bestDirection = initialDirection002;
					bestLocation = maploc002;
				}
				break;
			case SOUTHEAST:
				if (isPassable009 && accessibilityFactor002 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor002 + potentialFactor009;
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
			case WEST:
				if (isPassable002 && accessibilityFactor003 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor003 + potentialFactor002;
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
			case NORTHEAST:
				if (isPassable000 && accessibilityFactor005 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor000;
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
				if (isPassable012 && accessibilityFactor005 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor012;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case SOUTH:
				if (isPassable013 && accessibilityFactor005 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor013;
					bestDirection = initialDirection005;
					bestLocation = maploc005;
				}
				break;
			case SOUTHEAST:
				if (isPassable014 && accessibilityFactor005 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor005 + potentialFactor014;
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
			case NORTH:
				if (isPassable000 && accessibilityFactor006 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor000;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case NORTHEAST:
				if (isPassable001 && accessibilityFactor006 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor001;
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
				if (isPassable013 && accessibilityFactor006 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor013;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case SOUTH:
				if (isPassable014 && accessibilityFactor006 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor014;
					bestDirection = initialDirection006;
					bestLocation = maploc006;
				}
				break;
			case SOUTHEAST:
				if (isPassable015 && accessibilityFactor006 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor006 + potentialFactor015;
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
				if (isPassable000 && accessibilityFactor007 + potentialFactor000 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor000;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case NORTH:
				if (isPassable001 && accessibilityFactor007 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor001;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case NORTHEAST:
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
			case EAST:
				if (isPassable008 && accessibilityFactor007 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor008;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTHWEST:
				if (isPassable014 && accessibilityFactor007 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor014;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTH:
				if (isPassable015 && accessibilityFactor007 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor015;
					bestDirection = initialDirection007;
					bestLocation = maploc007;
				}
				break;
			case SOUTHEAST:
				if (isPassable016 && accessibilityFactor007 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor007 + potentialFactor016;
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
			case NORTHWEST:
				if (isPassable001 && accessibilityFactor008 + potentialFactor001 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor001;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case NORTH:
				if (isPassable002 && accessibilityFactor008 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor002;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case NORTHEAST:
				if (isPassable003 && accessibilityFactor008 + potentialFactor003 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor003;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case WEST:
				if (isPassable007 && accessibilityFactor008 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor007;
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
			case SOUTHWEST:
				if (isPassable015 && accessibilityFactor008 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor015;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case SOUTH:
				if (isPassable016 && accessibilityFactor008 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor016;
					bestDirection = initialDirection008;
					bestLocation = maploc008;
				}
				break;
			case SOUTHEAST:
				if (isPassable017 && accessibilityFactor008 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor008 + potentialFactor017;
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
			case NORTHWEST:
				if (isPassable002 && accessibilityFactor009 + potentialFactor002 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor002;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
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
				if (isPassable016 && accessibilityFactor009 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor016;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case SOUTH:
				if (isPassable017 && accessibilityFactor009 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor017;
					bestDirection = initialDirection009;
					bestLocation = maploc009;
				}
				break;
			case SOUTHEAST:
				if (isPassable018 && accessibilityFactor009 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor009 + potentialFactor018;
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
				if (isPassable017 && accessibilityFactor010 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor017;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case SOUTH:
				if (isPassable018 && accessibilityFactor010 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor018;
					bestDirection = initialDirection010;
					bestLocation = maploc010;
				}
				break;
			case SOUTHEAST:
				if (isPassable019 && accessibilityFactor010 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor010 + potentialFactor019;
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
			case SOUTHWEST:
				if (isPassable018 && accessibilityFactor011 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor018;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case SOUTH:
				if (isPassable019 && accessibilityFactor011 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor019;
					bestDirection = initialDirection011;
					bestLocation = maploc011;
				}
				break;
			case SOUTHEAST:
				if (isPassable020 && accessibilityFactor011 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor011 + potentialFactor020;
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
			case NORTHEAST:
				if (isPassable005 && accessibilityFactor012 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor005;
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
				if (isPassable021 && accessibilityFactor012 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor021;
					bestDirection = initialDirection012;
					bestLocation = maploc012;
				}
				break;
			case SOUTHEAST:
				if (isPassable022 && accessibilityFactor012 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor012 + potentialFactor022;
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
			case NORTH:
				if (isPassable005 && accessibilityFactor013 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor005;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case NORTHEAST:
				if (isPassable006 && accessibilityFactor013 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor006;
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
				if (isPassable021 && accessibilityFactor013 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor021;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case SOUTH:
				if (isPassable022 && accessibilityFactor013 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor022;
					bestDirection = initialDirection013;
					bestLocation = maploc013;
				}
				break;
			case SOUTHEAST:
				if (isPassable023 && accessibilityFactor013 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor013 + potentialFactor023;
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
				if (isPassable005 && accessibilityFactor014 + potentialFactor005 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor005;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case NORTH:
				if (isPassable006 && accessibilityFactor014 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor006;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case NORTHEAST:
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
			case EAST:
				if (isPassable015 && accessibilityFactor014 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor015;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case SOUTHWEST:
				if (isPassable022 && accessibilityFactor014 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor022;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case SOUTH:
				if (isPassable023 && accessibilityFactor014 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor023;
					bestDirection = initialDirection014;
					bestLocation = maploc014;
				}
				break;
			case SOUTHEAST:
				if (isPassable024 && accessibilityFactor014 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor014 + potentialFactor024;
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
			case NORTHWEST:
				if (isPassable006 && accessibilityFactor015 + potentialFactor006 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor006;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case NORTH:
				if (isPassable007 && accessibilityFactor015 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor007;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case NORTHEAST:
				if (isPassable008 && accessibilityFactor015 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor008;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case WEST:
				if (isPassable014 && accessibilityFactor015 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor014;
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
			case SOUTHWEST:
				if (isPassable023 && accessibilityFactor015 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor023;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case SOUTH:
				if (isPassable024 && accessibilityFactor015 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor024;
					bestDirection = initialDirection015;
					bestLocation = maploc015;
				}
				break;
			case SOUTHEAST:
				if (isPassable025 && accessibilityFactor015 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor015 + potentialFactor025;
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
				if (isPassable007 && accessibilityFactor016 + potentialFactor007 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor007;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case NORTH:
				if (isPassable008 && accessibilityFactor016 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor008;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case NORTHEAST:
				if (isPassable009 && accessibilityFactor016 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor009;
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
				if (isPassable024 && accessibilityFactor016 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor024;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case SOUTH:
				if (isPassable025 && accessibilityFactor016 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor025;
					bestDirection = initialDirection016;
					bestLocation = maploc016;
				}
				break;
			case SOUTHEAST:
				if (isPassable026 && accessibilityFactor016 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor016 + potentialFactor026;
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
				if (isPassable008 && accessibilityFactor017 + potentialFactor008 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor008;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case NORTH:
				if (isPassable009 && accessibilityFactor017 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor009;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case NORTHEAST:
				if (isPassable010 && accessibilityFactor017 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor010;
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
			case EAST:
				if (isPassable018 && accessibilityFactor017 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor018;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTHWEST:
				if (isPassable025 && accessibilityFactor017 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor025;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTH:
				if (isPassable026 && accessibilityFactor017 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor026;
					bestDirection = initialDirection017;
					bestLocation = maploc017;
				}
				break;
			case SOUTHEAST:
				if (isPassable027 && accessibilityFactor017 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor017 + potentialFactor027;
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
				if (isPassable009 && accessibilityFactor018 + potentialFactor009 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor009;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case NORTH:
				if (isPassable010 && accessibilityFactor018 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor010;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case NORTHEAST:
				if (isPassable011 && accessibilityFactor018 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor011;
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
			case CENTER:
				if (isPassable018 && accessibilityFactor018 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor018;
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
				if (isPassable026 && accessibilityFactor018 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor026;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case SOUTH:
				if (isPassable027 && accessibilityFactor018 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor027;
					bestDirection = initialDirection018;
					bestLocation = maploc018;
				}
				break;
			case SOUTHEAST:
				if (isPassable028 && accessibilityFactor018 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor018 + potentialFactor028;
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
				if (isPassable010 && accessibilityFactor019 + potentialFactor010 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor010;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case NORTH:
				if (isPassable011 && accessibilityFactor019 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor011;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case WEST:
				if (isPassable018 && accessibilityFactor019 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor018;
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
				if (isPassable027 && accessibilityFactor019 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor027;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case SOUTH:
				if (isPassable028 && accessibilityFactor019 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor028;
					bestDirection = initialDirection019;
					bestLocation = maploc019;
				}
				break;
			case SOUTHEAST:
				if (isPassable029 && accessibilityFactor019 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor019 + potentialFactor029;
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
				if (isPassable011 && accessibilityFactor020 + potentialFactor011 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor011;
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
			case SOUTHWEST:
				if (isPassable028 && accessibilityFactor020 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor028;
					bestDirection = initialDirection020;
					bestLocation = maploc020;
				}
				break;
			case SOUTH:
				if (isPassable029 && accessibilityFactor020 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor020 + potentialFactor029;
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
			case NORTH:
				if (isPassable012 && accessibilityFactor021 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor012;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case NORTHEAST:
				if (isPassable013 && accessibilityFactor021 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor013;
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
			case EAST:
				if (isPassable022 && accessibilityFactor021 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor022;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case SOUTH:
				if (isPassable030 && accessibilityFactor021 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor030;
					bestDirection = initialDirection021;
					bestLocation = maploc021;
				}
				break;
			case SOUTHEAST:
				if (isPassable031 && accessibilityFactor021 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor021 + potentialFactor031;
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
			case NORTHWEST:
				if (isPassable012 && accessibilityFactor022 + potentialFactor012 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor012;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case NORTH:
				if (isPassable013 && accessibilityFactor022 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor013;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case NORTHEAST:
				if (isPassable014 && accessibilityFactor022 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor014;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case WEST:
				if (isPassable021 && accessibilityFactor022 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor021;
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
			case SOUTHWEST:
				if (isPassable030 && accessibilityFactor022 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor030;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case SOUTH:
				if (isPassable031 && accessibilityFactor022 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor031;
					bestDirection = initialDirection022;
					bestLocation = maploc022;
				}
				break;
			case SOUTHEAST:
				if (isPassable032 && accessibilityFactor022 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor022 + potentialFactor032;
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
				if (isPassable013 && accessibilityFactor023 + potentialFactor013 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor013;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case NORTH:
				if (isPassable014 && accessibilityFactor023 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor014;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case NORTHEAST:
				if (isPassable015 && accessibilityFactor023 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor015;
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
			case SOUTHWEST:
				if (isPassable031 && accessibilityFactor023 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor031;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case SOUTH:
				if (isPassable032 && accessibilityFactor023 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor032;
					bestDirection = initialDirection023;
					bestLocation = maploc023;
				}
				break;
			case SOUTHEAST:
				if (isPassable033 && accessibilityFactor023 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor023 + potentialFactor033;
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
				if (isPassable014 && accessibilityFactor024 + potentialFactor014 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor014;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case NORTH:
				if (isPassable015 && accessibilityFactor024 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor015;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case NORTHEAST:
				if (isPassable016 && accessibilityFactor024 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor016;
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
				if (isPassable032 && accessibilityFactor024 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor032;
					bestDirection = initialDirection024;
					bestLocation = maploc024;
				}
				break;
			case SOUTH:
				if (isPassable033 && accessibilityFactor024 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor024 + potentialFactor033;
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
				if (isPassable015 && accessibilityFactor025 + potentialFactor015 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor015;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case NORTH:
				if (isPassable016 && accessibilityFactor025 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor016;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case NORTHEAST:
				if (isPassable017 && accessibilityFactor025 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor017;
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
				if (isPassable033 && accessibilityFactor025 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor033;
					bestDirection = initialDirection025;
					bestLocation = maploc025;
				}
				break;
			case SOUTHEAST:
				if (isPassable035 && accessibilityFactor025 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor025 + potentialFactor035;
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
			case NORTHWEST:
				if (isPassable016 && accessibilityFactor026 + potentialFactor016 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor016;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case NORTH:
				if (isPassable017 && accessibilityFactor026 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor017;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case NORTHEAST:
				if (isPassable018 && accessibilityFactor026 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor018;
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
			case SOUTH:
				if (isPassable035 && accessibilityFactor026 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor035;
					bestDirection = initialDirection026;
					bestLocation = maploc026;
				}
				break;
			case SOUTHEAST:
				if (isPassable036 && accessibilityFactor026 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor026 + potentialFactor036;
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
				if (isPassable017 && accessibilityFactor027 + potentialFactor017 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor017;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case NORTH:
				if (isPassable018 && accessibilityFactor027 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor018;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case NORTHEAST:
				if (isPassable019 && accessibilityFactor027 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor019;
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
				if (isPassable035 && accessibilityFactor027 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor035;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case SOUTH:
				if (isPassable036 && accessibilityFactor027 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor036;
					bestDirection = initialDirection027;
					bestLocation = maploc027;
				}
				break;
			case SOUTHEAST:
				if (isPassable037 && accessibilityFactor027 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor027 + potentialFactor037;
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
				if (isPassable018 && accessibilityFactor028 + potentialFactor018 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor018;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case NORTH:
				if (isPassable019 && accessibilityFactor028 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor019;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case NORTHEAST:
				if (isPassable020 && accessibilityFactor028 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor020;
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
			case EAST:
				if (isPassable029 && accessibilityFactor028 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor029;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case SOUTHWEST:
				if (isPassable036 && accessibilityFactor028 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor036;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case SOUTH:
				if (isPassable037 && accessibilityFactor028 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor037;
					bestDirection = initialDirection028;
					bestLocation = maploc028;
				}
				break;
			case SOUTHEAST:
				if (isPassable038 && accessibilityFactor028 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor028 + potentialFactor038;
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
				if (isPassable019 && accessibilityFactor029 + potentialFactor019 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor019;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case NORTH:
				if (isPassable020 && accessibilityFactor029 + potentialFactor020 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor020;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case WEST:
				if (isPassable028 && accessibilityFactor029 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor028;
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
			case SOUTHWEST:
				if (isPassable037 && accessibilityFactor029 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor037;
					bestDirection = initialDirection029;
					bestLocation = maploc029;
				}
				break;
			case SOUTH:
				if (isPassable038 && accessibilityFactor029 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor029 + potentialFactor038;
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
			case NORTH:
				if (isPassable021 && accessibilityFactor030 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor021;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case NORTHEAST:
				if (isPassable022 && accessibilityFactor030 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor022;
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
				if (isPassable039 && accessibilityFactor030 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor039;
					bestDirection = initialDirection030;
					bestLocation = maploc030;
				}
				break;
			case SOUTHEAST:
				if (isPassable040 && accessibilityFactor030 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor030 + potentialFactor040;
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
				if (isPassable021 && accessibilityFactor031 + potentialFactor021 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor021;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case NORTH:
				if (isPassable022 && accessibilityFactor031 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor022;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case NORTHEAST:
				if (isPassable023 && accessibilityFactor031 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor023;
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
				if (isPassable039 && accessibilityFactor031 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor039;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case SOUTH:
				if (isPassable040 && accessibilityFactor031 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor040;
					bestDirection = initialDirection031;
					bestLocation = maploc031;
				}
				break;
			case SOUTHEAST:
				if (isPassable041 && accessibilityFactor031 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor031 + potentialFactor041;
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
				if (isPassable022 && accessibilityFactor032 + potentialFactor022 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor022;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case NORTH:
				if (isPassable023 && accessibilityFactor032 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor023;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case NORTHEAST:
				if (isPassable024 && accessibilityFactor032 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor024;
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
				if (isPassable040 && accessibilityFactor032 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor040;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case SOUTH:
				if (isPassable041 && accessibilityFactor032 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor041;
					bestDirection = initialDirection032;
					bestLocation = maploc032;
				}
				break;
			case SOUTHEAST:
				if (isPassable042 && accessibilityFactor032 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor032 + potentialFactor042;
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
				if (isPassable023 && accessibilityFactor033 + potentialFactor023 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor023;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case NORTH:
				if (isPassable024 && accessibilityFactor033 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor024;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case NORTHEAST:
				if (isPassable025 && accessibilityFactor033 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor025;
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
				if (isPassable041 && accessibilityFactor033 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor041;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case SOUTH:
				if (isPassable042 && accessibilityFactor033 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor042;
					bestDirection = initialDirection033;
					bestLocation = maploc033;
				}
				break;
			case SOUTHEAST:
				if (isPassable043 && accessibilityFactor033 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor033 + potentialFactor043;
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
				if (isPassable024 && accessibilityFactor034 + potentialFactor024 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor024;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case NORTH:
				if (isPassable025 && accessibilityFactor034 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor025;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case NORTHEAST:
				if (isPassable026 && accessibilityFactor034 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor026;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case WEST:
				if (isPassable033 && accessibilityFactor034 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor033;
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
			case SOUTHWEST:
				if (isPassable042 && accessibilityFactor034 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor042;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case SOUTH:
				if (isPassable043 && accessibilityFactor034 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor043;
					bestDirection = initialDirection034;
					bestLocation = maploc034;
				}
				break;
			case SOUTHEAST:
				if (isPassable044 && accessibilityFactor034 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor034 + potentialFactor044;
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
				if (isPassable025 && accessibilityFactor035 + potentialFactor025 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor025;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case NORTH:
				if (isPassable026 && accessibilityFactor035 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor026;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case NORTHEAST:
				if (isPassable027 && accessibilityFactor035 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor027;
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
			case SOUTHWEST:
				if (isPassable043 && accessibilityFactor035 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor043;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case SOUTH:
				if (isPassable044 && accessibilityFactor035 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor044;
					bestDirection = initialDirection035;
					bestLocation = maploc035;
				}
				break;
			case SOUTHEAST:
				if (isPassable045 && accessibilityFactor035 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor035 + potentialFactor045;
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
				if (isPassable026 && accessibilityFactor036 + potentialFactor026 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor026;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case NORTH:
				if (isPassable027 && accessibilityFactor036 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor027;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case NORTHEAST:
				if (isPassable028 && accessibilityFactor036 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor028;
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
			case EAST:
				if (isPassable037 && accessibilityFactor036 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor037;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case SOUTHWEST:
				if (isPassable044 && accessibilityFactor036 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor044;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case SOUTH:
				if (isPassable045 && accessibilityFactor036 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor045;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			case SOUTHEAST:
				if (isPassable046 && accessibilityFactor036 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor036 + potentialFactor046;
					bestDirection = initialDirection036;
					bestLocation = maploc036;
				}
				break;
			default: break;
			}
		}
		if (isPassable037) {
			tempCurrentDirection = mapinfo037.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable027 && accessibilityFactor037 + potentialFactor027 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor027;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case NORTH:
				if (isPassable028 && accessibilityFactor037 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor028;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case NORTHEAST:
				if (isPassable029 && accessibilityFactor037 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor029;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case WEST:
				if (isPassable036 && accessibilityFactor037 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor036;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case CENTER:
				if (isPassable037 && accessibilityFactor037 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor037;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case EAST:
				if (isPassable038 && accessibilityFactor037 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor038;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case SOUTHWEST:
				if (isPassable045 && accessibilityFactor037 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor045;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case SOUTH:
				if (isPassable046 && accessibilityFactor037 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor046;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			case SOUTHEAST:
				if (isPassable047 && accessibilityFactor037 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor037 + potentialFactor047;
					bestDirection = initialDirection037;
					bestLocation = maploc037;
				}
				break;
			default: break;
			}
		}
		if (isPassable038) {
			tempCurrentDirection = mapinfo038.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable028 && accessibilityFactor038 + potentialFactor028 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor028;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			case NORTH:
				if (isPassable029 && accessibilityFactor038 + potentialFactor029 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor029;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			case WEST:
				if (isPassable037 && accessibilityFactor038 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor037;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			case CENTER:
				if (isPassable038 && accessibilityFactor038 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor038;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			case SOUTHWEST:
				if (isPassable046 && accessibilityFactor038 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor046;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			case SOUTH:
				if (isPassable047 && accessibilityFactor038 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor038 + potentialFactor047;
					bestDirection = initialDirection038;
					bestLocation = maploc038;
				}
				break;
			default: break;
			}
		}
		if (isPassable039) {
			tempCurrentDirection = mapinfo039.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable030 && accessibilityFactor039 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor030;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			case NORTHEAST:
				if (isPassable031 && accessibilityFactor039 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor031;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			case CENTER:
				if (isPassable039 && accessibilityFactor039 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor039;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			case EAST:
				if (isPassable040 && accessibilityFactor039 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor040;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			case SOUTH:
				if (isPassable048 && accessibilityFactor039 + potentialFactor048 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor048;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			case SOUTHEAST:
				if (isPassable049 && accessibilityFactor039 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor039 + potentialFactor049;
					bestDirection = initialDirection039;
					bestLocation = maploc039;
				}
				break;
			default: break;
			}
		}
		if (isPassable040) {
			tempCurrentDirection = mapinfo040.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable030 && accessibilityFactor040 + potentialFactor030 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor030;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case NORTH:
				if (isPassable031 && accessibilityFactor040 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor031;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case NORTHEAST:
				if (isPassable032 && accessibilityFactor040 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor032;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case WEST:
				if (isPassable039 && accessibilityFactor040 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor039;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case CENTER:
				if (isPassable040 && accessibilityFactor040 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor040;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case EAST:
				if (isPassable041 && accessibilityFactor040 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor041;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case SOUTHWEST:
				if (isPassable048 && accessibilityFactor040 + potentialFactor048 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor048;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case SOUTH:
				if (isPassable049 && accessibilityFactor040 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor049;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			case SOUTHEAST:
				if (isPassable050 && accessibilityFactor040 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor040 + potentialFactor050;
					bestDirection = initialDirection040;
					bestLocation = maploc040;
				}
				break;
			default: break;
			}
		}
		if (isPassable041) {
			tempCurrentDirection = mapinfo041.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable031 && accessibilityFactor041 + potentialFactor031 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor031;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case NORTH:
				if (isPassable032 && accessibilityFactor041 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor032;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case NORTHEAST:
				if (isPassable033 && accessibilityFactor041 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor033;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case WEST:
				if (isPassable040 && accessibilityFactor041 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor040;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case CENTER:
				if (isPassable041 && accessibilityFactor041 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor041;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case EAST:
				if (isPassable042 && accessibilityFactor041 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor042;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case SOUTHWEST:
				if (isPassable049 && accessibilityFactor041 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor049;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case SOUTH:
				if (isPassable050 && accessibilityFactor041 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor050;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			case SOUTHEAST:
				if (isPassable051 && accessibilityFactor041 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor041 + potentialFactor051;
					bestDirection = initialDirection041;
					bestLocation = maploc041;
				}
				break;
			default: break;
			}
		}
		if (isPassable042) {
			tempCurrentDirection = mapinfo042.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable032 && accessibilityFactor042 + potentialFactor032 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor032;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case NORTH:
				if (isPassable033 && accessibilityFactor042 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor033;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case WEST:
				if (isPassable041 && accessibilityFactor042 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor041;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case CENTER:
				if (isPassable042 && accessibilityFactor042 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor042;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case EAST:
				if (isPassable043 && accessibilityFactor042 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor043;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case SOUTHWEST:
				if (isPassable050 && accessibilityFactor042 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor050;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case SOUTH:
				if (isPassable051 && accessibilityFactor042 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor051;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			case SOUTHEAST:
				if (isPassable052 && accessibilityFactor042 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor042 + potentialFactor052;
					bestDirection = initialDirection042;
					bestLocation = maploc042;
				}
				break;
			default: break;
			}
		}
		if (isPassable043) {
			tempCurrentDirection = mapinfo043.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable033 && accessibilityFactor043 + potentialFactor033 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor033;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case NORTHEAST:
				if (isPassable035 && accessibilityFactor043 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor035;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case WEST:
				if (isPassable042 && accessibilityFactor043 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor042;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case CENTER:
				if (isPassable043 && accessibilityFactor043 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor043;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case EAST:
				if (isPassable044 && accessibilityFactor043 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor044;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case SOUTHWEST:
				if (isPassable051 && accessibilityFactor043 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor051;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case SOUTH:
				if (isPassable052 && accessibilityFactor043 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor052;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			case SOUTHEAST:
				if (isPassable053 && accessibilityFactor043 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor043 + potentialFactor053;
					bestDirection = initialDirection043;
					bestLocation = maploc043;
				}
				break;
			default: break;
			}
		}
		if (isPassable044) {
			tempCurrentDirection = mapinfo044.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable035 && accessibilityFactor044 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor035;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case NORTHEAST:
				if (isPassable036 && accessibilityFactor044 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor036;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case WEST:
				if (isPassable043 && accessibilityFactor044 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor043;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case CENTER:
				if (isPassable044 && accessibilityFactor044 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor044;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case EAST:
				if (isPassable045 && accessibilityFactor044 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor045;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case SOUTHWEST:
				if (isPassable052 && accessibilityFactor044 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor052;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case SOUTH:
				if (isPassable053 && accessibilityFactor044 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor053;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			case SOUTHEAST:
				if (isPassable054 && accessibilityFactor044 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor044 + potentialFactor054;
					bestDirection = initialDirection044;
					bestLocation = maploc044;
				}
				break;
			default: break;
			}
		}
		if (isPassable045) {
			tempCurrentDirection = mapinfo045.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable035 && accessibilityFactor045 + potentialFactor035 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor035;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case NORTH:
				if (isPassable036 && accessibilityFactor045 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor036;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case NORTHEAST:
				if (isPassable037 && accessibilityFactor045 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor037;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case WEST:
				if (isPassable044 && accessibilityFactor045 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor044;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case CENTER:
				if (isPassable045 && accessibilityFactor045 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor045;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case EAST:
				if (isPassable046 && accessibilityFactor045 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor046;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case SOUTHWEST:
				if (isPassable053 && accessibilityFactor045 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor053;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case SOUTH:
				if (isPassable054 && accessibilityFactor045 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor054;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			case SOUTHEAST:
				if (isPassable055 && accessibilityFactor045 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor045 + potentialFactor055;
					bestDirection = initialDirection045;
					bestLocation = maploc045;
				}
				break;
			default: break;
			}
		}
		if (isPassable046) {
			tempCurrentDirection = mapinfo046.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable036 && accessibilityFactor046 + potentialFactor036 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor036;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case NORTH:
				if (isPassable037 && accessibilityFactor046 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor037;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case NORTHEAST:
				if (isPassable038 && accessibilityFactor046 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor038;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case WEST:
				if (isPassable045 && accessibilityFactor046 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor045;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case CENTER:
				if (isPassable046 && accessibilityFactor046 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor046;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case EAST:
				if (isPassable047 && accessibilityFactor046 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor047;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case SOUTHWEST:
				if (isPassable054 && accessibilityFactor046 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor054;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case SOUTH:
				if (isPassable055 && accessibilityFactor046 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor055;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			case SOUTHEAST:
				if (isPassable056 && accessibilityFactor046 + potentialFactor056 < bestValue) {
					bestValue = accessibilityFactor046 + potentialFactor056;
					bestDirection = initialDirection046;
					bestLocation = maploc046;
				}
				break;
			default: break;
			}
		}
		if (isPassable047) {
			tempCurrentDirection = mapinfo047.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable037 && accessibilityFactor047 + potentialFactor037 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor037;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			case NORTH:
				if (isPassable038 && accessibilityFactor047 + potentialFactor038 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor038;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			case WEST:
				if (isPassable046 && accessibilityFactor047 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor046;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			case CENTER:
				if (isPassable047 && accessibilityFactor047 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor047;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			case SOUTHWEST:
				if (isPassable055 && accessibilityFactor047 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor055;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			case SOUTH:
				if (isPassable056 && accessibilityFactor047 + potentialFactor056 < bestValue) {
					bestValue = accessibilityFactor047 + potentialFactor056;
					bestDirection = initialDirection047;
					bestLocation = maploc047;
				}
				break;
			default: break;
			}
		}
		if (isPassable048) {
			tempCurrentDirection = mapinfo048.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTH:
				if (isPassable039 && accessibilityFactor048 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor048 + potentialFactor039;
					bestDirection = initialDirection048;
					bestLocation = maploc048;
				}
				break;
			case NORTHEAST:
				if (isPassable040 && accessibilityFactor048 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor048 + potentialFactor040;
					bestDirection = initialDirection048;
					bestLocation = maploc048;
				}
				break;
			case CENTER:
				if (isPassable048 && accessibilityFactor048 + potentialFactor048 < bestValue) {
					bestValue = accessibilityFactor048 + potentialFactor048;
					bestDirection = initialDirection048;
					bestLocation = maploc048;
				}
				break;
			case EAST:
				if (isPassable049 && accessibilityFactor048 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor048 + potentialFactor049;
					bestDirection = initialDirection048;
					bestLocation = maploc048;
				}
				break;
			case SOUTHEAST:
				if (isPassable057 && accessibilityFactor048 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor048 + potentialFactor057;
					bestDirection = initialDirection048;
					bestLocation = maploc048;
				}
				break;
			default: break;
			}
		}
		if (isPassable049) {
			tempCurrentDirection = mapinfo049.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable039 && accessibilityFactor049 + potentialFactor039 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor039;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case NORTH:
				if (isPassable040 && accessibilityFactor049 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor040;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case NORTHEAST:
				if (isPassable041 && accessibilityFactor049 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor041;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case WEST:
				if (isPassable048 && accessibilityFactor049 + potentialFactor048 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor048;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case CENTER:
				if (isPassable049 && accessibilityFactor049 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor049;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case EAST:
				if (isPassable050 && accessibilityFactor049 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor050;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case SOUTH:
				if (isPassable057 && accessibilityFactor049 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor057;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			case SOUTHEAST:
				if (isPassable058 && accessibilityFactor049 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor049 + potentialFactor058;
					bestDirection = initialDirection049;
					bestLocation = maploc049;
				}
				break;
			default: break;
			}
		}
		if (isPassable050) {
			tempCurrentDirection = mapinfo050.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable040 && accessibilityFactor050 + potentialFactor040 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor040;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case NORTH:
				if (isPassable041 && accessibilityFactor050 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor041;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case NORTHEAST:
				if (isPassable042 && accessibilityFactor050 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor042;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case WEST:
				if (isPassable049 && accessibilityFactor050 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor049;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case CENTER:
				if (isPassable050 && accessibilityFactor050 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor050;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case EAST:
				if (isPassable051 && accessibilityFactor050 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor051;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case SOUTHWEST:
				if (isPassable057 && accessibilityFactor050 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor057;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case SOUTH:
				if (isPassable058 && accessibilityFactor050 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor058;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			case SOUTHEAST:
				if (isPassable059 && accessibilityFactor050 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor050 + potentialFactor059;
					bestDirection = initialDirection050;
					bestLocation = maploc050;
				}
				break;
			default: break;
			}
		}
		if (isPassable051) {
			tempCurrentDirection = mapinfo051.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable041 && accessibilityFactor051 + potentialFactor041 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor041;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case NORTH:
				if (isPassable042 && accessibilityFactor051 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor042;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case NORTHEAST:
				if (isPassable043 && accessibilityFactor051 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor043;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case WEST:
				if (isPassable050 && accessibilityFactor051 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor050;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case CENTER:
				if (isPassable051 && accessibilityFactor051 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor051;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case EAST:
				if (isPassable052 && accessibilityFactor051 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor052;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case SOUTHWEST:
				if (isPassable058 && accessibilityFactor051 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor058;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case SOUTH:
				if (isPassable059 && accessibilityFactor051 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor059;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			case SOUTHEAST:
				if (isPassable060 && accessibilityFactor051 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor051 + potentialFactor060;
					bestDirection = initialDirection051;
					bestLocation = maploc051;
				}
				break;
			default: break;
			}
		}
		if (isPassable052) {
			tempCurrentDirection = mapinfo052.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable042 && accessibilityFactor052 + potentialFactor042 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor042;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case NORTH:
				if (isPassable043 && accessibilityFactor052 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor043;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case NORTHEAST:
				if (isPassable044 && accessibilityFactor052 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor044;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case WEST:
				if (isPassable051 && accessibilityFactor052 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor051;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case CENTER:
				if (isPassable052 && accessibilityFactor052 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor052;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case EAST:
				if (isPassable053 && accessibilityFactor052 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor053;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case SOUTHWEST:
				if (isPassable059 && accessibilityFactor052 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor059;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case SOUTH:
				if (isPassable060 && accessibilityFactor052 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor060;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			case SOUTHEAST:
				if (isPassable061 && accessibilityFactor052 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor052 + potentialFactor061;
					bestDirection = initialDirection052;
					bestLocation = maploc052;
				}
				break;
			default: break;
			}
		}
		if (isPassable053) {
			tempCurrentDirection = mapinfo053.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable043 && accessibilityFactor053 + potentialFactor043 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor043;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case NORTH:
				if (isPassable044 && accessibilityFactor053 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor044;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case NORTHEAST:
				if (isPassable045 && accessibilityFactor053 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor045;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case WEST:
				if (isPassable052 && accessibilityFactor053 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor052;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case CENTER:
				if (isPassable053 && accessibilityFactor053 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor053;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case EAST:
				if (isPassable054 && accessibilityFactor053 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor054;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case SOUTHWEST:
				if (isPassable060 && accessibilityFactor053 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor060;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case SOUTH:
				if (isPassable061 && accessibilityFactor053 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor061;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			case SOUTHEAST:
				if (isPassable062 && accessibilityFactor053 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor053 + potentialFactor062;
					bestDirection = initialDirection053;
					bestLocation = maploc053;
				}
				break;
			default: break;
			}
		}
		if (isPassable054) {
			tempCurrentDirection = mapinfo054.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable044 && accessibilityFactor054 + potentialFactor044 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor044;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case NORTH:
				if (isPassable045 && accessibilityFactor054 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor045;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case NORTHEAST:
				if (isPassable046 && accessibilityFactor054 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor046;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case WEST:
				if (isPassable053 && accessibilityFactor054 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor053;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case CENTER:
				if (isPassable054 && accessibilityFactor054 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor054;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case EAST:
				if (isPassable055 && accessibilityFactor054 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor055;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case SOUTHWEST:
				if (isPassable061 && accessibilityFactor054 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor061;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case SOUTH:
				if (isPassable062 && accessibilityFactor054 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor062;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			case SOUTHEAST:
				if (isPassable063 && accessibilityFactor054 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor054 + potentialFactor063;
					bestDirection = initialDirection054;
					bestLocation = maploc054;
				}
				break;
			default: break;
			}
		}
		if (isPassable055) {
			tempCurrentDirection = mapinfo055.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable045 && accessibilityFactor055 + potentialFactor045 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor045;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case NORTH:
				if (isPassable046 && accessibilityFactor055 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor046;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case NORTHEAST:
				if (isPassable047 && accessibilityFactor055 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor047;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case WEST:
				if (isPassable054 && accessibilityFactor055 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor054;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case CENTER:
				if (isPassable055 && accessibilityFactor055 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor055;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case EAST:
				if (isPassable056 && accessibilityFactor055 + potentialFactor056 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor056;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case SOUTHWEST:
				if (isPassable062 && accessibilityFactor055 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor062;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			case SOUTH:
				if (isPassable063 && accessibilityFactor055 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor055 + potentialFactor063;
					bestDirection = initialDirection055;
					bestLocation = maploc055;
				}
				break;
			default: break;
			}
		}
		if (isPassable056) {
			tempCurrentDirection = mapinfo056.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable046 && accessibilityFactor056 + potentialFactor046 < bestValue) {
					bestValue = accessibilityFactor056 + potentialFactor046;
					bestDirection = initialDirection056;
					bestLocation = maploc056;
				}
				break;
			case NORTH:
				if (isPassable047 && accessibilityFactor056 + potentialFactor047 < bestValue) {
					bestValue = accessibilityFactor056 + potentialFactor047;
					bestDirection = initialDirection056;
					bestLocation = maploc056;
				}
				break;
			case WEST:
				if (isPassable055 && accessibilityFactor056 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor056 + potentialFactor055;
					bestDirection = initialDirection056;
					bestLocation = maploc056;
				}
				break;
			case CENTER:
				if (isPassable056 && accessibilityFactor056 + potentialFactor056 < bestValue) {
					bestValue = accessibilityFactor056 + potentialFactor056;
					bestDirection = initialDirection056;
					bestLocation = maploc056;
				}
				break;
			case SOUTHWEST:
				if (isPassable063 && accessibilityFactor056 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor056 + potentialFactor063;
					bestDirection = initialDirection056;
					bestLocation = maploc056;
				}
				break;
			default: break;
			}
		}
		if (isPassable057) {
			tempCurrentDirection = mapinfo057.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable048 && accessibilityFactor057 + potentialFactor048 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor048;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			case NORTH:
				if (isPassable049 && accessibilityFactor057 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor049;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			case NORTHEAST:
				if (isPassable050 && accessibilityFactor057 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor050;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			case CENTER:
				if (isPassable057 && accessibilityFactor057 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor057;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			case EAST:
				if (isPassable058 && accessibilityFactor057 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor058;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			case SOUTHEAST:
				if (isPassable064 && accessibilityFactor057 + potentialFactor064 < bestValue) {
					bestValue = accessibilityFactor057 + potentialFactor064;
					bestDirection = initialDirection057;
					bestLocation = maploc057;
				}
				break;
			default: break;
			}
		}
		if (isPassable058) {
			tempCurrentDirection = mapinfo058.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable049 && accessibilityFactor058 + potentialFactor049 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor049;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case NORTH:
				if (isPassable050 && accessibilityFactor058 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor050;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case NORTHEAST:
				if (isPassable051 && accessibilityFactor058 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor051;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case WEST:
				if (isPassable057 && accessibilityFactor058 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor057;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case CENTER:
				if (isPassable058 && accessibilityFactor058 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor058;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case EAST:
				if (isPassable059 && accessibilityFactor058 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor059;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case SOUTH:
				if (isPassable064 && accessibilityFactor058 + potentialFactor064 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor064;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			case SOUTHEAST:
				if (isPassable065 && accessibilityFactor058 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor058 + potentialFactor065;
					bestDirection = initialDirection058;
					bestLocation = maploc058;
				}
				break;
			default: break;
			}
		}
		if (isPassable059) {
			tempCurrentDirection = mapinfo059.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable050 && accessibilityFactor059 + potentialFactor050 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor050;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case NORTH:
				if (isPassable051 && accessibilityFactor059 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor051;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case NORTHEAST:
				if (isPassable052 && accessibilityFactor059 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor052;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case WEST:
				if (isPassable058 && accessibilityFactor059 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor058;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case CENTER:
				if (isPassable059 && accessibilityFactor059 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor059;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case EAST:
				if (isPassable060 && accessibilityFactor059 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor060;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case SOUTHWEST:
				if (isPassable064 && accessibilityFactor059 + potentialFactor064 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor064;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case SOUTH:
				if (isPassable065 && accessibilityFactor059 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor065;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			case SOUTHEAST:
				if (isPassable066 && accessibilityFactor059 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor059 + potentialFactor066;
					bestDirection = initialDirection059;
					bestLocation = maploc059;
				}
				break;
			default: break;
			}
		}
		if (isPassable060) {
			tempCurrentDirection = mapinfo060.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable051 && accessibilityFactor060 + potentialFactor051 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor051;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case NORTH:
				if (isPassable052 && accessibilityFactor060 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor052;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case NORTHEAST:
				if (isPassable053 && accessibilityFactor060 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor053;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case WEST:
				if (isPassable059 && accessibilityFactor060 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor059;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case CENTER:
				if (isPassable060 && accessibilityFactor060 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor060;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case EAST:
				if (isPassable061 && accessibilityFactor060 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor061;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case SOUTHWEST:
				if (isPassable065 && accessibilityFactor060 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor065;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case SOUTH:
				if (isPassable066 && accessibilityFactor060 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor066;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			case SOUTHEAST:
				if (isPassable067 && accessibilityFactor060 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor060 + potentialFactor067;
					bestDirection = initialDirection060;
					bestLocation = maploc060;
				}
				break;
			default: break;
			}
		}
		if (isPassable061) {
			tempCurrentDirection = mapinfo061.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable052 && accessibilityFactor061 + potentialFactor052 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor052;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case NORTH:
				if (isPassable053 && accessibilityFactor061 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor053;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case NORTHEAST:
				if (isPassable054 && accessibilityFactor061 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor054;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case WEST:
				if (isPassable060 && accessibilityFactor061 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor060;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case CENTER:
				if (isPassable061 && accessibilityFactor061 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor061;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case EAST:
				if (isPassable062 && accessibilityFactor061 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor062;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case SOUTHWEST:
				if (isPassable066 && accessibilityFactor061 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor066;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case SOUTH:
				if (isPassable067 && accessibilityFactor061 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor067;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			case SOUTHEAST:
				if (isPassable068 && accessibilityFactor061 + potentialFactor068 < bestValue) {
					bestValue = accessibilityFactor061 + potentialFactor068;
					bestDirection = initialDirection061;
					bestLocation = maploc061;
				}
				break;
			default: break;
			}
		}
		if (isPassable062) {
			tempCurrentDirection = mapinfo062.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable053 && accessibilityFactor062 + potentialFactor053 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor053;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case NORTH:
				if (isPassable054 && accessibilityFactor062 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor054;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case NORTHEAST:
				if (isPassable055 && accessibilityFactor062 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor055;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case WEST:
				if (isPassable061 && accessibilityFactor062 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor061;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case CENTER:
				if (isPassable062 && accessibilityFactor062 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor062;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case EAST:
				if (isPassable063 && accessibilityFactor062 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor063;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case SOUTHWEST:
				if (isPassable067 && accessibilityFactor062 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor067;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			case SOUTH:
				if (isPassable068 && accessibilityFactor062 + potentialFactor068 < bestValue) {
					bestValue = accessibilityFactor062 + potentialFactor068;
					bestDirection = initialDirection062;
					bestLocation = maploc062;
				}
				break;
			default: break;
			}
		}
		if (isPassable063) {
			tempCurrentDirection = mapinfo063.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable054 && accessibilityFactor063 + potentialFactor054 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor054;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			case NORTH:
				if (isPassable055 && accessibilityFactor063 + potentialFactor055 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor055;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			case NORTHEAST:
				if (isPassable056 && accessibilityFactor063 + potentialFactor056 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor056;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			case WEST:
				if (isPassable062 && accessibilityFactor063 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor062;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			case CENTER:
				if (isPassable063 && accessibilityFactor063 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor063;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			case SOUTHWEST:
				if (isPassable068 && accessibilityFactor063 + potentialFactor068 < bestValue) {
					bestValue = accessibilityFactor063 + potentialFactor068;
					bestDirection = initialDirection063;
					bestLocation = maploc063;
				}
				break;
			default: break;
			}
		}
		if (isPassable064) {
			tempCurrentDirection = mapinfo064.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable057 && accessibilityFactor064 + potentialFactor057 < bestValue) {
					bestValue = accessibilityFactor064 + potentialFactor057;
					bestDirection = initialDirection064;
					bestLocation = maploc064;
				}
				break;
			case NORTH:
				if (isPassable058 && accessibilityFactor064 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor064 + potentialFactor058;
					bestDirection = initialDirection064;
					bestLocation = maploc064;
				}
				break;
			case NORTHEAST:
				if (isPassable059 && accessibilityFactor064 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor064 + potentialFactor059;
					bestDirection = initialDirection064;
					bestLocation = maploc064;
				}
				break;
			case CENTER:
				if (isPassable064 && accessibilityFactor064 + potentialFactor064 < bestValue) {
					bestValue = accessibilityFactor064 + potentialFactor064;
					bestDirection = initialDirection064;
					bestLocation = maploc064;
				}
				break;
			case EAST:
				if (isPassable065 && accessibilityFactor064 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor064 + potentialFactor065;
					bestDirection = initialDirection064;
					bestLocation = maploc064;
				}
				break;
			default: break;
			}
		}
		if (isPassable065) {
			tempCurrentDirection = mapinfo065.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable058 && accessibilityFactor065 + potentialFactor058 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor058;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			case NORTH:
				if (isPassable059 && accessibilityFactor065 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor059;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			case NORTHEAST:
				if (isPassable060 && accessibilityFactor065 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor060;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			case WEST:
				if (isPassable064 && accessibilityFactor065 + potentialFactor064 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor064;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			case CENTER:
				if (isPassable065 && accessibilityFactor065 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor065;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			case EAST:
				if (isPassable066 && accessibilityFactor065 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor065 + potentialFactor066;
					bestDirection = initialDirection065;
					bestLocation = maploc065;
				}
				break;
			default: break;
			}
		}
		if (isPassable066) {
			tempCurrentDirection = mapinfo066.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable059 && accessibilityFactor066 + potentialFactor059 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor059;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			case NORTH:
				if (isPassable060 && accessibilityFactor066 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor060;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			case NORTHEAST:
				if (isPassable061 && accessibilityFactor066 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor061;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			case WEST:
				if (isPassable065 && accessibilityFactor066 + potentialFactor065 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor065;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			case CENTER:
				if (isPassable066 && accessibilityFactor066 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor066;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			case EAST:
				if (isPassable067 && accessibilityFactor066 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor066 + potentialFactor067;
					bestDirection = initialDirection066;
					bestLocation = maploc066;
				}
				break;
			default: break;
			}
		}
		if (isPassable067) {
			tempCurrentDirection = mapinfo067.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable060 && accessibilityFactor067 + potentialFactor060 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor060;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			case NORTH:
				if (isPassable061 && accessibilityFactor067 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor061;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			case NORTHEAST:
				if (isPassable062 && accessibilityFactor067 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor062;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			case WEST:
				if (isPassable066 && accessibilityFactor067 + potentialFactor066 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor066;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			case CENTER:
				if (isPassable067 && accessibilityFactor067 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor067;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			case EAST:
				if (isPassable068 && accessibilityFactor067 + potentialFactor068 < bestValue) {
					bestValue = accessibilityFactor067 + potentialFactor068;
					bestDirection = initialDirection067;
					bestLocation = maploc067;
				}
				break;
			default: break;
			}
		}
		if (isPassable068) {
			tempCurrentDirection = mapinfo068.getCurrentDirection();
			switch (tempCurrentDirection) {
			case NORTHWEST:
				if (isPassable061 && accessibilityFactor068 + potentialFactor061 < bestValue) {
					bestValue = accessibilityFactor068 + potentialFactor061;
					bestDirection = initialDirection068;
					bestLocation = maploc068;
				}
				break;
			case NORTH:
				if (isPassable062 && accessibilityFactor068 + potentialFactor062 < bestValue) {
					bestValue = accessibilityFactor068 + potentialFactor062;
					bestDirection = initialDirection068;
					bestLocation = maploc068;
				}
				break;
			case NORTHEAST:
				if (isPassable063 && accessibilityFactor068 + potentialFactor063 < bestValue) {
					bestValue = accessibilityFactor068 + potentialFactor063;
					bestDirection = initialDirection068;
					bestLocation = maploc068;
				}
				break;
			case WEST:
				if (isPassable067 && accessibilityFactor068 + potentialFactor067 < bestValue) {
					bestValue = accessibilityFactor068 + potentialFactor067;
					bestDirection = initialDirection068;
					bestLocation = maploc068;
				}
				break;
			case CENTER:
				if (isPassable068 && accessibilityFactor068 + potentialFactor068 < bestValue) {
					bestValue = accessibilityFactor068 + potentialFactor068;
					bestDirection = initialDirection068;
					bestLocation = maploc068;
				}
				break;
			default: break;
			}
		}
		
		// System.out.println("bestValue = " + bestValue + ", bestDirection = " + (bestDirection == null ? "null" : bestDirection.name()));
		// System.out.println("dx = " + dx + ", dy = " + dy);
		// System.out.println("bestLocation = " + bestLocation.toString());
		if (bestDirection != null) rc.setIndicatorLine(maploc034.add(bestDirection), bestLocation, 0, 255, 0);
		return bestDirection;
	}
}
