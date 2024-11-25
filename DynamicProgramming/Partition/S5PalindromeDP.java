import java.util.*;
public class S5PalindromeDP {
    //RECURSIVE + MEMOIZATION
    // public static boolean isPali(String s,int i, int j,int dp[][]){
    //     if(i>=j)return true;
    //     if(dp[i][j]!=-1) return dp[i][j]==1?true:false;
    //     dp[i][j] = s.charAt(i)==s.charAt(j) && isPali(s, i+1, j-1,dp)==true?1:0;
    //     return dp[i][j]==1?true:false;
    // }


    //TABULATION
    public static boolean isPali(String s,int n,boolean dp[][]){
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>=j) dp[i][j] = true;
                else{
                    dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }



    public static void main(String[] args) {
        String s = "tenet";


        // int dp[][] = new int[s.length()][s.length()];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
        // System.out.println(isPali(s,0,s.length()-1,dp));


        boolean dp[][] = new boolean[s.length()+1][s.length()+1];
        System.out.println(isPali(s,s.length(),dp));
    }
}