class Solution {
public:
    int longestSubstring(const string& s, int k) {
        vector<bool> found(26, false);
        for (char c : s) found[c - 'a'] = true;
        int maxUnique = 0;
        for (bool f : found) if (f) maxUnique++;
        int ans = 0;

        for (int uniqueLimit = 0; uniqueLimit <= maxUnique; uniqueLimit++) {
            vector<int> freq(26, 0);
            int left = 0, countUnique = 0;

            for (int right = 0; right < (int)s.size(); right++) {
                if (freq[s[right] - 'a'] == 0) countUnique++;
                freq[s[right] - 'a']++;

                while (countUnique > uniqueLimit) {
                    freq[s[left] - 'a']--;
                    if (freq[s[left] - 'a'] == 0) countUnique--;
                    left++;
                }

                if (countUnique == uniqueLimit) {
                    bool valid = true;
                    for (int i = 0; i < 26; i++) {
                        if (freq[i] != 0 && freq[i] < k) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) ans = max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
};