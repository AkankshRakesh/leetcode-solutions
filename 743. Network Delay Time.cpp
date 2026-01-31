using namespace std;

class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        unordered_map<int, vector<pair<int, int>>> adj;
        vector<bool> visited(n + 1, false);

        for (const auto& time : times) {
            adj[time[0]].emplace_back(time[1], time[2]);
        }

        // Min-heap priority queue: pair<vertex, cost>, ordered by cost
        priority_queue<pair<int, int>, vector<pair<int, int>>, 
                       function<bool(pair<int,int>, pair<int,int>)>> q(
            [](const pair<int,int>& a, const pair<int,int>& b) {
                return a.second > b.second;
            }
        );

        q.emplace(k, 0);

        int ans = 0;
        while (!q.empty()) {
            auto [vertex, cost] = q.top();
            q.pop();

            if (visited[vertex]) continue;
            visited[vertex] = true;
            ans = max(ans, cost);

            if (adj.find(vertex) == adj.end()) continue;

            for (const auto& neig : adj[vertex]) {
                if (!visited[neig.first]) {
                    q.emplace(neig.first, cost + neig.second);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return -1;
        }

        return ans;
    }
};