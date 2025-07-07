import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int i, j, diff;

    public Pair(int i, int j, int diff) {
        this.i = i;
        this.j = j;
        this.diff = diff;
    }
}
public class S6PathWithMinEffort {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        
        int n = heights.length,m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.diff-b.diff);
        pq.offer(new Pair(0,0,0));
        
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i=p.i;
            int j=p.j;
            int diff=p.diff;
            if(i==n-1 && j==m-1) return diff;
            
            for (int dir = 0; dir < 4; dir++) {
                int nrow = i + dx[dir];
                int ncol = j + dy[dir];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int currDiff = Math.max(diff,Math.abs(heights[i][j]-heights[nrow][ncol]));
                    if(currDiff<dist[nrow][ncol]){
                        dist[nrow][ncol] = currDiff;
                        pq.offer(new Pair(nrow, ncol, currDiff));
                    }
                } 
            }
        }
        return -1;
    }    
}
