import java.util.*;

import javax.swing.undo.StateEdit;
public class GeekJump {
    //RECURSIVE APPROACH
    // public static int f(int ind,int arr[]){
    //     if(ind==0) return 0;
    //     int left = f(ind-1,arr)+Math.abs(arr[ind]-arr[ind-1]);
    //     int right = Integer.MAX_VALUE;
    //     if(ind>1) right=f(ind-2,arr)+Math.abs(arr[ind]-arr[ind-2]);
    //     return Math.min(left,right);
    // }

    //DP APPROACH --> MEMOIZATION
    // public static int f(int ind,int arr[],int dp[]){
    //     if(ind==0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int left = f(ind-1,arr,dp)+Math.abs(arr[ind]-arr[ind-1]);
    //     int right = Integer.MAX_VALUE;
    //     if(ind>1) right=f(ind-2,arr,dp)+Math.abs(arr[ind]-arr[ind-2]);
    //     return dp[ind] = Math.min(left,right);
    // }

    //DP APPROACH --> TABULATION
    // public static int f(int arr[],int dp[]){
    //     dp[0]=0;
    //     for(int i=1;i<arr.length;i++){
    //         int fs = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
    //         int ss = Integer.MAX_VALUE;
    //         if(i>1){
    //             ss = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
    //         }
    //         dp[i]=Math.min(fs,ss);
    //     }
    //     return dp[arr.length-1];
    // }

    //SPACE OPTIMIZATION
    public static int minimumEnergy(int arr[],int N){
        int prev=0,prev2=0,curr=0;
        for(int i=1;i<N;i++){
            int ls = prev+Math.abs(arr[i]-arr[i-1]);
            int rs = Integer.MAX_VALUE;
            if(i>1) rs=prev2+Math.abs(arr[i]-arr[i-2]);
            curr=Math.min(ls,rs);
            prev2=prev;
            prev=curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int arr[]={10 ,20, 30, 10};
        int n=4;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        //MEMO
        // System.out.println(f(n-1,arr,dp));
        // System.out.println(Arrays.toString(dp));
        
        //TABU
        // System.out.println(f(arr,dp));
        // System.out.println(Arrays.toString(dp));

        //SPACE OPTI
        System.out.println(minimumEnergy(arr, n));


    }
}

