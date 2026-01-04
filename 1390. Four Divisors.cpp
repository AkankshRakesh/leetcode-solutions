class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        int maxNum = -1;
        for (int num : nums)
            maxNum = max(maxNum, num);

        vector<int> divCount(maxNum + 1, 0);
        vector<vector<int>> divisors(maxNum + 1, vector<int>(2, 0));

        for (int i = 2; i <= maxNum; i++) {
            for (int j = i + i; j <= maxNum; j += i) {
                divCount[j]++;
                if (divCount[j] == 1)
                    divisors[j][0] = i;
                else
                    divisors[j][1] = i;
            }
        }

        int ans = 0;
        for (int num : nums) {
            if (divCount[num] == 2) {
                ans += (1 + num + divisors[num][0] + divisors[num][1]);
            }
        }

        return ans;
    }
};
