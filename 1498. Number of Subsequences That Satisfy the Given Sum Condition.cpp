class Solution {
    const int mod = 1e9 + 7;

public:
    int numSubseq(std::vector<int>& nums, int target) {
        int n = nums.size();
        std::vector<int> powList(n, 1);

        for (int i = 1; i < n; ++i) {
            powList[i] = (powList[i - 1] * 2LL) % mod;
        }

        std::sort(nums.begin(), nums.end());

        int left = 0, right = n - 1;
        int ans = 0;

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                --right;
            } else {
                ans = (ans + powList[right - left]) % mod;
                ++left;
            }
        }

        return ans;
    }
};