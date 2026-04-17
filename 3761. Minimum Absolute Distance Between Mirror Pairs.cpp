class Solution {
public:
    int rev(int num) {
        int ans = 0;
        while (num != 0) {
            ans *= 10;
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    int minMirrorPairDistance(const vector<int>& nums) {
        unordered_map<int, int> hm;
        int ans = INT_MAX;
        for (int i = 0; i < (int)nums.size(); i++) {
            int r = rev(nums[i]);
            if (hm.find(nums[i]) != hm.end()) {
                ans = min(ans, i - hm[nums[i]]);
            }
            hm[r] = i;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};