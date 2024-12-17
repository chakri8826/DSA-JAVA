public class A11 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length,c=0,maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                c++;
                maxi = Math.max(maxi,c);
            }
            else if(nums[i]==0){
                c=0;
            }
        }
        return maxi;
    }
}
