class Solution {
public:
    int maxIncreasingSubarrays(vector<int>& nums) {
        int n = nums.size();
    std::vector<int> streak(n, 0);

    for (int i = n - 2; i >= 0; --i) {
        if (nums[i] < nums[i + 1]) {
            streak[i] = streak[i + 1] + 1;
        }
    }

    int left = 1, right = n / 2, maxK = 0;
    while (left <= right) {
        int k = left + (right - left) / 2;
        bool found = false;

        for (int i = 0; i <= n - 2 * k; ++i) {
            if (streak[i] >= k - 1 && streak[i + k] >= k - 1) {
                found = true;
                break; 
            }
        }

        if (found) {
            maxK = k; 
            left = k + 1;
        } else {
            right = k - 1;
        }
    }

    return maxK;
    }
};