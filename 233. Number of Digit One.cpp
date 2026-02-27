class Solution {
public:
    int solve(vector<vector<vector<int>>>& dp, const vector<int>& digits, int index, int limit, int ones) {
        if (index >= (int)digits.size()) return ones;
        if (dp[index][limit][ones] != -1) return dp[index][limit][ones];

        int end = limit == 1 ? digits[index] : 9;
        int ans = 0;
        for (int i = 0; i <= end; i++) {
            int nextLimit = (limit == 1 && i == end) ? 1 : 0;
            ans += solve(dp, digits, index + 1, nextLimit, ones + (i == 1 ? 1 : 0));
        }

        return dp[index][limit][ones] = ans;
    }

    int countDigitOne(int n) {
        vector<int> digits;
        while (n != 0) {
            digits.push_back(n % 10);
            n /= 10;   
        }
        reverse(digits.begin(), digits.end());

        int size = (int)digits.size();
        vector<vector<vector<int>>> dp(size, vector<vector<int>>(2, vector<int>(size, -1)));

        return solve(dp, digits, 0, 1, 0);
    }
};