public class S11MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int hash[] = new int[256];
        int l=0,r=0,m=s.length(),n=t.length(),sind=-1,cnt=0,minlen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            hash[t.charAt(i)]++;
        }
        while(r<m){
            if(hash[s.charAt(r)]>0) cnt++;
            hash[s.charAt(r)]--;
            while(cnt==n){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sind=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt=cnt-1;
                l++;
            }
            r++;
        }
        return sind==-1?"":s.substring(sind,sind+minlen);
    }
}

