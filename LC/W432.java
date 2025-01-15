import java.util.Arrays;

public class W432 {
    public static int f(int i,int j,int p,int m,int n,int[][] coins,int dp[][][]){
        if (i == 0 && j == 0) {
            if (p > 0 && coins[i][j] < 0) return 0;
            else return coins[i][j];
        }
        if(i<0 || j<0) return  Integer.MIN_VALUE;
        if(dp[i][j][p]!=-1) return dp[i][j][p];
        int take = Integer.MIN_VALUE;
        int nottake = Integer.MIN_VALUE;
        
        take = coins[i][j] + Math.max(f(i-1,j,p,m,n,coins,dp), f(i,j-1,p,m,n,coins,dp));
        if(coins[i][j]<0 && p>0){
            nottake = Math.max(f(i-1,j,p-1,m,n,coins,dp), f(i,j-1,p-1,m,n,coins,dp));
        }

        return dp[i][j][p]=Math.max(take,nottake);
    }

    public static void main(String[] args) {
        int [][] coins = {{-16,8,-7,-19},{6,3,-10,13},{13,15,4,-3},{-16,4,19,-12}};
        int m = coins.length;
        int n = coins[0].length;
        int dp[][][] = new int[m][n][3];
        for(int [][] layer:dp){
            for(int []row:layer){
                Arrays.fill(row,-1);
            }
        }
        System.out.println(f(m-1,n-1,2,m,n,coins,dp));
    }
}
