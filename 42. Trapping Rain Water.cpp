class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> fromLeft(n), fromRight(n);
        fromLeft[0] = 0;
        fromRight[n - 1] = 0;

        int maxVal = height[0];
        for (int i = 1; i < n; i++) {
            if (height[i] > maxVal) {
                fromLeft[i] = 0;
                maxVal = height[i];
            } else {
                fromLeft[i] = maxVal - height[i];
            }
        }

        maxVal = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > maxVal) {
                fromRight[i] = 0;
                maxVal = height[i];
            } else {
                fromRight[i] = maxVal - height[i];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (fromLeft[i] == 0 || fromRight[i] == 0) continue;
            ans += min(fromLeft[i], fromRight[i]);
        }

        return ans;
    }
};
