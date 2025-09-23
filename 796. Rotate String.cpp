class Solution {
public:
    vector<int> lps(const string& s) {
        vector<int> lps(s.length());
        int i = 1;
        int len = 0;
        while (i < (int)s.length()) {
            if (s[i] == s[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    bool search(const string& txt, const string& pat) {
        vector<int> lp = lps(pat);
        int i = 0, j = 0;
        while (i < (int)txt.length()) {
            if (txt[i] == pat[j]) {
                i++;
                j++;
                if (j == (int)pat.length()) return true;
            } else {
                if (j != 0) {
                    j = lp[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    bool rotateString(string s, string goal) {
        if (s.length() != goal.length()) return false;
        s += s;
        return search(s, goal);
    }
};
