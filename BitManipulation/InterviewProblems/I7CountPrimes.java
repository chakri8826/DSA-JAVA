import java.util.Arrays;

public class I7CountPrimes {
    // prime numbers that are strictly less than n. if n is prime we are not counting it.
    public int countPrimes(int n){
        boolean primes[]=new boolean[n];
        Arrays.fill(primes,true);
        int count=0;
        if(n<2){
            return 0;
        }
        for(int i=2;i<n;i++){
            if(primes[i]){
                count++;
                System.out.print(i+" ");
                for(long j=(long)2*i;j<n;j=j+i){
                    primes[(int)j]=false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        I7CountPrimes obj = new I7CountPrimes();

        int res = obj.countPrimes(13);
        System.out.println("\n"+"count: "+res);
    }
}
