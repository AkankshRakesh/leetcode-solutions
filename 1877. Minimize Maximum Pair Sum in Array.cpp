class Solution {
public:
    int minPairSum(std::vector<int>& nums) {
        std::sort(nums.begin(), nums.end());
        int left = 0;
        int right = nums.size() - 1;
        int ans = 0;
        while (left < right) {
            ans = std::max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }
        return ans;
    }
};

