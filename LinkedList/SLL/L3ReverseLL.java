// Definition for a singly linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class L3ReverseLL {
    public static Node reverseLinkedList(Node head) {
        Node prev = null, curr = head, temp;
        while (curr != null) {
            temp = curr.next; // Store the next node
            curr.next = prev; // Reverse the link
            prev = curr;      // Move prev to current node
            curr = temp;      // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        // Create an example Linked List: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Print the original list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Reverse the Linked List
        Node reversedHead = reverseLinkedList(head);

        // Print the reversed list
        System.out.println("Reversed Linked List:");
        printLinkedList(reversedHead);
    }

    // Utility function to print the linked list
    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
