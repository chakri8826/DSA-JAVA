import java.util.Arrays;

public class BiWeekly146 {
    static int mod = 1000000007;

    // public static int f(int[][] grid, int k, int m, int n, int currX, int[][][] dp) {
    //     if (m < 0 || n < 0) return 0; // Out of bounds

    //     currX ^= grid[m][n];

    //     if (m == 0 && n == 0) { // Base case
    //         return currX == k ? 1 : 0;
    //     }

    //     if (dp[m][n][currX] != -1) return dp[m][n][currX];

    //     // Update XOR value for this cell

    //     // Recursive calls for left and up
    //     int leftPaths = f(grid, k, m, n - 1, currX, dp);
    //     int upPaths = f(grid, k, m - 1, n, currX, dp);

    //     dp[m][n][currX] = (leftPaths + upPaths) % mod;

    //     System.out.println("M: "+ m+" N: "+n+" CurrX: "+currX);
    //     return dp[m][n][currX];
    // }

    public static int f(int[][] grid, int k, int m, int n, int currX, int[][][] dp) {
        if (m < 0 || n < 0) return 0; // Out of bounds

        if (m == 0 && n == 0) { // Base case
            currX^=grid[0][0];
            return currX == k ? 1 : 0;
        }

        if (dp[m][n][currX] != -1) return dp[m][n][currX];

        int newX = currX ^ grid[m][n];



        // Update XOR value for this cell

        // Recursive calls for left and up
        int leftPaths = f(grid, k, m, n - 1, newX, dp);
        int upPaths = f(grid, k, m - 1, n, newX, dp);

        dp[m][n][currX] = (leftPaths + upPaths) % mod;

        System.out.println("M: "+ m+" N: "+n+" CurrX: "+currX);
        return dp[m][n][currX];
    }


    public static int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Determine the maximum possible XOR value
        int maxXOR = 100; // 2^10 is sufficient for this grid
        int[][][] dp = new int[m][n][maxXOR];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return f(grid, k, m - 1, n - 1, 0, dp);
    }


    public static void main(String[] args) {
        int [][]grid = {{2, 1, 5}, {7, 10, 0}, {12, 6, 4}};
        int k=11;
        System.out.println(countPathsWithXorValue(grid, k));
        // System.out.println(0^4);
    }
}
