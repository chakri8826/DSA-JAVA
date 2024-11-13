import java.util.*;
public class S7NumOfLIS {
    static int findNumberOfLIS(int[] arr){

        int n = arr.length;
        
        int[] dp= new int[n];
        int[] ct= new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(ct,1);
        
        int maxi = 1;
        
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                
                if(arr[prev_index]<arr[i] && dp[prev_index]+1>dp[i]){
                    dp[i] = dp[prev_index]+1;
                    //inherit
                    ct[i] = ct[prev_index];
                }
                else if(arr[prev_index]<arr[i] && dp[prev_index]+1==dp[i]){
                    //increase the count
                    ct[i] = ct[i] + ct[prev_index];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(ct));
        int nos =0;
        
        for(int i=0; i<=n-1; i++){
            if(dp[i]==maxi){
                nos+=ct[i];
            }
        }
        
        return nos;
    }

    public static void main(String args[]) {
        
        // int[] arr = {1,5,4,3,2,6,7,10,8,9};
        // int[] arr = {1,3,5,4,7};
        int[] arr = {100,90,80,70,60,50,60,70,80,90,100};
        
        System.out.println("The count of LIS is "+findNumberOfLIS(arr));
        
    }
}