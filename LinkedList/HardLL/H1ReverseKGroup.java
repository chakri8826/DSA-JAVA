class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class H1ReverseKGroup{
    // TRY
    // public ListNode reverse(ListNode head){
    //     ListNode prev=null,curr=head,temp=head;
    //     while(temp!=null){
    //         temp=temp.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=temp;
    //     }
    //     return prev;
    // }
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode temp=head,pp=null;
    //     while(temp!=null){
    //         ListNode lh = temp;
    //         ListNode ptr = temp;
    //         int cnt=1;
    //         while(cnt<k){
    //             if(ptr.next==null){
    //                 pp.next=temp;
    //                 return head;
    //             }
    //             ptr=ptr.next;
    //             cnt++;
    //         }
    //         temp=ptr.next;
    //         ptr.next=null;
    //         ListNode nh = reverse(lh);
    //         if(head==lh){
    //             head=nh;
    //         }
    //         if(pp!=null){
    //             pp.next=nh;
    //         }
    //         pp=lh;
    //     }
    //     return head;
    // }


    // PERFECT(NAMES AND CLEAN-CODE)
    public ListNode reverse(ListNode head){
        ListNode previous = null, current = head, nextNode = head;
        while(nextNode != null){
            nextNode = nextNode.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
    
    public ListNode findKthNode(ListNode head, int k){
        int count = 1;
        ListNode pointer = head;
        while(pointer != null && count < k){
            pointer = pointer.next;
            count++;
        }
        return pointer;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevGroupEnd = null;
        while(temp != null){
            ListNode groupStart = temp;
            ListNode groupEnd = findKthNode(temp, k);
            if(groupEnd == null){
                prevGroupEnd.next = temp;
                return head;
            }
            temp = groupEnd.next;
            groupEnd.next = null;
            ListNode newHead = reverse(groupStart);
            if(head == groupStart){
                head = newHead;
            }
            if(prevGroupEnd != null){
                prevGroupEnd.next = newHead;
            }
            prevGroupEnd = groupStart;
        }
        return head;
    }
}