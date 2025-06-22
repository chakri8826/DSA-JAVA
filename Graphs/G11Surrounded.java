public class G11Surrounded{
    int dx[] = {-1,0,1,0};
    int dy[] = {0,1,0,-1};

    public void DFS(int r,int c,char[][] board,boolean[][] vis){
        vis[r][c]=true;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++){
            int nrow = r+dx[i];
            int ncol = c+dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O' && !vis[nrow][ncol]){
                DFS(nrow,ncol,board,vis);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][] = new boolean[n][m];
    
        for (int j = 0; j < m; j++) {
            if(board[0][j]=='O' && !vis[0][j]) DFS(0,j,board,vis);
            if(board[n-1][j]=='O' && !vis[n-1][j]) DFS(n-1,j,board,vis);
        }

        for (int i = 1; i < n-1 ; i++) {
            if(board[i][0]=='O' && !vis[i][0]) DFS(i,0,board,vis);
            if(board[i][m - 1]=='O' && !vis[i][m-1]) DFS(i,m-1,board,vis);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }
}