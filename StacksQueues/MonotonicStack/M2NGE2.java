import java.util.*;
class M2NGE2{
    // public int[] nextGreaterElements(int[] nums) {
    //      int n = nums.length;
    //      int res[] = new int[n];
    //      Arrays.fill(res,-1);
    //     for(int i=0;i<n;i++){
    //         for (int j = i + 1; j<i+n; j++) {    
    //             int ind = j % n;  
    //             if (nums[ind] > nums[i]) {
    //                 res[i] = nums[ind];
    //                 break;
    //             }
    //         }
    //     }
                // CHAKRI'S THOUGHT
    //         // int j=i+1;
    //         // j=j%n;
    //         // while(j!=i){
    //         //     if(nums[j]>nums[i]){
    //         //         res[i]=nums[j];
    //         //         break;
    //         //     }
    //         //     j++;
    //         //     j=j%n;
    //         // }
    //     return res;
    // }


    // OPTIMAL
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
                res[i]=st.isEmpty()?-1:st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}

