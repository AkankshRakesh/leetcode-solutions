class Solution {
    struct Pair {
        char ch;
        int num;
        Pair(char c, int n) : ch(c), num(n) {}
    };
    
public:
    string removeDuplicates(string s, int k) {
        stack<Pair> st;

        for (char ch : s) {
            if (!st.empty() && st.top().ch == ch) {
                Pair top = st.top();
                st.pop();
                st.push(Pair(ch, top.num + 1));
            } else {
                st.push(Pair(ch, 1));
            }

            // Remove group if frequency == k
            if (!st.empty() && st.top().num == k) {
                st.pop();
            }
        }

        // Build final string
        string result = "";
        stack<Pair> reversed;

        // Reverse stack to build result in correct order
        while (!st.empty()) {
            reversed.push(st.top());
            st.pop();
        }

        while (!reversed.empty()) {
            Pair p = reversed.top();
            reversed.pop();
            result.append(p.num, p.ch); // repeat char `num` times
        }

        return result;
    }
};