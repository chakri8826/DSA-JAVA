import java.util.ArrayList;

public class A17SubArrMaxSumNoNegs {
    public ArrayList<Integer> findSubarray(int arr[]) {
        int maxi = Integer.MIN_VALUE, sum = 0, n = arr.length, start = 0, aStart = -1, aEnd = -1;

        // Handle edge case for empty array
        if (n == 0) return new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                sum = 0;
                start = i + 1; // Reset start index for the next potential subarray
            } 
            else {
                sum += arr[i];
                if (sum >= maxi  ) {
                    maxi = sum;
                    aStart = start;
                    aEnd = i;
                }
            }
        }
        ArrayList<Integer> li = new ArrayList<>();
        if (aStart == -1 && aEnd == -1){
            li.add(-1);
            return li;
        }
        else{ // Valid subarray exists
            for (int i = aStart; i <= aEnd; i++) {
                li.add(arr[i]);
            }
        }

        return li;
    }
}


