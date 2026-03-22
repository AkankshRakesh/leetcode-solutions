class Solution {
    public int dfs(int[][] grid, int[][][] dp, int x1, int y1, int x2){
        int y2 = (x1 + y1) - x2;
        if(x1 >= grid.length || y1 >= grid[0].length || x2 >= grid.length || y2 >= grid[0].length || grid[x1][y1] == -1 || grid[x2][y2] == -1) return Integer.MIN_VALUE;

        if(dp[x1][y1][x2] != -1) return dp[x1][y1][x2];
        if(x1 == grid.length - 1 && y1 == grid[0].length - 1) return grid[x1][y1];

        int cherries = x1 == x2 && y1 == y2 ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2];

        int maxCherries = Math.max(dfs(grid, dp, x1 + 1, y1, x2 + 1), 
            Math.max(dfs(grid, dp, x1 + 1, y1, x2), 
            Math.max(dfs(grid, dp, x1, y1 + 1, x2 + 1), dfs(grid, dp, x1, y1 + 1, x2))
            )
        );

        return dp[x1][y1][x2] = maxCherries == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxCherries + cherries;
    }
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) Arrays.fill(dp[i][j], -1);
        }

        return dfs(grid, dp, 0, 0, 0) == Integer.MIN_VALUE ? 0 : dfs(grid, dp, 0, 0, 0);
    }
}