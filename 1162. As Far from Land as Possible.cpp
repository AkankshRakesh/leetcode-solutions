class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));

        queue<vector<int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) q.push({i, j, i, j});
            }
        }

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.front()[0];
                int y = q.front()[1];
                int landX = q.front()[2];
                int landY = q.front()[3];
                q.pop();

                int right = abs(landX - (x + 1)) + abs(landY - y);
                int left = abs(landX - (x - 1)) + abs(landY - y);
                int top = abs(landX - x) + abs(landY - (y - 1));
                int bottom = abs(landX - x) + abs(landY - (y + 1));

                if (x + 1 < n && grid[x + 1][y] != 1 && (dp[x + 1][y] == -1 || dp[x + 1][y] > right)) {
                    dp[x + 1][y] = right;
                    q.push({x + 1, y, landX, landY});
                }
                if (x - 1 >= 0 && grid[x - 1][y] != 1 && (dp[x - 1][y] == -1 || dp[x - 1][y] > left)) {
                    dp[x - 1][y] = left;
                    q.push({x - 1, y, landX, landY});
                }

                if (y + 1 < n && grid[x][y + 1] != 1 && (dp[x][y + 1] == -1 || dp[x][y + 1] > bottom)) {
                    dp[x][y + 1] = bottom;
                    q.push({x, y + 1, landX, landY});
                }
                if (y - 1 >= 0 && grid[x][y - 1] != 1 && (dp[x][y - 1] == -1 || dp[x][y - 1] > top)) {
                    dp[x][y - 1] = top;
                    q.push({x, y - 1, landX, landY});
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1 && dp[i][j] > ans) ans = dp[i][j];
            }
        }

        return ans;
    }
};

