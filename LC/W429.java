import java.util.Arrays;

public class W429 {
    //SECOND PROBLEM
    // BRUTE - TLE
    // public int maxDistinctElements(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     HashSet<Integer> set = new HashSet<>();
    //     int n = nums.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=-k;j<=k;j++){
    //             if(!set.contains(nums[i]+j)){
    //                 set.add(nums[i]+j);
    //                 break;
    //             }
    //         }
    //     }
    //     return set.size();
    // }


    // Optimised
     public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int nextAvailable = Integer.MIN_VALUE; 
        int count = 0;
        for (int num : nums) {
            int assign = Math.max(num - k, nextAvailable);
            if (assign <= num + k) {
                count++; // We successfully assign this number
                nextAvailable = assign + 1; // Update the next available value
            }
        }
        return count;
    }
}
