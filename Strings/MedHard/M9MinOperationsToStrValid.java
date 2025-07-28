public class M9MinOperationsToStrValid {
    // brute force
    // public int minAddToMakeValid(String s) {
    //     return dfs(s, 0);
    // }

    // // Check if a string is valid
    // private boolean isValid(String s) {
    //     int bal = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '(') bal++;
    //         else bal--;
    //         if (bal < 0) return false;
    //     }
    //     return bal == 0;
    // }

    // // Recursive DFS to try all insertions
    // private int dfs(String s, int insertions) {
    //     if (isValid(s)) return insertions;
    //     int min = Integer.MAX_VALUE;
    //     for (int i = 0; i <= s.length(); i++) {
    //         // Try inserting '(' at position i
    //         min = Math.min(min, dfs(s.substring(0, i) + '(' + s.substring(i), insertions + 1));
    //         // Try inserting ')' at position i
    //         min = Math.min(min, dfs(s.substring(0, i) + ')' + s.substring(i), insertions + 1));
    //     }
    //     return min;
    // }

    
    //Optimal- greedy
    public int minAddToMakeValid(String s) {
        int open = 0, insert = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else open--;
            if (open < 0) {
                insert++;
                open = 0;
            }
        }
        return open + insert;
    }
    
}
