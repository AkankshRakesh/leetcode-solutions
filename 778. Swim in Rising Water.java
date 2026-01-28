class Solution {
    public boolean dfs(int[][] grid, int i, int j, int cost, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] > cost) return false;
        if(i == grid.length - 1 && j == grid[0].length - 1) return true;

        visited[i][j] = true;
        return dfs(grid, i + 1, j, cost, visited) | dfs(grid, i - 1, j, cost, visited) | dfs(grid, i, j + 1, cost, visited) | dfs(grid, i, j - 1, cost, visited);
    }
    public int swimInWater(int[][] grid) {
        int left = 0, right = grid.length * grid.length;
        int ans = Integer.MAX_VALUE;

        while(left < right){
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            if(dfs(grid, 0, 0, mid, visited)){
                ans = mid;
                right = mid;
            }
            else left = mid + 1;
        }

        return ans;
    }
}