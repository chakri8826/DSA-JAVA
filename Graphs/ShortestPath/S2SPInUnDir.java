package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S2SPInUnDir {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);  // Directly initialize with -1 (unreachable)
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {  // Unvisited
                    dist[neighbor] = dist[node] + 1;
                    q.offer(neighbor);
                }
            }
        }
        for(int i=0;i<adj.size();i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }

        return dist;
    }
}
