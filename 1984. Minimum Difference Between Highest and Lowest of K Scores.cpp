class Solution {
public:
    int minimumDifference(std::vector<int>& nums, int k) {
        std::sort(nums.begin(), nums.end());
        int left = 0, right = k;
        int ans = INT_MAX;
        while (right <= (int)nums.size()) {
            ans = std::min(ans, nums[right - 1] - nums[left]);
            left++;
            right++;
        }
        return ans;
    }
};