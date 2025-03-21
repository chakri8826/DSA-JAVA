public class B6SearchInRotatedArr2 {
    public boolean search(int[] nums, int target) {
        int n=nums.length,low=0,high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)return true;
            else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            else if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]) high=mid-1;
                else low=mid+1;
            }
            else {
                if(nums[mid]<target && target<=nums[high]) low=mid+1;
                else high=mid-1; 
            }
        }
        return false;
    }
}