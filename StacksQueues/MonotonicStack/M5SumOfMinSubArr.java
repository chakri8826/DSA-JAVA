class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;
        long sum = 0;

        // Generate all subarrays
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal,arr[j]);
                sum = (sum + minVal) % mod;
            }
        }
        return (int) sum;
    }
}
