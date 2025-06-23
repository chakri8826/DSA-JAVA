import java.util.*;
class G13DistinctIslands {
    public String toString(int a,int b){
        return Integer.toString(a)+" "+Integer.toString(b);
    }
    public void DFS(int r,int c,boolean vis[][],ArrayList<String> li,int[][] grid,int row0,int col0){
        vis[r][c]=true;
        li.add(toString(r-row0,c-col0));
        int n = grid.length;
        int m = grid[0].length;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = r+dx[i];
            int ncol = c+dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && !vis[nrow][ncol]){
                DFS(nrow,ncol,vis,li,grid,row0,col0);
            }
        }
    }
    
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        Set<ArrayList<String>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ArrayList<String> li = new ArrayList<>();
                    DFS(i,j,vis,li,grid,i,j);
                    st.add(li);
                }
            }
        }
        return st.size();
    }
}
