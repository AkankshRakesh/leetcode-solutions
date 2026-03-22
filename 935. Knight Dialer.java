class Solution {
    public int MOD = 1_000_000_007;
    public long dfs(int[][] grid, long[][][] dp, int n, int i, int j){
        if(i >= 4 || j >= 3 || i < 0 || j < 0 || grid[i][j] == -1) return 0;
        if(n == 0) return 1;
        if(dp[n][i][j] != -1) return dp[n][i][j];

        return dp[n][i][j] = (dfs(grid, dp, n - 1, i - 2, j - 1) + dfs(grid, dp, n - 1, i - 2, j + 1) + dfs(grid, dp, n - 1, i + 2, j - 1) + dfs(grid, dp, n - 1, i + 2, j + 1) + dfs(grid, dp, n - 1, i + 1, j - 2) + dfs(grid, dp, n - 1, i - 1, j - 2) + dfs(grid, dp, n - 1, i + 1, j + 2) + dfs(grid, dp, n - 1, i - 1, j + 2)) % MOD;
    }
    public int knightDialer(int n) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        long[][][] dp = new long[n + 1][4][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 4; j++) Arrays.fill(dp[i][j], -1);
        }
        
        int ans = 0;
        ans = (ans + (int)dfs(grid, dp, n - 1, 3, 1)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 0, 0)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 0, 1)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 0, 2)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 1, 0)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 1, 1)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 1, 2)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 2, 0)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 2, 1)) % MOD;
        ans = (ans + (int)dfs(grid, dp, n - 1, 2, 2)) % MOD;

        return ans;
    }
}