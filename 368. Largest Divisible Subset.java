class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 1, maxInd = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxSize) {
                maxSize = dp[i];
                maxInd = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        int curr = maxInd;
        while(curr != -1) {
            res.add(nums[curr]);
            curr = prev[curr];
        }

        return res;

    }
}