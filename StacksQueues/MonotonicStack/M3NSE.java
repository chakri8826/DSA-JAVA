import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class M3NSE {

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr.get(i)){
                st.pop();
            }
            res.set(i,st.isEmpty()?-1:st.peek());
            st.push(arr.get(i));
        }
        return res;
    }
}
