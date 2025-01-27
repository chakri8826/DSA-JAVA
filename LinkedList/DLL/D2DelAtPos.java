package DLL;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class D2DelAtPos {
    
    // Method to delete a node at a specific position
    // public Node deleteNode(Node head, int x) {
    //     if (head == null || x <= 0) {
    //         return head; // Invalid position or empty list
    //     }

    //     Node prev = null, curr = head;
    //     int c = 1;

    //     // Traverse to the position x
    //     while (c < x && curr != null) {
    //         prev = curr;
    //         curr = curr.next;
    //         c++;
    //     }

    //     if (curr == null) {
    //         return head; // Position out of bounds
    //     }

    //     // Handle deletion
    //     if (prev == null) { // Deleting the head node
    //         head = head.next;
    //         if (head != null) {
    //             head.prev = null;
    //         }
    //     } else if (curr.next == null) { // Deleting the tail node
    //         prev.next = null;
    //     } else { // Deleting a middle node
    //         curr.next.prev = curr.prev;
    //         prev.next = curr.next;
    //     }

    //     return head;
    // }

    //MY IMPLEMENTATION
    public Node deleteNode(Node head, int x) {
        Node prev=null,curr=head;
        int c=1;
        while(c<x){
            prev=curr;
            curr=curr.next;
            c++;
        }
        if(prev==null){
            head=head.next;
            head.prev=null;
        }
        else if(curr.next==null){
            curr.prev=null;
            prev.next=null;
        }
        else{
            curr.next.prev= curr.prev;
            curr.prev.next=curr.next;
        }
        return head;
    }

    // Helper method to print the Doubly Linked List
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        D2DelAtPos dll = new D2DelAtPos();

        // Create nodes
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        // Link nodes to form the DLL: 1 <-> 2 <-> 3 <-> 4
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.println("Original list:");
        dll.printList(head);

        // Delete node at position 2
        head = dll.deleteNode(head, 2);
        System.out.println("After deleting at position 2:");
        dll.printList(head);

        // Delete node at position 1 (head)
        head = dll.deleteNode(head, 1);
        System.out.println("After deleting at position 1:");
        dll.printList(head);

        // Delete node at position 2 (tail)
        head = dll.deleteNode(head, 2);
        System.out.println("After deleting at position 2:");
        dll.printList(head);
    }
}

