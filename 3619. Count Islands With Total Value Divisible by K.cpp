#include <vector>

class Solution {
public:
    int dfs(std::vector<std::vector<int>>& grid, int i, int j, int n, int m, std::vector<std::vector<bool>>& visited) {
        if (i >= n || j >= m || i < 0 || j < 0) return 0;
        if (grid[i][j] == 0 || visited[i][j]) return 0;

        visited[i][j] = true;
        int val = dfs(grid, i + 1, j, n, m, visited) +
                  dfs(grid, i, j + 1, n, m, visited) +
                  dfs(grid, i - 1, j, n, m, visited) +
                  dfs(grid, i, j - 1, n, m, visited) +
                  grid[i][j];

        return val;
    }

    int countIslands(std::vector<std::vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        std::vector<std::vector<bool>> visited(n, std::vector<bool>(m, false));

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int val = dfs(grid, i, j, n, m, visited);
                    if (val % k == 0) ans++;
                }
            }
        }

        return ans;
    }
};
