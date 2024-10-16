import java.util.*;
public class RAT_IN_MAZE_OPTIMIZED {
    public static void DFS(int r, int c, int[][] mat, ArrayList<String> ans, StringBuilder curr,int di[],int dj[]) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != 1) {
            return;
        }
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            ans.add(curr.toString());
            return;
        }
        String dir = "DLRU";
        for(int ind=0;ind<4;ind++){
            int nextr = r+di[ind];
            int nextc = c+dj[ind];
            mat[r][c] = -1; // Mark the cell as visited
            DFS(nextr, nextc, mat, ans, curr.append(dir.charAt(ind)), di, dj);
            mat[r][c] = 1; // Unmark the cell as part of backtracking
            curr.deleteCharAt(curr.length() - 1);      //string builder kabatti maname delete cheyali to retail its previous state.
        }
    }

    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        if (mat[0][0] != 1) return ans;
        int di[] = {+1,0,0,-1};
        int dj[] = {0,-1,1,0};
        DFS(0, 0, mat, ans, new StringBuilder(),di,dj);
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
