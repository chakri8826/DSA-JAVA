
// import java.util.*;

// public class Main {

//     public static long nCr(int n, int r) {
//         long res = 1;

//         // calculating nCr:
//         for (int i = 0; i < r; i++) {
//             res = res * (n - i);
//             res = res / (i + 1);
//         }
//         return res;
//     }

//     public static void pascalTriangle(int n) {
//         // printing the entire row n:
//         for (int c = 1; c <= n; c++) {
//             System.out.print(nCr(n - 1, c - 1) + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int n = 5;
//         pascalTriangle(n);
//     }
// }
    













import java.util.*;

public class tUf {

    static void pascalTriangle(int n) {
        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }
}
