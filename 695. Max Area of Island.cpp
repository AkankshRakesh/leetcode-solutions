class Solution {
public:
    void dfs(int i, int j, int& count, vector<vector<int>>& grid, vector<vector<bool>>& visited, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        count++;

        dfs(i + 1, j, count, grid, visited, n, m);
        dfs(i - 1, j, count, grid, visited, n, m);
        dfs(i, j + 1, count, grid, visited, n, m);
        dfs(i, j - 1, count, grid, visited, n, m);
    }

    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        int maxSize = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int count = 0;
                    dfs(i, j, count, grid, visited, n, m);
                    maxSize = max(maxSize, count);
                }
            }
        }

        return maxSize;
    }
};
