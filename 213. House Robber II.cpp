class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0];
        if (n == 2) return max(nums[0], nums[1]);

        int max1 = robLinear(nums, 0, n - 2); // Exclude last house
        int max2 = robLinear(nums, 1, n - 1); // Exclude first house

        return max(max1, max2);
    }

private:
    int robLinear(vector<int>& nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; ++i) {
            int temp = max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
};
