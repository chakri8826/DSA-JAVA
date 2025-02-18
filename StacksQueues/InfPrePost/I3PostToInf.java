import java.util.Stack;

public class I3PostToInf {
    static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if((c>=97 && c<=122) || (c>=65 && c<=90)){
                // Character.toString(ch).
                st.push(String.valueOf(c));
            }
            else{
                String b = st.pop();
                String a = st.pop();
                String r = Character.toString(c);
                String con = "("+a+r+b+")";
                st.push(con);
            }
        }
        return st.pop();
    }
}
