import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair {
    int dist, node, steps;

    public Pair(int steps, int node, int dist) {
        this.steps = steps;
        this.node = node;
        this.dist = dist;
    }
}

class Pair1 {
    int v, wt;

    public Pair1(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
public class S7CheapFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair1>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.steps-b.steps);
        for(int[] fli:flights){
            int u = fli[0];
            int v = fli[1];
            int wt = fli[2];
            adj.get(u).add(new Pair1(v,wt));
        }
        q.offer(new Pair(0,src,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int steps = p.steps;
            int node = p.node;
            int dis = p.dist;
            if(steps>k)continue;
            for(Pair1 nbr:adj.get(node)){
                int v = nbr.v;
                int wt = nbr.wt;
                if(dis+wt<dist[v]){
                    dist[v]=dis+wt;
                    q.offer(new Pair(steps+1,v,dis+wt));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }    
}
