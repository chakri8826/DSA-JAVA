public class S2BASS2 {
    // public int search(int ind,int buy,int[] prices){
    //     if(ind==prices.length){
    //         return 0;
    //     }
    //     int profit=0;
    //     if(buy==1){
    //         profit = Math.max(-prices[ind] + search(ind+1,0,prices),0+search(ind+1,1,prices));
    //     }
    //     if(buy==0){
    //         profit = Math.max(prices[ind] + search(ind+1,1,prices), 0+search(ind+1,0,prices));
    //     }
    //     return profit;
    // }


    // public int search(int ind,int buy,int[] prices,int dp[][]){
    //     if(ind==prices.length){
    //         return 0;
    //     }
    //     if(dp[ind][buy]!=-1) return dp[ind][buy];
    //     int profit=0;
    //     if(buy==1){
    //         profit = Math.max(-prices[ind] + search(ind+1,0,prices,dp),0+search(ind+1,1,prices,dp));
    //     }
    //     if(buy==0){
    //         profit = Math.max(prices[ind] + search(ind+1,1,prices,dp), 0+search(ind+1,0,prices,dp));
    //     }
 
    //     return dp[ind][buy] = profit;
    // }



    // public int search(int n,int[] prices,int dp[][]){
    //     for(int b=0;b<2;b++){
    //         dp[prices.length][b]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
            // for(int buy=0;buy<2;buy++){ // WE CAN USE ANYOF THE ONE
    //         for(int buy=1;buy>=0;buy--){
    //             int profit=0;
    //             if(buy==1){
    //                 profit = Math.max(-prices[ind] + dp[ind+1][0],0+dp[ind+1][1]);
    //             }
    //             if(buy==0){
    //                 profit = Math.max(prices[ind] + dp[ind+1][1], 0+dp[ind+1][0]);
    //             }
    //             dp[ind][buy] = profit;
    //         }
    //     }
    //     return dp[0][1];
    // }


    // public int search(int n,int[] prices){
    //     int prev[] = new int[2];
    //     for(int b=0;b<2;b++){
    //         prev[b]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
    //         int curr[] = new int[2];
    //         for(int buy=1;buy>=0;buy--){
    //             int profit=0;
    //             if(buy==1){
    //                 profit = Math.max(-prices[ind] + prev[0],0+prev[1]);
    //             }
    //             else{
    //                 profit = Math.max(prices[ind] + prev[1], 0+prev[0]);
    //             }
    //             curr[buy] = profit;
    //         }
    //         prev=curr;
    //     }
    //     return prev[1];
    // }


    public int search(int n,int[] prices){
        int aheadNotBuy,aheadBuy,currBuy,currNotBuy;
        aheadNotBuy=aheadBuy=0; // rendu 0 tho initialize chesame paina kuda so do the same
        for(int ind=n-1;ind>=0;ind--){
                currBuy = Math.max(-prices[ind] + aheadNotBuy,0+aheadBuy);
                currNotBuy = Math.max(prices[ind] +aheadBuy, 0+aheadNotBuy);
                aheadBuy=currBuy;
                aheadNotBuy=currNotBuy;
        }
        return aheadBuy;
    }



    public int maxProfit(int[] prices) {
        // return search(0,1,prices);

        // int[][] dp = new int[prices.length][2];
        // for (int i = 0; i < prices.length; i++) {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return search(0,1,prices,dp);


        // int[][] dp = new int[prices.length+1][2];
        // return search(prices.length,prices,dp);

        return search(prices.length,prices);
    }
    public static void main(String[] args) {
        S2BASS2 s = new S2BASS2();
        int prices[] = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}



