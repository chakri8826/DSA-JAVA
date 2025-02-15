import java.util.Stack;

class Q3 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public Q3() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(int x) {
        s1.add(x);
    }
    // public int pop() {
    //     while(!s1.isEmpty()){
    //         s2.add(s1.pop());
    //     }
    //     int num = s2.pop();
    //     while(!s2.isEmpty()){
    //         s1.add(s2.pop());
    //     }
    //     return num;
    // }
    public int pop(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        return s2.pop();
    }
    
    // public int peek() {
    //     while(!s1.isEmpty()){
    //         s2.add(s1.pop());
    //     }
    //     int num = s2.peek();
    //     while(!s2.isEmpty()){
    //         s1.add(s2.pop());
    //     }
    //     return num;
    // }
    public int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        return s2.peek();
    }

    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}

