class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        map<int, vector<int>> hm;
        int n = points.size();

        for (int i = 0; i < n; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            hm[dist].push_back(i);
        }

        vector<vector<int>> ans(k);
        int ind = 0;

        for (auto& [dist, indices] : hm) {
            for (int i = 0; i < indices.size() && ind < k; ++i) {
                ans[ind++] = points[indices[i]];
            }
            if (ind >= k) break;
        }

        return ans;
    }
};
