#include <vector>
using namespace std;

class Solution {
public:
    void dfs(vector<vector<int>>& grid, int i, int j, int n, int m, int dist) {
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (grid[i][j] == -1) return;       
        if (grid[i][j] < dist) return; 

        grid[i][j] = dist;

        dfs(grid, i + 1, j, n, m, dist + 1);
        dfs(grid, i - 1, j, n, m, dist + 1);
        dfs(grid, i, j + 1, n, m, dist + 1);
        dfs(grid, i, j - 1, n, m, dist + 1);
    }

    void islandsAndTreasure(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) { // Gate
                    dfs(grid, i + 1, j, n, m, 1);
                    dfs(grid, i - 1, j, n, m, 1);
                    dfs(grid, i, j + 1, n, m, 1);
                    dfs(grid, i, j - 1, n, m, 1);
                }
            }
        }
    }
};
