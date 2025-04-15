import java.util.*;
class G8NonOverLap{
    // MISTAKE I THOUGHT
    // public int eraseOverlapIntervals(int[][] intervals) {
    //     Arrays.sort(intervals,(a,b)-> a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]) );
    //     int pre[] = intervals[0];
    //     int cnt=0;
    //     for(int i=1;i<intervals.length;i++){
    //         if(intervals[i][0]<pre[1]){
    //             cnt++;
    //         }
    //         else{
    //             pre=intervals[i];
    //         }
    //     }
    //     return cnt;
    // }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int pre = intervals[0][1];
        int cnt=1,n=intervals.length;
        for(int i=1;i<n;i++){
            // for this question == also other interval so it is not overlap
            if(intervals[i][0]>=pre){
                cnt++;
                pre=intervals[i][1];
            }
        }
        return n-cnt;
    } 
    public static void main(String[] args) {
        G8NonOverLap obj = new G8NonOverLap();

        // Example input for intervals
        int[][] intervals = {
            {1, 100},
            {11, 22},
            {1, 11},
            {2, 12}
        };

        // Calling the function and printing the result
        int result = obj.eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove: " + result);
    }
}

