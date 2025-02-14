
import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class Main {

    // Function to merge K sorted linked lists
    static Node mergeKLists(ArrayList<Node> listArray) {
        // Priority queue to maintain
        // sorted order based on node values
        // Pairs store node value and pointer to the node
        PriorityQueue<Map.Entry<Integer, Node>> pq = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getKey));

        // Push the heads of all the
        // linked lists into the priority queue
        for (Node node : listArray) {
            // Check if the current linked list exists
            if (node != null) {
                // Push the pair of node data and
                // node pointer into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(node.data, node));
            }
        }

        // Create a dummy node to build the merged list
        Node dummyNode = new Node(-1, null);
        Node temp = dummyNode;

        // Merge the lists present
        // in the priority queue
        while (!pq.isEmpty()) {
            // Get the top element (minimum node value)
            // from the priority queue
            Map.Entry<Integer, Node> it = pq.poll();

            // Check if the current
            // node has a next node
            if (it.getValue().next != null) {
                // Push the next node
                // into the priority queue
                pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.data, it.getValue().next));
            }

            // Set the next pointer of the
            // current node in the merged list
            temp.next = it.getValue();
            temp = temp.next;
        }

        // Return the merged linked list
        return dummyNode.next;
    }

    // Function to print the linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked lists
        Node head1 = new Node(2, new Node(4, new Node(6)));
        Node head2 = new Node(1, new Node(5));
        Node head3 = new Node(1, new Node(1, new Node(3, new Node(7))));
        Node head4 = new Node(8);

        // Populate the lists vector
        ArrayList<Node> lists = new ArrayList<>();
        lists.add(head1);
        lists.add(head2);
        lists.add(head3);
        lists.add(head4);

        System.out.println("Original Linked Lists:");
        for (int i = 0; i < lists.size(); ++i) {
            System.out.print("List " + (i + 1) + ": ");
            printLinkedList(lists.get(i));
        }

        // Merge the linked lists
        Node mergedList = mergeKLists(lists);

        // Print the merged linked list
        System.out.print("Merged Linked List: ");
        printLinkedList(mergedList);
    }
}

