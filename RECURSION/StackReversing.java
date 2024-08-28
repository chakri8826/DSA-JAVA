import java.util.Stack;
import java.util.ArrayDeque;

public class StackReversing {
	//MAIN SOL
	static void insert_at_bottom(Stack<Integer> s, int x){
        // if stack is empty, add the element at the bottom
        if(s.size()==0){
            s.push(x);
        }
        else{
            // store the top element of the stack
            int y= s.peek();
            // remove the top element
            s.pop();
            // recursively insert the element at the bottom
            insert_at_bottom(s, x);
            // add the stored element back to the stack
            s.add(y);
        }
    }
    static void fun(Stack<Integer> s){
        // if stack is not empty
        if(s.size()>0){
            // store the top element of the stack
            int x=s.peek();
            // remove the top element
            s.pop();
            // recursively reverse the remaining elements in the stack
            fun(s);
            // insert the stored element at the bottom of the reversed stack
            insert_at_bottom(s, x);
        }
    }
    static void Reverse(Stack<Integer> s)
    {
        // reverse the given stack
        fun(s);
    }
    
    
    // CHAKRI SOL
    static ArrayDeque<Integer> h = new ArrayDeque<>();
    static void getBack(Stack<Integer> s){
            while (!h.isEmpty()) {
            s.push(h.pop());
        }
    }

    static void reverse(Stack<Integer> s) {     
        if (s.isEmpty()) {
            return;
        }
        h.addLast(s.pop());
        reverse(s);
        getBack(s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);
        // Reverse(s);
        System.out.println("Stack after reversing: " + s);
    }
}
