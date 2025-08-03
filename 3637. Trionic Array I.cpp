class Solution {
public:
    bool isInc(vector<int>& nums, int s, int e) {
        for (int i = s; i < e; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }

    bool isDec(vector<int>& nums, int s, int e) {
        for (int i = s; i < e; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        return true;
    }

    bool isTrionic(vector<int>& nums) {
        int n = nums.size();
        for (int p = 1; p < n; p++) {
            for (int q = p + 1; q < n - 1; q++) {
                if (isInc(nums, 0, p) && isDec(nums, p, q) && isInc(nums, q, n - 1)) {
                    return true;
                }
            }
        }
        return false;
    }
};
