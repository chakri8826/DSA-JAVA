import java.util.*;
public class S10SubSetSum {
    public static boolean check(int arr[],int sum,boolean dp[][],int n){
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if (arr[0] <= sum) { //there may be chance of arr[0] can be greater than sum so checking it
            dp[0][arr[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=sum;tar++){
                boolean nottake = dp[ind-1][tar];
                boolean  take =false;
                if (arr[ind] <= tar){ 
                    take = dp[ind-1][tar-arr[ind]];
                }
                dp[ind][tar] = nottake || take;
            }
        }
        return dp[n-1][sum];
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean dp[][] = new boolean[arr.length][sum+1];
        return check(arr,sum,dp,arr.length);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

         
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        
        System.out.print("Enter the sum: ");
        int sum = sc.nextInt();

        if (isSubsetSum(arr, sum)) {
            System.out.println("Yes, there is a subset with the given sum.");
        } else {
            System.out.println("No, there is no subset with the given sum.");
        }

                
    }
}
