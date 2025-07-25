class Solution {
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> hm, int ele, boolean[] visited, boolean[] res){
        if(visited[ele]) return res[ele];
        // if(hs.contains(ele)) return false;
        // hs.add()
        visited[ele] = true;
        boolean ans = true;
        ArrayList<Integer> arr = hm.get(ele);
        if(arr.size() != 0){
            for(int nb : arr){
                ans = ans && dfs(hm, nb, visited, res);
            }
        }
        res[ele] = ans;
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] res = new boolean[n];
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            int m = graph[i].length;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++){
                temp.add(graph[i][j]);
            }
            hm.put(i, temp);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(hm, i, visited, res);
            }
            if(res[i]) arr.add(i);
        }

        return arr;
    }
}