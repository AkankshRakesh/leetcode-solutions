class Solution {
public:
    int findIndex(const vector<vector<int>>& offers, int index) {
        int left = index + 1, right = (int)offers.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (offers[mid][0] > offers[index][1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    int solve(const vector<vector<int>>& offers, vector<int>& dp, int index) {
        if (index >= (int)offers.size()) return 0;
        if (dp[index] != -1) return dp[index];

        int nextInd = findIndex(offers, index);
        int pick = offers[index][2] + solve(offers, dp, nextInd);
        int notPick = solve(offers, dp, index + 1);

        return dp[index] = max(pick, notPick);
    }

    int maximizeTheProfit(int n, vector<vector<int>>& offers) {
        sort(offers.begin(), offers.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        vector<int> dp((int)offers.size(), -1);

        return solve(offers, dp, 0);
    }
};