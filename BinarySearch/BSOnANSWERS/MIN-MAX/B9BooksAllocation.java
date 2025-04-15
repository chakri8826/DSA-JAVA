public class B9BooksAllocation {
        public static boolean possible(int sum,int k,int[] arr){
            int scnt=1,pages=0;
            for(int i=0;i<arr.length;i++){
                pages+=arr[i];
                if(pages>sum){
                    scnt++;
                    pages=arr[i];
                }
            }
            return scnt<=k;
        }

    // GURTHU UNDEDI
    // public static boolean possible(int sum, int k, ArrayList<Integer> arr) {
    //     int scnt = 1, pages = 0;
    //     for (int i = 0; i < arr.size(); i++) {
    //         int curr = arr.get(i);
    //         if (pages+curr<=sum) {
    //             pages+=curr;
    //         }
    //         else{
    //             scnt++;
    //             pages = curr;
    //         }
    //     }
    //     return scnt <= k;
    // }
    
    // public static int findPages(int[] arr, int k) {
    //     int total=0,maxVal=0;
    //     if (k > arr.length) return -1;
    //     for(int num:arr){
    //         total+=num;
    //         maxVal = Math.max(maxVal, num);
    //     }
    //     for(int i=1;i<=total;i++){
    //         if(possible(i,k,arr))return i;
    //     }
    //     return -1;
    // }
    
    public static int findPages(int[] arr, int k) {
        int total=0,maxVal=0;
        if (k > arr.length) return -1;
        for(int num:arr){
            total+=num;
            maxVal = Math.max(maxVal, num);
        }
        int low=maxVal,high=total;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(mid,k,arr))high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}