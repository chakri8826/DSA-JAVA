import java.util.ArrayList;
import java.util.List;

class I9PrimeFactosUsingSieve{
    // Most numbers ≤ 200000 have prime factors that are ≤ 100100.
    static int MAXN = 100100;
    static int[] spf = new int[MAXN];
    static void sieve(){
        for(int i=2;i<MAXN;i++){
            spf[i]=i;
        }
        for(int i=2;i*i<=MAXN;i++){
            if(spf[i]==i){
                for(int j=i*i;j<MAXN;j=j+i){
                    if(spf[j]==j){
                        spf[j]=i;
                    }
                }
            }
        }
    }
    
    static List<Integer> findPrimeFactors(int N) {
        List<Integer> li = new ArrayList<>();
        while(N>1){
            li.add(spf[N]);
            N=N/spf[N];
        }
        return li;
    } 
    public static void main(String[] args) {
        sieve();
        int N = 100;
        List<Integer> li = findPrimeFactors(N);
        for(int ele:li){
            System.out.print(ele+" ");
        }
    }
}