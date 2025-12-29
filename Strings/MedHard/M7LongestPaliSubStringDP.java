public class M7LongestPaliSubStringDP {
     // public boolean isPali(String str){
    //     int i=0,j=str.length()-1;
    //     while(i<j){
    //         if(str.charAt(i)!=str.charAt(j)){
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    
    // public String longestPalindrome(String s) {
    //     String res="";
    //     int n=s.length();
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             String str = s.substring(i,j+1);
    //             if(isPali(str) && str.length()>res.length()){
    //                 res=str;
    //             }
    //         }
    //     }
    //     return res;
    // }

    

    // public String longestPalindrome(String s) {
    //     int maxLen=1,n=s.length(),startInd=0;
    //     int dp[][] = new int[n][n];

    //     for(int i=0;i<n;i++) dp[i][i]=1;
    //     for(int i=0;i<n-1;i++){
    //         dp[i][i+1]=(s.charAt(i)==s.charAt(i+1))?1:0;
    //         if(dp[i][i+1]==1){
    //             maxLen=2;
    //             startInd=i;
    //         }
    //     }
    //     for(int k=2;k<n;k++){
    //         for(int i=0;i<n-k;i++){
    //             int j=i+k;
    //             if(s.charAt(i)==s.charAt(i+k) && dp[i+1][j-1]==1){
    //                 dp[i][j]=1;
    //                 if(k+1>maxLen){
    //                     maxLen=k+1;
    //                     startInd=i;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(startInd,startInd+maxLen);
        
    // }



    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int oddLen = expandAroundCenter(s,i,i);
            int evLen = expandAroundCenter(s,i,i+1);
            int len = Math.max(evLen,oddLen);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }   
    public int expandAroundCenter(String str,int i,int j){
        while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}

