public class M4LenOfCycle {
    //BRUTE FORCE 
    // public int countNodesinLoop(Node head) {
    //     HashMap<Node,Integer> map = new HashMap<>();
    //     Node temp = head;
    //     int curr=1;
    //     while(temp!=null){
    //         if(map.containsKey(temp)){
    //             int res = curr-map.get(temp);
    //             return res;
    //         }
    //         else{
    //             map.put(temp,curr);
    //         }
    //         curr++;
    //         temp=temp.next;
    //     }
    //     return 0;
    // }
    
    
    // OPTIMAL
    public int countNodesinLoop(Node head) {
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int cnt=1;
                while(slow.next!=fast){
                    cnt++;
                    slow=slow.next;
                }
                return cnt;
            }
        }
        return 0; 
    }
}
