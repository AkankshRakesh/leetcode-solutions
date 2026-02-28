class Solution {
public:
    int findIndex(const vector<vector<int>>& rides, int index) {
        int left = index + 1, right = (int)rides.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (rides[mid][0] > rides[index][1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    int solve(const vector<vector<int>>& events, int k, vector<vector<int>>& dp, int index) {
        if (index >= (int)events.size() || k == 0) return 0;
        if (dp[index][k] != -1) return dp[index][k];

        int nextInd = findIndex(events, index);
        int pick = events[index][2] + solve(events, k - 1, dp, nextInd);
        int notPick = solve(events, k, dp, index + 1);

        return dp[index][k] = max(pick, notPick);
    }

    int maxValue(vector<vector<int>>& events, int k) {
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        vector<vector<int>> dp((int)events.size(), vector<int>(k + 1, -1));

        return solve(events, k, dp, 0);
    }
};