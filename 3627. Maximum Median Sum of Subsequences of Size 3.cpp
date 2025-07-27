class Solution {
public:
    long long maximumMedianSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int n = nums.size();
        long long sum = 0;
        int k = n / 3;

        for (int i = n - 2; k > 0; i -= 2, k--) {
            sum += nums[i];
        }

        return sum;
    }
};
