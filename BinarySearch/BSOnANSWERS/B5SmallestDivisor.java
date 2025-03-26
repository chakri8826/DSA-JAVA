public class B5SmallestDivisor {
    public int findRes(int[] nums, int div){
        int res=0;
        for(int num:nums){
            res+=Math.ceil((double) num/div);
        }
        return res;
    }
    // public int smallestDivisor(int[] nums, int threshold) {
    //     int maxi=0;
    //     for(int i=0;i<nums.length;i++){
    //         maxi=Math.max(maxi,nums[i]);
    //     }
        // for(int div=1;div<=maxi;div++){
        //     int res = findRes(nums,div);
        //     if(res<=threshold)return div;
        // }
    //     return -1;
    // }

    public int smallestDivisor(int[] nums, int threshold) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1,high=maxi;
        while(low<=high){
            int mid = low+(high-low)/2;
            int res = findRes(nums,mid);
            if(res<=threshold) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
