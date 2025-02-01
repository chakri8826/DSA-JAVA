public class M10SortLL {
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        temp.next=(left!=null) ? left:right;

        // if(left!=null) temp.next=left;
        // else temp.next=right;
        return dummy.next;
    }
    public ListNode findMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
 
    public ListNode sortList(ListNode head) {
       if(head==null || head.next==null) return head;
        ListNode mid = findMid(head);
        ListNode lh=head,rh=mid.next;
        mid.next=null;
        lh = sortList(lh);
        rh =sortList(rh);

        return merge(lh,rh);
    }                           
            
}
