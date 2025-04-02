public class B2Search2dMat {
    // O(N*M)
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for(int i=0;i<matrix.length;i++){
    //         for(int j=0;j<matrix[i].length;j++){
    //             if(matrix[i][j]==target)return true;
    //         }
    //     }
    //     return false;
    // }



    // public boolean found(int arr[],int tar){
    //     int n=arr.length,low=0,high=n-1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         if(arr[mid]==tar)return true;
    //         else if(arr[mid]<tar)low=mid+1;
    //         else high=mid-1;
    //     }
    //     return false;
    // } 
    
    // O(N + logM) ~ O(N)
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for(int i=0;i<matrix.length;i++){
    //         if(matrix[i][0]<=target && target<=matrix[i][matrix[i].length-1]){
    //             if(found(matrix[i],target))return true;
    //         }
    //     }
    //     return false;
    // }



    // O(log(N*M))
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length,low=0,high=n*m-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int r = mid/m,c=mid%m;
            if(matrix[r][c]==target)return true;
            else if(matrix[r][c]<target)low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
