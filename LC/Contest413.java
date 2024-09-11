import java.util.PriorityQueue;

public class Contest413{

    //FIRST PROBLEM
    public static boolean ifSame(int a,int b,int c, int d){
        if((a%2!=0 && b%2!=0) && (c%2!=0 && d%2!=0)){
            return true;
        }
        if((a%2==0 && b%2==0) && (c%2==0 && d%2==0)){
            return true;
        }
        if((a%2!=0 && b%2!=0) && (c%2==0 && d%2==0)){
            return true;
        }
        if((a%2==0 && b%2==0) && (c%2!=0 && d%2!=0)){
            return true;
        }
        if((a%2!=0 && b%2==0) && (c%2==0 && d%2!=0)){
            return true;
        }
        if((a%2==0 && b%2!=0) && (c%2!=0 && d%2==0)){
            return true;
        }
         if((a%2!=0 && b%2==0) && (c%2!=0 && d%2==0)){
            return true;
        }
         if((a%2==0 && b%2!=0) && (c%2==0 && d%2!=0)){
            return true;
        }
        return false;
    }
    //OPTIMAL SOLUTION FOR PROBLEM-1
      public boolean checkTwoChessboards(String c1, String c2) {
        int s1 = (c1.charAt(0) - 'a') + (c1.charAt(1) - '0');
        int s2 = (c2.charAt(0) - 'a') + (c2.charAt(1) - '0');
        return s1 % 2 == s2 % 2;
    }

    //SECOND PROBLEM
    public static int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        // Max-heap to maintain the k smallest distances
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if (maxHeap.size() < k) {
                maxHeap.add(sum);
            }
            else if (sum < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(sum);
            }
            // After processing the i-th query
            if (maxHeap.size() >= k) {
                res[i] = maxHeap.peek(); // k-th smallest element
            } else {
                res[i] = -1;
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        System.out.println('3'-'0');   
    }
}



