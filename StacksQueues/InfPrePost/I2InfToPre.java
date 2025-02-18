import java.util.Stack;

public class I2InfToPre {
    public static int prec(char c) {
        switch (c) {
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

    public static String reverse(char ch[], int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

    public static String infixToPrefix(String s) {
        // Reverse the input expression
        s = reverse(s.toCharArray(), 0, s.length() - 1);

        String res = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                res += ch;
            } 
            else if (ch == ')') {
                st.push(ch);
            } 
            else if (ch == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    res += st.pop();
                }
                st.pop(); // Remove ")"
            } 
            else {
                // if (ch == '^') {
                //     while (!st.isEmpty() && prec(ch) <= prec(st.peek())) {
                //         res += st.pop();
                //     }
                // } else {
                //     while (!st.isEmpty() && prec(ch) < prec(st.peek())) {
                //         res += st.pop();
                //     }
                // }

                
                while (!st.isEmpty() &&( (prec(ch) < prec(st.peek()))   || ((prec(ch) <= prec(st.peek())) && (ch=='^')) ) ) {
                    res += st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(') return "Invalid Expression";
            res += st.pop();
        }

        // Reverse final result
        res = reverse(res.toCharArray(), 0, res.length() - 1);
        return res;
    }

    public static void main(String[] args) {
        String infix = "(A+B)*(C-D)";
        String prefix = infixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}
