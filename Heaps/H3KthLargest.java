import java.util.*;
public class H3KthLargest {

    // O(nlogk) SC->O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        for (int num : nums) {
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }

    // O(n+klogn) SC->O(1)
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Step 2: Extract max (k-1) times
        for (int i = n - 1; i > n - k; i--) {
            // swap root (max) with end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // heapify reduced heap
            heapify(nums, i, 0);
        }

        // After removing k-1 largest, root is kth largest
        return nums[0];
    }

    // Heapify subtree rooted at index i in array of size n
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    
    // QUICK SELECT
    // O(n) SC->O(n)
    public int findKthLargest3(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        return quickSelect(arr, k);
    }

    private int quickSelect(List<Integer> arr, int k) {
        Random rand = new Random(); 
        int pivot = arr.get(rand.nextInt(arr.size()));

        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : arr) {
            if (num > pivot) left.add(num);
            else if (num < pivot) right.add(num);
            else mid.add(num);
        }

        int leftSize = left.size();
        int midSize = mid.size();

        if (k <= leftSize) {
            return quickSelect(left, k); // kth largest in left
        } else if (k > leftSize + midSize) {
            return quickSelect(right, k - leftSize - midSize); // adjust k
        } else {
            return pivot; // pivot is the kth largest
        }
    }

    public static void main(String[] args) {
        H3KthLargest h3 = new H3KthLargest();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(h3.findKthLargest(nums, k));
    }
}