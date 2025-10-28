class Solution {
public:
    int countValidSelections(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefix(n, 0), suffix(n, 0);
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i + 1];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (prefix[i] == suffix[i]) ans += 2;
                else if (prefix[i] + 1 == suffix[i]) ans++;
                else if (prefix[i] == suffix[i] + 1) ans++;
            }
        }

        return ans;
    }
};
