public class KnapSack {
    //RECURSIVE APPROACH
    static int knapsack(int W,int wt[],int v[],int n){
        if(n==0 || W==0) return 0;
        if(wt[n-1]>W) return knapsack(W,wt,v,n-1);
        return Math.max(knapsack(W, wt, v, n-1),v[n-1]+knapsack(W-wt[n-1], wt, v, n-1));
    }

    //DP APPROACH
    static int knapsackdp(int W,int wt[],int v[],int n){
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=W;j>=0;j--){
                if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }

    //DP OPTIMISED APPROACH
    static int knapsackOp(int W,int wt[],int v[],int n){
        int dp[]=new int[W+1];
        for(int i=0;i<W;i++){
            dp[i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=W;j>0;j--){
                if(wt[i-1]>j){
                    dp[i]=dp[i-1];
                }
                else{
                    dp[j]=Math.max(dp[j],v[i-1]+dp[j-wt[i-1]]);
                }
            }
        }
        return dp[W];
    }
//     static int knapsackOp(int W, int wt[], int v[], int n) {
//     int dp[] = new int[W + 1]; // 1D dp array initialized with size W+1

//     // Initialize dp array with zeros
//     for (int i = 0; i <= W; i++) {
//         dp[i] = 0;
//     }

//     // Iterating over all items
//     for (int i = 1; i <= n; i++) {
//         // Traverse from the back (W to 1) to avoid overwriting current results
//         for (int j = W; j >= wt[i-1]; j--) {
//             dp[j] = Math.max(dp[j], v[i-1] + dp[j - wt[i-1]]);
//         }
//     }
//     return dp[W]; // Return the maximum value for capacity W
// }



    public static void main(String[] args) {
        int wt[]={5,4,6,3};
        int v[]={10,40,30,50};
        int W=10;
        // System.out.println(knapsack(W,wt,v,4));
        System.out.println(knapsackOp(W,wt,v,4));
    }
}
