public class S4BASS4 {
    // public int search(int ind,int k,int[] prices,int trans){
    //     if(ind==prices.length || trans==2*k){
    //         return 0;
    //     }
    //     int profit=0;
    //     if(trans%2==0){
    //         profit=Math.max(-prices[ind] + search(ind+1,k,prices,trans+1),0 + search(ind+1,k,prices,trans));
    //     }
    //     else{
    //         profit=Math.max(prices[ind] + search(ind+1,k,prices,trans+1),0 + search(ind+1,k,prices,trans));
    //     }
    //     return profit;
    // }


    //TABULATION
    // public int search(int n,int k,int[] prices,int dp[][]){
    //     for(int t=0;t<2*k;t++){
    //         dp[prices.length][t]=0;
    //     }
    //     for(int i=0;i<n;i++){
    //         dp[i][2*k]=0;
    //     }
    //     for(int ind=n-1;ind>=0;ind--){
    //         for(int trans=0;trans<2*k;trans++){
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


    //SPACE OPTIMIZATION
    public int search(int n,int k,int[] prices){
        int prev[] = new int[2*k+1];
        for(int t=0;t<2*k;t++){
            prev[t]=0;
        }
        for(int ind=n-1;ind>=0;ind--){
            int curr[] = new int[2*k+1];
            curr[2*k]=0;   //Ensures dp[i][4] = 0 boundary condition
            for(int trans=0;trans<2*k;trans++){
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


    public int maxProfit(int k, int[] prices) {
        //TABULATION
        // int dp[][] = new int[prices.length+1][2*k+1];
        // return search(prices.length,k,prices,dp);

        //SPACE OPTIMIZATION
        return search(prices.length,k,prices);
    }
}





