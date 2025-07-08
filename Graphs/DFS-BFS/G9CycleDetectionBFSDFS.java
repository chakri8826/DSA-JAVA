import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node, par;
    public Pair(int node, int par) {
        this.node = node;
        this.par = par;
    }
}

public class G9CycleDetectionBFSDFS {
    public boolean BFS(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        vis[0]=true;
        q.offer(new Pair(start,-1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int par = p.par;
            for(int it:adj.get(node)){
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new Pair(it, node));
                } else if (it != par) return true;
            }
        }
        return false;
    }
    public boolean DFS(int start,int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[start]=true;
        for(int it:adj.get(start)){
            if(!vis[it]){
                if(DFS(it,start,adj,vis)) return true;
            }
            else  if(it!=par){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean vis[] = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // if (BFS(i, adj, vis)) return true;
                if (DFS(i, -1, adj, vis)) return true;
            }
        }
        
       return false;
    }
}
