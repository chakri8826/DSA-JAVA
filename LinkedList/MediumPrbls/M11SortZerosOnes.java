class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
public class M11SortZerosOnes {
     // Function to sort a linked list of 0s, 1s and 2s.
    // static Node segregate(Node head) {
    //     Node temp=head;
    //     ArrayList<Integer> li = new ArrayList<>();
    //     while(temp!=null){
    //         li.add(temp.data);
    //         temp=temp.next;
    //     }
    //     Collections.sort(li);
    //     temp=head;
    //     int ind=0;
    //     while(temp!=null){
    //         temp.data=li.get(ind);
    //         temp=temp.next;
    //         ind++;
    //     }
    //     return head;
    // }
    
    static Node segregate(Node head) {
        Node dummy = new Node(-1);
        Node dummy2 = new Node(-1);
        Node dummy3 = new Node(-1);
        Node zero = dummy,one=dummy2,two=dummy3,temp=head;
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }
            else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=dummy2.next!=null?dummy2.next:dummy3.next;
        one.next=dummy3.next;
        two.next=null;
        return dummy.next;
    }
}
