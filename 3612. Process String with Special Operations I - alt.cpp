class Solution {
public:
    string processStr(string s) {
        string sb = "";  
        int n = s.length();

        for (char ch : s) {
            if (islower(ch)) {
                sb.push_back(ch);
            }
            else if (ch == '*') {
                if (!sb.empty()) {
                    sb.pop_back();
                }
            }
            else if (ch == '#') {
                if (!sb.empty()) {
                    sb += sb; 
                }
            }
            else {
                reverse(sb.begin(), sb.end());
            }
        }

        return sb;
    }
};
