import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class M8MergeIntervals {
    // public int[][] merge(int[][] intervals) {
    //     int n = intervals.length;
    //     Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
    //     List<int[]> res = new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         int start = intervals[i][0];
    //         int end = intervals[i][1];
    //         if(!res.isEmpty() && res.get(res.size()-1)[1]>=intervals[i][1]){
    //             continue;
    //         }
    //         for(int j=i+1;j<n;j++){
    //             if(intervals[j][0]<=end){
    //                 end=Math.max(end,intervals[j][1]);
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         res.add(new int[]{start,end});
    //     }
    //     return res.toArray(new int[res.size()][]);
    
    // }


    // Even though you updated a, it also updated what's inside the list — because both point to the same array.
    // int[] a = {1, 3};
    // List<int[]> list = new ArrayList<>();
    // list.add(a);
    // a[1] = 5;
    // System.out.println(list.get(0)[1]); // Outputs 5

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> res = new ArrayList<>();
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
        return res.toArray(new int[res.size()][]);
    }

}
