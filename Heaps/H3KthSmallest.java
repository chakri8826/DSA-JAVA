import java.util.*;
public class H3KthSmallest {
        // public static int kthSmallest(int[] arr, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    //     for(int num:arr){
    //         if(pq.size()>k)pq.poll();
    //         pq.add(num);
    //     }
 
    //     return pq.poll();
    // }
    
    
    
    // public static int kthSmallest(int[] nums, int k) {
    //     int n = nums.length;

    //     // Step 1: Build min heap
    //     for (int i = n / 2 - 1; i >= 0; i--) {
    //         heapify(nums, n, i);
    //     }

    //     // Step 2: Extract min (k-1) times
    //     for (int i = n - 1; i > n - k; i--) {
    //         // swap root (max) with end
    //         int temp = nums[0];
    //         nums[0] = nums[i];
    //         nums[i] = temp;

    //         // heapify reduced heap
    //         heapify(nums, i, 0);
    //     }

    //     // After removing k-1 smallest, root is kth smallest
    //     return nums[0];
    // }

    // // Heapify subtree rooted at index i in array of size n
    // private static void heapify(int[] arr, int n, int i) {
    //     int smallest = i;
    //     int left = 2 * i + 1;
    //     int right = 2 * i + 2;

    //     if (left < n && arr[left] < arr[smallest]) {
    //         smallest = left;
    //     }

    //     if (right < n && arr[right] < arr[smallest]) {
    //         smallest = right;
    //     }

    //     if (smallest != i) {
    //         int swap = arr[i];
    //         arr[i] = arr[smallest];
    //         arr[smallest] = swap;

    //         heapify(arr, n, smallest);
    //     }
    // }
    
    
    
    
    public static int kthSmallest(int[] nums, int k) {
        ArrayList<Integer> li = new ArrayList<>();
        for(int num:nums){
            li.add(num);
        }
        return quickSelect(li,k);
    }
    
    public static int quickSelect(ArrayList<Integer> arr, int k) {
        Random rand = new Random();
        int pivot = arr.get(rand.nextInt(arr.size()));
        ArrayList<Integer> left = new ArrayList<>(); 
        ArrayList<Integer> right = new ArrayList<>(); 
        ArrayList<Integer> mid = new ArrayList<>(); 
        
        for(int num:arr){
            if(num<pivot) left.add(num);
            else if(num>pivot) right.add(num);
            else mid.add(num);
        }
        
        int leftSize = left.size();
        int midSize = mid.size();
        
        if (k <= leftSize) {
            return quickSelect(left, k); // kth smallest in left
        } else if (k > leftSize + midSize) {
            return quickSelect(right, k - leftSize - midSize); // adjust k
        } else {
            return pivot; // pivot is the kth smallest
        }
    }
}
    