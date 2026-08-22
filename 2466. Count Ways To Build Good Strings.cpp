class Solution {
public:
    long long solve(int curr, int low, int high, int zero, int one, vector<long long>& dp) {
        if (curr > high) return 0;
        if (dp[curr] != -1) return dp[curr];

        long long res = solve(curr + zero, low, high, zero, one, dp)
                      + solve(curr + one, low, high, zero, one, dp);

        if (curr >= low) return dp[curr] = (res + 1) % 1000000007;
        return dp[curr] = res % 1000000007;
    }

    int countGoodStrings(int low, int high, int zero, int one) {
        vector<long long> dp(high + 1, -1);

        return (int)solve(0, low, high, zero, one, dp);
    }
};