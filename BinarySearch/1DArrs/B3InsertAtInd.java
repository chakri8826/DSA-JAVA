public class B3InsertAtInd {
    // USING FLOOR
    // public int searchInsert(int[] nums, int target) {
    //     int n=nums.length;
    //     int low=0,high=n-1,ans=-1;
    //     while(low<=high){
    //         int mid = low+(high-low)/2; 
    //         if(nums[mid]==target)return mid;
    //         if(nums[mid]<target){
    //             ans=mid;
    //             low=mid+1;
    //         }
    //         else high=mid-1;
    //     }
    //     return ans+1;
    // }    


    // USING CEIL
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
