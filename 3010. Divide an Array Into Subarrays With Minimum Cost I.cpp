class Solution {
public:
    int minimumCost(const std::vector<int>& nums) {
        int first = std::min(nums[1], nums[2]);
        int second = std::max(nums[1], nums[2]);
        for (size_t i = 3; i < nums.size(); i++) {
            if (nums[i] < first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            }
        }
        return nums[0] + first + second;
    }
};