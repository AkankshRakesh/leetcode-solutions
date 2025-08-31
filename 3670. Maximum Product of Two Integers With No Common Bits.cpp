class Solution {
    public long maxProduct(int[] nums) {
        int maxNum = 0;
        for (int num : nums) maxNum = Math.max(maxNum, num);
        int bitMask = 32 - Integer.numberOfLeadingZeros(maxNum);
        int MAX_MASK = 1 << bitMask;
        int[] dp = new int[MAX_MASK];
        for (int num : nums) {
            int val = 0, x = num;
            while (x > 0) {
                int bit = Integer.numberOfTrailingZeros(x);
                val |= (1 << bit);
                x &= (x - 1);
            }
            dp[val] = Math.max(dp[val], num);
        }
        for (int bit = 0; bit < bitMask; bit++) {
            for (int mask = 0; mask < MAX_MASK; mask++) {
                if ((mask & (1 << bit)) != 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << bit)]);
                }
            }
        }
        long maxProd = 0;
        for (int num : nums) {
            int val = 0, x = num;
            while (x > 0) {
                int bit = Integer.numberOfTrailingZeros(x);
                val |= (1 << bit);
                x &= (x - 1);
            }
            int complement = ((1 << bitMask) - 1) ^ val;
            maxProd = Math.max(maxProd, (long) num * dp[complement]);
        }
        return maxProd;
    }
}