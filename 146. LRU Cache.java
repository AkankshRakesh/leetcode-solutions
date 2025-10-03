class LRUCache {
    class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    class Pair{
        int value;
        int count;
        public Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
    HashMap<Integer, Pair> hm = new HashMap<>();
    Node head = new Node(-1);
    Node tail = new Node(-1);
    int maxCap;
    public LRUCache(int capacity) {
        maxCap = capacity;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        int val = hm.get(key).value;
        hm.get(key).count++;
        Node node = new Node(key);
        node.right = head;
        head.left = node;
        head = node;

        return val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.get(key).value = value;
            hm.get(key).count++;
        }
        else{
            hm.put(key, new Pair(value, 1));
        }
        Node node = new Node(key);
        node.right = head;
        head.left = node;
        head = node;
        if(tail.val == -1) tail = head;

        while(hm.size() > maxCap){
            int tailKey = tail.val;
            if(hm.get(tailKey).count == 1) hm.remove(tailKey);
            else hm.get(tailKey).count--;

            Node prev = tail.left;
            prev.right = null;
            tail = prev;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */