  
class DSU{
    int parent[],rank[];
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x] = find(parent[x]);
    }

    public void unionByRank(int u,int v){
        int px = find(u);
        int py = find(v);
        if(rank[px]<rank[py]){
            parent[px]=py;
        }
        else if(rank[py]<rank[px]){
            parent[py]=px;
        }
        else{
            parent[py]=px;
            rank[px]++;
        }
    }
}
public class M6NoOfIslands2 {
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        DSU dsu = new DSU(n*m);
        int noOfQueries = q.length;
        
        int dx[] = {-1,0,1,0};
        int dy[] = {0,1,0,-1};

        boolean vis[][] = new boolean[n][m];

        int res[] = new int[noOfQueries];
        int ind=0,cnt=0;

        for(int[] query:q){
            int x = query[0];
            int y = query[1];

            if(vis[x][y]){
                res[ind++]=cnt;
                continue;
            }

            vis[x][y]=true;
            cnt++;
            int currId = x*m+y;

            for(int dir=0;dir<4;dir++){
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]){
                    int neighId = nx*m+ny;
                    if(dsu.find(currId)!=dsu.find(neighId)){
                        dsu.unionByRank(currId,neighId);
                        cnt--;
                    }
                }
            }

            res[ind++]=cnt;
        }
        return res;
    }
}