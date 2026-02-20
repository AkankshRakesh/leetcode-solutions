class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        if (n == 0) return 0;

        unordered_set<char> hs;
        int left = 0, ans = 0;

        for (int right = 0; right < n; ++right) {
            while (hs.find(s[right]) != hs.end()) {
                hs.erase(s[left]);
                ++left;
            }
            hs.insert(s[right]);
            ans = max(ans, right - left + 1);  
        }

        return ans;
    }
};
