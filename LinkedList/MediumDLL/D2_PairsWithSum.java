import java.util.ArrayList;
class Node{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

public class D2_PairsWithSum {
        // public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
    //     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //     Node temp=head;
    //     HashSet<Integer> set = new HashSet<>();
    //     while(temp!=null){
    //         set.add(temp.data);
    //         if(set.contains(target-temp.data) && target-temp.data!=temp.data){
    //             ArrayList<Integer> li = new ArrayList<>();
    //             li.add(temp.data);
    //             li.add(target-temp.data);
    //             Collections.sort(li);
    //             res.add(li);
    //         }
    //         temp=temp.next;
    //     }
    //      res.sort((a, b) -> {
    //         if (a.get(0).equals(b.get(0))) 
    //             return a.get(1) - b.get(1);
    //         return a.get(0) - b.get(0);
    //     });
    //     return res;
    // }
    
    
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node left=head,right=head;
        while(right.next!=null){
            right=right.next;
        }
        
        while(left!=right && left.data<=right.data){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> li = new ArrayList<>();
                li.add(left.data);
                li.add(right.data);
                res.add(li);
                left=left.next;
                right=right.prev;
            }
            else if(sum<target){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return res;
    }
}
