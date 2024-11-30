import java.util.List;

public class LC425 {
    //FIRST PROBLEM
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int mini = Integer.MAX_VALUE;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n && (j - i + 1) <= r; j++) {
                sum += nums.get(j);
                // Check if the subarray is of valid size and sum > 0.
                if (j - i + 1 >= l && sum > 0) {
                    mini = Math.min(mini, sum);
                }
            }
        }

        // Return -1 if no valid subarray is found.
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}
