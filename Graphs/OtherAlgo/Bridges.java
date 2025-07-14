import java.util.*;
public class Bridges {
    public void DFS(int i,int par,int tin[],int low[],int timer[],boolean vis[],List<List<Integer>> adjLi,List<List<Integer>> res){
            vis[i]=true;
            tin[i]=low[i]=timer[0]++;
            for(int adj:adjLi.get(i)){
                if(adj==par)continue;
                if(!vis[adj]){
                    DFS(adj,i,tin,low,timer,vis,adjLi,res);
                    if(low[adj]>
                    
                    tin[i]){
                        List<Integer> li = new ArrayList<>();
                        li.add(i);
                        li.add(adj);
                        res.add(li);
                    }
                }   
                low[i]=Math.min(low[adj],low[i]);            
            }
        }
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(List<Integer> edge:connections){
                int u = edge.get(0),v=edge.get(1);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            
            int[] tin = new int[n];
            int[] low = new int[n];
            int[] timer = {0};
            boolean vis[] = new boolean[n];
            List<List<Integer>> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    DFS(i,-1,tin,low,timer,vis,adj,res);
                }
            }
            return res;
        }
    
}
