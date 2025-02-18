import java.util.Stack;

public class I1InfToPost {
    // TC==>O(N)+O(N)[WHILE LOOP INSIDE GOES UPTO N IN OVERALL]      &&         SC==>O(N)+O(N)  [STACK AND STRING]
    public static int prec(char c){
        switch(c){
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        String res = new String("");
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res+=ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res+=st.pop();
                }
                st.pop(); //removes "(", if present
            }
            else{
                // IF incoming char has less/equal precedence with top of stack then pop top from stack
                while(!st.isEmpty() && prec(ch)<=prec(st.peek())){
                    res+=st.pop();
                }   
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            if(st.peek()=='(') return "Invalid Expression";
            res+=st.pop();  
        }
        return res;
    }
}
