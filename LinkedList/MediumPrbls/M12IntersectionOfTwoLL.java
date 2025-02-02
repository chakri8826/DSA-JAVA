public class M12IntersectionOfTwoLL {
    // BETTER
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode la=headA,lb=headB;
    //     HashSet<ListNode> set = new HashSet<>();
    //     while(la!=null){
    //         set.add(la);
    //         la=la.next;
    //     }
    //     while(lb!=null){
    //         if(set.contains(lb)) return lb;
    //         lb=lb.next;
    //     }
    //     return null;
    // }


    // OPTIMAL
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa!=null || pb!=null){
            if(pa==pb) return pa;
            if(pa==null){
                pa=headB;
                continue;
            }
            if(pb==null){
                pb=headA;
                continue;
            }
            pa=pa.next;
            pb=pb.next;
        }
        return null;
    
    }

}
