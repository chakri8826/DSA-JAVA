class DSU{
    int[] parent,rank;

    public DSU(int V){
        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
    }

    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    public void unionByRank(int u,int v){
        int px = find(u);
        int py = find(v);
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
public class M3NoOfOperationsToConnect {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        DSU dsu = new DSU(n);
        for(int conn[]:connections){
            dsu.unionByRank(conn[0],conn[1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(dsu.parent[i]==i)res++;
        }
        return res-1;
    }
}
