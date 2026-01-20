class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        vector<int> ans(nums.size(), -1);
        int index = 0;

        for (int num : nums) {
            for (int i = 1; i < num; i++) {
                int val = i + 1;
                val |= i;
                if (val == num) {
                    ans[index] = i;
                    break;
                }
            }
            index++;
        }

        return ans;
    }
};
