import java.util.ArrayList;

public class G4Provisions {
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