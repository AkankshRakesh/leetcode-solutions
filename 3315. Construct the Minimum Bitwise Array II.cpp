class Solution {
public:
    std::vector<int> minBitwiseArray(const std::vector<int>& nums) {
        int n = nums.size();
        std::vector<int> result(n);
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int res = -1;
            int d = 1;
            while ((x & d) != 0) {
                res = x - d;
                d <<= 1;
            }
            result[i] = res;
        }
        return result;
    }
};