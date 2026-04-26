class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean dfs(char[][] grid, char ch, int i, int j, boolean[][] visited, int pi, int pj){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j]) return false;
        visited[i][j] = true;

        for(int[] dir : dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
                if(grid[x][y] != ch) continue;
                if(visited[x][y] && x != pi && y != pj) return true;

                if(dfs(grid, ch, x, y, visited, i, j)) return true;
            }
        }
        
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j]){
                    if(dfs(grid, grid[i][j], i, j, visited, -1, -1)) return true;
                }
            }
        }

        return false;
    }
}