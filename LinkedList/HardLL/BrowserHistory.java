class BrowserHistory {
    public class ListNode{
        String val;
        ListNode next;
        ListNode prev;
        ListNode(String val) {
            this.val = val;
            this.next = null;
            this.prev=null;
        }
    }
    ListNode curr;
    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage); 
    }
    
    public void visit(String url) {
        curr.next=new ListNode(url);
        curr.next.prev=curr;
        curr=curr.next;
        curr.next=null;
    }
    
    public String back(int steps) {
        while(steps!=0){
            if(curr.prev==null){
                return curr.val;
            }
            curr=curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while(steps!=0){
            if(curr.next==null){
                return curr.val;
            }
            curr=curr.next;
            steps--;
        }
        return curr.val;
    }
}
