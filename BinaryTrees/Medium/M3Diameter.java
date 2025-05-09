public class M3Diameter {
    // int maxi=0;
    // public int f(TreeNode root){
    //     if(root==null) return 0;
    //     int l = f(root.left);
    //     int r = f(root.right);
    //     return 1+Math.max(l,r);
    // } 
    // public void f1(TreeNode root){
    //     if (root == null) return ;
    //     int l = f(root.left);
    //     int r = f(root.right);
    //     maxi=Math.max(l+r,maxi);
    //     f1(root.left);
    //     f1(root.right);
    // } 
    // public int diameterOfBinaryTree(TreeNode root) {
    //     f1(root);
    //     return maxi;
    // }

 
    public int f(TreeNode root,int diameter[]){
        if(root==null) return 0;
        int l = f(root.left,diameter);
        int r = f(root.right,diameter);
        diameter[0]=Math.max(l+r,diameter[0]);
        return 1+Math.max(l,r);
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        f(root,diameter);
        return diameter[0];
    }
}
