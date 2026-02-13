class Solution {
    public boolean dfs(int[][] grid, int i, int j, int max, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] > max || visited[i][j]) return false;
        if(i == grid.length - 1 && j == grid[0].length - 1) return true;
        visited[i][j] = true;
        
        return dfs(grid, i + 1, j, max, visited) | 
        dfs(grid, i - 1, j, max, visited) |
        dfs(grid, i, j + 1, max, visited) |
        dfs(grid, i, j - 1, max, visited);
    }
    public int swimInWater(int[][] grid) {
        int left = 0;
        int right = grid.length * grid.length;
        while(left < right){
            boolean[][] visited = new boolean[grid.length][grid.length];
            int mid = left + (right - left) / 2;
            if(dfs(grid, 0, 0, mid, visited)) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}