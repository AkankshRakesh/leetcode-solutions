class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < k; i++) pq.offer(i);
        ans.add(nums[pq.peek()]);

        for(int i = k; i < nums.length; i++){
            pq.offer(i);  
            while(pq.peek() <= i - k) pq.poll();

            ans.add(nums[pq.peek()]);
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length; i++) res[i] = ans.get(i);

        return res;
    }
}