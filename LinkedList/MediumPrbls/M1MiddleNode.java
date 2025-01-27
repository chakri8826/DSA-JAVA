class M1MiddleNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    // BRUTE FORCE
    // public ListNode middleNode(ListNode head) {
    //     int cnt = 0;
    //     ListNode temp = head;
    //     // Count the number of nodes in the list
    //     while (temp != null) {
    //         cnt++;
    //         temp = temp.next;
    //     }
    //     int req = cnt / 2; // Calculate the middle index
    //     cnt = 0;
    //     temp = head;
    //     // Traverse to the middle node
    //     while (cnt < req) {
    //         temp = temp.next;
    //         cnt++;
    //     }
    //     return temp; // Return the middle node
    // }

    // OPTIMAL (CHAKRI TRY)
    // public ListNode middleNode(ListNode head) {
    //     ListNode slow = head, fast = head;
    //     // Loop to move slow and fast pointers
    //     while (true) {
    //         if (fast.next == null || fast.next.next == null) {
    //             break; // End of the list reached
    //         }
    //         else {
    //             fast = fast.next.next;
    //         }
    //         slow = slow.next;
    //     }
    //     if (fast.next != null) {
    //         slow = slow.next;
    //     }
    //     // No need for extra adjustment of slow
    //     return slow;
    // }


    // OPTIMAL APPROACH
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        // Move slow one step and fast two steps until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // Slow is now at the middle node
    }

    // Example to test the code
    public static void main(String[] args) {
        M1MiddleNode solution = new M1MiddleNode();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle node
        ListNode middle = solution.middleNode(head);
        System.out.println("Middle Node Value: " + middle.val); // Expected output: 3

        // Create another sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Find the middle node
        middle = solution.middleNode(head);
        System.out.println("Middle Node Value: " + middle.val); // Expected output: 4
    }
}
