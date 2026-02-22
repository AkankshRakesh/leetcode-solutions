class Solution {
public:
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;

        DSU(int n) : parent(n), rank(n, 0) {
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int vertex) {
            if (parent[vertex] != vertex) 
                parent[vertex] = find(parent[vertex]);
            return parent[vertex];
        }

        bool unionSet(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);
            if (p1 == p2) return false;

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                rank[p1]++;
            }

            return true;
        }
    };

    int kruskal(int n, vector<vector<int>>& edges, int skipIndex, int pickIndex) {
        auto cmp = [](const vector<int>& a, const vector<int>& b) {
            return a[2] > b[2];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);

        int index = 0;
        int ans = 0;

        for (auto& edge : edges) {
            if (index == skipIndex) {
                index++;
                continue;
            }
            pq.push(edge);
            index++;
        }

        DSU dsu(n);
        if (pickIndex != -1 && dsu.unionSet(edges[pickIndex][0], edges[pickIndex][1])) {
            ans += edges[pickIndex][2];
        }

        while (!pq.empty()) {
            vector<int> edge = pq.top();
            pq.pop();
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (dsu.unionSet(u, v)) {
                ans += weight;
            }
        }

        int parent = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (parent != dsu.find(i)) return INT_MAX;
        }

        return ans;
    }

    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        int minWeight = kruskal(n, edges, -1, -1);
        vector<vector<int>> ans(2);

        int index = 0;
        for (auto& edge : edges) {
            if (kruskal(n, edges, index, -1) > minWeight) 
                ans[0].push_back(index);
            else if (kruskal(n, edges, -1, index) == minWeight) 
                ans[1].push_back(index);

            index++;
        }

        return ans;
    }
};