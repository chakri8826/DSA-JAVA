public class S9EditDistance {
    // public int f(int i,int j,String word1, String word2){
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;
    //     if(word1.charAt(i)==word2.charAt(j)){
    //         return f(i-1,j-1,word1,word2);
    //     }
    //     return Math.min(Math.min(1+f(i,j-1,word1,word2),1+f(i-1,j,word1,word2)),1+f(i-1,j-1,word1,word2));
    // }

    //1BASED INDEXING RECURSIVE
    // public int f(int i,int j,String word1, String word2){
    //     if(i==0) return j;
    //     if(j==0) return i;
    //     if(word1.charAt(i-1)==word2.charAt(j-1)){
    //         return f(i-1,j-1,word1,word2);
    //     }
    //     return Math.min(Math.min(1+f(i,j-1,word1,word2),1+f(i-1,j,word1,word2)),1+f(i-1,j-1,word1,word2));
    // }

    //1BASED INDEXING MEMO
    // public int f(int i,int j,String word1, String word2,int dp[][] ){
    //     if(i==0) return j;
    //     if(j==0) return i;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(word1.charAt(i-1)==word2.charAt(j-1)){
    //         return dp[i][j] = f(i-1,j-1,word1,word2,dp);
    //     }
    //     return dp[i][j] = Math.min(Math.min(1+f(i,j-1,word1,word2,dp),1+f(i-1,j,word1,word2,dp)),1+f(i-1,j-1,word1,word2,dp));
    // }

    //1BASED TABULAITON
    // public int f(int n,int m,String word1, String word2,int dp[][] ){
    //     for(int j=0;j<=m;j++){
    //         dp[0][j]=j;
    //     }
    //     for(int i=1;i<=n;i++){
    //         dp[i][0]=i;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(word1.charAt(i-1)==word2.charAt(j-1)){
    //                  dp[i][j] = dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = Math.min(Math.min(1+dp[i][j-1],1+dp[i-1][j]),1+dp[i-1][j-1]);
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }


    //SPACE OPTIMIZATION 2 ARRAYS
    public int f(int n,int m,String word1, String word2){
        int prev[] = new int[m+1];
        for(int j=0;j<=m;j++){
            prev[j]=j;  // Base case: transform an empty word1 to word2[0..j]
        }
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            curr[0]=i;   // Base case: transform word1[0..i] to an empty word2
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    curr[j] = Math.min(Math.min(1+curr[j-1],1+prev[j]),1+prev[j-1]);
                }
            }
            prev=curr;
        }
        return prev[m];
    }


    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        // return f(n-1,m-1,word1,word2);

        //1BASED INDEXING
        // return f(n,m,word1,word2);

        //MEMO 1 BASED
        // int dp[][] = new int[n+1][m+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(n,m,word1,word2,dp);

        //TABU 1 BASED
        // int dp[][] = new int[n+1][m+1];
        // return f(n,m,word1,word2,dp);

        return f(n,m,word1,word2);
    }
    public static void main(String[] args) {
        S9EditDistance s = new  S9EditDistance();
        System.out.println(s.minDistance("horse","ros"));
    }
}




