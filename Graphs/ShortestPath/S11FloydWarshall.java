public class S11FloydWarshall {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]!=1e8 && dist[via][j]!=1e8){
                        dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    }
                }
            }
        }
    }
}


// USING DIJSTRA-ALGO
// class Pair{
//     int v,wt;
//     public Pair(int v,int wt){
//         this.v=v;
//         this.wt=wt;
//     }
// }
// class S11FloydWarshall {
//     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++) adj.add(new ArrayList<>());
//         for(int edge[]:edges){
//             int u=edge[0],v=edge[1],wt=edge[2];
//             adj.get(u).add(new Pair(v,wt));
//             adj.get(v).add(new Pair(u,wt));
//         }

//         int minReachable=Integer.MAX_VALUE;
//         int ans=-1;
//         for(int i=0;i<n;i++){
//             int dist[] = dijstra(i,adj,n);
            
//             int cnt=0;
//             for(int j=0;j<n;j++){
//                 if(i!=j && dist[j]<=distanceThreshold){
//                     cnt++;
//                 }
//             }

//             if(cnt<=minReachable){
//                 minReachable=cnt;
//                 ans=i;
//             }
//         }
//         return ans;

//     }
//     public int[] dijstra(int src,ArrayList<ArrayList<Pair>> adj,int n){
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
//         int dist[] = new int[n];
//         Arrays.fill(dist,Integer.MAX_VALUE);
//         pq.offer(new Pair(src,0));
//         dist[src]=0;
//         while(!pq.isEmpty()){
//             Pair top = pq.poll();
//             int node = top.v;
//             int wt = top.wt;
//             for(Pair nbr:adj.get(node)){
//                 int v=nbr.v;
//                 int dis=nbr.wt;
//                 if(dist[node]+dis<dist[v]){
//                     dist[v]=dist[node]+dis;
//                     pq.offer(new Pair(v,dist[v]));  
//                 }
//             }
//         }
//         return dist;
//     }
// }