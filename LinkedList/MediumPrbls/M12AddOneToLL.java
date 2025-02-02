public class M12AddOneToLL {
    // BRUTE - FORCE
    // public Node reverse(Node head){
    //     Node temp=head,curr=head,pre=null;
    //     while(temp!=null){
    //         temp=temp.next;
    //         curr.next=pre;
    //         pre=curr;
    //         curr=temp;
    //     }
    //     return pre;
    // }
    
    // public Node addOne(Node head) {
    //     head = reverse(head);
    //     Node temp = head;
    //     int carry=1;
    //     while(temp!=null){
    //         temp.data=temp.data+carry;
    //         if(temp.data<10){
    //             carry=0;
    //             break;
    //         }
    //         else{
    //             temp.data=0;
    //             carry=1;
    //         }
    //         temp=temp.next;
    //     }
    //     head=reverse(head);
    //     if(carry==1){
    //         Node nn = new Node(1);
    //         nn.next=head;
    //         return nn;
    //     }
    //     return head;
    // }
    
    
    
    // OPTIMAL
    public int helper(Node head){
        if(head==null)return 1;
        int carry=helper(head.next);
        head.data = head.data+carry;
        if(head.data<10)return 0;
        else {
            head.data=0;
            return 1;
        }
    }
    public Node addOne(Node head) {
        int carry = helper(head);
        if(carry==1){
            Node nn = new Node(1);
            nn.next=head;
            return nn;
        }
        return head;
    }
}
