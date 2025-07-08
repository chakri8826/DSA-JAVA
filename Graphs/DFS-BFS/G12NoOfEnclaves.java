import java.util.*;

class Pair{
    int f,s;
    public Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
public class G12NoOfEnclaves {
    public void DFS(int r, int c, int[][] board, boolean[][] vis) {
        vis[r][c] = true;
        int n = board.length;
        int m = board[0].length;
        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) {
            int nrow = r + dx[i];
            int ncol = c + dy[i];
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && board[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                DFS(nrow, ncol, board, vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        // Step 1: DFS from all boundary land cells
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1)
                DFS(i, 0, grid, vis);
            if (grid[i][m - 1] == 1)
                DFS(i, m - 1, grid, vis);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1)
                DFS(0, j, grid, vis);
            if (grid[n - 1][j] == 1)
                DFS(n - 1, j, grid, vis);
        }

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && !vis[i][j])
                    count++;

        return count;

        
        // BFS
        // int n = grid.length;
        // int m = grid[0].length;
        // boolean vis[][] = new boolean[n][m];
        // Queue<Pair> q = new LinkedList<>();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(i==0 || i==n-1 || j==0 || j==m-1){
        //             if(grid[i][j]==1){
        //                 vis[i][j]=true;
        //                 q.offer(new Pair(i,j));
        //             }
        //         }
        //     }
        // }

        // int dx[] = {-1,0,1,0};
        // int dy[] = {0,1,0,-1};

        // while(!q.isEmpty()){
        //     Pair p = q.poll();
        //     int f = p.f;
        //     int s = p.s;
        //     for(int i=0;i<4;i++){
        //         int nrow = f+dx[i];
        //         int ncol = s+dy[i];
        //         if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
        //             vis[nrow][ncol]=true;
        //             q.offer(new Pair(nrow,ncol));
        //         }
        //     }
        // }
        // int cnt=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid[i][j]==1 && !vis[i][j]){
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;
    }
}
