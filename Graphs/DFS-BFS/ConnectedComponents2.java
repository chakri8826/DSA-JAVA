import java.util.*;

public class ConnectedComponents2{
    static int[] visited;
    static int[][] A;
    static int n; // Size of the matrix (number of nodes)

    public static void DFS(int i) {
        visited[i] = 1;
        for (int j = 0; j < n; j++) {
            if (A[i][j] == 1 && visited[j] == 0) {
                DFS(j);
            }
        }
    }

    public static int cc() {
        int count = 0;
        for (int v = 0; v < n; v++) {
            if (visited[v] == 0) {
                DFS(v);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the number of nodes
        System.out.print("Enter the number of nodes: ");
        n = scanner.nextInt();

        // Initialize the adjacency matrix and visited array
        A = new int[n][n];
        visited = new int[n];

        // Input for the adjacency matrix
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        // Output the number of connected components
        System.out.println("Number of connected components: " + cc());

        scanner.close();
    }
}
