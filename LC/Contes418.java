import java.util.*;

public class Contes418{
    // public int maxGoodNumber(int[] nums) {
    //     // Initialize the maximum number
    //     int maxNumber = 0;
        
    //     // Create a list to store all permutations
    //     List<int[]> permutations = new ArrayList<>();
    //     generatePermutations(nums, 0, permutations);
        
    //     // Iterate through each permutation
    //     for (int[] perm : permutations) {
    //         // Create a StringBuilder to store the binary concatenation
    //         StringBuilder binaryConcat = new StringBuilder();
            
    //         // Concatenate binary representations of each number in the permutation
    //         for (int num : perm) {
    //             binaryConcat.append(Integer.toBinaryString(num));
    //         }
            
    //         // Convert the binary string to an integer
    //         int currentValue = Integer.parseInt(binaryConcat.toString(), 2);
            
    //         // Update the maximum number if the current value is larger
    //         maxNumber = Math.max(maxNumber, currentValue);
    //     }
        
    //     return maxNumber;
    // }
    
    // // Helper method to generate all permutations of the array
    // private void generatePermutations(int[] nums, int index, List<int[]> permutations) {
    //     if (index == nums.length) {
    //         permutations.add(nums.clone()); // Add the current permutation
    //     } else {
    //         for (int i = index; i < nums.length; i++) {
    //             swap(nums, i, index); // Swap elements
    //             generatePermutations(nums, index + 1, permutations); // Recurse
    //             swap(nums, i, index); // Backtrack
    //         }
    //     }
    // }
    
    // // Helper method to swap two elements in an array
    // private void swap(int[] nums, int i, int j) {
    //     int temp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = temp;
    // }









    public static String binOfArr(int[] nums){
        StringBuilder res= new StringBuilder();
        for(int n:nums){
            res.append(Integer.toBinaryString(n));
        }
        return res.toString();
    }

    public static int permute(int arr[],int i){
        int fi=0;
        if(i==arr.length-1){
            fi=0;
            String res=binOfArr(arr);
            int num = Integer.parseInt(res,2);
            return num;
        }
        for(int j=i;j<arr.length;j++){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            fi=Math.max(fi,permute(arr, i+1));
            arr[j]=arr[i];
            arr[i]=temp;
        }
        return fi;
    }
    public static int maxGoodNumber(int[] nums) {
        return permute(nums, 0);
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(maxGoodNumber(nums));
    }
}


