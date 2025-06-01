import java.util.HashMap;
import java.util.Map;

public class H9BtWithPostIn {
     // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i=0;i<inorder.length;i++){
    //         map.put(inorder[i],i);
    //     }
    //     return helper(postorder,postorder.length-1,0,inorder,0,inorder.length-1,map);
    // }
    // public TreeNode helper(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> map){
    //     if(ps<0||is>ie)return null;
    //     int rootVal = postorder[ps];
    //     TreeNode root = new TreeNode(rootVal);
    //     int rootInd = map.get(rootVal);
    //     int rightSize = ie-rootInd;
    //     root.right = helper(postorder,ps-1,ps-rightSize,inorder,rootInd+1,ie,map);
    //     root.left = helper(postorder,ps-rightSize-1,pe,inorder,is,rootInd-1,map);
    //     return root;
    // }



    // ✅ Why this works without explicit postorder range:
    // You're not traversing the full array — you're always:

    // Taking the root from postorder[postIndex]

    // Using inorder to determine subtree sizes

    // And jumping backwards in postorder appropriately

    // Thus, a single postIndex is enough as long as you:

    // Keep the subtree sizes accurate (from inorder)

    // Use correct recursive calls

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] postorder, int[] inorder, int postIndex, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (postIndex < 0 || inStart > inEnd) return null;

        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        int rightSize = inEnd - rootIdx;

        root.right = helper(postorder, inorder, postIndex - 1, rootIdx + 1, inEnd, map);
        root.left = helper(postorder, inorder, postIndex - rightSize - 1, inStart, rootIdx - 1, map);

        return root;
    }
}