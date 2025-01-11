import java.util.*;
public class Solution04HOUSE_ROBBER {
    //recursive 
    // public static int rob(int[] nums,int ind) {
    //     if(ind==0) return  nums[ind];
    //     if(ind<0) return 0;
    //     int le = nums[ind]+rob(nums,ind-2);
    //     int ri = rob(nums,ind-1);
    //     return Math.max(le,ri);
    // }

    
    //Memoization
    // public static int rob(int[] nums,int ind,int dp[]) {
    //     if(ind==0) return  nums[ind];
    //     if(ind<0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int le = nums[ind]+rob(nums,ind-2,dp);
    //     int ri = rob(nums,ind-1,dp);
    //     return dp[ind] = Math.max(le,ri);
    // }

    //Tabulation
    // public static int rob(int[] nums,int dp[]) {
    //     dp[0]=nums[0];
    //     if (nums.length == 2) return Math.max(nums[0], nums[1]);
    //     for(int i=1;i<nums.length;i++){
    //         int le = nums[i];
    //         if(i>1) {
    //             le += dp[i-2];
    //         }
    //         int ri = dp[i-1];
    //         dp[i] = Math.max(le,ri);
    //     }
    //     return dp[nums.length-1];
    // }

    //Space Optimization
    public static int rob(int[] nums){
        int prev=nums[0],prev2=0;
        for(int i=1;i<nums.length;i++){
            int le = nums[i];
            if(i>1)
                le+=prev2;
            int ri = prev;
            int curr = Math.max(le,ri);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {

        int nums[] = {1,2,3,1};
        int n = nums.length;
        
        // System.out.println(rob(nums,n-1));


        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        // System.out.println(rob(nums,n-1,dp));

        // System.out.println(rob(nums, dp));


        System.out.println(rob(nums));
    }
}
