class Solution {
public:
    bool bfs(unordered_map<int, vector<vector<int>>>& adj, int vertex, vector<int>& color, int target) {
        queue<int> q;
        q.push(vertex);
        color[vertex] = 0;

        while (!q.empty()) {
            int u = q.front();
            q.pop();

            for (vector<int>& neig : adj[u]) {
                int v = neig[0];
                int dist = neig[1];

                if (dist >= target) continue;

                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.push(v);
                }
                else if (color[v] == color[u]) {
                    return false;
                }
            }
        }

        return true;
    }

    bool isPossible(vector<vector<int>>& points, int target, unordered_map<int, vector<vector<int>>>& adj) {
        vector<int> color(points.size(), -1);

        for (int i = 0; i < points.size(); i++) {
            if (color[i] == -1 && !bfs(adj, i, color, target))
                return false;
        }

        return true;
    }

    int maxPartitionFactor(vector<vector<int>>& points) {
        if (points.size() == 2) return 0;

        int left = 0, right = 0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int dist = abs(points[i][0] - points[j][0])
                         + abs(points[i][1] - points[j][1]);

                right = max(right, dist);
            }
        }

        unordered_map<int, vector<vector<int>>> adj;

        for (int i = 0; i < points.size(); i++) {
            vector<vector<int>> arr;

            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;

                int dist = abs(points[i][0] - points[j][0])
                         + abs(points[i][1] - points[j][1]);

                arr.push_back({j, dist});
            }

            adj[i] = arr;
        }

        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(points, mid, adj)) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}; 