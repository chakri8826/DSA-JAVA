public class M7DelFromEnd {
     //BRUTE FORCE
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if(head==null || head.next==null) return null;
    //     ListNode temp = head;
    //     int len=1;
    //     while(temp.next!=null){
    //         temp=temp.next;
    //         len++;
    //     }
    //     int tarNode = len-n;
    //     if(tarNode==0){
    //         head=head.next;
    //         return head;
    //     }
    //     temp=head;
    //     int cnt=1;
    //     while(cnt<tarNode){
    //         temp=temp.next;
    //         cnt++;
    //     }
    //     temp.next=temp.next.next;
    //     return head;
    // }


    //Optimal
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        ListNode slow=head,fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        if(fast==null) return head.next;
        slow.next=slow.next.next;
        return head;
    }

}
