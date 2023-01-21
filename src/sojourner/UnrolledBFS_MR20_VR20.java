package sojourner;

import battlecode.common.*;
import java.math.*;

public class UnrolledBFS_MR20_VR20 {
	static RobotController rc;

	public static void init(RobotController _rc) { rc = _rc; }

	static MapLocation maploc1000;
	static MapInfo mapinfo1000;
	static int accessibilityFactor1000;
	static int potentialFactor1000;
	static Direction initialDirection1000;

	static MapLocation maploc1001;
	static MapInfo mapinfo1001;
	static int accessibilityFactor1001;
	static int potentialFactor1001;
	static Direction initialDirection1001;

	static MapLocation maploc1002;
	static MapInfo mapinfo1002;
	static int accessibilityFactor1002;
	static int potentialFactor1002;
	static Direction initialDirection1002;

	static MapLocation maploc1003;
	static MapInfo mapinfo1003;
	static int accessibilityFactor1003;
	static int potentialFactor1003;
	static Direction initialDirection1003;

	static MapLocation maploc1004;
	static MapInfo mapinfo1004;
	static int accessibilityFactor1004;
	static int potentialFactor1004;
	static Direction initialDirection1004;

	static MapLocation maploc1005;
	static MapInfo mapinfo1005;
	static int accessibilityFactor1005;
	static int potentialFactor1005;
	static Direction initialDirection1005;

	static MapLocation maploc1006;
	static MapInfo mapinfo1006;
	static int accessibilityFactor1006;
	static int potentialFactor1006;
	static Direction initialDirection1006;

	static MapLocation maploc1007;
	static MapInfo mapinfo1007;
	static int accessibilityFactor1007;
	static int potentialFactor1007;
	static Direction initialDirection1007;

	static MapLocation maploc1008;
	static MapInfo mapinfo1008;
	static int accessibilityFactor1008;
	static int potentialFactor1008;
	static Direction initialDirection1008;

	static MapLocation maploc1009;
	static MapInfo mapinfo1009;
	static int accessibilityFactor1009;
	static int potentialFactor1009;
	static Direction initialDirection1009;

	static MapLocation maploc1010;
	static MapInfo mapinfo1010;
	static int accessibilityFactor1010;
	static int potentialFactor1010;
	static Direction initialDirection1010;

	static MapLocation maploc1011;
	static MapInfo mapinfo1011;
	static int accessibilityFactor1011;
	static int potentialFactor1011;
	static Direction initialDirection1011;

	static MapLocation maploc1012;
	static MapInfo mapinfo1012;
	static int accessibilityFactor1012;
	static int potentialFactor1012;
	static Direction initialDirection1012;

	static MapLocation maploc1013;
	static MapInfo mapinfo1013;
	static int accessibilityFactor1013;
	static int potentialFactor1013;
	static Direction initialDirection1013;

	static MapLocation maploc1014;
	static MapInfo mapinfo1014;
	static int accessibilityFactor1014;
	static int potentialFactor1014;
	static Direction initialDirection1014;

	static MapLocation maploc1015;
	static MapInfo mapinfo1015;
	static int accessibilityFactor1015;
	static int potentialFactor1015;
	static Direction initialDirection1015;

	static MapLocation maploc1016;
	static MapInfo mapinfo1016;
	static int accessibilityFactor1016;
	static int potentialFactor1016;
	static Direction initialDirection1016;

	static MapLocation maploc1017;
	static MapInfo mapinfo1017;
	static int accessibilityFactor1017;
	static int potentialFactor1017;
	static Direction initialDirection1017;

	static MapLocation maploc1018;
	static MapInfo mapinfo1018;
	static int accessibilityFactor1018;
	static int potentialFactor1018;
	static Direction initialDirection1018;

	static MapLocation maploc1019;
	static MapInfo mapinfo1019;
	static int accessibilityFactor1019;
	static int potentialFactor1019;
	static Direction initialDirection1019;

	static MapLocation maploc1020;
	static MapInfo mapinfo1020;
	static int accessibilityFactor1020;
	static int potentialFactor1020;
	static Direction initialDirection1020;

	static MapLocation maploc1021;
	static MapInfo mapinfo1021;
	static int accessibilityFactor1021;
	static int potentialFactor1021;
	static Direction initialDirection1021;

	static MapLocation maploc1022;
	static MapInfo mapinfo1022;
	static int accessibilityFactor1022;
	static int potentialFactor1022;
	static Direction initialDirection1022;

	static MapLocation maploc1023;
	static MapInfo mapinfo1023;
	static int accessibilityFactor1023;
	static int potentialFactor1023;
	static Direction initialDirection1023;

	static MapLocation maploc1024;
	static MapInfo mapinfo1024;
	static int accessibilityFactor1024;
	static int potentialFactor1024;
	static Direction initialDirection1024;

	static MapLocation maploc1025;
	static MapInfo mapinfo1025;
	static int accessibilityFactor1025;
	static int potentialFactor1025;
	static Direction initialDirection1025;

	static MapLocation maploc1026;
	static MapInfo mapinfo1026;
	static int accessibilityFactor1026;
	static int potentialFactor1026;
	static Direction initialDirection1026;

	static MapLocation maploc1027;
	static MapInfo mapinfo1027;
	static int accessibilityFactor1027;
	static int potentialFactor1027;
	static Direction initialDirection1027;

	static MapLocation maploc1028;
	static MapInfo mapinfo1028;
	static int accessibilityFactor1028;
	static int potentialFactor1028;
	static Direction initialDirection1028;

	static MapLocation maploc1029;
	static MapInfo mapinfo1029;
	static int accessibilityFactor1029;
	static int potentialFactor1029;
	static Direction initialDirection1029;

	static MapLocation maploc1030;
	static MapInfo mapinfo1030;
	static int accessibilityFactor1030;
	static int potentialFactor1030;
	static Direction initialDirection1030;

	static MapLocation maploc1031;
	static MapInfo mapinfo1031;
	static int accessibilityFactor1031;
	static int potentialFactor1031;
	static Direction initialDirection1031;

	static MapLocation maploc1032;
	static MapInfo mapinfo1032;
	static int accessibilityFactor1032;
	static int potentialFactor1032;
	static Direction initialDirection1032;

	static MapLocation maploc1033;
	static MapInfo mapinfo1033;
	static int accessibilityFactor1033;
	static int potentialFactor1033;
	static Direction initialDirection1033;

	static MapLocation maploc1034;
	static MapInfo mapinfo1034;
	static int accessibilityFactor1034;
	static int potentialFactor1034;
	static Direction initialDirection1034;

	static MapLocation maploc1035;
	static MapInfo mapinfo1035;
	static int accessibilityFactor1035;
	static int potentialFactor1035;
	static Direction initialDirection1035;

	static MapLocation maploc1036;
	static MapInfo mapinfo1036;
	static int accessibilityFactor1036;
	static int potentialFactor1036;
	static Direction initialDirection1036;

	static MapLocation maploc1037;
	static MapInfo mapinfo1037;
	static int accessibilityFactor1037;
	static int potentialFactor1037;
	static Direction initialDirection1037;

	static MapLocation maploc1038;
	static MapInfo mapinfo1038;
	static int accessibilityFactor1038;
	static int potentialFactor1038;
	static Direction initialDirection1038;

	static MapLocation maploc1039;
	static MapInfo mapinfo1039;
	static int accessibilityFactor1039;
	static int potentialFactor1039;
	static Direction initialDirection1039;

	static MapLocation maploc1040;
	static MapInfo mapinfo1040;
	static int accessibilityFactor1040;
	static int potentialFactor1040;
	static Direction initialDirection1040;

	static MapLocation maploc1041;
	static MapInfo mapinfo1041;
	static int accessibilityFactor1041;
	static int potentialFactor1041;
	static Direction initialDirection1041;

	static MapLocation maploc1042;
	static MapInfo mapinfo1042;
	static int accessibilityFactor1042;
	static int potentialFactor1042;
	static Direction initialDirection1042;

	static MapLocation maploc1043;
	static MapInfo mapinfo1043;
	static int accessibilityFactor1043;
	static int potentialFactor1043;
	static Direction initialDirection1043;

	static MapLocation maploc1044;
	static MapInfo mapinfo1044;
	static int accessibilityFactor1044;
	static int potentialFactor1044;
	static Direction initialDirection1044;

	static MapLocation maploc1045;
	static MapInfo mapinfo1045;
	static int accessibilityFactor1045;
	static int potentialFactor1045;
	static Direction initialDirection1045;

	static MapLocation maploc1046;
	static MapInfo mapinfo1046;
	static int accessibilityFactor1046;
	static int potentialFactor1046;
	static Direction initialDirection1046;

	static MapLocation maploc1047;
	static MapInfo mapinfo1047;
	static int accessibilityFactor1047;
	static int potentialFactor1047;
	static Direction initialDirection1047;

	static MapLocation maploc1048;
	static MapInfo mapinfo1048;
	static int accessibilityFactor1048;
	static int potentialFactor1048;
	static Direction initialDirection1048;

	static MapLocation maploc1049;
	static MapInfo mapinfo1049;
	static int accessibilityFactor1049;
	static int potentialFactor1049;
	static Direction initialDirection1049;

	static MapLocation maploc1050;
	static MapInfo mapinfo1050;
	static int accessibilityFactor1050;
	static int potentialFactor1050;
	static Direction initialDirection1050;

	static MapLocation maploc1051;
	static MapInfo mapinfo1051;
	static int accessibilityFactor1051;
	static int potentialFactor1051;
	static Direction initialDirection1051;

	static MapLocation maploc1052;
	static MapInfo mapinfo1052;
	static int accessibilityFactor1052;
	static int potentialFactor1052;
	static Direction initialDirection1052;

	static MapLocation maploc1053;
	static MapInfo mapinfo1053;
	static int accessibilityFactor1053;
	static int potentialFactor1053;
	static Direction initialDirection1053;

	static MapLocation maploc1054;
	static MapInfo mapinfo1054;
	static int accessibilityFactor1054;
	static int potentialFactor1054;
	static Direction initialDirection1054;

	static MapLocation maploc1055;
	static MapInfo mapinfo1055;
	static int accessibilityFactor1055;
	static int potentialFactor1055;
	static Direction initialDirection1055;

	static MapLocation maploc1056;
	static MapInfo mapinfo1056;
	static int accessibilityFactor1056;
	static int potentialFactor1056;
	static Direction initialDirection1056;

	static MapLocation maploc1057;
	static MapInfo mapinfo1057;
	static int accessibilityFactor1057;
	static int potentialFactor1057;
	static Direction initialDirection1057;

	static MapLocation maploc1058;
	static MapInfo mapinfo1058;
	static int accessibilityFactor1058;
	static int potentialFactor1058;
	static Direction initialDirection1058;

	static MapLocation maploc1059;
	static MapInfo mapinfo1059;
	static int accessibilityFactor1059;
	static int potentialFactor1059;
	static Direction initialDirection1059;

	static MapLocation maploc1060;
	static MapInfo mapinfo1060;
	static int accessibilityFactor1060;
	static int potentialFactor1060;
	static Direction initialDirection1060;

	static MapLocation maploc1061;
	static MapInfo mapinfo1061;
	static int accessibilityFactor1061;
	static int potentialFactor1061;
	static Direction initialDirection1061;

	static MapLocation maploc1062;
	static MapInfo mapinfo1062;
	static int accessibilityFactor1062;
	static int potentialFactor1062;
	static Direction initialDirection1062;

	static MapLocation maploc1063;
	static MapInfo mapinfo1063;
	static int accessibilityFactor1063;
	static int potentialFactor1063;
	static Direction initialDirection1063;

	static MapLocation maploc1064;
	static MapInfo mapinfo1064;
	static int accessibilityFactor1064;
	static int potentialFactor1064;
	static Direction initialDirection1064;

	static MapLocation maploc1065;
	static MapInfo mapinfo1065;
	static int accessibilityFactor1065;
	static int potentialFactor1065;
	static Direction initialDirection1065;

	static MapLocation maploc1066;
	static MapInfo mapinfo1066;
	static int accessibilityFactor1066;
	static int potentialFactor1066;
	static Direction initialDirection1066;

	static MapLocation maploc1067;
	static MapInfo mapinfo1067;
	static int accessibilityFactor1067;
	static int potentialFactor1067;
	static Direction initialDirection1067;

	static MapLocation maploc1068;
	static MapInfo mapinfo1068;
	static int accessibilityFactor1068;
	static int potentialFactor1068;
	static Direction initialDirection1068;


