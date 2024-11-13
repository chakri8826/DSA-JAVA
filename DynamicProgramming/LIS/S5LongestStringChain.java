import java.util.*;
class Mycmp implements Comparator<String>{
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}

public class S5LongestStringChain {
    public boolean compare(String a,String b){
        if (a.length()+1 != b.length()) return false;
        int i=0,j=0;
        while(j<b.length()){
            if(i<a.length() && a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        // if return true;
        return  i==a.length() && j==b.length();
    }

    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,new Mycmp());
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        int maxi=1,lastInd=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(compare(words[j],words[i]) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastInd=i;
            }
        }
        return maxi;
    }
}

