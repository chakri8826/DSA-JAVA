import java.util.*;
class MaxMoves {
    public int fun(int row,int col, int[][] grid, int m, int n,int dp[][]){
        if(row>=m || col>=n || row<0) return 0;
        // int up = Integer.MIN_VALUE;
        // int st = Integer.MIN_VALUE;
        // int down = Integer.MIN_VALUE;
        if(dp[row][col]!=-1) return dp[row][col];
        int up = 0;
        int st = 0;
        int down = 0;
        if(row-1>=0 && col+1<n){
            if(grid[row-1][col+1]>grid[row][col]){
                up = 1+fun(row-1,col+1,grid,m,n,dp);
            }
        }
        if(col+1<n){
            if(grid[row][col+1]>grid[row][col]){
                st = 1+fun(row,col+1,grid,m,n,dp);
            }
        }
        if(row+1<m && col+1<n){
            if(grid[row+1][col+1]>grid[row][col]){
                down = 1+fun(row+1,col+1,grid,m,n,dp);
            }
        }
        return dp[row][col] = Math.max(Math.max(up,st),down);
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxi = 0;
        int dp[][] = new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;i++){
            maxi = Math.max(maxi,fun(i,0,grid,m,n,dp));
        }
        return maxi;
    }
}
