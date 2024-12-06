public class A3ArrayIsSortedRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0; // to count the number of breakpoints
        
        for (int i = 0; i < n; i++) {
            // Compare current element with the next element (using modulo for wraparound)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            // If more than one breakpoint is found, return false
            if (count > 1) {
                return false;
            }
        }
        
        // If we exit the loop with at most one breakpoint, it is a valid sorted and rotated array
        return true;
    }
}

