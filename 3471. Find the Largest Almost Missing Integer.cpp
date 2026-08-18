class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int freq[51] = {};

        for (int i = 0; i + k <= nums.size(); i++) {
            bool found[51] = {};

            for (int j = i; j < i + k; j++) {
                if (!found[nums[j]]) freq[nums[j]]++;
                found[nums[j]] = true;
            }
        }

        int ans = -1;
        for (int i = 0; i <= 50; i++) {
            if (freq[i] == 1) ans = i;
        }

        return ans;
    }
};