class Solution {
    int ans = 0;
    public boolean check(boolean[][] queens, int x, int y){
        int n = queens.length;
        for(int j = y; j >= 0; j--) if(queens[x][j]) return false;
        for(int i = x; i >= 0; i--) if(queens[i][y]) return false;

        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) if(queens[i][j]) return false;
        for(int i = x, j = y; i >= 0 && j < n; i--, j++) if(queens[i][j]) return false;

        return true;
    }
    public void backtrack(boolean[][] queens, int row){
        int n = queens.length;
        if(row >= n){
            ans++;
            return;
        }

        for(int col = 0; col < n; col++){
            if(check(queens, row, col)){
                queens[row][col] = true;
                backtrack(queens, row + 1);
                queens[row][col] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        backtrack(queens, 0);
        return ans;
    }
}