	/* tries to get exactly to target in one move per turn */
	public static Direction getBestDirectionOneMove(MapLocation target) throws GameActionException {
		maploc1034 = rc.getLocation();
		mapinfo1034 = rc.senseMapInfo(maploc1034);
		accessibilityFactor1034 = 0;
		potentialFactor1034 = 256;
		initialDirection1034 = null;

		maploc1024 = maploc1034.add(Direction.NORTHWEST);
		mapinfo1024 = rc.senseMapInfo(maploc1024);

		accessibilityFactor1024 = 256;
		potentialFactor1024 = 256;
		initialDirection1024 = null;
		maploc1025 = maploc1034.add(Direction.NORTH);
		mapinfo1025 = rc.senseMapInfo(maploc1025);

		accessibilityFactor1025 = 256;
		potentialFactor1025 = 256;
		initialDirection1025 = null;
		maploc1026 = maploc1034.add(Direction.NORTHEAST);
		mapinfo1026 = rc.senseMapInfo(maploc1026);

		accessibilityFactor1026 = 256;
		potentialFactor1026 = 256;
		initialDirection1026 = null;
		maploc1033 = maploc1034.add(Direction.WEST);
		mapinfo1033 = rc.senseMapInfo(maploc1033);

		accessibilityFactor1033 = 256;
		potentialFactor1033 = 256;
		initialDirection1033 = null;
		maploc1035 = maploc1034.add(Direction.EAST);
		mapinfo1035 = rc.senseMapInfo(maploc1035);

		accessibilityFactor1035 = 256;
		potentialFactor1035 = 256;
		initialDirection1035 = null;
		maploc1042 = maploc1034.add(Direction.SOUTHWEST);
		mapinfo1042 = rc.senseMapInfo(maploc1042);

		accessibilityFactor1042 = 256;
		potentialFactor1042 = 256;
		initialDirection1042 = null;
		maploc1043 = maploc1034.add(Direction.SOUTH);
		mapinfo1043 = rc.senseMapInfo(maploc1043);

		accessibilityFactor1043 = 256;
		potentialFactor1043 = 256;
		initialDirection1043 = null;
		maploc1044 = maploc1034.add(Direction.SOUTHEAST);
		mapinfo1044 = rc.senseMapInfo(maploc1044);

		accessibilityFactor1044 = 256;
		potentialFactor1044 = 256;
		initialDirection1044 = null;
		maploc1014 = maploc1024.add(Direction.NORTHWEST);
		mapinfo1014 = rc.senseMapInfo(maploc1014);

		accessibilityFactor1014 = 256;
		potentialFactor1014 = 256;
		initialDirection1014 = null;
		maploc1015 = maploc1024.add(Direction.NORTH);
		mapinfo1015 = rc.senseMapInfo(maploc1015);

		accessibilityFactor1015 = 256;
		potentialFactor1015 = 256;
		initialDirection1015 = null;
		maploc1016 = maploc1024.add(Direction.NORTHEAST);
		mapinfo1016 = rc.senseMapInfo(maploc1016);

		accessibilityFactor1016 = 256;
		potentialFactor1016 = 256;
		initialDirection1016 = null;
		maploc1023 = maploc1024.add(Direction.WEST);
		mapinfo1023 = rc.senseMapInfo(maploc1023);

		accessibilityFactor1023 = 256;
		potentialFactor1023 = 256;
		initialDirection1023 = null;
		maploc1032 = maploc1024.add(Direction.SOUTHWEST);
		mapinfo1032 = rc.senseMapInfo(maploc1032);

		accessibilityFactor1032 = 256;
		potentialFactor1032 = 256;
		initialDirection1032 = null;
		maploc1017 = maploc1025.add(Direction.NORTHEAST);
		mapinfo1017 = rc.senseMapInfo(maploc1017);

		accessibilityFactor1017 = 256;
		potentialFactor1017 = 256;
		initialDirection1017 = null;
		maploc1018 = maploc1026.add(Direction.NORTHEAST);
		mapinfo1018 = rc.senseMapInfo(maploc1018);

		accessibilityFactor1018 = 256;
		potentialFactor1018 = 256;
		initialDirection1018 = null;
		maploc1027 = maploc1026.add(Direction.EAST);
		mapinfo1027 = rc.senseMapInfo(maploc1027);

		accessibilityFactor1027 = 256;
		potentialFactor1027 = 256;
		initialDirection1027 = null;
		maploc1036 = maploc1026.add(Direction.SOUTHEAST);
		mapinfo1036 = rc.senseMapInfo(maploc1036);

		accessibilityFactor1036 = 256;
		potentialFactor1036 = 256;
		initialDirection1036 = null;
		maploc1041 = maploc1033.add(Direction.SOUTHWEST);
		mapinfo1041 = rc.senseMapInfo(maploc1041);

		accessibilityFactor1041 = 256;
		potentialFactor1041 = 256;
		initialDirection1041 = null;
		maploc1045 = maploc1035.add(Direction.SOUTHEAST);
		mapinfo1045 = rc.senseMapInfo(maploc1045);

		accessibilityFactor1045 = 256;
		potentialFactor1045 = 256;
		initialDirection1045 = null;
		maploc1050 = maploc1042.add(Direction.SOUTHWEST);
		mapinfo1050 = rc.senseMapInfo(maploc1050);

		accessibilityFactor1050 = 256;
		potentialFactor1050 = 256;
		initialDirection1050 = null;
		maploc1051 = maploc1042.add(Direction.SOUTH);
		mapinfo1051 = rc.senseMapInfo(maploc1051);

		accessibilityFactor1051 = 256;
		potentialFactor1051 = 256;
		initialDirection1051 = null;
		maploc1052 = maploc1042.add(Direction.SOUTHEAST);
		mapinfo1052 = rc.senseMapInfo(maploc1052);

		accessibilityFactor1052 = 256;
		potentialFactor1052 = 256;
		initialDirection1052 = null;
		maploc1053 = maploc1043.add(Direction.SOUTHEAST);
		mapinfo1053 = rc.senseMapInfo(maploc1053);

		accessibilityFactor1053 = 256;
		potentialFactor1053 = 256;
		initialDirection1053 = null;
		maploc1054 = maploc1044.add(Direction.SOUTHEAST);
		mapinfo1054 = rc.senseMapInfo(maploc1054);

		accessibilityFactor1054 = 256;
		potentialFactor1054 = 256;
		initialDirection1054 = null;
		maploc1005 = maploc1014.add(Direction.NORTHWEST);
		mapinfo1005 = rc.senseMapInfo(maploc1005);

		accessibilityFactor1005 = 256;
		potentialFactor1005 = 256;
		initialDirection1005 = null;
		maploc1006 = maploc1014.add(Direction.NORTH);
		mapinfo1006 = rc.senseMapInfo(maploc1006);

		accessibilityFactor1006 = 256;
		potentialFactor1006 = 256;
		initialDirection1006 = null;
		maploc1007 = maploc1014.add(Direction.NORTHEAST);
		mapinfo1007 = rc.senseMapInfo(maploc1007);

		accessibilityFactor1007 = 256;
		potentialFactor1007 = 256;
		initialDirection1007 = null;
		maploc1013 = maploc1014.add(Direction.WEST);
		mapinfo1013 = rc.senseMapInfo(maploc1013);

		accessibilityFactor1013 = 256;
		potentialFactor1013 = 256;
		initialDirection1013 = null;
		maploc1022 = maploc1014.add(Direction.SOUTHWEST);
		mapinfo1022 = rc.senseMapInfo(maploc1022);

		accessibilityFactor1022 = 256;
		potentialFactor1022 = 256;
		initialDirection1022 = null;
		maploc1008 = maploc1015.add(Direction.NORTHEAST);
		mapinfo1008 = rc.senseMapInfo(maploc1008);

		accessibilityFactor1008 = 256;
		potentialFactor1008 = 256;
		initialDirection1008 = null;
		maploc1009 = maploc1016.add(Direction.NORTHEAST);
		mapinfo1009 = rc.senseMapInfo(maploc1009);

		accessibilityFactor1009 = 256;
		potentialFactor1009 = 256;
		initialDirection1009 = null;
		maploc1031 = maploc1023.add(Direction.SOUTHWEST);
		mapinfo1031 = rc.senseMapInfo(maploc1031);

		accessibilityFactor1031 = 256;
		potentialFactor1031 = 256;
		initialDirection1031 = null;
		maploc1040 = maploc1032.add(Direction.SOUTHWEST);
		mapinfo1040 = rc.senseMapInfo(maploc1040);

		accessibilityFactor1040 = 256;
		potentialFactor1040 = 256;
		initialDirection1040 = null;
		maploc1010 = maploc1017.add(Direction.NORTHEAST);
		mapinfo1010 = rc.senseMapInfo(maploc1010);

		accessibilityFactor1010 = 256;
		potentialFactor1010 = 256;
		initialDirection1010 = null;
		maploc1011 = maploc1018.add(Direction.NORTHEAST);
		mapinfo1011 = rc.senseMapInfo(maploc1011);

		accessibilityFactor1011 = 256;
		potentialFactor1011 = 256;
		initialDirection1011 = null;
		maploc1019 = maploc1018.add(Direction.EAST);
		mapinfo1019 = rc.senseMapInfo(maploc1019);

		accessibilityFactor1019 = 256;
		potentialFactor1019 = 256;
		initialDirection1019 = null;
		maploc1028 = maploc1018.add(Direction.SOUTHEAST);
		mapinfo1028 = rc.senseMapInfo(maploc1028);

		accessibilityFactor1028 = 256;
		potentialFactor1028 = 256;
		initialDirection1028 = null;
		maploc1037 = maploc1027.add(Direction.SOUTHEAST);
		mapinfo1037 = rc.senseMapInfo(maploc1037);

		accessibilityFactor1037 = 256;
		potentialFactor1037 = 256;
		initialDirection1037 = null;
		maploc1046 = maploc1036.add(Direction.SOUTHEAST);
		mapinfo1046 = rc.senseMapInfo(maploc1046);

		accessibilityFactor1046 = 256;
		potentialFactor1046 = 256;
		initialDirection1046 = null;
		maploc1049 = maploc1041.add(Direction.SOUTHWEST);
		mapinfo1049 = rc.senseMapInfo(maploc1049);

		accessibilityFactor1049 = 256;
		potentialFactor1049 = 256;
		initialDirection1049 = null;
		maploc1055 = maploc1045.add(Direction.SOUTHEAST);
		mapinfo1055 = rc.senseMapInfo(maploc1055);

		accessibilityFactor1055 = 256;
		potentialFactor1055 = 256;
		initialDirection1055 = null;
		maploc1057 = maploc1050.add(Direction.SOUTHWEST);
		mapinfo1057 = rc.senseMapInfo(maploc1057);

		accessibilityFactor1057 = 256;
		potentialFactor1057 = 256;
		initialDirection1057 = null;
		maploc1058 = maploc1050.add(Direction.SOUTH);
		mapinfo1058 = rc.senseMapInfo(maploc1058);

		accessibilityFactor1058 = 256;
		potentialFactor1058 = 256;
		initialDirection1058 = null;
		maploc1059 = maploc1050.add(Direction.SOUTHEAST);
		mapinfo1059 = rc.senseMapInfo(maploc1059);

		accessibilityFactor1059 = 256;
		potentialFactor1059 = 256;
		initialDirection1059 = null;
		maploc1060 = maploc1051.add(Direction.SOUTHEAST);
		mapinfo1060 = rc.senseMapInfo(maploc1060);

		accessibilityFactor1060 = 256;
		potentialFactor1060 = 256;
		initialDirection1060 = null;
		maploc1061 = maploc1052.add(Direction.SOUTHEAST);
		mapinfo1061 = rc.senseMapInfo(maploc1061);

		accessibilityFactor1061 = 256;
		potentialFactor1061 = 256;
		initialDirection1061 = null;
		maploc1062 = maploc1053.add(Direction.SOUTHEAST);
		mapinfo1062 = rc.senseMapInfo(maploc1062);

		accessibilityFactor1062 = 256;
		potentialFactor1062 = 256;
		initialDirection1062 = null;
		maploc1063 = maploc1054.add(Direction.SOUTHEAST);
		mapinfo1063 = rc.senseMapInfo(maploc1063);

		accessibilityFactor1063 = 256;
		potentialFactor1063 = 256;
		initialDirection1063 = null;
		maploc1000 = maploc1005.add(Direction.NORTHEAST);
		mapinfo1000 = rc.senseMapInfo(maploc1000);

		accessibilityFactor1000 = 256;
		potentialFactor1000 = 256;
		initialDirection1000 = null;
		maploc1012 = maploc1005.add(Direction.SOUTHWEST);
		mapinfo1012 = rc.senseMapInfo(maploc1012);

		accessibilityFactor1012 = 256;
		potentialFactor1012 = 256;
		initialDirection1012 = null;
		maploc1001 = maploc1006.add(Direction.NORTHEAST);
		mapinfo1001 = rc.senseMapInfo(maploc1001);

		accessibilityFactor1001 = 256;
		potentialFactor1001 = 256;
		initialDirection1001 = null;
		maploc1002 = maploc1007.add(Direction.NORTHEAST);
		mapinfo1002 = rc.senseMapInfo(maploc1002);

		accessibilityFactor1002 = 256;
		potentialFactor1002 = 256;
		initialDirection1002 = null;
		maploc1021 = maploc1013.add(Direction.SOUTHWEST);
		mapinfo1021 = rc.senseMapInfo(maploc1021);

		accessibilityFactor1021 = 256;
		potentialFactor1021 = 256;
		initialDirection1021 = null;
		maploc1030 = maploc1022.add(Direction.SOUTHWEST);
		mapinfo1030 = rc.senseMapInfo(maploc1030);

		accessibilityFactor1030 = 256;
		potentialFactor1030 = 256;
		initialDirection1030 = null;
		maploc1003 = maploc1008.add(Direction.NORTHEAST);
		mapinfo1003 = rc.senseMapInfo(maploc1003);

		accessibilityFactor1003 = 256;
		potentialFactor1003 = 256;
		initialDirection1003 = null;
		maploc1004 = maploc1009.add(Direction.NORTHEAST);
		mapinfo1004 = rc.senseMapInfo(maploc1004);

		accessibilityFactor1004 = 256;
		potentialFactor1004 = 256;
		initialDirection1004 = null;
		maploc1039 = maploc1031.add(Direction.SOUTHWEST);
		mapinfo1039 = rc.senseMapInfo(maploc1039);

		accessibilityFactor1039 = 256;
		potentialFactor1039 = 256;
		initialDirection1039 = null;
		maploc1048 = maploc1040.add(Direction.SOUTHWEST);
		mapinfo1048 = rc.senseMapInfo(maploc1048);

		accessibilityFactor1048 = 256;
		potentialFactor1048 = 256;
		initialDirection1048 = null;
		maploc1020 = maploc1011.add(Direction.SOUTHEAST);
		mapinfo1020 = rc.senseMapInfo(maploc1020);

		accessibilityFactor1020 = 256;
		potentialFactor1020 = 256;
		initialDirection1020 = null;
		maploc1029 = maploc1019.add(Direction.SOUTHEAST);
		mapinfo1029 = rc.senseMapInfo(maploc1029);

		accessibilityFactor1029 = 256;
		potentialFactor1029 = 256;
		initialDirection1029 = null;
		maploc1038 = maploc1028.add(Direction.SOUTHEAST);
		mapinfo1038 = rc.senseMapInfo(maploc1038);

		accessibilityFactor1038 = 256;
		potentialFactor1038 = 256;
		initialDirection1038 = null;
		maploc1047 = maploc1037.add(Direction.SOUTHEAST);
		mapinfo1047 = rc.senseMapInfo(maploc1047);

		accessibilityFactor1047 = 256;
		potentialFactor1047 = 256;
		initialDirection1047 = null;
		maploc1056 = maploc1046.add(Direction.SOUTHEAST);
		mapinfo1056 = rc.senseMapInfo(maploc1056);

		accessibilityFactor1056 = 256;
		potentialFactor1056 = 256;
		initialDirection1056 = null;
		maploc1064 = maploc1057.add(Direction.SOUTHEAST);
		mapinfo1064 = rc.senseMapInfo(maploc1064);

		accessibilityFactor1064 = 256;
		potentialFactor1064 = 256;
		initialDirection1064 = null;
		maploc1065 = maploc1058.add(Direction.SOUTHEAST);
		mapinfo1065 = rc.senseMapInfo(maploc1065);

		accessibilityFactor1065 = 256;
		potentialFactor1065 = 256;
		initialDirection1065 = null;
		maploc1066 = maploc1059.add(Direction.SOUTHEAST);
		mapinfo1066 = rc.senseMapInfo(maploc1066);

		accessibilityFactor1066 = 256;
		potentialFactor1066 = 256;
		initialDirection1066 = null;
		maploc1067 = maploc1060.add(Direction.SOUTHEAST);
		mapinfo1067 = rc.senseMapInfo(maploc1067);

		accessibilityFactor1067 = 256;
		potentialFactor1067 = 256;
		initialDirection1067 = null;
		maploc1068 = maploc1061.add(Direction.SOUTHEAST);
		mapinfo1068 = rc.senseMapInfo(maploc1068);

		accessibilityFactor1068 = 256;
		potentialFactor1068 = 256;
		initialDirection1068 = null;
		if (accessibilityFactor1024 > accessibilityFactor1034 + 1) {
			accessibilityFactor1024 = accessibilityFactor1034 + 1;
			initialDirection1024 = Direction.NORTHWEST;
		}
		if (accessibilityFactor1025 > accessibilityFactor1034 + 1) {
			accessibilityFactor1025 = accessibilityFactor1034 + 1;
			initialDirection1025 = Direction.NORTH;
		}
		if (accessibilityFactor1026 > accessibilityFactor1034 + 1) {
			accessibilityFactor1026 = accessibilityFactor1034 + 1;
			initialDirection1026 = Direction.NORTHEAST;
		}
		if (accessibilityFactor1033 > accessibilityFactor1034 + 1) {
			accessibilityFactor1033 = accessibilityFactor1034 + 1;
			initialDirection1033 = Direction.WEST;
		}
		if (accessibilityFactor1035 > accessibilityFactor1034 + 1) {
			accessibilityFactor1035 = accessibilityFactor1034 + 1;
			initialDirection1035 = Direction.EAST;
		}
		if (accessibilityFactor1042 > accessibilityFactor1034 + 1) {
			accessibilityFactor1042 = accessibilityFactor1034 + 1;
			initialDirection1042 = Direction.SOUTHWEST;
		}
		if (accessibilityFactor1043 > accessibilityFactor1034 + 1) {
			accessibilityFactor1043 = accessibilityFactor1034 + 1;
			initialDirection1043 = Direction.SOUTH;
		}
		if (accessibilityFactor1044 > accessibilityFactor1034 + 1) {
			accessibilityFactor1044 = accessibilityFactor1034 + 1;
			initialDirection1044 = Direction.SOUTHEAST;
		}

		if (mapinfo1025.isPassable() && rc.senseRobotAtLocation(maploc1025) == null) {
			if (accessibilityFactor1015 > accessibilityFactor1025 + 1) {
				accessibilityFactor1015 = accessibilityFactor1025 + 1;
				initialDirection1015 = initialDirection1025;
			}
			if (accessibilityFactor1016 > accessibilityFactor1025 + 1) {
				accessibilityFactor1016 = accessibilityFactor1025 + 1;
				initialDirection1016 = initialDirection1025;
			}
			if (accessibilityFactor1017 > accessibilityFactor1025 + 1) {
				accessibilityFactor1017 = accessibilityFactor1025 + 1;
				initialDirection1017 = initialDirection1025;
			}
			if (accessibilityFactor1024 > accessibilityFactor1025 + 1) {
				accessibilityFactor1024 = accessibilityFactor1025 + 1;
				initialDirection1024 = initialDirection1025;
			}
			if (accessibilityFactor1026 > accessibilityFactor1025 + 1) {
				accessibilityFactor1026 = accessibilityFactor1025 + 1;
				initialDirection1026 = initialDirection1025;
			}
			if (accessibilityFactor1033 > accessibilityFactor1025 + 1) {
				accessibilityFactor1033 = accessibilityFactor1025 + 1;
				initialDirection1033 = initialDirection1025;
			}
			if (accessibilityFactor1035 > accessibilityFactor1025 + 1) {
				accessibilityFactor1035 = accessibilityFactor1025 + 1;
				initialDirection1035 = initialDirection1025;
			}

			}
		if (mapinfo1033.isPassable() && rc.senseRobotAtLocation(maploc1033) == null) {
			if (accessibilityFactor1023 > accessibilityFactor1033 + 1) {
				accessibilityFactor1023 = accessibilityFactor1033 + 1;
				initialDirection1023 = initialDirection1033;
			}
			if (accessibilityFactor1024 > accessibilityFactor1033 + 1) {
				accessibilityFactor1024 = accessibilityFactor1033 + 1;
				initialDirection1024 = initialDirection1033;
			}
			if (accessibilityFactor1032 > accessibilityFactor1033 + 1) {
				accessibilityFactor1032 = accessibilityFactor1033 + 1;
				initialDirection1032 = initialDirection1033;
			}
			if (accessibilityFactor1041 > accessibilityFactor1033 + 1) {
				accessibilityFactor1041 = accessibilityFactor1033 + 1;
				initialDirection1041 = initialDirection1033;
			}
			if (accessibilityFactor1042 > accessibilityFactor1033 + 1) {
				accessibilityFactor1042 = accessibilityFactor1033 + 1;
				initialDirection1042 = initialDirection1033;
			}
			if (accessibilityFactor1043 > accessibilityFactor1033 + 1) {
				accessibilityFactor1043 = accessibilityFactor1033 + 1;
				initialDirection1043 = initialDirection1033;
			}

			}
		if (mapinfo1035.isPassable() && rc.senseRobotAtLocation(maploc1035) == null) {
			if (accessibilityFactor1026 > accessibilityFactor1035 + 1) {
				accessibilityFactor1026 = accessibilityFactor1035 + 1;
				initialDirection1026 = initialDirection1035;
			}
			if (accessibilityFactor1027 > accessibilityFactor1035 + 1) {
				accessibilityFactor1027 = accessibilityFactor1035 + 1;
				initialDirection1027 = initialDirection1035;
			}
			if (accessibilityFactor1036 > accessibilityFactor1035 + 1) {
				accessibilityFactor1036 = accessibilityFactor1035 + 1;
				initialDirection1036 = initialDirection1035;
			}
			if (accessibilityFactor1043 > accessibilityFactor1035 + 1) {
				accessibilityFactor1043 = accessibilityFactor1035 + 1;
				initialDirection1043 = initialDirection1035;
			}
			if (accessibilityFactor1044 > accessibilityFactor1035 + 1) {
				accessibilityFactor1044 = accessibilityFactor1035 + 1;
				initialDirection1044 = initialDirection1035;
			}
			if (accessibilityFactor1045 > accessibilityFactor1035 + 1) {
				accessibilityFactor1045 = accessibilityFactor1035 + 1;
				initialDirection1045 = initialDirection1035;
			}

			}
		if (mapinfo1043.isPassable() && rc.senseRobotAtLocation(maploc1043) == null) {
			if (accessibilityFactor1042 > accessibilityFactor1043 + 1) {
				accessibilityFactor1042 = accessibilityFactor1043 + 1;
				initialDirection1042 = initialDirection1043;
			}
			if (accessibilityFactor1044 > accessibilityFactor1043 + 1) {
				accessibilityFactor1044 = accessibilityFactor1043 + 1;
				initialDirection1044 = initialDirection1043;
			}
			if (accessibilityFactor1051 > accessibilityFactor1043 + 1) {
				accessibilityFactor1051 = accessibilityFactor1043 + 1;
				initialDirection1051 = initialDirection1043;
			}
			if (accessibilityFactor1052 > accessibilityFactor1043 + 1) {
				accessibilityFactor1052 = accessibilityFactor1043 + 1;
				initialDirection1052 = initialDirection1043;
			}
			if (accessibilityFactor1053 > accessibilityFactor1043 + 1) {
				accessibilityFactor1053 = accessibilityFactor1043 + 1;
				initialDirection1053 = initialDirection1043;
			}

			}
		if (mapinfo1024.isPassable() && rc.senseRobotAtLocation(maploc1024) == null) {
			if (accessibilityFactor1014 > accessibilityFactor1024 + 1) {
				accessibilityFactor1014 = accessibilityFactor1024 + 1;
				initialDirection1014 = initialDirection1024;
			}
			if (accessibilityFactor1015 > accessibilityFactor1024 + 1) {
				accessibilityFactor1015 = accessibilityFactor1024 + 1;
				initialDirection1015 = initialDirection1024;
			}
			if (accessibilityFactor1016 > accessibilityFactor1024 + 1) {
				accessibilityFactor1016 = accessibilityFactor1024 + 1;
				initialDirection1016 = initialDirection1024;
			}
			if (accessibilityFactor1023 > accessibilityFactor1024 + 1) {
				accessibilityFactor1023 = accessibilityFactor1024 + 1;
				initialDirection1023 = initialDirection1024;
			}
			if (accessibilityFactor1032 > accessibilityFactor1024 + 1) {
				accessibilityFactor1032 = accessibilityFactor1024 + 1;
				initialDirection1032 = initialDirection1024;
			}

			}
		if (mapinfo1026.isPassable() && rc.senseRobotAtLocation(maploc1026) == null) {
			if (accessibilityFactor1016 > accessibilityFactor1026 + 1) {
				accessibilityFactor1016 = accessibilityFactor1026 + 1;
				initialDirection1016 = initialDirection1026;
			}
			if (accessibilityFactor1017 > accessibilityFactor1026 + 1) {
				accessibilityFactor1017 = accessibilityFactor1026 + 1;
				initialDirection1017 = initialDirection1026;
			}
			if (accessibilityFactor1018 > accessibilityFactor1026 + 1) {
				accessibilityFactor1018 = accessibilityFactor1026 + 1;
				initialDirection1018 = initialDirection1026;
			}
			if (accessibilityFactor1027 > accessibilityFactor1026 + 1) {
				accessibilityFactor1027 = accessibilityFactor1026 + 1;
				initialDirection1027 = initialDirection1026;
			}
			if (accessibilityFactor1036 > accessibilityFactor1026 + 1) {
				accessibilityFactor1036 = accessibilityFactor1026 + 1;
				initialDirection1036 = initialDirection1026;
			}

			}
		if (mapinfo1042.isPassable() && rc.senseRobotAtLocation(maploc1042) == null) {
			if (accessibilityFactor1032 > accessibilityFactor1042 + 1) {
				accessibilityFactor1032 = accessibilityFactor1042 + 1;
				initialDirection1032 = initialDirection1042;
			}
			if (accessibilityFactor1041 > accessibilityFactor1042 + 1) {
				accessibilityFactor1041 = accessibilityFactor1042 + 1;
				initialDirection1041 = initialDirection1042;
			}
			if (accessibilityFactor1050 > accessibilityFactor1042 + 1) {
				accessibilityFactor1050 = accessibilityFactor1042 + 1;
				initialDirection1050 = initialDirection1042;
			}
			if (accessibilityFactor1051 > accessibilityFactor1042 + 1) {
				accessibilityFactor1051 = accessibilityFactor1042 + 1;
				initialDirection1051 = initialDirection1042;
			}
			if (accessibilityFactor1052 > accessibilityFactor1042 + 1) {
				accessibilityFactor1052 = accessibilityFactor1042 + 1;
				initialDirection1052 = initialDirection1042;
			}

			}
		if (mapinfo1044.isPassable() && rc.senseRobotAtLocation(maploc1044) == null) {
			if (accessibilityFactor1036 > accessibilityFactor1044 + 1) {
				accessibilityFactor1036 = accessibilityFactor1044 + 1;
				initialDirection1036 = initialDirection1044;
			}
			if (accessibilityFactor1045 > accessibilityFactor1044 + 1) {
				accessibilityFactor1045 = accessibilityFactor1044 + 1;
				initialDirection1045 = initialDirection1044;
			}
			if (accessibilityFactor1052 > accessibilityFactor1044 + 1) {
				accessibilityFactor1052 = accessibilityFactor1044 + 1;
				initialDirection1052 = initialDirection1044;
			}
			if (accessibilityFactor1053 > accessibilityFactor1044 + 1) {
				accessibilityFactor1053 = accessibilityFactor1044 + 1;
				initialDirection1053 = initialDirection1044;
			}
			if (accessibilityFactor1054 > accessibilityFactor1044 + 1) {
				accessibilityFactor1054 = accessibilityFactor1044 + 1;
				initialDirection1054 = initialDirection1044;
			}

			}
		if (mapinfo1016.isPassable() && rc.senseRobotAtLocation(maploc1016) == null) {
			if (accessibilityFactor1007 > accessibilityFactor1016 + 1) {
				accessibilityFactor1007 = accessibilityFactor1016 + 1;
				initialDirection1007 = initialDirection1016;
			}
			if (accessibilityFactor1008 > accessibilityFactor1016 + 1) {
				accessibilityFactor1008 = accessibilityFactor1016 + 1;
				initialDirection1008 = initialDirection1016;
			}
			if (accessibilityFactor1009 > accessibilityFactor1016 + 1) {
				accessibilityFactor1009 = accessibilityFactor1016 + 1;
				initialDirection1009 = initialDirection1016;
			}
			if (accessibilityFactor1015 > accessibilityFactor1016 + 1) {
				accessibilityFactor1015 = accessibilityFactor1016 + 1;
				initialDirection1015 = initialDirection1016;
			}
			if (accessibilityFactor1017 > accessibilityFactor1016 + 1) {
				accessibilityFactor1017 = accessibilityFactor1016 + 1;
				initialDirection1017 = initialDirection1016;
			}

			}
		if (mapinfo1032.isPassable() && rc.senseRobotAtLocation(maploc1032) == null) {
			if (accessibilityFactor1022 > accessibilityFactor1032 + 1) {
				accessibilityFactor1022 = accessibilityFactor1032 + 1;
				initialDirection1022 = initialDirection1032;
			}
			if (accessibilityFactor1023 > accessibilityFactor1032 + 1) {
				accessibilityFactor1023 = accessibilityFactor1032 + 1;
				initialDirection1023 = initialDirection1032;
			}
			if (accessibilityFactor1031 > accessibilityFactor1032 + 1) {
				accessibilityFactor1031 = accessibilityFactor1032 + 1;
				initialDirection1031 = initialDirection1032;
			}
			if (accessibilityFactor1040 > accessibilityFactor1032 + 1) {
				accessibilityFactor1040 = accessibilityFactor1032 + 1;
				initialDirection1040 = initialDirection1032;
			}
			if (accessibilityFactor1041 > accessibilityFactor1032 + 1) {
				accessibilityFactor1041 = accessibilityFactor1032 + 1;
				initialDirection1041 = initialDirection1032;
			}

			}
		if (mapinfo1036.isPassable() && rc.senseRobotAtLocation(maploc1036) == null) {
			if (accessibilityFactor1027 > accessibilityFactor1036 + 1) {
				accessibilityFactor1027 = accessibilityFactor1036 + 1;
				initialDirection1027 = initialDirection1036;
			}
			if (accessibilityFactor1028 > accessibilityFactor1036 + 1) {
				accessibilityFactor1028 = accessibilityFactor1036 + 1;
				initialDirection1028 = initialDirection1036;
			}
			if (accessibilityFactor1037 > accessibilityFactor1036 + 1) {
				accessibilityFactor1037 = accessibilityFactor1036 + 1;
				initialDirection1037 = initialDirection1036;
			}
			if (accessibilityFactor1045 > accessibilityFactor1036 + 1) {
				accessibilityFactor1045 = accessibilityFactor1036 + 1;
				initialDirection1045 = initialDirection1036;
			}
			if (accessibilityFactor1046 > accessibilityFactor1036 + 1) {
				accessibilityFactor1046 = accessibilityFactor1036 + 1;
				initialDirection1046 = initialDirection1036;
			}

			}
		if (mapinfo1052.isPassable() && rc.senseRobotAtLocation(maploc1052) == null) {
			if (accessibilityFactor1051 > accessibilityFactor1052 + 1) {
				accessibilityFactor1051 = accessibilityFactor1052 + 1;
				initialDirection1051 = initialDirection1052;
			}
			if (accessibilityFactor1053 > accessibilityFactor1052 + 1) {
				accessibilityFactor1053 = accessibilityFactor1052 + 1;
				initialDirection1053 = initialDirection1052;
			}
			if (accessibilityFactor1059 > accessibilityFactor1052 + 1) {
				accessibilityFactor1059 = accessibilityFactor1052 + 1;
				initialDirection1059 = initialDirection1052;
			}
			if (accessibilityFactor1060 > accessibilityFactor1052 + 1) {
				accessibilityFactor1060 = accessibilityFactor1052 + 1;
				initialDirection1060 = initialDirection1052;
			}
			if (accessibilityFactor1061 > accessibilityFactor1052 + 1) {
				accessibilityFactor1061 = accessibilityFactor1052 + 1;
				initialDirection1061 = initialDirection1052;
			}

			}
		if (mapinfo1015.isPassable() && rc.senseRobotAtLocation(maploc1015) == null) {
			if (accessibilityFactor1006 > accessibilityFactor1015 + 1) {
				accessibilityFactor1006 = accessibilityFactor1015 + 1;
				initialDirection1006 = initialDirection1015;
			}
			if (accessibilityFactor1007 > accessibilityFactor1015 + 1) {
				accessibilityFactor1007 = accessibilityFactor1015 + 1;
				initialDirection1007 = initialDirection1015;
			}
			if (accessibilityFactor1008 > accessibilityFactor1015 + 1) {
				accessibilityFactor1008 = accessibilityFactor1015 + 1;
				initialDirection1008 = initialDirection1015;
			}
			if (accessibilityFactor1014 > accessibilityFactor1015 + 1) {
				accessibilityFactor1014 = accessibilityFactor1015 + 1;
				initialDirection1014 = initialDirection1015;
			}
			if (accessibilityFactor1023 > accessibilityFactor1015 + 1) {
				accessibilityFactor1023 = accessibilityFactor1015 + 1;
				initialDirection1023 = initialDirection1015;
			}

			}
		if (mapinfo1017.isPassable() && rc.senseRobotAtLocation(maploc1017) == null) {
			if (accessibilityFactor1008 > accessibilityFactor1017 + 1) {
				accessibilityFactor1008 = accessibilityFactor1017 + 1;
				initialDirection1008 = initialDirection1017;
			}
			if (accessibilityFactor1009 > accessibilityFactor1017 + 1) {
				accessibilityFactor1009 = accessibilityFactor1017 + 1;
				initialDirection1009 = initialDirection1017;
			}
			if (accessibilityFactor1010 > accessibilityFactor1017 + 1) {
				accessibilityFactor1010 = accessibilityFactor1017 + 1;
				initialDirection1010 = initialDirection1017;
			}
			if (accessibilityFactor1018 > accessibilityFactor1017 + 1) {
				accessibilityFactor1018 = accessibilityFactor1017 + 1;
				initialDirection1018 = initialDirection1017;
			}
			if (accessibilityFactor1027 > accessibilityFactor1017 + 1) {
				accessibilityFactor1027 = accessibilityFactor1017 + 1;
				initialDirection1027 = initialDirection1017;
			}

			}
		if (mapinfo1023.isPassable() && rc.senseRobotAtLocation(maploc1023) == null) {
			if (accessibilityFactor1013 > accessibilityFactor1023 + 1) {
				accessibilityFactor1013 = accessibilityFactor1023 + 1;
				initialDirection1013 = initialDirection1023;
			}
			if (accessibilityFactor1014 > accessibilityFactor1023 + 1) {
				accessibilityFactor1014 = accessibilityFactor1023 + 1;
				initialDirection1014 = initialDirection1023;
			}
			if (accessibilityFactor1022 > accessibilityFactor1023 + 1) {
				accessibilityFactor1022 = accessibilityFactor1023 + 1;
				initialDirection1022 = initialDirection1023;
			}
			if (accessibilityFactor1031 > accessibilityFactor1023 + 1) {
				accessibilityFactor1031 = accessibilityFactor1023 + 1;
				initialDirection1031 = initialDirection1023;
			}

			}
		if (mapinfo1027.isPassable() && rc.senseRobotAtLocation(maploc1027) == null) {
			if (accessibilityFactor1018 > accessibilityFactor1027 + 1) {
				accessibilityFactor1018 = accessibilityFactor1027 + 1;
				initialDirection1018 = initialDirection1027;
			}
			if (accessibilityFactor1019 > accessibilityFactor1027 + 1) {
				accessibilityFactor1019 = accessibilityFactor1027 + 1;
				initialDirection1019 = initialDirection1027;
			}
			if (accessibilityFactor1028 > accessibilityFactor1027 + 1) {
				accessibilityFactor1028 = accessibilityFactor1027 + 1;
				initialDirection1028 = initialDirection1027;
			}
			if (accessibilityFactor1037 > accessibilityFactor1027 + 1) {
				accessibilityFactor1037 = accessibilityFactor1027 + 1;
				initialDirection1037 = initialDirection1027;
			}

			}
		if (mapinfo1041.isPassable() && rc.senseRobotAtLocation(maploc1041) == null) {
			if (accessibilityFactor1031 > accessibilityFactor1041 + 1) {
				accessibilityFactor1031 = accessibilityFactor1041 + 1;
				initialDirection1031 = initialDirection1041;
			}
			if (accessibilityFactor1040 > accessibilityFactor1041 + 1) {
				accessibilityFactor1040 = accessibilityFactor1041 + 1;
				initialDirection1040 = initialDirection1041;
			}
			if (accessibilityFactor1049 > accessibilityFactor1041 + 1) {
				accessibilityFactor1049 = accessibilityFactor1041 + 1;
				initialDirection1049 = initialDirection1041;
			}
			if (accessibilityFactor1050 > accessibilityFactor1041 + 1) {
				accessibilityFactor1050 = accessibilityFactor1041 + 1;
				initialDirection1050 = initialDirection1041;
			}
			if (accessibilityFactor1051 > accessibilityFactor1041 + 1) {
				accessibilityFactor1051 = accessibilityFactor1041 + 1;
				initialDirection1051 = initialDirection1041;
			}

			}
		if (mapinfo1045.isPassable() && rc.senseRobotAtLocation(maploc1045) == null) {
			if (accessibilityFactor1037 > accessibilityFactor1045 + 1) {
				accessibilityFactor1037 = accessibilityFactor1045 + 1;
				initialDirection1037 = initialDirection1045;
			}
			if (accessibilityFactor1046 > accessibilityFactor1045 + 1) {
				accessibilityFactor1046 = accessibilityFactor1045 + 1;
				initialDirection1046 = initialDirection1045;
			}
			if (accessibilityFactor1053 > accessibilityFactor1045 + 1) {
				accessibilityFactor1053 = accessibilityFactor1045 + 1;
				initialDirection1053 = initialDirection1045;
			}
			if (accessibilityFactor1054 > accessibilityFactor1045 + 1) {
				accessibilityFactor1054 = accessibilityFactor1045 + 1;
				initialDirection1054 = initialDirection1045;
			}
			if (accessibilityFactor1055 > accessibilityFactor1045 + 1) {
				accessibilityFactor1055 = accessibilityFactor1045 + 1;
				initialDirection1055 = initialDirection1045;
			}

			}
		if (mapinfo1051.isPassable() && rc.senseRobotAtLocation(maploc1051) == null) {
			if (accessibilityFactor1050 > accessibilityFactor1051 + 1) {
				accessibilityFactor1050 = accessibilityFactor1051 + 1;
				initialDirection1050 = initialDirection1051;
			}
			if (accessibilityFactor1058 > accessibilityFactor1051 + 1) {
				accessibilityFactor1058 = accessibilityFactor1051 + 1;
				initialDirection1058 = initialDirection1051;
			}
			if (accessibilityFactor1059 > accessibilityFactor1051 + 1) {
				accessibilityFactor1059 = accessibilityFactor1051 + 1;
				initialDirection1059 = initialDirection1051;
			}
			if (accessibilityFactor1060 > accessibilityFactor1051 + 1) {
				accessibilityFactor1060 = accessibilityFactor1051 + 1;
				initialDirection1060 = initialDirection1051;
			}

			}
		if (mapinfo1053.isPassable() && rc.senseRobotAtLocation(maploc1053) == null) {
			if (accessibilityFactor1054 > accessibilityFactor1053 + 1) {
				accessibilityFactor1054 = accessibilityFactor1053 + 1;
				initialDirection1054 = initialDirection1053;
			}
			if (accessibilityFactor1060 > accessibilityFactor1053 + 1) {
				accessibilityFactor1060 = accessibilityFactor1053 + 1;
				initialDirection1060 = initialDirection1053;
			}
			if (accessibilityFactor1061 > accessibilityFactor1053 + 1) {
				accessibilityFactor1061 = accessibilityFactor1053 + 1;
				initialDirection1061 = initialDirection1053;
			}
			if (accessibilityFactor1062 > accessibilityFactor1053 + 1) {
				accessibilityFactor1062 = accessibilityFactor1053 + 1;
				initialDirection1062 = initialDirection1053;
			}

			}
		if (mapinfo1014.isPassable() && rc.senseRobotAtLocation(maploc1014) == null) {
			if (accessibilityFactor1005 > accessibilityFactor1014 + 1) {
				accessibilityFactor1005 = accessibilityFactor1014 + 1;
				initialDirection1005 = initialDirection1014;
			}
			if (accessibilityFactor1006 > accessibilityFactor1014 + 1) {
				accessibilityFactor1006 = accessibilityFactor1014 + 1;
				initialDirection1006 = initialDirection1014;
			}
			if (accessibilityFactor1007 > accessibilityFactor1014 + 1) {
				accessibilityFactor1007 = accessibilityFactor1014 + 1;
				initialDirection1007 = initialDirection1014;
			}
			if (accessibilityFactor1013 > accessibilityFactor1014 + 1) {
				accessibilityFactor1013 = accessibilityFactor1014 + 1;
				initialDirection1013 = initialDirection1014;
			}
			if (accessibilityFactor1022 > accessibilityFactor1014 + 1) {
				accessibilityFactor1022 = accessibilityFactor1014 + 1;
				initialDirection1022 = initialDirection1014;
			}

			}
		if (mapinfo1018.isPassable() && rc.senseRobotAtLocation(maploc1018) == null) {
			if (accessibilityFactor1009 > accessibilityFactor1018 + 1) {
				accessibilityFactor1009 = accessibilityFactor1018 + 1;
				initialDirection1009 = initialDirection1018;
			}
			if (accessibilityFactor1010 > accessibilityFactor1018 + 1) {
				accessibilityFactor1010 = accessibilityFactor1018 + 1;
				initialDirection1010 = initialDirection1018;
			}
			if (accessibilityFactor1011 > accessibilityFactor1018 + 1) {
				accessibilityFactor1011 = accessibilityFactor1018 + 1;
				initialDirection1011 = initialDirection1018;
			}
			if (accessibilityFactor1019 > accessibilityFactor1018 + 1) {
				accessibilityFactor1019 = accessibilityFactor1018 + 1;
				initialDirection1019 = initialDirection1018;
			}
			if (accessibilityFactor1028 > accessibilityFactor1018 + 1) {
				accessibilityFactor1028 = accessibilityFactor1018 + 1;
				initialDirection1028 = initialDirection1018;
			}

			}
		if (mapinfo1050.isPassable() && rc.senseRobotAtLocation(maploc1050) == null) {
			if (accessibilityFactor1040 > accessibilityFactor1050 + 1) {
				accessibilityFactor1040 = accessibilityFactor1050 + 1;
				initialDirection1040 = initialDirection1050;
			}
			if (accessibilityFactor1049 > accessibilityFactor1050 + 1) {
				accessibilityFactor1049 = accessibilityFactor1050 + 1;
				initialDirection1049 = initialDirection1050;
			}
			if (accessibilityFactor1057 > accessibilityFactor1050 + 1) {
				accessibilityFactor1057 = accessibilityFactor1050 + 1;
				initialDirection1057 = initialDirection1050;
			}
			if (accessibilityFactor1058 > accessibilityFactor1050 + 1) {
				accessibilityFactor1058 = accessibilityFactor1050 + 1;
				initialDirection1058 = initialDirection1050;
			}
			if (accessibilityFactor1059 > accessibilityFactor1050 + 1) {
				accessibilityFactor1059 = accessibilityFactor1050 + 1;
				initialDirection1059 = initialDirection1050;
			}

			}
		if (mapinfo1054.isPassable() && rc.senseRobotAtLocation(maploc1054) == null) {
			if (accessibilityFactor1046 > accessibilityFactor1054 + 1) {
				accessibilityFactor1046 = accessibilityFactor1054 + 1;
				initialDirection1046 = initialDirection1054;
			}
			if (accessibilityFactor1055 > accessibilityFactor1054 + 1) {
				accessibilityFactor1055 = accessibilityFactor1054 + 1;
				initialDirection1055 = initialDirection1054;
			}
			if (accessibilityFactor1061 > accessibilityFactor1054 + 1) {
				accessibilityFactor1061 = accessibilityFactor1054 + 1;
				initialDirection1061 = initialDirection1054;
			}
			if (accessibilityFactor1062 > accessibilityFactor1054 + 1) {
				accessibilityFactor1062 = accessibilityFactor1054 + 1;
				initialDirection1062 = initialDirection1054;
			}
			if (accessibilityFactor1063 > accessibilityFactor1054 + 1) {
				accessibilityFactor1063 = accessibilityFactor1054 + 1;
				initialDirection1063 = initialDirection1054;
			}

			}
		if (mapinfo1008.isPassable() && rc.senseRobotAtLocation(maploc1008) == null) {
			if (accessibilityFactor1001 > accessibilityFactor1008 + 1) {
				accessibilityFactor1001 = accessibilityFactor1008 + 1;
				initialDirection1001 = initialDirection1008;
			}
			if (accessibilityFactor1002 > accessibilityFactor1008 + 1) {
				accessibilityFactor1002 = accessibilityFactor1008 + 1;
				initialDirection1002 = initialDirection1008;
			}
			if (accessibilityFactor1003 > accessibilityFactor1008 + 1) {
				accessibilityFactor1003 = accessibilityFactor1008 + 1;
				initialDirection1003 = initialDirection1008;
			}
			if (accessibilityFactor1007 > accessibilityFactor1008 + 1) {
				accessibilityFactor1007 = accessibilityFactor1008 + 1;
				initialDirection1007 = initialDirection1008;
			}
			if (accessibilityFactor1009 > accessibilityFactor1008 + 1) {
				accessibilityFactor1009 = accessibilityFactor1008 + 1;
				initialDirection1009 = initialDirection1008;
			}

			}
		if (mapinfo1031.isPassable() && rc.senseRobotAtLocation(maploc1031) == null) {
			if (accessibilityFactor1021 > accessibilityFactor1031 + 1) {
				accessibilityFactor1021 = accessibilityFactor1031 + 1;
				initialDirection1021 = initialDirection1031;
			}
			if (accessibilityFactor1022 > accessibilityFactor1031 + 1) {
				accessibilityFactor1022 = accessibilityFactor1031 + 1;
				initialDirection1022 = initialDirection1031;
			}
			if (accessibilityFactor1030 > accessibilityFactor1031 + 1) {
				accessibilityFactor1030 = accessibilityFactor1031 + 1;
				initialDirection1030 = initialDirection1031;
			}
			if (accessibilityFactor1039 > accessibilityFactor1031 + 1) {
				accessibilityFactor1039 = accessibilityFactor1031 + 1;
				initialDirection1039 = initialDirection1031;
			}
			if (accessibilityFactor1040 > accessibilityFactor1031 + 1) {
				accessibilityFactor1040 = accessibilityFactor1031 + 1;
				initialDirection1040 = initialDirection1031;
			}

			}
		if (mapinfo1037.isPassable() && rc.senseRobotAtLocation(maploc1037) == null) {
			if (accessibilityFactor1028 > accessibilityFactor1037 + 1) {
				accessibilityFactor1028 = accessibilityFactor1037 + 1;
				initialDirection1028 = initialDirection1037;
			}
			if (accessibilityFactor1029 > accessibilityFactor1037 + 1) {
				accessibilityFactor1029 = accessibilityFactor1037 + 1;
				initialDirection1029 = initialDirection1037;
			}
			if (accessibilityFactor1038 > accessibilityFactor1037 + 1) {
				accessibilityFactor1038 = accessibilityFactor1037 + 1;
				initialDirection1038 = initialDirection1037;
			}
			if (accessibilityFactor1046 > accessibilityFactor1037 + 1) {
				accessibilityFactor1046 = accessibilityFactor1037 + 1;
				initialDirection1046 = initialDirection1037;
			}
			if (accessibilityFactor1047 > accessibilityFactor1037 + 1) {
				accessibilityFactor1047 = accessibilityFactor1037 + 1;
				initialDirection1047 = initialDirection1037;
			}

			}
		if (mapinfo1060.isPassable() && rc.senseRobotAtLocation(maploc1060) == null) {
			if (accessibilityFactor1059 > accessibilityFactor1060 + 1) {
				accessibilityFactor1059 = accessibilityFactor1060 + 1;
				initialDirection1059 = initialDirection1060;
			}
			if (accessibilityFactor1061 > accessibilityFactor1060 + 1) {
				accessibilityFactor1061 = accessibilityFactor1060 + 1;
				initialDirection1061 = initialDirection1060;
			}
			if (accessibilityFactor1065 > accessibilityFactor1060 + 1) {
				accessibilityFactor1065 = accessibilityFactor1060 + 1;
				initialDirection1065 = initialDirection1060;
			}
			if (accessibilityFactor1066 > accessibilityFactor1060 + 1) {
				accessibilityFactor1066 = accessibilityFactor1060 + 1;
				initialDirection1066 = initialDirection1060;
			}
			if (accessibilityFactor1067 > accessibilityFactor1060 + 1) {
				accessibilityFactor1067 = accessibilityFactor1060 + 1;
				initialDirection1067 = initialDirection1060;
			}

			}
		if (mapinfo1007.isPassable() && rc.senseRobotAtLocation(maploc1007) == null) {
			if (accessibilityFactor1000 > accessibilityFactor1007 + 1) {
				accessibilityFactor1000 = accessibilityFactor1007 + 1;
				initialDirection1000 = initialDirection1007;
			}
			if (accessibilityFactor1001 > accessibilityFactor1007 + 1) {
				accessibilityFactor1001 = accessibilityFactor1007 + 1;
				initialDirection1001 = initialDirection1007;
			}
			if (accessibilityFactor1002 > accessibilityFactor1007 + 1) {
				accessibilityFactor1002 = accessibilityFactor1007 + 1;
				initialDirection1002 = initialDirection1007;
			}
			if (accessibilityFactor1006 > accessibilityFactor1007 + 1) {
				accessibilityFactor1006 = accessibilityFactor1007 + 1;
				initialDirection1006 = initialDirection1007;
			}

			}
		if (mapinfo1009.isPassable() && rc.senseRobotAtLocation(maploc1009) == null) {
			if (accessibilityFactor1002 > accessibilityFactor1009 + 1) {
				accessibilityFactor1002 = accessibilityFactor1009 + 1;
				initialDirection1002 = initialDirection1009;
			}
			if (accessibilityFactor1003 > accessibilityFactor1009 + 1) {
				accessibilityFactor1003 = accessibilityFactor1009 + 1;
				initialDirection1003 = initialDirection1009;
			}
			if (accessibilityFactor1004 > accessibilityFactor1009 + 1) {
				accessibilityFactor1004 = accessibilityFactor1009 + 1;
				initialDirection1004 = initialDirection1009;
			}
			if (accessibilityFactor1010 > accessibilityFactor1009 + 1) {
				accessibilityFactor1010 = accessibilityFactor1009 + 1;
				initialDirection1010 = initialDirection1009;
			}

			}
		if (mapinfo1022.isPassable() && rc.senseRobotAtLocation(maploc1022) == null) {
			if (accessibilityFactor1012 > accessibilityFactor1022 + 1) {
				accessibilityFactor1012 = accessibilityFactor1022 + 1;
				initialDirection1012 = initialDirection1022;
			}
			if (accessibilityFactor1013 > accessibilityFactor1022 + 1) {
				accessibilityFactor1013 = accessibilityFactor1022 + 1;
				initialDirection1013 = initialDirection1022;
			}
			if (accessibilityFactor1021 > accessibilityFactor1022 + 1) {
				accessibilityFactor1021 = accessibilityFactor1022 + 1;
				initialDirection1021 = initialDirection1022;
			}
			if (accessibilityFactor1030 > accessibilityFactor1022 + 1) {
				accessibilityFactor1030 = accessibilityFactor1022 + 1;
				initialDirection1030 = initialDirection1022;
			}

			}
		if (mapinfo1028.isPassable() && rc.senseRobotAtLocation(maploc1028) == null) {
			if (accessibilityFactor1019 > accessibilityFactor1028 + 1) {
				accessibilityFactor1019 = accessibilityFactor1028 + 1;
				initialDirection1019 = initialDirection1028;
			}
			if (accessibilityFactor1020 > accessibilityFactor1028 + 1) {
				accessibilityFactor1020 = accessibilityFactor1028 + 1;
				initialDirection1020 = initialDirection1028;
			}
			if (accessibilityFactor1029 > accessibilityFactor1028 + 1) {
				accessibilityFactor1029 = accessibilityFactor1028 + 1;
				initialDirection1029 = initialDirection1028;
			}
			if (accessibilityFactor1038 > accessibilityFactor1028 + 1) {
				accessibilityFactor1038 = accessibilityFactor1028 + 1;
				initialDirection1038 = initialDirection1028;
			}

			}
		if (mapinfo1040.isPassable() && rc.senseRobotAtLocation(maploc1040) == null) {
			if (accessibilityFactor1030 > accessibilityFactor1040 + 1) {
				accessibilityFactor1030 = accessibilityFactor1040 + 1;
				initialDirection1030 = initialDirection1040;
			}
			if (accessibilityFactor1039 > accessibilityFactor1040 + 1) {
				accessibilityFactor1039 = accessibilityFactor1040 + 1;
				initialDirection1039 = initialDirection1040;
			}
			if (accessibilityFactor1048 > accessibilityFactor1040 + 1) {
				accessibilityFactor1048 = accessibilityFactor1040 + 1;
				initialDirection1048 = initialDirection1040;
			}
			if (accessibilityFactor1049 > accessibilityFactor1040 + 1) {
				accessibilityFactor1049 = accessibilityFactor1040 + 1;
				initialDirection1049 = initialDirection1040;
			}

			}
		if (mapinfo1046.isPassable() && rc.senseRobotAtLocation(maploc1046) == null) {
			if (accessibilityFactor1038 > accessibilityFactor1046 + 1) {
				accessibilityFactor1038 = accessibilityFactor1046 + 1;
				initialDirection1038 = initialDirection1046;
			}
			if (accessibilityFactor1047 > accessibilityFactor1046 + 1) {
				accessibilityFactor1047 = accessibilityFactor1046 + 1;
				initialDirection1047 = initialDirection1046;
			}
			if (accessibilityFactor1055 > accessibilityFactor1046 + 1) {
				accessibilityFactor1055 = accessibilityFactor1046 + 1;
				initialDirection1055 = initialDirection1046;
			}
			if (accessibilityFactor1056 > accessibilityFactor1046 + 1) {
				accessibilityFactor1056 = accessibilityFactor1046 + 1;
				initialDirection1056 = initialDirection1046;
			}

			}
		if (mapinfo1059.isPassable() && rc.senseRobotAtLocation(maploc1059) == null) {
			if (accessibilityFactor1058 > accessibilityFactor1059 + 1) {
				accessibilityFactor1058 = accessibilityFactor1059 + 1;
				initialDirection1058 = initialDirection1059;
			}
			if (accessibilityFactor1064 > accessibilityFactor1059 + 1) {
				accessibilityFactor1064 = accessibilityFactor1059 + 1;
				initialDirection1064 = initialDirection1059;
			}
			if (accessibilityFactor1065 > accessibilityFactor1059 + 1) {
				accessibilityFactor1065 = accessibilityFactor1059 + 1;
				initialDirection1065 = initialDirection1059;
			}
			if (accessibilityFactor1066 > accessibilityFactor1059 + 1) {
				accessibilityFactor1066 = accessibilityFactor1059 + 1;
				initialDirection1066 = initialDirection1059;
			}

			}
		if (mapinfo1061.isPassable() && rc.senseRobotAtLocation(maploc1061) == null) {
			if (accessibilityFactor1062 > accessibilityFactor1061 + 1) {
				accessibilityFactor1062 = accessibilityFactor1061 + 1;
				initialDirection1062 = initialDirection1061;
			}
			if (accessibilityFactor1066 > accessibilityFactor1061 + 1) {
				accessibilityFactor1066 = accessibilityFactor1061 + 1;
				initialDirection1066 = initialDirection1061;
			}
			if (accessibilityFactor1067 > accessibilityFactor1061 + 1) {
				accessibilityFactor1067 = accessibilityFactor1061 + 1;
				initialDirection1067 = initialDirection1061;
			}
			if (accessibilityFactor1068 > accessibilityFactor1061 + 1) {
				accessibilityFactor1068 = accessibilityFactor1061 + 1;
				initialDirection1068 = initialDirection1061;
			}

			}
		if (mapinfo1006.isPassable() && rc.senseRobotAtLocation(maploc1006) == null) {
			if (accessibilityFactor1000 > accessibilityFactor1006 + 1) {
				accessibilityFactor1000 = accessibilityFactor1006 + 1;
				initialDirection1000 = initialDirection1006;
			}
			if (accessibilityFactor1001 > accessibilityFactor1006 + 1) {
				accessibilityFactor1001 = accessibilityFactor1006 + 1;
				initialDirection1001 = initialDirection1006;
			}
			if (accessibilityFactor1005 > accessibilityFactor1006 + 1) {
				accessibilityFactor1005 = accessibilityFactor1006 + 1;
				initialDirection1005 = initialDirection1006;
			}
			if (accessibilityFactor1013 > accessibilityFactor1006 + 1) {
				accessibilityFactor1013 = accessibilityFactor1006 + 1;
				initialDirection1013 = initialDirection1006;
			}

			}
		if (mapinfo1010.isPassable() && rc.senseRobotAtLocation(maploc1010) == null) {
			if (accessibilityFactor1003 > accessibilityFactor1010 + 1) {
				accessibilityFactor1003 = accessibilityFactor1010 + 1;
				initialDirection1003 = initialDirection1010;
			}
			if (accessibilityFactor1004 > accessibilityFactor1010 + 1) {
				accessibilityFactor1004 = accessibilityFactor1010 + 1;
				initialDirection1004 = initialDirection1010;
			}
			if (accessibilityFactor1011 > accessibilityFactor1010 + 1) {
				accessibilityFactor1011 = accessibilityFactor1010 + 1;
				initialDirection1011 = initialDirection1010;
			}
			if (accessibilityFactor1019 > accessibilityFactor1010 + 1) {
				accessibilityFactor1019 = accessibilityFactor1010 + 1;
				initialDirection1019 = initialDirection1010;
			}

			}
		if (mapinfo1013.isPassable() && rc.senseRobotAtLocation(maploc1013) == null) {
			if (accessibilityFactor1005 > accessibilityFactor1013 + 1) {
				accessibilityFactor1005 = accessibilityFactor1013 + 1;
				initialDirection1005 = initialDirection1013;
			}
			if (accessibilityFactor1012 > accessibilityFactor1013 + 1) {
				accessibilityFactor1012 = accessibilityFactor1013 + 1;
				initialDirection1012 = initialDirection1013;
			}
			if (accessibilityFactor1021 > accessibilityFactor1013 + 1) {
				accessibilityFactor1021 = accessibilityFactor1013 + 1;
				initialDirection1021 = initialDirection1013;
			}

			}
		if (mapinfo1019.isPassable() && rc.senseRobotAtLocation(maploc1019) == null) {
			if (accessibilityFactor1011 > accessibilityFactor1019 + 1) {
				accessibilityFactor1011 = accessibilityFactor1019 + 1;
				initialDirection1011 = initialDirection1019;
			}
			if (accessibilityFactor1020 > accessibilityFactor1019 + 1) {
				accessibilityFactor1020 = accessibilityFactor1019 + 1;
				initialDirection1020 = initialDirection1019;
			}
			if (accessibilityFactor1029 > accessibilityFactor1019 + 1) {
				accessibilityFactor1029 = accessibilityFactor1019 + 1;
				initialDirection1029 = initialDirection1019;
			}

			}
		if (mapinfo1049.isPassable() && rc.senseRobotAtLocation(maploc1049) == null) {
			if (accessibilityFactor1039 > accessibilityFactor1049 + 1) {
				accessibilityFactor1039 = accessibilityFactor1049 + 1;
				initialDirection1039 = initialDirection1049;
			}
			if (accessibilityFactor1048 > accessibilityFactor1049 + 1) {
				accessibilityFactor1048 = accessibilityFactor1049 + 1;
				initialDirection1048 = initialDirection1049;
			}
			if (accessibilityFactor1057 > accessibilityFactor1049 + 1) {
				accessibilityFactor1057 = accessibilityFactor1049 + 1;
				initialDirection1057 = initialDirection1049;
			}
			if (accessibilityFactor1058 > accessibilityFactor1049 + 1) {
				accessibilityFactor1058 = accessibilityFactor1049 + 1;
				initialDirection1058 = initialDirection1049;
			}

			}
		if (mapinfo1055.isPassable() && rc.senseRobotAtLocation(maploc1055) == null) {
			if (accessibilityFactor1047 > accessibilityFactor1055 + 1) {
				accessibilityFactor1047 = accessibilityFactor1055 + 1;
				initialDirection1047 = initialDirection1055;
			}
			if (accessibilityFactor1056 > accessibilityFactor1055 + 1) {
				accessibilityFactor1056 = accessibilityFactor1055 + 1;
				initialDirection1056 = initialDirection1055;
			}
			if (accessibilityFactor1062 > accessibilityFactor1055 + 1) {
				accessibilityFactor1062 = accessibilityFactor1055 + 1;
				initialDirection1062 = initialDirection1055;
			}
			if (accessibilityFactor1063 > accessibilityFactor1055 + 1) {
				accessibilityFactor1063 = accessibilityFactor1055 + 1;
				initialDirection1063 = initialDirection1055;
			}

			}
		if (mapinfo1058.isPassable() && rc.senseRobotAtLocation(maploc1058) == null) {
			if (accessibilityFactor1057 > accessibilityFactor1058 + 1) {
				accessibilityFactor1057 = accessibilityFactor1058 + 1;
				initialDirection1057 = initialDirection1058;
			}
			if (accessibilityFactor1064 > accessibilityFactor1058 + 1) {
				accessibilityFactor1064 = accessibilityFactor1058 + 1;
				initialDirection1064 = initialDirection1058;
			}
			if (accessibilityFactor1065 > accessibilityFactor1058 + 1) {
				accessibilityFactor1065 = accessibilityFactor1058 + 1;
				initialDirection1065 = initialDirection1058;
			}

			}
		if (mapinfo1062.isPassable() && rc.senseRobotAtLocation(maploc1062) == null) {
			if (accessibilityFactor1063 > accessibilityFactor1062 + 1) {
				accessibilityFactor1063 = accessibilityFactor1062 + 1;
				initialDirection1063 = initialDirection1062;
			}
			if (accessibilityFactor1067 > accessibilityFactor1062 + 1) {
				accessibilityFactor1067 = accessibilityFactor1062 + 1;
				initialDirection1067 = initialDirection1062;
			}
			if (accessibilityFactor1068 > accessibilityFactor1062 + 1) {
				accessibilityFactor1068 = accessibilityFactor1062 + 1;
				initialDirection1068 = initialDirection1062;
			}

			}
		if (mapinfo1002.isPassable() && rc.senseRobotAtLocation(maploc1002) == null) {
			if (accessibilityFactor1001 > accessibilityFactor1002 + 1) {
				accessibilityFactor1001 = accessibilityFactor1002 + 1;
				initialDirection1001 = initialDirection1002;
			}
			if (accessibilityFactor1003 > accessibilityFactor1002 + 1) {
				accessibilityFactor1003 = accessibilityFactor1002 + 1;
				initialDirection1003 = initialDirection1002;
			}

			}
		if (mapinfo1030.isPassable() && rc.senseRobotAtLocation(maploc1030) == null) {
			if (accessibilityFactor1021 > accessibilityFactor1030 + 1) {
				accessibilityFactor1021 = accessibilityFactor1030 + 1;
				initialDirection1021 = initialDirection1030;
			}
			if (accessibilityFactor1039 > accessibilityFactor1030 + 1) {
				accessibilityFactor1039 = accessibilityFactor1030 + 1;
				initialDirection1039 = initialDirection1030;
			}

			}
		if (mapinfo1038.isPassable() && rc.senseRobotAtLocation(maploc1038) == null) {
			if (accessibilityFactor1029 > accessibilityFactor1038 + 1) {
				accessibilityFactor1029 = accessibilityFactor1038 + 1;
				initialDirection1029 = initialDirection1038;
			}
			if (accessibilityFactor1047 > accessibilityFactor1038 + 1) {
				accessibilityFactor1047 = accessibilityFactor1038 + 1;
				initialDirection1047 = initialDirection1038;
			}

			}
		if (mapinfo1066.isPassable() && rc.senseRobotAtLocation(maploc1066) == null) {
			if (accessibilityFactor1065 > accessibilityFactor1066 + 1) {
				accessibilityFactor1065 = accessibilityFactor1066 + 1;
				initialDirection1065 = initialDirection1066;
			}
			if (accessibilityFactor1067 > accessibilityFactor1066 + 1) {
				accessibilityFactor1067 = accessibilityFactor1066 + 1;
				initialDirection1067 = initialDirection1066;
			}

			}
		if (mapinfo1001.isPassable() && rc.senseRobotAtLocation(maploc1001) == null) {
			if (accessibilityFactor1000 > accessibilityFactor1001 + 1) {
				accessibilityFactor1000 = accessibilityFactor1001 + 1;
				initialDirection1000 = initialDirection1001;
			}

			}
		if (mapinfo1003.isPassable() && rc.senseRobotAtLocation(maploc1003) == null) {
			if (accessibilityFactor1004 > accessibilityFactor1003 + 1) {
				accessibilityFactor1004 = accessibilityFactor1003 + 1;
				initialDirection1004 = initialDirection1003;
			}

			}
		if (mapinfo1021.isPassable() && rc.senseRobotAtLocation(maploc1021) == null) {
			if (accessibilityFactor1012 > accessibilityFactor1021 + 1) {
				accessibilityFactor1012 = accessibilityFactor1021 + 1;
				initialDirection1012 = initialDirection1021;
			}

			}
		if (mapinfo1029.isPassable() && rc.senseRobotAtLocation(maploc1029) == null) {
			if (accessibilityFactor1020 > accessibilityFactor1029 + 1) {
				accessibilityFactor1020 = accessibilityFactor1029 + 1;
				initialDirection1020 = initialDirection1029;
			}

			}
		if (mapinfo1039.isPassable() && rc.senseRobotAtLocation(maploc1039) == null) {
			if (accessibilityFactor1048 > accessibilityFactor1039 + 1) {
				accessibilityFactor1048 = accessibilityFactor1039 + 1;
				initialDirection1048 = initialDirection1039;
			}

			}
		if (mapinfo1047.isPassable() && rc.senseRobotAtLocation(maploc1047) == null) {
			if (accessibilityFactor1056 > accessibilityFactor1047 + 1) {
				accessibilityFactor1056 = accessibilityFactor1047 + 1;
				initialDirection1056 = initialDirection1047;
			}

			}
		if (mapinfo1065.isPassable() && rc.senseRobotAtLocation(maploc1065) == null) {
			if (accessibilityFactor1064 > accessibilityFactor1065 + 1) {
				accessibilityFactor1064 = accessibilityFactor1065 + 1;
				initialDirection1064 = initialDirection1065;
			}

			}
		if (mapinfo1067.isPassable() && rc.senseRobotAtLocation(maploc1067) == null) {
			if (accessibilityFactor1068 > accessibilityFactor1067 + 1) {
				accessibilityFactor1068 = accessibilityFactor1067 + 1;
				initialDirection1068 = initialDirection1067;
			}

			}
		if (mapinfo1005.isPassable() && rc.senseRobotAtLocation(maploc1005) == null) {
			if (accessibilityFactor1000 > accessibilityFactor1005 + 1) {
				accessibilityFactor1000 = accessibilityFactor1005 + 1;
				initialDirection1000 = initialDirection1005;
			}
			if (accessibilityFactor1012 > accessibilityFactor1005 + 1) {
				accessibilityFactor1012 = accessibilityFactor1005 + 1;
				initialDirection1012 = initialDirection1005;
			}

			}
		if (mapinfo1011.isPassable() && rc.senseRobotAtLocation(maploc1011) == null) {
			if (accessibilityFactor1004 > accessibilityFactor1011 + 1) {
				accessibilityFactor1004 = accessibilityFactor1011 + 1;
				initialDirection1004 = initialDirection1011;
			}
			if (accessibilityFactor1020 > accessibilityFactor1011 + 1) {
				accessibilityFactor1020 = accessibilityFactor1011 + 1;
				initialDirection1020 = initialDirection1011;
			}

			}
		if (mapinfo1057.isPassable() && rc.senseRobotAtLocation(maploc1057) == null) {
			if (accessibilityFactor1048 > accessibilityFactor1057 + 1) {
				accessibilityFactor1048 = accessibilityFactor1057 + 1;
				initialDirection1048 = initialDirection1057;
			}
			if (accessibilityFactor1064 > accessibilityFactor1057 + 1) {
				accessibilityFactor1064 = accessibilityFactor1057 + 1;
				initialDirection1064 = initialDirection1057;
			}

			}
		if (mapinfo1063.isPassable() && rc.senseRobotAtLocation(maploc1063) == null) {
			if (accessibilityFactor1056 > accessibilityFactor1063 + 1) {
				accessibilityFactor1056 = accessibilityFactor1063 + 1;
				initialDirection1056 = initialDirection1063;
			}
			if (accessibilityFactor1068 > accessibilityFactor1063 + 1) {
				accessibilityFactor1068 = accessibilityFactor1063 + 1;
				initialDirection1068 = initialDirection1063;
			}

			}
			int dx = target.x - maploc1034.x, dy = target.y - maploc1034.y;
		switch (dx) {
		case -4:
			switch (dy) {
			case -2: return initialDirection1000;
			case -1: return initialDirection1001;
			case 0: return initialDirection1002;
			case 1: return initialDirection1003;
			case 2: return initialDirection1004;
			}
			break;
		case -3:
			switch (dy) {
			case -3: return initialDirection1005;
			case -2: return initialDirection1006;
			case -1: return initialDirection1007;
			case 0: return initialDirection1008;
			case 1: return initialDirection1009;
			case 2: return initialDirection1010;
			case 3: return initialDirection1011;
			}
			break;
		case -2:
			switch (dy) {
			case -4: return initialDirection1012;
			case -3: return initialDirection1013;
			case -2: return initialDirection1014;
			case -1: return initialDirection1015;
			case 0: return initialDirection1016;
			case 1: return initialDirection1017;
			case 2: return initialDirection1018;
			case 3: return initialDirection1019;
			case 4: return initialDirection1020;
			}
			break;
		case -1:
			switch (dy) {
			case -4: return initialDirection1021;
			case -3: return initialDirection1022;
			case -2: return initialDirection1023;
			case -1: return initialDirection1024;
			case 0: return initialDirection1025;
			case 1: return initialDirection1026;
			case 2: return initialDirection1027;
			case 3: return initialDirection1028;
			case 4: return initialDirection1029;
			}
			break;
		case 0:
			switch (dy) {
			case -4: return initialDirection1030;
			case -3: return initialDirection1031;
			case -2: return initialDirection1032;
			case -1: return initialDirection1033;
			case 0: return initialDirection1034;
			case 1: return initialDirection1035;
			case 2: return initialDirection1036;
			case 3: return initialDirection1037;
			case 4: return initialDirection1038;
			}
			break;
		case 1:
			switch (dy) {
			case -4: return initialDirection1039;
			case -3: return initialDirection1040;
			case -2: return initialDirection1041;
			case -1: return initialDirection1042;
			case 0: return initialDirection1043;
			case 1: return initialDirection1044;
			case 2: return initialDirection1045;
			case 3: return initialDirection1046;
			case 4: return initialDirection1047;
			}
			break;
		case 2:
			switch (dy) {
			case -4: return initialDirection1048;
			case -3: return initialDirection1049;
			case -2: return initialDirection1050;
			case -1: return initialDirection1051;
			case 0: return initialDirection1052;
			case 1: return initialDirection1053;
			case 2: return initialDirection1054;
			case 3: return initialDirection1055;
			case 4: return initialDirection1056;
			}
			break;
		case 3:
			switch (dy) {
			case -3: return initialDirection1057;
			case -2: return initialDirection1058;
			case -1: return initialDirection1059;
			case 0: return initialDirection1060;
			case 1: return initialDirection1061;
			case 2: return initialDirection1062;
			case 3: return initialDirection1063;
			}
			break;
		case 4:
			switch (dy) {
			case -2: return initialDirection1064;
			case -1: return initialDirection1065;
			case 0: return initialDirection1066;
			case 1: return initialDirection1067;
			case 2: return initialDirection1068;
			}
			break;
		}
			potentialFactor1000 = Math.max(Math.abs(target.x - maploc1000.x), Math.abs(target.y - maploc1000.y));
			potentialFactor1001 = Math.max(Math.abs(target.x - maploc1001.x), Math.abs(target.y - maploc1001.y));
			potentialFactor1002 = Math.max(Math.abs(target.x - maploc1002.x), Math.abs(target.y - maploc1002.y));
			potentialFactor1003 = Math.max(Math.abs(target.x - maploc1003.x), Math.abs(target.y - maploc1003.y));
			potentialFactor1004 = Math.max(Math.abs(target.x - maploc1004.x), Math.abs(target.y - maploc1004.y));
			potentialFactor1005 = Math.max(Math.abs(target.x - maploc1005.x), Math.abs(target.y - maploc1005.y));
			potentialFactor1006 = Math.max(Math.abs(target.x - maploc1006.x), Math.abs(target.y - maploc1006.y));
			potentialFactor1010 = Math.max(Math.abs(target.x - maploc1010.x), Math.abs(target.y - maploc1010.y));
			potentialFactor1011 = Math.max(Math.abs(target.x - maploc1011.x), Math.abs(target.y - maploc1011.y));
			potentialFactor1012 = Math.max(Math.abs(target.x - maploc1012.x), Math.abs(target.y - maploc1012.y));
			potentialFactor1013 = Math.max(Math.abs(target.x - maploc1013.x), Math.abs(target.y - maploc1013.y));
			potentialFactor1019 = Math.max(Math.abs(target.x - maploc1019.x), Math.abs(target.y - maploc1019.y));
			potentialFactor1020 = Math.max(Math.abs(target.x - maploc1020.x), Math.abs(target.y - maploc1020.y));
			potentialFactor1021 = Math.max(Math.abs(target.x - maploc1021.x), Math.abs(target.y - maploc1021.y));
			potentialFactor1029 = Math.max(Math.abs(target.x - maploc1029.x), Math.abs(target.y - maploc1029.y));
			potentialFactor1030 = Math.max(Math.abs(target.x - maploc1030.x), Math.abs(target.y - maploc1030.y));
			potentialFactor1038 = Math.max(Math.abs(target.x - maploc1038.x), Math.abs(target.y - maploc1038.y));
			potentialFactor1039 = Math.max(Math.abs(target.x - maploc1039.x), Math.abs(target.y - maploc1039.y));
			potentialFactor1047 = Math.max(Math.abs(target.x - maploc1047.x), Math.abs(target.y - maploc1047.y));
			potentialFactor1048 = Math.max(Math.abs(target.x - maploc1048.x), Math.abs(target.y - maploc1048.y));
			potentialFactor1049 = Math.max(Math.abs(target.x - maploc1049.x), Math.abs(target.y - maploc1049.y));
			potentialFactor1055 = Math.max(Math.abs(target.x - maploc1055.x), Math.abs(target.y - maploc1055.y));
			potentialFactor1056 = Math.max(Math.abs(target.x - maploc1056.x), Math.abs(target.y - maploc1056.y));
			potentialFactor1057 = Math.max(Math.abs(target.x - maploc1057.x), Math.abs(target.y - maploc1057.y));
			potentialFactor1058 = Math.max(Math.abs(target.x - maploc1058.x), Math.abs(target.y - maploc1058.y));
			potentialFactor1062 = Math.max(Math.abs(target.x - maploc1062.x), Math.abs(target.y - maploc1062.y));
			potentialFactor1063 = Math.max(Math.abs(target.x - maploc1063.x), Math.abs(target.y - maploc1063.y));
			potentialFactor1064 = Math.max(Math.abs(target.x - maploc1064.x), Math.abs(target.y - maploc1064.y));
			potentialFactor1065 = Math.max(Math.abs(target.x - maploc1065.x), Math.abs(target.y - maploc1065.y));
			potentialFactor1066 = Math.max(Math.abs(target.x - maploc1066.x), Math.abs(target.y - maploc1066.y));
			potentialFactor1067 = Math.max(Math.abs(target.x - maploc1067.x), Math.abs(target.y - maploc1067.y));
			potentialFactor1068 = Math.max(Math.abs(target.x - maploc1068.x), Math.abs(target.y - maploc1068.y));
		if (mapinfo1068.isPassable() && rc.senseRobotAtLocation(maploc1068) == null) {
			potentialFactor1061 = Math.min(potentialFactor1061, potentialFactor1068 + 1);
			potentialFactor1062 = Math.min(potentialFactor1062, potentialFactor1068 + 1);
			potentialFactor1063 = Math.min(potentialFactor1063, potentialFactor1068 + 1);
			potentialFactor1067 = Math.min(potentialFactor1067, potentialFactor1068 + 1);
		}

		if (mapinfo1064.isPassable() && rc.senseRobotAtLocation(maploc1064) == null) {
			potentialFactor1057 = Math.min(potentialFactor1057, potentialFactor1064 + 1);
			potentialFactor1058 = Math.min(potentialFactor1058, potentialFactor1064 + 1);
			potentialFactor1059 = Math.min(potentialFactor1059, potentialFactor1064 + 1);
			potentialFactor1065 = Math.min(potentialFactor1065, potentialFactor1064 + 1);
		}

		if (mapinfo1056.isPassable() && rc.senseRobotAtLocation(maploc1056) == null) {
			potentialFactor1046 = Math.min(potentialFactor1046, potentialFactor1056 + 1);
			potentialFactor1047 = Math.min(potentialFactor1047, potentialFactor1056 + 1);
			potentialFactor1055 = Math.min(potentialFactor1055, potentialFactor1056 + 1);
			potentialFactor1063 = Math.min(potentialFactor1063, potentialFactor1056 + 1);
		}

		if (mapinfo1048.isPassable() && rc.senseRobotAtLocation(maploc1048) == null) {
			potentialFactor1039 = Math.min(potentialFactor1039, potentialFactor1048 + 1);
			potentialFactor1040 = Math.min(potentialFactor1040, potentialFactor1048 + 1);
			potentialFactor1049 = Math.min(potentialFactor1049, potentialFactor1048 + 1);
			potentialFactor1057 = Math.min(potentialFactor1057, potentialFactor1048 + 1);
		}

		if (mapinfo1020.isPassable() && rc.senseRobotAtLocation(maploc1020) == null) {
			potentialFactor1011 = Math.min(potentialFactor1011, potentialFactor1020 + 1);
			potentialFactor1019 = Math.min(potentialFactor1019, potentialFactor1020 + 1);
			potentialFactor1028 = Math.min(potentialFactor1028, potentialFactor1020 + 1);
			potentialFactor1029 = Math.min(potentialFactor1029, potentialFactor1020 + 1);
		}

		if (mapinfo1012.isPassable() && rc.senseRobotAtLocation(maploc1012) == null) {
			potentialFactor1005 = Math.min(potentialFactor1005, potentialFactor1012 + 1);
			potentialFactor1013 = Math.min(potentialFactor1013, potentialFactor1012 + 1);
			potentialFactor1021 = Math.min(potentialFactor1021, potentialFactor1012 + 1);
			potentialFactor1022 = Math.min(potentialFactor1022, potentialFactor1012 + 1);
		}

		if (mapinfo1004.isPassable() && rc.senseRobotAtLocation(maploc1004) == null) {
			potentialFactor1003 = Math.min(potentialFactor1003, potentialFactor1004 + 1);
			potentialFactor1009 = Math.min(potentialFactor1009, potentialFactor1004 + 1);
			potentialFactor1010 = Math.min(potentialFactor1010, potentialFactor1004 + 1);
			potentialFactor1011 = Math.min(potentialFactor1011, potentialFactor1004 + 1);
		}

		if (mapinfo1000.isPassable() && rc.senseRobotAtLocation(maploc1000) == null) {
			potentialFactor1001 = Math.min(potentialFactor1001, potentialFactor1000 + 1);
			potentialFactor1005 = Math.min(potentialFactor1005, potentialFactor1000 + 1);
			potentialFactor1006 = Math.min(potentialFactor1006, potentialFactor1000 + 1);
			potentialFactor1007 = Math.min(potentialFactor1007, potentialFactor1000 + 1);
		}

		if (mapinfo1063.isPassable() && rc.senseRobotAtLocation(maploc1063) == null) {
			potentialFactor1054 = Math.min(potentialFactor1054, potentialFactor1063 + 1);
			potentialFactor1055 = Math.min(potentialFactor1055, potentialFactor1063 + 1);
			potentialFactor1062 = Math.min(potentialFactor1062, potentialFactor1063 + 1);
		}

		if (mapinfo1057.isPassable() && rc.senseRobotAtLocation(maploc1057) == null) {
			potentialFactor1049 = Math.min(potentialFactor1049, potentialFactor1057 + 1);
			potentialFactor1050 = Math.min(potentialFactor1050, potentialFactor1057 + 1);
			potentialFactor1058 = Math.min(potentialFactor1058, potentialFactor1057 + 1);
		}

		if (mapinfo1011.isPassable() && rc.senseRobotAtLocation(maploc1011) == null) {
			potentialFactor1010 = Math.min(potentialFactor1010, potentialFactor1011 + 1);
			potentialFactor1018 = Math.min(potentialFactor1018, potentialFactor1011 + 1);
			potentialFactor1019 = Math.min(potentialFactor1019, potentialFactor1011 + 1);
		}

		if (mapinfo1005.isPassable() && rc.senseRobotAtLocation(maploc1005) == null) {
			potentialFactor1006 = Math.min(potentialFactor1006, potentialFactor1005 + 1);
			potentialFactor1013 = Math.min(potentialFactor1013, potentialFactor1005 + 1);
			potentialFactor1014 = Math.min(potentialFactor1014, potentialFactor1005 + 1);
		}

		if (mapinfo1067.isPassable() && rc.senseRobotAtLocation(maploc1067) == null) {
			potentialFactor1060 = Math.min(potentialFactor1060, potentialFactor1067 + 1);
			potentialFactor1061 = Math.min(potentialFactor1061, potentialFactor1067 + 1);
			potentialFactor1062 = Math.min(potentialFactor1062, potentialFactor1067 + 1);
			potentialFactor1066 = Math.min(potentialFactor1066, potentialFactor1067 + 1);
		}

		if (mapinfo1065.isPassable() && rc.senseRobotAtLocation(maploc1065) == null) {
			potentialFactor1058 = Math.min(potentialFactor1058, potentialFactor1065 + 1);
			potentialFactor1059 = Math.min(potentialFactor1059, potentialFactor1065 + 1);
			potentialFactor1060 = Math.min(potentialFactor1060, potentialFactor1065 + 1);
			potentialFactor1066 = Math.min(potentialFactor1066, potentialFactor1065 + 1);
		}

		if (mapinfo1047.isPassable() && rc.senseRobotAtLocation(maploc1047) == null) {
			potentialFactor1037 = Math.min(potentialFactor1037, potentialFactor1047 + 1);
			potentialFactor1038 = Math.min(potentialFactor1038, potentialFactor1047 + 1);
			potentialFactor1046 = Math.min(potentialFactor1046, potentialFactor1047 + 1);
			potentialFactor1055 = Math.min(potentialFactor1055, potentialFactor1047 + 1);
		}

		if (mapinfo1039.isPassable() && rc.senseRobotAtLocation(maploc1039) == null) {
			potentialFactor1030 = Math.min(potentialFactor1030, potentialFactor1039 + 1);
			potentialFactor1031 = Math.min(potentialFactor1031, potentialFactor1039 + 1);
			potentialFactor1040 = Math.min(potentialFactor1040, potentialFactor1039 + 1);
			potentialFactor1049 = Math.min(potentialFactor1049, potentialFactor1039 + 1);
		}

		if (mapinfo1029.isPassable() && rc.senseRobotAtLocation(maploc1029) == null) {
			potentialFactor1019 = Math.min(potentialFactor1019, potentialFactor1029 + 1);
			potentialFactor1028 = Math.min(potentialFactor1028, potentialFactor1029 + 1);
			potentialFactor1037 = Math.min(potentialFactor1037, potentialFactor1029 + 1);
			potentialFactor1038 = Math.min(potentialFactor1038, potentialFactor1029 + 1);
		}

		if (mapinfo1021.isPassable() && rc.senseRobotAtLocation(maploc1021) == null) {
			potentialFactor1013 = Math.min(potentialFactor1013, potentialFactor1021 + 1);
			potentialFactor1022 = Math.min(potentialFactor1022, potentialFactor1021 + 1);
			potentialFactor1030 = Math.min(potentialFactor1030, potentialFactor1021 + 1);
			potentialFactor1031 = Math.min(potentialFactor1031, potentialFactor1021 + 1);
		}

		if (mapinfo1003.isPassable() && rc.senseRobotAtLocation(maploc1003) == null) {
			potentialFactor1002 = Math.min(potentialFactor1002, potentialFactor1003 + 1);
			potentialFactor1008 = Math.min(potentialFactor1008, potentialFactor1003 + 1);
			potentialFactor1009 = Math.min(potentialFactor1009, potentialFactor1003 + 1);
			potentialFactor1010 = Math.min(potentialFactor1010, potentialFactor1003 + 1);
		}

		if (mapinfo1001.isPassable() && rc.senseRobotAtLocation(maploc1001) == null) {
			potentialFactor1002 = Math.min(potentialFactor1002, potentialFactor1001 + 1);
			potentialFactor1006 = Math.min(potentialFactor1006, potentialFactor1001 + 1);
			potentialFactor1007 = Math.min(potentialFactor1007, potentialFactor1001 + 1);
			potentialFactor1008 = Math.min(potentialFactor1008, potentialFactor1001 + 1);
		}

		if (mapinfo1066.isPassable() && rc.senseRobotAtLocation(maploc1066) == null) {
			potentialFactor1059 = Math.min(potentialFactor1059, potentialFactor1066 + 1);
			potentialFactor1060 = Math.min(potentialFactor1060, potentialFactor1066 + 1);
			potentialFactor1061 = Math.min(potentialFactor1061, potentialFactor1066 + 1);
		}

		if (mapinfo1038.isPassable() && rc.senseRobotAtLocation(maploc1038) == null) {
			potentialFactor1028 = Math.min(potentialFactor1028, potentialFactor1038 + 1);
			potentialFactor1037 = Math.min(potentialFactor1037, potentialFactor1038 + 1);
			potentialFactor1046 = Math.min(potentialFactor1046, potentialFactor1038 + 1);
		}

		if (mapinfo1030.isPassable() && rc.senseRobotAtLocation(maploc1030) == null) {
			potentialFactor1022 = Math.min(potentialFactor1022, potentialFactor1030 + 1);
			potentialFactor1031 = Math.min(potentialFactor1031, potentialFactor1030 + 1);
			potentialFactor1040 = Math.min(potentialFactor1040, potentialFactor1030 + 1);
		}

		if (mapinfo1002.isPassable() && rc.senseRobotAtLocation(maploc1002) == null) {
			potentialFactor1007 = Math.min(potentialFactor1007, potentialFactor1002 + 1);
			potentialFactor1008 = Math.min(potentialFactor1008, potentialFactor1002 + 1);
			potentialFactor1009 = Math.min(potentialFactor1009, potentialFactor1002 + 1);
		}

		if (mapinfo1062.isPassable() && rc.senseRobotAtLocation(maploc1062) == null) {
			potentialFactor1053 = Math.min(potentialFactor1053, potentialFactor1062 + 1);
			potentialFactor1054 = Math.min(potentialFactor1054, potentialFactor1062 + 1);
			potentialFactor1055 = Math.min(potentialFactor1055, potentialFactor1062 + 1);
			potentialFactor1061 = Math.min(potentialFactor1061, potentialFactor1062 + 1);
		}

		if (mapinfo1058.isPassable() && rc.senseRobotAtLocation(maploc1058) == null) {
			potentialFactor1049 = Math.min(potentialFactor1049, potentialFactor1058 + 1);
			potentialFactor1050 = Math.min(potentialFactor1050, potentialFactor1058 + 1);
			potentialFactor1051 = Math.min(potentialFactor1051, potentialFactor1058 + 1);
			potentialFactor1059 = Math.min(potentialFactor1059, potentialFactor1058 + 1);
		}

		if (mapinfo1055.isPassable() && rc.senseRobotAtLocation(maploc1055) == null) {
			potentialFactor1045 = Math.min(potentialFactor1045, potentialFactor1055 + 1);
			potentialFactor1046 = Math.min(potentialFactor1046, potentialFactor1055 + 1);
			potentialFactor1054 = Math.min(potentialFactor1054, potentialFactor1055 + 1);
		}

		if (mapinfo1049.isPassable() && rc.senseRobotAtLocation(maploc1049) == null) {
			potentialFactor1040 = Math.min(potentialFactor1040, potentialFactor1049 + 1);
			potentialFactor1041 = Math.min(potentialFactor1041, potentialFactor1049 + 1);
			potentialFactor1050 = Math.min(potentialFactor1050, potentialFactor1049 + 1);
		}

		if (mapinfo1019.isPassable() && rc.senseRobotAtLocation(maploc1019) == null) {
			potentialFactor1010 = Math.min(potentialFactor1010, potentialFactor1019 + 1);
			potentialFactor1018 = Math.min(potentialFactor1018, potentialFactor1019 + 1);
			potentialFactor1027 = Math.min(potentialFactor1027, potentialFactor1019 + 1);
			potentialFactor1028 = Math.min(potentialFactor1028, potentialFactor1019 + 1);
		}

		if (mapinfo1013.isPassable() && rc.senseRobotAtLocation(maploc1013) == null) {
			potentialFactor1006 = Math.min(potentialFactor1006, potentialFactor1013 + 1);
			potentialFactor1014 = Math.min(potentialFactor1014, potentialFactor1013 + 1);
			potentialFactor1022 = Math.min(potentialFactor1022, potentialFactor1013 + 1);
			potentialFactor1023 = Math.min(potentialFactor1023, potentialFactor1013 + 1);
		}

		if (mapinfo1010.isPassable() && rc.senseRobotAtLocation(maploc1010) == null) {
			potentialFactor1009 = Math.min(potentialFactor1009, potentialFactor1010 + 1);
			potentialFactor1017 = Math.min(potentialFactor1017, potentialFactor1010 + 1);
			potentialFactor1018 = Math.min(potentialFactor1018, potentialFactor1010 + 1);
		}

		if (mapinfo1006.isPassable() && rc.senseRobotAtLocation(maploc1006) == null) {
			potentialFactor1007 = Math.min(potentialFactor1007, potentialFactor1006 + 1);
			potentialFactor1014 = Math.min(potentialFactor1014, potentialFactor1006 + 1);
			potentialFactor1015 = Math.min(potentialFactor1015, potentialFactor1006 + 1);
		}

		if (mapinfo1061.isPassable() && rc.senseRobotAtLocation(maploc1061) == null) {
			potentialFactor1052 = Math.min(potentialFactor1052, potentialFactor1061 + 1);
			potentialFactor1053 = Math.min(potentialFactor1053, potentialFactor1061 + 1);
			potentialFactor1054 = Math.min(potentialFactor1054, potentialFactor1061 + 1);
			potentialFactor1060 = Math.min(potentialFactor1060, potentialFactor1061 + 1);
		}

		if (mapinfo1059.isPassable() && rc.senseRobotAtLocation(maploc1059) == null) {
			potentialFactor1050 = Math.min(potentialFactor1050, potentialFactor1059 + 1);
			potentialFactor1051 = Math.min(potentialFactor1051, potentialFactor1059 + 1);
			potentialFactor1052 = Math.min(potentialFactor1052, potentialFactor1059 + 1);
			potentialFactor1060 = Math.min(potentialFactor1060, potentialFactor1059 + 1);
		}

		if (mapinfo1046.isPassable() && rc.senseRobotAtLocation(maploc1046) == null) {
			potentialFactor1036 = Math.min(potentialFactor1036, potentialFactor1046 + 1);
			potentialFactor1037 = Math.min(potentialFactor1037, potentialFactor1046 + 1);
			potentialFactor1045 = Math.min(potentialFactor1045, potentialFactor1046 + 1);
			potentialFactor1054 = Math.min(potentialFactor1054, potentialFactor1046 + 1);
		}

		if (mapinfo1040.isPassable() && rc.senseRobotAtLocation(maploc1040) == null) {
			potentialFactor1031 = Math.min(potentialFactor1031, potentialFactor1040 + 1);
			potentialFactor1032 = Math.min(potentialFactor1032, potentialFactor1040 + 1);
			potentialFactor1041 = Math.min(potentialFactor1041, potentialFactor1040 + 1);
			potentialFactor1050 = Math.min(potentialFactor1050, potentialFactor1040 + 1);
		}

		if (mapinfo1028.isPassable() && rc.senseRobotAtLocation(maploc1028) == null) {
			potentialFactor1018 = Math.min(potentialFactor1018, potentialFactor1028 + 1);
			potentialFactor1027 = Math.min(potentialFactor1027, potentialFactor1028 + 1);
			potentialFactor1036 = Math.min(potentialFactor1036, potentialFactor1028 + 1);
			potentialFactor1037 = Math.min(potentialFactor1037, potentialFactor1028 + 1);
		}

		if (mapinfo1022.isPassable() && rc.senseRobotAtLocation(maploc1022) == null) {
			potentialFactor1014 = Math.min(potentialFactor1014, potentialFactor1022 + 1);
			potentialFactor1023 = Math.min(potentialFactor1023, potentialFactor1022 + 1);
			potentialFactor1031 = Math.min(potentialFactor1031, potentialFactor1022 + 1);
			potentialFactor1032 = Math.min(potentialFactor1032, potentialFactor1022 + 1);
		}

		if (mapinfo1009.isPassable() && rc.senseRobotAtLocation(maploc1009) == null) {
			potentialFactor1008 = Math.min(potentialFactor1008, potentialFactor1009 + 1);
			potentialFactor1016 = Math.min(potentialFactor1016, potentialFactor1009 + 1);
			potentialFactor1017 = Math.min(potentialFactor1017, potentialFactor1009 + 1);
			potentialFactor1018 = Math.min(potentialFactor1018, potentialFactor1009 + 1);
		}

		if (mapinfo1007.isPassable() && rc.senseRobotAtLocation(maploc1007) == null) {
			potentialFactor1008 = Math.min(potentialFactor1008, potentialFactor1007 + 1);
			potentialFactor1014 = Math.min(potentialFactor1014, potentialFactor1007 + 1);
			potentialFactor1015 = Math.min(potentialFactor1015, potentialFactor1007 + 1);
			potentialFactor1016 = Math.min(potentialFactor1016, potentialFactor1007 + 1);
		}

		if (mapinfo1060.isPassable() && rc.senseRobotAtLocation(maploc1060) == null) {
			potentialFactor1051 = Math.min(potentialFactor1051, potentialFactor1060 + 1);
			potentialFactor1052 = Math.min(potentialFactor1052, potentialFactor1060 + 1);
			potentialFactor1053 = Math.min(potentialFactor1053, potentialFactor1060 + 1);
		}

		if (mapinfo1037.isPassable() && rc.senseRobotAtLocation(maploc1037) == null) {
			potentialFactor1027 = Math.min(potentialFactor1027, potentialFactor1037 + 1);
			potentialFactor1036 = Math.min(potentialFactor1036, potentialFactor1037 + 1);
			potentialFactor1045 = Math.min(potentialFactor1045, potentialFactor1037 + 1);
		}

		if (mapinfo1031.isPassable() && rc.senseRobotAtLocation(maploc1031) == null) {
			potentialFactor1023 = Math.min(potentialFactor1023, potentialFactor1031 + 1);
			potentialFactor1032 = Math.min(potentialFactor1032, potentialFactor1031 + 1);
			potentialFactor1041 = Math.min(potentialFactor1041, potentialFactor1031 + 1);
		}

		if (mapinfo1008.isPassable() && rc.senseRobotAtLocation(maploc1008) == null) {
			potentialFactor1015 = Math.min(potentialFactor1015, potentialFactor1008 + 1);
			potentialFactor1016 = Math.min(potentialFactor1016, potentialFactor1008 + 1);
			potentialFactor1017 = Math.min(potentialFactor1017, potentialFactor1008 + 1);
		}

		if (mapinfo1054.isPassable() && rc.senseRobotAtLocation(maploc1054) == null) {
			potentialFactor1044 = Math.min(potentialFactor1044, potentialFactor1054 + 1);
			potentialFactor1045 = Math.min(potentialFactor1045, potentialFactor1054 + 1);
			potentialFactor1053 = Math.min(potentialFactor1053, potentialFactor1054 + 1);
		}

		if (mapinfo1050.isPassable() && rc.senseRobotAtLocation(maploc1050) == null) {
			potentialFactor1041 = Math.min(potentialFactor1041, potentialFactor1050 + 1);
			potentialFactor1042 = Math.min(potentialFactor1042, potentialFactor1050 + 1);
			potentialFactor1051 = Math.min(potentialFactor1051, potentialFactor1050 + 1);
		}

		if (mapinfo1018.isPassable() && rc.senseRobotAtLocation(maploc1018) == null) {
			potentialFactor1017 = Math.min(potentialFactor1017, potentialFactor1018 + 1);
			potentialFactor1026 = Math.min(potentialFactor1026, potentialFactor1018 + 1);
			potentialFactor1027 = Math.min(potentialFactor1027, potentialFactor1018 + 1);
		}

		if (mapinfo1014.isPassable() && rc.senseRobotAtLocation(maploc1014) == null) {
			potentialFactor1015 = Math.min(potentialFactor1015, potentialFactor1014 + 1);
			potentialFactor1023 = Math.min(potentialFactor1023, potentialFactor1014 + 1);
			potentialFactor1024 = Math.min(potentialFactor1024, potentialFactor1014 + 1);
		}

		if (mapinfo1053.isPassable() && rc.senseRobotAtLocation(maploc1053) == null) {
			potentialFactor1043 = Math.min(potentialFactor1043, potentialFactor1053 + 1);
			potentialFactor1044 = Math.min(potentialFactor1044, potentialFactor1053 + 1);
			potentialFactor1045 = Math.min(potentialFactor1045, potentialFactor1053 + 1);
			potentialFactor1052 = Math.min(potentialFactor1052, potentialFactor1053 + 1);
		}

		if (mapinfo1051.isPassable() && rc.senseRobotAtLocation(maploc1051) == null) {
			potentialFactor1041 = Math.min(potentialFactor1041, potentialFactor1051 + 1);
			potentialFactor1042 = Math.min(potentialFactor1042, potentialFactor1051 + 1);
			potentialFactor1043 = Math.min(potentialFactor1043, potentialFactor1051 + 1);
			potentialFactor1052 = Math.min(potentialFactor1052, potentialFactor1051 + 1);
		}

		if (mapinfo1045.isPassable() && rc.senseRobotAtLocation(maploc1045) == null) {
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1045 + 1);
			potentialFactor1036 = Math.min(potentialFactor1036, potentialFactor1045 + 1);
			potentialFactor1044 = Math.min(potentialFactor1044, potentialFactor1045 + 1);
		}

