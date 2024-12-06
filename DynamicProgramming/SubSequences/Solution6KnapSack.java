import java.util.*;
public class Solution6KnapSack {
    // static int steal(int W, int wt[], int val[],int ind){
    //     if(ind==0){
    //         if(wt[0]<=W){
    //             return val[0];
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     int nottake = steal(W,wt,val,ind-1);
    //     int take = Integer.MIN_VALUE;
    //     if(wt[ind]<=W){
    //         take = val[ind] + steal(W-wt[ind],wt,val,ind-1);
    //     }
    //     return Math.max(take,nottake);   
    // }


    // static int steal(int W, int wt[], int val[],int ind, int dp[][] ){
    //     if(ind==0){
    //         if(wt[0]<=W){
    //             return val[0];
    //         }
    //         else{
    //             return 0;
    //         }
    //     }
    //     if(dp[ind][W]!=-1) return dp[ind][W];
    //     int nottake = steal(W,wt,val,ind-1,dp);
    //     int take = Integer.MIN_VALUE;
    //     if(wt[ind]<=W){
    //         take = val[ind] + steal(W-wt[ind],wt,val,ind-1,dp);
    //     }
    //     return dp[ind][W] = Math.max(take,nottake);
    // }


    // static int steal(int W, int wt[], int val[],int n, int dp[][] ){
    //         for (int w = 0; w <= W; w++) {
    //             if (wt[0] <= w) {
    //                 dp[0][w] = val[0];
    //             }
    //         }
    //         for(int i=1;i<n;i++){
    //             for(int w = 0;w<=W;w++){
    //                 int nottake = dp[i-1][w];
    //                 int take = Integer.MIN_VALUE;
    //                 if(wt[i]<=w){
    //                     take = val[i] + dp[i-1][w-wt[i]];
    //                 }
    //                 dp[i][w] = Math.max(take,nottake);
    //             }
    //         }
    //         return dp[n-1][W];
    // }


    // static int steal(int W, int wt[], int val[],int n){
    //     int prev[] = new int[W+1];
    //         for (int w = 0; w <= W; w++) {
    //             if (wt[0] <= w) {
    //                 prev[w] = val[0];
    //             }
    //         }
    //         for(int i=1;i<n;i++){
    //             int curr[] = new int[W+1];
    //             for(int w = 0;w<=W;w++){
    //                 int nottake = prev[w];
    //                 int take = Integer.MIN_VALUE;
    //                 if(wt[i]<=w){
    //                     take = val[i] + prev[w-wt[i]];
    //                 }
    //                 curr[w] = Math.max(take,nottake);
    //             }
    //             prev=curr;
    //         }
    //         return prev[W];
    // }




    //FURTHER OPTIMIZATION FOR SINGLE ARRAY SPACE
    static int steal(int W, int wt[], int val[],int n){
            int prev[] = new int[W+1];
                for (int w = wt[0]; w <= W; w++) {
                    if (wt[0] <= w) {
                        prev[w] = val[0];
                    }
                }
                for(int i=1;i<n;i++){
                    for(int w=W;w>=0;w--){
                        int nottake = prev[w];
                        int take = Integer.MIN_VALUE;
                        if(wt[i]<=w){
                            take = val[i] + prev[w-wt[i]];
                        }
                        prev[w] = Math.max(take,nottake);
                    }
                }
                return prev[W];
    }


    static int knapSack(int W, int wt[], int val[]) {
        // return steal(W,wt,val,val.length-1);


        // int dp[][] = new int[val.length][W+1];
        // for(int row[]:dp){
        //         Arrays.fill(row,-1);
        //     }
        // return steal(W,wt,val,val.length-1,dp);
            
            
        // int dp[][] = new int[val.length][W+1];
        // return steal(W,wt,val,val.length,dp);
        
        
        return steal(W,wt,val,val.length);

    }
    public static void main(String[] args) {
        
    }
}
