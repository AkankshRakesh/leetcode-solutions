class Solution {
public:
    int ans = 0;

    bool check(vector<vector<bool>>& queens, int x, int y) {
        int n = queens.size();

        for (int j = y; j >= 0; j--)
            if (queens[x][j]) return false;

        for (int i = x; i >= 0; i--)
            if (queens[i][y]) return false;

        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--)
            if (queens[i][j]) return false;

        for (int i = x, j = y; i >= 0 && j < n; i--, j++)
            if (queens[i][j]) return false;

        return true;
    }

    void backtrack(vector<vector<bool>>& queens, int row) {
        int n = queens.size();
        if (row >= n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(queens, row, col)) {
                queens[row][col] = true;
                backtrack(queens, row + 1);
                queens[row][col] = false;
            }
        }
    }

    int totalNQueens(int n) {
        vector<vector<bool>> queens(n, vector<bool>(n, false));
        backtrack(queens, 0); 
        return ans;
    }
};
