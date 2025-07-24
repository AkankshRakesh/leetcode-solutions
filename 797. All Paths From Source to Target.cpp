class Solution {
public:
    void dfs(unordered_map<int, vector<int>>& adj, vector<vector<int>>& ans,
             vector<int>& currPath, int node, int target) {
        currPath.push_back(node);

        if (node == target) {
            ans.push_back(currPath);
        } else {
            for (int neighbor : adj[node]) {
                dfs(adj, ans, currPath, neighbor, target);
            }
        }

        currPath.pop_back();
    }

    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        unordered_map<int, vector<int>> adj;
        int n = graph.size();

        for (int i = 0; i < n; ++i) {
            adj[i] = graph[i];
        }

        vector<vector<int>> ans;
        vector<int> path;
        dfs(adj, ans, path, 0, n - 1);
        return ans;
    }
};
