import org.w3c.dom.Node;

public class D1DeleteNode {
        Node addNode(Node head, int p, int x) {
        int c=0;
        Node temp = head;
        while(c<p){
            temp=temp.next;
            c++;
        }
        Node newNode = new Node(x);
        
        //LAST-NODE
        if(temp.next==null){
            temp.next=newNode;
            newNode.prev=temp;
        }
        else{
            newNode.next=temp.next;
            newNode.next.prev=newNode;
            newNode.prev=temp;
            temp.next=newNode;
        }
        return head;
    }
}
