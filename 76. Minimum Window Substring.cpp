class Solution {
public:
    string minWindow(const string& s, const string& t) {
        int needed[128] = {0};
        int count = 0;
        for (char c : t) {
            needed[c]++;
            count++;
        }

        int ansLeft = 0, ansRight = 0;
        int left = 0;
        int len = INT_MAX;
        for (int right = 0; right < (int)s.size(); right++) {
            if (needed[s[right]] > 0) count--;
            needed[s[right]]--;

            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    ansLeft = left;
                    ansRight = right;
                }
                if (needed[s[left]] == 0) count++;
                needed[s[left]]++;
                left++;
            }
        }

        return len == INT_MAX ? "" : s.substr(ansLeft, ansRight - ansLeft + 1);
    }
};

