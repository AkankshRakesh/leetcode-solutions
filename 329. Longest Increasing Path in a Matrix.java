class Solution {
    public int dfs(int[][] matrix, int i, int j, int past, int[][] dp, boolean[][] visited){
        if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] <= past || visited[i][j]) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        visited[i][j] = true;

        int res = 0;
        res = Math.max(res, 1 + dfs(matrix, i + 1, j, matrix[i][j], dp, visited));
        res = Math.max(res, 1 + dfs(matrix, i - 1, j, matrix[i][j], dp, visited));
        res = Math.max(res, 1 + dfs(matrix, i, j + 1, matrix[i][j], dp, visited));
        res = Math.max(res, 1 + dfs(matrix, i, j - 1, matrix[i][j], dp, visited));

        visited[i][j] = false;

        return dp[i][j] = res;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        int ans = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(matrix, i, j, -1, dp, visited));
            }
        }

        return ans;
    }
}