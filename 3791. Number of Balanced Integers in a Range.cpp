class Solution {
public:
    long long count(vector<int>& nums, int index, int balance, int tight, vector<vector<vector<long long>>>& dp) {
        if (index >= nums.size()) return balance == 0 ? 1 : 0;

        if (dp[index][balance + 100][tight] != -1)
            return dp[index][balance + 100][tight];

        long long res = 0;

        if (tight == 1) {
            for (int i = 0; i < nums[index]; i++) {
                if (index % 2 == 0)
                    res += count(nums, index + 1, balance + i, 0, dp);
                else
                    res += count(nums, index + 1, balance - i, 0, dp);
            }

            if (index % 2 == 0)
                res += count(nums, index + 1, balance + nums[index], 1, dp);
            else
                res += count(nums, index + 1, balance - nums[index], 1, dp);
        }
        else {
            for (int i = 0; i <= 9; i++) {
                if (index % 2 == 0)
                    res += count(nums, index + 1, balance + i, 0, dp);
                else
                    res += count(nums, index + 1, balance - i, 0, dp);
            }
        }

        return dp[index][balance + 100][tight] = res;
    }

    long long countBalanced(long long low, long long high) {
        int digits = 0;
        long long temp = low - 1;

        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        vector<int> lowNums(digits);
        temp = low - 1;
        int index = digits - 1;

        while (temp != 0) {
            lowNums[index] = (int)(temp % 10);
            temp /= 10;
            index--;
        }

        digits = 0;
        temp = high;

        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        vector<int> highNums(digits);
        temp = high;
        index = digits - 1;

        while (temp != 0) {
            highNums[index] = (int)(temp % 10);
            temp /= 10;
            index--;
        }

        vector<vector<vector<long long>>> dp1(
            lowNums.size(),
            vector<vector<long long>>(300, vector<long long>(2, -1))
        );

        vector<vector<vector<long long>>> dp2(
            highNums.size(),
            vector<vector<long long>>(300, vector<long long>(2, -1))
        );

        return count(highNums, 0, 0, 1, dp2)
             - count(lowNums, 0, 0, 1, dp1);
    }
};