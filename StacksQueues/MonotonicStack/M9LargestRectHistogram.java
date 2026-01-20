import java.util.*;

public class M9LargestRectHistogram {
    // BRUTE - CHAKRI APPROACH
    // public int findMl(int[] heights, int ind) {
    //     int res = ind; // Default to itself
    //     for (int i = ind - 1; i >= 0; i--) {
    //         if (heights[i] >= heights[ind]) {
    //             res = i; // Keep extending left
    //         } else {
    //             break; // Stop at the first smaller height
    //         }
    //     }
    //     return res;
    // }

    // public int findMr(int[] heights, int ind) {
    //     int res = ind; // Default to itself
    //     for (int i = ind + 1; i < heights.length; i++) {
    //         if (heights[i] >= heights[ind]) {
    //             res = i; // Keep extending right
    //         } else {
    //             break; // Stop at the first smaller height
    //         }
    //     }
    //     return res;
    // }

    // public int largestRectangleArea(int[] heights) {
    //     int maxi = 0;
    //     if (heights.length == 1) return heights[0];
    //     for (int i = 0; i < heights.length; i++) {
    //         int ml = findMl(heights, i);
    //         int mr = findMr(heights, i);
    //         int width = mr - ml + 1; // Include both boundaries
    //         int area = width * heights[i];
    //         maxi = Math.max(maxi, area);
    //     }
    //     return maxi;
    // }




// BRUTE - NSE AND PSE APPROACH
//     public int findMl(int[] heights, int ind) {
//         int res = -1;
//         for (int i = ind - 1; i >= 0; i--) {
//             if (heights[i] < heights[ind]) { // First strictly smaller height
//                 res = i;
//                 break;
//             }
//         }
//         return res;
//     }
 
//     public int findMr(int[] heights, int ind) {
//         int res = heights.length;
//         for (int i = ind + 1; i < heights.length; i++) {
//             if (heights[i] < heights[ind]) { // First strictly smaller height
//                 res = i;
//                 break;
//             }
//         }
//         return res;
//     }

//     public int largestRectangleArea(int[] heights) {
//         int maxi = 0;
//         if (heights.length == 1) return heights[0];
        
//         for (int i = 0; i < heights.length; i++) {
//             int ml = findMl(heights, i);
//             int mr = findMr(heights, i);
            
            // int width = mr - ml - 1; // Correct width calculation
            // int area = width * heights[i];
            // maxi = Math.max(maxi, area);
//         }
//         return maxi;
//     }



// BETTER
    // public int[] nse(int[] hts){
    //     int nse[] = new int[hts.length];
    //     Stack<Integer> st = new Stack<>();
    //     for(int i=hts.length-1;i>=0;i--){
    //         while(!st.isEmpty() && hts[i]<=hts[st.peek()]){
    //             st.pop();
    //         }
    //         nse[i]=st.isEmpty()?hts.length:st.peek();
    //         st.push(i);
    //     }
    //     return nse;
    // }
    // public int[] pse(int[] hts){
    //     int pse[] = new int[hts.length];
    //     Stack<Integer> st = new Stack<>();
    //     for(int i=0;i<hts.length;i++){
    //         while(!st.isEmpty() && hts[i]<=hts[st.peek()]){
    //             st.pop();
    //         }
    //         pse[i]=st.isEmpty()?-1:st.peek();
    //         st.push(i);
    //     }
    //     return pse;
    // }
    // public int largestRectangleArea(int[] heights) {
    //     int nse[] = nse(heights);
    //     int pse[] = pse(heights);
    //     System.out.println(Arrays.toString(nse));
    //     System.out.println(Arrays.toString(pse));
    //     int maxi=0;
    //     for(int i=0;i<heights.length;i++){
    //         int area = (nse[i]-pse[i]-1) * heights[i];
    //         maxi=Math.max(area,maxi);
    //     }
    //     return maxi;
    // }



 

// OPTIMAL 
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int ele = heights[st.pop()],nse=i;
                int pse = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(ele*(nse-pse-1),maxArea);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ele = heights[st.pop()],nse=heights.length;
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(ele*(nse-pse-1),maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        M9LargestRectHistogram m9 = new M9LargestRectHistogram();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(m9.largestRectangleArea(heights));
    }
}
