public class H2RotateList {
    public ListNode reverse(ListNode head){
        ListNode pre=null,curr=head,temp=head;
        while(temp!=null){
            temp=temp.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        return pre;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int n=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }

        //if k is greater than n, then it returns only reversed list so we do modulo for that
        k=k%n;
        if (k == 0) return head; // in this case we should give the list as it is if we miss this it will return the reversed list
        head=reverse(head);
        int cnt=1;
        ListNode ptr=head;
        while(cnt<k){
            if(ptr.next==null) return head;
            ptr=ptr.next;
            cnt++;
        }
        ListNode nn = ptr.next;
        ptr.next=null;
        head=reverse(head);
        
        ptr=nn;
        ListNode nh = reverse(ptr);
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = nh;
        return head;
    }
}
