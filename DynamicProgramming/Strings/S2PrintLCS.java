import java.util.*;

class S2PrintLCS{
//placing values from last index
// static void lcs(String s1, String s2) {
//     int n=s1.length();
//     int m=s2.length();

//     int dp[][]=new int[n+1][m+1];
//     for(int i=0;i<=n;i++){
//         dp[i][0] = 0;
//     }
//     for(int i=0;i<=m;i++){
//         dp[0][i] = 0;
//     }
    
//     for(int ind1=1;ind1<=n;ind1++){
//         for(int ind2=1;ind2<=m;ind2++){
//             if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
//                 dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
//             else
//                 dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
//         }
//     }
    
//     int len=dp[n][m];
//     int i=n;
//     int j=m;
    
//     int index = len-1;
//     String str="";
//     for(int k=1; k<=len;k++){
//         str +="$"; // dummy string
//     }
//     // StringBuilder ss= new StringBuilder(s1);
//     StringBuilder str2=new StringBuilder(str);
//     while(i>0 && j>0){
//         if(s1.charAt(i-1) == s2.charAt(j-1)){
//             str2.setCharAt(index,s1.charAt(i-1) ); 
//             index--;
//             i--;
//             j--;
//         }
//         else if(dp[i - 1][j] > dp[i][j - 1]){
//             i--;
//         }
//         else j--;
//     }
//     System.out.println(str2);
// }


//DIRECTLY ADDING TO STR FROM STARTING INDEXES AND AT LAST REVERSING IT(BETTER APPROACH)
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
                dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    
    // int len=dp[n][m];
    int i=n;
    int j=m;
    
 
    StringBuilder str2=new StringBuilder();
    while(i>0 && j>0){
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            str2.append(s1.charAt(i-1));
            i--;
            j--;
        }
        else if(dp[i - 1][j] > dp[i][j - 1]){
            i--;
        }
        else j--;
    }
    System.out.println(str2.reverse().toString());
}


public static void main(String args[]) {

  String s1= "abcdgh";
  String s2= "acdghr";
  System.out.print("The Longest Common Subsequence is ");
  lcs(s1,s2);
}
}