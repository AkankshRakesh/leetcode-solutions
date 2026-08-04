class Solution {
public:
    std::vector<int> findMissingElements(const std::vector<int>& nums) {
        std::unordered_set<int> seen;
        int min = nums[0], max = nums[0];
        
        for (int num : nums) {
            seen.insert(num);
            min = std::min(min, num);
            max = std::max(max, num);
        }

        std::vector<int> ans;
        for (int i = min; i < max; i++) {
            if (seen.find(i) == seen.end()) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};