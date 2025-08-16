#include <bits/stdc++.h>
using namespace std;

class Solution {
    struct Edge {
        int to, w;
        Edge(int t, int w) : to(t), w(w) {}
    };

public:
    int minCost(int n, vector<vector<int>>& edges) {
        vector<vector<Edge>> adj(n);
        for (auto &e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].push_back(Edge(v, w));       // normal edge
            adj[v].push_back(Edge(u, 2 * w));   // reversed edge
        }

        vector<vector<long long>> dist(n, vector<long long>(2, LLONG_MAX));
        dist[0][0] = 0;

        priority_queue<array<long long,3>, vector<array<long long,3>>, greater<>> pq;
        pq.push({0, 0, 0}); // {cost, node, switchUsed}

        while (!pq.empty()) {
            auto cur = pq.top(); pq.pop();
            long long d = cur[0];
            int u = cur[1], s = cur[2];

            if (d > dist[u][s]) continue;

            for (auto &e : adj[u]) {
                int v = e.to;
                long long w = e.w;
                int ns = (w % 2 == 0) ? 1 : s; // reversed edge, switch used
                if (dist[v][ns] > d + w) {
                    dist[v][ns] = d + w;
                    pq.push({dist[v][ns], v, ns});
                }
            }
        }

        long long ans = min(dist[n-1][0], dist[n-1][1]);
        return ans == LLONG_MAX ? -1 : (int) ans;
    }
};
