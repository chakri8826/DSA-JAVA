import java.util.*;
public class A2First_SecondSmallest {
    public static int smallest(int[] arr) {
        int s = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < s) {
                s = arr[i];
            }
        }
        return s;
    }

    public static int findSecondSmallest(int[] arr) {
        int s = arr[0]; // Smallest
        int ss = Integer.MAX_VALUE; // Initialize to max value
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < s) {
                ss = s; // Update second smallest
                s = arr[i]; // Update smallest
            } 
            else if (arr[i] > s && arr[i] < ss) {
                ss = arr[i]; // Update second smallest
            }
        }

        return ss != Integer.MAX_VALUE ? ss : -1;
    }

    public static int[] minAnd2ndMin(int[] arr) {
        int smallest = smallest(arr);
        
        boolean allIdentical = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != smallest) {
                allIdentical = false;
                break;
            }
        }
        if (allIdentical) {
            return new int[]{-1}; // Return [-1] if all elements are identical
        }

        int secondSmallest = findSecondSmallest(arr);

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 5, 6};
        System.out.println(Arrays.toString(minAnd2ndMin(arr)));
    }
}

