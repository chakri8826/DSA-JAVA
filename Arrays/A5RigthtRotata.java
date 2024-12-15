import java.util.*;
public class A5RigthtRotata {
    // RIGHT ROTATE FOR K PLACES (USING MODULO)
    // public void rotate(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] temp = new int[n]; 
    //     for (int i = 0; i < n; i++) {
    //         temp[(i + k) % n] = nums[i];
    //     }
    //     for (int i = 0; i < n; i++) {
    //         nums[i] = temp[i];
    //     }
    // }


    // RIGHT ROTATE FOR K PLACES  (OPTIMIZED)
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        // reverse(nums,0,n-1);
        // reverse(nums,0,k-1);
        // reverse(nums,k,n-1);

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
        A5RigthtRotata  A = new A5RigthtRotata();
        A.rotate(nums, k);
       System.out.println(Arrays.toString(nums));  //[5,6,7,1,2,3,4]
    }
}
