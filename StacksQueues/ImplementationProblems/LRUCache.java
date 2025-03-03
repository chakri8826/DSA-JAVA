import java.util.*;
class LRUCache {
    int capacity;
    Node head,tail;
    Map<Integer,Node> map;

    class Node{
        int key,value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    public void insertAtFront(Node curr){
        curr.next=head.next;
        curr.prev=head;
        head.next=curr;
        curr.next.prev=curr;
    }

    public void delete(Node curr){
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }

    public void removeLast(){
        Node ln = tail.prev;
        delete(ln);
        map.remove(ln.key);
    }

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            delete(curr);
            insertAtFront(curr);
            return curr.value;
        }
        return -1;
    }
    

    // ❌ If we check size == capacity at the beginning, we might evict an entry incorrectly when the key is already present in the cache.
    // ✅ So We should first check if the key exists before handling the cache being full.
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            delete(curr);
            insertAtFront(curr);
            curr.value=value;
        }
        else{
            if(map.size()==capacity){
                removeLast();
            } 
            Node newNode = new Node(key,value);
            insertAtFront(newNode);
            map.put(key,newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
