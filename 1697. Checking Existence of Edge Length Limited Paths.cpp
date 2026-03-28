class Solution {
public:
    class DSU {
    public:
        vector<int> parent;
        vector<int> rank;

        DSU(int n) : parent(n), rank(n, 0) {
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int n) {
            if (parent[n] != n) parent[n] = find(parent[n]);
            return parent[n];
        }

        void union_sets(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) return;

            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    };

    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edgeList, vector<vector<int>>& qs) {
        sort(edgeList.begin(), edgeList.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[2] < b[2];
        });

        vector<vector<int>> queries(qs.size(), vector<int>(4));
        for (int i = 0; i < (int)qs.size(); i++) {
            queries[i][0] = qs[i][0];
            queries[i][1] = qs[i][1];
            queries[i][2] = qs[i][2];
            queries[i][3] = i;
        }

        sort(queries.begin(), queries.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[2] < b[2];
        });

        DSU dsu(n);
        vector<bool> ans(queries.size());
        int index = 0;
        for (int i = 0; i < (int)queries.size(); i++) {
            while (index < (int)edgeList.size() && edgeList[index][2] < queries[i][2]) {
                dsu.union_sets(edgeList[index][0], edgeList[index][1]);
                index++;
            }

            ans[queries[i][3]] = (dsu.find(queries[i][0]) == dsu.find(queries[i][1]));
        }

        return ans;
    }
};