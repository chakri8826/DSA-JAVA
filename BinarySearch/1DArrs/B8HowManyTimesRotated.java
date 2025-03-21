import java.util.List;

public class B8HowManyTimesRotated {
     public int findKRotation(List<Integer> arr) {
        int low=0,high=arr.size()-1,ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr.get(low)<=arr.get(high)){
                if(ans==-1 || arr.get(low)<arr.get(ans) ){
                    ans=low;
                }
                break;
            }
            else if(arr.get(low)<=arr.get(mid)){
                if(ans==-1 || arr.get(low)<arr.get(ans)){
                    ans=low;
                }
                // ans = Math.min(ans,arr.get(low));
                low=mid+1;
            }
            else{
                if(ans==-1 || arr.get(mid)<arr.get(ans)  ){
                    ans=mid;
                }
                // ans = Math.min(ans,arr.get(mid));
                high=mid-1;
            }
        }
        return ans;
    }
}
