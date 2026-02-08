class Solution {
public:
    int numberOfSubstrings(const std::string& s, int k) {
        int ans = 0;

        for (int left = 0; left < (int)s.length(); left++) {
            vector<int> freq(128, 0);
            int right = left;
            for (right = left; right < (int)s.length(); right++) {
                freq[s[right]]++;
                if (freq[s[right]] == k) break;
            }
            ans += (int)s.length() - right;
        }

        return ans;
    }
};