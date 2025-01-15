import java.util.Arrays;

public class Solution10ChoclateSum {
    // public int solving(int n,int m,int grid[][],int i,int j1,int j2){
    //     if(j1<0 || j1>=m || j2<0 || j2>=m) return (int) -1e7;
    //     if(i==n-1){
    //         if(j1==j2) return grid[i][j1];
    //         else return grid[i][j1] + grid[i][j2];
    //     }
    //     int maxi=Integer.MIN_VALUE;;
    //     for(int dj1=-1;dj1<2;dj1++){
    //         for(int dj2=-1;dj2<2;dj2++){
    //             int ans;
    //             if(j1==j2) ans = grid[i][j1] + solving(n, m, grid, i + 1, j1 + dj1, j2 + dj2);
    //             else ans = grid[i][j1] + grid[i][j2] + solving(n,m,grid,i+1,j1+dj1,j2+dj2);
    //             maxi = Math.max(maxi, ans);
    //         }
    //     }
    //     return maxi;
    // }


    // public int solving(int n,int m,int grid[][],int i,int j1,int j2,int dp[][][]){
    //     if(j1<0 || j1>=m || j2<0 || j2>=m) return (int) -1e7;
    //     if(i==n-1){
    //         if(j1==j2) return grid[i][j1];
    //         else return grid[i][j1] + grid[i][j2];
    //     }
    //     if(dp[i][j1][j2] !=-1) return dp[i][j1][j2];
    //     int maxi=Integer.MIN_VALUE;;
    //     for(int dj1=-1;dj1<2;dj1++){
    //         for(int dj2=-1;dj2<2;dj2++){
    //             int ans;
    //             if(j1==j2) ans = grid[i][j1] + solving(n, m, grid, i + 1, j1 + dj1, j2 + dj2,dp);
    //             else ans = grid[i][j1] + grid[i][j2] + solving(n,m,grid,i+1,j1+dj1,j2+dj2,dp);
    //             maxi = Math.max(maxi, ans);
    //         }
    //     }
    //     return dp[i][j1][j2] = maxi;
    // }



    // public int solving(int n,int m,int grid[][],int dp[][][]){
    //     for(int j1=0;j1<m;j1++){
    //         for(int j2=0;j2<m;j2++){
    //             if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
    //             else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2]  ;
    //         }
    //     }
    //     for(int i=n-2;i>=0;i--){
    //         for(int j1=0;j1<m;j1++){
    //             for(int j2=0;j2<m;j2++){
    //                 int maxi= (int) -1e8;
    //                      for(int dj1=-1;dj1<2;dj1++){
    //                         for(int dj2=-1;dj2<2;dj2++){
    //                             int ans;
    //                             if(j1==j2) ans = grid[i][j1];
    //                             else ans = grid[i][j1] + grid[i][j2];
    //                             if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m){
    //                                 ans+=dp[i+1][j1+dj1][j2+dj2];
    //                             }
    //                             else ans+=(int)-1e8;
    //                             maxi=Math.max(ans,maxi);
    //                         }
    //                     }
    //               dp[i][j1][j2] = maxi;
    //             }
    //         }
    //     }

    //     return dp[0][0][m-1];
    // }




    public int solving(int n,int m,int grid[][],int dp[][][]){
        int front[][] = new int[m][m];
        int curr[][] = new int[m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) front[j1][j2] = grid[n-1][j1];
                else front[j1][j2] = grid[n-1][j1] + grid[n-1][j2]  ;
            }
        }
        for(int i=n-2;i>=0;i--){
            curr = new int[m][m]; 
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi= (int) -1e8;
                        for(int dj1=-1;dj1<2;dj1++){
                            for(int dj2=-1;dj2<2;dj2++){
                                int ans;
                                if(j1==j2) ans = grid[i][j1];
                                else ans = grid[i][j1] + grid[i][j2];
                                if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m){
                                    ans+=front[j1+dj1][j2+dj2];
                                }
                                else ans+=(int)-1e8;
                                maxi=Math.max(ans,maxi);
                            }
                        }
                        curr[j1][j2] = maxi;
                }
            }
            front=curr;
        }

        return front[0][m-1];
    }
    


    public int solve(int n, int m, int grid[][]) {
        // int i=0,j1=0,j2=m-1;
        // return solving(n,m,grid,i,j1,j2);
        
        //MEMO
        // int i=0,j1=0,j2=m-1;
        // int dp[][][] = new int[n][m][m];
        // for(int row[][]:dp){
        //     for(int inrow[]:row){
        //         Arrays.fill(inrow,-1);
        //     }
        // }
        // return solving(n,m,grid,i,j1,j2,dp);


        //Space Optimization
        int dp[][][] = new int[n][m][m];
        return solving(n,m,grid,dp);

    }
    public static void main(String[] args) {
        Solution10ChoclateSum  sol = new Solution10ChoclateSum();
        int grid[][] = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        // System.out.println(sol.solve(4, 3, grid));


    
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(sol.solve(4, 3, grid));

    }
}


