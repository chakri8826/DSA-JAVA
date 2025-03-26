class B7KthMissing{
    // public int findKthPositive(int[] arr, int k) {
    //     int n = arr.length,cnt=0;
    //     for(int num:arr){
    //         if(num<=k)k++;
    //         else break;
    //     }
    //     return k;
    // }

    public int findKthPositive(int[] arr, int k){
        int n = arr.length,cnt=0;
        int low=0,high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int miss = arr[mid]-(mid+1);
            if(miss<k) low=mid+1;
            else high=mid-1;
        }
        if(high==-1)return k;
        return arr[high]+(k-(arr[high]-(high+1)));
        
        // simplified equation
        // return k+low;
    }
}