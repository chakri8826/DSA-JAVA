public class S5Print1toN {
    static void printTillN(int N){
        if(N==0){
            return;
        }
        printTillN(N-1);
        System.out.print(N+" ");
    }
    public static void main(String[] args) {
        printTillN(5);
    }
}