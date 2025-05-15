
import java.util.LinkedList;
import java.util.Queue;

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
 
class Tuple{
    TreeNode n;
    int ind;
    Tuple(TreeNode n,int ind){
        this.n=n;
        this.ind=ind;
    }
}
public class H3Width {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,1));
        int maxWidth=1;
        while(!q.isEmpty()){
            int f=0,l=0,i=0;
            int ls = q.size();
            while(i<ls){
                Tuple t = q.poll();
                TreeNode n = t.n;
                int ind = t.ind;
                if(i==0)f=ind;
                if(i==ls-1)l=ind;
                if(n.left!=null) q.offer(new Tuple(n.left,2*(ind-1)+1));
                if(n.right!=null) q.offer(new Tuple(n.right,2*(ind-1)+2));
                i++;
            }
            maxWidth=Math.max(maxWidth,l-f+1);
        }
        return maxWidth;
    }
}
