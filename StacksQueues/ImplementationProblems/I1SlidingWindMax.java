import java.util.ArrayDeque;
import java.util.Deque;

public class I1SlidingWindMax {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int res[] = new int[n-k+1];
    //     for(int i=0;i<=n-k;i++){
    //         int maxi=Integer.MIN_VALUE;
    //         for(int j=i;j<i+k;j++){
    //             maxi=Math.max(maxi,nums[j]);
    //         }
    //         res[i]=maxi;
    //     }
    //     return res;
    // }


    // FAILED AS Collections.max(deq) takes O(K).
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int res[] = new int[n-k+1];
    //     Deque<Integer> deq = new  ArrayDeque<>();
    //     for(int i=0;i<k;i++){
    //         deq.addLast(nums[i]);
    //     }
    //     res[0]=Collections.max(deq);
    //     int ind=1;
    //     for(int i=k;i<n;i++){
    //         deq.removeFirst();
    //         deq.addLast(nums[i]);
    //         res[ind++]=Collections.max(deq);
    //     }
    //     return res;
    // }

    // Optimized
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length,ind=0;
        int res[] = new int[n-k+1];
        Deque<Integer> deq = new  ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!deq.isEmpty() && deq.getFirst()<=i-k){
                deq.removeFirst();
            }
            while(!deq.isEmpty() && nums[i]>=nums[deq.getLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
            if(i>=k-1){
                res[ind++]=nums[deq.getFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        I1SlidingWindMax obj = new I1SlidingWindMax();
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = obj.maxSlidingWindow(nums, k);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
