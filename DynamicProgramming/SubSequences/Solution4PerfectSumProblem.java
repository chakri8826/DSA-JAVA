public class Solution4PerfectSumProblem {
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


    //Memoization
    // public int count(int arr[], int sum, int ind,int dp[][]) {
    //     if (ind < 0) {
    //         return sum==0?1:0;
    //     }
    //     if(dp[ind][sum]!=-1) return dp[ind][sum];
    //     int notpick = count(arr, sum, ind - 1,dp)%mod; 
    //     int pick = 0;
    //     if (arr[ind] <= sum) {
    //         pick = count(arr, sum - arr[ind], ind - 1,dp)%mod;  
    //     }
    //     return dp[ind][sum] = (pick + notpick) % mod;  
    // }

    


    public static void main(String[] args) {
        // int arr[] = {9, 7, 0, 3, 9, 8};
        // int sum = 11;
        int arr[] = {0, 1};
        int sum = 1;
        System.out.println(count(arr,sum, 1));
    }
}

