// User function Template for Java
import java.util.*;
class Pair{
    int val,i;
    Pair(int val,int i){
        this.val=val;
        this.i=i;
    }
}

public class H5ReplaceEleRanks {
    // USING HEAP
    // static int[] replaceWithRank(int arr[], int N) {
    //     // code here
    //     PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
    //     for(int i=0;i<N;i++){
    //         pq.add(new Pair(arr[i],i));
    //     }
        
    //     int rank=0,prev=-1;
    //     int newArr[] = new int[N];
        
    //     while(!pq.isEmpty()){
    //         Pair p = pq.poll();
    //         if(p.val!=prev){
    //             rank++;
    //         }     
    //         newArr[p.i]=rank;
    //         prev=p.val;
    //     }
    //     return newArr;
    // }
    
    
    // USING SORTING
    static int[] replaceWithRank(int arr[], int N) {
        // Step 1: Copy array
        int[] temp = Arrays.copyOf(arr, N);

        // Step 2: Sort the copy
        Arrays.sort(temp);

        // Step 3: Assign ranks using a HashMap
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int val : temp) {
            if (!rankMap.containsKey(val)) {
                rankMap.put(val, rank++);
            }
        }

        // Step 4: Replace elements in original array
        int[] newArr = new int[N];
        for (int i = 0; i < N; i++) {
            newArr[i] = rankMap.get(arr[i]);
        }

        return newArr;
    }
}