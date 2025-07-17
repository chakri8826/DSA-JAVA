import java.util.Arrays;

class S10BellmanFord{
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[] = new int[V];
        int maxi = (int)1e8;
        Arrays.fill(dist,maxi);
        dist[src]=0;
5


        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            if(dist[u]!=maxi && dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}