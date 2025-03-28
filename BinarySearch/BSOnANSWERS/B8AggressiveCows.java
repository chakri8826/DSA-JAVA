import java.util.*;
class B8AggressiveCows{
    public static boolean canWePlace(int[] stalls,int dist, int k){
        int cntCows=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=dist){
                cntCows++;
                last=stalls[i];
            }
            if(cntCows>=k)return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length,low=1,high=stalls[n-1]-stalls[0],ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canWePlace(stalls,mid,k)){
                low=mid+1;
                ans=mid;
            }        
            else {
                high=mid-1;
            }
        }
        return ans;
    }
}
