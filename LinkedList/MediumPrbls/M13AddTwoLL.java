public class M13AddTwoLL {
    // CHANING THE INPUT DATA (SC=>O(1))  TC-> O(max(n, m))
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     ListNode t1 = l1,t2 = l2;
    //     ListNode dummy = new ListNode(-1);
    //     ListNode temp=dummy;
    //     int carry=0;

    //     while(t1!=null || t2!=null){
    //         int val = carry;
    //         if(t1!=null) val+=t1.val;
    //         if(t2!=null) val+=t2.val;
    //         // x%10 gives the remainder as sum
    //         if(t1!=null){
    //             t1.val=val%10;
    //             temp.next=t1;
    //             temp=temp.next;
    //         }
    //         else{
    //             t2.val=val%10;
    //             temp.next=t2;
    //             temp=temp.next;
    //         }
    //         // x/10 gives the quotient as carry
    //         carry=val/10;
    //         if(t1!=null) t1=t1.next;
    //         if(t2!=null) t2=t2.next;
    //     }

    //     if(carry==1){
    //         ListNode nn = new ListNode(1);
    //         temp.next=nn;
    //         temp=temp.next;
    //     }
    //     return dummy.next;
    // }


    // WE ARE NOT CHANGING INPUT DATA HERE,  SC=>O(max(n, m))  TC-> O(max(n, m))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1,t2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(t1!=null || t2!=null){
            int val = carry;
            if(t1!=null) val+=t1.val;
            if(t2!=null) val+=t2.val;
            // x%10 gives the remainder as sum
            ListNode nn = new ListNode(val%10);
            temp.next=nn;
            temp=temp.next;
            // x/10 gives the quotient as carry
            carry=val/10;
            if(t1!=null) t1=t1.next;
            if(t2!=null) t2=t2.next;
        }
        if(carry==1){
            ListNode nn = new ListNode(1);
            temp.next=nn;
            temp=temp.next;
        }
        return dummy.next;
    }
}
