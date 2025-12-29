import java.util.*;
// class mycmp implements Comparator<int[]> {
//     public int compare(int[] i1, int[] i2) {
//         return i1[0] - i2[0]; // Compare by the first element of each row
//     }
// }

public class A7MergeIntervals {
 
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        int n = intervals.length;
        ArrayList<int[]> res = new ArrayList<>();
        int[] prev = intervals[0]; 
        res.add(prev);
        for(int i=1;i<n;i++){
            int curr[] = intervals[i];
            if(curr[0]<=prev[1]){
                prev[1]=Math.max(prev[1],curr[1]);
            }
            else{
                prev=curr;
                res.add(prev);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
    public static void main(String[] args) {
        A7MergeIntervals solution = new A7MergeIntervals();

        // Example input
        int[][] intervals = { {8, 10}, {15, 18}, {1, 3}, {2, 6}};
        System.out.println("Original Intervals: ");
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        int[][] res = merge(intervals);
        System.out.println("Merged Intervals: ");
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}


