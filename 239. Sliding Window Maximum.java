class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;

        int[] ans = new int[nums.length - k + 1];
        int index = 1;
        int first = -1, second = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i], i});
        }

        ans[0] = pq.peek()[0];
        for(int i = 1; i + k <= nums.length; i++){
            int ele = nums[i + k - 1];
            pq.offer(new int[]{ele, i + k - 1});
            while(pq.peek()[1] < i) pq.poll();
            ans[index++] = pq.peek()[0];
        }

        return ans;
    }
}