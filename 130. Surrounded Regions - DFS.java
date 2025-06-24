class Solution {
    public boolean dfs(int i,int j,char[][] board, boolean[][] visited, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m) return false;
        if(board[i][j] == 'X' || visited[i][j]) return true;

        visited[i][j] = true;
        return dfs(i + 1, j, board, visited, n, m) && dfs(i - 1, j, board, visited, n, m) && dfs(i, j + 1, board, visited, n, m) && dfs(i, j - 1, board, visited, n, m);
    }
    public void changeDfs(int i, int j, char[][] board, boolean[][] visited, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m) return;
        if(board[i][j] == 'X') return;

        visited[i][j] = false;
        board[i][j] = 'X';

        changeDfs(i + 1, j, board, visited, n, m);
        changeDfs(i - 1, j, board, visited, n, m);
        changeDfs(i, j + 1, board, visited, n, m);
        changeDfs(i, j - 1, board, visited, n, m);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    boolean res = dfs(i, j, board, visited, n, m);
                    if(res){ 
                        changeDfs(i, j, board, visited, n, m);
                        // System.out.println(i + " "  + j);
                    }
                    visited = new boolean[n][m];
                }
            }
        }
    }
}