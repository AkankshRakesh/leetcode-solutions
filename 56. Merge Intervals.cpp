class Solution {
public:
    bool isOverlap(int x1, int y1, int x2, int y2) {
        if (x2 <= y1) return true;
        return false;
    }

    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] != b[0] ? a[0] < b[0] : a[1] < b[1];
        });

        vector<vector<int>> res;
        int index = 0;

        while (index < intervals.size()) {
            int maxR = intervals[index][1];
            int minL = intervals[index][0];

            while (index + 1 < intervals.size() &&
                   isOverlap(minL, maxR, intervals[index + 1][0], intervals[index + 1][1])) {
                maxR = max(maxR, intervals[index + 1][1]);
                index++;
            }

            res.push_back({minL, maxR});
            index++;
        }

        return res;
    }
};