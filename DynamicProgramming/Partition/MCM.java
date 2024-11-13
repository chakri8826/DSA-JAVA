package Partition;

import java.util.Arrays;

public class MCM {
    // static int f(int i,int j,int arr[],int dp[][]){
    //     if(i==j) return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     int mini=Integer.MAX_VALUE; 
    //     for(int k=i;k<j;k++){
    //         int steps = arr[i-1]*arr[k]*arr[j] + f(i,k,arr,dp) + f(k+1,j,arr,dp);
    //         mini = Math.min(mini,steps);
    //     }
    //     return dp[i][j] = mini;
    // }

    //Tabulation
    static int f(int n,int arr[],int dp[][]){
        //REDUNDANT
        for(int i=1;i<n;i++){
            dp[i][i]=0;
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int mini=Integer.MAX_VALUE; 
                for(int k=i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini,steps);
                }
                dp[i][j] = mini;
            }
        }
    
        return dp[1][n-1];
    }
    static int matrixMultiplication(int N, int arr[])
    {
        //  return f(1,N-1,arr);


        // int dp[][] = new int[N][N];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(1,N-1,arr,dp);


        int dp[][] = new int[N][N];
        return f(N,arr,dp);
    }
}
