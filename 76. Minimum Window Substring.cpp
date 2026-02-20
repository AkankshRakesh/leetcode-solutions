class Solution {
public:
    string minWindow(string s, string t) {
        int ansFreq[128] = {0};
        int ansCount = 0;
        for (char c : t) {
            if (ansFreq[c] == 0) ansCount++;
            ansFreq[c]++;
        }

        int freq[128] = {0};
        int count = 0;
        string ans = s;
        int left = 0;
        bool oneMatch = false;

        for (int right = 0; right < (int)s.size(); right++) {
            freq[s[right]]++;
            if (freq[s[right]] == ansFreq[s[right]]) count++;

            while (count == ansCount) {
                oneMatch = true;
                if (right - left + 1 < (int)ans.size()) {
                    ans = s.substr(left, right - left + 1);
                }
                if (freq[s[left]] == ansFreq[s[left]]) count--;
                freq[s[left]]--;
                left++;
            }
        }

        if (!oneMatch) return "";
        return ans;
    }
};