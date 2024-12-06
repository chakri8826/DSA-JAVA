public class S11MeanRec {
    public static int f(int[] A,int n){
        if(n==1){
            return A[0];
        }
        return A[n-1] + f(A,n-1);
    }
    static int mean(int N , int[] A) {
        return f(A,N)/N;
    }

    public static void main(String[] args) {
        int arr[] = { 56 , 67 , 30 , 79 };
        int n=4;
        System.out.println(mean(n,arr));
    }
}
