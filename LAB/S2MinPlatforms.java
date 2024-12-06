import java.util.Arrays;
import java.util.Scanner;

public class S2MinPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int aind = 0, dind = 0, count = 0, maxPlat = 0, n = arr.length;
        while (aind < n) {
            if (arr[aind] <= dep[dind]) {
                count++;
                aind++;
            } else if (arr[aind] >= dep[dind]) {
                count--;
                dind++;
            }
            maxPlat = Math.max(maxPlat, count);
        }
        return maxPlat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of trains: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the arrival times: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dep = new int[n];
        System.out.println("Enter the departure times: ");
        for (int i = 0; i < n; i++) {
            dep[i] = sc.nextInt();
        }

        int totalCount = findPlatform(arr, dep);
        System.out.println("Minimum number of platforms required: " + totalCount);

    }
}
