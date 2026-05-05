import java.util.Arrays;
public class M14KMP2 {
    
        public void lps(String patt, int lps[]){
            int i=0,j=1,n=patt.length();
            while(j<n){
                if(patt.charAt(i)==patt.charAt(j)){
                    lps[j]=i+1;
                    i++;j++;
                }
                else if(i==0)j++;
                else i=lps[i-1];
            }
        }
        
        public int pattMatch(String str, String patt){
            int m=str.length(),n=patt.length();
            int i=0,j=0;
            int lps[] = new int[n];
            lps(patt,lps);
            System.out.println(Arrays.toString(lps));
            while(i<m){
                System.out.println(i+" "+j);
                if(str.charAt(i)==patt.charAt(j)){
                    i++;
                    j++;
                    if(j==n)return i-j;
                }
                // System.out.println("else "+i+" "+j);
                else if(j==0)i++;
                else j=lps[j-1];
            }
            return -1;
        }
        public int strStr(String haystack, String needle) {
            return pattMatch(haystack,needle);
        }
        public static void main(String[] args) {
            M14KMP2 obj = new M14KMP2();
            String haystack = "sadbutsad";
            String needle = "sad";
            System.out.println(obj.strStr(haystack,needle));
        }
}
