class Solution {
public:

    int bfs(int dest, unordered_map<int, vector<int>> adj){
        unordered_map<int, bool> visited;
        queue<int> q;
        q.push(0);
        vector<int> dist(dest + 1, 0);
        dist[0] = 0;
        visited[0] = true;
        while(!q.empty()){
            int node = q.front();
            q.pop();

            for(int i : adj[node]){
                if(!visited[i]){
                    visited[i] = true;
                    dist[i] = dist[node] + 1;
                    if(i == dest) break;
                    q.push(i);
                }
            }
        }
        return dist[dest];
    }
    vector<int> shortestDistanceAfterQueries(int n, vector<vector<int>>& queries) {
        unordered_map<int, vector<int>> adj;
        for(int i = 0; i < n - 1; i++){
            adj[i].push_back(i + 1);
        }
        vector<int> ans;
        
        for(int i = 0; i < queries.size(); i++){
            int u = queries[i][0], v = queries[i][1];
            adj[u].push_back(v);
            int val = bfs( n - 1,adj);
            ans.push_back(val);
        }
        return ans;
    }
};