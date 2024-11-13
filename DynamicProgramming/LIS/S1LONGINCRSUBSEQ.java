import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class S1LONGINCRSUBSEQ {
    // public int maxLen(int ind,int prev,int[] nums){
    //     if(ind==nums.length) return 0;
    //     int notTake = maxLen(ind+1,prev,nums);
    //     int take = 0;
    //     if(prev==-1 || nums[ind]>nums[prev]){
    //         take = 1 + maxLen(ind+1,ind,nums); 
    //     }
    //     return Math.max(notTake,take);
    // }


    // public int maxLen(int ind,int prev,int[] nums,int dp[][]){
    //     if(ind==nums.length) return 0;
    //     if(dp[ind][prev+1]!=-1 && prev!=-1)return dp[ind][prev+1];
    //     int notTake = maxLen(ind+1,prev,nums,dp);
    //     int take = 0;
    //     if(prev==-1 || nums[ind]>nums[prev]){
    //         take = 1 + maxLen(ind+1,ind,nums,dp); 
    //     }
    //     return dp[ind][prev+1] = Math.max(notTake,take);
    // }


    // public int maxLen(int n,int[] nums,int dp[][]){
    //     for(int ind=n-1;ind>=0;ind--){
    //         for(int prev=ind-1;prev>=-1;prev--){
    //             int notTake =dp[ind+1][prev+1];
    //             int take = 0;
    //             if(prev==-1 || nums[ind]>nums[prev]){
    //                 take = 1 + dp[ind+1][ind+1]; 
    //             }
    //             dp[ind][prev+1] = Math.max(notTake,take);
    //         }
    //     }
    //     return dp[0][0];
    // }


    // public int maxLen(int n,int[] nums){
    //     int front[] = new int[n+1];
    //     for(int ind=n-1;ind>=0;ind--){
    //         int curr[] = new int[n+1];
    //         for(int prev=ind-1;prev>=-1;prev--){
    //             int notTake =front[prev+1];
    //             int take = 0;
    //             if(prev==-1 || nums[ind]>nums[prev]){
    //                 take = 1 + front[ind+1]; 
    //             }
    //             curr[prev+1] = Math.max(notTake,take);
    //         }
    //         front=curr;
    //     }
    //     return front[0];
    // }


    //NEW TABU
    // public int maxLen(int n,int[] nums){
    //     int dp[] = new int[n];
    //     Arrays.fill(dp,1);
    //     int maxi=1;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(nums[j]<nums[i]){
    //                 dp[i] = Math.max(1+dp[j],dp[i]);
    //             }
    //         }
    //         maxi = Math.max(maxi,dp[i]);
    //     }
    //     return maxi;
    // }


    //PRINTING LIS
    public static void maxLen(int n,int[] nums){
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp,1);
        int maxi=1,lastInd=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i] =  1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastInd=i;
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        li.add(nums[lastInd]);
        while(hash[lastInd]!=lastInd){
            lastInd = hash[lastInd];
            li.add(nums[lastInd]);
        }
        Collections.reverse(li);
        System.out.println(li);
    }



    // public int lengthOfLIS(int[] nums){
        // return maxLen(0,-1,nums);

        // int dp[][] = new int[nums.length][nums.length];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return maxLen(0,-1,nums,dp);


        // int dp[][] = new int[nums.length+1][nums.length+1];
        // return maxLen(nums.length,nums,dp);


        // return maxLen(nums.length,nums);
    // }
    public static void main(String[] args) {
        int nums[] = {5,4,11,1,16,8};
        maxLen(nums.length, nums); 
    }
}
