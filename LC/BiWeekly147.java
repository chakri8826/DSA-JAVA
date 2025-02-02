public class BiWeekly147 {
    // SECOND PROBLEM
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gap = new int[n + 1];

        // Calculate gaps
        gap[0] = startTime[0];  // Before the first event
        for (int i = 1; i < n; ++i) {
            gap[i] = startTime[i] - endTime[i - 1];  // Between events
        }
        gap[n] = eventTime - endTime[n - 1];  // After the last event

        int ans = 0, sum = 0;
        int windowSize = k + 1;  // We can consider up to k+1 consecutive gaps

        // Sliding window
        for (int i = 0; i < gap.length; ++i) {
            sum += gap[i];
            if (i >= windowSize) {
                sum -= gap[i - windowSize];  // Remove the gap that's out of the window
            }
            ans = Math.max(ans, sum);  // Update maximum free time
        }
        return ans;
    }
}
