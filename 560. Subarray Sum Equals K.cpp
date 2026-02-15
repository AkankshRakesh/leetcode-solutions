class Solution {
public:
    int subarraySumLessThanEqualToK(const vector<int>& nums, int k) {
        int left = 0;
        unordered_map<int, int> freq;
        int ans = 0;
        int sum = 0;
        freq[0] = 1;

        for (int right = 0; right < (int)nums.size(); right++) {
            sum += nums[right];
            if (freq.find(sum - k) != freq.end()) {
                ans += freq[sum - k];
            }
            freq[sum]++;
        }
        return ans;
    }

    int subarraySum(const vector<int>& nums, int k) {
        return subarraySumLessThanEqualToK(nums, k);
    }
};