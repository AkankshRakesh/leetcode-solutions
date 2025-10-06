class Solution {
    int min = Integer.MAX_VALUE;
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int maxPathCost){
        int n = grid.length;

        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j]) return;

        maxPathCost = Math.max(maxPathCost, grid[i][j]);

        if (i == n - 1 && j == n - 1) {
            min = Math.min(min, maxPathCost);
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j, maxPathCost);
        dfs(grid, visited, i - 1, j, maxPathCost);
        dfs(grid, visited, i, j + 1, maxPathCost);
        dfs(grid, visited, i, j - 1, maxPathCost);

        visited[i][j] = false;
        
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        dfs(grid, visited, 0, 0, 0);
        return min;
    }
}