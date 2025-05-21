class H11MorrisTraversal{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root==null)return inOrder;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                inOrder.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode rightMost = curr.left;
                while(rightMost.right!=null && rightMost.right!=curr){
                    rightMost=rightMost.right;
                }
                if(rightMost.right==null){
                    rightMost.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMost.right=null;
                    inOrder.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return inOrder;
    }
}