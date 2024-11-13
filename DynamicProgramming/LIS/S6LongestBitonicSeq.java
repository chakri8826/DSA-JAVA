import java.util.Arrays;

public class S6LongestBitonicSeq {
        public static int LongestBitonicSequence(int n, int[] nums) {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        // Calculate the longest increasing subsequence up to each index
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + dp1[j] > dp1[i]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }
        
        // Calculate the longest decreasing subsequence starting from each index
        for (int i = n - 2; i >= 0; i--) {  // Corrected to n-2
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }
        
        // Calculate the maximum bitonic sequence length
        int maxi = 0;
        for (int i = 1; i < n-1; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        
    }
}