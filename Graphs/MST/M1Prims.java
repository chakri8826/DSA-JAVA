import java.util.PriorityQueue;

class Pair{
    int wt,node;
    public Pair(int wt,int node){
        this.wt=wt;
        this.node=node;
    }
}

public class M1Prims {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        pq.offer(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int wt=top.wt,node=top.node;
            if(vis[node])continue;
            vis[node]=true;
            sum+=wt;
            for(int[] nbr:adj.get(node)){
                int v=nbr[0];
                int dis=nbr[1];
                if(!vis[v]){
                    pq.offer(new Pair(dis,v));
                }
            }
        }
        return sum;
    }    
}
