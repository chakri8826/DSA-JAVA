import java.util.Arrays;

class PartitionEqualToSum{
    public int getSum(int[] nums){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }


    public static boolean check(int arr[],int sum,boolean dp[][],int n){
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=sum;tar++){
                boolean nottake = dp[ind-1][tar];
                boolean  take =false;
                if (arr[ind] <= tar){ 
                    take = dp[ind-1][tar-arr[ind]];
                }
                dp[ind][tar] = nottake || take;
            }
        }
        return dp[n-1][sum];
    }



    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if(sum%2!=0) return false;
        int tar = sum/2;
        // return check(nums,tar,0,nums.length-1);


        // int dp[][] = new int[nums.length][sum];
        // for(int row[]:dp){
            //     Arrays.fill(row,-1);
            // }
            // return check(nums,tar,0,nums.length-1,dp);


        boolean dp[][] = new boolean[nums.length][sum];
        return check(nums,tar,dp,nums.length);
    }

    public static void main(String[] args) {
        
    }
}









