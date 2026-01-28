class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                int curr = 0;
                if(i + 1 >= grid.length || grid[i + 1][j] == 0) curr++;
                if(j + 1 >= grid[0].length || grid[i][j + 1] == 0) curr++;
                if(i - 1 < 0 || grid[i - 1][j] == 0) curr++;
                if(j - 1 < 0 || grid[i][j - 1] == 0) curr++;
                ans += curr;
            }
        }

        return ans;
    }
}