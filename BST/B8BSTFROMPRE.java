class B8BSTFROMPRE{
    public TreeNode f(int[] A,int bound,int i[]){
        if(i[0]==A.length || A[i[0]]>bound)return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = f(A,root.val,i);
        root.right = f(A,bound,i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return f(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}

