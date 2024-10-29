import java.util.*;
public class Solution7MinCoins {
    // public int find(int[] coins, int amt, int ind) {
    //     if(ind==0){
    //         if(amt%coins[0]==0) return amt/coins[0];
    //         else return (int) 1e8;
    //     }
    //     int dpick = find(coins, amt, ind - 1);
    //     int pick = Integer.MAX_VALUE;
    //     if (coins[ind] <= amt) {
    //         pick = 1 + find(coins, amt - coins[ind], ind);
    //     }
    //     return Math.min(pick, dpick);
    // }


    // public int find(int[] coins, int amt, int ind, int dp[][]) {
    //     if(ind==0){
    //         if(amt%coins[0]==0) return amt/coins[0];
    //         else return (int) 1e8;
    //     }
    //     if(dp[ind][amt]!=-1) return dp[ind][amt];
    //     int dpick = find(coins, amt, ind - 1, dp);
    //     int pick = Integer.MAX_VALUE;
    //     if (coins[ind] <= amt) {
    //         pick = 1 + find(coins, amt - coins[ind], ind, dp);
    //     }
    //     return dp[ind][amt] = Math.min(pick, dpick);
    // }


    // public int find(int[] coins, int Amt, int n, int dp[][]){
    //     for(int amt = 0;amt<=Amt;amt++){
    //         if(amt%coins[0]==0){
    //             dp[0][amt] = amt/coins[0];
    //         }
    //         else{
    //             dp[0][amt] = (int) 1e8;
    //         }
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         for(int amt=0;amt<=Amt;amt++){
    //             int dpick = dp[ind-1][amt];
    //             int pick = Integer.MAX_VALUE;
    //             if (coins[ind] <= amt) {
    //                 pick = 1 + dp[ind][amt - coins[ind]];
    //             }
    //             dp[ind][amt] = Math.min(pick, dpick);
    //         }
    //     }
    //     return dp[n-1][Amt];
    // }


    public int find(int[] coins, int Amt, int n){
        int prev[] = new int[Amt+1];
        for(int amt = 0;amt<=Amt;amt++){
            if(amt%coins[0]==0){
                prev[amt] = amt/coins[0];
            }
            else{
                prev[amt] = (int) 1e8;
            }
        }
        for(int ind=1;ind<n;ind++){
            int curr[] = new int[Amt+1];
            for(int amt=0;amt<=Amt;amt++){
                int dpick = prev[amt];
                int pick = Integer.MAX_VALUE;
                //here we are not going to ind-1 so using curr itself
                if (coins[ind] <= amt) {
                    pick = 1 + curr[amt - coins[ind]];
                }
                curr[amt] = Math.min(pick, dpick);
            }
            prev=curr;
        }
        return prev[Amt];
    }


    public int coinChange(int[] coins, int amount) {
        // int res = find(coins, amount, coins.length - 1);
        // return res >= (int) 1e8 ? -1 : res;
        
        
        // int dp[][] = new int[coins.length][amount+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // int res = find(coins, amount, coins.length - 1,dp);
        // return res >= (int) 1e8 ? -1 : res;


        // int dp[][] = new int[coins.length][amount+1];
        // int res = find(coins, amount, coins.length,dp);
        // return res >= (int) 1e8 ? -1 : res;


        int res = find(coins, amount, coins.length);
        return res >= (int) 1e8 ? -1 : res;
    }
    public static void main(String[] args) {
        
    }
}
