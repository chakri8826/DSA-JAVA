import java.util.ArrayList;
public class M14KMPAlgo {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Create LPS (Longest Prefix Suffix) array
        int[] lps = new int[m];
        computeLps(pat,lps);

        int i = 0; // Pointer for txt
        int j = 0; // Pointer for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            else if(j==0) i++;
            else j=lps[j-1];
            if (j == m) {
                result.add(i - j); // Pattern found
                j = lps[j - 1];
            }
        }
        return result;
    }

    public void computeLps(String s,int[] lps ){
        int n=s.length();
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
    }
}
