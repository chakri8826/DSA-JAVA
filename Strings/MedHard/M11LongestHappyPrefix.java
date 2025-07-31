public class M11LongestHappyPrefix {
    public int[] computeLps(String s){
        int n=s.length();
        int lps[] = new int[n];
        int i=0,j=1;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }
            else if(i==0)j++;
            else i=lps[i-1];
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int n=s.length();
        int lps[] = computeLps(s);
        int len=lps[n-1];
        return s.substring(0,len);
    }

    // BRUTE FORCE
    // public String longestPrefix(String s) {
    //     int n = s.length();
    //     for (int len = n - 1; len > 0; len--) {
    //         if (s.substring(0, len).equals(s.substring(n - len))) {
    //             return s.substring(0, len);
    //         }
    //     }
    //     return "";
    // }
}
