class Solution {
public:
    int maximumLengthSubstring(string s) {
        int freq[128] = {};

        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s[right]]++;

            while (freq[s[right]] > 2) {
                freq[s[left]]--;
                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};