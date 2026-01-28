class Solution {
    public int dfs(int[][] matrix, int i, int j, int[][] dp, boolean[][] visited, int prev){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) return 0;
        if(dp[i][j] != 0) return dp[i][j];

        return dp[i][j] = 1 + Math.max(dfs(matrix, i + 1, j, dp, visited, matrix[i][j]), Math.max(dfs(matrix, i - 1, j, dp, visited, matrix[i][j]), Math.max(dfs(matrix, i, j + 1, dp, visited, matrix[i][j]), dfs(matrix, i, j - 1, dp, visited, matrix[i][j]))));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 1;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                dfs(matrix, i, j, dp, visited, Integer.MIN_VALUE);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}