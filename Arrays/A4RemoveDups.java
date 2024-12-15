import java.util.*;
public class A4RemoveDups {
    // public int removeDuplicates(int[] nums) {
    //     int n = nums.length,j=0;
    //     for(int i=1;i<n;i++){
    //         if(nums[i]!=nums[j]){
    //             nums[++j]=nums[i];
    //         }
    //     }
    //     return j+1;
    // }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int nums[] = {3,2,1};
        for(int n:nums){
            set.add(n);
        }
        System.out.println(set);
    }
}


