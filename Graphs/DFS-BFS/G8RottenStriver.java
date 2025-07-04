import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first, second, third;

    public Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}   
public class G8RottenStriver {
     int dx[] = {-1,0,1,0};
    int dy[] = {0,1,0,-1};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh=0,cnt=0;
        int vis[][] = new int[n][m];
        vis=grid;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
 
        int tm=0;
        while(!q.isEmpty()){
            int f = q.peek().first;
            int s = q.peek().second;
            int t = q.peek().third;
            tm = Math.max(tm,t);
            q.poll();
            for(int j=0;j<4;j++){
                int iind = f + dx[j];
                int jind = s + dy[j];
                if(iind>=0 && jind>=0 && iind<n && jind<m && vis[iind][jind]==1){
                    vis[iind][jind]=2;
                    q.offer(new Pair(iind,jind,t+1));
                    fresh--;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=2 && grid[i][j]==1)return -1;
            }
        }
        return tm;

        
    }
}
