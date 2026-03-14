class LFUCache {
    public class Node{
        int freq;
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val, int freq){
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
    public class NodeList{
        Node head;
        Node tail;
        public NodeList(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }
    }

    int capacity;
    int size;
    int minF = 1;
    HashMap<Integer, Node> hm = new HashMap<>(); // key -> specific Node
    HashMap<Integer, NodeList> freqHm = new HashMap<>(); // freq -> linkedList head and tail

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int key, int value, int freq){
        if(!hm.containsKey(key)) hm.put(key, new Node(key, value, freq));
        Node node = hm.get(key);
        node.freq = freq;
        node.next = null;
        node.prev = null;
        // minF = Math.min(minF, freq);
        if(!freqHm.containsKey(freq)) freqHm.put(freq, new NodeList(node, node));
        else{
            NodeList list = freqHm.get(freq);
            node.next = list.head;
            if(list.head != null) list.head.prev = node;
            list.head = node;
            if(list.tail == null) list.tail = node;
        }
    }
    public void removal(){
        NodeList list = freqHm.get(minF);
        Node node = list.tail; 
        hm.remove(node.key);
        if(list.head == list.tail) freqHm.remove(minF);
        else{
            list.tail = node.prev;
            list.tail.next = null;
        }
        node.prev = null;
        node.next = null;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        NodeList list = freqHm.get(node.freq);
        if(list.head == node && list.tail == node){
            freqHm.remove(node.freq);
            if(minF == node.freq) minF++;
        }
        else if(node.next == null){
            Node prev = node.prev;
            prev.next = null;
            list.tail = prev;
        }
        else if(node.prev == null){
            Node next = node.next;
            next.prev = null;
            list.head = next;
        }
        else{
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
        }

        node.prev = null;
        node.next = null;
        insert(node.key, node.val, node.freq + 1);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            get(key); 
            return;
        }
        if(size >= capacity){
            removal();
            size--;
        }
        
        insert(key, value, 1);
        minF = 1;
        size++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */