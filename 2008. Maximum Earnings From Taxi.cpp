class Solution {
public:
    int findIndex(const vector<vector<int>>& rides, int index) {
        int left = index + 1, right = (int)rides.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (rides[mid][0] >= rides[index][1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    long long solve(const vector<vector<int>>& rides, vector<long long>& dp, int index) {
        if (index >= (int)rides.size()) return 0;
        if (dp[index] != -1) return dp[index];

        int nextInd = findIndex(rides, index);
        long long pick = (long long)(rides[index][1] - rides[index][0]) + rides[index][2] + solve(rides, dp, nextInd);
        long long notPick = solve(rides, dp, index + 1);

        return dp[index] = max(pick, notPick);
    }

    long long maxTaxiEarnings(int n, vector<vector<int>>& rides) {
        sort(rides.begin(), rides.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        vector<long long> dp(rides.size(), -1);

        return solve(rides, dp, 0);
    }
};