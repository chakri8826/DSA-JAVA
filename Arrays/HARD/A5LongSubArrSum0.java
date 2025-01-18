import java.util.HashMap;

public class A5LongSubArrSum0 {
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
            long psum = 0; // Variable to store the prefix sum
            int maxlen = 0; // Variable to store the maximum length of the subarray
            int n = arr.length; // Length of the array

            // HashMap to store the first occurrence of each prefix sum
            HashMap<Long, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                psum += arr[i]; // Update the prefix sum
                if (psum == 0) {
                    maxlen = Math.max(maxlen, i + 1);
                }

                if (map.containsKey(psum)) {
                    maxlen = Math.max(maxlen, i - map.get(psum));
                } 

                else{
                    map.put(psum,i);
                } 
            }

            return maxlen; // Return the maximum length
        }
    
}



