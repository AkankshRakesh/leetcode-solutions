class Solution {
    public boolean canPlace(boolean[][] queens, int row, int col){
        if(row >= queens.length) return false;
        for(int i = row; i >= 0; i--) if(queens[i][col]) return false;

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(queens[i][j]) return false;
        }

        for(int i = row, j = col; i >= 0 && j < queens.length; i--, j++){
            if(queens[i][j]) return false;
        }
        
        return true;
    }

    public int backtrack(boolean[][] queens, int row, int n, int currQueens){
        if(row >= n) return 1;
        // System.out.println(row);

        int res = 0;
        for(int col = 0; col < n; col++){
            if(canPlace(queens, row, col)){
                queens[row][col] = true;
                res += backtrack(queens, row + 1, n, currQueens + 1);
                queens[row][col] = false;
            }
        }

        return res;
    }
    public int totalNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        return backtrack(queens, 0, n, 0);
    }
}