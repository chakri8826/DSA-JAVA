import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first,second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

public class G6Islands {
    int dx[] = {-1,-1,-1,0,1,1,1,0};
    int dy[] = {-1,0,1,1,1,0,-1,-1};
    
    public void DFS(int i,int j,char[][] grid,boolean vis[][]){
        vis[i][j]=true;
        int n = grid.length;
        int m = grid[0].length;
        for(int dir=0;dir<8;dir++){
            int iind = i + dx[dir];
            int jind = j + dy[dir];
            if(iind>=0 && jind>=0 && iind<n && jind<m && grid[iind][jind]=='L' && !vis[iind][jind]){
                DFS(iind,jind,grid,vis);
            }
        }
    }
    public void BFS(int f,int s,char[][] grid,boolean vis[][]){
        vis[f][s]=true;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(f,s));
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            q.poll();
            for(int dir=0;dir<8;dir++){
                int iind = i + dx[dir];
                int jind = j + dy[dir];
                if(iind>=0 && jind>=0 && iind<n && jind<m && grid[iind][jind]=='L' && !vis[iind][jind]){
                    vis[iind][jind]=true;
                    q.offer(new Pair(iind,jind));
                }
            }
        }
    }
    
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && !vis[i][j]){
                    cnt++;
                    // DFS(i,j,grid,vis);
                    BFS(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}
