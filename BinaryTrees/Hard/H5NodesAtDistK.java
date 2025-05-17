import java.util.*;
public class H5NodesAtDistK {
    public void makeParents(TreeNode root,Map<TreeNode,TreeNode> map,TreeNode parent){
        if(root==null)return;
        map.put(root,parent);
        if(root.left!=null)makeParents(root.left,map,root);
        if(root.right!=null)makeParents(root.right,map,root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        makeParents(root,map,null);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int dist=0;
        while(!q.isEmpty()){
            int qs = q.size();
            if(dist==k)break;
            while(qs!=0){
                TreeNode node = q.poll();
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                TreeNode par = map.get(node);
                if(par!=null && !visited.contains(par)){
                    q.offer(par);
                    visited.add(par);
                }               
                qs--;
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;

    }
}
