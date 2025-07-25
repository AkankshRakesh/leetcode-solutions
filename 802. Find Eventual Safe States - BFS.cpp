class Solution {
public:
    bool dfs(unordered_map<int, vector<int>>& graph, int node, vector<bool>& visited, vector<bool>& result) {
        if (visited[node]) return result[node];

        visited[node] = true;
        bool isSafe = true;

        for (int neighbor : graph[node]) {
            isSafe = isSafe && dfs(graph, neighbor, visited, result);
        }

        result[node] = isSafe;
        return isSafe;
    }

    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        unordered_map<int, vector<int>> adj;
        for (int i = 0; i < n; ++i) {
            adj[i] = graph[i];
        }

        vector<bool> visited(n, false);
        vector<bool> result(n, false);
        vector<int> safeNodes;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(adj, i, visited, result);
            }
            if (result[i]) {
                safeNodes.push_back(i);
            }
        }

        return safeNodes;
    }
};
