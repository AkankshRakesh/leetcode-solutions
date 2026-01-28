class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        for(int ele : rooms.get(0)) q.offer(ele);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        while(!q.isEmpty()){
            int top = q.poll();
            if(visited[top]) continue;
            visited[top] = true;
            for(int ele : rooms.get(top)) q.offer(ele);
        }

        for(boolean door: visited) if(!door) return false;

        return true;
    }
}
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