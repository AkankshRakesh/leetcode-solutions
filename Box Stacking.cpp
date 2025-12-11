class Solution {
public:
    static int LIS(vector<array<int,3>>& arr) {
        vector<int> dp(arr.size());
        for (int i = 0; i < arr.size(); i++) dp[i] = arr[i][2];

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    dp[i] = max(dp[i], dp[j] + arr[i][2]);
                }
            }
        }

        int ans = dp[0];
        for (int i = 1; i < arr.size(); i++) ans = max(ans, dp[i]);

        return ans;
    }

    static int maxHeight(vector<int>& height, vector<int>& width, vector<int>& length) {
        vector<array<int,3>> arr;
        for (int i = 0; i < height.size(); i++) {
            int h = height[i], w = width[i], l = length[i];
            arr.push_back({h, w, l});
            arr.push_back({h, l, w});
            arr.push_back({l, h, w});
            arr.push_back({l, w, h});
            arr.push_back({w, l, h});
            arr.push_back({w, h, l});
        }

        sort(arr.begin(), arr.end(),
             [](auto &a, auto &b) {
                 return (a[0] != b[0]) ? a[0] < b[0] : a[1] < b[1];
             });

        return LIS(arr);
    }
};
