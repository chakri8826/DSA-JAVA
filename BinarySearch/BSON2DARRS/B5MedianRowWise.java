public class B5MedianRowWise {
    int upperBound(int arr[],int tar){
        int n=arr.length,low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>tar) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
 
    int findLessEquals(int mat[][],int x){
        int cnt=0;
        for(int i=0;i<mat.length;i++){
            cnt+=upperBound(mat[i],x);
        }
        return cnt;
    }
    
    int median(int mat[][]) {
        int m=mat.length,n=mat[0].length,req=(m*n)/2,low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][n-1]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int lessEquals = findLessEquals(mat,mid);
            if(lessEquals<=req)low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
