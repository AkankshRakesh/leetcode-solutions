class Solution {
    class DSU {
        vector<int> parent;
        vector<int> size;
    public:
        DSU(int n) : parent(n), size(n, 1) {
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int node) {
            if (parent[node] != node)
                parent[node] = find(parent[node]);
            return parent[node];
        }

        void unionSets(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 == p2) return;

            if (size[p1] > size[p2]) {
                size[p1] += size[p2];
                parent[p2] = p1;
            } else {
                size[p2] += size[p1];
                parent[p1] = p2;
            }
        }

        int getSize(int n) {
            return size[find(n)];
        }
    };

public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int cost = 0;
        vector<vector<int>> edges;
        int n = points.size();
        DSU dsu(n);

        for (int i = 0; i < n; i++) {
            auto& pointsA = points[i];
            for (int j = i + 1; j < n; j++) {
                auto& pointsB = points[j];
                edges.push_back({i, j, abs(pointsA[0] - pointsB[0]) + abs(pointsA[1] - pointsB[1])});
            }
        }

        sort(edges.begin(), edges.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[2] < b[2];
        });

        for (auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dsu.find(u) == dsu.find(v)) continue;
            dsu.unionSets(u, v);
            cost += edge[2];
            if (dsu.getSize(u) == n) return cost;
        }

        return 0;
    }
};

