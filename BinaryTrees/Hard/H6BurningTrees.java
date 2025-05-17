
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class H6BurningTrees {
    public static void makeParents(Node root, Map<Node,Node> map,Node parent, int targetVal, Node[] targetHolder){
        if(root==null)return;
        map.put(root,parent);
        if (root.data == targetVal) {
            targetHolder[0] = root; // Found the target node
        }
        if(root.left!=null)makeParents(root.left,map,root,targetVal,targetHolder);
        if(root.right!=null)makeParents(root.right,map,root,targetVal,targetHolder);
    }
    public static int minTime(Node root, int target) {
        Map<Node,Node> map = new HashMap<>();
        Node[] targetHolder = new Node[1]; 
        makeParents(root, map, null, target, targetHolder);
        Node targetNode = targetHolder[0];
        
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        int count=0;
        q.offer(targetNode);
        visited.add(targetNode);
        while(!q.isEmpty()){
            int qs = q.size();
            boolean burnt=false;
            while(qs!=0){
                Node n = q.poll();
                if(n.right!=null && !visited.contains(n.right)){
                    q.offer(n.right);
                    visited.add(n.right);
                    burnt=true;
                }
                if(n.left!=null && !visited.contains(n.left)){
                    q.offer(n.left);
                    visited.add(n.left);
                    burnt=true;
                }
                Node par = map.get(n);
                if(par!=null && !visited.contains(par)){
                    q.offer(par);
                    visited.add(par);
                    burnt=true;
                }
                qs--;
            }
            if(burnt)count++;
        }
        return count;
    }
}
