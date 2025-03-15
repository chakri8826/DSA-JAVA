import java.util.ArrayList;
import java.util.List;

class G8InsertInterval{
       public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i=0,n=intervals.length;
        // LEFT SIDE POSSIBLE INTERVALS
        while(i<n && newInterval[0]>intervals[i][1]){
            res.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        //  int mini = intervals[i][0] and int maxi = intervals[i][1]
        // if i == n (from above loop) (when newInterval is beyond all intervals),
        // intervals[i][0] causes an IndexOutOfBoundsException.

        // OVERLAPPING PART
        int mini = newInterval[0], maxi = newInterval[1];  
        while(i<n && newInterval[1]>=intervals[i][0]){
            mini=Math.min(mini,intervals[i][0]);
            maxi=Math.max(maxi,intervals[i][1]);
            i++;
        }
        res.add(new int[]{mini,maxi});

        // RIGHT SIDE REMAINING
        while(i<n){
            res.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        G8InsertInterval obj = new G8InsertInterval();
        int intervals[][] = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int newInterval[] = {4,8};
        int res[][] = obj.insert(intervals,newInterval);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}