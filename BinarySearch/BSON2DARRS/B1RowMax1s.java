public class B1RowMax1s {
    // O(N*M) approach
        // public int rowWithMax1s(int arr[][]) {
    //     int ind=-1,maxi=0;
        // for(int i=0;i<arr.length;i++){
        //     int cnt=0;
        //     for(int j=0;j<arr[i].length;j++){
        //         if(arr[i][j]==1)cnt++;
        //     }
        //     if(cnt>maxi){
        //         ind=i;
        //         maxi=cnt;
        //     }
        // }
    //     return ind;
    // }
    
    
    
    public int findCeil(int[] arr, int x) {
        int n=arr.length;
        int low=0,high=n-1,ans=n;
        while(low<=high){
            int mid = low+(high-low)/2;
             // UPPER-BOUND (last occurance of 0)
            // if(arr[mid]>0){
            
            // LOWER-BOUND (first occurance of 1)
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    } 

    // O(N*logM) approach  
    public int rowWithMax1s(int arr[][]) {
        int ind=-1,maxi=0;
        for(int i=0;i<arr.length;i++){
            int cnt=0;
            
            cnt = arr[i].length-findCeil(arr[i],1);
            
            if(cnt>maxi){
                ind=i;
                maxi=cnt;
            }
        }
        return ind;
    }
}
