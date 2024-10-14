public class MColoringGFG {
   public boolean isSafe(int u,List<int[]> edges,int m,int[] CA,int V){
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            if((v1 == u && CA[v2] == m) || (v2 == u && CA[v1] == m)){
                return false;
            }
        }
        return true;
    }
    public boolean Mcolor(int M,int V,List<int[]> edges,int u,int[] CA){
        if(u==V) return true;
        for(int m=1;m<=M;m++){
            if(isSafe(u,edges,m,CA,V)){
                CA[u]=m;
                if (Mcolor(M, V, edges, u + 1, CA)) {
                    return true;
                }
                CA[u]=0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, List<int[]> edges, int m) {
        int[] CA = new int[v];
        return Mcolor(m,v,edges,0,CA);
    }

    

}