import java.util.*;
/*
Total Complexity
Adding up all the steps:

1. Sorting each row: O(n ⋅ m log m) 
2. Collecting elements: O(n ⋅ m) 
3. Sorting collected elements: O(n ⋅ m log(n ⋅ m)) 
4. Picking top k elements: O(k) (which is at most O(n ⋅ m)) 

Final Complexity:
O(n ⋅ m log m + n ⋅ m + n ⋅ m log(n ⋅ m) + k)

Since O(n ⋅ m log(n ⋅ m)) dominates the complexity, we simplify it to:

O(n ⋅ m log(n ⋅ m))

*/
class WC438 {
    // FIRST PROBLEM
    // public boolean hasSameDigits(String s) {
    //     while(s.length()>2){
    //         StringBuilder sb = new StringBuilder();
    //         for(int i=0;i<s.length()-1;i++){
    //             int sum = (s.charAt(i)-'0') + (s.charAt(i+1)-'0');
    //             sb.append(sum%10);
    //         }
    //         s=sb.toString();
    //     }
    //     return s.charAt(0)==s.charAt(1);
    // }
    // 2ND PROBLEM 
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> candidates = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        
        // Step 1: Collect top `limits[i]` elements from each row
        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]); // Sort row in ascending order
            int count = limits[i]; // Max elements we can take from this row
            
            // Take `limits[i]` largest elements
            // for (int j = m - 1; j >= m - count; j--) {
            //     candidates.add(grid[i][j]);
            // }
            int cnt=0;
            for(int j=m-1;j>=0;j--){
                if(cnt>=count) break;
                candidates.add(grid[i][j]);
                cnt++;
            }
        }
        
        // Step 2: Sort all selected elements in descending order
        candidates.sort(Collections.reverseOrder());
        
        // Step 3: Take the top `k` elements
        long maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += candidates.get(i);
        }
        
        return maxSum;
    }
}