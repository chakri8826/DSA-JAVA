import java.util.LinkedList;
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
class M1Depth {
    // USING RECURSION
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // USING LEVEL ORDER TRAVERSAL
    // public int maxDepth(TreeNode root) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     if(root==null)return 0;
    //     q.add(root);
    //     int depth=0;
    //     while(!q.isEmpty()){
    //         int levSize = q.size();
    //         while(levSize!=0){
    //             if(q.peek().left!=null) q.offer(q.peek().left);
    //             if(q.peek().right!=null) q.offer(q.peek().right);
    //             q.poll();
    //             levSize--;
    //         }
    //         depth++;
    //     }
    //     return depth;
    // }   

    public static void main(String[] args) {
        M1Depth m1Depth = new M1Depth();
        System.out.println(m1Depth.maxDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}