
public class H7CountNodes {
     public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left==right)return (2<<left)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int getLeftHeight(TreeNode root){
        if(root==null)return 0;
        int count=0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int getRightHeight(TreeNode root){
        if(root==null)return 0;
        int count=0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
}
