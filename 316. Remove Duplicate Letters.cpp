class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> lastInd(26);
        for (int i = 0; i < (int)s.size(); i++)
            lastInd[s[i] - 'a'] = i;

        vector<bool> seen(26, false);
        stack<char> st;

        for (int i = 0; i < (int)s.size(); i++) {
            char ch = s[i];
            if (seen[ch - 'a']) continue;

            while (!st.empty() && ch < st.top() && lastInd[st.top() - 'a'] > i) {
                seen[st.top() - 'a'] = false;
                st.pop();
            }

            st.push(ch);
            seen[ch - 'a'] = true;
        }

        string ans;
        while (!st.empty()) {
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
