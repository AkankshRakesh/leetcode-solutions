class Solution {
public:
    int recurse(unordered_map<int, int>& hm, vector<bool>& visited, vector<int>& seq, int key) {
        if (hm.find(key) == hm.end()) return 0;
        if (visited[hm[key]]) return seq[hm[key]];

        visited[hm[key]] = true;
        return seq[hm[key]] = 1 + recurse(hm, visited, seq, key + 1);
    }

    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        unordered_map<int, int> hm;
        vector<bool> visited(nums.size(), false);
        vector<int> seq(nums.size(), 0);
        int ans = 1;

        for (int i = 0; i < (int)nums.size(); i++) {
            if (hm.find(nums[i]) == hm.end()) hm[nums[i]] = i;
        }

        for (int num : nums) {
            recurse(hm, visited, seq, num);
            ans = max(ans, seq[hm[num]]);
        }

        return ans;
    }
};