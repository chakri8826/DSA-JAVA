class 02Floor{ 
    public static int floor(Node root, int x) {
        int ceil=-1;
        while(root!=null){
            if(root.data==x){
                return x;
            }
            else if(root.data>x){
                root=root.left;
            }
            else{
                ceil=root.data;
                root=root.right;
            }
        }
        return ceil;
    }
} 