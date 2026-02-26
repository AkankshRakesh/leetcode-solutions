class Solution {
    public int MOD = 1_000_000_007;
    public long dfs(int[][] grid, boolean[][] visited, int i, int j, int past, int[][] dp){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= past || visited[i][j]) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        visited[i][j] = true;
        
        long ans = 1;
        ans += dfs(grid, visited, i + 1, j, grid[i][j], dp) + dfs(grid, visited, i, j - 1, grid[i][j], dp) + dfs(grid, visited, i, j + 1, grid[i][j], dp) + dfs(grid, visited, i - 1, j, grid[i][j], dp);
        ans %= MOD; 

        visited[i][j] = false;
        return dp[i][j] = (int)ans;
    }
    public int countPaths(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) Arrays.fill(dp[i], -1);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans = (ans + (int)dfs(grid, visited, i, j, -1, dp)) % MOD;
            }
        }

        return ans;
    }
}