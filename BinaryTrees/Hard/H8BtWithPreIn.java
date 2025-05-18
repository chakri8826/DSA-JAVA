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
class H8BtWithPreIn{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    } 
    public TreeNode helper(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer>map){
        if(ps>pe || is>ie)return null;
        int rootval = preorder[ps];
        TreeNode root = new TreeNode(rootval);
        int rootInd = map.get(rootval);
        int leftSize = rootInd-is;
        root.left = helper(preorder,ps+1,ps+leftSize,inorder,is,rootInd-1,map);
        root.right = helper(preorder,ps+leftSize+1,pe,inorder,rootInd+1,ie,map);
        return root;
    }
}