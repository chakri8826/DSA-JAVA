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
class H12FlattenBT{
    TreeNode prev=null;
    
        // public void flatten(TreeNode root) {
        //     if(root==null)return;
        //     flatten(root.right);
        //     flatten(root.left);
        //     root.right=prev;
        //     root.left=null;
        //     prev=root;
        // }

        // public void flatten(TreeNode root) {
        //     Stack<TreeNode> st = new Stack<>();
        //     if(root==null)return;
        //     st.push(root);
        //     while(!st.isEmpty()){
        //         TreeNode curr = st.pop();
        //         if(curr.right!=null){
        //             st.push(curr.right);
        //         }
        //         if(curr.left!=null){
        //             st.push(curr.left);
        //         }
        //         if(!st.isEmpty()){
        //             curr.right=st.peek();
        //         }
        //         curr.left=null;
        //     }
        // } 

        public void flatten(TreeNode root) {
            if(root==null) return;
            TreeNode curr = root;
            while(curr!=null){
                if(curr.left!=null){
                    TreeNode rightMost = curr.left;
                    while(rightMost.right!=null){
                        rightMost=rightMost.right;
                    }
                    rightMost.right=curr.right;
                    curr.right=curr.left;
                    curr.left=null;
                } 
                curr=curr.right;
            }
        }
}