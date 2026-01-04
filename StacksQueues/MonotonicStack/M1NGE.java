import java.util.HashMap;
import java.util.Stack;

public class M1NGE {
    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int n1 = nums1.length,n2 = nums2.length;
    //     int res[] = new int[n1];
    //     for(int i=0;i<n1;i++){
    //         int j;
    //         for(j=0;j<n2;j++){
    //             if(nums1[i]==nums2[j]){
    //                 break;
    //             }
    //         }
    //         int flag=0;
    //         for(int p=j+1;p<n2;p++){
    //             if(nums2[p]>nums2[j]){
    //                 res[i]=nums2[p];
    //                 flag=1;
    //                 break;
    //             }
    //         }
    //         if(flag==0){
    //             res[i]=-1;
    //         }
    //     }
    //     return res;
    // }



    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int n = nums1.length,m = nums2.length;
    //     int res[] = new int[m];
    //     int fin[] = new int[n];

    //     Stack<Integer> st = new Stack<>();
    //     for(int i=m-1;i>=0;i--){
    //         while(!st.isEmpty() && st.peek()<nums2[i]){
    //             st.pop();
    //         }
    //         res[i]=st.isEmpty()?-1:st.peek();
    //         st.push(nums2[i]);
    //     }

    //     HashMap<Integer,Integer> map = new HashMap<>();
    //     for(int i=0;i<m;i++){
    //         map.put(nums2[i],i);
    //     }
    //     for(int i=0;i<n;i++){
    //         int ind = map.get(nums1[i]);
    //         fin[i]=res[ind];
    //     }
    //     return fin;
    // }


    // AVOIDING ==> res[]
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length,m = nums2.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            map.put(nums2[i],st.isEmpty() ?-1:st.peek());
            st.push(nums2[i]);
        }
        int fin[] = new int[n];
        for(int i=0;i<n;i++){
            fin[i]=map.get(nums1[i]);
        }

        return fin;
    }
}