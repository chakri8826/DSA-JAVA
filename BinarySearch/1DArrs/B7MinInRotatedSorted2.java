public class B7MinInRotatedSorted2 {
    public int findMin(int[] nums) {
        int n=nums.length,low=0,high=n-1,ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            // IF SEARCH SPACE IS ALREADY SORTED, THEN nums[low] WILL BE SMALLER ONE
            if(nums[low]<nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            else if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // Arr may have only one ele, so check and do l++ and h--
                ans=Math.min(ans,nums[low]);
                low++;
                high--;
            }
            else if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}