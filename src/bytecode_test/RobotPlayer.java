package bytecode_test;

import battlecode.common.*;

public strictfp class RobotPlayer {

    static void func(){
        return;
    }

    static int BIT0 = 254;
    static int BIT1 = 253;
    static int BIT2 = 251;
    static int BIT3 = 247;
    static int BIT4 = 239;
    static int BIT5 = 223;
    static int BIT6 = 191;
    static int BIT7 = 127;
    static int queue[], edge[], par[];

    static Direction bfs() throws GameActionException{
        int l = 0, r = 1, cur, nxt;
        while(l < r){
            nxt = cur = queue[l];
            ++l;
            ++nxt;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            nxt += 60;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            --nxt;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            --nxt;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            nxt -= 60;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            nxt -= 60;
            if(par[nxt] == 0){
                par[nxt] = cur;
                queue[r] = nxt;
                ++r;
            }
            ++nxt;
            if(par[nxt] == 0){
                par[nxt] = cur;
                edge[nxt] &= BIT6;
                queue[r] = nxt;
                ++r;
            }
            ++nxt;
            if(par[nxt] == 0){
                par[nxt] = cur;
                edge[nxt] &= BIT6;
                queue[r] = nxt;
                ++r;
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        String s = "sadfdsafjaekeafds";
        int start = Clock.getBytecodeNum();
        s = s.substring(1);
        int end = Clock.getBytecodeNum();
        System.out.println("string delete :" + (end - start - 1));
        start = Clock.getBytecodeNum();
        s += 1;
        end = Clock.getBytecodeNum();
        System.out.println("string add :" + (end - start - 1));
        int x;
        start = Clock.getBytecodeNum();
        x = s.charAt(0);
        end = Clock.getBytecodeNum();
        System.out.println("string query :" + (end - start - 1));
        int arr[] = new int[10];
        int l = 0, r = 1;
        start = Clock.getBytecodeNum();
        l++;
        end = Clock.getBytecodeNum();
        System.out.println("array delete :" + (end - start - 1));
        start = Clock.getBytecodeNum();
        arr[r++] = 1;
        end = Clock.getBytecodeNum();
        System.out.println("array add :" + (end - start - 1));
        start = Clock.getBytecodeNum();
        x = arr[l];
        end = Clock.getBytecodeNum();
        System.out.println("array query :" + (end - start - 1));
        start = Clock.getBytecodeNum();
        x &= BIT0;
        end = Clock.getBytecodeNum();
        System.out.println("add global :" + (end - start - 1));
        start = Clock.getBytecodeNum();
        x &= 254;
        end = Clock.getBytecodeNum();
        System.out.println("add constant :" + (end - start - 1));
        rc.resign();
    }
}