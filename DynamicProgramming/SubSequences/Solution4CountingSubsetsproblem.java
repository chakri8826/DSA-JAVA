public class Solution4CountingSubsetsproblem {
    //NOT WORKS AS IT DOES NOT CARE ABOUT 0
    public static int count(int arr[], int sum, int ind) {
        if (sum == 0) return 1; // Found a valid subset
        if (ind == 0) {
            return arr[0] == sum?1:0;
        }
        int notpick = count(arr, sum, ind - 1); // Exclude the current index
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = count(arr, sum - arr[ind], ind - 1); // Include the current index
        }
        return pick + notpick; // Return total ways
    }


    //RECURSIVE APPROACH
    // public static int count(int arr[], int sum, int ind) {
    //     if (ind < 0) {
    //         return sum==0?1:0;
    //     }
    //     int notpick = count(arr, sum, ind - 1); // Exclude the current index
    //     int pick = 0;
    //     if (arr[ind] <= sum) {
    //         pick = count(arr, sum - arr[ind], ind - 1); // Include the current index
    //     }
    //     return pick + notpick; // Return total ways
    // }


    //ANOTHER APPROACH WITH MODIFIED BASE CASE WORKS SAME
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
    //     return pick + notpick; // Return total ways
    // }



    //Memoization
    // public int count(int arr[], int sum, int ind,int dp[][]) {
    //     if (ind == 0) {
    //         if(sum==0 && arr[0]==0)return 2;
    //         if(sum==0 || sum==arr[0]) return 1;
    //         return 0;
    //     }
    //     if(dp[ind][sum]!=-1) return dp[ind][sum];
    //     int notpick = count(arr, sum, ind - 1,dp)%mod; 
    //     int pick = 0;
    //     if (arr[ind] <= sum) {
    //         pick = count(arr, sum - arr[ind], ind - 1,dp)%mod;  
    //     }
    //     return dp[ind][sum] = (pick + notpick) % mod;  
    // }

    //Tabulation
    // public static int count(int arr[], int sum, int dp[][], int n) {
    //     if (arr[0] == 0) {
    //         dp[0][0] = 2;
    //     } else {
    //         dp[0][0] = 1;
    //     }
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
    //             dp[ind][tar] = (pick + notpick); // Update DP value for current index and target
    //         }
    //     }
    //     return dp[n - 1][sum];
    // }

    //Space Optimization
    // public static int count(int arr[], int sum,int n) {
    //     int prev[] = new int[sum+1];
    //     if (arr[0] == 0) {
    //         prev[0] = 2;
    //     } else {
    //         prev[0] = 1;
    //     }
    //     if (arr[0] != 0 && arr[0] <= sum) {
    //         prev[arr[0]] = 1;
    //     }
    //     for (int ind = 1; ind < n; ind++) {
    //         int curr[] = new int[sum+1];
    //         for (int tar = 0; tar <= sum; tar++) {
    //             int notpick = prev[tar]; // Exclude the current index
    //             int pick = 0;
    //             if (arr[ind] <= tar) {
    //                 pick = prev[tar - arr[ind]]; // Include the current index
    //             }
    //             curr[tar] = (pick + notpick) % mod; // Update DP value for current index and target
    //         }
    //         prev=curr;
    //     }
    
    //     return prev[sum];
    // }

    


    public static void main(String[] args) {
        // int arr[] = {9, 7, 0, 3, 9, 8};
        // int sum = 11;
        int arr[] = {0, 1};
        int sum = 1;
        System.out.println(count(arr,sum, 1));
    }
}

