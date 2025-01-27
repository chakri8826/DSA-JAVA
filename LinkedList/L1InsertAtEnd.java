public class L1InsertAtEnd {
    // Definition of a Node
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Function to insert a node at the end of the linked list
    Node insertAtEnd(Node head, int x) {
        Node newnode = new Node(x);
        if (head == null) { // If the list is empty, the new node becomes the head
            return newnode;
        }
        Node temp = head;
        while (temp.next != null) { // Traverse to the end of the list
            temp = temp.next;
        }
        temp.next = newnode; // Attach the new node at the end
        return head;
    }

    //COUNTING
    public int getCount(Node head) {
        Node temp = head;
        int cnt=0;
        while (temp != null) {
            temp = temp.next;
            cnt++;             
        }
        return cnt;
    }

    // Function to print the linked list
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        L1InsertAtEnd list = new L1InsertAtEnd();

        Node head = null; // Start with an empty list

        // Insert nodes into the list
        head = list.insertAtEnd(head, 10);
        head = list.insertAtEnd(head, 20);
        head = list.insertAtEnd(head, 30);
        head = list.insertAtEnd(head, 40);

        // Print the linked list
        System.out.print("Linked List: ");
        list.printList(head); // Expected Output: 10 -> 20 -> 30 -> 40 -> null
    }
}
