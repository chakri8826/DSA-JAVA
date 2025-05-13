import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class H1Paths {
    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    public static void DFS(Node root,ArrayList<Integer> li,ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        li.add(root.data);
        if(isLeaf(root)) ans.add(new ArrayList<>(li));  //creates a new copy of the list that wil be added to the ans.
        // if(isLeaf(root)) ans.add(li);   // This creates a reference for li when li changes ans containing li also changes
        else{
            DFS(root.left,li,ans);
            DFS(root.right,li,ans);
        }
        li.remove(li.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        DFS(root,li,ans);
        return ans;
    }
}
