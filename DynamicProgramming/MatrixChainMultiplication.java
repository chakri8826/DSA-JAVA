// package DynamicProgramming;
import java.util.*;
public class MatrixChainMultiplication {
    //RECURSIVE APPROACH IN OVERLAPPING OF SUBPROBLEMS OCCUR
    public static int mm(int arr[],int i,int j){
        int res = Integer.MAX_VALUE;
        if(i+1==j) return 0;
        for(int k=i+1;k<j;k++){
            res = Math.min(res,mm(arr,i,k)+mm(arr,k,j)+arr[i]*arr[k]*arr[j]);
        }
        return res;
    }
    static int matrixMultiplication(int N, int arr[]){
            return mm(arr,0,N-1);
    }
    public static void main(String[] args) {
        int arr[] = {20,10,30,40};
        int n = arr.length;
        System.out.println(matrixMultiplication(n,arr));
    }
}
