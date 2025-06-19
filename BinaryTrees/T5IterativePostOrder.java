import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
class T5IterativePostOrder {
    // Using 2 stacks
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> li = new ArrayList<>();
    //     if(root==null)return li;
    //     Stack<TreeNode> st1 = new Stack<>();
    //     Stack<TreeNode> st2 = new Stack<>();
    //     st1.push(root);
    //     while(!st1.isEmpty()){
    //         TreeNode top = st1.pop();
    //         st2.push(top);
    //         if(top.left!=null) st1.push(top.left);
    //         if(top.right!=null) st1.push(top.right);
    //     }
        
    //     while(!st2.isEmpty()){
    //         li.add(st2.pop().val);
    //     }
    //     return li;
    // }

    // Using 1 stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        if(root==null)return li;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            } 
            else{
                TreeNode temp = st.peek().right;
                if(temp==null){
                    temp=st.pop();
                    li.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop();
                        li.add(temp.val);
                    }
                }
                else{
                    curr=temp;
                }
            }
        }
        return li;
        
    } 
    

}
