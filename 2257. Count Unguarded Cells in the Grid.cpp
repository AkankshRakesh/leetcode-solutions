class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        int res = m * n - (int)walls.size() - (int)guards.size();
        int grid[m][n];
        memset(grid, 0, sizeof(grid));
        for (auto& wall : walls)
            grid[wall[0]][wall[1]] = 1;
        for (auto& guard : guards)
            grid[guard[0]][guard[1]] = 2;
        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] != 2)
                    continue;
                for (int i = r - 1; i >= 0 && grid[i][c] <= 0; i--){
                    if (!grid[i][c]){
                        res--;
                        grid[i][c] = -1;
                    }
                }
                // down
                for (int i = r + 1; i < m && grid[i][c] <= 0; i++){
                    if (!grid[i][c]){
                        res--;
                        grid[i][c] = -1;
                    }
                }
                // left
                for (int i = c - 1; i >= 0 && grid[r][i] <= 0; i--){
                    if (!grid[r][i]){
                        grid[r][i] = -1;
                        res--;
                    }
                }
                // right
                for (int i = c + 1; i < n && grid[r][i] <= 0; i++){
                    if (!grid[r][i]){
                        res--;
                        grid[r][i] = -1;
                    }
                }
            }
        }
        return res;    
    }
};