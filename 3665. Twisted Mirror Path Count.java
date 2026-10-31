class Solution {
    public long dfs(int[][] grid, int i, int j, int pastMove, long[][][] dp){ // pastMove right = 0, down = 1
        if(i >= grid.length || j >= grid[0].length) return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1) return 1;

        if(dp[i][j][pastMove] != -1) return dp[i][j][pastMove];

        long ans = 0;
        if(grid[i][j] == 1){
            if(pastMove == 0){ // right
                ans = dfs(grid, i + 1, j, 1, dp);
            } 
            else{ // down
                ans = dfs(grid, i, j + 1, 0, dp);
            }
        }
        else{
            ans += dfs(grid, i + 1, j, 1, dp) + dfs(grid, i, j + 1, 0, dp);
        }

        return dp[i][j][pastMove] = ans % 1_000_000_007;
    }
    public int uniquePaths(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) Arrays.fill(dp[i][j], -1);
        }

        return (int)dfs(grid, 0, 0, 0, dp);
    }
}