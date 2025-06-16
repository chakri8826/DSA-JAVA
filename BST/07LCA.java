class 07LCA{
    // ITERATIVE
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if (p.val < root.val && q.val < root.val)root=root.left;
            else if (p.val > root.val && q.val > root.val)root=root.right;
            else return root;
        } 
        return null;
    }

    //RECURSIVE 
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        } 
        else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }
}