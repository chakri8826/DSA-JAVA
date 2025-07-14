
class DSU{
    int parent[],rank[];
    public DSU(int V){
        parent=new int[V];
        rank=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    public void unionByRank(int u,int v){
        int px=find(u);
        int py=find(v);
        if(px==py)return;
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
public class M4MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int maxRow=0,maxCol=0;
        int n=stones.length;
        for(int row[]:stones){
            maxRow=Math.max(maxRow,row[0]);
            maxCol=Math.max(maxCol,row[1]);
        }
        DSU dsu = new DSU(maxRow+maxCol+2);
        Set<Integer> set = new HashSet<>();
        for(int row[]:stones){
            int u=row[0],v=row[1]+maxRow+1;
            dsu.unionByRank(u,v);
            set.add(u);
            set.add(v);
        }
        int cnt=0;
        for(int node:set){
            if(dsu.parent[node]==node){
                cnt++;
            }
        }
        return n-cnt;
    }
}

