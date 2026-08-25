class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        unordered_set<int> seen;

        for (int num : nums) {
            seen.insert(num);
        }

        int num = k;
        while (seen.count(num)) {
            num += k;
        }

        return num;
    }
};