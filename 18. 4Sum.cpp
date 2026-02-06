class Solution {
public:
    std::vector<std::vector<int>> fourSum(std::vector<int>& nums, int target) {
        std::sort(nums.begin(), nums.end());
        std::vector<std::vector<int>> ans;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                if (j - 1 != i && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long long lSum = (long long)nums[i] + (long long)nums[j] + (long long)nums[left] + (long long)nums[right];
                    if (lSum > INT_MAX) {
                        left++;
                        right--;
                    } else {
                        int sum = (int)lSum;
                        if (sum == target) {
                            ans.push_back({nums[i], nums[j], nums[left], nums[right]});

                            left++;
                            right--;
                            while (left < right && nums[left] == nums[left - 1]) left++;
                            while (left < right && nums[right] == nums[right + 1]) right--;
                        } else if (sum > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        return ans;
    }
};