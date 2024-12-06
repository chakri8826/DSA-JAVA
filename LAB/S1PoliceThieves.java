import java.util.Scanner;

public class S1PoliceThieves {
    static int catchThieves(char arr[], int n, int k) { 
        int[] P = new int[n];
        int[] T = new int[n];
        int j = 0, l = 0, count = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                P[j++] = i;
            } else {
                T[l++] = i;
            }
        }
        
        int pind = 0, tind = 0;
        
        while (pind < j && tind < l) {
            if (Math.abs(P[pind] - T[tind]) <= k) {
                count++;
                pind++;
                tind++;
            } else if (T[tind] < P[pind] - k) {
                tind++;
            } else if (T[tind] > P[pind] + k) {
                pind++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of positions (n): ");
        int n = sc.nextInt();
        
    
        System.out.print("Enter the distance k: ");
        int k = sc.nextInt();
        
        System.out.print("Enter the positions (P for Police and T for Thief): ");
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        
        // Call the catchThieves function and display the result
        System.out.println("Maximum number of thieves caught: " + catchThieves(arr, n, k));
        
        sc.close();
    }
}
