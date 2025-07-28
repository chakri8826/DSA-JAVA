public class M10ShortestPalindrome {
    public String reverse(String str){
        char[] arr = str.toCharArray();
        int i=0,j=str.length()-1;
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public boolean isPali(String str){
        int i=0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int findMaxPali(String s){
        for(int i=s.length();i>=1;i--){
            if(isPali(s.substring(0,i)))return i;
        }
        return -1;
    }

    // BRUTE
    // public String shortestPalindrome(String s) {
    //     if(s.equals(""))return "";
    //     int i = findMaxPali(s);
    //     String word = s.substring(i,s.length());
    //     String reversed = reverse(word);
    //     return reversed!=""?reversed+s:s;
    // }



    // OPTIMIZED
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString(); //O(n)
        String combined = s+"#"+rev; //O(2n+1)
        int lps[] = findLps(combined); //O(n)
        int lenLongPali = lps[lps.length-1]; //O(1)
        String suff = s.substring(lenLongPali); //O(n)
        String pref = new StringBuilder(suff).reverse().toString(); //O(n)
        return pref+s; //O(n)
    }
    public int[] findLps(String str){ //O(n)
        int n = str.length();
        int lps[] = new int[n];
        int i=0,j=1; //O(1)
        while(j<n){
            if(str.charAt(i)==str.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }
            else if(i==0)j++;
            else i=lps[i-1];
        }
        return lps;
    }
}
