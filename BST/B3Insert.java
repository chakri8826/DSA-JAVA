class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
    }

    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

class B3Insert{
    public TreeNode create(int data){
        TreeNode node = new TreeNode(data,null,null);
        return node;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return create(val); 
        }
        else if(root.val<val){
            root.right = insertIntoBST(root.right,val);
        }
        else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}