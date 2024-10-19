import java.util.*;
class Solution06UniquePaths{
    //RECURSIVE
    // public static int uniquePaths(int m, int n) {
    //     if(m==0 && n==0) return 1;
    //     if(m<0 || n<0) return 0;
    //     int le = uniquePaths(m, n-1);
    //     int up = uniquePaths(m-1, n);
    //     return le+up;
    // }

    //MEMOIZATION
    // public static int uniquePaths(int m, int n, int dp[][]) {
    //     if(m==0 && n==0) return 1;
    //     if(m<0 || n<0) return 0;
    //     if(dp[m][n]!=-1) return  dp[m][n];
    //     int le = uniquePaths(m, n-1, dp);
    //     int up = uniquePaths(m-1, n, dp);
    //     return dp[m][n] = le+up;
    // }


    //TABULATION
    // public static int uniquePaths(int m, int n, int dp[][]) {
    //     if(m==0 && n==0) return 1;
    //     for(int i=0;i<=m;i++){
    //         for(int j=0;j<=n;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j] = 1;
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

    //SPACE OPTIMIZATION
    public static int uniquePaths(int m, int n, int dp[][]) {
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            prev[i]=1;
        }
        for(int i=1;i<m;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
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
        int m=3,n=2;
        // System.out.println(uniquePaths(m-1,n-1));
        
        int dp[][] = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println(uniquePaths(m-1,n-1,dp));

        System.out.println(uniquePaths(m, n, dp));
    }
}
