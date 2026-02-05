class Solution {
public:
    int solve(const std::vector<int>& nums, int goal) {
        int sum = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < (int)nums.size(); right++) {
            sum += nums[right];

            while (sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }

            ans += (right - left);
        }

        return ans;
    }

    int numSubarraysWithSum(const std::vector<int>& nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }
};