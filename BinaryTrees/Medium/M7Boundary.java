import java.util.ArrayList;
import java.util.Stack;
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
public class M7Boundary {
       public boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    
    public void addLeftBoundary(Node node,ArrayList<Integer> ans){
        Node curr = node.left;
        while(curr!=null){
            if(isLeaf(curr)==false) ans.add(curr.data);
            if(curr.left!=null)curr=curr.left;
            else curr=curr.right;
        }
    }
    
    public void addLeafs(Node node,ArrayList<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null) addLeafs(node.left,ans);
        if(node.right!=null) addLeafs(node.right,ans);
    } 
    
    public void addRightBoundary(Node node,ArrayList<Integer> ans){
        Node curr = node.right;
        Stack<Integer> st = new Stack<>();
        while(curr!=null){
            if(isLeaf(curr)==false) st.push(curr.data);
            if(curr.right!=null)curr=curr.right;
            else curr=curr.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
    } 
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(node)==false) ans.add(node.data);
        addLeftBoundary(node,ans);
        addLeafs(node,ans);
        addRightBoundary(node,ans);
        
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        M7Boundary m7Boundary = new M7Boundary();
        ArrayList<Integer> result = m7Boundary.boundaryTraversal(root);
        System.out.println(result); // Output: [1, 2, 4, 5, 6, 7, 3]
    }
}
