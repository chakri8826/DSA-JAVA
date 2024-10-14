import java.util.*;
public class ClimbStairs {
    //RECURSIVE APPROACH
    // public static int cs(int n,int i,int count){
    //     if(i==n) return ++count;
    //     if(i>n) return count;
    //     return cs(n,i+1,count) + cs(n,i+2,count);
    // }
    // public static void climbStairs(int n) {
    //     int count=0;
    //     System.out.println(cs(n,0,count)); 
    // }

    //DP APPROACH
    public static int cs(int[] mem,int n,int i){
        if(i==n) return 1;
        if(i>n) return 0; 
        if(mem[i]==-1){
            int left=cs(mem,n,i+1);
            int right=cs(mem,n,i+2);
            mem[i]=left+right;
        }
        return mem[i];
    }

    public static void climbStairs(int n) {
        int mem[] = new int[n];
        Arrays.fill(mem,-1);
        System.out.println(cs(mem,n,0));
        System.out.println(Arrays.toString(mem));
    }

    public static void main(String[] args){
        climbStairs(3);
    }
}



