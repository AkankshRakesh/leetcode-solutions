class Solution {
    class DSU {
        vector<int> parent;
        vector<int> rank;
    public:
        DSU(int n) : parent(n), rank(n, 1) {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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

            if (rank[p1] > rank[p2]) parent[p2] = p1;
            else if (rank[p1] < rank[p2]) parent[p1] = p2;
            else {
                parent[p2] = p1;
                rank[p1]++;
            }
        }
    };

public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        using Edge = vector<int>;
        auto cmp = [](const Edge& a, const Edge& b) { return a[2] > b[2]; };
        priority_queue<Edge, vector<Edge>, decltype(cmp)> pq(cmp);

        int n = points.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                pq.push({i, j, dist});
            }
        }

        int cost = 0;
        DSU dsu(n);
        while (!pq.empty()) {
            auto edge = pq.top();
            pq.pop();
            int u = edge[0];
            int v = edge[1];
            int edgeCost = edge[2];
            if (dsu.find(u) != dsu.find(v)) {
                dsu.unionSets(u, v);
                cost += edgeCost;
            }
        }

        return cost;
    }
};