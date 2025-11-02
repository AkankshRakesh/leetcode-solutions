class Solution {
public:
    string longestPalindrome(string s) {
        string sb = "#";
        for (char ch : s) {
            sb += ch;
            sb += "#";
        }

        int ansLen = 0;
        int ansCenter = 0;

        for (int i = 0; i < (int)sb.size(); i++) {
            int left = i - 1, right = i + 1;
            int len = (sb[i] == '#') ? 0 : 1;

            while (left >= 0 && right < (int)sb.size() && sb[left] == sb[right]) {
                if (sb[left] != '#') len += 2;
                left--;
                right++;
            }

            if (len > ansLen) {
                ansCenter = i;
                ansLen = len;
            }
        }

        int start = ansCenter - ansLen;
        int end = ansCenter + ansLen;
        string result = "";

        for (int i = start; i <= end; i++) {
            if (sb[i] != '#') result += sb[i];
        }

        return result;
    }
};