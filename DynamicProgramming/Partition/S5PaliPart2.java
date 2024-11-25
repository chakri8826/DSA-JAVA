class S5PaliPart2{
    // public boolean isPali(String str){
    //     int n = str.length();
    //     if(n==1) return true;
    //     int i=0;
    //     while(i<n/2){
    //         if(str.charAt(i)!=str.charAt(n-1-i)){
    //             return false;
    //         }
    //         i++;
    //     }
    //     return true;
    // }


    // public int f(int i,String s,int n,int memo[]){
    //     if(i==n) return 0;
    //     if (memo[i] != -1) return memo[i];
    //     int mini = Integer.MAX_VALUE;
    //     String temp="";
    //     for(int j=i;j<n;j++){
    //         // String temp = s.substring(i, j+1);
    //         temp+=s.charAt(j);
    //         if(isPali(temp)){
    //             int cost = 1+f(j+1,s,n,memo);
    //             mini = Math.min(mini,cost);
    //         }
    //     }
    //     return memo[i] = mini;
    // }


    //TABULATION  (PALINDROME CHECK TLE ISTUNDI,  ANDUKE TABU  LO CONVERT CHESI IMPLEMENT CHESAMU)
    public int f(int n,String s,int dp[]){
        boolean isPali[][] = new boolean[s.length()+1][s.length()+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>=j) isPali[i][j] = true;
                else{
                    isPali[i][j] = s.charAt(i)==s.charAt(j) && isPali[i+1][j-1];
                }
            }
        }

        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPali[i][j]){
                    int cost = 1+dp[j+1];
                    mini = Math.min(mini,cost);
                }
            }
            dp[i] = mini;
        }
        return dp[0];
    }


    public int minCut(String s) {
        // return f(0,s,s.length())-1;

        // int[] memo = new int[s.length()];
        // Arrays.fill(memo, -1); 
        // return f(0,s,s.length(),memo)-1;

        int[] dp = new int[s.length()+1];
        return f(s.length(),s,dp)-1;
    }
}
