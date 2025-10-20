class Solution {
public:
    void dfs(unordered_map<int, vector<int>>& adj, int vertex, vector<bool>& visited, vector<int>& ans) {
        visited[vertex] = true;

        for (int neig : adj[vertex]) {
            if (!visited[neig]) {
                dfs(adj, neig, visited, ans);
            }
        }

        ans.push_back(vertex);
    }

    bool canFinish(int numCourses, vector<vector<int>>& prereq) {
        unordered_map<int, vector<int>> adj;
        vector<bool> visited(numCourses, false);

        for (int i = 0; i < numCourses; i++) adj[i] = vector<int>();
        for (auto& arr : prereq) {
            int u = arr[1];
            int v = arr[0];
            adj[u].push_back(v);
        }

        vector<int> ans;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) dfs(adj, i, visited, ans);
        }

        reverse(ans.begin(), ans.end());

        unordered_map<int, int> hr;
        int ind = 0;
        for (int v : ans) hr[v] = ind++;

        for (auto& arr : prereq) {
            int u = arr[1];
            int v = arr[0];
            if (hr[v] <= hr[u]) return false;
        }

        return true;
    }
};