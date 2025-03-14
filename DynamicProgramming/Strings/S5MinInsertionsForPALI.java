public class S5MinInsertionsForPALI {
    public static String reverseString(String input) {
        StringBuilder word = new StringBuilder(input);
        return word.reverse().toString();
    }
    public static int minInsertions(String s) {
        String s2= reverseString(s);
        int n = s.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = dp[n][m];
        return s.length()-len;
    }
    public static void main(String[] args) {
        System.out.println(minInsertions("leetcode"));
    }
}
