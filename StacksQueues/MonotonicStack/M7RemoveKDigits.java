import java.util.*;
class M7RemoveKDigits{
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            char curr = num.charAt(i);
            if(st.isEmpty() || curr>=st.peek()){
                st.push(curr);
            }
            else{
                while(!st.isEmpty() && k>0 && curr<st.peek()){
                    st.pop();
                    k--;
                }
                st.push(curr);
            }
        }

        // K MIGHT NOT BECOME 0 IN UPPER LOOP (IF INP IS IN ASCENDING ORDER NOTHING WILL BE REMOED IN THERE, SO REMOVE LAST K NUMBERS )
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());  
        }
        sb=sb.reverse();

        // REMOVE TRAINLING 0's IF PRESENT
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
            
        return sb.length()==0?"0":sb.toString();
    }
 
    public static void main(String[] args) {
        M7RemoveKDigits solution = new M7RemoveKDigits();
        
        // Example cases
        System.out.println(solution.removeKdigits("1432999", 3)); // Output: "1219"
        // System.out.println(solution.removeKdigits("10200", 1));   // Output: "200"
        // System.out.println(solution.removeKdigits("10", 2));      // Output: "0"
        // System.out.println(solution.removeKdigits("9", 1));       // Output: "0"
    }
   

}
