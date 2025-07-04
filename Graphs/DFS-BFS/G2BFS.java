import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G2BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> bfs = new ArrayList<>();
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int val = q.poll();
            bfs.add(val);
            for(int adjs:adj.get(val)){
                if(!vis[adjs]){
                    q.offer(adjs);
                    vis[adjs]=true;
                }
            }
        }
        return bfs;
    } 

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove this line if the graph is directed
    }
    public static void main(String[] args) {
        int V = 5; // number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        G2BFS g2bfs = new G2BFS();
        ArrayList<Integer> bfsResult = g2bfs.bfs(adj);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
