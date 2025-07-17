import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class H2LCA {
    // BRUTE FORCE

    //  public boolean prtn(TreeNode root,ArrayList<Integer> li,int x){
    //     if(root==null) return false;
    //     li.add(root.val);
    //     if(root.val==x) return true;
    //     if(prtn(root.left,li,x) || prtn(root.right,li,x))return true;
    //     li.remove(li.size()-1);
    //     return false;
    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     ArrayList<Integer> li1 = new ArrayList<>();
    //     ArrayList<Integer> li2 = new ArrayList<>();
    //     prtn(root,li1,p.val);
    //     prtn(root,li2,q.val);
    //     int i=0;
    //     TreeNode lca = new TreeNode(0);
    //     while(i<li1.size() && i<li2.size()){
    //         int val1 = li1.get(i);
    //         int val2 = li2.get(i);
    //         if(val1==val2) lca.val=val1;
    //         i++;
    //     }
    //     return lca;
    // }

    
   
    // MISTAKEN
    // public TreeNode f(TreeNode root, TreeNode p, TreeNode q){
    //     if(root==null || root==p || root==q)return root;
    //     if(f(root.left,p,q)!=null && f(root.right,p,q)!=null)return root;
    //     // Here we are not storing the null in variable and we are returning only the root.left so always it gives a node, the null will be never come as output thats why we need to store in variables.
    //     if(f(root.left,p,q)!=null){
    //         return root.left;
    //     }
    //     return root.right;
    // }  

     // OPTIMIZED
    public TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;

        TreeNode left = f(root.left, p, q);
        TreeNode right = f(root.right, p, q);

        if(left != null && right != null) return root;
        return (left != null) ? left : right;
    }    
}


