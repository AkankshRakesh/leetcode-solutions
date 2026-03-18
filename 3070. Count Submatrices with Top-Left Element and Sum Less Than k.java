class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                int top = i - 1 >= 0 ? grid[i - 1][j] : 0;
                int diag = i - 1 >= 0 && j - 1 >= 0 ? grid[i - 1][j - 1] : 0;

                grid[i][j] += (top + left - diag);
                if(grid[i][j] <= k) ans++;
            }
        }
        
        return ans;
    }
}