import java.util.PriorityQueue;

public class H5MERGEKLISTS {
      // public ListNode mergeKLists(ListNode[] lists) {
    //     ArrayList<Integer> li = new ArrayList<>();
    //     if(lists.length==0 || lists==null) return null;
    //     for(int i=0;i<lists.length;i++){
    //         ListNode head = lists[i];
    //         while(head!=null){
    //             li.add(head.val);
    //             head=head.next;
    //         }
    //     }
    //     if (li.isEmpty()) return null; 
    //     Collections.sort(li);
    //     ListNode head=new ListNode(li.get(0));
    //     ListNode temp=head;
    //     for(int i=1;i<li.size();i++){
    //         temp.next=new ListNode(li.get(i));
    //         temp=temp.next;
    //     }
    //     return head;
    // }




    // public ListNode merge(ListNode l1,ListNode l2){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode res = dummy;
    //     while(l1!=null && l2!=null){
    //         if(l1.val<l2.val){
    //             res.next=l1;
    //             l1=l1.next;
    //         }
    //         else{
    //             res.next=l2;
    //             l2=l2.next;
    //         }
    //         res=res.next;
    //     }
    //     if(l1!=null) res.next=l1;
    //     else res.next=l2;
    //     return dummy.next;
    // }
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length==0 || lists==null) return null;
    //     ListNode head = lists[0];
    //     for(int i=1;i<lists.length;i++){
    //         ListNode l1 = lists[i];
    //         head=merge(l1,head);
    //     }
    //     return head;
    // }




    public ListNode mergeKLists(ListNode[] lists) {
        // Priority queue to maintain sorted order based on node values
        
        //USING COMPARATOR 
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
        //     public int compare(ListNode n1,ListNode n2){
        //         // return n1.val-n2.val;
        //         return Integer.compare(n1.val,n2.val);
        //     }
        // });


        // USING comparingInt() method
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        

        // LAMBDA EXPRESSIONS
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val-n2.val);

        for (ListNode node : lists) {
            // THE LIST MAY CONTAIN A NULL LIST SO CHECK IT
            if (node != null) {
                pq.add(node); 
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        
        while (!pq.isEmpty()) {             
            ListNode minNode = pq.poll();
            temp.next = minNode;
            temp = temp.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummyNode.next;
    }
}
