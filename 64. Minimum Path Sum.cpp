class Solution {
public:
    int minPathSum(std::vector<std::vector<int>>& grid) {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (i == 0 && j == 0) continue;
                int top = i - 1 >= 0 ? grid[i - 1][j] : INT_MAX;
                int left = j - 1 >= 0 ? grid[i][j - 1] : INT_MAX;
                grid[i][j] += std::min(top, left);
            }
        }
        return grid[grid.size() - 1][grid[0].size() - 1];
    }
};