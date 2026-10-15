class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int maxVal = nums[0];
        for (int num : nums) maxVal = max(maxVal, num);

        vector<int> freq(maxVal + 1);
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            freq = vector<int>(maxVal + 1);
            int count = 0;

            for (int j = i; j < nums.size(); j++) {
                if (freq[nums[j]] == 0) count++;
                freq[nums[j]]++;

                ans += count * count;
            }
        }

        return ans;
    }
};