import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tuple{
    Node n;
    int c;
    Tuple(Node n,int c){
        this.n=n;
        this.c=c;
    }
}

public class M9TopViewBT { 
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            Node n = t.n;
            int c = t.c;
            map.putIfAbsent(c,n.data);
            if(n.left!=null) q.offer(new Tuple(n.left,c-1));
            if(n.right!=null) q.offer(new Tuple(n.right,c+1));
        }
        for(int v : map.values()){
            ans.add(v);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        ArrayList<Integer> result = topView(root);
        System.out.println(result); // Output: [4, 2, 1, 3, 6, 7]
    }
}