		if (mapinfo1041.isPassable() && rc.senseRobotAtLocation(maploc1041) == null) {
			potentialFactor1032 = Math.min(potentialFactor1032, potentialFactor1041 + 1);
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1041 + 1);
			potentialFactor1042 = Math.min(potentialFactor1042, potentialFactor1041 + 1);
		}

		if (mapinfo1027.isPassable() && rc.senseRobotAtLocation(maploc1027) == null) {
			potentialFactor1017 = Math.min(potentialFactor1017, potentialFactor1027 + 1);
			potentialFactor1026 = Math.min(potentialFactor1026, potentialFactor1027 + 1);
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1027 + 1);
			potentialFactor1036 = Math.min(potentialFactor1036, potentialFactor1027 + 1);
		}

		if (mapinfo1023.isPassable() && rc.senseRobotAtLocation(maploc1023) == null) {
			potentialFactor1015 = Math.min(potentialFactor1015, potentialFactor1023 + 1);
			potentialFactor1024 = Math.min(potentialFactor1024, potentialFactor1023 + 1);
			potentialFactor1032 = Math.min(potentialFactor1032, potentialFactor1023 + 1);
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1023 + 1);
		}

		if (mapinfo1017.isPassable() && rc.senseRobotAtLocation(maploc1017) == null) {
			potentialFactor1016 = Math.min(potentialFactor1016, potentialFactor1017 + 1);
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1017 + 1);
			potentialFactor1026 = Math.min(potentialFactor1026, potentialFactor1017 + 1);
		}

		if (mapinfo1015.isPassable() && rc.senseRobotAtLocation(maploc1015) == null) {
			potentialFactor1016 = Math.min(potentialFactor1016, potentialFactor1015 + 1);
			potentialFactor1024 = Math.min(potentialFactor1024, potentialFactor1015 + 1);
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1015 + 1);
		}

		if (mapinfo1052.isPassable() && rc.senseRobotAtLocation(maploc1052) == null) {
			potentialFactor1042 = Math.min(potentialFactor1042, potentialFactor1052 + 1);
			potentialFactor1043 = Math.min(potentialFactor1043, potentialFactor1052 + 1);
			potentialFactor1044 = Math.min(potentialFactor1044, potentialFactor1052 + 1);
		}

		if (mapinfo1036.isPassable() && rc.senseRobotAtLocation(maploc1036) == null) {
			potentialFactor1026 = Math.min(potentialFactor1026, potentialFactor1036 + 1);
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1036 + 1);
			potentialFactor1044 = Math.min(potentialFactor1044, potentialFactor1036 + 1);
		}

		if (mapinfo1032.isPassable() && rc.senseRobotAtLocation(maploc1032) == null) {
			potentialFactor1024 = Math.min(potentialFactor1024, potentialFactor1032 + 1);
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1032 + 1);
			potentialFactor1042 = Math.min(potentialFactor1042, potentialFactor1032 + 1);
		}

		if (mapinfo1016.isPassable() && rc.senseRobotAtLocation(maploc1016) == null) {
			potentialFactor1024 = Math.min(potentialFactor1024, potentialFactor1016 + 1);
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1016 + 1);
			potentialFactor1026 = Math.min(potentialFactor1026, potentialFactor1016 + 1);
		}

		if (mapinfo1044.isPassable() && rc.senseRobotAtLocation(maploc1044) == null) {
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1044 + 1);
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1044 + 1);
			potentialFactor1043 = Math.min(potentialFactor1043, potentialFactor1044 + 1);
		}

		if (mapinfo1042.isPassable() && rc.senseRobotAtLocation(maploc1042) == null) {
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1042 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1042 + 1);
			potentialFactor1043 = Math.min(potentialFactor1043, potentialFactor1042 + 1);
		}

		if (mapinfo1026.isPassable() && rc.senseRobotAtLocation(maploc1026) == null) {
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1026 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1026 + 1);
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1026 + 1);
		}

		if (mapinfo1024.isPassable() && rc.senseRobotAtLocation(maploc1024) == null) {
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1024 + 1);
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1024 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1024 + 1);
		}

		if (mapinfo1043.isPassable() && rc.senseRobotAtLocation(maploc1043) == null) {
			potentialFactor1033 = Math.min(potentialFactor1033, potentialFactor1043 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1043 + 1);
			potentialFactor1035 = Math.min(potentialFactor1035, potentialFactor1043 + 1);
		}

		if (mapinfo1035.isPassable() && rc.senseRobotAtLocation(maploc1035) == null) {
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1035 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1035 + 1);
		}

		if (mapinfo1033.isPassable() && rc.senseRobotAtLocation(maploc1033) == null) {
			potentialFactor1025 = Math.min(potentialFactor1025, potentialFactor1033 + 1);
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1033 + 1);
		}

		if (mapinfo1025.isPassable() && rc.senseRobotAtLocation(maploc1025) == null) {
			potentialFactor1034 = Math.min(potentialFactor1034, potentialFactor1025 + 1);
		}

		int bestValue = 256;
		Direction bestDirection = null;
		if (accessibilityFactor1000 + potentialFactor1000 < bestValue) {
			bestValue = accessibilityFactor1000 + potentialFactor1000;
			bestDirection = initialDirection1000;
		}
		if (accessibilityFactor1001 + potentialFactor1001 < bestValue) {
			bestValue = accessibilityFactor1001 + potentialFactor1001;
			bestDirection = initialDirection1001;
		}
		if (accessibilityFactor1002 + potentialFactor1002 < bestValue) {
			bestValue = accessibilityFactor1002 + potentialFactor1002;
			bestDirection = initialDirection1002;
		}
		if (accessibilityFactor1003 + potentialFactor1003 < bestValue) {
			bestValue = accessibilityFactor1003 + potentialFactor1003;
			bestDirection = initialDirection1003;
		}
		if (accessibilityFactor1004 + potentialFactor1004 < bestValue) {
			bestValue = accessibilityFactor1004 + potentialFactor1004;
			bestDirection = initialDirection1004;
		}
		if (accessibilityFactor1005 + potentialFactor1005 < bestValue) {
			bestValue = accessibilityFactor1005 + potentialFactor1005;
			bestDirection = initialDirection1005;
		}
		if (accessibilityFactor1006 + potentialFactor1006 < bestValue) {
			bestValue = accessibilityFactor1006 + potentialFactor1006;
			bestDirection = initialDirection1006;
		}
		if (accessibilityFactor1007 + potentialFactor1007 < bestValue) {
			bestValue = accessibilityFactor1007 + potentialFactor1007;
			bestDirection = initialDirection1007;
		}
		if (accessibilityFactor1008 + potentialFactor1008 < bestValue) {
			bestValue = accessibilityFactor1008 + potentialFactor1008;
			bestDirection = initialDirection1008;
		}
		if (accessibilityFactor1009 + potentialFactor1009 < bestValue) {
			bestValue = accessibilityFactor1009 + potentialFactor1009;
			bestDirection = initialDirection1009;
		}
		if (accessibilityFactor1010 + potentialFactor1010 < bestValue) {
			bestValue = accessibilityFactor1010 + potentialFactor1010;
			bestDirection = initialDirection1010;
		}
		if (accessibilityFactor1011 + potentialFactor1011 < bestValue) {
			bestValue = accessibilityFactor1011 + potentialFactor1011;
			bestDirection = initialDirection1011;
		}
		if (accessibilityFactor1012 + potentialFactor1012 < bestValue) {
			bestValue = accessibilityFactor1012 + potentialFactor1012;
			bestDirection = initialDirection1012;
		}
		if (accessibilityFactor1013 + potentialFactor1013 < bestValue) {
			bestValue = accessibilityFactor1013 + potentialFactor1013;
			bestDirection = initialDirection1013;
		}
		if (accessibilityFactor1014 + potentialFactor1014 < bestValue) {
			bestValue = accessibilityFactor1014 + potentialFactor1014;
			bestDirection = initialDirection1014;
		}
		if (accessibilityFactor1015 + potentialFactor1015 < bestValue) {
			bestValue = accessibilityFactor1015 + potentialFactor1015;
			bestDirection = initialDirection1015;
		}
		if (accessibilityFactor1016 + potentialFactor1016 < bestValue) {
			bestValue = accessibilityFactor1016 + potentialFactor1016;
			bestDirection = initialDirection1016;
		}
		if (accessibilityFactor1017 + potentialFactor1017 < bestValue) {
			bestValue = accessibilityFactor1017 + potentialFactor1017;
			bestDirection = initialDirection1017;
		}
		if (accessibilityFactor1018 + potentialFactor1018 < bestValue) {
			bestValue = accessibilityFactor1018 + potentialFactor1018;
			bestDirection = initialDirection1018;
		}
		if (accessibilityFactor1019 + potentialFactor1019 < bestValue) {
			bestValue = accessibilityFactor1019 + potentialFactor1019;
			bestDirection = initialDirection1019;
		}
		if (accessibilityFactor1020 + potentialFactor1020 < bestValue) {
			bestValue = accessibilityFactor1020 + potentialFactor1020;
			bestDirection = initialDirection1020;
		}
		if (accessibilityFactor1021 + potentialFactor1021 < bestValue) {
			bestValue = accessibilityFactor1021 + potentialFactor1021;
			bestDirection = initialDirection1021;
		}
		if (accessibilityFactor1022 + potentialFactor1022 < bestValue) {
			bestValue = accessibilityFactor1022 + potentialFactor1022;
			bestDirection = initialDirection1022;
		}
		if (accessibilityFactor1023 + potentialFactor1023 < bestValue) {
			bestValue = accessibilityFactor1023 + potentialFactor1023;
			bestDirection = initialDirection1023;
		}
		if (accessibilityFactor1024 + potentialFactor1024 < bestValue) {
			bestValue = accessibilityFactor1024 + potentialFactor1024;
			bestDirection = initialDirection1024;
		}
		if (accessibilityFactor1025 + potentialFactor1025 < bestValue) {
			bestValue = accessibilityFactor1025 + potentialFactor1025;
			bestDirection = initialDirection1025;
		}
		if (accessibilityFactor1026 + potentialFactor1026 < bestValue) {
			bestValue = accessibilityFactor1026 + potentialFactor1026;
			bestDirection = initialDirection1026;
		}
		if (accessibilityFactor1027 + potentialFactor1027 < bestValue) {
			bestValue = accessibilityFactor1027 + potentialFactor1027;
			bestDirection = initialDirection1027;
		}
		if (accessibilityFactor1028 + potentialFactor1028 < bestValue) {
			bestValue = accessibilityFactor1028 + potentialFactor1028;
			bestDirection = initialDirection1028;
		}
		if (accessibilityFactor1029 + potentialFactor1029 < bestValue) {
			bestValue = accessibilityFactor1029 + potentialFactor1029;
			bestDirection = initialDirection1029;
		}
		if (accessibilityFactor1030 + potentialFactor1030 < bestValue) {
			bestValue = accessibilityFactor1030 + potentialFactor1030;
			bestDirection = initialDirection1030;
		}
		if (accessibilityFactor1031 + potentialFactor1031 < bestValue) {
			bestValue = accessibilityFactor1031 + potentialFactor1031;
			bestDirection = initialDirection1031;
		}
		if (accessibilityFactor1032 + potentialFactor1032 < bestValue) {
			bestValue = accessibilityFactor1032 + potentialFactor1032;
			bestDirection = initialDirection1032;
		}
		if (accessibilityFactor1033 + potentialFactor1033 < bestValue) {
			bestValue = accessibilityFactor1033 + potentialFactor1033;
			bestDirection = initialDirection1033;
		}
		if (accessibilityFactor1034 + potentialFactor1034 < bestValue) {
			bestValue = accessibilityFactor1034 + potentialFactor1034;
			bestDirection = initialDirection1034;
		}
		if (accessibilityFactor1035 + potentialFactor1035 < bestValue) {
			bestValue = accessibilityFactor1035 + potentialFactor1035;
			bestDirection = initialDirection1035;
		}
		if (accessibilityFactor1036 + potentialFactor1036 < bestValue) {
			bestValue = accessibilityFactor1036 + potentialFactor1036;
			bestDirection = initialDirection1036;
		}
		if (accessibilityFactor1037 + potentialFactor1037 < bestValue) {
			bestValue = accessibilityFactor1037 + potentialFactor1037;
			bestDirection = initialDirection1037;
		}
		if (accessibilityFactor1038 + potentialFactor1038 < bestValue) {
			bestValue = accessibilityFactor1038 + potentialFactor1038;
			bestDirection = initialDirection1038;
		}
		if (accessibilityFactor1039 + potentialFactor1039 < bestValue) {
			bestValue = accessibilityFactor1039 + potentialFactor1039;
			bestDirection = initialDirection1039;
		}
		if (accessibilityFactor1040 + potentialFactor1040 < bestValue) {
			bestValue = accessibilityFactor1040 + potentialFactor1040;
			bestDirection = initialDirection1040;
		}
		if (accessibilityFactor1041 + potentialFactor1041 < bestValue) {
			bestValue = accessibilityFactor1041 + potentialFactor1041;
			bestDirection = initialDirection1041;
		}
		if (accessibilityFactor1042 + potentialFactor1042 < bestValue) {
			bestValue = accessibilityFactor1042 + potentialFactor1042;
			bestDirection = initialDirection1042;
		}
		if (accessibilityFactor1043 + potentialFactor1043 < bestValue) {
			bestValue = accessibilityFactor1043 + potentialFactor1043;
			bestDirection = initialDirection1043;
		}
		if (accessibilityFactor1044 + potentialFactor1044 < bestValue) {
			bestValue = accessibilityFactor1044 + potentialFactor1044;
			bestDirection = initialDirection1044;
		}
		if (accessibilityFactor1045 + potentialFactor1045 < bestValue) {
			bestValue = accessibilityFactor1045 + potentialFactor1045;
			bestDirection = initialDirection1045;
		}
		if (accessibilityFactor1046 + potentialFactor1046 < bestValue) {
			bestValue = accessibilityFactor1046 + potentialFactor1046;
			bestDirection = initialDirection1046;
		}
		if (accessibilityFactor1047 + potentialFactor1047 < bestValue) {
			bestValue = accessibilityFactor1047 + potentialFactor1047;
			bestDirection = initialDirection1047;
		}
		if (accessibilityFactor1048 + potentialFactor1048 < bestValue) {
			bestValue = accessibilityFactor1048 + potentialFactor1048;
			bestDirection = initialDirection1048;
		}
		if (accessibilityFactor1049 + potentialFactor1049 < bestValue) {
			bestValue = accessibilityFactor1049 + potentialFactor1049;
			bestDirection = initialDirection1049;
		}
		if (accessibilityFactor1050 + potentialFactor1050 < bestValue) {
			bestValue = accessibilityFactor1050 + potentialFactor1050;
			bestDirection = initialDirection1050;
		}
		if (accessibilityFactor1051 + potentialFactor1051 < bestValue) {
			bestValue = accessibilityFactor1051 + potentialFactor1051;
			bestDirection = initialDirection1051;
		}
		if (accessibilityFactor1052 + potentialFactor1052 < bestValue) {
			bestValue = accessibilityFactor1052 + potentialFactor1052;
			bestDirection = initialDirection1052;
		}
		if (accessibilityFactor1053 + potentialFactor1053 < bestValue) {
			bestValue = accessibilityFactor1053 + potentialFactor1053;
			bestDirection = initialDirection1053;
		}
		if (accessibilityFactor1054 + potentialFactor1054 < bestValue) {
			bestValue = accessibilityFactor1054 + potentialFactor1054;
			bestDirection = initialDirection1054;
		}
		if (accessibilityFactor1055 + potentialFactor1055 < bestValue) {
			bestValue = accessibilityFactor1055 + potentialFactor1055;
			bestDirection = initialDirection1055;
		}
		if (accessibilityFactor1056 + potentialFactor1056 < bestValue) {
			bestValue = accessibilityFactor1056 + potentialFactor1056;
			bestDirection = initialDirection1056;
		}
		if (accessibilityFactor1057 + potentialFactor1057 < bestValue) {
			bestValue = accessibilityFactor1057 + potentialFactor1057;
			bestDirection = initialDirection1057;
		}
		if (accessibilityFactor1058 + potentialFactor1058 < bestValue) {
			bestValue = accessibilityFactor1058 + potentialFactor1058;
			bestDirection = initialDirection1058;
		}
		if (accessibilityFactor1059 + potentialFactor1059 < bestValue) {
			bestValue = accessibilityFactor1059 + potentialFactor1059;
			bestDirection = initialDirection1059;
		}
		if (accessibilityFactor1060 + potentialFactor1060 < bestValue) {
			bestValue = accessibilityFactor1060 + potentialFactor1060;
			bestDirection = initialDirection1060;
		}
		if (accessibilityFactor1061 + potentialFactor1061 < bestValue) {
			bestValue = accessibilityFactor1061 + potentialFactor1061;
			bestDirection = initialDirection1061;
		}
		if (accessibilityFactor1062 + potentialFactor1062 < bestValue) {
			bestValue = accessibilityFactor1062 + potentialFactor1062;
			bestDirection = initialDirection1062;
		}
		if (accessibilityFactor1063 + potentialFactor1063 < bestValue) {
			bestValue = accessibilityFactor1063 + potentialFactor1063;
			bestDirection = initialDirection1063;
		}
		if (accessibilityFactor1064 + potentialFactor1064 < bestValue) {
			bestValue = accessibilityFactor1064 + potentialFactor1064;
			bestDirection = initialDirection1064;
		}
		if (accessibilityFactor1065 + potentialFactor1065 < bestValue) {
			bestValue = accessibilityFactor1065 + potentialFactor1065;
			bestDirection = initialDirection1065;
		}
		if (accessibilityFactor1066 + potentialFactor1066 < bestValue) {
			bestValue = accessibilityFactor1066 + potentialFactor1066;
			bestDirection = initialDirection1066;
		}
		if (accessibilityFactor1067 + potentialFactor1067 < bestValue) {
			bestValue = accessibilityFactor1067 + potentialFactor1067;
			bestDirection = initialDirection1067;
		}
		if (accessibilityFactor1068 + potentialFactor1068 < bestValue) {
			bestValue = accessibilityFactor1068 + potentialFactor1068;
			bestDirection = initialDirection1068;
		}
