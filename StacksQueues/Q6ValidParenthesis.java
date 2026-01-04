import java.util.Stack;

public class Q6ValidParenthesis {
    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for(char c:s.toCharArray()){
    //         if(c=='(' || c=='[' || c=='{'){
    //             stack.push(c);
    //         }
    //         else if(!stack.isEmpty() && stack.peek()=='[' && c==']'){
    //             stack.pop();
    //         }
    //         else if(!stack.isEmpty() && stack.peek()=='{' && c=='}'){
    //             stack.pop();
    //         }
    //         else if(!stack.isEmpty() && stack.peek()=='(' && c==')'){
    //             stack.pop();
    //         }
    //         else{
    //             stack.push(c);
    //         }
    //     }
    //     return stack.isEmpty();
    // }



    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else{
                //Empty Stack loki only ],},) velthay they never pair,so false
                if(stack.isEmpty()) return false;
                char top = stack.peek();
                if((top=='[' && c==']') || (top=='{' && c=='}') || (top=='(' && c==')')) stack.pop();
                // Stack Have some symbols but the curr closing symbol doesn't have its opening symbol,so false 
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
