class Solution {
    class DSU {
    public:
        unordered_map<int, int> parent;
        unordered_map<int, priority_queue<int, vector<int>, greater<int>>> indexes;

        int find(int n) {
            if (parent[n] == n) return n;
            parent[n] = find(parent[n]);
            return parent[n];
        }

        void unite(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            parent[py] = px;

            while (!indexes[py].empty()) {
                indexes[px].push(indexes[py].top());
                indexes[py].pop();
            }

            indexes.erase(py);
        }
    };

public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        DSU dsu;
        int n = nums.size();

        vector<pair<int, int>> arr(n);

        for (int i = 0; i < n; i++) {
            arr[i] = {nums[i], i};

            dsu.parent[i] = i;

            priority_queue<int, vector<int>, greater<int>> pq;
            pq.push(i);
            dsu.indexes[i] = pq;
        }

        sort(arr.begin(), arr.end());

        for (int i = 0; i < n - 1; i++) {
            int x = arr[i].first;
            int y = arr[i + 1].first;

            if (y - x <= limit) {
                dsu.unite(arr[i].second, arr[i + 1].second);
            }
        }

        vector<int> ans(n);

        for (auto& pair : arr) {
            int num = pair.first;
            int index = pair.second;

            int parent = dsu.find(index);
            int targetIndex = dsu.indexes[parent].top();
            dsu.indexes[parent].pop();

            ans[targetIndex] = num;
        }

        return ans;
    }
};