import java.util.*;
public class Solution08Triangle {
    // public int min(List<List<Integer>> triangle, int row,int col,int n){
    //     if(row==n-1) return triangle.get(row).get(col);
    //     int d = triangle.get(row).get(col) + min(triangle,row+1,col,n);
    //     int dg = triangle.get(row).get(col) + min(triangle,row+1,col+1,n);
    //     return Math.min(d,dg);
    // }
    

    // public int min(List<List<Integer>> triangle, int row,int col,int n, int dp[][]){
    //     if(row==n-1) return triangle.get(row).get(col);
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int d = triangle.get(row).get(col) + min(triangle,row+1,col,n,dp);
    //     int dg = triangle.get(row).get(col) + min(triangle,row+1,col+1,n,dp);
    //     return dp[row][col] = Math.min(d,dg);
    // }


    // public int min(List<List<Integer>> triangle, int n, int dp[][]){
    //     for(int i=0;i<n;i++){
    //         dp[n-1][i] =  triangle.get(n-1).get(i);
    //     }
    //     for(int row=n-2;row>=0;row--){
    //         for(int col=row;col>=0;col--){
    //                 int d = triangle.get(row).get(col) + dp[row+1][col];
    //                 int dg = triangle.get(row).get(col) + dp[row+1][col+1];
    //                 dp[row][col] = Math.min(d,dg);
    //         }
    //     }
    //     return dp[0][0];
    // }

    
    public int min(List<List<Integer>> triangle, int n){
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            prev[i] =  triangle.get(n-1).get(i);
        }
        for(int row=n-2;row>=0;row--){
            int curr[] = new int[n];
            for(int col=row;col>=0;col--){
                    int d = triangle.get(row).get(col) + prev[col];
                    int dg = triangle.get(row).get(col) + prev[col+1];
                    curr[col] = Math.min(d,dg);
            }
            prev=curr;
        }
        return prev[0];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int dp[][] = new int[m][m];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return min(triangle,0,0,triangle.size(),dp); 

        
        // return min(triangle,triangle.size(),dp); 
        return min(triangle,triangle.size()); 

    }
public static void main(String[] args) {
        // Create a triangle as a List of Lists
        List<List<Integer>> triangle = new ArrayList<>();

        // Add rows to the triangle
        triangle.add(List.of(2));                 // Row 0
        triangle.add(List.of(3, 4));              // Row 1
        triangle.add(List.of(6, 5, 7));           // Row 2
        triangle.add(List.of(4, 1, 8, 3));        // Row 3

 
        Solution08Triangle solution = new Solution08Triangle();         
        // Call the minimumTotal method with the generated triangle
        int result = solution.minimumTotal(triangle);

        // Print the result
        System.out.println("Minimum path sum: " + result);
    }

}
