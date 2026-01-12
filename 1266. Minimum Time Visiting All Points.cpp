class Solution {
public:
    int minTimeToVisitAllPoints(std::vector<std::vector<int>>& points) {
        int ans = 0;
        for (size_t i = 1; i < points.size(); i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];

            ans += std::max(std::abs(x1 - x2), std::abs(y1 - y2));
        }
        return ans;
    }
};