import java.util.*;
class mycmp implements Comparator<int[]> {
    public int compare(int[] i1, int[] i2) {
        return i1[0] - i2[0]; // Compare by the first element of each row
    }
}

public class A7MergeIntervals {
    public static void merge(int[][] intervals) {
        // Step 1: Sort intervals using the custom comparator
        Arrays.sort(intervals, new mycmp());

    }

    public static void main(String[] args) {
        A7MergeIntervals solution = new A7MergeIntervals();

        // Example input
        int[][] intervals = { {8, 10}, {15, 18}, {1, 3}, {2, 6}};
        System.out.println("Original Intervals: ");
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        merge(intervals);
    }
}

