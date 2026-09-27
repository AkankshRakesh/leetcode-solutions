class Solution {
public:
    string solve(string& s, int& index) {
        string sb = "";

        while (index < s.length() && s[index] != ')') {
            if (s[index] == '(') {
                index++;
                sb += solve(s, index);
            }
            else {
                sb += s[index];
                index++;
            }
        }

        index++;
        reverse(sb.begin(), sb.end());
        return sb;
    }

    string reverseParentheses(string s) {
        int index = 0;
        string ans = solve(s, index);
        reverse(ans.begin(), ans.end());
        return ans;
    }
};