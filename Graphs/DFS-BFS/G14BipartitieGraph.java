import java.util.*;

public class G14BipartitieGraph {

    // BFS
    // public boolean check(int start,ArrayList<ArrayList<Integer>> li,int vis[]){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(start);
    //     vis[start]=0;
    //     while(!q.isEmpty()){
    //         int node = q.poll();
    //         for(int it:li.get(node)){
    //             if(vis[it]==-1){
    //                 vis[it] = 1-vis[node];
    //                 q.offer(it);
    //             }
    //             else if(vis[it]==vis[node])return false;
    //         }
    //     }
    //     return true;
    // } 
     

     // DFS
    public boolean DFS(int start,int col,ArrayList<ArrayList<Integer>> li,int vis[]){
        vis[start]=col;
        for(int it:li.get(start)){
            if(vis[it]==-1){
                if(DFS(it,1-col,li,vis)==false)return false;
            }
            else if(vis[start]==vis[it])return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<Integer>());
        } 
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                li.get(i).add(graph[i][j]);
            }
        }
        int vis[] = new int[n];
        Arrays.fill(vis,-1);

        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(check(i,li,vis)==false)return false;
                // if(DFS(i,0,li,vis)==false)return false;
            }
        }
        System.out.println(Arrays.toString(vis));
        return true;
    }
 
    public static void main(String[] args) {
        G14BipartitieGraph g = new G14BipartitieGraph();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(g.isBipartite(graph));
    }
}
