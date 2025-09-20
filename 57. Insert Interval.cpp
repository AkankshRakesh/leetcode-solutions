class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        stack<vector<int>> st;
        st.push(intervals[0]);

        for (int i = 1; i < intervals.size(); i++) {
            vector<int> last = st.top();
            vector<int> curr = intervals[i];

            if (last[1] >= curr[0]) {
                if (last[1] >= curr[1]) continue;
                else {
                    st.pop();
                    st.push({last[0], curr[1]});
                }
            } else {
                st.push(curr);
            }
        }

        vector<vector<int>> ans(st.size(), vector<int>(2));
        int ind = 0;
        while (!st.empty()) {
            ans[ind++] = st.top();
            st.pop();
        }

        return ans;
    }

    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> preAns(intervals.size() + 1, vector<int>(2));
        preAns[0] = newInterval;
        for (int i = 0; i < intervals.size(); i++) {
            preAns[i + 1] = intervals[i];
        }

        vector<vector<int>> ans = merge(preAns);
        sort(ans.begin(), ans.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        return ans;
    }
};
