import java.util.*;
public class CountMaxBitwiseSubs {
    private static int maxOr = 0;
    private static int count = 0;
    public static void subs(int nums[], int i,int currOr){
        if(currOr == maxOr){
            count++;
        }
        for(int j=i;j<nums.length;j++){
            int originalOR = currOr;
            currOr |= nums[j];
            subs(nums, j+1, currOr);
            currOr = originalOR;
        }
    }
    public static int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        count = 0;
        for(int e : nums){
            maxOr |= e;
        }
        subs(nums,0,0);
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {3,1};
        System.out.println(countMaxOrSubsets(nums));
    }
}



