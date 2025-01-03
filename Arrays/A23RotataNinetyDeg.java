public class A23RotataNinetyDeg {
      // public void rotate(int[][] matrix) {
    //     int m=matrix.length,n=matrix[0].length;
    //     int mat[][] = new int[m][n];
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             mat[j][n-i-1] = matrix[i][j];
    //         }
    //     }
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             matrix[i][j]  = mat[i][j];
    //         }
    //     }
    // }

    public void swap(int[][] matrix,int a,int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }

    public void rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        //TRANSPOSE
        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }
}
