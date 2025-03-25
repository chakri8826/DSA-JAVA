import java.util.ArrayList;

public class I5PrintPrimeFactors {
    // PRINTS ONLY UNIQUE PRIME FACTORS
     public int[] AllPrimeFactors(int N){
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=2;i*i<=N;i++){
            while(N%i==0){
                if(!li.contains(i))li.add(i);
                N=N/i;
            }
        }
        // last remaining prime factor is added to the list only once. 
        if(N>1)if(!li.contains(N))li.add(N);
        
        int[] arr = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        I5PrintPrimeFactors obj = new I5PrintPrimeFactors();
        int N = 100;
        int arr[] = obj.AllPrimeFactors(N);
        for(int ele:arr){
            if(ele==0) break;
            System.out.print(ele+" ");
        }
    }
}

