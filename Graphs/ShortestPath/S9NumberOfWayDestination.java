import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int node;
    long dis;

    public Pair(int node, long dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class S9NumberOfWayDestination {
    public int countPaths(int n, int[][] roads) {
        int mod=(int)1e9+7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for (int[] edge : roads) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        int ways[] = new int[n];
        ways[0]=1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dis,b.dis));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long dis = p.dis;
            if (dis > dist[node]) continue;

            for(Pair nbr:adj.get(node)){
                int v=nbr.node;
                long time = nbr.dis;

                if(dis+time<dist[v]){
                    dist[v]=dis+time;
                    pq.offer(new Pair(v, dist[v]));
                    ways[v]=ways[node];
                }
                else if(dis+time==dist[v]){
                    ways[v]=(ways[v]+ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
    }       
}
