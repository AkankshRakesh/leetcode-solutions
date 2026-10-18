class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<int> st;
        vector<int> ns(n, n);
        vector<int> ps(n, -1);

        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.top()] > heights[i]) {
                ns[st.top()] = i;
                st.pop();
            }

            st.push(i);
        }

        st = stack<int>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && heights[st.top()] > heights[i]) {
                ps[st.top()] = i;
                st.pop();
            }

            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, heights[i] * (ns[i] - ps[i] - 1));
        }

        return ans;
    }
};