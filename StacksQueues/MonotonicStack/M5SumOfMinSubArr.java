import java.util.Stack;

class Solution {
    // BRUTE FORCE
    // public int sumSubarrayMins(int[] arr) {
    //     int mod = 1_000_000_007;
    //     int n = arr.length;
    //     long sum = 0;

    //     // Generate all subarrays
    //     for (int i = 0; i < n; i++) {
    //         int minVal = Integer.MAX_VALUE;
    //         for (int j = i; j < n; j++) {
    //             minVal = Math.min(minVal,arr[j]);
    //             sum = (sum + minVal) % mod;
    //         }
    //     }
    //     return (int) sum;
    // }


    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSEE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length,mod = (int) 1e9+7;
        int[] nse = findNSE(arr);
        int[] pse = findPSEE(arr);
        long total = 0; 
        for(int i=0;i<n;i++){
            long left = i-pse[i];
            long right = nse[i]-i;
            total = (total +(right*left*arr[i]))%mod;
        }   
        return (int) total;
    }



}
