class Solution {
    struct Pair {
        int point;
        int dist;
        Pair(int p, int d) : point(p), dist(d) {}
    };
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        vector<bool> visited(n, false);

        auto cmp = [](const Pair& a, const Pair& b) {
            return a.dist > b.dist;
        };
        priority_queue<Pair, vector<Pair>, decltype(cmp)> pq(cmp);

        int ans = 0;
        pq.push(Pair(0, 0));

        while (!pq.empty()) {
            Pair p = pq.top();
            pq.pop();
            if (visited[p.point]) continue;

            ans += p.dist;
            visited[p.point] = true;

            for (int neig = 0; neig < n; neig++) {
                if (neig == p.point || visited[neig]) continue;
                int dist = abs(points[p.point][0] - points[neig][0]) +
                           abs(points[p.point][1] - points[neig][1]);
                pq.push(Pair(neig, dist));
            }
        }

        return ans;
    }
};
