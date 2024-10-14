public class GeekJumpChakri {
     public static int mE(int arr[], int N, int i, int curr, int res) {
        if (i == N - 1) {
            return Math.min(res, curr);
        }
        for (int j = i + 1; j <= i + 2 && j < N; j++) {
            curr += Math.abs(arr[j] - arr[i]); // Add the cost to move to the next position
            res = mE(arr, N, j, curr, res); // Recursive call to the next position
            curr -= Math.abs(arr[j] - arr[i]); // Backtrack the accumulated cost
        }
 
        return res;
    }

    //     public int mE(int arr[], int N, int i, int curr, int dp[]) {
    //     // If we reached the last index, return the current accumulated cost
    //     if (i == N - 1) {
    //         return curr;
    //     }
    //     // If this state has been calculated before, return its value
    //     if (dp[i] != -1) {
    //         return dp[i];
    //     }

    //     int minCost = Integer.MAX_VALUE;
    //     // Try to move from i to i+1 and i+2, considering the array boundaries
    //     for (int j = i + 1; j <= i + 2 && j < N; j++) {
    //         int newCost = curr + Math.abs(arr[j] - arr[i]); // Calculate the cost for the next step
    //         minCost = Math.min(minCost, mE(arr, N, j, newCost, dp)); // Recur to find the minimum cost
    //     }
    //     // Store the minimum result in dp[i]
    //     dp[i] = minCost;
    //     return minCost;
    // }
    public static void main(String[] args) {
        int arr[]={10 ,20, 30, 10};
        int n=4;
        int res=Integer.MAX_VALUE;
        System.out.println(mE(arr,n,0,0,res));
    }
}
