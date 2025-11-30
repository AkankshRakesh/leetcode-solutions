class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) totalSum = (totalSum + num) % p;

        int target = totalSum % p;
        if (target == 0) return 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int currSum = 0;
        int minLen = n;

        for (int i = 0; i < n; ++i) {
            currSum = (currSum + nums[i]) % p;

            int needed = (currSum - target + p) % p;

            if (hm.containsKey(needed)) {
                minLen = Math.min(minLen, i - hm.get(needed));
            }

            hm.put(currSum, i);
        }

        return minLen == n ? -1 : minLen;
    }
}