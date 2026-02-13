class Solution {
public:
    struct Pair {
        int value;
        vector<int> index;
        Pair(int v, vector<int> idx) : value(v), index(idx) {}
    };

    struct Compare {
        bool operator()(const Pair& a, const Pair& b) {
            return a.value > b.value; // min-heap
        } 
    };

    int swimInWater(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MAX));

        priority_queue<Pair, vector<Pair>, Compare> pq;
        pq.push(Pair(grid[0][0], {0, 0}));

        int curr = INT_MIN;
        int ans = INT_MAX;

        while (!pq.empty()) {
            Pair top = pq.top(); pq.pop();
            int i = top.index[0];
            int j = top.index[1];

            if (top.value > dp[i][j]) continue;

            dp[i][j] = curr;
 
            if (i + 1 < n && dp[i + 1][j] > curr) pq.push(Pair(grid[i + 1][j], {i + 1, j}));
            if (j + 1 < m && dp[i][j + 1] > curr) pq.push(Pair(grid[i][j + 1], {i, j + 1}));
            if (i - 1 >= 0 && dp[i - 1][j] > curr) pq.push(Pair(grid[i - 1][j], {i - 1, j}));
            if (j - 1 >= 0 && dp[i][j - 1] > curr) pq.push(Pair(grid[i][j - 1], {i, j - 1}));

            curr = max(curr, top.value);

            if (i + 1 >= n && j + 1 >= m) 
                ans = min(ans, curr);
        }

        return ans;
    }
};
