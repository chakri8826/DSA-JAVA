import java.util.* ;
import java.io.*; 
class Node {
    Node links[] = new Node[26];
    int countEndWith = 0;
    int countPrefix = 0;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd() {
        countEndWith++;
    }

    void increasePrefix() {
        countPrefix++;
    }

    void decreaseEnd() {
        countEndWith--;
    }

    void decreasePrefix() {
        countPrefix--;
    }

    int getEnd() {
        return countEndWith;
    }

    int getPrefix() {
        return countPrefix;
    }
}

public class T2 {
    private Node root;

    public T2() {
        root = new Node();
    }

    // Insert a word into the trie
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    // Count how many times a word was inserted
    public int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getEnd();
    }

    // Count how many words start with a given prefix
    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getPrefix();
    }

    // Erase a word from the trie
    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) return; // Word not present
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node next = node.get(ch);
            next.decreasePrefix();
            node = next;
        }
        node.decreaseEnd();
    }
}
