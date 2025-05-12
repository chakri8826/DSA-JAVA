import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M11RightView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levSize=q.size(),ls=0;
            while(ls<levSize){
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(ls==levSize-1) ans.add(node.val); 
                ls++;
            } 
        } 
        return ans;
    }

    // RECURSIVE SOLUTION
    // public void preOrder(TreeNode root,List<Integer> ans,int dep){
    //     if(root==null)return;
    //     if(dep==ans.size()) ans.add(root.val);
    //     preOrder(root.right,ans,dep+1);
    //     preOrder(root.left,ans,dep+1);
    // } 
    // public List<Integer> rightSideView(TreeNode root) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     if(root==null) return ans;
    //     preOrder(root,ans,0);
    //     return ans;
    // }
}
