import java.util.*;
public class MColoringMATRIX{
    public boolean isSafe(int u,int[][] edges,int m,int[] CA,int V){
        for(int v=0;v<V;v++){
            if(edges[u][v]==1 && CA[v]==m){
                return false;
            }
        }
        return true;
    }
    public boolean Mcolor(int M,int V,int[][] edges,int u,int[] CA){
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
    public static void main(String[] args){
        int[][] edges={
                        {0,1,1,1},
                        {1,0,1,0},
                        {1,1,0,1},
                        {1,0,1,0}};
        MColoringMATRIX m = new MColoringMATRIX();
        int[] CA = new int[4];
        boolean res = m.Mcolor(3, 4, edges, 0, CA);

        if (res) {
        System.out.println("Solution exists: " + Arrays.toString(CA));
        } else {
            System.out.println("No solution exists.");
        }

        
    }
}

// ADJ MATRIX
//TIME-COMPLEXITY-->O(M^V * V)     Checking if the Coloring is Safe: O(V):
//SPACE-COMPLEXITY-->O(V^2)    //ADJ MATRIX-->O(V^2)

