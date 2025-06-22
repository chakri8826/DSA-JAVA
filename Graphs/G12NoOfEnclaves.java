import java.util.*;

class Pair{
    int f,s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
public class G12NoOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        vis[i][j]=true;
                        q.offer(new Pair(i,j));
                    }
                }
            }
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int f = p.f;
            int s = p.s;
            for(int i=0;i<4;i++){
                int nrow = f+dx[i];
                int ncol = s+dy[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}