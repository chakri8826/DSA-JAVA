class B4Delete{
    public TreeNode inOrderPredecessor(TreeNode root){
        root=root.left;
        while(root.right!=null){
            root=root.right;
        }
        return root;
    } 
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                TreeNode ipre = inOrderPredecessor(root);
                root.val=ipre.val;
                root.left=deleteNode(root.left,ipre.val);
            }
        }
        return root;
    }
}