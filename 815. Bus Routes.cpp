class Solution {
public:
    int numBusesToDestination(std::vector<std::vector<int>>& routes, int source, int target) {
        if (source == target) return 0;
        std::unordered_map<int, std::vector<int>> adj;

        for (int i = 0; i < (int)routes.size(); i++) {
            for (int stop : routes[i]) {
                adj[stop].push_back(i);
            }
        }

        if (adj.find(source) == adj.end()) return -1;
        std::unordered_set<int> visited;
        std::queue<int> q;
        q.push(source);
        for (int route : adj[source]) {
            for (int stop : routes[route]) {
                if (stop != source) q.push(stop);
            }
            visited.insert(route);
        }

        int ans = 1;
        while (!q.empty()) {
            int size = (int)q.size();
            while (size != 0) {
                int station = q.front();
                q.pop();
                if (station == target) return ans;

                for (int route : adj[station]) {
                    if (visited.count(route)) continue;
                    for (int stop : routes[route]) {
                        if (stop != station) q.push(stop);
                    }
                    visited.insert(route);
                }

                size--;
            }
            ans++;
        }

        return -1;
    }
};