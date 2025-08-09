class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int left = 0;
        int n = nums.size();
        int maxSize = 1;

        for (int right = 1; right < n; right++) {
            while (left < right && (long long)nums[left] * k < nums[right]) {
                left++;
            }
            maxSize = max(maxSize, right - left + 1);
        }

        return n - maxSize;
    }
};
