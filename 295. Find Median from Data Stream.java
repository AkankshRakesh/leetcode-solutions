class MedianFinder {
    PriorityQueue<Integer> front, back;
    public MedianFinder() {
        front = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        back = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(front.size() == 0) front.offer(num);
        else if(back.size() == 0) back.offer(num);
        else{
            if(num > back.peek()){
                front.offer(back.poll());
                back.offer(num);
            }
            else front.offer(num);

            if(front.size() - back.size() == 2){
                back.offer(front.poll());
            }
            else if(back.size() - front.size() == 2){
                front.offer(back.poll());
            }
        } 
    }
    
    public double findMedian() {
        if(front.size() == back.size()){
            return ((double)(front.peek() + back.peek()) / 2.0);
        }
        else if(back.size() == 0) return front.peek();
        return Math.min(front.peek(), back.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */