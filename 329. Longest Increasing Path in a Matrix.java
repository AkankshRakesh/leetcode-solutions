class Solution {
    public int trav(int[][] matrix, int[][] memo, int lastEle, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m) return 0;

        if(lastEle >= matrix[i][j]) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int found = 1 + Math.max(trav(matrix,memo, matrix[i][j], i + 1, j, n, m), Math.max(trav(matrix,memo, matrix[i][j], i - 1, j, n, m), Math.max(trav(matrix, memo, matrix[i][j], i, j + 1, n, m), trav(matrix,memo, matrix[i][j], i, j - 1, n, m))));

        memo[i][j] = found;
        return found;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int max = 1;
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) memo[i][j] = -1;
        }

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(memo[i][j] != -1){
                    max = Math.max(max, memo[i][j]);
                    continue;
                }

                int found = 1 + Math.max(trav(matrix,memo, matrix[i][j], i + 1, j, n, m), Math.max(trav(matrix,memo, matrix[i][j], i - 1, j, n, m), Math.max(trav(matrix, memo, matrix[i][j], i, j + 1, n, m), trav(matrix,memo, matrix[i][j], i, j - 1, n, m))));
                memo[i][j] = found;
                max = Math.max(max, found);
            }
        }

        return max;
    }
}