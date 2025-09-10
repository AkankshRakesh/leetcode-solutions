class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    public MyQueue() {
        
    }

    public void shiftStack(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()) outStack.push(inStack.pop());
        }
    }

    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        shiftStack();
        return outStack.pop();
    }
    
    public int peek() {
        shiftStack();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */