public class B2NthSquare {
    public int pow(int x, int n){
        long m = n;
        double res=1;
        while(m>0){
            if((m&1)==1){
                res = res*x;
                m--;
            }
            else{
                x=x*x;
                m>>=1;
            }
        }
        return (int)res;
    }
    
    public int nthRoot(int n, int m) {
        int low=1,high=m;
        while(low<=high){
            int mid = low+(high-low)/2;
            int ans = pow(mid,n);
            if(ans==m)return mid;
            else if(ans>m)high=mid-1;
            else low=mid+1;
 
        }
        return -1;
    }
}