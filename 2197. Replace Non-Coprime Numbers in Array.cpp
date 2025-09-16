class Solution {
public:
    int gcdComp(int a, int b) {
        if (a == 0) return b;
        return gcdComp(b % a, a);
    }

    vector<int> replaceNonCoprimes(vector<int>& nums) {
        stack<int> st;
        vector<int> res;

        for (int num : nums) {
            long long x = num; 
            while (!st.empty()) {
                int top = st.top();
                int g = gcdComp(top, (int)x);
                if (g == 1) break;

                x = x / g * top;
                st.pop();
            }
            st.push((int)x);
        }

        while (!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
