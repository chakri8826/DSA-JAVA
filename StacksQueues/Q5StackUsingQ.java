import java.util.Queue;
import java.util.LinkedList;

class Q5StackUsingQ{
    Queue<Integer> q1;

    public Q5StackUsingQ() {
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        int size = q1.size();
        q1.add(x);  // Add new element
        
        // Rotate queue to make the new element the front
        for (int i = 0; i < size; i++) {
            q1.add(q1.poll());
        }
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.poll(); // Directly remove the front element (LIFO order)
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek(); // Front element is always the top element
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        Q5StackUsingQ stack = new Q5StackUsingQ();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top());  // 30
        System.out.println(stack.pop());  // 30
        System.out.println(stack.top());  // 20
    }
}
