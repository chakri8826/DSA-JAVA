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
class Trie{
    private Node root;
    public Trie(){
        root= new Node();
    }
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    // public boolean search(String word) {
    //     Node node = root;
    //     for (int i = 0; i < word.length(); i++) {
    //         char ch = word.charAt(i);
    //         if (!node.containsKey(ch)) {
    //             return false;
    //         }
    //         node = node.get(ch);
    //     }
    //     return node.isEnd();
    // }
    
    public boolean isValid(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
            if(!node.isEnd()){
                return false;
            }
        }
        return true;
    }
}

class T3LongValidWord {
    public String longestValidWord(String[] words) {
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }  
        String ans="";
        for(int i=0;i<words.length;i++){
            boolean flag=true;
            // CHAKRI THOUGHT (CREATES EXTRA SPACE FOR SUBSTRINGS)
            // for(int j=0;j<words[i].length();j++){
            //     if(!trie.search(words[i].substring(0,j+1))){
            //         flag=false;
            //         break;
            //     }
            // }
            if(trie.isValid(words[i])){
                if(words[i].length()>ans.length() || words[i].length()==ans.length() && words[i].compareTo(ans)<0){
                    ans=words[i];
                }
            }
        } 
        return ans;
    }
}   