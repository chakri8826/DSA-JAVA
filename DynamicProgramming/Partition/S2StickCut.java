import java.util.Arrays;

public class S2StickCut {
    // public int f(int i,int j,int[] cuts){
    //     if(i>j) return 0;
    //     int mini = Integer.MAX_VALUE;
    //     for(int ind=i;ind<=j;ind++){
    //         int cost = cuts[j+1]- cuts[i-1]+f(i,ind-1,cuts)+f(ind+1,j,cuts);
    //         mini = Math.min(mini,cost);
    //     }
    //     return mini;
    // }

    // public int f(int i,int j,int[] cuts,int dp[][] ){
    //     if(i>j) return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     int mini = Integer.MAX_VALUE;
    //     for(int ind=i;ind<=j;ind++){
    //         int cost = cuts[j+1]- cuts[i-1]+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);
    //         mini = Math.min(mini,cost);
    //     }
    //     return dp[i][j] = mini;
    // }


    public int f(int n,int[] cuts,int dp[][] ){
        for(int i=n;i>=1;i--){
            // for(int j=1;j<=n;j++){
            //     if(i>j) continue;
                for(int j=i;j<=n;j++){
                int mini = Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = cuts[j+1]- cuts[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n];
    }

    public int minCost(int n, int[] cuts) {
        int allCuts[] = new int[cuts.length+2];
        allCuts[0]=0;
        allCuts[allCuts.length-1]=n;
        for(int i=0;i<cuts.length;i++){
            allCuts[i+1]=cuts[i];
        }
        Arrays.sort(allCuts);

        // return f(1,allCuts.length-2,allCuts);

        // int dp[][] = new int[cuts.length+1][cuts.length+1];
        // for(int row[] :dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(1,allCuts.length-2,allCuts,dp);


        int dp[][] = new int[cuts.length+2][cuts.length+2];
        return f(allCuts.length-2,allCuts,dp);

    }
    public static void main(String[] args) {
    

    }
}