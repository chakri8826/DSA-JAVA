import java.util.ArrayList;

public class G4Provisions {
    // BFS APPROACH
    // int findCircleNum(int[][] isConnected) {
    //     int n = isConnected.length;
    //     boolean[] visited = new boolean[n];
    //     int provinces = 0;
    
    //     for (int i = 0; i < n; i++) {
    //         if (!visited[i]) {
    //             bfs(i, isConnected, visited);
    //             provinces++; // new province found
    //         }
    //     }
    //     return provinces;
    // }
    
    // void bfs(int start, int[][] isConnected, boolean[] visited) {
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(start);
    //     visited[start] = true;
    
    //     while (!q.isEmpty()) {
    //         int city = q.poll();
    //         for (int j = 0; j < isConnected.length; j++) {
    //             if (isConnected[city][j] == 1 && !visited[j]) {
    //                 visited[j] = true;
    //                 q.add(j);
    //             }
    //         }
    //     }
    // }

    // DFS APPROACH
    public void DFS(int val,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[val]=true;
        for(int it:adj.get(val)){
            if(!vis[it]){
                DFS(it,vis,adj);
            }
        }
    }
    public int findCircleNum( ArrayList<ArrayList<Integer>> adjList ) {
        int cnt=0;
        boolean vis[] = new boolean[adjList.size()];
        for(int v=0;v<adjList.size();v++){
            if(!vis[v]){
                DFS(v,vis,adjList);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] adjMatrix = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}   
        };
        int n = adjMatrix.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill list from matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        G4Provisions g = new G4Provisions();
        int result = g.findCircleNum(adjList);
        System.out.println(result); // Output: 2
    }
}