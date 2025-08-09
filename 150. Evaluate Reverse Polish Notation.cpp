class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        int n = tokens.size();
        
        for (int i = 0; i < n; i++) {
            string token = tokens[i];
            if (token == "/" || token == "+" || token == "-" || token == "*") {
                int top = st.top(); st.pop();
                int secondTop = st.top(); st.pop();
                if (token == "/") {
                    secondTop /= top;
                } else if (token == "*") {
                    secondTop *= top;
                } else if (token == "+") {
                    secondTop += top;
                } else if (token == "-") {
                    secondTop -= top;
                }
                st.push(secondTop);
            } else {
                st.push(stoi(token));
            }
        }
        
        return st.top();
    }
};
