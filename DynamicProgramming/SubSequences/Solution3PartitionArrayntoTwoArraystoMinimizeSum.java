//IT WORKS FOR ONLY POSITIVE VALUES 
class Solution3PartitionArrayntoTwoArraystoMinimizeSum{
//     public int getSum(int[] nums){
//         int sum=0;
//         for(int num:nums){
//             sum+=num;
//         }
//         return sum;
//     }

    // public static void check(int arr[],int sum,boolean dp[][],int n){
    //     for(int i=0;i<n;i++) dp[i][0] = true;
    //     if(arr[0]<=sum  ) dp[0][arr[0]] = true;
    //     for(int ind = 1; ind<n;ind++){
    //         for(int tar=1;tar<=sum;tar++){
    //             boolean nottake = dp[ind-1][tar];
    //             boolean  take =false;
    //             if (arr[ind] <= tar){ 
    //                 take = dp[ind-1][tar-arr[ind]];
    //             }
    //             dp[ind][tar] = nottake || take;
    //         }
    //     }
    // }
 
//     public int minimumDifference(int[] nums) {
//         int n = nums.length;
//         int sum = getSum(nums);
//         boolean dp[][] = new boolean[n][sum+1];
//         check(nums,sum,dp,n);
//         int mini =Integer.MAX_VALUE;
//         for(int i=0;i<sum;i++){
//             if(dp[n-1][i]){
//                 int s1 = i;
//                 int s2 = sum-s1;
//                 mini = Math.min(mini,Math.abs(s2-s1));
//             }
//         }
//         return mini;
//     }
// }
}