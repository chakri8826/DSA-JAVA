public class B9KthEle {
    // public int kthElement(int a[], int b[], int k) {
    //     int cnt=0,i=0,j=0,m=a.length,n=b.length;
    //     while(i<m && j<n){
    //         if(a[i]<b[j]){
    //             if(cnt==k-1) return a[i];
    //             i++;
    //         }
    //         else{
    //             if(cnt==k-1) return b[j];
    //             j++;
    //         }
    //         cnt++;
    //     } 
    //     while(i<m){
    //         if(cnt==k-1) return a[i];
    //         i++;
    //         cnt++;
    //     }
    //     while(j<n){
    //         if(cnt==k-1) return b[j];
    //         j++;
    //         cnt++;
    //     }
    //     return -1;
    // }
    
    public int kthElement(int a[], int b[], int k) {
        int m=a.length,n=b.length;
        if(m>n)return kthElement(b,a,k);
        int low=Math.max(0,k - n),high=Math.min(k,m);
        while(low<=high){
            int mid1 = (low+high)>>1;
            int mid2 = k-mid1;
            int l1 = Integer.MIN_VALUE,l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE,r2 = Integer.MAX_VALUE;
            if(mid1<m) r1 = a[mid1];
            if(mid2<n) r2 = b[mid2];
            if(mid1-1>=0) l1 = a[mid1-1];
            if(mid2-1>=0) l2 = b[mid2-1];
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            } 
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    } 
    public static void main(String[] args) {
        B9KthEle obj = new B9KthEle();
        int[] a = {2,3,6,7,9};
        int[] b = {1,4,8,10};
        System.out.println(obj.kthElement(a,b,4));
    }
}
