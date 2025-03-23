class B9SingleEleInSorted{
    // public int singleNonDuplicate(int[] nums) {
    //     int n=nums.length,low=0,high=n-1;
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(mid>0 && nums[mid]==nums[mid-1]){
    //             if(mid%2!=0) low=mid+1;
    //             else high=mid-2;
    //         } 
    //         else if(mid<n-1 && nums[mid]==nums[mid+1]){
    //             if(mid%2==0)low=mid+2;
    //             else high=mid-1;
    //         }
    //         else return nums[mid];
    //     }
    //     return -1;
    // }

    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        // CHECKING FIRST AND LAST ELEMENTS SEPARATELY
        if(nums[0]!=nums[1])return nums[0];
        if(nums[n-1]!=nums[n-2])return nums[n-1];

        int low=1,high=n-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==nums[mid-1]){
                if(mid%2!=0) low=mid+1;
                else high=mid-2;
            } 
            else if(nums[mid]==nums[mid+1]){
                if(mid%2==0)low=mid+2;
                else high=mid-1;
            }
            else return nums[mid];
        }
        return -1;
    }
}