System.out.println("1000: accessibilityFactor = " + accessibilityFactor1000 + "potentialFactor = " + potentialFactor1000);
System.out.println("1001: accessibilityFactor = " + accessibilityFactor1001 + "potentialFactor = " + potentialFactor1001);
System.out.println("1002: accessibilityFactor = " + accessibilityFactor1002 + "potentialFactor = " + potentialFactor1002);
System.out.println("1003: accessibilityFactor = " + accessibilityFactor1003 + "potentialFactor = " + potentialFactor1003);
System.out.println("1004: accessibilityFactor = " + accessibilityFactor1004 + "potentialFactor = " + potentialFactor1004);
System.out.println("1005: accessibilityFactor = " + accessibilityFactor1005 + "potentialFactor = " + potentialFactor1005);
System.out.println("1006: accessibilityFactor = " + accessibilityFactor1006 + "potentialFactor = " + potentialFactor1006);
System.out.println("1007: accessibilityFactor = " + accessibilityFactor1007 + "potentialFactor = " + potentialFactor1007);
System.out.println("1008: accessibilityFactor = " + accessibilityFactor1008 + "potentialFactor = " + potentialFactor1008);
System.out.println("1009: accessibilityFactor = " + accessibilityFactor1009 + "potentialFactor = " + potentialFactor1009);
System.out.println("1010: accessibilityFactor = " + accessibilityFactor1010 + "potentialFactor = " + potentialFactor1010);
System.out.println("1011: accessibilityFactor = " + accessibilityFactor1011 + "potentialFactor = " + potentialFactor1011);
System.out.println("1012: accessibilityFactor = " + accessibilityFactor1012 + "potentialFactor = " + potentialFactor1012);
System.out.println("1013: accessibilityFactor = " + accessibilityFactor1013 + "potentialFactor = " + potentialFactor1013);
System.out.println("1014: accessibilityFactor = " + accessibilityFactor1014 + "potentialFactor = " + potentialFactor1014);
System.out.println("1015: accessibilityFactor = " + accessibilityFactor1015 + "potentialFactor = " + potentialFactor1015);
System.out.println("1016: accessibilityFactor = " + accessibilityFactor1016 + "potentialFactor = " + potentialFactor1016);
System.out.println("1017: accessibilityFactor = " + accessibilityFactor1017 + "potentialFactor = " + potentialFactor1017);
System.out.println("1018: accessibilityFactor = " + accessibilityFactor1018 + "potentialFactor = " + potentialFactor1018);
System.out.println("1019: accessibilityFactor = " + accessibilityFactor1019 + "potentialFactor = " + potentialFactor1019);
System.out.println("1020: accessibilityFactor = " + accessibilityFactor1020 + "potentialFactor = " + potentialFactor1020);
System.out.println("1021: accessibilityFactor = " + accessibilityFactor1021 + "potentialFactor = " + potentialFactor1021);
System.out.println("1022: accessibilityFactor = " + accessibilityFactor1022 + "potentialFactor = " + potentialFactor1022);
System.out.println("1023: accessibilityFactor = " + accessibilityFactor1023 + "potentialFactor = " + potentialFactor1023);
System.out.println("1024: accessibilityFactor = " + accessibilityFactor1024 + "potentialFactor = " + potentialFactor1024);
System.out.println("1025: accessibilityFactor = " + accessibilityFactor1025 + "potentialFactor = " + potentialFactor1025);
System.out.println("1026: accessibilityFactor = " + accessibilityFactor1026 + "potentialFactor = " + potentialFactor1026);
System.out.println("1027: accessibilityFactor = " + accessibilityFactor1027 + "potentialFactor = " + potentialFactor1027);
System.out.println("1028: accessibilityFactor = " + accessibilityFactor1028 + "potentialFactor = " + potentialFactor1028);
System.out.println("1029: accessibilityFactor = " + accessibilityFactor1029 + "potentialFactor = " + potentialFactor1029);
System.out.println("1030: accessibilityFactor = " + accessibilityFactor1030 + "potentialFactor = " + potentialFactor1030);
System.out.println("1031: accessibilityFactor = " + accessibilityFactor1031 + "potentialFactor = " + potentialFactor1031);
System.out.println("1032: accessibilityFactor = " + accessibilityFactor1032 + "potentialFactor = " + potentialFactor1032);
System.out.println("1033: accessibilityFactor = " + accessibilityFactor1033 + "potentialFactor = " + potentialFactor1033);
System.out.println("1034: accessibilityFactor = " + accessibilityFactor1034 + "potentialFactor = " + potentialFactor1034);
System.out.println("1035: accessibilityFactor = " + accessibilityFactor1035 + "potentialFactor = " + potentialFactor1035);
System.out.println("1036: accessibilityFactor = " + accessibilityFactor1036 + "potentialFactor = " + potentialFactor1036);
System.out.println("1037: accessibilityFactor = " + accessibilityFactor1037 + "potentialFactor = " + potentialFactor1037);
System.out.println("1038: accessibilityFactor = " + accessibilityFactor1038 + "potentialFactor = " + potentialFactor1038);
System.out.println("1039: accessibilityFactor = " + accessibilityFactor1039 + "potentialFactor = " + potentialFactor1039);
System.out.println("1040: accessibilityFactor = " + accessibilityFactor1040 + "potentialFactor = " + potentialFactor1040);
System.out.println("1041: accessibilityFactor = " + accessibilityFactor1041 + "potentialFactor = " + potentialFactor1041);
System.out.println("1042: accessibilityFactor = " + accessibilityFactor1042 + "potentialFactor = " + potentialFactor1042);
System.out.println("1043: accessibilityFactor = " + accessibilityFactor1043 + "potentialFactor = " + potentialFactor1043);
System.out.println("1044: accessibilityFactor = " + accessibilityFactor1044 + "potentialFactor = " + potentialFactor1044);
System.out.println("1045: accessibilityFactor = " + accessibilityFactor1045 + "potentialFactor = " + potentialFactor1045);
System.out.println("1046: accessibilityFactor = " + accessibilityFactor1046 + "potentialFactor = " + potentialFactor1046);
System.out.println("1047: accessibilityFactor = " + accessibilityFactor1047 + "potentialFactor = " + potentialFactor1047);
System.out.println("1048: accessibilityFactor = " + accessibilityFactor1048 + "potentialFactor = " + potentialFactor1048);
System.out.println("1049: accessibilityFactor = " + accessibilityFactor1049 + "potentialFactor = " + potentialFactor1049);
System.out.println("1050: accessibilityFactor = " + accessibilityFactor1050 + "potentialFactor = " + potentialFactor1050);
System.out.println("1051: accessibilityFactor = " + accessibilityFactor1051 + "potentialFactor = " + potentialFactor1051);
System.out.println("1052: accessibilityFactor = " + accessibilityFactor1052 + "potentialFactor = " + potentialFactor1052);
System.out.println("1053: accessibilityFactor = " + accessibilityFactor1053 + "potentialFactor = " + potentialFactor1053);
System.out.println("1054: accessibilityFactor = " + accessibilityFactor1054 + "potentialFactor = " + potentialFactor1054);
System.out.println("1055: accessibilityFactor = " + accessibilityFactor1055 + "potentialFactor = " + potentialFactor1055);
System.out.println("1056: accessibilityFactor = " + accessibilityFactor1056 + "potentialFactor = " + potentialFactor1056);
System.out.println("1057: accessibilityFactor = " + accessibilityFactor1057 + "potentialFactor = " + potentialFactor1057);
System.out.println("1058: accessibilityFactor = " + accessibilityFactor1058 + "potentialFactor = " + potentialFactor1058);
System.out.println("1059: accessibilityFactor = " + accessibilityFactor1059 + "potentialFactor = " + potentialFactor1059);
System.out.println("1060: accessibilityFactor = " + accessibilityFactor1060 + "potentialFactor = " + potentialFactor1060);
System.out.println("1061: accessibilityFactor = " + accessibilityFactor1061 + "potentialFactor = " + potentialFactor1061);
System.out.println("1062: accessibilityFactor = " + accessibilityFactor1062 + "potentialFactor = " + potentialFactor1062);
System.out.println("1063: accessibilityFactor = " + accessibilityFactor1063 + "potentialFactor = " + potentialFactor1063);
System.out.println("1064: accessibilityFactor = " + accessibilityFactor1064 + "potentialFactor = " + potentialFactor1064);
System.out.println("1065: accessibilityFactor = " + accessibilityFactor1065 + "potentialFactor = " + potentialFactor1065);
System.out.println("1066: accessibilityFactor = " + accessibilityFactor1066 + "potentialFactor = " + potentialFactor1066);
System.out.println("1067: accessibilityFactor = " + accessibilityFactor1067 + "potentialFactor = " + potentialFactor1067);
System.out.println("1068: accessibilityFactor = " + accessibilityFactor1068 + "potentialFactor = " + potentialFactor1068);
		System.out.println("bestValue = " + bestValue + ", bestDirection = " + (bestDirection == null ? "null" : bestDirection.name()));
		return bestDirection;
	}
}
