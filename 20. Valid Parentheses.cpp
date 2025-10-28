class Solution {
public:
    bool check(char top, char curr) {
        if ((top == '(' && curr == ')') || 
            (top == '[' && curr == ']') || 
            (top == '{' && curr == '}'))
            return true;
        return false;
    }

    bool isValid(string s) {
        stack<char> st;
        for (char ch : s) {
            if (st.empty()) {
                st.push(ch);
                continue;
            }
            char top = st.top();
            if (check(top, ch))
                st.pop();
            else
                st.push(ch);
        }

        if (st.size() != 0) return false;
        return true;
    }
};
