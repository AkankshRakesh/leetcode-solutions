#include <iostream>
#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    string makeGood(string s) {
        stack<char> st;

        for (int i = 0; i < s.length(); i++) {
            st.push(s[i]);
            char top = st.top(); st.pop();

            if (st.size() >= 1) {
                char secondTop = st.top();
                if (top >= 'A' && top <= 'Z') {
                    if (secondTop >= 'a' && secondTop <= 'z') {
                        if (top - 'A' == secondTop - 'a') st.pop();
                        else st.push(top);
                    } else {
                        st.push(top);
                    }
                } else {
                    if (secondTop >= 'A' && secondTop <= 'Z') {
                        if (top - 'a' == secondTop - 'A') st.pop();
                        else st.push(top);
                    } else {
                        st.push(top);
                    }
                }
            } else {
                st.push(top);
            }
        }

        string ans = "";
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};
