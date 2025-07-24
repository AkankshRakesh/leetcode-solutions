class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        vector<vector<int>> dist(n, vector<int>(m, 0));
        queue<pair<int, int>> q;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (mat[i][j] == 0) {
                    q.push({i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        vector<pair<int, int>> dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.empty()) {
            auto [row, col] = q.front();
            q.pop();

            for (auto [dr, dc] : dir) {
                int nRow = row + dr;
                int nCol = col + dc;

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !visited[nRow][nCol]) {
                    dist[nRow][nCol] = 1 + dist[row][col];
                    q.push({nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
        }
        return dist;
    }
};
