class Solution {
public:
    string longestPrefix(string s) {
        vector<int> arr(s.length());
        int len = 0;
        int i = 1;
        while (i < s.length()) {
            if (s[i] == s[len]) {
                len++;
                arr[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = arr[len - 1];
                } else {
                    arr[i] = 0;
                    i++;
                }
            }
        } 

        return s.substr(0, arr[s.length() - 1]);
    }
};
