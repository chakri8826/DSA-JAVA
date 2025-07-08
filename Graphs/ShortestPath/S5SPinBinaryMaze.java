import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i, j, dis;

    public Pair(int i, int j, int dis) {
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}

public class S5SPinBinaryMaze {
     int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
        return -1;
        if (source[0] == destination[0] && source[1] == destination[1]) return 0;
        
        int n = grid.length,m = grid[0].length;
        int dist[][] = new int[n][m];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]]=0;
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(source[0],source[1],0));
        
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int d = p.dis;
            for (int dir = 0; dir < 4; dir++) {
                int nrow = i + dx[dir];
                int ncol = j + dy[dir];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1
                        && d + 1 < dist[nrow][ncol]) {
                    if (nrow == destination[0] && ncol == destination[1]) {
                        return d + 1;
                    }
                    dist[nrow][ncol] = d + 1;
                    q.offer(new Pair(nrow, ncol, d + 1));
                }
            }
        }
        return -1;
    }
}
