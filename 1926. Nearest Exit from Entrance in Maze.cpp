class Solution {
public:
    int nearestExit(std::vector<std::vector<char>>& maze, std::vector<int>& entrance) {
        int m = maze.size();
        int n = maze[0].size();
        std::vector<std::vector<int>> dist(m, std::vector<int>(n, -1));
        
        dist[entrance[0]][entrance[1]] = 0;
        std::queue<std::pair<int,int>> q;
        q.emplace(entrance[0], entrance[1]);
        
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            
            if (x + 1 < m && maze[x + 1][y] != '+' && dist[x + 1][y] == -1) {
                dist[x + 1][y] = dist[x][y] + 1;
                q.emplace(x + 1, y);
            }
            if (y + 1 < n && maze[x][y + 1] != '+' && dist[x][y + 1] == -1) {
                dist[x][y + 1] = dist[x][y] + 1;
                q.emplace(x, y + 1);
            }
            if (y - 1 >= 0 && maze[x][y - 1] != '+' && dist[x][y - 1] == -1) {
                dist[x][y - 1] = dist[x][y] + 1;
                q.emplace(x, y - 1);
            }
            if (x - 1 >= 0 && maze[x - 1][y] != '+' && dist[x - 1][y] == -1) {
                dist[x - 1][y] = dist[x][y] + 1;
                q.emplace(x - 1, y);
            }
        }
        
        int ans = INT_MAX;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (dist[i][j] != -1 && dist[i][j] != 0) {
                        ans = std::min(ans, dist[i][j]);
                    }
                }
            }
        }
        
        return ans == INT_MAX ? -1 : ans;
    }
};