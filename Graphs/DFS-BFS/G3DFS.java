import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G3DFS {
    // MARKING INSIDE LOOP LIKE BFS(vis[0]=true at calling first DFS)
    // public void DFS(int val,boolean[] vis,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
    //     res.add(val);
    //     for(int it:adj.get(val)){
    //         if(!vis[it]){
    //             vis[it]=true;
    //             DFS(it,vis,res,adj);
    //         }
    //     }
    // }
    // public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    //     Queue<Integer> q = new LinkedList<>();
    //     ArrayList<Integer> res = new ArrayList<>();
    //     boolean vis[] = new boolean[adj.size()];
    //     vis[0]=true;
    //     DFS(0,vis,res,adj);
    //     return res;
    // }
    
    public void DFS(int val,boolean[] vis,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
        vis[val]=true;
        res.add(val);
        for(int it:adj.get(val)){
            if(!vis[it]){
                DFS(it,vis,res,adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        DFS(0,vis,res,adj);
        return res;
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

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        
        G3DFS g = new G3DFS();
        ArrayList<Integer> result = g.dfs(adj);
        System.out.println(result);
    }
}
