class Solution {
public:
    bool dfs(const vector<vector<int>>& heights, int i, int j, int past, int k, vector<vector<bool>>& visited) {
        if (i >= (int)heights.size() || j >= (int)heights[0].size() || i < 0 || j < 0 || visited[i][j] || abs(past - heights[i][j]) > k) 
            return false;
        if (i == (int)heights.size() - 1 && j == (int)heights[0].size() - 1) 
            return true;

        visited[i][j] = true;
        bool res = dfs(heights, i + 1, j, heights[i][j], k, visited) ||
                   dfs(heights, i - 1, j, heights[i][j], k, visited) ||
                   dfs(heights, i, j + 1, heights[i][j], k, visited) ||
                   dfs(heights, i, j - 1, heights[i][j], k, visited);

        return res;
    }

    int minimumEffortPath(vector<vector<int>>& heights) {
        int left = 0, right = 0;
        for (int i = 0; i < (int)heights.size(); i++) {
            for (int j = 0; j < (int)heights[0].size(); j++) {
                right = max(right, heights[i][j]);
            }
        }
        int ans = INT_MAX;
        while (left < right) {
            vector<vector<bool>> visited(heights.size(), vector<bool>(heights[0].size(), false));
            int mid = left + (right - left) / 2;
            if (dfs(heights, 0, 0, heights[0][0], mid, visited)) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
};