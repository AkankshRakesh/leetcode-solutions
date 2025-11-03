class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        stack<int> st;
        st.push(0);
        int ans = 0;

        for (int i = 1; i < colors.size(); i++) {
            int top = st.top();
            if (colors[top] == colors[i]) {
                if (neededTime[top] > neededTime[i]) {
                    ans += neededTime[i];
                } else {
                    ans += neededTime[top];
                    st.pop();
                    st.push(i);
                }
            } else {
                st.push(i);
            }
        }

        return ans;
    }
};