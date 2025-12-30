import org.w3c.dom.Node;

public class H3FlattenLL {
    // MERGING
    // public Node merge(Node list1, Node list2){
    //     if(list1==null)return list2;
    //     if(list2==null)return list1;
        
    //     Node res = new Node(-1);
    //     Node head = res;
        
    //     while(list1!=null && list2!=null){
    //         if(list1.data<list2.data){
    //             res.bottom = list1;
    //             list1 = list1.bottom;
    //         }
    //         else{
    //             res.bottom = list2;
    //             list2 = list2.bottom;
    //         }
    //         res = res.bottom;
    //     }
    //     if(list1==null) res.bottom = list2;
    //     else res.bottom = list1;
    //     return head.bottom;
    // }
    
    // public Node flatten(Node root) {
    //     if(root==null || root.next==null)return root;
    //     root.next = flatten(root.next);
    //     root =  merge(root,root.next);
    //     return root;
    // }



     public Node merge(Node l1,Node l2){
        Node dummy = new Node(-1);
        Node res = dummy;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                res.bottom=l1;
                res=l1;
                l1=l1.bottom;
            }
            else{
                res.bottom=l2;
                res=l2;
                l2=l2.bottom;
            }
            res.next=null;
        }
        if(l1!=null) res.bottom=l1;
        else res.bottom=l2;
        return dummy.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
         if(root==null || root.next==null)return root;
         Node res = flatten(root.next);
         return merge(root,res);
    }    
}
