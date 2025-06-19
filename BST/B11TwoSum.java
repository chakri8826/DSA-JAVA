import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class BSTIterator{
    boolean reverse;
    Stack<TreeNode> st = new Stack<>();
    BSTIterator(TreeNode root,boolean reverse){
        this.reverse=reverse;
        pushAll(root);
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse)root=root.right;
            else root=root.left;
        }
    }
    public int next(){
        TreeNode top = st.pop();
        if(reverse)pushAll(top.left);
        else pushAll(top.right);
        return top.val;
    }
}
 

public class B11TwoSum {
    // BRUTE
    // public boolean findTarget(TreeNode root, int k) {
    //     Stack<TreeNode> st = new Stack<>();
    //     List<Integer> li = new ArrayList<>();
    //     while(root!=null || !st.isEmpty()){
    //         while(root!=null){
    //             st.push(root);
    //             root=root.left;
    //             System.out.println(root.val);
    //         }
    //         root = st.pop();
    //         li.add(root.val);
    //         root=root.right;
    //     }
    //     System.out.println(li);
    //     int le=0,ri=li.size()-1;
    //     while(le<ri){
    //         if(li.get(le)+li.get(ri)<k)le++;
    //         else if(li.get(le)+li.get(ri)>k)ri--;
    //         else return true;
    //     }
    //     return false;
    // }

    // OPTIMIZED
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k)return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
    public static void main(String[] args) {
        // Create a sample BST: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        
        B11TwoSum solution = new B11TwoSum();
        
        // Test cases
        System.out.println("Target 9: " + solution.findTarget(root, 9));  // true (2+7=9)
        // System.out.println("Target 28: " + solution.findTarget(root, 28)); // false
        // System.out.println("Target 6: " + solution.findTarget(root, 6));   // true (2+4=6)
        // System.out.println("Target 10: " + solution.findTarget(root, 10)); // true (3+7=10)
    }
    
    

}
