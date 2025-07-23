class Solution {
    public void dfs(int[][] grid, int i, int j, int n, int m, int dist, int[][] leastTime){
        if(i >= n || j >= m || i < 0 || j < 0) return;
        if(grid[i][j] == 0 || grid[i][j] == 2) return;

        if (leastTime[i][j] <= dist) return;
        leastTime[i][j] = dist;

        
        dfs(grid, i + 1, j, n, m, dist + 1, leastTime);
        dfs(grid, i - 1, j, n, m, dist + 1, leastTime);
        dfs(grid, i, j + 1, n, m, dist + 1, leastTime);
        dfs(grid, i, j - 1, n, m, dist + 1, leastTime);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] leastTime = new int[n][m];
        
        for (int[] r : leastTime)
            Arrays.fill(r, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i + 1, j, n, m, 1, leastTime);
                    dfs(grid, i - 1, j, n, m, 1, leastTime);
                    dfs(grid, i, j + 1, n, m, 1, leastTime);
                    dfs(grid, i, j - 1, n, m, 1, leastTime);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    if(leastTime[i][j] == Integer.MAX_VALUE) return -1;
                    ans = Math.max(ans, leastTime[i][j]);
                }
            }
        }

        return ans;
    }
}