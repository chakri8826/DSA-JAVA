import java.util.Arrays;

class Contest422{
    public int minTime(int n,int m,int[][] moveTime){
        if(n==0 && m==0){
            return 0;
        }
        int minTime = Integer.MAX_VALUE;
        // if(n>0){
            int timereq = 1+minTime(n-1,m,moveTime);
            if(timereq<moveTime[n][m]){
                timereq = moveTime[n][m];
            }
                minTime = Math.min(minTime,timereq); 
        // }
        // if(m>0){
            timereq = 1+minTime(n,m-1,moveTime);
                if(timereq<moveTime[n][m]){
                timereq = moveTime[n][m];
            }
            minTime = Math.min(minTime,timereq);
        // }
        return   minTime;
    }




    //  public int minTime(int n,int m,int[][] moveTime,int dp[][]){
    //     if(n==0 && m==0){
    //         return 0;
    //     }
    //     if(dp[n][m]!=-1) return dp[n][m];
    //     int minTime = Integer.MAX_VALUE;
    //     if(n>0){
    //         int timereq = 1+minTime(n-1,m,moveTime,dp);
    //         if(timereq<moveTime[n][m]){
    //             timereq = moveTime[n][m];
    //         }
    //             minTime = Math.min(minTime,timereq); 
    //     }
    //     if(m>0){
    //         int timereq = 1+minTime(n,m-1,moveTime,dp);
    //             if(timereq<moveTime[n][m]){
    //             timereq = moveTime[n][m];
    //         }
    //         minTime = Math.min(minTime,timereq);
    //     }
    //     return dp[n][m] = minTime;
    // }


    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        // return helper(n - 1, m - 1, moveTime,dp);
        return minTime(n - 1, m - 1, moveTime);
    }
    public static void main(String[] args) {
        int moveTime[][] =  {{0,4},{4,4}};
        Contest422 c = new Contest422();
        System.out.println(c.minTimeToReach(moveTime));
    }
}

