#include <vector>
using namespace std;
class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        vector<int> leftDP(nums.size(), 1), rightDP(nums.size(), 1);
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    leftDP[i] = max(leftDP[i], leftDP[j] + 1);
                }
            }
        }
        for (int i = nums.size() - 1; i >= 0; --i) {
            for (int j = nums.size() - 1; j > i; --j) {
                if (nums[i] > nums[j]) {
                    rightDP[i] = max(rightDP[i], rightDP[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (leftDP[i] != 1 && rightDP[i] != 1) {
                ans = max(ans, leftDP[i] + rightDP[i]);
            }
        }
        return nums.size() - ans + 1;
    }
};
