public class MaximumRemovals {
    
    private int maxRemovalsHelper(int index, String source, String pattern, int[] targetIndices, int removedCount) {
        // If we've considered all indices, return 0
        if (index == targetIndices.length) {
            return 0;
        }
        
        // Option 1: Skip the current index
        int skip = maxRemovalsHelper(index + 1, source, pattern, targetIndices, removedCount);

        // Option 2: Try removing the character at targetIndices[index]
        int adjustedIndex = targetIndices[index] - removedCount;
        int remove = 0;
        // if (adjustedIndex >= 0 && adjustedIndex < source.length()) {
            String newSource = removeCharacterAt(source, adjustedIndex);
            if (isSubsequence(pattern, newSource)) {
                remove = 1 + maxRemovalsHelper(index + 1, newSource, pattern, targetIndices, removedCount + 1);
            }
        // }

        // Return the maximum of the two choices
        return Math.max(skip, remove);
    }
    
    // Helper function to check if 'pattern' is a subsequence of 'source'
    private boolean isSubsequence(String pattern, String source) {
        int i = 0, j = 0;
        while (i < source.length() && j < pattern.length()) {
            if (source.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == pattern.length();
    }

    // Helper function to remove a character at a specific index in 'source'
    private String removeCharacterAt(String source, int idx) {
        return source.substring(0, idx) + source.substring(idx + 1);
    }

    
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int dp[][] = new int[][]
        return maxRemovalsHelper(0, source, pattern, targetIndices, 0);
    }

    public static void main(String[] args) {
        MaximumRemovals solution = new MaximumRemovals();

        // Test cases
        String source1 = "abbaa";
        String pattern1 = "aba";
        int[] targetIndices1 = {0, 1, 2};
        System.out.println(solution.maxRemovals(source1, pattern1, targetIndices1)); // Output: 1

        String source2 = "bcda";
        String pattern2 = "d";
        int[] targetIndices2 = {0, 3};
        System.out.println(solution.maxRemovals(source2, pattern2, targetIndices2)); // Output: 2

        String source3 = "dda";
        String pattern3 = "dda";
        int[] targetIndices3 = {0, 1, 2};
        System.out.println(solution.maxRemovals(source3, pattern3, targetIndices3)); // Output: 0

        String source4 = "yeyeykyded";
        String pattern4 = "yeyyd";
        int[] targetIndices4 = {0, 2, 3, 4};
        System.out.println(solution.maxRemovals(source4, pattern4, targetIndices4)); // Output: 2
    }
}
