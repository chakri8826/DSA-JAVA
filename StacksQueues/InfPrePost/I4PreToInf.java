import java.util.Stack;

public class I4PreToInf {
    static String preToInfix(String pre_exp) {
        Stack<String> st = new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char c = pre_exp.charAt(i);
            if((c>=65 && c<=90) || (c>=97 && c<=122)){
                st.push(Character.toString(c));
            }
            else{
                String a = st.pop();
                String b = st.pop();
                String r = Character.toString(c);
                String con = "("+ a+r+b+")"  ;
                st.push(con);
            }
        }
        return st.pop();
    }
}
