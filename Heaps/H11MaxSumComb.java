import java.util.*;
public class H11MaxSumComb {
    //BRUTE
    //  O(n² log(n²))
    // public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
    //     // code here
    //     int n = a.length;
    //     ArrayList<Integer> sums = new ArrayList<>();

    //     // Step 1: Generate all possible sums -> O(n²)
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             sums.add(a[i] + b[j]);
    //         }
    //     }

    //     // Step 2: Sort in descending order -> O(n² log(n²))
    //     Collections.sort(sums, Collections.reverseOrder());

    //     // Step 3: Take top k elements -> O(k)
    //     return new ArrayList<>(sums.subList(0, k));
        
    // }
    

    //OPTIMAL

    // O(n + m)
    public void reverse(int[] arr){
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            int temp = arr[n-i-1];
            arr[n-i-1] = arr[i];
            arr[i] = temp;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a); //O(n log n)
        Arrays.sort(b); //O(m log m)
        
        reverse(a); //O(n)
        reverse(b); //O(m)
        
        ArrayList<Integer> res = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0])); //O(1)
        Set<String> visited = new HashSet<>();
        
        pq.add(new int[]{a[0]+b[0],0,0});
        visited.add("0,0");
        
        int n = a.length;
        int m = b.length;
        
        // O(k log k)  Each poll() or add() operation on heap: O(log k)  && Max number of elements we ever push into heap: at most k (because we stop after extracting k elements)
        while(k-->0 && !pq.isEmpty()){
            int curr[] = pq.poll();
            int sum=curr[0];
            int i=curr[1],j=curr[2];
            
            res.add(sum);
            
            if(i+1<n && !visited.contains((i+1) + "," + j)){
                pq.add(new int[]{a[i+1]+b[j],i+1,j});
                visited.add((i+1) + "," + j);
            }
            if(j+1<m && !visited.contains(i + "," + (j+1))){
                pq.add(new int[]{a[i]+b[j+1],i,j+1});
                visited.add(i + "," + (j+1));
            }
        }
        
        return res;
        
    }
}
