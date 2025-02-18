import java.util.Stack;

public class I5PostToPre {
    static String postToPre(String post_exp) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char c = post_exp.charAt(i);
            if((c>=97 && c<=122) || (c>=65 && c<=90)){
                // Character.toString(ch).
                st.push(String.valueOf(c));
            }
            else{
                String b = st.pop();
                String a = st.pop();
                String con = Character.toString(c)+a+b;
                st.push(con);
            }
        }
        return st.pop();
    }
}


