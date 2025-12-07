class Solution {
public:
    bool overlaps(vector<int>& a, vector<int>& b) {
        if (a[1] >= b[0] && a[0] <= b[1]) return true;
        return false;
    }

    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        if (intervals.size() == 0) return { newInterval };

        stack<vector<int>> st;
        bool added = false;

        for (int i = 0; i < intervals.size(); i++) {
            if (st.empty()) {
                st.push(intervals[i]);
            }
            else if (!added && overlaps(st.top(), newInterval)) {
                vector<int> a = st.top(); st.pop();
                vector<int> combined(2);
                combined[0] = min(a[0], newInterval[0]);
                combined[1] = max(a[1], newInterval[1]);
                st.push(combined);
                i--;
                added = true;
            }
            else if (!added && newInterval[0] < st.top()[0]) {
                vector<int> a = st.top(); st.pop();
                st.push(newInterval);
                st.push(a);
                added = true;
                i--;
            }
            else if (overlaps(st.top(), intervals[i])) {
                vector<int> a = st.top(); st.pop();
                vector<int> combined(2);
                combined[0] = min(a[0], intervals[i][0]);
                combined[1] = max(a[1], intervals[i][1]);
                st.push(combined);
            }
            else {
                st.push(intervals[i]);
            }
        }

        if (!added && overlaps(st.top(), newInterval)) {
            vector<int> a = st.top(); st.pop();
            vector<int> combined(2);
            combined[0] = min(a[0], newInterval[0]);
            combined[1] = max(a[1], newInterval[1]);
            st.push(combined);
        }
        else if (!added && newInterval[0] < st.top()[0]) {
            vector<int> a = st.top(); st.pop();
            st.push(newInterval);
            st.push(a);
            added = true;
        }
        else if (!added) {
            st.push(newInterval);
        }

        vector<vector<int>> ans(st.size(), vector<int>(2));
        for (int i = ans.size() - 1; i >= 0; i--) {
            ans[i] = st.top();
            st.pop();
        }

        return ans;
    }
};
