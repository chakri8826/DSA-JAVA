import java.util.Arrays;
import java.util.Stack;

public class M3NSE {
        public int[] prevSmaller(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && A[i]<=st.peek()){
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(A[i]);
        }
        return res;
    }
}
