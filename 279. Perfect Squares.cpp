class Solution {
    public int backtrack(ArrayList<Integer> arr, int[] dp, int target) {
        if (target == 0) return 0;
        if (target < 0) return Integer.MAX_VALUE;
        
        if (dp[target] != -1) return dp[target];
        
        int ans = Integer.MAX_VALUE;
        for (int square : arr) {
            int res = backtrack(arr, dp, target - square);
            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, res + 1);
            }
        }
        dp[target] = ans;
        return dp[target];
    }

    public int numSquares(int n) {
        ArrayList<Integer> ps = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) ps.add(i * i);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = backtrack(ps, dp, n);
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
