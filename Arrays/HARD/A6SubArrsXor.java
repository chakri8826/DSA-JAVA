import java.util.HashMap;

public class A6SubArrsXor {
    public int solve(int[] A, int B) {
        int n = A.length; //size of the given array.
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int xor=0;
            for (int j = i; j < n; j++) {
                xor^=A[j];
                if (xor == B) cnt++;
            }
        }
        return cnt;
    }

    // public int solve(int[] A, int B) {
    //     int n = A.length,cnt=0,pxor=0;
    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     map.put(0,1);
    //     for(int i=0;i<n;i++){
    //         pxor^=A[i];
    //         if(map.containsKey(pxor^B)){
    //             cnt+=map.get(pxor^B);
    //         }
    //         map.put(pxor,map.getOrDefault(pxor,0)+1);
    //     }
    //     return cnt;
    // }
    public static void main(String[] args) {
        
    }
}

