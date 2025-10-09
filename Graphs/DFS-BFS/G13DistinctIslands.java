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


    public void BFS(int r, int c, boolean[][] vis, List<String> shape, int[][] grid, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        vis[r][c] = true;
        // shape.add(toString(0, 0)); // relative (0,0)

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int curR = cell[0];
            int curC = cell[1];

            for (int i = 0; i < 4; i++) {
                int newR = curR + dx[i];
                int newC = curC + dy[i];

                if (newR >= 0 && newC >= 0 && newR < n && newC < m &&
                        grid[newR][newC] == 1 && !vis[newR][newC]) {

                    vis[newR][newC] = true;
                    q.add(new int[] { newR, newC });
                    shape.add(toString(newR - row0, newC - col0));
                }
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
                    // BFS(i, j, vis, li, grid, i, j);
                    st.add(li);
                }
            }
        }
        System.out.println(st);
        return st.size();
    }
    public static void main(String[] args) {
        G13DistinctIslands g = new G13DistinctIslands();
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(g.countDistinctIslands(grid));
    }
}
