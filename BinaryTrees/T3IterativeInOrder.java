class T3IterativeInOrder {
    // CHAKRI THINKS
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     Stack<TreeNode> st = new Stack<>();
    //     List<Integer> ans = new ArrayList<>();
    //     if(root==null) return ans;
    //     st.push(root);
    //     TreeNode curr = root;
    //     while(!st.isEmpty()){
    //         while(curr!=null){
    //             st.push(curr);
    //             curr=curr.left;
    //         } 
    //         curr=st.pop();
    //         ans.add(curr.val);
    //         curr=curr.right;
    //     }
    //     ans.remove(ans.size()-1);
    //     return ans;
    // }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            } 
            curr=st.pop();
            ans.add(curr.val);
            curr=curr.right;
        }
        return ans;
    }
}
