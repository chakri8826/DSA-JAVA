class  06BSTORNOT{
    public boolean f(TreeNode root,long min,long max){
        if(root==null)return true;
        if(root.val<=min || root.val>=max)return false;
        boolean left = f(root.left,min,root.val);
        boolean right = f(root.right,root.val,max);
        return left&&right;
    }
    public boolean isValidBST(TreeNode root) {
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}

