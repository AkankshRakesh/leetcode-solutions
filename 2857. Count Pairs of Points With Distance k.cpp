class Solution {
public:
    int countPairs(vector<vector<int>>& coords, int k) {
        int ans = 0;
        unordered_map<string, int> hm;

        for (int i = coords.size() - 1; i >= 0; i--) {
            int x1 = coords[i][0];
            int y1 = coords[i][1];

            for (int u = 0; u <= k; u++) {
                int x2 = u ^ x1;
                int y2 = (k - u) ^ y1;

                string key = to_string(x2) + "#" + to_string(y2);
                if (hm.count(key))
                    ans += hm[key];
            }

            string key = to_string(x1) + "#" + to_string(y1);
            hm[key]++;
        }

        return ans;
    }
};