class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }

    public void shift(){
        int size = q.size() - 1;
        while(size > 0){
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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */