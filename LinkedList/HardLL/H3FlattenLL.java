import org.w3c.dom.Node;

public class H3FlattenLL {
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
