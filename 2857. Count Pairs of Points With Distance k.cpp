class Solution {
public:
    long long countPairs(vector<vector<int>>& coords, int k) {
        long long ans = 0;

        unordered_map<long long, int> mp;
        mp.reserve(coords.size() * 2);
        mp.max_load_factor(0.7);

        auto getKey = [](int x, int y) -> long long {
            return (static_cast<long long>(x) << 32) |
                   static_cast<unsigned int>(y);
        };

        for (int i = coords.size() - 1; i >= 0; --i) {
            int x = coords[i][0];
            int y = coords[i][1];

            for (int u = 0; u <= k; ++u) {
                int x2 = x ^ u;
                int y2 = y ^ (k - u);

                long long key = getKey(x2, y2);

                auto it = mp.find(key);
                if (it != mp.end())
                    ans += it->second;
            }

            mp[getKey(x, y)]++;
        }

        return ans;
    }
};