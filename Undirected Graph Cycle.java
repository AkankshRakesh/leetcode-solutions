class Solution {
    public boolean dfs(int ele, int parent,HashMap<Integer, ArrayList<Integer>> adj, boolean[] visited){
        visited[ele] = true;
        
        if(adj.containsKey(ele)){
            ArrayList<Integer> nbList = adj.get(ele);
            if(nbList.size() == 0) return false;
            
            for(int nb: nbList){
                if (!visited[nb]) {
            if (dfs(nb, ele, adj, visited)) return true;
            } else if (nb != parent) {
                return true;
            }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        int E = edges.length;
        for(int i = 0; i < E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(adj.containsKey(u)){
                adj.get(u).add(v);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(v);
                adj.put(u, temp);
            }
            if(adj.containsKey(v)){
                adj.get(v).add(u);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(u);
                adj.put(v, temp);
            }
        }
        
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                boolean temp = dfs(i,i, adj, visited);
                if(temp) return true;
            }
        }
        
        return false;
    }
}