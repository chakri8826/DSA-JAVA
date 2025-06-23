class G15DirectedCycleDetect {
    public boolean DFS(int start, ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[]){
        vis[start]=1;
        pathVis[start]=1;
        for(int it:adj.get(start)){
            if(vis[it]==0){
                if(DFS(it,adj,vis,pathVis))return true;
                pathVis[it]=0;
            }
            else if(pathVis[it]==1)return true;
        }
        return false;
    } 
    
    public boolean DFS(int start, ArrayList<ArrayList<Integer>> adj,int vis[]){
        vis[start]=2;
        for(int it:adj.get(start)){
            if(vis[it]==0){
                if(DFS(it,adj,vis))return true;
            }
            else if(vis[it]==2)return true;
        }
        vis[start]=1;
        return false;
    } 
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                // if(DFS(i,adj,vis,pathVis))return true;
                
                // SINGLE VIS NO preVis
                if(DFS(i,adj,vis))return true;
            }
        }
        return false;
    }
}