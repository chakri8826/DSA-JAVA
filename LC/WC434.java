import java.util.*;
class WC434{
    class Solution {
    //BRUTE FORCE SOLUTION
    // public int maxFrequency(int[] nums, int k) {
    //     int n = nums.length;
    //     int maxFrequency = 0;

    //     // Iterate over all subarrays
    //     for (int i = 0; i<n; i++) {
    //         for(int j=i;j<n;j++){
    //             // Create a copy of the original array
    //             int[] temp = nums.clone();

    //             // Calculate the minimum x to make the subarray contain k
    //             int x = k - nums[i];

    //             // Add x to all elements in nums[i..j]
    //             for (int m = i; m<=j; m++) {
    //                 temp[m] += x;
    //             }

    //             // Count the frequency of k in the modified array
    //             int count = 0;
    //             for (int num : temp) {
    //                 if (num == k) count++;
    //             }

    //             maxFrequency = Math.max(maxFrequency, count);
    //         }
    //     }
    //     return maxFrequency;
    // }



    //ARYAN TEACHER'S IMPLEMENTATION
    // Helper method to calculate the maximum gain of converting elements to targetValue
    // private int calculateMaxGain(int[] nums, int targetValue, int k) {
    //     int maxGain = 0; // Track the maximum gain
    //     int currentGain = 0; // Track the current gain while iterating

    //     for (int num : nums) {
    //         if (num == k) currentGain--; // Decrease gain if the number is equal to k
    //         if (num == targetValue) currentGain++; // Increase gain if the number is equal to targetValue
    //         if (currentGain < 0) currentGain = 0; // Reset gain if it becomes negative
                //maxGain ni paivi check chesaka mathrame minus cheyali
    //         maxGain = Math.max(maxGain, currentGain); // Update the maximum gain
    //     }

    //     return maxGain; // Return the highest gain achieved
    // }

    // // Main method to find the maximum frequency
    // public int maxFrequency(int[] nums, int k) {
    //     // Create a frequency map to store the count of each number in nums
    //     HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    //     for (int num : nums) {
    //         frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    //     }

    //     int maxFrequency = 0; // Track the maximum frequency
    //     // Iterate through the unique keys (values) in the frequency map
    //     for (int value : frequencyMap.keySet()) {
    //         // Calculate the maximum gain for converting numbers to 'value'
    //         int maxGainForValue = calculateMaxGain(nums, value, k);
    //         // Update the maximum frequency
    //         maxFrequency = Math.max(maxFrequency, maxGainForValue);
    //     }

    //     // Return the frequency of k plus the maximum gain calculated
    //     return frequencyMap.getOrDefault(k, 0) + maxFrequency;
    // }













    //CHAKRI'S IMPLEMENTATION
        public int calculate(int[] nums,int tar, int k){
            int curr=0,maxi=0;
            for(int num:nums){
                if(num==tar) curr++;
                if(num==k)curr--;
                //maxGain ni paivi check chesaka mathrame minus cheyali
                maxi=Math.max(maxi,curr);
                if(curr<0)curr=0;
            }
            return maxi;
        }

        public int maxFrequency(int[] nums, int k) {
            int maxi = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }

            for(int key:map.keySet()){
                int currTarVal = calculate(nums,key,k);
                maxi=Math.max(maxi,currTarVal);
            }
            return map.getOrDefault(k,0)+maxi;
        }
    }

}