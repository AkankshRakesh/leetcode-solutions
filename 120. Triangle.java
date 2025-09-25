class Solution {
    int ans = Integer.MAX_VALUE;
    public int backtrack(List<List<Integer>> triangle, int[][] dp, int i, int j,int  n){
        if(i == n - 1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = backtrack(triangle, dp, i + 1, j, n);
        int right = backtrack(triangle, dp, i + 1, j + 1, n);
        dp[i][j] = triangle.get(i).get(j) + Math.min(left, right);
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) for(int j = 0; j <= n; j++) dp[i][j] = Integer.MAX_VALUE;

        dp[0][0] = backtrack(triangle, dp, 0, 0, n);
        return dp[0][0];
    }
}