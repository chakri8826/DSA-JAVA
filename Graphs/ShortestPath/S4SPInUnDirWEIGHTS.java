import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node, dis;

    public Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class S4SPInUnDirWEIGHTS {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i<=n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int parent[] = new int[n+1];
         
        
        dist[1] = 0;
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node, d = p.dis;

            for (Pair nbr : adj.get(u)) {
                int v = nbr.node, wt = nbr.dis;
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    parent[v]=u;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        if (dist[n] == Integer.MAX_VALUE) return List.of(-1);
        
        List<Integer> path = new ArrayList<>();
        int curr = n;
        while (curr != 1) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0, dist[n]);  // Add total weight to front
        return path;
    }
}
