class MinStack {
    class Pair{
        Integer val;
        Integer min;
        public Pair(Integer val, Integer min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.size() == 0) stack.push(new Pair(val,val));
        else{
            Pair top = stack.peek();
            if(top.min > val) stack.push(new Pair(val,val));
            else stack.push(new Pair(val, top.min));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */