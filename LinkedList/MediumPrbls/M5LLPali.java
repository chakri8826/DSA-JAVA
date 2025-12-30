class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class M5LLPali {
    // public boolean isPalindrome(ListNode head) {
    // ListNode temp = head;
    // ArrayList<Integer> li = new ArrayList<>();
    // while(temp!=null){
    // li.add(temp.val);
    // temp=temp.next;
    // }
    // int l=0,r=li.size()-1;
    // while(l<r){
    // if(li.get(l)==li.get(r)){
    // l++;
    // r--;
    // }
    // else{
    // return false;
    // }
    // }
    // return true;
    // }

    // BRUTE-FORCE
    // public boolean isPalindrome(ListNode head) {
    // Stack<Integer> st = new Stack<>();
    // ListNode temp = head;
    // while(temp!=null){
    // st.push(temp.val);
    // temp=temp.next;
    // }
    // temp=head;
    // while(temp!=null){
    // if(temp.val!=st.pop()) return false;
    // temp=temp.next;
    // }
    // return true;
    // }

    public ListNode reverse(ListNode head) {
        ListNode temp = head, curr = head, prev = null;
        while (temp != null) {
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = reverse(slow);
        ListNode secondHalf = revHead;
        fast = head;
        boolean isPali = true;
        while (revHead != null) {
            if (fast.val != revHead.val) {
                isPali = false;
                break;
            }
            revHead = revHead.next;
            fast = fast.next;
        }
        reverse(secondHalf);
        return isPali;
    }

    public void traverse(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        M5LLPali obj = new M5LLPali();

        // Creating a palindrome linked list: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        // head.next.next.next.next.next = new ListNode(1);

        // Check if it is a palindrome
        obj.traverse(head);
        System.out.println(obj.isPalindrome(head)); // Output: true
        obj.traverse(head);

        // Creating a non-palindrome linked list: 1 -> 2 -> 3 -> 4 -> 5
        // ListNode head2 = new ListNode(1);
        // head2.next = new ListNode(2);
        // head2.next.next = new ListNode(3);
        // head2.next.next.next = new ListNode(4);
        // head2.next.next.next.next = new ListNode(5);

        // // Check if it is a palindrome
        // System.out.println(obj.isPalindrome(head2)); // Output: false
    }
}
