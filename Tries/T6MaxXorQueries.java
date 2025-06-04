import java.util.Arrays;

class Node{
    Node links[] = new Node[2]; 

    boolean containsKey(int bit) {
        return links[bit] != null;
    } 

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie{
    public Node root;

    public Trie(){
        root=new Node();
    }

    public void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    public int maxXor(int num){
        Node node = root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node=node.get(1-bit);
            } 
            else{
                node=node.get(bit);
            }
        }
        return maxNum;
    }
}
public class T6MaxXorQueries {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int [][]q = new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            q[i][0] = queries[i][0]; 
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q,(a,b)->Integer.compare(a[1],b[1]));
        Arrays.sort(nums);
        int ind=0;
        Trie trie = new Trie();
        int res[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int xi = q[i][0];
            int mi = q[i][1];
            int origInd = q[i][2];
            while(ind<nums.length && nums[ind]<=mi){
                trie.insert(nums[ind]);
                ind++;
            }
            if(ind==0)res[origInd]=-1;
            else res[origInd] = trie.maxXor(xi);
        }
        return res;
    }
}
