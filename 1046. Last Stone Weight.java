class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int n = stones.length;
        for(int i = 0; i < n; i++) pq.add(stones[i]);

        while(pq.size() > 1){
            int y = pq.peek();
            pq.remove(y);
            int x = pq.peek();
            pq.remove(x);

            if(x != y){
                pq.add(y - x);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}