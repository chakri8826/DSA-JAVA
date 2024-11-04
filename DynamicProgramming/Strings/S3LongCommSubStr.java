import java.util.*;
public class S3LongCommSubStr {
    //TABULATION
    //     // public static int longestCommonSubstr(String s1, String s2) {
    //     int n = s1.length();
    //     int m = s2.length();
    //     int dp[][] = new int[n+1][m+1];
    //     int ans = 0;
    //     for(int j=0;j<=m;j++){
    //         dp[0][j] = 0;
    //     }
    //     for(int i=0;i<=n;i++){
    //         dp[i][0] = 0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s1.charAt(i-1)==s2.charAt(j-1)){
    //                     dp[i][j] = 1+dp[i-1][j-1];
    //                     ans = Math.max(ans,dp[i][j]);
    //             }
    //             else dp[i][j] = 0;
    //         }
    //     }
    //     return ans;
    // }


    public static String printLCSubStr(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int endInd = -1;
        int dp[][] = new int[n+1][m+1];
        int ans = 0;
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                        ans = Math.max(ans,dp[i][j]);
                        endInd=i;
                }
                else dp[i][j] = 0;
            }
        }
        if(endInd==-1) return "";
        StringBuilder str = new StringBuilder();
        
        // for(int i=endInd-ans;i<endInd;i++){
        //     str.append(s1.charAt(i));
        // }
        // return str.toString();

        //AS WE CAME BY 1-INDEXING WE START FROM ENDIND-1
        //STORING  FORM LAST IND AND GIVING REVERSE AT LAST
        // for(int i=endInd-1;i>=endInd-ans;i--){
        //     str.append(s1.charAt(i));
        // }
        // return str.reverse().toString();

        
    } 


    //SPACE OPTIMIZATION
    // public int longestCommonSubstr(String s1, String s2) {
    //     int n = s1.length();
    //     int m = s2.length();
    //     int prev[] = new int[m+1];
    //     // int dp[][] = new int[n+1][m+1];
    //     int ans = 0;
    //     for(int j=0;j<=m;j++){
    //         prev[j] = 0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         int curr[] = new int[m+1];
    //         for(int j=1;j<=m;j++){
    //             if(s1.charAt(i-1)==s2.charAt(j-1)){
    //                     curr[j] = 1+prev[j-1];
    //                     ans = Math.max(ans,curr[j]);
    //             }
    //             else curr[j] = 0;
    //         }
    //         prev=curr;
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        // System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR"));
        System.out.println(printLCSubStr("ABCDGH", "ACDGHR"));
    }
}



