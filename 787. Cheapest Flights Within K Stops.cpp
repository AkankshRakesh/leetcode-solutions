class Solution {
public:
    struct Node {
        int node, cost, jump;
        Node(int n, int c, int j) : node(n), cost(c), jump(j) {}
    };

    struct Pair {
        int node, cost;
        Pair(int n, int c) : node(n), cost(c) {}
    };

    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        unordered_map<int, vector<Pair>> adj;

        for (auto& flight : flights) {
            adj[flight[0]].push_back(Pair(flight[1], flight[2]));
        }

        auto cmp = [](const Node& a, const Node& b) {
            return a.cost > b.cost;
        };

        priority_queue<Node, vector<Node>, decltype(cmp)> pq(cmp);
        pq.push(Node(src, 0, 0));

        vector<vector<int>> best(n, vector<int>(k + 2, INT_MAX));
        best[src][0] = 0;

        while (!pq.empty()) {
            Node top = pq.top();
            pq.pop();

            if (top.node == dst) return top.cost;
            if (top.jump > k || adj.find(top.node) == adj.end()) continue;
            if (top.cost > best[top.node][top.jump]) continue;

            for (auto& next : adj[top.node]) {
                int newCost = top.cost + next.cost;
                int nextJump = top.jump + 1;

                if (newCost < best[next.node][nextJump]) {
                    best[next.node][nextJump] = newCost;
                    pq.push(Node(next.node, newCost, nextJump));
                }
            }
        }

        return -1;
    }
};
