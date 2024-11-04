public class S7ShortestCommSubSeq {
    //placing values from last index
    // public String shortestCommonSupersequence(String str1, String str2) {
    //     int n = str1.length();
    //     int m = str2.length();
    //     int dp[][] = new int[n+1][m+1];
    //     for(int i=0;i<=n;i++){
    //         dp[i][0]=0;
    //     }
    //     for(int j=0;j<=m;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(str1.charAt(i-1)==str2.charAt(j-1)){
    //                 dp[i][j]=1+dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
    //             }
    //         }
    //     }
    //     int lcslen = dp[n][m];
    //     int lenscs = n+m-lcslen;
    //     int ind=lenscs-1;
    //     String st="";
    //     for(int k=0; k<lenscs;k++){
    //         st +="$"; // dummy string
    //     }
    //     StringBuilder str=new StringBuilder(st);
    //     int i=n,j=m;
    //     while(i>0&&j>0){
    //         if(str1.charAt(i-1) == str2.charAt(j-1)){
    //             str.setCharAt(ind,str1.charAt(i-1) ); 
    //             ind--;
    //             i--;
    //             j--;
    //         }
    //         else if(dp[i - 1][j] > dp[i][j - 1]){
    //             str.setCharAt(ind,str1.charAt(i-1) ); 
    //             i--;
    //             ind--;
    //         }
    //         else{
    //             str.setCharAt(ind,str2.charAt(j-1) ); 
    //             j--;
    //             ind--;
    //         }
    //     }
    //     while(i>0){
    //         str.setCharAt(ind,str1.charAt(i-1) ); 
    //         i--;
    //         ind--;
    //     }
    //     while(j>0){
    //         str.setCharAt(ind,str2.charAt(j-1) ); 
    //         j--;
    //         ind--;
    //     }
    //     return str.toString();
    // }
    
    //DIRECTLY ADDING TO STR FROM STARTING INDEXES AND AT LAST REVERSING IT(BETTER APPROACH)
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        // Fill the dp array to find the length of the LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Build the shortest common supersequence using the dp array
        StringBuilder str = new StringBuilder();
        int i = n, j = m;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(str1.charAt(i - 1));
                i--;
            } else {
                str.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // Add remaining characters from str1 or str2
        while (i > 0) {
            str.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            str.append(str2.charAt(j - 1));
            j--;
        }
        
        // Reverse the string as we constructed it backwards
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac","cab"));
    }
}

