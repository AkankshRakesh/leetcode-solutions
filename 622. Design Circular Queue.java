class MyCircularQueue {
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int count = 0;
    public MyCircularQueue(int k) {
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        Node node = new Node(value);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else if(isFull()) return false;
        else{
            node.next = tail;
            tail.prev = node;
            tail = node;
        }
        capacity--;

        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        Node nextHead = head.prev;
        if(nextHead == null){
            head = null;
            tail = null;
        }
        else{
            head = nextHead;
            head.next = null;
        }
        capacity++;

        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public boolean isFull() {
        return capacity == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */