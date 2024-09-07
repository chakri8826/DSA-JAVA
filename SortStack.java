import java.util.*;
public class SortStack {
    public static void  insertBottom(int topEl,Stack<Integer> s){
        if(s.isEmpty()){
            s.add(topEl);
            return;
        }
        // if(topEl>=s.peek()){
        //     s.add(topEl);
        //     return;
        // }
        int temp=s.pop();
        insertBottom(topEl, s);
        s.push(temp);
    }
    public static Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()){
            return s;
        }
        int topEl = s.pop();
        sort(s);
        insertBottom(topEl,s);
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(3);
        s.add(2);
        s.add(1);
        s.add(7);
        s.add(6);
        System.out.println(sort(s));
    }
}
