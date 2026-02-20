class Solution {
public:
    int lengthOfLongestSubstring(const string& s) {
        vector<int> freq(128, 0);
        int left = 0;
        int ans = 0;
        for (int right = 0; right < static_cast<int>(s.size()); right++) {
            freq[s[right]]++;

            while (freq[s[right]] >= 2) {
                freq[s[left]]--;
                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};