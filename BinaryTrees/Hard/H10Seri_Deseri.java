import java.util.LinkedList;
import java.util.Queue;

public class H10Seri_Deseri {
        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        // return serializeHelper(root,sb);  // PRE-ORDER
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // we dont need to group level by level(using inner while for size) as we are flattening, enouhg of going level by level 
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null){
                sb.append("null,");
                continue;
            }
            sb.append(n.val).append(",");
            q.offer(n.left);
            q.offer(n.right);   
        } 
        return sb.toString();
    } 
    // PRE-ORDER
    // public void serializeHelper(TreeNode root,StringBuilder sb){
    //     if(root==null){
    //         sb.append("null,");
    //         return;
    //     }
    //     sb.append(root.val).append(",");
    //     serializeHelper(root.left,sb);
    //     serializeHelper(root.right,sb);
    // }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split(",");
        if(nodes.length==0 || nodes[0].equals("null"))return null;
        // LinkedList<String> list = new LinkedList<>(Arrays.asList(nodes));  // PRE-ORDER
        // return deserializeHelper(list);  // PRE-ORDER
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);
        int i=1;
        // i never crosses the length of list (as nulls are not addes to the queue, only not nulls are addes for each of the not null node i will incremented 2 times so at final it will be at len-1 position)
        while(!q.isEmpty()&& i < nodes.length){
            TreeNode n = q.poll();
            if(!nodes[i].equals("null")){
                n.left=new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(n.left);
            }
            i++;
            if(!nodes[i].equals("null")){
                n.right=new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(n.right);
            }
            i++;
        }
        return root;
    } 
 
    // PRE-ORDER
    // public TreeNode deserializeHelper(LinkedList<String> list){
    //     if(list.isEmpty())return null;
    //     String val = list.removeFirst();
    //     if(val.equals("null"))return null;
    //     TreeNode node = new TreeNode(Integer.parseInt(val));
    //     node.left = deserializeHelper(list);
    //     node.right = deserializeHelper(list);
    //     return node;
    // }
}
