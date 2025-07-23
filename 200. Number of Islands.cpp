class Solution {
public:
    void dfs(vector<vector<char>>& grid, int i, int j, int n, int m, vector<vector<bool>>& visited) {
        if (i >= n || j >= m || i < 0 || j < 0) return;
        if (grid[i][j] == '1') {
            if (visited[i][j]) return;
            visited[i][j] = true;

            dfs(grid, i - 1, j, n, m, visited);
            dfs(grid, i + 1, j, n, m, visited);
            dfs(grid, i, j - 1, n, m, visited);
            dfs(grid, i, j + 1, n, m, visited);
        }
    }

    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, n, m, visited);
                    count++;
                }
            }
        }

        return count;
    }
};
