import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T4IterativePreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            ans.add(top.val);
            if(top.right!=null)st.push(top.right);
            if(top.left!=null)st.push(top.left);
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

        T4IterativePreOrder t4 = new T4IterativePreOrder();
        List<Integer> result = t4.preorderTraversal(root);
        System.out.println(result); // Output: [1, 2, 4, 5, 3]
    }
}