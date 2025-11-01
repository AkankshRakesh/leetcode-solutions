class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean check(boolean[][] queens, int row, int col){
        int n = queens.length;
        for (int i = 0; i < row; i++)
            if (queens[i][col]) return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (queens[i][j]) return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (queens[i][j]) return false;

        return true;
    }

    public void backtrack(int x, int n, boolean[][] queens){
        // if(x >= queens.length) return;
        if(n == 0){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < queens.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < queens.length; j++){
                    if(queens[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for(int col = 0; col < queens.length; col++){
            if(check(queens, x, col)){
                queens[x][col] = true;
                backtrack(x + 1, n - 1, queens);
                queens[x][col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][] queens = new boolean[n][n];
        backtrack(0, n, queens);
        // System.out.println(check(queens, 0, 0));
        return ans;
    }
}