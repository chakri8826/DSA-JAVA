public class B4FirstOccLastOcc {
    // WE CAN USE DIRECTLY FLOOR AND CEIL WITH MODIFICATION
   public int findFirst(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]==x){
                ans=mid;
                high=mid-1;
            } 
            else if(arr[mid]<x){
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    
    public int findLast(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(arr[mid]>x){
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }


    // USING LOWER-BOUND AND UPPER-BOUN DIRECTLY
    public int findLower(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    
    public int findUpper(int[] arr, int x) {
       int n=arr.length;
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        // int low = findLower(nums,target);
        // // AS LOW MAY BE n  OR IT IS NOT EQUAL TO TARGET WE RETURN {-1,-1}
        // if(low==nums.length || nums[low]!=target)return new int[]{-1,-1};
        // return new int[]{low,findUpper(nums,target)-1};
        
        int low = findFirst(nums,target);
        // IF WE DIDN'T FIND FIRST OCC RETURN -1,-1 WITH OUT CHECK FOR LAST OCC
        if(low==-1) return new int[]{-1,-1};
        return new int[]{low,findLast(nums,target)};
    }
}
