import java.util.*;
class SumEqualToTarget{
    // public static boolean check(int arr[],int sum,int ind){
    //     if(sum==0) return true;
    //     if(ind==0) return arr[0]==sum;
        // boolean nottake = check(arr,sum,ind-1 );
        // boolean  take =false;
        // if (arr[ind] <= sum) { 
        //     take = check(arr,sum-arr[ind],ind-1);
        // }
        // return nottake || take;
    // }


    // public static boolean check(int arr[],int sum,int ind,int dp[][]){
    //     if(sum==0) return true;
    //     if(ind==0) return arr[0]==sum;
    //     if(dp[ind][sum]!=-1){
    //         if(dp[ind][sum]==0) return false;
    //         return true;
    //     }
    //     boolean nottake = check(arr,sum,ind-1,dp);
    //     boolean  take =false;
    //     if (arr[ind] <= sum) { 
    //         take = check(arr,sum-arr[ind],ind-1,dp);
    //     }
    //     dp[ind][sum]=nottake||take ? 1:0;
    //     return nottake||take;
    // }


    // public static boolean check(int arr[],int sum,boolean dp[][],int n){
    //     for(int i=0;i<n;i++){
    //         dp[i][0]=true;
    //     }
    //     if (arr[0] <= sum) {
    //         dp[0][arr[0]] = true;
    //     }
    //     for(int ind=1;ind<n;ind++){
    //         for(int tar=1;tar<=sum;tar++){
    //             boolean nottake = dp[ind-1][tar];
    //             boolean  take =false;
    //             if (arr[ind] <= tar){ 
    //                 take = dp[ind-1][tar-arr[ind]];
    //             }
    //             dp[ind][tar] = nottake || take;
    //         }
    //     }
    //     return dp[n-1][sum];
    // }


    public static boolean check(int arr[],int sum,int n){
        boolean prev[] = new boolean[sum+1];
    
        prev[0]=true;
        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            boolean curr[] = new boolean[sum+1];
            curr[0]=true;
            for(int tar=1;tar<=sum;tar++){
                boolean nottake = prev[tar];
                boolean  take =false;
                if (arr[ind] <= tar) { 
                    take = prev[tar-arr[ind]];
                }
                curr[tar] = nottake || take;
            }
            prev=curr;

        }
        return prev[sum];
    }




    static Boolean isSubsetSum(int arr[], int sum) {
        // return check(arr,sum,0,arr.length,new ArrayList<>());

        // int dp[][] = new int[arr.length][sum+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return check(arr,sum,arr.length-1,dp);

        // boolean dp[][] = new boolean[arr.length][sum+1];
        // return check(arr,sum,dp,arr.length);
        
        
        return check(arr,sum,arr.length);
    }
    public static void main(String[] args) {
        
    }
}