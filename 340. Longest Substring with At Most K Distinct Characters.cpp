class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(const std::string& s) {
        std::vector<int> freq(128, 0);
        int count = 0;
        int ans = 0;
        int left = 0;

        for (int right = 0; right < (int)s.size(); right++) {
            freq[s[right]]++;
            if (freq[s[right]] == 1) count++;
            while (count > 2 && left < right) {
                freq[s[left]]--;
                if (freq[s[left]] == 0) count--;
                left++;
            }
            ans = std::max(ans, right - left + 1);
        }

        return ans;
    }
};