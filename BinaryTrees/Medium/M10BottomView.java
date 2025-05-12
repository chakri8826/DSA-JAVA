import java.util.*;

class Tuple{
    Node n;
    int c;
    Tuple(Node n,int c){
        this.n=n;
        this.c=c;
    }
} 

public class M10BottomView {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.offer(new Tuple(root,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            Node n = t.n;
            int c = t.c;
            map.put(c,n.data);
            if(n.left!=null) q.offer(new Tuple(n.left,c-1));
            if(n.right!=null) q.offer(new Tuple(n.right,c+1));
        }
        for(int v:map.values()){
            ans.add(v);
        }
        return ans;
    }



}