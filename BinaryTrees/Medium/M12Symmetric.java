public class M12Symmetric {
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return p.val==q.val && isSameTree(p.left,q.right) && isSameTree(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSameTree(root.left,root.right);
    }
}
