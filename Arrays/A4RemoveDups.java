import java.util.*;
public class A4RemoveDups {
    // BRUTE-FORCE
    public int removeDuplicates(int[] nums) {
        LinkedHashSet <Integer> set = new LinkedHashSet<>();
        for (int i = 0; i <nums.length; i++) {
            set.add(nums[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            nums[j++] = x;
        }
        return k;
    }
    
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


