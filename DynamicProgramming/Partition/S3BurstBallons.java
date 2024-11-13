public class S3BurstBallons {
     // public int f(int i,int j,int allNums[]){
    //     if(i>j) return 0;
    //     int maxi = Integer.MIN_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int coins = allNums[i-1]*allNums[k]*allNums[j+1] + f(i,k-1,allNums) + f(k+1,j,allNums);
    //         maxi = Math.max(maxi,coins);
    //     }
    //     return maxi;
    // }


    // public int f(int i,int j,int allNums[], int[][] dp){
    //     if(i>j) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int maxi=Integer.MIN_VALUE;
    //     for(int ind=i;ind<=j;ind++){
    //         int cost = allNums[i-1]*allNums[ind]*allNums[j+1] + f(i,ind-1,allNums,dp) + f(ind+1, j,allNums,dp);
    //         maxi = Math.max(maxi,cost); 
    //     }
    //     return dp[i][j] = maxi;
    // }


    public int f(int n,int allNums[], int[][] dp){
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                int maxi=Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = allNums[i-1]*allNums[ind]*allNums[j+1] + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi,cost); 
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }



    public int maxCoins(int[] nums) {
        int allNums[] = new int[nums.length+2];
        allNums[0] = 1;
        allNums[allNums.length-1] = 1;
        for(int i=0;i<nums.length;i++){
            allNums[i+1] = nums[i];
        }

        // return f(1,nums.length,allNums);


        // int[][] dp = new int[nums.length+1][nums.length+1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return f(1, nums.length, allNums, dp);


        int[][] dp = new int[nums.length+2][nums.length+2];
        return f(nums.length, allNums, dp);
    }
}
