
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int node, dis;

    public Pair(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}

public class S3Dijkstra {
    // Dijkstra's algorithm using a priority queue (min-heap)
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            // For undirected: adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node, d = p.dis;

            for (Pair nbr : adj.get(u)) {
                int v = nbr.node, wt = nbr.dis;
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }


    // SET DATA-STRUCT VERSION 
    // public int[] dijkstra(int V, int[][] edges, int src) {
    // ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    // for (int i = 0; i < V; i++) {
    // adj.add(new ArrayList<>());
    // }

    // // Building the adjacency list
    // for (int[] edge : edges) {
    // int u = edge[0];
    // int v = edge[1];
    // int wt = edge[2];
    // adj.get(u).add(new Pair(v, wt));
    // // If it's an undirected graph, add this:
    // // adj.get(v).add(new Pair(u, wt));
    // }

    // // TreeSet with custom comparator
    // TreeSet<Pair> set = new TreeSet<>((a, b) -> {
    // if (a.dis != b.dis)
    // return a.dis - b.dis;
    // return a.node - b.node; // break ties uniquely
    // });

    // int[] dist = new int[V];
    // Arrays.fill(dist, Integer.MAX_VALUE);
    // dist[src] = 0;

    // set.add(new Pair(src, 0));

    // while (!set.isEmpty()) {
    // Pair p = set.pollFirst(); // get and remove the smallest
    // int u = p.node;
    // int d = p.dis;

    // for (Pair nbr : adj.get(u)) {
    // int v = nbr.node;
    // int wt = nbr.dis;
    // if (d + wt < dist[v]) {
    // // Remove old Pair if it exists
    // set.remove(new Pair(v, dist[v]));
    // dist[v] = d + wt;
    // set.add(new Pair(v, dist[v]));
    // }
    // }
    // }

    // return dist;
    // }
}
