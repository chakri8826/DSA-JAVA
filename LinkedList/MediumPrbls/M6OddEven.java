public class M6OddEven {
    //CHAKRI'S TRY
    // public ListNode oddEvenList(ListNode head) {
    //     ListNode dummy = new ListNode(0),dummyev=new ListNode(0),curr=head;
    //     ListNode od=dummy,ev=dummyev;
    //     int ind=1;
    //     while(curr!=null){
    //         if(ind%2!=0){
    //             od.next=new ListNode(curr.val);
    //             od=od.next;
    //         }
    //         else{
    //             ev.next=new ListNode(curr.val);
    //             ev=ev.next;
    //         }
    //         curr=curr.next;
    //         ind++;
    //     }
    
    //     od.next=dummyev.next;
    //     return dummy.next;
    // }

    //OPTIMAL
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd=head,even=head.next,evenHead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
