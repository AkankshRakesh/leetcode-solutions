class Node{
    int val;
    int key;
    Node next;
    Node prev;
    public Node(int val, int key){
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    HashMap<Integer, Node> hm = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity;
    int currCap = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public void markUsed(int key){
        Node node = hm.get(key);
        if(head == tail || head == node) return;
        else if(tail == node){
            Node next = node.next;
            next.prev = null;
            tail = next;
            
            node.prev = head;
            head.next = node;
            head = node;
        }
        else{
            Node prev = node.prev;
            Node next = node.next;
            next.prev = prev;
            prev.next = next;

            node.prev = head;
            head.next = node;
            head = node;
        }
    }

    public void delete(){
        hm.remove(tail.key);
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            Node next = tail.next;
            next.prev = null;
            tail = next;
        }
    }

    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        
        // if(head != null) System.out.println(head.key + " " + head.val);

        markUsed(key);


        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            markUsed(key);
        }
        else{
            currCap++;  
            Node node = new Node(value, key);
            hm.put(key, node);

            if(head == null){
                head = node;
                tail = node;
            }
            else{
                node.prev = head;
                head.next = node;
                head = node;

                if(currCap > capacity){
                    delete();
                    currCap--;
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */