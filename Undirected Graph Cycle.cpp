class Solution {
public:
    bool dfs(int node, int parent, unordered_map<int, vector<int>>& adj, vector<bool>& visited) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited)) return true;
            } else if (neighbor != parent) {
                return true; // A visited node that's not the parent means a cycle
            }
        }

        return false;
    }

    bool isCycle(int V, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adj;

        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        vector<bool> visited(V, false);
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) return true;
            }
        }

        return false;
    }
};
