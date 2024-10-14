// package DynamicProgramming;
import java.util.*;
public class MatrixChainMultiplication {
    //RECURSIVE APPROACH IN OVERLAPPING OF SUBPROBLEMS OCCUR
    public static int mm(int arr[],int i,int j){
        int res = Integer.MAX_VALUE;
        if(i+1==j) return 0;
        for(int k=i+1;k<j;k++){
            res = Math.min(res,mm(arr,i,k)+mm(arr,k,j)+arr[i]*arr[k]*arr[j]);
        }
        return res;
    }
    
    //DP APPROACH
    public static int mchain(int arr[],int n){
        int dp[][] = new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i+1]=0;
        }
        for(int gap=2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        return dp[0][n-1];
    }

    //1-index
    public static int mchain1(int arr[],int n){
        int dp[][] = new int[n][n];
        for(int i=1;i<n;i++){
            dp[i][i]=0;
        }
        for(int gap=1;gap<n;gap++){
            for(int i=1;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j]);
                }
            }
        }
        return dp[1][n-1];
    }

    static int matrixMultiplication(int N, int arr[]){
            return mm(arr,0,N-1);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        int n = arr.length;
        // System.out.println(matrixMultiplication(n,arr));
        // System.out.println(mchain(arr, n));
        System.out.println(mchain1(arr, n));
    }
}
