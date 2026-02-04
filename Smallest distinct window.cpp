class Solution {
public:
    int findSubString(const std::string& s) {
        int freq[128] = {0};
        int count = 0;
        for (char c : s) {
            if (freq[c] == 0) count++;
            freq[c]++;
        }

        int left = 0;
        int ans = s.length();
        int currFreq[128] = {0};
        for (int right = 0; right < (int)s.length(); right++) {
            if (currFreq[s[right]] == 0) count--;
            currFreq[s[right]]++;

            while (count == 0) {
                ans = std::min(ans, right - left + 1);
                if (currFreq[s[left]] == 1) count++;
                currFreq[s[left]]--;
                left++;
            }
        }

        return ans;
    }
};