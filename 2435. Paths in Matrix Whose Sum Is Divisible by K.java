class Solution {
    int MOD = 1_000_000_007;
    public int backtrack(int[][] grid, int i, int j, int[][][] dp, int curr, int n, int m, int k){
        if(i >= n || j >= m || i < 0 || j < 0) return 0;
        if(i == n - 1 && j == m - 1){
            if((curr + grid[i][j]) % k == 0) return 1;
            return 0;
        }

        int nextCurr = (curr + grid[i][j]) % k;
        if(dp[i][j][nextCurr] != -1) return dp[i][j][nextCurr];
        int down = backtrack(grid, i + 1, j, dp, nextCurr, n, m, k);
        int right = backtrack(grid, i, j + 1, dp, nextCurr, n, m, k);

        dp[i][j][nextCurr] = (down + right) % MOD;
        return dp[i][j][nextCurr];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int z = 0; z < k; z++) dp[i][j][z] = -1;
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         for(int z = 0; z < k; z++) System.out.print(dp[i][j][z] + " ");
        //         System.out.print(", ");
        //     }
        //     System.out.println();
        // }

        return backtrack(grid, 0, 0, dp, 0, n, m, k);
    }
}