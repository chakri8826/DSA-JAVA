class B1LowerBound_Lowest{
    // it is a Floor --> 
    static int findFloor(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2; 
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}