class Solution {
public:
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
    
    for (int i = 0; i <= n - 2 * k; ++i) {
        
        bool firstIncreasing = true;
        for (int j = i; j < i + k - 1; ++j) {
            if (nums[j] >= nums[j + 1]) {
                firstIncreasing = false;
                break;
            }
        }

        bool secondIncreasing = true;
        for (int j = i + k; j < i + 2 * k - 1; ++j) {
            if (nums[j] >= nums[j + 1]) {
                secondIncreasing = false;
                break;
            }
        }

        if (firstIncreasing && secondIncreasing) {
            return true;
        }
    }

    return false;
    }
};