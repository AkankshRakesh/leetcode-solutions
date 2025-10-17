class Solution {
public:
    void dfs(vector<vector<int>>& heights, int i, int j, int n, int m, vector<vector<bool>>& visited, int past) {
        if (i >= n || j >= m || i < 0 || j < 0) return;
        if (heights[i][j] < past || visited[i][j]) return;

        visited[i][j] = true;
        dfs(heights, i - 1, j, n, m, visited, heights[i][j]);
        dfs(heights, i + 1, j, n, m, visited, heights[i][j]);
        dfs(heights, i, j + 1, n, m, visited, heights[i][j]);
        dfs(heights, i, j - 1, n, m, visited, heights[i][j]);
    }

    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int n = heights.size();
        int m = heights[0].size();

        vector<vector<int>> ans;
        vector<vector<bool>> pacific(n, vector<bool>(m, false));
        vector<vector<bool>> atlantic(n, vector<bool>(m, false));

        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
            atlantic[n - 1][j] = true;
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, i, 1, n, m, pacific, heights[i][0]);
        }
        for (int j = 0; j < m; j++) {
            dfs(heights, 1, j, n, m, pacific, heights[0][j]);
        }

        for (int i = n - 1; i >= 0; i--) {
            dfs(heights, i, m - 2, n, m, atlantic, heights[i][m - 1]);
        }
        for (int j = m - 1; j >= 0; j--) {
            dfs(heights, n - 2, j, n, m, atlantic, heights[n - 1][j]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.push_back({i, j});
                }
            }
        }

        return ans;
    }
};
