class Solution {
    public boolean colWiseSum(int[][] grid, long target){
        long sum = 0;
        for(int j = 0; j < grid[0].length; j++){
            for(int i = 0; i < grid.length; i++) sum += grid[i][j];
            if(sum == target) return true; 
        }

        return false;
    }
    public boolean rowWiseSum(int[][] grid, long target){
        long sum = 0;
        for(int[] row : grid){
            for(int col : row) sum += col;
            if(sum == target) return true;
        }

        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        for(int[] row : grid){
            for(int col : row) sum += col;
        }
        if(sum % 2 != 0) return false;

        long target = sum / 2;
        return rowWiseSum(grid, target) || colWiseSum(grid, target);
    }
}