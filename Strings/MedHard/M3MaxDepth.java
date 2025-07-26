
public class M3MaxDepth {
    // public int maxDepth(String s) {
    //     int cnt=0,res=0;
    //     Stack<Character> st = new Stack<>();
    //     for(char ch:s.toCharArray()){
    //         if(ch=='(')st.push(ch);
    //         else if(ch==')')st.pop();
    //         res = Math.max(st.size(),res);
    //     }
    //     return res;
    // }

    public int maxDepth(String s) {
        int cnt=0,res=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')cnt++;
            else if(ch==')')cnt--;
            res = Math.max(cnt,res);
        }
        return res;
    }
}
