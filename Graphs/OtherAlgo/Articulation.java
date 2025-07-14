 
public class Articulation {
        // Function to return Breadth First Traversal of given graph.
        public void DFS(int node,int parent,int tin[],int low[],int timer[],boolean vis[],boolean mark[],ArrayList<ArrayList<Integer>> adj){
            vis[node]=true;
            tin[node]=low[node]=timer[0]++;
            
            int child=0;
            for(int it:adj.get(node)){
                if(it==parent)continue;
                if(!vis[it]){
                    child++;
                    DFS(it,node,tin,low,timer,vis,mark,adj);
                    low[node]=Math.min(low[node],low[it]);
                    if(low[it]>=tin[node] && parent!=-1){
                        mark[node]=true;
                    }
                }
                else{
                    low[node]=Math.min(low[node],tin[it]);
                }
            }
            if(child>1 && parent==-1){
                mark[node]=true;
            }
        }
        public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
            int tin[] = new int[V];
            int low[] = new int[V];
            int timer[] = {0};
            boolean vis[] = new boolean[V];
            boolean mark[] = new boolean[V];
            for(int i=0;i<V;i++){
                if(!vis[i]){
                    DFS(i,-1,tin,low,timer,vis,mark,adj);
                }
            }
            
            ArrayList<Integer> li = new ArrayList<>();
            for(int i=0;i<V;i++){
                if(mark[i]){
                    li.add(i);
                }
            }
            if(li.size()==0){
                li.add(-1);
                return li;
            }
            return li;
        }
        
}