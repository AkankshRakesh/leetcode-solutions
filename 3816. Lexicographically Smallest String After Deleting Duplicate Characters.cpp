class Solution {
public:
    string lexSmallestAfterDeletion(string s) {
        int freq[128] = {};
        for (int i = 0; i < s.length(); i++) {
            freq[s[i]]++;
        }

        stack<char> st;
        for (int i = 0; i < s.length(); i++) {
            while (st.size() > 0 && st.top() > s[i] && freq[st.top()] > 1) {
                freq[st.top()]--;
                st.pop();
            }
            st.push(s[i]); 
        }

        char dup = st.top();
        while (st.size() > 0 && freq[st.top()] > 1) {
            freq[st.top()]--;
            st.pop();
        }

        string sb;
        while (!st.empty()) {
            sb += st.top();
            st.pop();
        }

        reverse(sb.begin(), sb.end());

        return sb;
    }
};