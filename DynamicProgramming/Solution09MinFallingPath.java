import java.util.*;
public class Solution09MinFallingPath {
    // public int paths(int[][] matrix,int row,int col,int n){
    //     if(col<0) return 10000;
    //     if(col>n-1) return 10000
    //     if(row==n-1) return matrix[n-1][col];
    //     int d = matrix[row][col] + paths(matrix,row+1,col,n);
    //     int le = matrix[row][col] + paths(matrix,row+1,col-1,n);
    //     int ri = matrix[row][col] + paths(matrix,row+1,col+1,n);
    //     return Math.min(Math.min(d,le),ri);
    // }


    // public int paths(int[][] matrix,int row,int col,int n,int dp[][]){
    //     if(col<0) return 10000;
    //     if(col>n-1) return 10000;
    //     if(row==n-1) return matrix[n-1][col];
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int d = matrix[row][col] + paths(matrix,row+1,col,n,dp);
    //     int le = matrix[row][col] + paths(matrix,row+1,col-1,n,dp);
    //     int ri = matrix[row][col] + paths(matrix,row+1,col+1,n,dp);
    //     return dp[row][col]=Math.min(Math.min(d,le),ri);
    // }


    // public int paths(int[][] matrix,int n,int dp[][]){
    //     for(int i=0;i<n;i++){
    //         dp[n-1][i]=matrix[n-1][i];
    //     }
    //     for(int row=n-2;row>=0;row--){
    //         for(int col=n-1;col>=0;col--){
    //                 int d = matrix[row][col] +  dp[row+1][col];
    //                 int le = (col-1 >= 0) ? matrix[row][col] + dp[row + 1][col - 1] : Integer.MAX_VALUE;
    //                 int ri = (col +1< n) ? matrix[row][col] + dp[row + 1][col + 1] : Integer.MAX_VALUE;
    //                 dp[row][col]=Math.min(Math.min(d,le),ri);
    //         }
    //     }
    //     int minsum = Integer.MAX_VALUE;
    //     for(int i=0;i<n;i++){
    //         minsum = Math.min(minsum,dp[0][i]);
    //     }
    //     return minsum;
    // }


    public int paths(int[][] matrix,int n){
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            prev[i]=matrix[n-1][i];
        }
        for(int row=n-2;row>=0;row--){
            int curr[] = new int[n];
            for(int col=n-1;col>=0;col--){
                    int d = matrix[row][col] +  prev[col];
                    int le = (col-1 >= 0) ? matrix[row][col] + prev[col - 1] : Integer.MAX_VALUE;
                    int ri = (col +1< n) ? matrix[row][col] + prev[col + 1] : Integer.MAX_VALUE;
                    curr[col]=Math.min(Math.min(d,le),ri);
            }
            prev=curr;
        }
        int minsum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minsum = Math.min(minsum,prev[i]);
        }
        return minsum;
    }




    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // int minsum=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     minsum = Math.min(minsum,paths(matrix,0,i,n));
        // }
        // return minsum;


        // int dp[][] = new int[n][n];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // for(int i=0;i<n;i++){
        //     minsum = Math.min(minsum,paths(matrix,0,i,n,dp));
        // }
        // return minsum;

        

        // int dp[][] = new int[n][n];
        // return paths(matrix, n, dp);


        return paths(matrix,n);



    }
    public static void main(String[] args) {
        Solution09MinFallingPath sol = new Solution09MinFallingPath();
        int matrix[][] =  {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(sol.minFallingPathSum(matrix));
    }
}
