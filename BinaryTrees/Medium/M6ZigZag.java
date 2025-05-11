import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class M6ZigZag {
      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        boolean ltr = true;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int levSize = q.size();
            while(levSize!=0){
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                li.add(q.poll().val);
                levSize--;
            }
            if(!ltr){
                Collections.reverse(li);
            }
            ans.add(li);
            ltr = !ltr;    
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

        M6ZigZag m6ZigZag = new M6ZigZag();
        List<List<Integer>> result = m6ZigZag.zigzagLevelOrder(root);
        System.out.println(result); // Output: [[1], [3, 2], [4, 5]]
    }
}
