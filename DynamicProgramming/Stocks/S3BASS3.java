public class S3BASS3 {
    // public int check(int ind,int buy,int[] prices,int bound){
    //     if(ind==prices.length){
    //         return 0;
    //     }
    //     if(bound==0) return 0;
    //     int profit=0;
    //     if(buy==1){
    //         profit=Math.max(-prices[ind] + check(ind+1,0,prices,bound),0 + check(ind+1,1,prices,bound));
    //     }
    //     else{
    //         profit=Math.max(prices[ind] + check(ind+1,1,prices,bound-1),0 + check(ind+1,0,prices,bound));
    //     }
    //     return profit;
    // }


    // public int search(int ind, int buy, int[] prices, int[][][] dp, int bound) {
    //     if (ind == prices.length || bound == 0) {
    //         return 0;
    //     }
        
    //     if (dp[ind][buy][bound] != -1) return dp[ind][buy][bound];
        
    //     int profit = 0;
        
    //     if (buy == 1) {
    //         profit = Math.max(-prices[ind] + search(ind + 1, 0, prices, dp, bound), 
    //                         search(ind + 1, 1, prices, dp, bound));
    //     } else {
    //         profit = Math.max(prices[ind] + search(ind + 1, 1, prices, dp, bound - 1), 
    //                         search(ind + 1, 0, prices, dp, bound));
    //     }
    //     return dp[ind][buy][bound] = profit;
    // }


    // public int search(int n,int[] prices,int dp[][][]){
    //     for(int b=0;b<2;b++){
    //         for(int bou=0;bou<3;bou++){
    //             dp[prices.length][b][bou]=0;
    //         }
    //     }
    //     for(int i=0;i<n;i++){
    //         for(int b=0;b<2;b++){
    //             dp[i][b][0]=0;
    //         }
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
    //         for(int buy=0;buy<2;buy++){  
    //             for(int bou=1;bou<3;bou++){
    //                 int profit=0;
    //                 if(buy==1){
    //                     profit = Math.max(-prices[ind] + dp[ind+1][0][bou],0+dp[ind+1][1][bou]);
    //                 }
    //                 if(buy==0){
    //                     profit = Math.max(prices[ind] + dp[ind+1][1][bou-1], 0+dp[ind+1][0][bou]);
    //                 }
    //                 dp[ind][buy][bou] = profit;
    //             }   
    //         }
    //     }
    //     return dp[0][1][2];    // dp[0][1][2] is the optimal starting point since it reflects starting from day 0 with the choice to buy,
    // }


    // public int search(int n,int[] prices){
    //     int prev[][] = new int[2][3];
    //     for(int b=0;b<2;b++){
    //         for(int bou=0;bou<3;bou++){
    //             prev[b][bou]=0;
    //         }
    //     }
    //     for(int i=0;i<n;i++){
    //         for(int b=0;b<2;b++){
    //             prev[b][0]=0;
    //         }
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
    //         int curr[][] = new int[2][3];
    //         for(int buy=0;buy<2;buy++){  
    //             for(int bou=1;bou<3;bou++){
    //                 int profit=0;
    //                 if(buy==1){
    //                     profit = Math.max(-prices[ind] + prev[0][bou],0+prev[1][bou]);
    //                 }
    //                 if(buy==0){
    //                     profit = Math.max(prices[ind] + prev[1][bou-1], 0+prev[0][bou]);
    //                 }
    //                 curr[buy][bou] = profit;
    //             }   
    //         }
    //         prev=curr;
    //     }
    //     return prev[1][2];    // dp[0][1][2] is the optimal starting point since it reflects starting from day 0 with the choice to buy,
    // }




//USING TRANSACTION
    // public int search(int ind,int[] prices,int trans){
    //     if(ind==prices.length || trans==4){
    //         return 0;
    //     }
    //     int profit=0;
    //     if(trans%2==0){
    //         profit=Math.max(-prices[ind] + search(ind+1,prices,trans+1),0 + search(ind+1,prices,trans));
    //     }
    //     else{
    //         profit=Math.max(prices[ind] + search(ind+1,prices,trans+1),0 + search(ind+1,prices,trans));
    //     }
    //     return profit;
    // }


    // public int search(int ind,int[] prices,int trans,int dp[][]){
    //     if(ind==prices.length || trans==4){
    //         return 0;
    //     }
    //     if(dp[ind][trans]!=-1) return dp[ind][trans];
    //     int profit=0;
    //     if(trans%2==0){
    //         profit=Math.max(-prices[ind] + search(ind+1,prices,trans+1,dp),0 + search(ind+1,prices,trans,dp));
    //     }
    //     else{
    //         profit=Math.max(prices[ind] + search(ind+1,prices,trans+1,dp),0 + search(ind+1,prices,trans,dp));
    //     }
    //     return dp[ind][trans] =profit;
    // }


    // public int search(int n,int[] prices,int dp[][]){
    //     for(int t=0;t<4;t++){
    //         dp[prices.length][t]=0;
    //     }
    //     for(int i=0;i<n;i++){
    //         dp[i][4]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
    //         for(int trans=0;trans<4;trans++){
    //             int profit=0;
    //             if(trans%2==0){
    //                 profit=Math.max(-prices[ind] + dp[ind+1][trans+1],0 + dp[ind+1][trans]);
    //             }
    //             else{
    //                 profit=Math.max(prices[ind] + dp[ind+1][trans+1],0 + dp[ind+1][trans]);
    //             }
    //             dp[ind][trans] =profit;
    //         }
    //     }
    //     return dp[0][0];
    // }


    public int search(int n,int[] prices){
        int prev[] = new int[5];
        for(int t=0;t<4;t++){
            prev[t]=0;
        }
        for(int ind=n-1;ind>=0;ind--){
            int curr[] = new int[5];
            curr[4]=0;   //Ensures dp[i][4] = 0 boundary condition
            for(int trans=0;trans<4;trans++){
                int profit=0;
                if(trans%2==0){
                    profit=Math.max(-prices[ind] + prev[trans+1],0 + prev[trans]);
                }
                else{
                    profit=Math.max(prices[ind] + prev[trans+1],0 + prev[trans]);
                }
                curr[trans] =profit;
            }
            prev=curr;
        }
        return prev[0];
    }




    public int maxProfit(int[] prices) {
        // int[][][] dp = new int[prices.length][2][3];
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         for (int k = 0; k < 3; k++) {
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }
        // return search(0, 1, prices, dp, 2);


        // int[][][] dp = new int[prices.length+1][2][3];
        // return search(prices.length,prices,dp);


        // return search(prices.length,prices);




        //USING TRANSACTION
        // return search(0,prices,0);


        // int dp[][] = new int[prices.length][5];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return search(prices.length,prices,0,dp);


        // int dp[][] = new int[prices.length+1][5];
        // return search(prices.length,prices,dp);


        return search(prices.length,prices);



    }
}
