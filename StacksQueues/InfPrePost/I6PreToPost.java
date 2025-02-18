import java.util.Stack;

public class I6PreToPost {
        static String preToPost(String pre_exp) {
        Stack<String> st = new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char c = pre_exp.charAt(i);
            if(Character.isAlphabetic(c)){
                st.push(Character.toString(c));
            }
            else{
                String a = st.pop();
                String b = st.pop();
                String con = a+b+Character.toString(c);
                st.push(con);
            }
        }
        return st.pop();
    }
}
