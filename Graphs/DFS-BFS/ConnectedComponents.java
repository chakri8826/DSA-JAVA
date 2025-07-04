import java.util.*;

public class ConnectedComponents {
    static int[] visited = new int[9];
    static int[][] A = {
        {0, 1, 0, 1, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 0, 1}, 
        {0, 0, 0, 0, 0, 0, 1, 1, 0}
    };
    
    public static int cc() {
        int count = 0;
        for (int v = 0; v < 9; v++) {
            if (visited[v] == 0) {
                DFS(v);
                count++;
            }
        }
        return count;
    }

    public static void DFS(int i) {
        visited[i] = 1;
        for (int j = 0; j < 9; j++) {
            if (A[i][j] == 1 && visited[j] == 0) {
                DFS(j);
            }
        }
    }
    

    public static void main(String[] args) {
        System.out.println("Number of connected components: " + cc());
    }
}
