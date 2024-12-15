import java.util.*;
public class WC427 {
    // public long maxSubarraySum(int[] nums, int k) {
    //     int n=nums.length,maxsum=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if((j-i+1)%k==0){
    //                 int sum=0;
    //                for(int l=i;l<=j;l++){
    //                     sum+=nums[l];
    //                }
    //                maxsum = Math.max(maxsum,sum);
    //             }
    //         }
    //     }
    //     return maxsum == Integer.MIN_VALUE ? 0 : maxsum;
    // }

    public static long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ans = Long.MIN_VALUE;
        long psum[] = new long[n+1];
        psum[0]=0;
        for(int i=1;i<=n;i++){
            psum[i]=nums[i-1]+psum[i-1];
        }
        long[] ms = new long[k];
        Arrays.fill(ms,Long.MAX_VALUE);
        ms[0]=0;
        for(int i=1;i<=n;i++){ 
            int ind=i%k;
//Without this check, you will compute the difference for indices where ms[ind] is still Long.MAX_VALUE, which leads to:
// Invalid results: Subtracting Long.MAX_VALUE from psum[i] will result in a very large negative value, which will incorrectly update the ans value.
            if (ms[ind] != Long.MAX_VALUE) {
                ans = Math.max(ans,psum[i]-(ms[ind]));
            }
            ms[ind] = Math.min(ms[ind],psum[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int []nums ={-1,-2,-3,-4,-5};
        int k=4;
        System.out.println(maxSubarraySum(nums,k));
    }
}
