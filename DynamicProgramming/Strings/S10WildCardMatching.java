public class S10WildCardMatching {
   // public boolean check(int i,int j,String s1,String s2){
    //     if(i<0 && j<0) return true;
    //     if(i<0 && j>=0) return false;
    //     if(j<0 && i>=0){
    //         for(int k=0;k<=i;k++){
    //             if(s1.charAt(k)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
    //         return check(i-1,j-1,s1,s2);
    //     }
    //     if(s1.charAt(i)=='*'){
    //         return check(i-1,j,s1,s2) || check(i,j-1,s1,s2);
    //     }
    //     return false;
    // }

    //0-BASED INDEXING
    // public int check(int i,int j,String s1,String s2,int dp[][]){
    //     if(i<0 && j<0) return 1;
    //     if(i<0 && j>=0) return 0;
    //     if(j<0 && i>=0){
    //         for(int k=0;k<=i;k++){
    //             if(s1.charAt(k)!='*'){
    //                 return 0;
    //             }
    //         }
    //         return 1;
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?'){
    //         return  dp[i][j] = check(i-1,j-1,s1,s2,dp);
    //     }
    //     if(s1.charAt(i)=='*'){
    //         return dp[i][j] = (check(i-1,j,s1,s2,dp)==1 || check(i,j-1,s1,s2,dp)==1)?1:0;
    //     }
        
    //     return dp[i][j]=0;
    // }


    //1 BASED INDEXING
    // public int check(int i,int j,String s1,String s2,int dp[][]){
        // if(i==0 && j==0) return 1;
        // if(i==0 && j>0) return 0;
        // if(j==0 && i>0){
        //     for(int k=1;k<=i;k++){
        //         if(s1.charAt(k-1)!='*'){
        //             return 0;
        //         }
        //     }
        //     return 1;
        // }
        // if(dp[i][j]!=-1) return dp[i][j];
        // if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
        //     return  dp[i][j] = check(i-1,j-1,s1,s2,dp);
        // }
        // if(s1.charAt(i-1)=='*'){
        //     return dp[i][j] = (check(i-1,j,s1,s2,dp)==1 || check(i,j-1,s1,s2,dp)==1)?1:0;
        // }
        
        // return dp[i][j]=0;
    // }


    //TABULAITON
    // public int check(int n,int m,String s1,String s2,int dp[][]){
    //     dp[0][0]=1;
    //     for(int j=1;j<=m;j++){
    //         dp[0][j]=0;
    //     }
    //     for(int i=1;i<=n;i++){
    //         int flag=1;
    //         for(int k=1;k<=i;k++){
    //             if(s1.charAt(k-1)!='*'){
    //                 flag=0;
    //                 break;
    //             }
    //         }
    //         dp[i][0]=flag;
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=m;j++){
    //             if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
    //                 dp[i][j] = dp[i-1][j-1];
    //             }
    //             else if(s1.charAt(i-1)=='*'){
    //                 dp[i][j] = (dp[i-1][j]==1 || dp[i][j-1]==1)?1:0;
    //             }
    //             else{
    //                 dp[i][j]=0;
    //             }
    //         }
    //     }
    //     return dp[n][m];
    // }


    //SPACE OPTIMIZATION
    public int check(int n,int m,String s1,String s2){
        int prev[] = new int[m+1];
        prev[0]=1;
        for(int j=1;j<=m;j++){
            prev[j]=0;
        }
        for(int i=1;i<=n;i++){
            int curr[]=new int[m+1];
            int flag=1;
            for(int k=1;k<=i;k++){
                if(s1.charAt(k-1)!='*'){
                    flag=0;
                    break;
                }
            }
            curr[0]=flag;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    curr[j] = prev[j-1];
                }
                else if(s1.charAt(i-1)=='*'){
                    curr[j] = (prev[j]==1 || curr[j-1]==1)?1:0;
                }
                else{
                    curr[j] = 0;
                }
            }
            prev=curr;
        }
        return prev[m];
    }



    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();
        // return check(n-1,m-1,p,s);


        //0-BASED INDEX
        // if(n==0 && m==0) return true;
        // int dp[][] = new int[n][m];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
        // return check(n-1,m-1,p,s,dp)==1;


        //1-BASED INDEX
        // int dp[][] = new int[n+1][m+1];
        // for(int row[]: dp){
        //     Arrays.fill(row,-1);
        // }
        // return check(n,m,p,s,dp)==1;


        //TABULAITON
        // int dp[][] = new int[n+1][m+1];
        // return check(n,m,p,s,dp)==1;


        //SPACE OPTIMIZATION
        return check(n,m,p,s)==1;
    }
}


