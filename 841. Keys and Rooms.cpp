class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> visited(n, false);
        queue<int> q;

        for (int key : rooms[0]) q.push(key);
        visited[0] = true;

        while (!q.empty()) {
            int room = q.front();
            q.pop();

            if (visited[room]) continue;
            visited[room] = true;

            for (int key : rooms[room]) {
                q.push(key);
            }
        }

        for (bool v : visited) {
            if (!v) return false;
        }

        return true;
    }
};
