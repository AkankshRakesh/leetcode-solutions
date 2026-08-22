class Solution {
    public long solve(int curr, int low, int high, int zero, int one, long[] dp){
        if(curr > high) return 0;
        if(dp[curr] != -1) return dp[curr];

        long res = solve(curr + zero, low, high, zero, one, dp) + solve(curr + one, low, high, zero, one, dp);

        if(curr >= low) return dp[curr] = (res + 1) % 1_000_000_007;
        return dp[curr] = res % 1_000_000_007;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        Arrays.fill(dp, -1);

        return (int)solve(0, low, high, zero, one, dp);
    }
}