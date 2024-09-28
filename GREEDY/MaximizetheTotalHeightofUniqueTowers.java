import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximizetheTotalHeightofUniqueTowers {
     public static long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<maximumHeight.length;i++){
            int item=maximumHeight[i];
            if(!hs.contains(item)){
                hs.add(item);
            }
            else{
                while(item>0){
                    if(!hs.contains(item)){
                        hs.add(item);
                        break;
                    }
                    item--;
                    if(item==0){
                        return -1;
                    }
                }
            }
        }
        long sum =0;
        for(int i:hs){
            sum+=i;
        }
        return sum;
    }

    //OPTIMISED VERSION O(N LOG N)
    public static long maximumTotalSumOptimsed(int[] maximumHeight) {
        // Sort the maximumHeight array in increasing order
        Arrays.sort(maximumHeight);
        
        int n = maximumHeight.length;
        long totalSum = 0;
        int currentHeight = maximumHeight[n - 1];  // Start from the largest value
        
        // Traverse from the largest element in the sorted array to the smallest
        for (int i = n - 1; i >= 0; i--) {
            // Assign the minimum between the current height and maximum allowable height
            currentHeight = Math.min(currentHeight, maximumHeight[i]);
            
            // If currentHeight is less than or equal to zero, return -1 (impossible to assign)
            if (currentHeight <= 0) {
                return -1;
            }
            
            // Add the current height to the total sum
            totalSum += currentHeight;
            
            // Decrease the current height for the next iteration to maintain uniqueness
            currentHeight--;
        }
        
        return totalSum;
    }
    public static void main(String[] args) {
        int arr[]={2,3,4,3};
        // System.out.println(maximumTotalSum(arr));
        System.out.println(maximumTotalSumOptimsed(arr));
    }
}
