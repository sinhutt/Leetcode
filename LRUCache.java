public class LRUCache {
    public class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1); // least recently used
    private Node tail = new Node(-1, -1); // most recently used
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        // remove current
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // move current to tail
        moveToTail(curr);
        return map.get(key).value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }
    
    private void moveToTail(Node curr) {
        curr.prev = tail.prev;
        tail.prev = curr;
        curr.prev.next = curr;
        curr.next = tail;
    }
}
        

   