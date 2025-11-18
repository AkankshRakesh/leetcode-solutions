class Solution {
public:
    int backtrack(vector<vector<int>>& grid, vector<vector<bool>>& visited,
                  int x, int y, int n, int m) {

        if (x >= n || y >= m || x < 0 || y < 0 || visited[x][y] || grid[x][y] == -1)
            return 0;

        if (grid[x][y] == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 0 && !visited[i][j])
                        return 0;
                }
            }
            return 1;
        }

        visited[x][y] = true;

        int res = 0;
        res += backtrack(grid, visited, x + 1, y, n, m);
        res += backtrack(grid, visited, x - 1, y, n, m);
        res += backtrack(grid, visited, x, y + 1, n, m);
        res += backtrack(grid, visited, x, y - 1, n, m);

        visited[x][y] = false;
        return res;
    }

    int uniquePathsIII(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<bool>> visited(n, vector<bool>(m, false));

        int stIndX = -1, stIndY = -1;
        for (int i = 0; i < n; i++) {
            bool found = false;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    stIndX = i;
                    stIndY = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        return backtrack(grid, visited, stIndX, stIndY, n, m);
    }
};
