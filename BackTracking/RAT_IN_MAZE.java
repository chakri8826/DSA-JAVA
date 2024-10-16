import java.util.*;
public class RAT_IN_MAZE {
    public static void DFS(int r, int c, int[][] mat, ArrayList<String> ans, StringBuilder curr) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != 1) {
            return;
        }
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            ans.add(curr.toString());
            return;
        }
        mat[r][c] = -1; // Mark the cell as visited
        // Explore in all four directions
        curr.append("D"); // Move Down
        DFS(r + 1, c, mat, ans, curr);
        curr.deleteCharAt(curr.length() - 1); // Backtrack

        curr.append("R"); // Move Right
        DFS(r, c + 1, mat, ans, curr);
        curr.deleteCharAt(curr.length() - 1); // Backtrack

        curr.append("U"); // Move Up
        DFS(r - 1, c, mat, ans, curr);
        curr.deleteCharAt(curr.length() - 1); // Backtrack

        curr.append("L"); // Move Left
        DFS(r, c - 1, mat, ans, curr);
        curr.deleteCharAt(curr.length() - 1); // Backtrack
        
        mat[r][c] = 1; // Unmark the cell as part of backtracking
    }

    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        if (mat[0][0] != 1) return ans;
        DFS(0, 0, mat, ans, new StringBuilder());
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        System.out.println(findPath(mat));
    }
}
