class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0, j = 0, n = nums.length;
        for (int a : nums) {
            while (j < n && nums[j] <= a + k) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            while (i < n && nums[i] < a - k) {
                count.put(nums[i], count.get(nums[i]) - 1);
                i++;
            }
            int cur = Math.min(j - i, count.getOrDefault(a, 0) + numOperations);
            res = Math.max(res, cur);
        }

        for (i = 0, j = 0; j < n; j++) {
            while (i < n && nums[i] + k + k < nums[j]) {
                i++;
            }
            res = Math.max(res, Math.min(j - i + 1, numOperations));
        }
        return res;
    }
}