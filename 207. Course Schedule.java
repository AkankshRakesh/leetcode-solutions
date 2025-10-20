class Solution {
    public void dfs(HashMap<Integer, ArrayList<Integer>> adj, int vertex, boolean[] visited, ArrayList<Integer> ans){
        visited[vertex] = true;

        for(int neig : adj.get(vertex)){
            if(!visited[neig]){
                dfs(adj, neig, visited, ans);
            }
        }

        ans.add(vertex);
    }
    public boolean canFinish(int numCourses, int[][] prereq) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());
        for(int[] arr : prereq){
            int u = arr[1];
            int v = arr[0];
            adj.get(u).add(v);
        }  
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]) dfs(adj, i, visited, ans);
        }
        
        Collections.reverse(ans);
        HashMap<Integer, Integer> hr = new HashMap<>();
        int ind = 0;
        for(int v : ans) hr.put(v, ind++);

        for(int[] arr: prereq){
            int u = arr[1];
            int v = arr[0];
            if(hr.get(v) <= hr.get(u)) return false;
        }
        return true;
    }
}