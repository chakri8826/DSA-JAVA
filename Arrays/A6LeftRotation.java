import java.util.ArrayList;
import java.util.Arrays;

public class A6LeftRotation {
    //USING MODULO
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] temp = new int[n]; 

    //     // Left rotation: Move each element `k` positions to the left
    //     for (int i = 0; i < n; i++) {
    //         temp[(i - k + n) % n] = nums[i];
    //     }

    //     // Copy the rotated array back to the original array
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = temp[i];
    //     }
    // }


    //Better
    // public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
    //     int n = arr.size();
    //     int d = k % n; // Handle cases where k > n
    //     ArrayList<Integer> temp = new ArrayList<>();

    //     // Step 1: Store the first `d` elements in a temporary list
    //     for (int i = 0; i < d; i++) {
    //         temp.add(arr.get(i));
    //     }

    //     // Step 2: Shift the remaining elements to the left
    //     for (int i = d; i < n; i++) {
    //         arr.set(i - d, arr.get(i)); // Correctly shift elements
    //     }

    //     // Step 3: Place the elements from `temp` at the end
    //     for (int i = n-d; i < n; i++) {
    //         arr.set(i, temp.get(i-(n-d))); // Restore `temp` elements
    //     }

    //     return arr;
    // }


    //OPTI
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;

        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        reverse(nums,0,n-1);
    }
    public void reverse(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k=3;
        A6LeftRotation  A = new A6LeftRotation();
        A.rotate(nums, k);
       System.out.println(Arrays.toString(nums));  //[5,6,7,1,2,3,4]
    }
}
