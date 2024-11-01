import java.util.Arrays;
public class S1longCommonSubSeq {
    // public int checkLong(int i,int j,String text1,String text2){
    //     if(i<0 || j<0) return 0;
    //     if(text1.charAt(i)==text2.charAt(j)){
    //         return 1+checkLong(i-1,j-1,text1,text2);
    //     }
    //     return Math.max(checkLong(i-1,j,text1,text2),checkLong(i,j-1,text1,text2));
    // }


    // public int checkLong(int i,int j,String text1,String text2,int dp[][]){
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(text1.charAt(i)==text2.charAt(j)){
    //         return dp[i][j] = 1+checkLong(i-1,j-1,text1,text2,dp);
    //     }
    //     return dp[i][j] = Math.max(checkLong(i-1,j,text1,text2,dp),checkLong(i,j-1,text1,text2,dp));
    // }


    //SHIFTING ONE UNIT TO RIGHT WARDS
    // public int checkLong(int i,int j,String text1,String text2,int dp[][]){
    //     if(i==0 || j==0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(text1.charAt(i-1)==text2.charAt(j-1)){
    //         return dp[i][j] = 1+checkLong(i-1,j-1,text1,text2,dp);
    //     }
    //     return dp[i][j] = Math.max(checkLong(i-1,j,text1,text2,dp),checkLong(i,j-1,text1,text2,dp));
    // }


    // public int checkLong(int I,int J,String text1,String text2,int dp[][]){
    //     for(int j=0;j<=J;j++){
    //         dp[0][j] = 0;
    //     }
    //     for(int i=0;i<=I;i++){
    //         dp[i][0] = 0;
    //     }
    //     for(int i=1;i<=I;i++){
    //         for(int j=1;j<=J;j++){
    //             if(text1.charAt(i-1)==text2.charAt(j-1)){
    //                     dp[i][j] = 1+dp[i-1][j-1];
    //             }
    //             else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
    //         }
    //     }
    //     return dp[I][J];
    // }


    //SPACE OPTIMIZATION
    public int checkLong(int I,int J,String text1,String text2){
        int prev[] = new int[J+1];
        for(int j=0;j<=J;j++){
            prev[j] = 0;
        }
        // for(int i=0;i<=I;i++){
        //     dp[i][0] = 0;
        // }
        for(int i=1;i<=I;i++){
            int curr[] = new int[J+1];
            for(int j=1;j<=J;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                        curr[j] = 1+prev[j-1];
                }
                else curr[j] = Math.max(prev[j],curr[j-1]);
            }
            prev=curr;
        }
        return prev[J];
    }




    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // return checkLong(n-1,m-1,text1,text2);

        // int dp[][] = new int[n][m]; 
        // int dp[][] = new int[n+1][m+1]; //FOR RIGHT SHIFT
        // for(int row[] : dp){
        //     Arrays.fill(row,-1);
        // }
        // return checkLong(n-1,m-1,text1,text2,dp);


        // int dp[][] = new int[n+1][m+1];
        // return checkLong(n,m,text1,text2,dp);

        return checkLong(n,m,text1,text2);
    }
    public static void main(String[] args) {
        
    }    
}
