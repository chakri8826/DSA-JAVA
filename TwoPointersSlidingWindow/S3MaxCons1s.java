package TwoPointersSlidingWindow;

public class S2MaxCons1s {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int maxZeros=0;
        int maxLen=0;
        int n = nums.length;
        // while(r<n){   //LESS OPTIMIZED
        if(r<n){    //MORE OPTIMIZED
            if(nums[r]==0){
                maxZeros++;
            }
            if(maxZeros>k){
                if(nums[l]==0){
                    maxZeros-=1;
                }
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
}