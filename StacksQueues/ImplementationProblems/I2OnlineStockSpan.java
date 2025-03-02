import java.util.Stack;

public class I2OnlineStockSpan {
    // BRUTE FORCE
//     ArrayList<Integer> li;
//    public I2OnlineStockSpan() {
//         li = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         li.add(price);
//         int cnt=1;
//         for(int i=li.size()-2;i>=0;i--){
//             if(li.get(i)<=price) cnt++;
//             else break;
//         }
//         return cnt;
//     }


    // OPTIMIZED
    Stack<int[]> st;
    int ind;
    public I2OnlineStockSpan() {
        ind=-1;
        st=new Stack<>();
    }
    
    // WE CAN DO BY PLACING COUNT ALSO (MORE INTUITIVE)
    public int next(int price) {
        int cnt=1;
        while(!st.isEmpty() && st.peek()[0]<=price){
            cnt+=st.pop()[1];
        }
        st.push(new int[]{price,cnt});
        return cnt;
    }


    // WE CAN DO BY PLACING INDEX ALSO
    // public int next(int price) {
    //     int cnt;
    //     ind=ind+1;
    //     while(!st.isEmpty() && st.peek()[0]<=price){
    //         st.pop();
    //     }
    //     cnt=ind-(st.isEmpty()?-1:st.peek()[1]);
    //     st.push(new int[]{price,ind});
    //     return cnt;
    // }
    public static void main(String[] args) {
        I2OnlineStockSpan obj = new I2OnlineStockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
