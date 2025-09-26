class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        unordered_map<int, int> hm;
        for (int num : nums) hm[num]++;

        int count = 0;
        for (auto &ele : hm) {
            int num = ele.first;
            if (k == 0) {
                if (hm[num] > 1) count++;
            } else {
                if (hm.find(num + k) != hm.end()) count++;
            }
        }

        return count;
    }
};
