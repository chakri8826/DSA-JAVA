import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class B10BSTIterator {
    private Stack<TreeNode> stack;
    
    public B10BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    // Push all left nodes to stack (inorder traversal preparation)
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        
        TreeNode current = stack.pop();
        // Push all left nodes of the right subtree
        pushAllLeft(current.right);
        
        return current.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    // Helper method to create a sample BST for testing
    private static TreeNode createSampleBST() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = createSampleBST();
        B10BSTIterator iterator = new B10BSTIterator(root);
        
        System.out.println("BST Inorder Traversal using Iterator:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
        // Test individual calls
        iterator = new B10BSTIterator(root);
        System.out.println("First element: " + iterator.next());  // 3
        System.out.println("Second element: " + iterator.next()); // 7
        System.out.println("Has next: " + iterator.hasNext());    // true
        System.out.println("Third element: " + iterator.next());  // 9
    }
}
