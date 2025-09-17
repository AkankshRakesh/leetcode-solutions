class Solution {
public:
    struct Pair {
        int t;
        int ind;
        Pair(int temp, int index) : t(temp), ind(index) {}
    };

    vector<int> dailyTemperatures(vector<int>& temp) {
        stack<Pair> st;
        st.push(Pair(temp[0], 0));

        vector<int> ans(temp.size(), 0);

        for (int i = 1; i < (int)temp.size(); i++) {
            while (!st.empty() && temp[i] > st.top().t) {
                ans[st.top().ind] = i - st.top().ind;
                st.pop();
            }
            st.push(Pair(temp[i], i));
        }

        return ans;
    }
};
