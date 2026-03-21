class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int endX = x + k, endY = y + k;
        // if(endX )
        for(int i = x; i < (x + (k / 2)); i++){
            for(int j = y; j < endY; j++){
                int temp = grid[i][j];
                // System.out.println(i + " - " + (endX - (i - x) - 1));
                grid[i][j] = grid[endX - (i - x) - 1][j];
                grid[endX - (i - x) - 1][j] = temp;
            }
        }
        return grid;
    }
}