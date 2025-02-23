class Solution {
    public int sumOfAllSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Generate all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0; // Running sum for subarrays starting at i
            for (int j = i; j < n; j++) {
                sum += arr[j]; // Extend the subarray to include arr[j]
                totalSum += sum;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(sol.sumOfAllSubarrays(arr)); // Output: 20
    }
}
