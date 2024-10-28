import java.util.*;
public class MColoringLIST {
    public boolean isSafe(int u,List<int[]> edges,int m,int[] CA,int V){
        /*
         * Condition 1: If v1 == u (i.e., the current vertex u is one of the vertices of the edge) and CA[v2] == m (i.e., the other vertex connected by the edge is already colored with color m), then returning false indicates that coloring u with m would not be safe because its neighbor has the same color.
            Condition 2: If v2 == u (i.e., the current vertex u is the other vertex of the edge) and CA[v1] == m (i.e., the first vertex connected by the edge is already colored with color m), then it also returns false for the same reason
         */
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



// ADJ LIST
//TIME-COMPLEXITY-->O(M^V * E)     Checking if the Coloring is Safe: O(E):
//SPACE-COMPLEXITY-->O(V+E)    //ADJ LIST-->O(V+E)
