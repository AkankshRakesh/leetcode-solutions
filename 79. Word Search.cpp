class Solution {
public:
    bool trav(vector<vector<char>>& board, vector<vector<bool>>& visited, string& word, int currInd, int x, int y, int n, int m, int strLen) {
        if (currInd >= strLen) return true;
        if (x >= n || y >= m || x < 0 || y < 0) return false;

        if (board[x][y] == word[currInd] && !visited[x][y]) {
            visited[x][y] = true;
            bool found = trav(board, visited, word, currInd + 1, x + 1, y, n, m, strLen) ||
                         trav(board, visited, word, currInd + 1, x, y + 1, n, m, strLen) ||
                         trav(board, visited, word, currInd + 1, x - 1, y, n, m, strLen) ||
                         trav(board, visited, word, currInd + 1, x, y - 1, n, m, strLen);
            if (found) return true;
            visited[x][y] = false;
        }
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) {
        int n = board.size();
        int m = board[0].size();
        int strLen = word.length();
        bool ans = false;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                vector<vector<bool>> visited(n, vector<bool>(m, false));
                ans = trav(board, visited, word, 0, i, j, n, m, strLen);
                if (ans) return ans;
            }
        }
        return ans;
    }
};
