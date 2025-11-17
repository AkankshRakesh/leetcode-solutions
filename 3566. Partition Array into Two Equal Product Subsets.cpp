typedef __int128 ll;
class Solution {
public:
    bool backtrack(vector<int>& nums, int index, long long target, ll currMult) {
        if (currMult == target) return true;
        if (index >= nums.size() || currMult > target) return false;

        return backtrack(nums, index + 1, target, currMult * nums[index]) ||
               backtrack(nums, index + 1, target, currMult);
    }

    bool checkEqualPartitions(vector<int>& nums, long long target) {
        ll mult = 1;
        for (int num : nums) mult *= num;
        if (mult != (ll)target * target) return false;

        return backtrack(nums, 0, target, 1);
    }
};
