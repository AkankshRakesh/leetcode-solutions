class Solution {
    public void dfs(int[][] grid, int[][] minTime,int currTime, int i, int j, int n, int m){
        if(i >= n || j >= m || i < 0 || j < 0) return;
        if(grid[i][j] == 0 || grid[i][j] == 2) return;
        if(minTime[i][j] <= currTime) return;
        minTime[i][j] = Math.min(minTime[i][j], currTime);

        dfs(grid, minTime, currTime + 1, i + 1, j, n, m);
        dfs(grid, minTime, currTime + 1, i - 1, j, n, m);
        dfs(grid, minTime, currTime + 1, i, j + 1, n, m);
        dfs(grid, minTime, currTime + 1, i, j - 1, n, m);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] minTime = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    dfs(grid, minTime, 1, i + 1, j, n, m);
                    dfs(grid, minTime, 1, i - 1, j, n, m);
                    dfs(grid, minTime, 1, i, j + 1, n, m);
                    dfs(grid, minTime, 1, i, j - 1, n, m);
                }
            }
        }

        int maxTime = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) maxTime = Math.max(maxTime, minTime[i][j]);
            }
        }
        if(maxTime == Integer.MAX_VALUE) return -1;
        return maxTime;
    }
}