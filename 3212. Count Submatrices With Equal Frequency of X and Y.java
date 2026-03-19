class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int count = 0;
        boolean[][] XFound = new boolean[grid.length][grid[0].length];
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                int top = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int diag = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;

                dp[i][j] = (left + top) - diag;
                if(grid[i][j] == 'X'){
                    dp[i][j]++;
                    XFound[i][j] = true;
                }
                else if(grid[i][j] == 'Y') dp[i][j]--;

                XFound[i][j] = XFound[i][j] || (i - 1 >= 0 ? XFound[i - 1][j] : false) || (j - 1 >= 0 ? XFound[i][j - 1] : false) || (i - 1 >= 0 && j - 1 >= 0 ? XFound[i - 1][j - 1] : false);

                if(dp[i][j] == 0 && XFound[i][j]) count++;
            }
        }
        
        return count;
    }
}