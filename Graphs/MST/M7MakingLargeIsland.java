public class M7MakingLargeIsland {
    public void DFS(int i,int j,boolean vis[][],int cnt[],int[][] mark,int id,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[i][j]=true;
        cnt[0]++;
        mark[i][j]=id;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};
        for(int dir=0;dir<4;dir++){
            int nx = i+dx[dir];
            int ny = j+dy[dir];
            if(nx>=0 && nx<n && ny>=0 && ny<m && !vis[nx][ny] && grid[nx][ny]==1){
                DFS(nx,ny,vis,cnt,mark,id,grid);
            }
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int mark[][] = new int[n][n];
        Map<Integer,Integer> map = new HashMap<>();
        boolean vis[][] = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int cnt[] = new int[1];
                    int id=i*n+j;
                    DFS(i,j,vis,cnt,mark,id,grid);
                    map.put(id,cnt[0]);
                }
            }
        }

        int maxCnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int size=1;
                    Set<Integer> seen = new HashSet<>();
                    int dx[] = {-1,0,1,0};
                    int dy[] = {0,1,0,-1};
                    for(int dir=0;dir<4;dir++){
                        int nx = i+dx[dir];
                        int ny = j+dy[dir];
                        if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==1){
                            int neighId = mark[nx][ny];
                            if(seen.add(neighId)){ 
                                size += map.get(neighId);
                            }
                        }
                    }
                    maxCnt = Math.max(size,maxCnt);
                }
            }
        }
        if(maxCnt==0)return n*n;
        return maxCnt;
    }
}