class Solution {
public:
    unordered_map<string, priority_queue<string, vector<string>, greater<string>>> adj;
    vector<string> ans;

    void dfs(string dest) {
        auto &pq = adj[dest];
        while (!pq.empty()) {
            string next = pq.top();
            pq.pop();
            dfs(next);
        }
        ans.insert(ans.begin(), dest); // insert at front
    }

    vector<string> findItinerary(vector<vector<string>>& tickets) {
        for (auto &t : tickets) {
            adj[t[0]].push(t[1]);
        }

        dfs("JFK");
        return ans;
    }
};
