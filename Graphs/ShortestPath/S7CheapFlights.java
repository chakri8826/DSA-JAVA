import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node, cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class State {
    int stops, node, dis;

    public State(int stops, int node, int dis) {
        this.stops = stops;
        this.node = node;
        this.dis = dis;
    }
}

public class S7CheapFlights {
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:flights){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        Queue<State> q = new LinkedList<>();
        q.offer(new State(0,src,0));
        
        while(!q.isEmpty()){
            State s = q.poll();
            int stops = s.stops;
            int node = s.node;
            int dis = s.dis;
            for(Pair p:adj.get(node)){
                int v=p.node;
                int cost = p.cost;
                int newCost = dis+cost;
                if(stops<=k && newCost<dist[v]){
                    dist[v]=newCost;
                    if (stops + 1 <= k)
                        q.offer(new State(stops + 1, v, dis+cost));
                }
            }
        }   
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }    
}
