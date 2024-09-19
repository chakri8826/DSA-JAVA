import java.util.*;

public class substrings {
    static ArrayList<String> ans = new ArrayList<>();
    public static void genSubs(String s,String c,int i){
        if(i==s.length()){
            ans.add(c);
            return;
        }
        genSubs(s, c+s.charAt(i), i+1);
        genSubs(s, c , i+1);

    }
    public static ArrayList<String> subs(String s){
        ans=new ArrayList<>();
        genSubs(s,"",0);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(subs("leetcode"));
    }
}
