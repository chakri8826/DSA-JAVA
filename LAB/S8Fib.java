class S8Fib {
    public static int f(int n){
        if(n==0 || n==1) return n;
        return f(n-1)+f(n-2);
    }
    public static void printFib(int n){
        for(int i=0;i<=n;i++){
            System.out.print(f(i)+" ");
        }
    }
    public static void main(String[] args) {
        printFib(6);
    }
}
