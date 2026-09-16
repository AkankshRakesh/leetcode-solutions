class Solution {
    public long dfs(int index, int kVal, int n, int k, long[][] dp){
        if(kVal <= 0) return 1;
        if(index >= n) return 0;

        if(dp[index][kVal] != -1) return dp[index][kVal];

        long res = 0;
        for(int i = index + 1; i < n; i++){
            res += dfs(i, kVal - 1, n, k, dp);
        }
        res += dfs(index + 1, kVal, n, k, dp);

        return dp[index][kVal] = res % (1_000_000_007);
    }
    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n][k + 1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return (int)dfs(0, k, n, k, dp);
    }
}