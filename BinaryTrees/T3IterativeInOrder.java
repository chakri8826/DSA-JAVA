import java.util.*;
class T3IterativeInOrder {
    // CHAKRI THINKS
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     Stack<TreeNode> st = new Stack<>();
    //     List<Integer> ans = new ArrayList<>();
    //     if(root==null) return ans;
    //     st.push(root);
    //     TreeNode curr = root;
    //     while(!st.isEmpty()){
    //         while(curr!=null){
    //             st.push(curr);
    //             curr=curr.left;
    //         } 
    //         curr=st.pop();
    //         ans.add(curr.val);
    //         curr=curr.right;
    //     }
    //     ans.remove(ans.size()-1);
    //     return ans;
    // }
    
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            } 
            curr=st.pop();
            ans.add(curr.val);
            curr=curr.right;
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        T3IterativeInOrder t3 = new T3IterativeInOrder();
        List<Integer> result = t3.inorderTraversal(root);
        System.out.println(result); // Output: [4, 2, 5, 1, 3]
    }
}
