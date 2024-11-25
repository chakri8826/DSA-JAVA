public class S6PartitionArrMaxSum {
     // public int f(int ind,int[] arr, int k,int dp[]){
    //     if(ind==arr.length) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int mxVal = 0;
    //     int larSum = 0; 
    //     for(int j=ind;j<arr.length && j<ind+k;j++){
    //        mxVal = Math.max(mxVal,arr[j]);
    //        int sum = mxVal*(j-ind+1) + f(j+1,arr,k,dp);
    //        larSum = Math.max(larSum,sum);
    //     }
    //     return dp[ind] = larSum;
    // }


    public int f(int n,int[] arr, int k,int dp[]){
        dp[n] = 0;
        for(int ind=n-1;ind>=0;ind--){
            int mxVal = 0;
            int larSum = 0; 
            for(int j=ind;j<arr.length && j<ind+k;j++){
                mxVal = Math.max(mxVal,arr[j]);
                int sum = mxVal*(j-ind+1) + dp[j+1];
                larSum = Math.max(larSum,sum);
            }
            dp[ind] = larSum;
        }
        return dp[0];  
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // int dp[] = new int[arr.length];
        // Arrays.fill(dp,-1);
        // return f(0,arr,k,dp);

        int dp[] = new int[arr.length+1];
        return f(arr.length,arr,k,dp);
    }
}
