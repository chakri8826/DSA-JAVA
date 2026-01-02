public class H4CloneLL {
    // public Node copyRandomList(Node head) {
    //     Node old=head;
    //     HashMap<Node,Node> map = new HashMap<>();
    //     while(old!=null){
    //         map.put(old,new Node(old.val));
    //         old=old.next;
    //     }
    //     old=head;
    //     while(old!=null){
    //         Node copy = map.get(old);
    //         copy.next=map.get(old.next);
    //         copy.random=map.get(old.random);
    //         old=old.next;
    //     }
    //     return map.get(head);
    // }




















    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;
        while(temp!=null){
            Node cNode = new Node(temp.val);
            cNode.next = temp.next;
            temp.next = cNode;
            temp = temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
