public class S4LCpali {
    static void lcs(String s1, String s2) {

    int n=s1.length();
    int m=s2.length();

    int dp[][]=new int[n+1][m+1];
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=m;i++){
        dp[0][i] = 0;
    }
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    int len=dp[n][m];  


    //PRINTING THE Longest Palindromic Subsequence
    int i=n;
    int j=m;
    int index = len-1;
    String str="";
    for(int k=1; k<=len;k++){
        str +="$"; // dummy string
    }
 
    StringBuilder str2=new StringBuilder(str);
    while(i>0 && j>0){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            str2.setCharAt(index,s1.charAt(i-1) ); 
            index--;
            i--;
            j--;
        }
        else if(dp[i - 1][j] > dp[i][j - 1]){
            i--;
        }
        else j--;
    }
        System.out.println(str2);
}
    
    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public static void main(String args[]) {
        String s1= "bbbab";
        String s2= reverseString(s1);
        System.out.print("The Longest Common Subsequence is ");
        lcs(s1,s2);
    }
}



