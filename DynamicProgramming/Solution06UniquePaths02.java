public class Solution06UniquePaths02 {
    // public static int uniquePaths(int m, int n, int[][] obstacleGrid) {
    //     if(m==0 && n==0) return 1;
    //     if(m<0 || n<0 || obstacleGrid[m][n]==1) return 0;
    //     int le = uniquePaths(m, n-1, obstacleGrid);
    //     int up = uniquePaths(m-1, n, obstacleGrid);
    //     return le+up;
    // }

    // public static int uniquePaths(int m, int n, int dp[][], int[][] obstacleGrid) {
    //     if(m==0 && n==0) return 1;
    //     if(m<0 || n<0 || obstacleGrid[m][n]==1) return 0;
    //     if(dp[m][n]!=-1) return  dp[m][n];
    //     int le = uniquePaths(m, n-1, dp, obstacleGrid);
    //     int up = uniquePaths(m-1, n, dp, obstacleGrid);
    //     return dp[m][n] = le+up;
    // }

    // public static int uniquePaths(int m, int n, int dp[][], int[][] obstacleGrid) {
    //     if(m==0 && n==0) return 1;
    //     for(int i=0;i<=m;i++){
    //         for(int j=0;j<=n;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j] = 1;
    //                 continue;
    //             }
    //             if(obstacleGrid[i][j]==1){
    //                 dp[i][j] = 0;
    //                 continue;
    //             }
    //             int up=0;
    //             int le=0;
    //             if(i>0){
    //                 up = dp[i-1][j];
    //             }
    //             if(j>0){
    //                 le = dp[i][j-1];
    //             }
    //             dp[i][j] = up+le;
    //         }
    //     }
    //     return dp[m][n];
    // }
    public static int uniquePaths(int m, int n, int[][] obstacleGrid){
        int[] prev = new int[n];
        prev[0] = 1; // Starting point
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                prev[j] = 0; // Block the path if there's an obstacle
            } else {
                prev[j] = prev[j - 1]; // Can only come from the left
            }
        }
        for(int i=1;i<m;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    curr[j] = 0;
                    continue;
                }
                int up=0;
                int le=0;
                up = prev[j];
                if(j>0){
                    le = curr[j-1];
                }
                curr[j] = up+le;
            }
            prev=curr;
        }
        return prev[n-1];
    }

    

    public static void main(String[] args) {
        int obstacleGrid[][] = {{0,0,0},{0,1,0},{0,0,0}};
        int m =  obstacleGrid.length;
        int n =  obstacleGrid[0].length;
        // if(obstacleGrid[0][0]==1) return 0; 
        // int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        System.out.println(uniquePaths(m, n, obstacleGrid));
    }
}
