import java.util.*;
public class G5ValidParenthesis {
        // RECURSIVE
    // public boolean f(String s,int ind,int cnt){
    //     if(cnt<0) return false;
    //     if(ind==s.length()) return cnt==0;
    //     if(s.charAt(ind)=='('){
    //         return f(s,ind+1,cnt+1);
    //     }
    //     if(s.charAt(ind)==')'){
    //         return f(s,ind+1,cnt-1);
    //     }
    //     return f(s,ind+1,cnt+1) || f(s,ind+1,cnt-1) || f(s,ind+1,cnt);
    // }


    // MEMOIZATION
    // public int f(String s,int ind,int cnt,int dp[][]){
    //     if(cnt<0) return 0;
    //     if(ind==s.length()) return cnt==0?1:0;
    //     if(dp[ind][cnt]!=-1)return dp[ind][cnt];
    //     if(s.charAt(ind)=='('){
    //         return dp[ind][cnt] = f(s,ind+1,cnt+1,dp);
    //     }
    //     if(s.charAt(ind)==')'){
    //         return dp[ind][cnt] = f(s,ind+1,cnt-1,dp);
    //     }
    //     dp[ind][cnt] = Math.max(f(s, ind+1, cnt+1, dp), Math.max(f(s, ind+1, cnt-1, dp), f(s, ind+1, cnt, dp)));
    //     return dp[ind][cnt];
    // }
    // public boolean checkValidString(String s) {
    //     // return f(s,0,0);
    //     int n = s.length();
    //     int dp[][] = new int[n+1][n+1];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return f(s,0,0,dp)==1?true:false;
    // }


    // Using Boolean[][] instead of int[][] as Boolean is a wrapper class that will store null initially.
    // arrays of wrapper classes (e.g., Boolean[], Integer[]) are initialized with null because they are objects.

    // public boolean f(String s, int ind, int cnt,Boolean[][] dp) {
    //     if (cnt < 0) return false;  
    //     if (ind == s.length()) return cnt == 0; 
    //     if (dp[ind][cnt] != null) return dp[ind][cnt];  

    //     if (s.charAt(ind) == '(') {
    //         return dp[ind][cnt] = f(s, ind + 1, cnt + 1, dp);
    //     }
    //     if (s.charAt(ind) == ')') {
    //         return dp[ind][cnt] = f(s, ind + 1, cnt - 1, dp);
    //     }
    //     // '*' can be '(', ')' or ''
    //     return dp[ind][cnt] = f(s, ind + 1, cnt + 1, dp) || f(s, ind + 1, cnt - 1, dp) || f(s, ind + 1, cnt, dp);
    // }

    // public boolean checkValidString(String s) {
    //     int n = s.length();
    //     Boolean[][] dp = new Boolean[n + 1][n + 1]; 
    //     return f(s, 0, 0, dp);
    // }

    public boolean checkValidString(String s) {
        int min=0,max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min=min+1;
                max=max+1;
            }
            else if(s.charAt(i)==')'){
                min=Math.max(0,min-1);
                max=max-1;
            }
            else{
                min=Math.max(0,min-1);
                max=max+1;
            }
            // EDGE CASE IF STRING STARTED WITH ')' then max will be negative so it will not in corrected, thats why return false
            if(max<0)return false;
        }
        return min==0;
    
    }
}
