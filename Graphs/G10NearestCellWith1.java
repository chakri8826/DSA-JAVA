import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int row,col,dis;
    public Pair(int row,int col,int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
public class G10NearestCellWith1 {
    public int[][] nearest(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][] res = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            res[row][col]=dis;
            for(int j=0;j<4;j++){
                int nrow = row + dx[j];
                int ncol = col + dy[j];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==0 && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.offer(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return res;
        
        
    }
}
