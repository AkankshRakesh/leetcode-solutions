class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.size() && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }

        unordered_set<int> hs;
        for (int j = 0; j < nums.size(); j++) {
            hs.insert(nums[j]);
        }

        while (hs.count(sum))
            sum++;

        return sum;
    }
};