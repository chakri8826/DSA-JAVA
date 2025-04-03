public class B4Search2d {
   // BS ON COLS
    public int findRow(int col,int[][] mat){
        int maxi=Integer.MIN_VALUE,row=-1;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]>maxi){
                row=i;
                maxi=mat[i][col];
            }
        }
        return row;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat[0].length,low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row = findRow(mid,mat);
            if ((mid==0 || mat[row][mid]>mat[row][mid-1]) &&  (mid==n-1 || mat[row][mid]>mat[row][mid+1])) return new int[]{row,mid};
            else if(mid>0 && mat[row][mid]<mat[row][mid-1]) high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }


    // BS ON ROWS
    // public int findCol(int row,int[][] mat){
    //     int maxi=Integer.MIN_VALUE,col=-1;
    //     for(int i=0;i<mat[0].length;i++){
    //         if(mat[row][i]>maxi){
    //             col=i;
    //             maxi=mat[row][i];
    //         }
    //     }
    //     return col;
    // }
    // public int[] findPeakGrid(int[][] mat) {
    //     int m=mat.length,low=0,high=m-1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         int col = findCol(mid,mat);
    //         if ((mid==0 || mat[mid][col]>mat[mid-1][col]) &&  (mid==m-1 || mat[mid][col]>mat[mid+1][col])) return new int[]{mid,col};
    //         else if(mid>0 && mat[mid][col]<mat[mid-1][col]) high=mid-1;
    //         else low=mid+1;
    //     }
    //     return new int[]{-1,-1};
    // }
}
