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
class M2Balanced{
    // public int f(TreeNode root){
    //     if(root==null) return 0;
    //     int l = f(root.left);
    //     int r = f(root.right);
    //     return 1+Math.max(l,r);
    // } 
    // public boolean isBalanced(TreeNode root) {
    //     if(root==null)return true;
    //     int lh = f(root.left);
    //     int rh = f(root.right);
    //     if(Math.abs(lh-rh)>1) return false;
    //     boolean left = isBalanced(root.left);
    //     boolean right = isBalanced(root.right);
    //     if(!left || !right)return false;
    //     return (lh-rh==-1 || lh-rh==0 || lh-rh==1) ;
    // }

    public int f(TreeNode root){
        if(root==null) return 0;
        int l = f(root.left);
        if(l==-1) return -1;
        
        int r = f(root.right);
        if(r==-1)return -1;
        if(Math.abs(l-r)>1)return -1;
        return 1+Math.max(l,r);
    } 

    public boolean isBalanced(TreeNode root) {
        if(f(root)==-1)return false;
        return true;
    } 
}
