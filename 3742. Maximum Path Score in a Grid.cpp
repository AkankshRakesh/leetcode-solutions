class Solution {
    public int dfs(int[][] grid, int i, int j, int currCost, int[][][] dp, int k){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return -1;
        int nextCost = grid[i][j] == 0 ? currCost: currCost + 1; 
        if(nextCost > k) return -1;

        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(dp[i][j][nextCost] != -1) return dp[i][j][nextCost];

        int down = dfs(grid, i + 1, j, nextCost, dp, k);
        int right = dfs(grid, i, j + 1, nextCost, dp, k);

        if(down == -1 && right == -1) return dp[i][j][nextCost] = -1;
        return dp[i][j][nextCost] = grid[i][j] + Math.max(down, right);
    }
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost <= k; cost++) {

                    if (dp[i][j][cost] == -1) continue;

                    if (j + 1 < n) {
                        int val = grid[i][j + 1];
                        int newCost = cost + (val == 0 ? 0 : 1);

                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(
                                dp[i][j + 1][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }

                    if (i + 1 < m) {
                        int val = grid[i + 1][j];
                        int newCost = cost + (val == 0 ? 0 : 1);

                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(
                                dp[i + 1][j][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans == -1 ? -1 : ans;
    }
}