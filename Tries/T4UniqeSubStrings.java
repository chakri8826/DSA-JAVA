class Node {
    Node links[] = new Node[26];
    boolean flag=false;
    
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
 
public class T4UniqeSubStrings {
    public static int countDistinctSubstring(String st) {
        Node root = new Node();
        int n = st.length(),cnt=0;
        for(int i=0;i<st.length();i++){
            Node node = root;
            for(int j=i;j<n;j++){
                if(!node.containsKey(st.charAt(j))){
                    cnt++;
                    node.put(st.charAt(j),new Node());
                }
                node=node.get(st.charAt(j));
            }
        }
        return cnt+1;
    }
    public static void main(String[] args) {
        String st = "abc";
        System.out.println(countDistinctSubstring(st));
    }
}
