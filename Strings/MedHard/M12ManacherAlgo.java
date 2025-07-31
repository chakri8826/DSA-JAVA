public class M12ManacherAlgo {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("^");
        for(char ch:s.toCharArray()){
            sb.append(ch);
        }
        sb.append("$");
        String s1 = sb.toString();
        int n = s1.length();
        char T[] = s1.toCharArray();
        int rad[] = new int[n];
        int c=0,r=0,m=0;
        for(int i=1;i<n-1;i++){
            System.out.println("i: " + i + ",r: " + r);
            m = 2*c-i;
            if(i<r){
                System.out.println("Inside condition i: " + i + ",r: " + r);
                rad[i]= r-i;
            }
            while(T[i+rad[i]] == T[i-rad[i]])rad[i]++;
            if(i+rad[i]>r){
                
                c=i;
                r=i+rad[i];
            }
        }
    
        int maxLen=0,center=0;
        for(int i=1;i<n-1;i++){
            if(rad[i]>maxLen){
                maxLen=rad[i];
                center=i;
            }
        }
        int startInd = (center-maxLen)/2;
        return s.substring(startInd,startInd+maxLen);
    }
    public static void main(String[] args) {
        M12ManacherAlgo obj = new M12ManacherAlgo();
        String s = "aacabdkacaa";
        System.out.println("Longest Palindrome Substring: " + obj.longestPalindrome(s));
    }
}
