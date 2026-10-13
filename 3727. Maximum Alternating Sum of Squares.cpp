class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size() / 2;
        long long ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            nums[i] = abs(nums[i]);
        }

        sort(nums.begin(), nums.end());

        for (int i = nums.size() - 1; i >= n; i--) {
            ans += (long long)nums[i] * (long long)nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            ans -= (long long)nums[i] * (long long)nums[i];
        }

        return ans;
    }
};