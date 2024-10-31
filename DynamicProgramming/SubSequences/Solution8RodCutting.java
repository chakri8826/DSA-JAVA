public class Solution8RodCutting {
    // static int steal(int W,int ind,int val[]){
    //         if(ind==0){
    //             return  W*val[0];
    //         }
    //         int nottake = steal(W,ind-1,val);
    //         int take = Integer.MIN_VALUE;
    //         if(ind+1<=W){
    //             take = val[ind] + steal(W-(ind+1),ind,val);
    //         }
    //         return Math.max(take,nottake);
    // }
    
    
    // static int steal(int ind,int W,int val[],int dp[][]){
    //         if(ind==0){
    //             return  W*val[0];
    //         }
    //         if(dp[ind][W]!=-1) return dp[ind][W];
    //         int nottake = steal(ind-1,W,val,dp);
    //         int take = Integer.MIN_VALUE;
    //         if(ind+1<=W){
    //             take = val[ind] + steal(ind,W-(ind+1),val,dp);
    //         }
    //         return dp[ind][W] = Math.max(take,nottake);
    // }
    
    
    // static int steal(int n,int W,int val[],int dp[][]){
    //     for(int w=0;w<=W;w++){
    //         dp[0][w] = w*val[0];
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         for(int rl=0;rl<=W;rl++){
    //             int nottake =dp[ind-1][rl];
    //             int take = Integer.MIN_VALUE;
    //             if(ind+1<=rl){
    //                 take = val[ind] + dp[ind][rl-(ind+1)];
    //             }
    //             dp[ind][rl] = Math.max(take,nottake); 
    //         }
    //     }
    //     return dp[n-1][W]; 
    // }


    // static int steal(int n,int W,int val[]){
    //     int prev[] = new int[W+1];
    //     for(int w=0;w<=W;w++){
    //         prev[w] = w*val[0];
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         int curr[] = new int[W+1];
    //         for(int rl=0;rl<=W;rl++){
    //             int nottake =prev[rl];
    //             int take = Integer.MIN_VALUE;
    //             if(ind+1<=rl){
    //                 take = val[ind] + curr[rl-(ind+1)];
    //             }
    //             curr[rl] = Math.max(take,nottake); 
    //         }
    //         prev=curr;
    //     }
    //     return prev[W]; 
    // }


    //SINGLE ARRAY SPACE OPTIMIZATION
    static int steal(int n,int W,int val[]){
        int prev[] = new int[W+1];
        for(int w=0;w<=W;w++){
            prev[w] = w*val[0];
        }
        for(int ind=1;ind<n;ind++){
            for(int rl=0;rl<=W;rl++){
                int nottake =prev[rl];
                int take = Integer.MIN_VALUE;
                if(ind+1<=rl){
                    take = val[ind] + prev[rl-(ind+1)];
                }
                prev[rl] = Math.max(take,nottake); 
            }
        }
        return prev[W]; 
    }
    
    public int cutRod(int price[], int n) {
        // return steal(n-1,n,price);
        
        
        // int dp[][] = new int[n][n+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return steal(n-1,n,price,dp);
        
        
        // int dp[][] = new int[n][n+1];
        // return steal(n,n,price,dp);

        return steal(n,n,price);
    }
}
