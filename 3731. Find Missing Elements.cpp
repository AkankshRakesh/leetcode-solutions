class Solution {
public:
    vector<int> findMissingElements(const vector<int>& nums) {
        unordered_set<int> seen;
        int min = nums[0], max = nums[0];
        
        for (int num : nums) {
            seen.insert(num);
            min = min(min, num);
            max = max(max, num);
        }

        vector<int> ans;
        for (int i = min; i < max; i++) {
            if (seen.find(i) == seen.end()) {
                ans.push_back(i);
            }
        }

        return ans;
    }
};