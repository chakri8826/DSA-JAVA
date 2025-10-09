import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class G16EventualSafeStates {
    public boolean DFS(int start,ArrayList<ArrayList<Integer>> li,int vis[],int preVis[],int check[] ){
        vis[start]=1;
        preVis[start]=1;
        check[start]=0;
        for(int it:li.get(start)){
            if(vis[it]==0){
                if(DFS(it,li,vis,preVis,check))return true;
            }
            else if(preVis[it]==1)return true;
        }
        check[start]=1;
        preVis[start]=0;
        return false;
    } 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // DFS
        // List<Integer> res = new ArrayList<>();
        // int n = graph.length;
        // ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     li.add(new ArrayList<Integer>());
        // } 
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<graph[i].length;j++){
        //         li.get(i).add(graph[i][j]);
        //     }
        // }


        // int vis[] = new int[n];
        // int preVis[] = new int[n];
        // int check[] = new int[n];
        // for(int i=0;i<n;i++){
        //     if(vis[i]==0){
        //         DFS(i,li,vis,preVis,check);
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     if(check[i]==1){
        //         res.add(i);
        //     }
        // }
        // return res;


        // BFS
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new ArrayList<Integer>());
        } 
        int inDeg[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                li.get(graph[i][j]).add(i);
                inDeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int top = q.poll();
            res.add(top);
            for(int it:li.get(top)){
                inDeg[it]--;
                if(inDeg[it]==0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(res);         
        return res;
    }
}