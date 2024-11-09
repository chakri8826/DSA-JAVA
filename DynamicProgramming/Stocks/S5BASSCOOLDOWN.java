public class S5BASSCOOLDOWN {
    // public int search(int ind,int buy,int[] prices){
    //     if(ind>=prices.length){
    //         return 0;
    //     }
    //     int profit=0;
    //     if(buy==1){
    //         profit = Math.max(-prices[ind] + search(ind+1,0,prices),0+search(ind+1,1,prices));
    //     }
    //     if(buy==0){
    //         profit = Math.max(prices[ind] + search(ind+2,1,prices), 0+search(ind+1,0,prices));
    //     }
    //     return profit;
    // }

    
    // public int search(int ind,int buy,int[] prices,int dp[][]){
    //     if(ind>=prices.length){
    //         return 0;
    //     }
    //     if(dp[ind][buy]!=-1) return dp[ind][buy];
    //     int profit=0;
    //     if(buy==1){
    //         profit = Math.max(-prices[ind] + search(ind+1,0,prices,dp),0+search(ind+1,1,prices,dp));
    //     }
    //     if(buy==0){
    //         profit = Math.max(prices[ind] + search(ind+2,1,prices,dp), 0+search(ind+1,0,prices,dp));
    //     }
 
    //     return dp[ind][buy] = profit;
    // }

    // TABU
    // public int search(int n,int[] prices,int dp[][]){
    //     for(int b=0;b<2;b++){
    //         dp[prices.length][b]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
            // for(int buy=1;buy>=0;buy--){
            //     int profit=0;
            //     if(buy==1){
            //         profit = Math.max(-prices[ind] + dp[ind+1][0],0+dp[ind+1][1]);
            //     }
            //     if(buy==0){
            //         profit = Math.max(prices[ind] + dp[ind+2][1], 0+dp[ind+1][0]);
            //     }
            //     dp[ind][buy] = profit;
            // }
    //     }
    //     return dp[0][1];    // dp[0][1] is the optimal starting point since it reflects starting from day 0 with the choice to buy,
    // }


    //TABU2 AS BUY IS GOING TO 1 AND 0 WE CAN DIRECTLY PLACE THEM WITHOUT ANY LOOPS
    // public int search(int n,int[] prices,int dp[][]){
    //     for(int b=0;b<2;b++){
    //         dp[prices.length][b]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){                
    //         dp[ind][1] = Math.max(-prices[ind] + dp[ind+1][0],0+dp[ind+1][1]);
    //         dp[ind][0] = Math.max(prices[ind] + dp[ind+2][1], 0+dp[ind+1][0]);
    //     }
    //     return dp[0][1];    // dp[0][1] is the optimal starting point since it reflects starting from day 0 with the choice to buy,
    // }


    //SPACE OPTIMIZATION SEEE CLEARLY WE USED 3 ARRAYS
    public int search(int n, int[] prices) {
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2];
            for(int buy=1;buy>=0;buy--){
                    int profit=0;
                    if(buy==1){
                        profit = Math.max(-prices[ind] + front1[0],0+front1[1]);
                    }
                    if(buy==0){
                        profit = Math.max(prices[ind] + front2[1], 0+front1[0]);
                    }
                    curr[buy] = profit;
            }
            front2 = front1;   
            front1 = curr;     
        }

        return front1[1]; // dp[0][1] is the optimal starting point, as it reflects buying on day 0.
    }


    public int maxProfit(int[] prices) {
        // return search(0,1,prices);

        // int[][] dp = new int[prices.length][2];
        // for (int i = 0; i < prices.length; i++) {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return search(0,1,prices,dp);


        // int[][] dp = new int[prices.length+2][2];
        // return search(prices.length,prices,dp);


        return search(prices.length,prices);
    }
}
