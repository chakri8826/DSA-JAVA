import java.util.*;
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    public  boolean isPali(String s){
        int n=s.length();
        if(s.length()==1){
            return true;
        }
        int i=0;
        while(i<s.length()/2){
            if(s.charAt(i)!=s.charAt(n-1-i)){
                return false;
            }
            i++;
        }
        return true;
    }
    public void perfectPalis(String s, List<String> curr,int i){
        if(i==s.length()){
            res.add(new ArrayList<>(curr));
        }
        for(int j=i;j<s.length();j++){
            String subStr = s.substring(i, j+1);
            if(isPali(subStr)){
                curr.add(subStr);
                perfectPalis(s, curr, j+1);
                curr.remove(curr.size()-1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        perfectPalis(s, new ArrayList<>(), 0);
        return res;
    }
    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aabb"));
    }
}






