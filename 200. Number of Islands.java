class Solution {
    public void dfs(char[][] grid, int i, int j, int n, int m, boolean[][] visited){
        if(i >= n || j >= m || i < 0 || j < 0) return;
        if(grid[i][j] == '1'){
            if(visited[i][j]) return;
            visited[i][j] = true;

            dfs(grid, i - 1, j, n, m, visited);
            dfs(grid, i + 1, j, n, m, visited);
            dfs(grid, i, j - 1, n, m, visited);
            dfs(grid, i, j + 1, n, m, visited);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, n, m, visited);
                    count++;
                }
            }
        }

        return count;
    }
}