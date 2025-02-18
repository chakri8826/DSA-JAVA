import java.util.Stack;

// // BRUTE APPROACH
// public class Q7MinStack {
//     Stack<Integer> st;
//     Stack<Integer> minStack;
//     public Q7MinStack() {
//         st=new Stack<>();
//         minStack=new Stack<>();
//     }
    
//     public void push(int val) {
//         st.push(val);
//         if(minStack.isEmpty() || val<=minStack.peek()){
//             minStack.push(val);
//         }
//     }
    
//     public void pop() {
//         if(st.pop().equals(minStack.peek())){
//             minStack.pop();
//         }
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         // PriorityQueue<Integer> pq = new PriorityQueue<>();
//         // Stack<Integer> temp = new Stack<>();
//         // while(!st.isEmpty()){
//         //     int val=st.pop();
//         //     pq.add(val);
//         //     temp.add(val);
//         // }
//         // while(!temp.isEmpty()){
//         //     st.add(temp.pop());
//         // }
//         // return pq.poll();

//         return minStack.peek();
//     }
// }



// OPTIMAL
class Q7MinStack {
    Stack<Long> st;
    Long mini = Long.MAX_VALUE;
    public Q7MinStack() {
        st = new Stack<Long>();
    }
    
    public void push(int val) {
        Long v = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(v);
            mini=v;
        }
        else if(v<mini){
            st.push(2*v-mini);
            mini=v;
        }
        else{
            st.push(v);
        }
    }
    
    public int pop() {
        if(st.peek()<mini){
            Long val = mini;
            mini = 2*mini-st.pop();
            return val.intValue();
        }
        else{
            return st.pop().intValue();
        }
    }

    public int top() {
        if(st.peek()<mini){
            return mini.intValue();
        }
        else{
            return st.peek().intValue();
        }
    }
    
    public int getMin() {
        return mini.intValue();
    }
}