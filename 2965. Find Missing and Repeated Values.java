class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int map[] = new int[n * n + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(map[grid[i][j]] >= 0) map[grid[i][j]]++;
                else map[grid[i][j]] = 1;

            }
        }
        int ans[] = new int[2];
        for(int i = 0; i <= n*n; i++){
            if(map[i] == 2) ans[0] = i;
            if(map[i] == 0) ans[1] = i;
        }
        return ans;
    }
}
