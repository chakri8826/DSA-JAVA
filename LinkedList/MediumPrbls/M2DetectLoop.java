class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class M2DetectLoop {
    // public boolean hasCycle(ListNode head) {
    //     HashSet<ListNode> set = new HashSet<>();
    //     ListNode temp = head;
    //     while(temp!=null){
    //         if(set.contains(temp)){
    //             return true;
    //         }
    //         set.add(temp);
    //         temp=temp.next;
    //     }
    //     return false;
    // }

    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }
}


