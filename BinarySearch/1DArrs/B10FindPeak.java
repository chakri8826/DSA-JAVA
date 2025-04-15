public class B10FindPeak {
      // public int findPeakElement(int[] nums) {
    //     int n=nums.length,low=0,high=n-1;   
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if ((mid == 0 || nums[mid] > nums[mid - 1]) && 
    //             (mid == n - 1 || nums[mid] > nums[mid + 1])) {
    //             return mid;
    //         }
    //         // Peak may be at ind=1, so that's why check mid==0
    //         // If u write as (mid>0 && ....) then u will miss peak at ind=1
    //         // 3,4,3,2,1
    //         else if(mid==0 || nums[mid]>nums[mid-1])low=mid+1;
    //         else high=mid-1;
    //     }
    //     return -1;
    // }


    // public int findPeakElement(int[] nums) {
    //     int n=nums.length;
    //     if(n==1)return 0;
    //     // CHECKING FIRST AND LAST ELEMENTS SEPARATELY
    //     if(nums[0]>nums[1])return 0;
    //     if(nums[n-1]>nums[n-2])return n-1;
        
    //     int low=1,high=n-2;   
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
    //             return mid;
    //         }
    //         // Peak may be at ind=1, so that's why check mid==0
    //         // If u write as (mid>0 && ....) then u will miss peak at ind=1
    //         // 3,4,3,2,1
    //         else if(nums[mid]>nums[mid-1])low=mid+1;
    //         else high=mid-1;
    //     }
    //     return -1;
    // }

    
    // GURTHU UNDEDI
    public int findPeakElement(int[] nums) {
        int n=nums.length,l=1,h=n-2;
        if(n==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[n-1]>nums[n-2])return n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<nums[mid-1])h=mid-1;
            else if(nums[mid]<nums[mid+1])l=mid+1;
            else return mid;
        }
        return -1;
    }   
}
