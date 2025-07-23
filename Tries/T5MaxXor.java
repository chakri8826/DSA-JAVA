// class Node{
//     Node links[] = new Node[2]; 

//     boolean containsKey(char ch) {
//         return links[ch - '0'] != null;
//     }

//     Node get(char ch) {
//         return links[ch - '0'];
//     }

//     void put(char ch, Node node) {
//         links[ch - '0'] = node;
//     }
// }
// class Trie{
//     public Node root;

//     public Trie(){
//         root=new Node();
//     }

//     public void insert(String st){
//         Node node = root;
//         for(int i=0;i<st.length();i++){
//             if(!node.containsKey(st.charAt(i))){
//                 node.put(st.charAt(i),new Node());
//             }
//             node = node.get(st.charAt(i));
//         }
//     }

//     public int maxXor(String st){
//         Node node = root;
//         StringBuilder xor = new StringBuilder();
//         for(int i=0;i<st.length();i++){
//             char ch = st.charAt(i);
//             char opposite = (ch=='0')?'1':'0';
//             if(node.containsKey(opposite)){
//                 xor.append('1');
//                 node = node.get(opposite);   
//             }
//             else{
//                 xor.append('0');
//                 node = node.get(ch);
//             }
//         }
//         return Integer.parseInt(xor.toString(),2);
//     }
// }

// public class T5MaxXor {
//     public static String convertNumToBin(int num){
//         StringBuilder sb = new StringBuilder();
//         for (int i = 31; i >= 0; i--) {
//             int bit = (num >> i) & 1;
//             sb.append(bit);
//         }
//         return sb.toString();
//     }
//     public static int findMaximumXOR(int[] nums) {
//         Trie trie = new Trie();
//         for(int i=0;i<nums.length;i++){
//             trie.insert(convertNumToBin(nums[i]));
//         }
//         int maxXor=0;
//         for(int i=0;i<nums.length;i++){
//             String x = convertNumToBin(nums[i]);
//             maxXor = Math.max(maxXor,trie.maxXor(x));
//         }
//         return maxXor;
//     }
//     public static void main(String[] args) {
//         int[] nums = {3,10,5,25,2,8};
//         System.out.println(findMaximumXOR(nums));
//     }
// }







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


public class T5MaxXor {
    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }
        int maxXor=0;
        for(int i=0;i<nums.length;i++){
            maxXor = Math.max(maxXor,trie.maxXor(nums[i]));
        }
        return maxXor;
    }
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }
}
