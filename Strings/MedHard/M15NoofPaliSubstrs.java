public class M15NoofPaliSubstrs {
    //BRUTE FORCE   
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // There are 2n - 1 possible centers
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + (center % 2); // odd or even center

            // Expand around the center
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;   // every expansion is a palindrome
                left--;
                right++;
            }
        }
        return count;
    }

    //OPTIMIZED
    public int numberOfPalindromicSubstrings(String s) {
        // Step 1: Transform the string
        StringBuilder sb = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        sb.append("#$");
        String t = sb.toString();

        int n = t.length();
        int[] rad = new int[n];  // radius array
        int center = 0, right = 0;

        // Step 2: Manacher's algorithm
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                rad[i] = Math.min(right - i, rad[mirror]);
            }

            while (t.charAt(i + 1 + rad[i]) == t.charAt(i - 1 - rad[i])) {
                rad[i]++;
            }

            if (i + rad[i] > right) {
                center = i;
                right = i + rad[i];
            }
        }

        // Step 3: Count palindromic substrings
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            cnt += (rad[i] + 1) / 2;
        }

        return cnt;
    }

        
    
        public static void main(String[] args) {
            M15NoofPaliSubstrs ps = new M15NoofPaliSubstrs();
            String s = "racecar";
            System.out.println("Total Palindromic Substrings: " + ps.countSubstrings(s));
        }
}
