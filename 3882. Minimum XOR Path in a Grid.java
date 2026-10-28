class Solution {
    public int dfs(int[][] grid, int i, int j, int xor, int[][][] dp){
        if(i >= grid.length || j >= grid[0].length) return -1;
        if(i == grid.length - 1 && j == grid[0].length - 1) return xor ^ grid[i][j];
        
        if(dp[i][j][xor] != -1) return dp[i][j][xor];

        int right = dfs(grid, i, j + 1, xor ^ grid[i][j], dp);
        int down = dfs(grid, i + 1, j, xor ^ grid[i][j], dp);

        right = right == -1 ? Integer.MAX_VALUE : right;
        down = down == -1 ? Integer.MAX_VALUE : down;

        return dp[i][j][xor] = Math.min(right, down);
    }
    public int minCost(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][1024];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) Arrays.fill(dp[i][j], -1);
        }

        return dfs(grid, 0, 0, 0, dp);
    }
}