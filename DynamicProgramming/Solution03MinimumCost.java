import java.util.*;
public class Solution03MinimumCost {
    //RECURSIVE
    // public static int mc(int k, int arr[],int ind){
    //     if(ind==0) return 0;
    //     int minCost = Integer.MAX_VALUE;
    //     for(int i=1;i<=k;i++){
    //         if(ind-i>=0){
    //             int newCost = mc(k,arr,ind-i)+ Math.abs(arr[ind] - arr[ind-i]);
    //             minCost=Math.min(minCost,newCost);
    //         }
    //     }
    //     return minCost;
    // }


    //MEMOIZATION
    // public static int mc(int k, int arr[],int ind,int dp[]){
    //     if(ind==0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int minCost = Integer.MAX_VALUE;
    //     for(int i=1;i<=k;i++){
    //         if(ind-i>=0){
    //             int newCost = mc(k,arr,ind-i,dp)+ Math.abs(arr[ind] - arr[ind-i]);
    //             minCost=Math.min(minCost,newCost);
    //         }
    //     }
    //     return dp[ind] = minCost;
    // }


    //TABULATION
    public static int mc(int k, int arr[],int dp[]){
        dp[0] = 0;
        for(int ind=1;ind<arr.length;ind++){
            int minCost = Integer.MAX_VALUE;
            for(int i=1;i<=k;i++){
                if(ind-i>=0){
                    int newCost = dp[ind-i]+ Math.abs(arr[ind] - arr[ind-i]);
                    minCost=Math.min(minCost,newCost);
                }
            }
            dp[ind]=minCost;
        }
        return dp[arr.length-1];
    }
    public static int minimizeCost(int k, int arr[]) {
        // int n= arr.length;
        // return mc(k,arr,n-1);
        
        // int n= arr.length;
        // int dp[] = new int[n];
        // Arrays.fill(dp,-1);
        // return mc(k, arr, n-1, dp);
        
        int n= arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return mc(k, arr, dp);
    }
    public static void main(String[] args) {
        int arr[] = {10, 30, 40, 50, 20};
        int k = 3;
        System.out.println(minimizeCost(k, arr));

    }
}


