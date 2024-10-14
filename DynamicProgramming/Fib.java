public class Fib {
    static long topDown(int n) {
        long mem[] = new long[n+1];  // Memoization array
        return topDownHelper(n, mem);
    }

    static long topDownHelper(int n, long[] mem) {
        if (n<=1) return n;
        if (mem[n]!=0) return mem[n];
        return mem[n] = (topDownHelper(n - 1, mem) + topDownHelper(n - 2, mem)) % 1000000007; 
    }

    static long bottomUp(int n) {
          // Handle base case separately
        long fib[] = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2])%1000000007;
        }
        return fib[n];
    }
    public static void main(String[] args) {
        System.out.println(topDown(4));
        System.out.println(bottomUp(4));
    }
}

