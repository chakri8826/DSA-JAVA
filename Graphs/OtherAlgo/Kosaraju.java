 
public class Kosaraju {
        // Function to find number of strongly connected components in the graph.
        public void DFS(int i,boolean vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
            vis[i]=true;
            for(int v:adj.get(i)){
                if(!vis[v]){
                    DFS(v,vis,st,adj);
                }
            }
            st.push(i);
        }
        
        public void DFSReversed(int i,boolean vis[],ArrayList<ArrayList<Integer>> reversedGraph){
            vis[i]=true;
            for(int v:reversedGraph.get(i)){
                if(!vis[v]){
                    DFSReversed(v,vis,reversedGraph);
                }
            }
        }
        
        public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
            Stack<Integer> st = new Stack<>();
            int n = adj.size();
            boolean vis[] = new boolean[n];
            
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    DFS(i,vis,st,adj);
                }
            }
            
            ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
            for(int i=0;i<n;i++){
                vis[i]=false;
                reversedGraph.add(new ArrayList<>());
            } 
            for(int u=0;u<n;u++){
                for(int v:adj.get(u)){
                    reversedGraph.get(v).add(u);
                }
            }
            
            int cnt=0;
            
            while(!st.isEmpty()){
                int top = st.pop();
                if(!vis[top]){
                    DFSReversed(top,vis,reversedGraph);
                    cnt++;
                }
            }
            return  cnt;
        }
    }