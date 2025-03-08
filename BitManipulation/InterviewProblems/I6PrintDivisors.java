public class I6PrintDivisors {
    public static void print_divisors(int n) {
        int i;
        for(i = 1; i * i <=n; i++) { // Iterate up to sqrt(n)
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }
        for(i--; i > 0; i--) { // Decrement i to avoid duplicate for perfect squares
            if(n % i == 0 && i != n / i) { // Avoid duplicate printing
                System.out.print(n / i + " ");
            }
        }
    }
    public static void main(String[] args) {
        print_divisors(100);
    }

}
