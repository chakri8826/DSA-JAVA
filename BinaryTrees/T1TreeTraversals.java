import java.util.*;
public class T1TreeTraversals {
    public static void inOrder(TreeNode root,List<Integer> li){
        if(root==null)return ;
        inOrder(root.left,li);
        li.add(root.data);
        inOrder(root.right,li);
    }   
    
    public static void preOrder(TreeNode root,List<Integer> li){
        if(root==null)return ;
        li.add(root.data);
        preOrder(root.left,li);
        preOrder(root.right,li);
    }
    public static void postOrder(TreeNode root,List<Integer> li){
        if(root==null)return ;
        postOrder(root.left,li);
        postOrder(root.right,li);
        li.add(root.data);
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        List<Integer> li3 = new ArrayList<>();
        inOrder(root,li1);
        preOrder(root,li2);
        postOrder(root,li3);
        ans.add(li1);
        ans.add(li2);
        ans.add(li3);
        return ans;
    }
}   