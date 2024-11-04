public class S6MinOperForMakTwoStrsEqual {
    public int minDistance(String word1, String word2) {  
        int n=word1.length();
        int m=word2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        
        int len=dp[n][m];
        return (n - len) + (m - len);

    }
    public static void main(String[] args) {
        
    }
}
