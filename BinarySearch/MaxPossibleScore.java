import java.util.*;
class MaxPossibleScore {
    public boolean ifPossible(int[] start, int d, long m, long p) {
        for (int i = 1; i < start.length; i++) {
                if (p + m >= start[i] && p + m <= start[i] + d) {
                    // If we can pick a number from this interval such that the difference is at least `m`, pick it.
                    p += m;
                } else if (p + m < start[i]) {
                    // If the current difference is too small, reset `p` to the start of the new interval.
                    p = start[i];
                } else {
                    // If it's impossible to maintain a difference of `m`, break.
                    return false;
                }
            }
            return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);  // Sort the `start` array.
        long l = 0, r = start[start.length - 1] + d;  // `l` and `r` define the range for binary search.
        int ans = 0;  // This will store the result (maximum possible score).

        while (l <= r) {
            long m = (l + r) / 2;  // Find the mid-point of the current range.
            long p = start[0];  // Pick the first number from the first interval.
             // A flag to track if we can pick all numbers with a difference of at least `m`.

            // Try to choose numbers from the intervals.
            

            // If we managed to choose all numbers with a minimum difference of `m`, update the answer.
            if (ifPossible(start,d,m,p)) {
                ans = (int) m;
                l = m + 1;  // Try for a larger `m` (to maximize the score).
            } else {
                r = m - 1;  // Reduce the search range.
            }
        }
        return ans;
    }
}




