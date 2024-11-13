public class S4EvaluateBooleanToTrue {
    static final int mod = 1003;
    // public static int f(int i,int j,int isTrue,String s){
    //     if(i>j) return 0;
    //     if(i==j){
    //         if(isTrue==1) return s.charAt(i)=='T' ? 1:0;
    //         else return s.charAt(i)=='F'? 1:0;
    //     }
    //     int ways=0;
    //     for(int ind=i+1;ind<=j;ind=ind+2){
    //         int lT = f(i,ind-1,1,s);
    //         int lF = f(i,ind-1,0,s);
    //         int rT = f(ind+1,j,1,s);
    //         int rF = f(ind+1,j,0,s);
    //         if(s.charAt(ind)=='&'){
    //             if(isTrue==1) ways = (ways + (lT*rT) % mod) % mod;
    //             else ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lF*rF) % mod) % mod;
    //         }
    //         else if(s.charAt(ind)=='|'){
    //             if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lT*rT) % mod) % mod;
    //             else ways = (ways + (lF*rF) % mod) % mod;
    //         }
    //         else{
    //             if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod) % mod;
    //             else ways = (ways + (lF*rF) % mod + (lT*rT) % mod) % mod;
    //         }
    //     }
    //     return ways;
    // }
    
    
    // public static int f(int i,int j,int isTrue,String s,int dp[][][] ){
    //     if(i>j) return 0;
        // if(i==j){
        //     if(isTrue==1) return s.charAt(i)=='T' ? 1:0;
        //     else return s.charAt(i)=='F'? 1:0;
        // }
    //     if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
    //     int ways=0;
    //     for(int ind=i+1;ind<=j;ind=ind+2){
    //         int lT = f(i,ind-1,1,s,dp);
    //         int lF = f(i,ind-1,0,s,dp);
    //         int rT = f(ind+1,j,1,s,dp);
    //         int rF = f(ind+1,j,0,s,dp);
    //         if(s.charAt(ind)=='&'){
    //             if(isTrue==1) ways = (ways + (lT*rT) % mod) % mod;
    //             else ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lF*rF) % mod) % mod;
    //         }
    //         else if(s.charAt(ind)=='|'){
    //             if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lT*rT) % mod) % mod;
    //             else ways = (ways + (lF*rF) % mod) % mod;
    //         }
    //         else{
    //             if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod) % mod;
    //             else ways = (ways + (lF*rF) % mod + (lT*rT) % mod) % mod;
    //         }
    //     }
    //     return dp[i][j][isTrue] = ways;
    // }
    
    
    public static int f(int n,String s,int dp[][][]){
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>j) continue;
                for(int isTrue=0;isTrue<2;isTrue++){
                    if(i==j){
                        if(isTrue==1) dp[i][j][isTrue] = s.charAt(i)=='T' ? 1:0;
                        else dp[i][j][isTrue] = s.charAt(i)=='F'? 1:0;
                        continue;
                    }
                    int ways=0;
                    for(int ind=i+1;ind<j;ind=ind+2){
                        int lT = dp[i][ind-1][1];
                        int lF = dp[i][ind-1][0];
                        int rT = dp[ind+1][j][1];
                        int rF = dp[ind+1][j][0];
                        if(s.charAt(ind)=='&'){
                            if(isTrue==1) ways = (ways + (lT*rT) % mod) % mod;
                            else ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lF*rF) % mod) % mod;
                        }
                        else if(s.charAt(ind)=='|'){
                            if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod + (lT*rT) % mod) % mod;
                            else ways = (ways + (lF*rF) % mod) % mod;
                        }
                        else{
                            if(isTrue==1) ways = (ways + (lF*rT) % mod + (lT*rF) % mod) % mod;
                            else ways = (ways + (lF*rF) % mod + (lT*rT) % mod) % mod;
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][n-1][1];
    }
    
    static int countWays(int n, String s){
        // return f(0,n-1,1,s);
        
        
        // int dp[][][] = new int[n][n][2];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         for(int k=0;k<2;k++){
        //             dp[i][j][k]=-1;
        //         }
        //     }
        // }
        // return f(0,n-1,1,s,dp);
        
        
        int dp[][][] = new int[n+2][n+2][2];
        return f(n,s,dp);
    }
}
