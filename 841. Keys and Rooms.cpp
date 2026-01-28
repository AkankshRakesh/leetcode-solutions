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
class Solution {
    public void dfs(List<List<Integer>> rooms, boolean[] visited, int index){
        visited[index] = true;

        for(int room : rooms.get(index)){
            if(!visited[room]) dfs(rooms, visited, room);        
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms, visited, 0);

        for(boolean val : visited) if(!val) return false;
        return true;
    }
}