class Solution {
public:
    bool canCross(const vector<vector<int>>& grid, const vector<vector<int>>& fireTime, int allowed, vector<vector<bool>>& visited) {
        int n = fireTime.size(), m = fireTime[0].size();
        queue<pair<int,int>> q;
        q.emplace(0, 0);
        if(fireTime[0][0] != -1 && fireTime[0][0] <= allowed) return false;
        visited[0][0] = true;

        int time = allowed;
        vector<vector<int>> dir{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                if(x == n - 1 && y == m - 1) return true;

                for(const auto& d : dir){
                    int nx = x + d[0], ny = y + d[1];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(grid[nx][ny] == 2 || visited[nx][ny]) continue;

                    int arrival = time + 1;

                    if(nx == n - 1 && ny == m - 1){
                        if(fireTime[nx][ny] != -1 && fireTime[nx][ny] < arrival) continue;
                    } else {
                        if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= arrival) continue;
                    }

                    visited[nx][ny] = true;
                    q.emplace(nx, ny);
                }
            }
            time++;
        }

        return false;
    }

    int maximumMinutes(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        queue<pair<int,int>> fireQ;

        vector<vector<int>> fireTime(n, vector<int>(m, -1));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) fireQ.emplace(i, j);
            }
        }

        int time = 0;
        while(!fireQ.empty()){
            int size = fireQ.size();
            for(int i = 0; i < size; i++){
                int x = fireQ.front().first;
                int y = fireQ.front().second;
                fireQ.pop();
                fireTime[x][y] = time;
                if(x + 1 < n && grid[x + 1][y] == 0 && fireTime[x + 1][y] == -1) fireQ.emplace(x + 1, y);
                if(y + 1 < m && grid[x][y + 1] == 0 && fireTime[x][y + 1] == -1) fireQ.emplace(x, y + 1);
                if(x - 1 >= 0 && grid[x - 1][y] == 0 && fireTime[x - 1][y] == -1) fireQ.emplace(x - 1, y);
                if(y - 1 >= 0 && grid[x][y - 1] == 0 && fireTime[x][y - 1] == -1) fireQ.emplace(x, y - 1);
            }
            time++;
        }

        int left = 0, right = 1000000000, ans = -1;
        while(left <= right){
            vector<vector<bool>> visited(n, vector<bool>(m, false));
            int mid = left + (right - left) / 2;
            if(canCross(grid, fireTime, mid, visited)){
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return ans;
    }
};