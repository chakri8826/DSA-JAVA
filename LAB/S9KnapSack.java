import java.util.Arrays;
import java.util.Scanner;

public class S9KnapSack {
    //recursive
    // public static int f(int capacity, int val[], int wt[],int ind,int dp[][]){
    //     if(ind==0){
    //         if(wt[0]<=capacity){
    //             return val[0];
    //         }
    //         else return 0;
    //     }
    //     if(dp[ind][capacity]!=-1) return dp[ind][capacity];
    //     int np = f(capacity,val,wt,ind-1,dp);
    //     int p = Integer.MIN_VALUE;
    //     if(wt[ind]<=capacity){
    //         p = val[ind] + f(capacity-wt[ind],val,wt,ind-1,dp);
    //     }
    //     return dp[ind][capacity] = Math.max(np,p);
    // }


    //DP
    public static int f(int W, int val[], int wt[],int n,int dp[][]){
        for(int w=0;w<=W;w++){
            if(wt[0]<=w){
                dp[0][w] = val[0];
            }
        }
        for(int ind=1;ind<n;ind++){
            for(int w=0;w<=W;w++){
                int np = dp[ind-1][w];
                int pi = Integer.MIN_VALUE;
                if(wt[ind]<=w){
                    pi = val[ind] + dp[ind-1][w-wt[ind]];
                }
                dp[ind][w] = Math.max(np,pi);
            }
        }
        return dp[n-1][W];
    }
    

    static int knapSack(int capacity, int val[], int wt[]) {
        int dp[][] = new int[val.length][capacity+1];
        return f(capacity,val,wt,val.length,dp);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of items
        System.out.println("Enter the number of items: ");
        int n = scanner.nextInt();

        // Input values and weights arrays
        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            val[i] = scanner.nextInt();
        }

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
        }

        // Input the capacity of the knapsack
        System.out.println("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        // Output the result of the knapSack function
        System.out.println("Maximum value in knapsack: " + knapSack(W, val, wt));
    
    }
}

