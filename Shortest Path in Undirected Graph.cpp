#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    vector<int> shortestPath(vector<vector<int>>& adj, int src) {
        int n = adj.size();
        vector<int> res(n, -1);
        queue<int> q;

        res[src] = 0;
        q.push(src);

        while (!q.empty()) {
            int top = q.front();
            q.pop();

            for (int nb : adj[top]) {
                if (res[nb] == -1) {
                    res[nb] = res[top] + 1;
                    q.push(nb);
                }
            }
        }

        return res;
    }
};
