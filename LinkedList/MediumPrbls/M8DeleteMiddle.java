public class M8DeleteMiddle {
    
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }
        int res = n / 2;
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // CHAKRI'S APPROACH (OPTIMAL)
    // public ListNode deleteMiddle(ListNode head) {
    //     if(head==null || head.next==null) return null;
    //     ListNode slow=head,fast=head,slowPrev=null;
    //     while(fast!=null && fast.next!=null){
    //         slowPrev=slow;
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }       
    //     slowPrev.next=slow.next;
    //     return head;
    // }


    // OPTIMAL
    // public ListNode deleteMiddle(ListNode head) {
    //     if(head==null || head.next==null) return null;
    //     ListNode slow=head,fast=head;
    //     fast=head.next.next;
    //     while(fast!=null && fast.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }       
    //      if (slow.next != null) {
    //         slow.next = slow.next.next;
    //     }
    //     return head;
    // }
}
