public class D3_RemoveDups {
    Node removeDuplicates(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node j = head;
        Node i = head.next;
        while(i!=null){
            if(j.data!=i.data){
                i.prev=j;
                j.next=i;
                j=j.next;
            }
            i=i.next;
        }
        if(j.next!=null){
            j.next.prev=null;
            j.next=null;
        }
        else{
            j.next=null;
        }
        return head;
    }
}
