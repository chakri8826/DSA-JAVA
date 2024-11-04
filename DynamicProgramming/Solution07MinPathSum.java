import java.util.*;
class Solution07MinPathSum{
    // public int minPath(int m, int n, int[][] grid) {
    //     // Base cases
    //     if (m == 0 && n == 0) {
    //         return grid[0][0];
    //     }
    //     if (m < 0 || n < 0) {
    //         return Integer.MAX_VALUE;
    //     }

    //     // Recursive calculation: minimum path from left or up plus current cell value
    //     int left = minPath(m, n - 1, grid);
    //     int up = minPath(m - 1, n, grid);

    //     return grid[m][n] + Math.min(left, up);
    // }



    // public int minPath(int m, int n, int[][] grid, int dp[][]){
    //     if(m==0 && n==0){
    //         return grid[0][0];
    //     }
    //     if(m<0 || n<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[m][n]!=-1) return dp[m][n];
        // int le = minPath(m, n-1, grid, dp);
        // int up = minPath(m-1, n, grid, dp);

    //     return dp[m][n] =  grid[m][n] + Math.min(le,up);
    // }



    // public int minPath(int m, int n, int[][] grid, int[][] dp) {
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (i == 0 && j == 0) {
    //                 dp[i][j] = grid[0][0];
    //             } else {
    //                 int le = Integer.MAX_VALUE;
    //                 int up = Integer.MAX_VALUE;
    //                 if (i > 0) {
    //                     up = dp[i - 1][j];
    //                 }
    //                 if (j > 0) {
    //                     le = dp[i][j - 1];
    //                 }
    //                 dp[i][j] = grid[i][j] + Math.min(le, up);
    //             }
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }


    // static int minSumPath(int n, int m, int[][] matrix) {
    //     // Initialize an array to store the previous row values
    //     int prev[] = new int[m];

    //     for (int i = 0; i < n; i++) {
    //         // Create a temporary array to store the current row values
    //         int temp[] = new int[m];

    //         for (int j = 0; j < m; j++) {
    //             if (i == 0 && j == 0)
    //                 temp[j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is its value
    //             else {
    //                 int up = matrix[i][j];
    //                 if (i > 0)
    //                     up += prev[j]; // Add the value from above if it's not out of bounds
    //                 else
    //                     up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

    //                 int left = matrix[i][j];
    //                 if (j > 0)
    //                     left += temp[j - 1]; // Add the value from the left if it's not out of bounds
    //                 else
    //                     left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

    //                 // Store the minimum of the two possible paths in the current cell
    //                 temp[j] = Math.min(up, left);
    //             }
    //         }
    //         // Update the previous row with the values of the current row
    //         prev = temp;
    //     }

    //     // The final result is stored in the last element of the previous row
    //     return prev[m - 1];
    // }

    public int minPath(int m, int n, int[][] grid, int[][] dp) {
        int prev[] = new int[n];
        prev[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            prev[j] = prev[j - 1] + grid[0][j];
        }
        for (int i = 0; i < m; i++) {
                int curr[] = new int[n];
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        curr[j] = grid[0][0];
                    }
                    else {
                        int le = Integer.MAX_VALUE;
                        int up = Integer.MAX_VALUE;
                        if (i > 0) {
                            up = prev[j];
                        }
                        if (j > 0) {
                            le = curr[j-1];
                        }
                        curr[j]= grid[i][j] + Math.min(le, up);
                    }
                }
                prev=curr;
        }
        return prev[n-1];
    }




    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Start the recursion from the bottom-right corner
        // return minPath(m - 1, n - 1, grid);
        
        int dp[][]  =  new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return minPath(m - 1, n - 1, grid, dp);

        return minPath(m, n, grid, dp);
    }


    public static void main(String[] args) {
        Solution07MinPathSum s = new Solution07MinPathSum();
        int [][] grid= {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(s.minPathSum(grid));

    }
}
