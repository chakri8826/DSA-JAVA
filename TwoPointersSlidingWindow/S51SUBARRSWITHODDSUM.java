public class S51SUBARRSWITHODDSUM {
    public int numOfSubarrays(int[] arr) {
        // AS PSUM==0 AT STARTING 0 IS EVEN SO INITIALIZING ev=1
        int psum=0,cnt=0,n=arr.length,ev=1,od=0,mod=(int) 1e9+7;
        for(int i=0;i<n;i++){
            psum+=arr[i];
            cnt=(cnt+(psum%2==0?od:ev))%mod;
            if(psum%2==0){
                ev=ev+1;
            }
            else{
                od=od+1;
            }
        }
        return cnt;
    }
}
