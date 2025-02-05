public class D1_DelAllOcc {
    // chakri's approach
    // static Node deleteAllOccurOfX(Node head, int x) {
    //     Node temp = head;
    //     while (temp != null) {
    //         if (temp.data == x) {
    //             if (temp == head) { // Deleting head
    //                 head = head.next;
    //                 if (head != null) {
    //                     head.prev = null;
    //                 }
    //                 temp = head; // Move temp to new head
    //             } else {
    //                 Node nextNode = temp.next; // Store next before deletion
    //                 temp.prev.next = temp.next;
    //                 if (temp.next != null) {
    //                     temp.next.prev = temp.prev;
    //                 }
    //                 temp = nextNode; // Move temp to next node
    //             }
    //         } else {
    //             temp = temp.next; // Move forward only if no deletion
    //         }
    //     }
    //     return head;
    // }
    
    
    
    // static Node deleteAllOccurOfX(Node head, int x) {
    //     Node temp = head;
    //     while (temp != null) {
    //         if (temp.data == x) {
    //             if (temp == head) { // Deleting head
    //                 head = head.next;
    //             }
    //             Node nn = temp.next;
    //             Node pn = temp.prev;
    //             if(nn!=null) nn.prev = pn;
    //             if(pn!=null) pn.next = nn;
    //             temp=nn;
    //         } else {
    //             temp = temp.next; // Move forward only if no deletion
    //         }
    //     }
    //     return head;
    // }
    
}
