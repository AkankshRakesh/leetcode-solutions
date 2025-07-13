class Solution {
public:
    int minCost(int n, vector<vector<int>>& edges, int k) {
        int left = 0, right = 0;

        for (const auto& edge : edges) {
            right = max(right, edge[2]);
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (canSplit(n, edges, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

private:
    bool canSplit(int n, vector<vector<int>>& edges, int k, int weight) {
        vector<vector<int>> graph(n);

        for (const auto& edge : edges) {
            if (edge[2] <= weight) {
                graph[edge[0]].push_back(edge[1]);
                graph[edge[1]].push_back(edge[0]);
            }
        }

        vector<bool> visited(n, false);
        int comps = 0;

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                comps++;
                dfs(i, graph, visited);
            }
        }

        return comps <= k;
    }

    void dfs(int node, vector<vector<int>>& graph, vector<bool>& visited) {
        stack<int> stk;
        stk.push(node);
        visited[node] = true;

        while (!stk.empty()) {
            int curr = stk.top();
            stk.pop();

            for (int neighbor : graph[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stk.push(neighbor);
                }
            }
        }
    }
};
