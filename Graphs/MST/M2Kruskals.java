class Pair {
    int u, v, wt;

    public Pair(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

class DSU {
    int parent[], rank[];

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void unionByRank(int u, int v) {
        int x_rep = find(u);
        int y_rep = find(v);
        if (rank[x_rep] < rank[y_rep]) {
            parent[x_rep] = y_rep;
        } else if (rank[y_rep] < rank[x_rep]) {
            parent[y_rep] = x_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}

public class M2Kruskals {
    /* adj list will be like this
     * adj[0] = [ {1, 10}, {2, 6}, {3, 5} ]
     * adj[1] = [ {0, 10}, {3, 15} ]
     * adj[2] = [ {0, 6}, {3, 4} ]
     * adj[3] = [ {0, 5}, {1, 15}, {2, 4} ]
     * 
     */
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        DSU dsu = new DSU(V);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
        for (int i = 0; i < V; i++) {
            for (int edge[] : adj.get(i)) {
                int v = edge[0], wt = edge[1];
                if (i < v) { // ensures the pair is added only once without double time (Undirected graph).
                    pq.offer(new Pair(i, v, wt));
                }
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.u, v = p.v, wt = p.wt;
            if (dsu.find(u) != dsu.find(v)) {
                sum += wt;
                dsu.unionByRank(u, v);
            }
        }
        return sum;
    }

    // If inp is like edges[][] then we can do like this
    // public int spanningTree(int V, int[][] edges) {
    //     DSU dsu = new DSU(V);
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));
    //     for(int edge[]:edges){
    //         int u=edge[0], v = edge[1], wt = edge[2];
    //         pq.offer(new Pair(u, v, wt));
    //     }
    //     int sum = 0;
    //     while (!pq.isEmpty()) {
    //         Pair p = pq.poll();
    //         int u = p.u, v = p.v, wt = p.wt;
    //         if (dsu.find(u) != dsu.find(v)) {
    //             sum += wt;
    //             dsu.unionByRank(u, v);
    //         }
    //     }
    //     return sum;
    // }
}
