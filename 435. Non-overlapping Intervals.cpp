class Solution {
public:
    int eraseOverlapIntervals(std::vector<std::vector<int>>& intervals) {
        std::sort(intervals.begin(), intervals.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            return a[1] < b[1];
        });

        int n = intervals.size();
        int ans = 0;
        int last = 0;

        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] < intervals[last][1]) {
                ++ans;
            } else {
                last = i;
            }
        }

        return ans;
    }
};
