import java.util.LinkedList;
import java.util.Queue;

class Q4StackUsingQ {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public Q4StackUsingQ() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        if(!empty()){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
        }
        int topEle = q1.poll();
        Queue<Integer> temp =  q1;
        q1=q2;
        q2=temp;
        return topEle; 
    }
    
    public int top() {
        if(!empty()){
            while(q1.size()>1){
                q2.add(q1.poll());
            }
        }
        int topEle = q1.peek();
        q2.add(q1.poll());
        Queue<Integer> temp =  q1;
        q1=q2;
        q2=temp;
        return topEle; 
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
