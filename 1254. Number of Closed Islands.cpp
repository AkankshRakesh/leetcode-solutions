class Solution {
private:
    static const int dirX[4];
    static const int dirY[4];

public:
    int closedIsland(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));

        queue<vector<int>> q;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    q.push({i, j});

                    bool isIsland = true;
                    while (!q.empty()) {
                        int x = q.front()[0];
                        int y = q.front()[1];
                        q.pop();

                        for (int k = 0; k < 4; k++) {
                            int nextX = dirX[k] + x;
                            int nextY = dirY[k] + y;

                            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                                isIsland = false;
                                continue;
                            }

                            if (grid[nextX][nextY] == 0 && !visited[nextX][nextY])
                                q.push({nextX, nextY});

                            visited[nextX][nextY] = true;
                        }
                    }

                    if (isIsland) ans++;
                }
            }
        }

        return ans;
    }
};

const int Solution::dirX[4] = {0, 1, 0, -1};
const int Solution::dirY[4] = {1, 0, -1, 0};