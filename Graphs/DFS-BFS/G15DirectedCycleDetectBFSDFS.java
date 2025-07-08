import java.util.LinkedList;
import java.util.Queue;

class G15DirectedCycleDetectBFSDFS {
    public boolean DFS(int start, ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[]){
        vis[start]=1;
        pathVis[start]=1;
        for(int it:adj.get(start)){
            if(vis[it]==0){
                if(DFS(it,adj,vis,pathVis))return true;
            }
            else if(pathVis[it]==1)return true;
        }
        pathVis[start]=0;
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

        // DFS
        // int vis[] = new int[V];
        // int pathVis[] = new int[V];
        // for(int i=0;i<V;i++){
        //     if(vis[i]==0){
        //         // if(DFS(i,adj,vis,pathVis))return true;
                
        //         // SINGLE VIS NO preVis
        //         if(DFS(i,adj,vis))return true;
        //     }
        // }
        // return false;


        // BFS
        int inDeg[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                inDeg[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            li.add(top);
            for(int it:adj.get(top)){
                inDeg[it]--;
                if(inDeg[it]==0){
                    q.offer(it);
                }
            }
        }
        return li.size()<V;
    }
}

