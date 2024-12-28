public class A16MaxSubArray {
    // public int maxSubArray(int[] nums) {
    //     int n=nums.length,maxi=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int sum=0;
    //         for(int j=i;j<n;j++){
    //             sum+=nums[j];
    //             maxi = Math.max(sum,maxi);
    //         }
    //     }
    //     return maxi;
    // }

    public int maxSubArray(int[] nums){
        int n=nums.length,maxi=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            maxi=Math.max(sum,maxi);
            if(sum<0) sum=0;
        }
        return maxi;
    }
}
