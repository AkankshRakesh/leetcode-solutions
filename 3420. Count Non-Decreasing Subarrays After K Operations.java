class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long operations = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        List<List<Integer>> cnt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cnt.add(new ArrayList<>());
        }
        int[] pos = new int[n];
        Arrays.fill(pos, n);
        Deque<Integer> st = new ArrayDeque<>();

        for (int left = 0, right = 0; right < n; right++) {
            while (!st.isEmpty() && nums[right] >= nums[st.peek()]) {
                pos[st.peek()] = right;
                st.pop();
            }
            if (!st.isEmpty()) {
                cnt.get(st.peek()).add(right);
            }
            st.push(right);

            q.offer(new int[] { nums[right], right });
            operations += Math.max(0, q.peek()[0] - nums[right]);

            while (operations > k) {
                for (int i : cnt.get(left)) {
                    operations -=
                        (long) (nums[left] - nums[i]) *
                        (Math.min(pos[i], right + 1) - i);
                }
                left++;
            }

            while (!q.isEmpty() && q.peek()[1] < left) {
                q.poll();
            }

            ans += right - left + 1;
        }

        return ans;
    }
}