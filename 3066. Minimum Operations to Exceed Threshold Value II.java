class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i = 0; i < nums.length; i++){
            pq.add((long)nums[i]);
        }
        int count = 0;
        while(pq.peek() < k){
            long first = pq.poll(), second = pq.poll();
            long min = first > second ? second : first;
            long max = first > second ?  first : second;
            pq.add((min * 2) + (max));
            count++;
        }
        return count;
    }
}