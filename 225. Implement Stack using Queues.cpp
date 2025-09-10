class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {}

    private void shift() {
        int size = q.size() - 1;
        while (size > 0) {
            q.offer(q.poll());
            size--;
        }
    }

    public void push(int x) {
        q.offer(x);
    }

    public int pop() {
        shift();
        return q.poll();
    }

    public int top() {
        shift();
        int val = q.poll(); 
        q.offer(val);      
        return val;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
