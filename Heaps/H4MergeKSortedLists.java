import java.util.*;
class Pair{
    int i,j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class H4MergeKSortedLists {
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int colSize = arr[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->arr[a.i][a.j]-arr[b.i][b.j]);
        
        for(int i=0;i<K;i++){
            pq.add(new Pair(i,0));    
        }
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            res.add(arr[p.i][p.j]);
            if(p.j+1<colSize){
                pq.add(new Pair(p.i,p.j+1));
            }
        }

        return res;
    }
}