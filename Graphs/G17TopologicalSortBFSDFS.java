import java.util.*;
import java.io.*; 

public class G17TopologicalSortBFSDFS {
    public static void DFS(int start, ArrayList<ArrayList<Integer>> edges, boolean[] vis, Stack<Integer> st) {
        vis[start] = true;
        for (int it : edges.get(start)) {
            if (!vis[it]) {
                DFS(it, edges, vis, st);
            }
        }
        st.push(start);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v2 = edge.get(1);
            adj.get(u).add(v2);  // u -> v2
        }

        // DFS
        // Stack<Integer> st = new Stack<>();
        // boolean[] vis = new boolean[v];

        // for (int i = 0; i < v; i++) {
        //     if (!vis[i]) {
        //         DFS(i, adj, vis, st);
        //     }
        // }

        // ArrayList<Integer> res = new ArrayList<>();
        // while (!st.isEmpty()) {
        //     res.add(st.pop());
        // }
        // return res;



        // BFS
        int inDeg[] = new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                inDeg[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
 
        for(int i=0;i<v;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
       
        while(!q.isEmpty()){
            int top = q.poll();
            res.add(top);
            for(int it:adj.get(top)){
                inDeg[it]--;
                if(inDeg[it]==0)q.offer(it);
            }
        }
 
        return res;
    }
}