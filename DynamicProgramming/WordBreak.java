import java.util.*;

public class WordBreak {
    // static ArrayList<String> ans = new ArrayList<>();
    // public static void genSubs(String s,String c,int i){
    //     if(i==s.length()){
    //         ans.add(c);
    //         return;
    //     }
    //     genSubs(s, c+s.charAt(i), i+1);
    //     genSubs(s, c , i+1);

    // }
    // public static ArrayList<String> subs(String s){
    //     ans=new ArrayList<>();
    //     genSubs(s,"",0);
    //     return ans;
    // }

    //RECURSIVE APPRAOCH INCLUDES OVERLAPPING OF SUBPROBLEMS
    // public static boolean isValid(String s,List<String> wordDict){
    //     if(s.isEmpty())return true;
    //     for(int i=1;i<=s.length();i++){
    //         String ss=s.substring(0, i);
    //         if(wordDict.contains(ss) && isValid(s.substring(i),wordDict)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public static boolean isValid(String s,List<String> wordDict){
        int n=s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if( dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> wd = new ArrayList<>(Arrays.asList("leet","code"));
        // System.out.println(isValid("leetcode",wd));
        String s = "leetcode";
 
    }
}


