public class Solution5GivenDifference {
    static int mod = (int) 1e9 + 7;
    public static int getSum(int[] nums){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
    // public static int count(int arr[], int sum, int ind) {
    //     if (ind == 0) {
    //         if(sum==0 && arr[0]==0)return 2;
    //         if(sum==0 || sum==arr[0]) return 1;
    //         return 0;
    //     }
    //     int notpick = count(arr, sum, ind - 1); // Exclude the current index
    //     int pick = 0;
    //     if (arr[ind] <= sum) {
    //         pick = count(arr, sum - arr[ind], ind - 1); // Include the current index
    //     }
    //     return (pick + notpick)% mod; // Return total ways
    // }


    // public static int count(int arr[], int sum, int ind,int dp[][]) {
    //     if (ind == 0) {
    //         if(sum==0 && arr[0]==0)return 2;
    //         if(sum==0 || sum==arr[0]) return 1;
    //         return 0;
    //     }
    //     if(dp[ind][sum]!=-1) return dp[ind][sum];
    //     int notpick = count(arr, sum, ind - 1, dp); // Exclude the current index
    //     int pick = 0;
    //     if (arr[ind] <= sum) {
    //         pick = count(arr, sum - arr[ind], ind - 1 , dp); // Include the current index
    //     }
    //     return dp[ind][sum] = (pick + notpick)% mod; // Return total ways
    // }


    // public static int count(int arr[], int sum, int dp[][], int n) {
    //     if (arr[0] == 0) {
    //         dp[0][0] = 2;
    //     } else {
    //         dp[0][0] = 1;
    //     }
    //     //checking arr[0] is not 0, becoz if 0 it may over write 2 as we written 1st case as 2 for arr[0] =0;
    //     if (arr[0] != 0 && arr[0] <= sum) {
    //         dp[0][arr[0]] = 1;
    //     }
    //     for (int ind = 1; ind < n; ind++) {
    //         for (int tar = 0; tar <= sum; tar++) {
    //             int notpick = dp[ind - 1][tar]; // Exclude the current index
    //             int pick = 0;
    //             if (arr[ind] <= tar) {
    //                 pick = dp[ind - 1][tar - arr[ind]]; // Include the current index
    //             }
    //             dp[ind][tar] = (pick + notpick) % mod; // Update DP value for current index and target
    //         }
    //     }
    //     return dp[n - 1][sum];
    // }


    public static int count(int arr[], int sum,int n) {
        int prev[] = new int[sum+1];
        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }
        if (arr[0] != 0 && arr[0] <= sum) {
            prev[arr[0]] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            int curr[] = new int[sum+1];
            for (int tar = 0; tar <= sum; tar++) {
                int notpick = prev[tar]; // Exclude the current index
                int pick = 0;
                if (arr[ind] <= tar) {
                    pick = prev[tar - arr[ind]]; // Include the current index
                }
                curr[tar] = (pick + notpick) % mod; // Update DP value for current index and target
            }
            prev=curr;
        }
    
        return prev[sum];
    }




    public static int countPartitions(int n, int d, int[] arr) {
        int sum = getSum(arr);
        if(sum-d<0 || (sum-d)%2==1){
            return 0;
        }
        // int dp[][] = new int[n][sum+1];
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return count(arr, (sum-d)/2,n-1,dp);
        
        
        // int dp[][] = new int[n][sum+1];
        // return count(arr,(sum-d)/2,dp,n);
        
        
        return count(arr,(sum-d)/2,n);        
    }
    public static void main(String[] args) {
        
    }
}
