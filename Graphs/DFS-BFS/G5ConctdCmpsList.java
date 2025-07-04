import java.util.ArrayList;

public class G5ConctdCmpsList {
    public void DFS(int val,boolean[] vis,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
        vis[val]=true;
        res.add(val);
        for(int it:adj.get(val)){
            if(!vis[it]){
                DFS(it,vis,res,adj);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // GIVEN EDGE LIST WE ARE CONVERTING IT TO --> ADJ MATRIX.
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // because the graph is undirected
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[V];
        
        for(int v=0;v<adjList.size();v++){
            if(!vis[v]){
                ArrayList<Integer> li = new ArrayList<>();
                DFS(v,vis,li,adjList);
                res.add(li);
            }   
        }
        return res;
    }
    public static void main(String[] args) {
        int V = 5; // number of vertices
        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {1, 4}
        };

        G5ConctdCmpsList g = new G5ConctdCmpsList();
        ArrayList<ArrayList<Integer>> components = g.getComponents(V, edges);
        System.out.println(components); // Output: [[0, 1, 2, 3, 4]]
    }
}
