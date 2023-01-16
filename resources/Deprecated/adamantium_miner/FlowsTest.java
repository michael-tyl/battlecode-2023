package adamantium_miner;

import java.util.*;

public class FlowsTest {
    //mcmf for edges capacities of 1
    static class Flows {

        class Pair {

            int ff, ss;

            Pair(){
                ff = ss = 0;
            }

            Pair(int first, int second){
                ff = first;
                ss = second;
            }
        }

        ArrayList<Pair> graph[];
        int flow[], dist[];
        boolean in[];
        Pair edge[], par[];
        int n, m;

        Flows(int n_, int m_){
            n = n_;
            m = 0;
            graph = new ArrayList[n];
            for(int i = 0; i < n; i++) graph[i] = new ArrayList<Pair>();
            dist = new int[n];
            in = new boolean[n];
            par = new Pair[n];
            edge = new Pair[2*m_];
            flow = new int[2*m_];
        }
        
        //adds an edge between a and b with cost c
        void addEdge(int a, int b, int c){
            graph[a].add(new Pair(b, m));
            graph[b].add(new Pair(a, m + 1));
            edge[m] = new Pair(1, c);
            edge[m + 1] = new Pair(0, -c);
            flow[m] = 0;
            flow[m + 1] = 0;
            m += 2;
        }

        boolean spfa(){
            for(int i = 0; i < n; i++){
                dist[i] = 1000000000;
                in[i] = false;
            } 
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            dist[0] = 0;
            while(!q.isEmpty()){
                int x = q.remove();
                in[x] = false;
                for(Pair i : graph[x]){
                    if(dist[i.ff] > dist[x] + edge[i.ss].ss && flow[i.ss] < edge[i.ss].ff){
                        dist[i.ff] = dist[x] + edge[i.ss].ss;
                        par[i.ff] = new Pair(x, i.ss);
                        if(!in[i.ff]){
                            in[i.ff] = true;
                            q.add(i.ff);
                        }
                    }
                }
            }
            return dist[n - 1] < 1000000000;
        }

        int run(){
            int ret = 0;
            while(spfa()){
                int x = n - 1;
                while(x != 0){
                    int ind = par[x].ss;
                    flow[ind]++;
                    flow[ind ^ 1]--;
                    x = par[x].ff;
                }
                ret++;
            }
            return ret;
        }

        //Returns an arraylist of paths representing the max flow
        ArrayList<ArrayList<Integer>> paths(){
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            int cnt = run();
            for(int i = 0; i < cnt; i++){
                ret.add(new ArrayList<Integer>());
                int x = 0;
                while(x != n - 1){
                    ret.get(ret.size() - 1).add(x);
                    for(Pair j : graph[x]){
                        if(flow[j.ss] == 1){
                            flow[j.ss] = 0;
                            x = j.ff;
                            break;
                        }
                    }
                }
                ret.get(ret.size() - 1).add(n - 1);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Flows graph = new Flows(n, m);
        for(int i = 0; i < m; i++){
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            graph.addEdge(a, b, 1);
        }
        in.close();
        ArrayList<ArrayList<Integer>> ans = graph.paths();
        System.out.println(ans.size());
        for(ArrayList<Integer> i : ans){
            System.out.println(i.size());
            for(int j : i) System.out.print((j + 1) + " ");
            System.out.print("\n");
        }
    }
}
