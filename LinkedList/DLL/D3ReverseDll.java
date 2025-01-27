public class D3ReverseDll {
    // Definition for a doubly linked list node
    static class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        DLLNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DLLNode reverseDLL(DLLNode head) {
        DLLNode prev = null, curr = head, temp;
        while (curr != null) {
            temp = curr.next; // Store the next node
            curr.next = prev; // Reverse the next pointer
            curr.prev = temp; // Reverse the prev pointer
            prev = curr;      // Move prev to the current node
            curr = temp;      // Move to the next node
        }
        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        D3ReverseDll list = new D3ReverseDll();

        // Create an example DLL: 1 <-> 2 <-> 3 <-> 4
        DLLNode head = new DLLNode(1);
        DLLNode second = new DLLNode(2);
        DLLNode third = new DLLNode(3);
        DLLNode fourth = new DLLNode(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        // Print the original list
        System.out.println("Original DLL:");
        printDLL(head);

        // Reverse the DLL
        DLLNode reversedHead = list.reverseDLL(head);

        // Print the reversed list
        System.out.println("Reversed DLL:");
        printDLL(reversedHead);
    }

    // Utility function to print the doubly linked list
    public static void printDLL(DLLNode head) {
        DLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
