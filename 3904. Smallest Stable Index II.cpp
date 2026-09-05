class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> suffix(n);
        int maxValue = nums[0], minValue = nums[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            minValue = min(minValue, nums[i]);
            suffix[i] = minValue;
        }

        for (int i = 0; i < n; i++) {
            maxValue = max(maxValue, nums[i]);
            if (maxValue - suffix[i] <= k) return i;
        }

        return -1;
    }
};