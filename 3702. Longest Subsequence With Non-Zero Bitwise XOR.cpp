class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int xorValue = 0;
        bool allZero = true;

        for (int num : nums) {
            if (num != 0) allZero = false;
            xorValue ^= num;
        }

        if (allZero) return 0;
        if (xorValue == 0) return nums.size() - 1;
        return nums.size();
    }
};