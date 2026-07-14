class Solution {
    int[][][] dp;
    int MOD = 1_000_000_007;

    public int gcd(int a, int b){
        if(a == 0) return b;
        if(b == 0) return a;
        int res = a % b;
        if(res == 0) return b;
        return gcd(b, res);
    }

    public int dfs(int[] nums, int index, int gcd1, int gcd2) {

        if(index == nums.length){
            return (gcd1 != 0 && gcd1 == gcd2) ? 1 : 0;
        }

        if(dp[index][gcd1][gcd2] != -1)
            return dp[index][gcd1][gcd2];

        int ans = 0;

        ans = (ans + dfs(nums, index + 1, gcd1, gcd2)) % MOD;

        ans = (ans + dfs(nums, index + 1, gcd(gcd1, nums[index]), gcd2)) % MOD;

        ans = (ans + dfs(nums, index + 1, gcd1, gcd(gcd2, nums[index]))) % MOD;

        return dp[index][gcd1][gcd2] = ans % MOD;
    }

    public int subsequencePairCount(int[] nums) {

        int max = 0;
        for(int x : nums) max = Math.max(max, x);

        dp = new int[nums.length + 1][max + 1][max + 1];

        for(int i = 0; i <= nums.length; i++)
            for(int j = 0; j <= max; j++)
                Arrays.fill(dp[i][j], -1);

        return dfs(nums, 0, 0, 0);
    }
}