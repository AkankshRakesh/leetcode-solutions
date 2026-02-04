class Solution {
public:
    int solve(const std::vector<int>& nums, int k) {
        int ans = 0;
        std::unordered_map<int, int> hm;
        int left = 0;
        for (int right = 0; right < (int)nums.size(); right++) {
            hm[nums[right]]++;

            while ((int)hm.size() > k) {
                hm[nums[left]]--;
                if (hm[nums[left]] == 0) hm.erase(nums[left]);
                left++;
            }

            ans += right - left;
        }
        return ans;
    }

    int subarraysWithKDistinct(const std::vector<int>& nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }
};