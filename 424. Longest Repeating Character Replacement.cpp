class Solution {
public:
    bool check(const vector<int>& freq, int k) {
        int maxEle = 0, sum = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxEle) {
                sum += maxEle;
                maxEle = freq[i];
            } else {
                sum += freq[i];
            }
        }

        if (sum > k) return false;

        return true;
    }

    int characterReplacement(const string& s, int k) {
        int left = 0;
        int ans = 0;
        vector<int> freq(26, 0);

        for (int right = 0; right < (int)s.size(); right++) {
            freq[s[right] - 'A']++;

            while (!check(freq, k)) {
                freq[s[left] - 'A']--;
                left++;
            }

            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};