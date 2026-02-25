class FreqStack {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] != a[1] ? Integer.compare(b[1], a[1]) : Integer.compare(b[2], a[2]));
    HashMap<Integer, Integer> hm = new HashMap<>();
    int time = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        if(!hm.containsKey(val)){
            pq.offer(new int[]{val, 1, time++});
            hm.put(val, 1);
        }
        else{
            pq.offer(new int[]{val, hm.get(val) + 1, time++});
            hm.put(val, hm.get(val) + 1);
        }
    }
    
    public int pop() {
        while(hm.get(pq.peek()[0]) != pq.peek()[1]) pq.poll();
        hm.put(pq.peek()[0], pq.peek()[1] - 1); 
        return pq.poll()[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */