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
public class M4MaxPathSum {
    public int maxDepth(TreeNode root,int maxPath[]){
        if(root==null) return 0;

        // not thinked to ignore negative paths
        int lh = Math.max(0,maxDepth(root.left,maxPath));
        int rh = Math.max(0,maxDepth(root.right,maxPath));
        maxPath[0] = Math.max(maxPath[0],lh+rh+root.val);

        // returned only max(lh,rh) we should return root.val also as for the parent node to take the max from either l or r;
        return root.val+Math.max(lh,rh);
    }  
    public int maxPathSum(TreeNode root) {
        int maxPath[] = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        maxDepth(root,maxPath);
        return maxPath[0];
    }
    public static void main(String[] args) {
        M4MaxPathSum m4 = new M4MaxPathSum();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(m4.maxPathSum(root)); // Output: 42
    }
}
