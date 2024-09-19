import java.lang.*;
import java.util.*;
class Memoization {
    static int memo[];
    static int fib(int n){
        int res;
        if(memo[n]==0){
            if(n==0||n==1){
                res=n;
            } 
            else{
                res=fib(n-1)+fib(n-2);
            }
            memo[n]=res;
        }

        return memo[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of fib num ");
        int n = sc.nextInt();
        memo=new int[n+1];
        System.out.println(fib(n));
    }
}

