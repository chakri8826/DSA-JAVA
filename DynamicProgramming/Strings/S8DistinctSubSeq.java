import java.util.Arrays;

public class S8DistinctSubSeq {
    // public int f(int i,int j,String s, String t){
    //     if(j<0) return 1;
    //     if(i<0) return 0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         return f(i-1,j-1,s,t)+f(i-1,j,s,t);
    //     }
    //     else{
    //         return f(i-1,j,s,t);
    //     }
    // }

    // public int f(int i,int j,String s, String t,int dp[][]){
    //     if(j<0) return 1;
    //     if(i<0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j] = f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp);
    //     }
    //     else{
    //         return  dp[i][j] = f(i-1,j,s,t,dp);
    //     }
    // }


    //RECURSIVE FOR 1 BASED INDEXING
    // public int f(int i,int j,String s, String t){
    //     if(j==0) return 1;
    //     if(i==0) return 0;
    //     if(s.charAt(i-1)==t.charAt(j-1)){
    //         return f(i-1,j-1,s,t)+f(i-1,j,s,t);
    //     }
    //     else{
    //         return f(i-1,j,s,t);
    //     }
    // }


    //TABULATION APPROACH 1 BASED IND
    // public int f(int n,int m,String s, String t,int [][]dp){
    //     for(int i=0;i<=n;i++){
    //         dp[i][0]=1;
    //     }
    //     for(int j=1;j<=m;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1)==t.charAt(j-1)){
    //                 dp[i][j] =  dp[i-1][j-1]+dp[i-1][j];
    //             }
    //             else{
    //                 dp[i][j] =  dp[i-1][j];
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }


    //JUST ANOTHER METHOD TO DO THE SAME(DECLARING CURR PREVIOUSLY AND COPYING CONTENTS EACH TIME)
    // public int f(int n,int m,String s, String t){
    //     int prev[] = new int[m+1];
    //     int curr[] = new int[m+1];
    //     prev[0]=1;
    //     for(int i=1;i<=n;i++){
    //         curr[0]=1;
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1)==t.charAt(j-1)){
    //                 curr[j] =  prev[j-1]+prev[j];
    //             }
    //             else{
    //                 curr[j] =  prev[j];
    //             }
    //         }
    //         System.arraycopy(curr, 0, prev, 0, m + 1);
    //     }
    //     return prev[m];
    // }


    //SPACE OPTIMIZATION 2D ARRAY
    // public int f(int n,int m,String s, String t){
    //     int prev[] = new int[m+1];
    //     prev[0]=1;
    //     for(int i=1;i<=n;i++){
    //         int curr[] = new int[m+1];
    //         curr[0]=1;
    //         for(int j=1;j<=m;j++){
    //             if(s.charAt(i-1)==t.charAt(j-1)){
    //                 curr[j] =  prev[j-1]+prev[j];
    //             }
    //             else{
    //                 curr[j] =  prev[j];
    //             }
    //         }
    //         prev=curr;
    //     }
    //     return prev[m];
    // }


    //SPACE OPTIMIZATION 1D ARRAY
    public int f(int n,int m,String s, String t){
        int prev[] = new int[m+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    prev[j] =  prev[j-1]+prev[j];
                }
                //NOT REQUIRED
                // else{
                //     prev[j] =  prev[j];
                // }
            }
        }
        return prev[m];
    }


    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        // return f(n-1,m-1,s,t);

        // int dp[][] = new int[n][m];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(n-1,m-1,s,t,dp);
        
    
        //1BASED RECURSIVE CALL
        // return f(n,m,s,t);

        //1BASED TABULATION 
        // int dp[][] = new int[n+1][m+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(n,m,s,t,dp);

        return f(n,m,s,t);


    }
    public static void main(String[] args) {
        
    }
}
