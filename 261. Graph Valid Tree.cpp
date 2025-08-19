class Solution {
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> hm, int parent, int curr, boolean[] visited){
        if(visited[curr]) return false;
        visited[curr] = true;

        if(!hm.containsKey(curr)) return false;
        for(int child : hm.get(curr)){
            if(parent == child) continue;
            if(!dfs(hm, curr, child, visited)) return false;
        }    

        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i < edges.length; i++){
            // if(hm.containsKey(edges[i][0])) hm.get(edges[i][0]).add(edges[i][1]);
            // else{
            //     ArrayList<>() temp = new ArrayList<>();
            //     temp.add(edges[i][1]);
            //     hm.put(edges[i][0], temp);
            // }
            hm.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            hm.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        if(hm.size() == 0) return true;
        
        boolean[] visited = new boolean[n];
        if(!dfs(hm, -1, 0, visited)) return false;

        for(boolean edge : visited) if(!edge) return false;
        
        return true;
    }
}
