class Solution {
public:
    int longestKSubstr(const std::string& s, int k) {
        int count = 0;
        int len = -1;
        int left = 0;

        std::vector<int> freq(128, 0);
        for (int right = 0; right < (int)s.length(); right++) {
            if (freq[s[right]] == 0) count++;
            freq[s[right]]++;

            while (count > k) {
                if (freq[s[left]] == 1) count--;
                freq[s[left]]--;
                left++;
            }
            if (count == k) len = std::max(len, right - left + 1);
        }

        if (count == k) len = std::max(len, (int)s.length() - left);

        return len;
    }
};