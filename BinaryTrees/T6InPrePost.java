import java.util.*;
 
 
//  Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 
class Pair{
    TreeNode t;
    int i;
    public Pair(TreeNode t,int i){
        this.t=t;
        this.i=i;
    }
}

class T6InPrePost {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(Arrays.asList(
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        ));
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        while(!st.isEmpty()){
            Pair top = st.pop();
            if(top.i==1){
                preOrder.add(top.t.data);
                top.i++;
                st.push(top);
                if(top.t.left!=null)st.push(new Pair(top.t.left,1));
            }
            else if(top.i==2){
                inOrder.add(top.t.data);
                top.i++;
                st.push(top);
                if(top.t.right!=null)st.push(new Pair(top.t.right,1));
            }
            else{
                postOrder.add(top.t.data);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(preOrder);
        ans.add(inOrder);
        ans.add(postOrder);
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = getTreeTraversal(root);
        System.out.println(result); // Output: [[1, 2, 4, 5, 3], [4, 2, 5, 1, 3], [4, 5, 2, 3, 1]]
    }
}
