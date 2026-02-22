class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> st;
        vector<vector<int>> dp(heights.size(), vector<int>(2));
        
        for (int i = 0; i < (int)heights.size(); i++) {
            while (!st.empty() && heights[st.top()] >= heights[i]) st.pop();

            if (!st.empty()) dp[i][0] = st.top();
            else dp[i][0] = -1;

            st.push(i);
        }
        st = stack<int>();

        for (int i = (int)heights.size() - 1; i >= 0; i--) {
            while (!st.empty() && heights[st.top()] >= heights[i]) st.pop();

            if (!st.empty()) dp[i][1] = st.top();
            else dp[i][1] = (int)heights.size();

            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < (int)heights.size(); i++) {
            ans = max(ans, (dp[i][1] - dp[i][0] - 1) * heights[i]);
        }

        return ans;
    }
};