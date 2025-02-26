public class S51LongSubArrWithKSum {
    //BRUTE FORCE
       // public int lenOfLongestSubarr(int[] arr, int k) {
    //     int n =arr.length;
    //     int count=0;
    //     int maxlen=0;
    //     for(int i=0;i<n;i++){
    //         int sum=0;
    //         for(int j=i;j<n;j++){
    //             sum+=arr[j];
    //             if(sum==k){
    //                 maxlen = Math.max(maxlen,j-i+1);   
    //             }
    //         }
    //     }
    //     return maxlen;
    // }

    
    //OPTIMAL FOR POSI AND NEGATIVES
    // public int lenOfLongestSubarr(int[] arr, int k){
    //     int psum,maxlen;
    //     psum=maxlen=0;
    //     int n = arr.length;
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         psum+=arr[i];
    //         if(psum==k){
    //             maxlen = Math.max(maxlen,i+1);
    //         }
    //         else if(map.containsKey(psum-k)){
    //             int len = i- map.get(psum-k);
    //             maxlen = Math.max(maxlen,len);
    //         }
    //         if (!map.containsKey(psum)) {
    //             map.put(psum, i);
    //         }
    //     }
    //     return maxlen;
    // }
    
    

    //OPTIMAL FOR ONLY POSITIVES
    public int lenOfLongestSubarr(int[] arr, int k){
        int l=0;
        int r=0;
        int sum=0;
        int n = arr.length;
        int maxlen=0;
        while(r<n){
            sum+=arr[r];
            if(sum==k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            r++;
        }
        return maxlen;
    }
}
