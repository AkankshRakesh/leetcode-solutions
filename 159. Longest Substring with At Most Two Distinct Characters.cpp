class Solution {
public:
    int lengthOfLongestSubstringKDistinct(const std::string& s, int k) {
        if (k == 0) return 0;
        std::vector<int> freq(128, 0);
        int left = 0;
        int ans = 0;
        int count = 0;

        for (int right = 0; right < (int)s.size(); right++) {
            freq[s[right]]++;
            if (freq[s[right]] == 1) count++;
            while (count > k && left < right) {
                freq[s[left]]--;
                if (freq[s[left++]] == 0) count--;
            }

            ans = std::max(ans, right - left + 1);
        }

        return ans;
    }
};