class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(left.size() == 0 && right.size() == 0) right.offer(num);
        else{
            if(!left.isEmpty() && num <= left.peek()){
                right.offer(left.poll());
                left.offer(num);
            }
            else{
                right.offer(num);
            }
        }

        if(right.size() - left.size() == 2){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        int leftSize = left.size(), rightSize = right.size();
        if((leftSize + rightSize) % 2 != 0){
            return (double)right.peek();
        }

        double first = (double)left.peek();
        double second = (double)right.peek();
        
        return (first + second) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */