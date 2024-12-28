import java.util.*;
public class Solution06GeekTraining {
    //RECURSIVE APPROACH
    // public static int mp(int day,int last,int arr[][]){
    //     if(day==0){
    //         int maxi=0;
    //         for(int i=0;i<3;i++){
    //             if(i!=last){
    //                 maxi=Math.max(maxi,arr[0][i]);
    //             }
    //         }
    //         return maxi;
    //     }
    //     int maxi=0;
    //     for(int i=0;i<3;i++){
    //         if(i!=last){
    //             int points = arr[day][i] + mp(day-1,i,arr);
    //             maxi = Math.max(maxi,points);
    //         }
    //     }
    //     return maxi;
    // }


    //MEMOIZATION
    // public static int mp(int day,int last,int arr[][],int dp[][]){
    //     if (day < 0) {
    //         return 0;
    //     }
    //     if(day==0){
    //         int maxi=0;
    //         for(int i=0;i<3;i++){
    //             if(i!=last){
    //                 maxi=Math.max(maxi,arr[0][i]);
    //             }
    //         }
    //         return maxi;
    //     }
        // if(dp[day][last]!=-1) return dp[day][last];
        // int maxi=0;
        // for(int i=0;i<3;i++){
        //     if(i!=last){
        //         int points = arr[day][i] + mp(day-1,i,arr,dp);
        //         maxi = Math.max(maxi,points);
        //     }
        // }
        // return dp[day][last] = maxi;
    // }


    //TABULATION
    // public static int mp(int arr[][],int dp[][],int n){
    //     dp[0][0] = Math.max(arr[0][1],arr[0][2]);
    //     dp[0][1] = Math.max(arr[0][0],arr[0][2]);
    //     dp[0][2] = Math.max(arr[0][0],arr[0][1]);
    //     dp[0][3] = Math.max(Math.max(arr[0][0],arr[0][1]),arr[0][2]);

    //     for(int day=1;day<n;day++){
    //         for(int last=0;last<4;last++){
    //             dp[day][last]=0;
    //             for(int task=0;task<3;task++){
    //                 if(task!=last){
    //                     int points = arr[day][task] + dp[day-1][task];
    //                     dp[day][last] = Math.max(dp[day][last],points);
    //                 }
    //             }
    //         }
    //     }
    //     return dp[n-1][3];
    // }


    //SPACE OPTIMIZATION
    public static int mp(int arr[][], int n){
        int[] prev = new int[4];
        prev[0] = Math.max(arr[0][1],arr[0][2]);
        prev[1] = Math.max(arr[0][0],arr[0][2]);
        prev[2] = Math.max(arr[0][0],arr[0][1]);
        prev[3] = Math.max(Math.max(arr[0][0],arr[0][1]),arr[0][2]);
        for(int day=1;day<n;day++){
            int curr[] = new int[4];
            for(int last = 0;last<4;last++){
                curr[last] = 0;
                for(int task =0;task<3;task++){
                    if(task!=last){
                        int points = arr[day][task] + prev[task];
                        curr[last] = Math.max(curr[last],points);
                    }
                }
            }
            prev=curr;
        }
        return prev[3];
    }

    public static int maximumPoints(int arr[][], int N) {
        // return mp(N-1,3,arr);

        // int dp[][] = new int[N][4];
        // for (int i = 0; i < N; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return mp(arr, dp, N);
      
        return mp(arr, N);
        

    }

    public static void main(String[] args) {
        int arr[][]= {{1,2,5},{3,1,1},{3,3,3}};
        int n = arr.length;
        System.out.println(maximumPoints(arr,n));
        
    }
}

