class Solution {
public:
    bool isPalindrome(string s) {
        string sb;
        int n = s.size();

        for (int i = 0; i < n; i++) {
            if ((s[i] >= 'a' && s[i] <= 'z') ||
                (s[i] >= 'A' && s[i] <= 'Z') ||
                (s[i] >= '0' && s[i] <= '9')) 
            {
                sb.push_back(tolower(s[i]));
            }
        }

        int m = sb.size();
        for (int i = 0; i < m / 2; i++) {
            if (sb[i] != sb[m - 1 - i]) return false;
        }

        return true;
    }
};
