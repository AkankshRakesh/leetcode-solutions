class Solution {
    struct Pair {
        string vertex;
        double weight;
        Pair(const string& vertex, double weight) : vertex(vertex), weight(weight) {}
    };
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        unordered_map<string, vector<Pair>> adj;
        for (size_t i = 0; i < values.size(); i++) {
            adj[equations[i][0]].emplace_back(equations[i][1], values[i]);
            adj[equations[i][1]].emplace_back(equations[i][0], 1.0 / values[i]);
        }

        vector<double> ans(queries.size());
        int index = 0;
        for (const auto& query : queries) {
            unordered_map<string, double> visited;
            queue<Pair> q;

            if (adj.find(query[0]) == adj.end()) {
                ans[index++] = -1;
                continue;
            }

            visited[query[0]] = 1.0;
            q.emplace(query[0], 1.0);

            while (!q.empty()) {
                Pair top = q.front();
                q.pop();

                if (adj.find(top.vertex) == adj.end()) continue;

                for (const auto& neig : adj[top.vertex]) {
                    if (visited.find(neig.vertex) == visited.end()) {
                        double new_weight = top.weight * neig.weight;
                        q.emplace(neig.vertex, new_weight);
                        visited[neig.vertex] = new_weight;
                    }
                }
            }

            ans[index++] = visited.count(query[1]) ? visited[query[1]] : -1;
        }

        return ans;
    }
};