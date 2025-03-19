public class B5CountNoofOccrs {
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
            else if(arr[mid]<x){
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    int countFreq(int[] arr, int target) {
        if(findLast(arr,target)==-1)return 0;
        return findLast(arr,target)-findFirst(arr,target)+1;
    }
}
