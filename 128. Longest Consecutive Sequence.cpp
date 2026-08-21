class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> hs;
        for (int num : nums) hs.insert(num);

        int ans = 0;
        for (int num : nums) {
            if (!hs.count(num)) continue;

            int left = num - 1, right = num + 1;

            while (hs.count(left)) {
                hs.erase(left);
                left--;
            }

            while (hs.count(right)) {
                hs.erase(right);
                right++;
            }

            hs.erase(num);
            ans = max(ans, 1 + (num - left - 1) + (right - num - 1));
        }

        return ans;
    }
};