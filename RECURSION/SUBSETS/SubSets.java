class SubSets {
    static int count = 0; // Declare count as a static variable

    static void subSets(String s, String curr, int i, int k) {
        if (i == s.length()) { // Base case: if i reaches the end of the string
            int zero = 0;
            int one = 0;
            for (int l = 0; l < curr.length(); l++) { // Count zeroes and ones in the current subset
                if (curr.charAt(l) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            // Check if the count of zeroes or ones is less than k
            if (zero < k || one < k) {
                count++; // Increment the count if the condition is satisfied
            }
            return; // Return after processing the base case
        }

        // Recursive call excluding the current character
        subSets(s, curr, i + 1, k);

        // Recursive call including the current character
        subSets(s, curr + s.charAt(i), i + 1, k);
    }

    public static void main(String[] args) {
        int k = 1;
        subSets("10101", "", 0, k); // Start the recursive function
        System.out.println("Number of subsets with fewer than " + k + " zeroes or ones: " + count); // Print the result
    }
}
