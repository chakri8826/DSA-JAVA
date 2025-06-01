public class H4ChildSum {
    public static boolean f(Node root){
        if(root==null)return true;
        int le=0,ri=0;
        if(root.left!=null)le=root.left.data;
        if(root.right!=null)ri=root.right.data;
        int valid = le+ri;
        if(valid!=0 && valid!=root.data)return false;
        return f(root.left) && f(root.right);
    }
    public static int isSumProperty(Node root) {
        if(f(root))return 1;
        return 0;
    }
}
