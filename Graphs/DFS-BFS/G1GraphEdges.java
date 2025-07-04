import java.util.*;

public class G1GraphEdges {
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

        // Print all edges
        System.out.println("Edges of the graph:");
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) { // to avoid printing both (u,v) and (v,u)
                    System.out.println(u + " - " + v);
                }
            }
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove this line if the graph is directed
    }
    static void removeEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).remove(Integer.valueOf(v));
        adj.get(v).remove(Integer.valueOf(u)); // remove this line if the graph is directed
    }
}
