import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// User function Template for Java
class Pair{
    int node,wt;
    public Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}

public class S1SPInDAG {
    public void DFS(int start,boolean vis[],Stack<Integer> st,ArrayList<ArrayList<Pair>> adj){
        vis[start]=true;
        for(Pair p:adj.get(start)){
            int it=p.node;
            if(!vis[it]){
                DFS(it,vis,st,adj);
            }
        }
        st.push(start);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v,wt));
        }
        
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                DFS(i,vis,st,adj);
            }
        }
        
        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        
        while(!st.isEmpty()){
            int top = st.pop();
            int dis = dist[top]; 
            if (dist[top] != Integer.MAX_VALUE) {
                for(Pair p:adj.get(top)){
                    int node = p.node;
                    int wt = p.wt;
                    if(dis+wt<dist[node]){
                        dist[node]=dis+wt;
                    }
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    } 
}
