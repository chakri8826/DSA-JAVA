import java.util.ArrayList;

public class M12RabinKarp {
    public ArrayList<Integer> rabinKarp(String text, String patt) {
        int m = text.length(), n = patt.length();
        int d = 256, prime = 101;
        int t = 0, p = 0;
        ArrayList<Integer> result = new ArrayList<>();

        // Initial hash for pattern and first window of text
        for (int i = 0; i < n; i++) {
            p = (p * d + patt.charAt(i)) % prime;
            t = (t * d + text.charAt(i)) % prime;
        }

        // Precompute (d^(n-1)) % prime
        int x = 1;
        for (int i = 1; i < n; i++) {
            x = (x * d) % prime;
        }

        // Slide over text
        for (int i = 0; i <= m - n; i++) {
            // If hash matches, check characters
            if (p == t) {
                int j;
                for (j = 0; j < n; j++) {
                    if (patt.charAt(j) != text.charAt(i + j)) break;
                }
                if (j == n) result.add(i);  // save match index
            }

            // Compute next hash
            if (i < m - n) {
                t = ((t - text.charAt(i) * x) * d + text.charAt(i + n)) % prime;
                if (t < 0) t = t + prime;
            }
        }

        return result;
    }
}
