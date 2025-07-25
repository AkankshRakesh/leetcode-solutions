class Solution {
public:
    int maxSum(vector<int>& nums) {
        unordered_set<int> seen;
        int sum = 0;
        bool hasPositive = false;

        for (int num : nums) {
            if (num > 0 && seen.find(num) == seen.end()) {
                seen.insert(num);
                sum += num;
                hasPositive = true;
            }
        }

        if (!hasPositive) {
            sum = nums[0];
            for (int num : nums) {
                sum = max(sum, num);
            }
        }

        return sum;
    }
};
