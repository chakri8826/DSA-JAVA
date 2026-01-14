public class I3Celebrity {
    
    // public int celebrity(int mat[][]) {
    //     int n = mat.length;

    //     // Arrays to store knowledge information
    //     int[] iknow = new int[n];  // Counts how many people `i` knows
    //     int[] known = new int[n];  // Counts how many people know `i`
    
    //     // Fill the arrays based on the matrix
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (i!=j && mat[i][j] == 1) {
    //                 iknow[i]++;   // `i` knows `j`
    //                 known[j]++;   // `j` is known by `i`
    //             }
    //         }
    //     }
    
    //     // Find the potential celebrity
    //     for (int i = 0; i < n; i++) {
    //         if (iknow[i] == 0 && known[i] == n - 1) {
    //             return i; // Found the celebrity
    //         }
    //     }
        
    //     return -1; // No celebrity found
    // }


    

     // TC -> O(N^2)+O(N^2),SC=O(1)
    // public int celebrity(int mat[][]) {
    //     int r = mat.length,c=mat[0].length;
    //     for(int i=0;i<r;i++){
    //         boolean cele=true;
    //         for(int j=0;j<c;j++){
    //             if(i!=j && mat[i][j]==1){
    //                 cele=false;
    //                 break;
    //             }
    //         }
    //         if(cele){
    //             boolean celebrity=true;
    //             for(int k=0;k<r;k++){
    //                 if(k!=i && mat[k][i]==0){
    //                     celebrity=false;
    //                     break;
    //                 }
    //             }
    //             if(celebrity)return i;
    //         }
    //     }
    //     return -1;
    // }
    
    
    
    
    
    
    
    public int celebrity(int mat[][]) {
        int n=mat.length,t=0,b=n-1;
        // When i == j → loop stops
        while(t<b){
            if(mat[t][b]==1)t++;
            else if(mat[b][t]==1)b--;
            else{
                t++;
                b--;
            }
        }
        if(t>b)return -1;
        for(int i=0;i<n;i++){
            if(i!=t && mat[t][i]==1)return -1;
            if(i!=t && mat[i][t]==0)return -1;
        }
        return t;
    }
    
    public static void main(String[] args) {
        I3Celebrity obj = new I3Celebrity();
        int mat[][] = {{0, 0, 1, 0},
                       {0, 0, 1, 0},
                       {0, 0, 0, 0},
                       {0, 0, 1, 0}};
        System.out.println(obj.celebrity(mat));
    }
}
