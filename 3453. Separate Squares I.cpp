class Solution {
public:
    double separateSquares(vector<vector<int>>& squares) {
        double left = DBL_MAX;
        double right = DBL_MIN;
        double totalArea = 0;

        for (auto& s : squares) {
            left = min(left, (double)s[1]);
            right = max(right, (double)(s[1] + s[2]));
            totalArea += (double)s[2] * s[2];
        }

        double ans = -1;
        while (right - left > 1e-6) {
            double mid = left + (right - left) / 2;
            double areaAbove = 0;

            for (auto& square : squares) {
                if (square[1] > mid) {
                    areaAbove += (double)square[2] * square[2];
                }
                else if (square[1] + square[2] > mid) {
                    double len = (double)(square[1] + square[2]) - mid;
                    areaAbove += len * square[2];
                }
            }

            double areaBelow = totalArea / 2;

            if (areaAbove > areaBelow) {
                left = mid;
            } else {
                ans = mid;
                right = mid;
            }
        }

        return ans;
    }
};
