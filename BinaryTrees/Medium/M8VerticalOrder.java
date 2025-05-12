import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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
public class M8VerticalOrder {
     class Tuple {
        TreeNode node;
        int row, col;
        Tuple(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // col -> (row -> all node values at (row, col))
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS traversal, storing node with row and col
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;
            
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            
            if (node.left != null) q.offer(new Tuple(node.left, row + 1, col - 1));
            if (node.right != null) q.offer(new Tuple(node.right, row + 1, col + 1));
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            // System.out.println(rows);
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                // System.out.println(pq);
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            // System.out.println(colList);
            result.add(colList);
        }

        // for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> rows:map.entrySet()){
        //     List<Integer> li = new ArrayList<>();
        //     for(Map.Entry<Integer,PriorityQueue<Integer>> pqEntry:rows.getValue().entrySet()){
        //         PriorityQueue<Integer> pq = pqEntry.getValue();
        //         while(!pq.isEmpty()){
        //             li.add(pq.poll());
        //         }
        //     }
        //     result.add(li);
        // }
 
        return result;
    }
    public static void main(String[] args) {
        // Example usage
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(9);
        // root.right = new TreeNode(20);
        // root.right.left = new TreeNode(15);
        // root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        M8VerticalOrder m8VerticalOrder = new M8VerticalOrder();
        List<List<Integer>> result = m8VerticalOrder.verticalTraversal(root);
        System.out.println(result); // Output: [[4], [2], [1, 5, 6], [3]]
    }
}
