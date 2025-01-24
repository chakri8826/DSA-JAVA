import java.util.Arrays;
import java.util.HashSet;

public class A21LongConsSeq {
    public static boolean ls(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true; // Return the index if the element is found
            }
        }
        return false; // Return -1 if the element is not found
    }
    //BRUTE
    // public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
    //     int maxi=1;
    //     for(int i=0;i<N;i++){
    //         int curr = arr[i];
    //         int len=1;
    //         while(ls(arr,curr+1)==true){
    //             curr=curr+1;
    //             len=len+1;
    //         }
    //         maxi=Math.max(maxi,len);
    //     }
    //     return maxi;
    // }

    
    //BRUTE
    // public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
    //     int maxi = 1;
    //     for (int i = 0; i < N; i++) {
    //         int curr = arr[i];
    //         int len = 1;
    //         for (int j = 0; j < N; j++) {
    //             if (arr[j] == curr + 1) { // Check if the next consecutive number exists
    //                 curr = curr + 1;    // Update current number
    //                 len++;              // Increment sequence length
    //                 j = -1;             // Restart the search to ensure all elements are checked
    //             }
    //         }
    //         maxi = Math.max(maxi, len);
    //     }
    //     return maxi;
    // }








    //BETTER
    // public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
    //     Arrays.sort(arr);
    //IF ARR IS EMPTY 0 SHOULD BE ANSWER
    // if(N==0) return 0;
    //     int maxi=1,cc=0,ls=Integer.MIN_VALUE;
    //     for(int i=0;i<N;i++){
    //         if(arr[i]==ls+1){
    //             cc++;
    //             ls=arr[i];
    //             maxi=Math.max(maxi,cc);
    //         }
    //         else if(arr[i]!=ls){
    //             cc=1;
    //             ls=arr[i];
    //         }
    //     }
    //     return maxi;
    // }

    
        //OPTIMAL
    public static int find(int ele, HashSet<Integer> set){
        int len=1;
        while(set.contains(ele+1)){
            len++;
            ele++;
        }
        return len;
    }
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(arr[i]);
        }
        int maxi=1;
        for(int i=0;i<N;i++){
            int curr = arr[i];
            if(!set.contains(curr-1)){
                int len = find(curr,set);
                maxi = Math.max(maxi,len);
            }
        }
        return maxi;
    }




        
    







    
}
