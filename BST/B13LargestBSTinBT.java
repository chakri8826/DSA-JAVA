class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}

class NodeValue{
    int min,max,size;
    NodeValue(int min,int max,int size){
        this.min=min;
        this.max=max;
        this.size=size;
    }
}
public class B13LargestBSTinBT {
    static boolean isBST(Node node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;

        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    // Count the number of nodes in a subtree
    static int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Brute force approachessss
    // static int largestBst(Node root) {
    //     if (root == null) return 0;

    //     // If current subtree is a BST
    //     if (isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
    //         return countNodes(root);
    //     }

    //     // Else, try left and right subtrees
    //     return Math.max(largestBst(root.left), largestBst(root.right));
    // }


    

    // OPTIMIZED
    static NodeValue largestBstHelper(Node root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);
        
       
        if(left.max<root.data && root.data<right.min){
            //  the minimum of the whole subtree is from the left.
            // But if the left is null, left.min will be Integer.MAX_VALUE, so you’ll use root.data.
            // Same idea for Math.max(root.data, right.max), which gives the maximum value in the entire current subtree.
            return new NodeValue(Math.min(root.data,left.min),Math.max(root.data,right.max),1+left.size+right.size);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }

    static int largestBst(Node root) {
        return largestBstHelper(root).size;
    }
}

