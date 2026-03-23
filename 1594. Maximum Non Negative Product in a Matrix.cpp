class Solution {
    public static int MOD = 1_000_000_007;
    public long dfs(int[][] grid, long[][] dpMax, long[][] dpMin, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return -1;
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(dpMax[i][j] != -1 && dpMin[i][j] != -1) return Math.max(dpMax[i][j], dpMin[i][j]);
        
        if(grid[i][j] >= 0){
            dpMax[i][j] = Math.max(dfs(grid, dpMax, dpMin, i + 1, j), dfs(grid, dpMax, dpMin, i, j + 1)) * grid[i][j];
            dpMin[i][j] = Math.min(dfs(grid, dpMax, dpMin, i + 1, j), dfs(grid, dpMax, dpMin, i, j + 1)) * grid[i][j];
        }
        else{
            dpMax[i][j] = Math.min(dfs(grid, dpMax, dpMin, i + 1, j), dfs(grid, dpMax, dpMin, i, j + 1)) * grid[i][j];
            dpMin[i][j] = Math.max(dfs(grid, dpMax, dpMin, i + 1, j), dfs(grid, dpMax, dpMin, i, j + 1)) * grid[i][j];
        }

        return Math.max(dpMax[i][j], dpMin[i][j]) % MOD;
    }
    public int maxProductPath(int[][] grid) {
        long[][] dpMax = new long[grid.length][grid[0].length];
        long[][] dpMin = new long[grid.length][grid[0].length];
        dpMax[0][0] = dpMin[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dpMax[0][i] = dpMin[0][i] = dpMax[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dpMax[i][0] = dpMin[i][0] = dpMax[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] >= 0) {
                    dpMax[i][j] =
                        Math.max(dpMax[i][j - 1], dpMax[i - 1][j]) * grid[i][j];
                    dpMin[i][j] =
                        Math.min(dpMin[i][j - 1], dpMin[i - 1][j]) * grid[i][j];
                } else {
                    dpMax[i][j] =
                        Math.min(dpMin[i][j - 1], dpMin[i - 1][j]) * grid[i][j];
                    dpMin[i][j] =
                        Math.max(dpMax[i][j - 1], dpMax[i - 1][j]) * grid[i][j];
                }
            }
        }

        if(dpMax[grid.length - 1][grid[0].length - 1] < 0) return -1;
        return (int)(dpMax[grid.length - 1][grid[0].length - 1] % MOD);
    }
}