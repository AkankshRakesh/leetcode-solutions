class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b) {
            if (a[0] != b[0]) return a[0] < b[0];
            return a[1] < b[1];
        });

        vector<vector<int>> result;
        int n = intervals.size();
        int low = intervals[0][0];
        int high = intervals[0][1];

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] <= high) {
                high = max(high, intervals[i][1]);
            } else {
                result.push_back({low, high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }

        result.push_back({low, high});
        return result;
    }
};
