public class S6SumRec {
    //METHOD-1
    // public static int f(int n){
    //     if(n==0) return 0;
    //     return n%9==0?9:n%9;
    // }
    // public static int SumofDigits(int A, int B)
    // {
    //     return f((int) Math.pow(A,B));
    // }
    
    //METHOD-2
    public static int f(int n){
        if(n<10) return n;
        return f(n%10+f(n/10));
    }
    public static void main(String[] args) {
        System.out.println(f(1237890));
    }
}


