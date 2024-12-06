import java.util.Arrays;

public class S2LongSubstrWithoutRepChars {
     public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int hash[] = new int[256];
        Arrays.fill(hash,-1);
        int l=0;
        int r=0;
        int maxlen=0;
        while(r<n){
            if(hash[s.charAt(r)]>=l){
                l=hash[s.charAt(r)]+1;
            }
            int len = r-l+1;
            hash[s.charAt(r)]=r;
            maxlen=Math.max(len,maxlen);
            r++;
        }   
        return maxlen;
    }
}
