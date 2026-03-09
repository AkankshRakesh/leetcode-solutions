class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        vector<int> ans;
        if (n == 1) {
            ans.push_back(0);
            return ans;
        }
        if (n == 2) {
            ans.push_back(0);
            ans.push_back(1);
            return ans;
        }

        unordered_map<int, vector<int>> adj;
        vector<int> inDeg(n, 0);

        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
        }

        int nodesRemoved = 0;
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1) {
                q.push(i);
                nodesRemoved++;
                inDeg[i] = 0;
            }
        }

        while (!q.empty()) {
            if (n - nodesRemoved <= 2) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.front();
                q.pop();
                for (int neig : adj[node]) {
                    inDeg[neig]--;
                    if (inDeg[neig] == 1) {
                        nodesRemoved++;
                        q.push(neig);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDeg[i] > 1) ans.push_back(i);
        }

        return ans;
    }
};