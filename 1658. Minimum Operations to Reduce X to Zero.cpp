class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        unordered_map<int, int> hm;
        hm[0] = -1;
        int sum = 0;

        for (int i = 0; i < nums.size() && sum <= x; i++) {
            sum += nums[i];
            hm[sum] = i;
        }

        int ans = hm.count(x) ? hm[x] + 1 : INT_MAX;

        sum = 0;
        for (int i = nums.size() - 1; i >= 0 && sum <= x; i--) {
            sum += nums[i];

            if (hm.count(x - sum) && hm[x - sum] < i)
                ans = min(ans, hm[x - sum] + 1 + ((int)nums.size() - i));
        }

        return ans == INT_MAX ? -1 : ans;
    }
};