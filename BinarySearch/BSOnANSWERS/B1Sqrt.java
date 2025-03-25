public class B1Sqrt {
     int floorSqrt(int n) {
        int low=0,high=n,ans=1;
        while(low<=high){
            int mid = low+(high-low)/2;
            // To Handle OverFlow 
            long sq = (long) mid*mid;
            // if(sq==n)return mid;
            if(sq<=n){
                ans = mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}
