// robot that does nothing, useful for testing resource or navigation bots

package dummyplayer;

import battlecode.common.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public strictfp class RobotPlayer {
    static int turnCount = 0;

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        while (true) {
            turnCount += 1;
            try {
            } finally {
                Clock.yield();
            }
        }
    }
}
