import java.util.*;
class Leonardo{
      public static long prod=1;
    public static boolean isPrime(long n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public static int primeCount(long n) {
        prod = 1;  // Reset prod for each function call
        int i = 2, count = 0; // Start from 2 (smallest prime)

        while (prod <= n) {
            if (isPrime(i)) {
                // Check if multiplying prod by prime i will exceed n
                if (prod * i > n) {
                    break;
                }
                prod *= i;  // Multiply prod by prime i
                count++;    // Increment count of primes
            }
            i++;  // Move to the next number
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(primeCount(2 ));
    }
}
