public class M5Identical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        // if(p.val!=q.val)return false;
        // boolean l = isSameTree(p.left,q.left);
        // boolean r = isSameTree(p.right,q.right);
        // if(!l || !r)return false;
        // return true;
        
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
