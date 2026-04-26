class Solution {
    vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

public:
    bool dfs(const vector<vector<char>>& grid, char ch, int i, int j, vector<vector<bool>>& visited, int pi, int pj) {
        if (i < 0 || j < 0 || i >= (int)grid.size() || j >= (int)grid[0].size() || visited[i][j]) return false;
        visited[i][j] = true;

        for (const auto& dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && y >= 0 && x < (int)grid.size() && y < (int)grid[0].size()) {
                if (grid[x][y] != ch) continue;
                if (visited[x][y] && (x != pi || y != pj)) return true;

                if (dfs(grid, ch, x, y, visited, i, j)) return true;
            }
        }

        return false;
    }

    bool containsCycle(const vector<vector<char>>& grid) {
        int m = (int)grid.size();
        int n = (int)grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, grid[i][j], i, j, visited, -1, -1)) return true;
                }
            }
        }
        return false;
    }
};