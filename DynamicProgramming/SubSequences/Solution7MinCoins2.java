import java.util.Arrays;

public class Solution7MinCoins2 {
    //  public int find(int[] coins, int amt, int ind) {
    //     if (ind == 0) return amt % coins[0] == 0?1:0;
    //     int dpick = find(coins, amt, ind - 1);
    //     int pick = 0;
    //     if (coins[ind] <= amt) {
    //         pick = find(coins, amt - coins[ind], ind);
    //     }
    //     return pick+dpick;
    // }


    // public int find(int[] coins, int amt, int ind,int dp[][]) {
    //     if (ind == 0) return amt % coins[0] == 0?1:0;
    //     if(dp[ind][amt]!=-1) return dp[ind][amt];
    //     int dpick = find(coins, amt, ind - 1, dp);
    //     int pick = 0;
    //     if (coins[ind] <= amt) {
    //         pick = find(coins, amt - coins[ind], ind, dp);
    //     }
    //     return dp[ind][amt] = pick+dpick;
    // }


    // public int find(int[] coins, int Amt, int n,int dp[][]) {
    //     for(int amt=0;amt<=Amt;amt++){
    //         if(amt % coins[0] == 0){
    //             dp[0][amt]=1;
    //         }
    //         else{
    //             dp[0][amt]=0;
    //         }
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         for(int amt=0;amt<=Amt;amt++){
    //             int dpick = dp[ind - 1][amt];
    //             int pick = 0;
    //             if (coins[ind] <= amt) {
    //                 pick = dp[ind][amt - coins[ind]];
    //             }
    //             dp[ind][amt] = pick+dpick;
    //         }
    //     }
    //     return dp[n-1][Amt];
    // }


    public int find(int[] coins, int Amt, int n) {
        int prev[] = new int[Amt+1];
        for(int amt=0;amt<=Amt;amt++){
            if(amt % coins[0] == 0){
                prev[amt]=1;
            }
            else{
                prev[amt]=0;
            }
        }
        for(int ind=1;ind<n;ind++){
            int curr[] = new int[Amt+1];
            for(int amt=0;amt<=Amt;amt++){
                int dpick = prev[amt];
                int pick = 0;
                if (coins[ind] <= amt) {
                    pick = curr[amt - coins[ind]];
                }
                curr[amt] = pick+dpick;
            }
            prev=curr;
        }
        return prev[Amt];
    }
    public int change(int amount, int[] coins) {
        //  return find(coins, amount, coins.length - 1);


        // int dp[][] = new int[coins.length][amount+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // int res = find(coins, amount, coins.length - 1,dp);
        // return res;
        
        
        // int dp[][] = new int[coins.length][amount+1];
        // return find(coins, amount, coins.length,dp);

        return find(coins, amount, coins.length);
    }
    public static void main(String[] args) {
        
    }
}
