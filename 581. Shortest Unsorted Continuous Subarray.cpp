class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int leftInd = -1;
        int rightInd = -1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < nums[i - 1]) {
                leftInd = i - 1;
                break;
            }
        }

        if (leftInd == -1) return 0;

        for (int i = nums.size() - 2; i >= leftInd; i--) {
            if (nums[i] > nums[i + 1]) {
                rightInd = i + 1;
                break;
            }
        }

        int minVal = INT_MAX;
        int maxVal = INT_MIN;

        for (int i = leftInd; i <= rightInd; i++) {
            minVal = min(minVal, nums[i]);
            maxVal = max(maxVal, nums[i]);
        }

        for (int i = leftInd - 1; i >= 0; i--) {
            if (nums[i] > minVal) {
                leftInd = i;
                maxVal = max(maxVal, nums[i]);
            }
        }

        for (int i = rightInd + 1; i < nums.size(); i++) {
            if (nums[i] < maxVal) {
                rightInd = i;
                minVal = min(minVal, nums[i]);
            }
        }

        return rightInd - leftInd + 1;
    }
};
