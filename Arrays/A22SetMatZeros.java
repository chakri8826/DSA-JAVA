public class A22SetMatZeros {
    //     public void setZeroes(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;

    //         boolean[] row = new boolean[m];
    //         boolean[] col = new boolean[n];

    //         for(int i=0;i<m;i++){
    //             for(int j=0;j<n;j++){
    //                 if(matrix[i][j]==0){
    //                     row[i]=true;
    //                     col[j]=true;
    //                 }
    //             }
    //         }
    //         for(int i=0;i<m;i++){
    //             for(int j=0;j<n;j++){
    //                 if(row[i] || col[j]){
    //                     matrix[i][j]=0;
    //                 }
    //             }
    //         }
    //     }



    public void fill(int[][] matrix, int r, int n) {
        for (int c = 0; c < n; c++) {
            matrix[r][c] = 0;
        }
    }

    public void fillr(int[][] matrix, int c, int m) {
        for (int r = 0; r < m; r++) {
            matrix[r][c] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rows = false, cols = false;

        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                cols = true;
                break;
            }
        }

        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                rows = true;
                break;
            }
        }

        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                fill(matrix, i, n);
            }
        }

        
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                fillr(matrix, j, m);
            }
        }

        if (rows) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

        
        if (cols) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}
