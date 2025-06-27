class Solution {
    public void dfs(int i, int j, int[] count, int[][] grid, boolean[][] visited, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m) return;
        if(grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        count[0]++;

        dfs(i + 1, j, count, grid, visited, n, m);
        dfs(i - 1, j, count, grid, visited, n, m);
        dfs(i, j + 1, count, grid, visited, n, m);
        dfs(i, j - 1, count, grid, visited, n, m);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxSize = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int[] count = new int[1];
                    dfs(i, j, count, grid, visited, n, m);
                    maxSize = maxSize > count[0] ? maxSize : count[0];
                }
            }
        }

        return maxSize;
    }
}