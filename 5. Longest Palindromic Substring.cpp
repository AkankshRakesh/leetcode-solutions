class Solution {
public:
    vector<int> expand(const string& s, int left, int right) {
        while (left >= 0 && right < (int)s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        return {left + 1, right - 1};
    }

    string longestPalindrome(const string& s) {
        int len = 0, ansLeft = 0, ansRight = 0;
        for (int i = 1; i < (int)s.length(); i++) {
            vector<int> boundary1 = expand(s, i - 1, i + 1);
            vector<int> boundary2(2, 0);
            if (s[i] == s[i - 1]) boundary2 = expand(s, i - 2, i + 1);
            int len1 = boundary1[1] - boundary1[0];
            int len2 = boundary2[1] - boundary2[0];
            if (len < len1 || len < len2) {
                if (len1 < len2) {
                    len = len2;
                    ansLeft = boundary2[0];
                    ansRight = boundary2[1];
                } else {
                    len = len1;
                    ansLeft = boundary1[0];
                    ansRight = boundary1[1];
                }
            }
        }

        return s.substr(ansLeft, ansRight - ansLeft + 1);
    }
};

