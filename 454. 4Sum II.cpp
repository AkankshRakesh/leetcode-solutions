class Solution {
public:
    int fourSumCount(std::vector<int>& nums1, std::vector<int>& nums2, std::vector<int>& nums3, std::vector<int>& nums4) {
        std::unordered_map<int, int> hm;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                hm[num1 + num2]++;
            }
        }

        int ans = 0;
        for (int num1 : nums3) {
            for (int num2 : nums4) {
                int target = 0 - num1 - num2;
                if (hm.find(target) != hm.end()) {
                    ans += hm[target];
                }
            }
        }

        return ans;
    }
};